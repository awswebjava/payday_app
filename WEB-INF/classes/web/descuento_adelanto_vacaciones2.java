package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class descuento_adelanto_vacaciones2 extends GXProcedure
{
   public descuento_adelanto_vacaciones2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( descuento_adelanto_vacaciones2.class ), "" );
   }

   public descuento_adelanto_vacaciones2( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           java.util.Date aP4 ,
                           String aP5 ,
                           String aP6 ,
                           boolean aP7 ,
                           java.math.BigDecimal[] aP8 ,
                           java.math.BigDecimal[] aP9 ,
                           String[] aP10 ,
                           String[] aP11 )
   {
      descuento_adelanto_vacaciones2.this.aP12 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        String aP6 ,
                        boolean aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 ,
                        byte[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 ,
                             byte[] aP12 )
   {
      descuento_adelanto_vacaciones2.this.AV20CliCod = aP0;
      descuento_adelanto_vacaciones2.this.AV23EmpCod = aP1;
      descuento_adelanto_vacaciones2.this.AV28LegNumero = aP2;
      descuento_adelanto_vacaciones2.this.AV30liqnro = aP3;
      descuento_adelanto_vacaciones2.this.AV31LiqPeriodo = aP4;
      descuento_adelanto_vacaciones2.this.AV21ConCodigo = aP5;
      descuento_adelanto_vacaciones2.this.AV42ProcesoLiquidacion = aP6;
      descuento_adelanto_vacaciones2.this.AV41insertandoConceptos = aP7;
      descuento_adelanto_vacaciones2.this.aP8 = aP8;
      descuento_adelanto_vacaciones2.this.aP9 = aP9;
      descuento_adelanto_vacaciones2.this.aP10 = aP10;
      descuento_adelanto_vacaciones2.this.aP11 = aP11;
      descuento_adelanto_vacaciones2.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV29LiqDCalculado = (byte)(1) ;
      GXv_int1[0] = AV26LegClase ;
      new web.getlegajoclase(remoteHandle, context).execute( AV20CliCod, AV23EmpCod, AV28LegNumero, GXv_int1) ;
      descuento_adelanto_vacaciones2.this.AV26LegClase = GXv_int1[0] ;
      GXv_char2[0] = AV33SubTipoConCod1 ;
      GXv_char3[0] = "" ;
      new web.conceptogetsubtipos(remoteHandle, context).execute( AV20CliCod, AV21ConCodigo, GXv_char2, GXv_char3) ;
      descuento_adelanto_vacaciones2.this.AV33SubTipoConCod1 = GXv_char2[0] ;
      GXv_char3[0] = AV36TipoConCod ;
      new web.conceptogettipo(remoteHandle, context).execute( AV20CliCod, AV21ConCodigo, GXv_char3) ;
      descuento_adelanto_vacaciones2.this.AV36TipoConCod = GXv_char3[0] ;
      GXv_char3[0] = AV34SubTipoConDes1 ;
      new web.getdatossubtipo1(remoteHandle, context).execute( AV36TipoConCod, AV33SubTipoConCod1, GXv_char3) ;
      descuento_adelanto_vacaciones2.this.AV34SubTipoConDes1 = GXv_char3[0] ;
      if ( GXutil.strcmp(AV33SubTipoConCod1, new web.subtipovacaciones(remoteHandle, context).executeUdp( )) == 0 )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         GXt_char4 = AV43LegLicSitCodigo ;
         GXv_char3[0] = GXt_char4 ;
         new web.codigodesituacionvacaciones(remoteHandle, context).execute( AV20CliCod, GXv_char3) ;
         descuento_adelanto_vacaciones2.this.GXt_char4 = GXv_char3[0] ;
         AV43LegLicSitCodigo = GXt_char4 ;
         GXv_char3[0] = AV47TLiqCod ;
         new web.gettipoliq(remoteHandle, context).execute( AV20CliCod, AV23EmpCod, AV30liqnro, GXv_char3) ;
         descuento_adelanto_vacaciones2.this.AV47TLiqCod = GXv_char3[0] ;
         GXv_date5[0] = AV48iniPeriodo ;
         GXv_date6[0] = AV46finPeriodo ;
         new web.getrangoperiodos(remoteHandle, context).execute( AV20CliCod, AV23EmpCod, AV30liqnro, AV28LegNumero, AV47TLiqCod, AV26LegClase, AV31LiqPeriodo, false, GXv_date5, GXv_date6) ;
         descuento_adelanto_vacaciones2.this.AV48iniPeriodo = GXv_date5[0] ;
         descuento_adelanto_vacaciones2.this.AV46finPeriodo = GXv_date6[0] ;
         GXv_char3[0] = "" ;
         GXv_int7[0] = AV27LegLicCntDias ;
         GXv_date6[0] = AV22date ;
         GXv_date5[0] = AV22date ;
         GXv_date8[0] = AV22date ;
         GXv_decimal9[0] = DecimalUtil.doubleToDec(0) ;
         GXv_boolean10[0] = false ;
         GXv_char2[0] = "" ;
         new web.legajodevuelvelicencia2(remoteHandle, context).execute( AV20CliCod, AV23EmpCod, AV28LegNumero, AV30liqnro, true, AV48iniPeriodo, true, AV46finPeriodo, AV43LegLicSitCodigo, false, false, false, GXv_char3, GXv_int7, GXv_date6, GXv_date5, GXv_date8, GXv_decimal9, GXv_boolean10, GXv_char2) ;
         descuento_adelanto_vacaciones2.this.AV27LegLicCntDias = GXv_int7[0] ;
         descuento_adelanto_vacaciones2.this.AV22date = GXv_date6[0] ;
         descuento_adelanto_vacaciones2.this.AV22date = GXv_date5[0] ;
         descuento_adelanto_vacaciones2.this.AV22date = GXv_date8[0] ;
         if ( AV27LegLicCntDias == 0 )
         {
            AV29LiqDCalculado = (byte)(0) ;
            AV8error = httpContext.getMessage( "No existe licencia \"Vacaciones\" cargada en novedad evento", "") ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      GXv_char3[0] = AV49ConCondCodigo ;
      new web.getcondicioncodigo(remoteHandle, context).execute( AV20CliCod, AV21ConCodigo, GXv_char3) ;
      descuento_adelanto_vacaciones2.this.AV49ConCondCodigo = GXv_char3[0] ;
      if ( GXutil.strcmp(AV33SubTipoConCod1, new web.subtipoanticipodesueldo(remoteHandle, context).executeUdp( )) == 0 )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         AV50mesAnterior = true ;
      }
      else
      {
         AV50mesAnterior = false ;
      }
      GXv_decimal9[0] = AV12adelantosVacLiqDImpCalcu ;
      GXv_decimal11[0] = AV11adelantosVacLiqDCanti ;
      GXv_char3[0] = AV14adelvacError ;
      GXv_int1[0] = AV15adelVacLiqDCalculado ;
      GXv_char2[0] = AV40subtipo2Encontrado ;
      GXv_int12[0] = AV16antLiqNro ;
      GXv_char13[0] = AV44encontradoConCodigo ;
      new web.getadelantoanterior(remoteHandle, context).execute( AV20CliCod, AV23EmpCod, AV28LegNumero, AV31LiqPeriodo, AV30liqnro, AV33SubTipoConCod1, "", AV50mesAnterior, AV49ConCondCodigo, GXv_decimal9, GXv_decimal11, GXv_char3, GXv_int1, GXv_char2, GXv_int12, GXv_char13) ;
      descuento_adelanto_vacaciones2.this.AV12adelantosVacLiqDImpCalcu = GXv_decimal9[0] ;
      descuento_adelanto_vacaciones2.this.AV11adelantosVacLiqDCanti = GXv_decimal11[0] ;
      descuento_adelanto_vacaciones2.this.AV14adelvacError = GXv_char3[0] ;
      descuento_adelanto_vacaciones2.this.AV15adelVacLiqDCalculado = GXv_int1[0] ;
      descuento_adelanto_vacaciones2.this.AV40subtipo2Encontrado = GXv_char2[0] ;
      descuento_adelanto_vacaciones2.this.AV16antLiqNro = GXv_int12[0] ;
      descuento_adelanto_vacaciones2.this.AV44encontradoConCodigo = GXv_char13[0] ;
      AV25Importes = AV12adelantosVacLiqDImpCalcu.multiply(DecimalUtil.doubleToDec(-1)) ;
      AV9LiqDLog = httpContext.getMessage( "Se asigna mismo valor que adelanto en negativo. Se asigna cantidad ", "") + GXutil.trim( GXutil.str( AV11adelantosVacLiqDCanti, 14, 2)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = descuento_adelanto_vacaciones2.this.AV25Importes;
      this.aP9[0] = descuento_adelanto_vacaciones2.this.AV11adelantosVacLiqDCanti;
      this.aP10[0] = descuento_adelanto_vacaciones2.this.AV8error;
      this.aP11[0] = descuento_adelanto_vacaciones2.this.AV9LiqDLog;
      this.aP12[0] = descuento_adelanto_vacaciones2.this.AV29LiqDCalculado;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV25Importes = DecimalUtil.ZERO ;
      AV11adelantosVacLiqDCanti = DecimalUtil.ZERO ;
      AV8error = "" ;
      AV9LiqDLog = "" ;
      AV33SubTipoConCod1 = "" ;
      AV36TipoConCod = "" ;
      AV34SubTipoConDes1 = "" ;
      AV43LegLicSitCodigo = "" ;
      GXt_char4 = "" ;
      AV47TLiqCod = "" ;
      AV48iniPeriodo = GXutil.nullDate() ;
      AV46finPeriodo = GXutil.nullDate() ;
      GXv_int7 = new short[1] ;
      AV22date = GXutil.nullDate() ;
      GXv_date6 = new java.util.Date[1] ;
      GXv_date5 = new java.util.Date[1] ;
      GXv_date8 = new java.util.Date[1] ;
      GXv_boolean10 = new boolean[1] ;
      AV49ConCondCodigo = "" ;
      AV12adelantosVacLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal9 = new java.math.BigDecimal[1] ;
      GXv_decimal11 = new java.math.BigDecimal[1] ;
      AV14adelvacError = "" ;
      GXv_char3 = new String[1] ;
      GXv_int1 = new byte[1] ;
      AV40subtipo2Encontrado = "" ;
      GXv_char2 = new String[1] ;
      GXv_int12 = new int[1] ;
      AV44encontradoConCodigo = "" ;
      GXv_char13 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV29LiqDCalculado ;
   private byte AV26LegClase ;
   private byte AV15adelVacLiqDCalculado ;
   private byte GXv_int1[] ;
   private short AV23EmpCod ;
   private short AV27LegLicCntDias ;
   private short GXv_int7[] ;
   private short Gx_err ;
   private int AV20CliCod ;
   private int AV28LegNumero ;
   private int AV30liqnro ;
   private int AV16antLiqNro ;
   private int GXv_int12[] ;
   private java.math.BigDecimal AV25Importes ;
   private java.math.BigDecimal AV11adelantosVacLiqDCanti ;
   private java.math.BigDecimal AV12adelantosVacLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal9[] ;
   private java.math.BigDecimal GXv_decimal11[] ;
   private String AV21ConCodigo ;
   private String AV42ProcesoLiquidacion ;
   private String AV33SubTipoConCod1 ;
   private String AV36TipoConCod ;
   private String AV43LegLicSitCodigo ;
   private String GXt_char4 ;
   private String AV47TLiqCod ;
   private String AV49ConCondCodigo ;
   private String GXv_char3[] ;
   private String AV40subtipo2Encontrado ;
   private String GXv_char2[] ;
   private String AV44encontradoConCodigo ;
   private String GXv_char13[] ;
   private java.util.Date AV31LiqPeriodo ;
   private java.util.Date AV48iniPeriodo ;
   private java.util.Date AV46finPeriodo ;
   private java.util.Date AV22date ;
   private java.util.Date GXv_date6[] ;
   private java.util.Date GXv_date5[] ;
   private java.util.Date GXv_date8[] ;
   private boolean AV41insertandoConceptos ;
   private boolean Cond_result ;
   private boolean GXv_boolean10[] ;
   private boolean returnInSub ;
   private boolean AV50mesAnterior ;
   private String AV9LiqDLog ;
   private String AV8error ;
   private String AV34SubTipoConDes1 ;
   private String AV14adelvacError ;
   private byte[] aP12 ;
   private java.math.BigDecimal[] aP8 ;
   private java.math.BigDecimal[] aP9 ;
   private String[] aP10 ;
   private String[] aP11 ;
}

