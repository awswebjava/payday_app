package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gethorasdiaparavacacionesjornal extends GXProcedure
{
   public gethorasdiaparavacacionesjornal( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gethorasdiaparavacacionesjornal.class ), "" );
   }

   public gethorasdiaparavacacionesjornal( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           java.math.BigDecimal aP3 )
   {
      gethorasdiaparavacacionesjornal.this.aP4 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.math.BigDecimal aP3 ,
                        java.math.BigDecimal[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.math.BigDecimal aP3 ,
                             java.math.BigDecimal[] aP4 )
   {
      gethorasdiaparavacacionesjornal.this.AV11CliCod = aP0;
      gethorasdiaparavacacionesjornal.this.AV10EmpCod = aP1;
      gethorasdiaparavacacionesjornal.this.AV9LegNumero = aP2;
      gethorasdiaparavacacionesjornal.this.AV25AgeCanti = aP3;
      gethorasdiaparavacacionesjornal.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV24parmvalue ;
      new web.getparametro(remoteHandle, context).execute( AV11CliCod, new web.horas_default_feriado_param(remoteHandle, context).executeUdp( ), GXv_char1) ;
      gethorasdiaparavacacionesjornal.this.AV24parmvalue = GXv_char1[0] ;
      AV12horasJornadaHabitual = CommonUtil.decimalVal( AV24parmvalue, ".") ;
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV12horasJornadaHabitual)==0) )
      {
         GXv_int2[0] = AV14PaiCod ;
         new web.clientegetpais(remoteHandle, context).execute( AV11CliCod, GXv_int2) ;
         gethorasdiaparavacacionesjornal.this.AV14PaiCod = GXv_int2[0] ;
         GXt_decimal3 = AV12horasJornadaHabitual ;
         GXv_decimal4[0] = GXt_decimal3 ;
         new web.getpaidiahornormales(remoteHandle, context).execute( AV14PaiCod, "diurno", GXv_decimal4) ;
         gethorasdiaparavacacionesjornal.this.GXt_decimal3 = GXv_decimal4[0] ;
         AV12horasJornadaHabitual = GXt_decimal3 ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV29Pgmname, httpContext.getMessage( "&horasJornadaHabitual ", "")+GXutil.trim( GXutil.str( AV12horasJornadaHabitual, 3, 1))) ;
         AV8LegHorasDia = (short)(DecimalUtil.decToDouble(AV25AgeCanti)) ;
         GXv_decimal4[0] = DecimalUtil.doubleToDec(AV23limiteDiasCalcuJorVac) ;
         new web.getpaimaxhornor(remoteHandle, context).execute( AV14PaiCod, GXv_decimal4) ;
         gethorasdiaparavacacionesjornal.this.AV23limiteDiasCalcuJorVac = (short)(DecimalUtil.decToDouble(GXv_decimal4[0])) ;
         if ( (0==AV8LegHorasDia) )
         {
            AV8LegHorasDia = (short)(DecimalUtil.decToDouble(AV12horasJornadaHabitual)) ;
         }
         if ( AV8LegHorasDia >= AV23limiteDiasCalcuJorVac )
         {
            AV12horasJornadaHabitual = DecimalUtil.doubleToDec(AV23limiteDiasCalcuJorVac) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = gethorasdiaparavacacionesjornal.this.AV12horasJornadaHabitual;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12horasJornadaHabitual = DecimalUtil.ZERO ;
      AV24parmvalue = "" ;
      GXv_char1 = new String[1] ;
      GXv_int2 = new short[1] ;
      GXt_decimal3 = DecimalUtil.ZERO ;
      AV29Pgmname = "" ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      AV29Pgmname = "getHorasDiaParaVacacionesJornal" ;
      /* GeneXus formulas. */
      AV29Pgmname = "getHorasDiaParaVacacionesJornal" ;
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short AV14PaiCod ;
   private short GXv_int2[] ;
   private short AV8LegHorasDia ;
   private short AV23limiteDiasCalcuJorVac ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LegNumero ;
   private java.math.BigDecimal AV25AgeCanti ;
   private java.math.BigDecimal AV12horasJornadaHabitual ;
   private java.math.BigDecimal GXt_decimal3 ;
   private java.math.BigDecimal GXv_decimal4[] ;
   private String GXv_char1[] ;
   private String AV29Pgmname ;
   private String AV24parmvalue ;
   private java.math.BigDecimal[] aP4 ;
}

