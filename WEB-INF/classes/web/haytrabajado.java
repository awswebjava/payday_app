package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class haytrabajado extends GXProcedure
{
   public haytrabajado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( haytrabajado.class ), "" );
   }

   public haytrabajado( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              java.util.Date aP4 ,
                              byte aP5 ,
                              String aP6 ,
                              String aP7 )
   {
      haytrabajado.this.aP8 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        byte aP5 ,
                        String aP6 ,
                        String aP7 ,
                        boolean[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             byte aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean[] aP8 )
   {
      haytrabajado.this.AV9CliCod = aP0;
      haytrabajado.this.AV10EmpCod = aP1;
      haytrabajado.this.AV12LegNumero = aP2;
      haytrabajado.this.AV11LiqNro = aP3;
      haytrabajado.this.AV17LiqPeriodo = aP4;
      haytrabajado.this.AV8LegClase = aP5;
      haytrabajado.this.AV24tipo_tarifa = aP6;
      haytrabajado.this.AV16TLiqCod = aP7;
      haytrabajado.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15trabajadoHay = true ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "hola &LegClase  ", "")+GXutil.trim( GXutil.str( AV8LegClase, 1, 0))) ;
      if ( GXutil.strcmp(AV24tipo_tarifa, "H") == 0 )
      {
         GXv_char1[0] = AV13auxConCodigo ;
         new web.getparametro(remoteHandle, context).execute( AV9CliCod, new web.concepto_sueldojornal_codigoparam(remoteHandle, context).executeUdp( ), GXv_char1) ;
         haytrabajado.this.AV13auxConCodigo = GXv_char1[0] ;
         GXv_decimal2[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean3[0] = AV14existe ;
         GXv_int4[0] = (byte)(0) ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LegNumero, AV13auxConCodigo, "Calculo", false, GXv_decimal2, GXv_boolean3, GXv_int4) ;
         haytrabajado.this.AV14existe = GXv_boolean3[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV27Pgmname, httpContext.getMessage( "&auxConCodigo ", "")+GXutil.trim( AV13auxConCodigo)+httpContext.getMessage( " &existe ", "")+GXutil.trim( GXutil.booltostr( AV14existe))+httpContext.getMessage( " clicod ", "")+GXutil.trim( GXutil.str( AV9CliCod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV10EmpCod, 4, 0))+httpContext.getMessage( " leg ", "")+GXutil.trim( GXutil.str( AV12LegNumero, 8, 0))+httpContext.getMessage( " &liqnro ", "")+GXutil.trim( GXutil.str( AV11LiqNro, 8, 0))) ;
         if ( ! AV14existe )
         {
            AV15trabajadoHay = false ;
         }
      }
      else
      {
         GXv_date5[0] = AV18iniPeriodo ;
         GXv_date6[0] = AV19finPeriodo ;
         new web.getrangoperiodos(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LiqNro, AV12LegNumero, AV16TLiqCod, AV8LegClase, AV17LiqPeriodo, false, GXv_date5, GXv_date6) ;
         haytrabajado.this.AV18iniPeriodo = GXv_date5[0] ;
         haytrabajado.this.AV19finPeriodo = GXv_date6[0] ;
         GXv_char1[0] = "" ;
         GXv_int7[0] = AV21LegLicCntDias ;
         GXv_date6[0] = AV20date ;
         GXv_date5[0] = AV20date ;
         GXv_date8[0] = AV20date ;
         GXv_decimal2[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean3[0] = false ;
         GXv_char9[0] = "" ;
         new web.legajodevuelvelicencia2(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV12LegNumero, AV11LiqNro, false, AV18iniPeriodo, true, AV19finPeriodo, "", false, false, false, GXv_char1, GXv_int7, GXv_date6, GXv_date5, GXv_date8, GXv_decimal2, GXv_boolean3, GXv_char9) ;
         haytrabajado.this.AV21LegLicCntDias = GXv_int7[0] ;
         haytrabajado.this.AV20date = GXv_date6[0] ;
         haytrabajado.this.AV20date = GXv_date5[0] ;
         haytrabajado.this.AV20date = GXv_date8[0] ;
         if ( AV21LegLicCntDias > 0 )
         {
            GXv_int7[0] = AV22mes_dias ;
            new web.diasmes(remoteHandle, context).execute( AV9CliCod, AV17LiqPeriodo, GXv_int7) ;
            haytrabajado.this.AV22mes_dias = GXv_int7[0] ;
            if ( AV21LegLicCntDias >= AV22mes_dias )
            {
               AV15trabajadoHay = false ;
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = haytrabajado.this.AV15trabajadoHay;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV27Pgmname = "" ;
      AV13auxConCodigo = "" ;
      GXv_int4 = new byte[1] ;
      AV18iniPeriodo = GXutil.nullDate() ;
      AV19finPeriodo = GXutil.nullDate() ;
      GXv_char1 = new String[1] ;
      AV20date = GXutil.nullDate() ;
      GXv_date6 = new java.util.Date[1] ;
      GXv_date5 = new java.util.Date[1] ;
      GXv_date8 = new java.util.Date[1] ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      GXv_boolean3 = new boolean[1] ;
      GXv_char9 = new String[1] ;
      GXv_int7 = new short[1] ;
      AV27Pgmname = "hayTrabajado" ;
      /* GeneXus formulas. */
      AV27Pgmname = "hayTrabajado" ;
      Gx_err = (short)(0) ;
   }

   private byte AV8LegClase ;
   private byte GXv_int4[] ;
   private short AV10EmpCod ;
   private short AV21LegLicCntDias ;
   private short AV22mes_dias ;
   private short GXv_int7[] ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV12LegNumero ;
   private int AV11LiqNro ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private String AV24tipo_tarifa ;
   private String AV16TLiqCod ;
   private String AV27Pgmname ;
   private String AV13auxConCodigo ;
   private String GXv_char1[] ;
   private String GXv_char9[] ;
   private java.util.Date AV17LiqPeriodo ;
   private java.util.Date AV18iniPeriodo ;
   private java.util.Date AV19finPeriodo ;
   private java.util.Date AV20date ;
   private java.util.Date GXv_date6[] ;
   private java.util.Date GXv_date5[] ;
   private java.util.Date GXv_date8[] ;
   private boolean AV15trabajadoHay ;
   private boolean AV14existe ;
   private boolean GXv_boolean3[] ;
   private boolean[] aP8 ;
}

