package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class valordia extends GXProcedure
{
   public valordia( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( valordia.class ), "" );
   }

   public valordia( int remoteHandle ,
                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           int aP3 ,
                                           java.util.Date aP4 ,
                                           boolean aP5 ,
                                           String[] aP6 )
   {
      valordia.this.aP7 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        boolean aP5 ,
                        String[] aP6 ,
                        java.math.BigDecimal[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             boolean aP5 ,
                             String[] aP6 ,
                             java.math.BigDecimal[] aP7 )
   {
      valordia.this.AV8CliCod = aP0;
      valordia.this.AV9EmpCod = aP1;
      valordia.this.AV16LiqNro = aP2;
      valordia.this.AV10LegNumero = aP3;
      valordia.this.AV11LiqPeriodo = aP4;
      valordia.this.AV22mesComo25Dias = aP5;
      valordia.this.aP6 = aP6;
      valordia.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV26tipo_tarifa ;
      new web.gettipodetarifa(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV16LiqNro, AV10LegNumero, (short)(0), "", "", GXv_char1) ;
      valordia.this.AV26tipo_tarifa = GXv_char1[0] ;
      if ( GXutil.strcmp(AV26tipo_tarifa, "H") == 0 )
      {
         GXv_char1[0] = AV23error ;
         GXv_decimal2[0] = AV12valorHora ;
         new web.obtbasicovalorhora(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV16LiqNro, AV10LegNumero, AV11LiqPeriodo, httpContext.getMessage( "TOTAL", ""), GXv_char1, GXv_decimal2) ;
         valordia.this.AV23error = GXv_char1[0] ;
         valordia.this.AV12valorHora = GXv_decimal2[0] ;
         if ( ! (GXutil.strcmp("", AV23error)==0) )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXv_decimal2[0] = DecimalUtil.doubleToDec(AV14horasDia) ;
         new web.gethorasdianormal(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, GXv_decimal2) ;
         valordia.this.AV14horasDia = (short)(DecimalUtil.decToDouble(GXv_decimal2[0])) ;
         AV18valorDia = AV12valorHora.multiply(DecimalUtil.doubleToDec(AV14horasDia)) ;
      }
      else
      {
         GXv_char1[0] = AV23error ;
         GXv_decimal2[0] = AV17Sueldo ;
         GXv_char3[0] = AV24LegSuelTipo ;
         GXv_char4[0] = "" ;
         new web.obtsueldobasicomensual(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, AV16LiqNro, AV11LiqPeriodo, DecimalUtil.doubleToDec(0), httpContext.getMessage( "TOTAL", ""), GXv_char1, GXv_decimal2, GXv_char3, GXv_char4) ;
         valordia.this.AV23error = GXv_char1[0] ;
         valordia.this.AV17Sueldo = GXv_decimal2[0] ;
         valordia.this.AV24LegSuelTipo = GXv_char3[0] ;
         if ( ! (GXutil.strcmp("", AV23error)==0) )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( AV22mesComo25Dias )
         {
            AV19diasMes = (byte)(25) ;
         }
         else
         {
            GXv_int5[0] = AV19diasMes ;
            new web.diasmes(remoteHandle, context).execute( AV8CliCod, AV11LiqPeriodo, GXv_int5) ;
            valordia.this.AV19diasMes = (byte)((byte)(GXv_int5[0])) ;
         }
         AV18valorDia = AV17Sueldo.divide(DecimalUtil.doubleToDec(AV19diasMes), 18, java.math.RoundingMode.DOWN) ;
      }
      AV21OrigvalorDia = AV18valorDia ;
      GXv_decimal2[0] = AV18valorDia ;
      GXv_decimal6[0] = DecimalUtil.doubleToDec(0) ;
      GXv_decimal7[0] = DecimalUtil.doubleToDec(0) ;
      new web.reducirporparcial(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, AV11LiqPeriodo, AV21OrigvalorDia, GXv_decimal2, GXv_decimal6, GXv_decimal7) ;
      valordia.this.AV18valorDia = GXv_decimal2[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = valordia.this.AV23error;
      this.aP7[0] = valordia.this.AV18valorDia;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV23error = "" ;
      AV18valorDia = DecimalUtil.ZERO ;
      AV26tipo_tarifa = "" ;
      AV12valorHora = DecimalUtil.ZERO ;
      GXv_char1 = new String[1] ;
      AV17Sueldo = DecimalUtil.ZERO ;
      AV24LegSuelTipo = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      GXv_int5 = new short[1] ;
      AV21OrigvalorDia = DecimalUtil.ZERO ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV19diasMes ;
   private short AV9EmpCod ;
   private short AV14horasDia ;
   private short GXv_int5[] ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV16LiqNro ;
   private int AV10LegNumero ;
   private java.math.BigDecimal AV18valorDia ;
   private java.math.BigDecimal AV12valorHora ;
   private java.math.BigDecimal AV17Sueldo ;
   private java.math.BigDecimal AV21OrigvalorDia ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private String AV26tipo_tarifa ;
   private String GXv_char1[] ;
   private String AV24LegSuelTipo ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private java.util.Date AV11LiqPeriodo ;
   private boolean AV22mesComo25Dias ;
   private boolean returnInSub ;
   private String AV23error ;
   private java.math.BigDecimal[] aP7 ;
   private String[] aP6 ;
}

