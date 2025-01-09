package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getdatoslegajorecibo extends GXProcedure
{
   public getdatoslegajorecibo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getdatoslegajorecibo.class ), "" );
   }

   public getdatoslegajorecibo( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 ,
                             java.util.Date[] aP11 ,
                             String[] aP12 ,
                             String[] aP13 ,
                             long[] aP14 ,
                             java.math.BigDecimal[] aP15 ,
                             String[] aP16 )
   {
      getdatoslegajorecibo.this.aP17 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17);
      return aP17[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String[] aP4 ,
                        String[] aP5 ,
                        String[] aP6 ,
                        String[] aP7 ,
                        String[] aP8 ,
                        String[] aP9 ,
                        String[] aP10 ,
                        java.util.Date[] aP11 ,
                        String[] aP12 ,
                        String[] aP13 ,
                        long[] aP14 ,
                        java.math.BigDecimal[] aP15 ,
                        String[] aP16 ,
                        String[] aP17 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String[] aP4 ,
                             String[] aP5 ,
                             String[] aP6 ,
                             String[] aP7 ,
                             String[] aP8 ,
                             String[] aP9 ,
                             String[] aP10 ,
                             java.util.Date[] aP11 ,
                             String[] aP12 ,
                             String[] aP13 ,
                             long[] aP14 ,
                             java.math.BigDecimal[] aP15 ,
                             String[] aP16 ,
                             String[] aP17 )
   {
      getdatoslegajorecibo.this.AV12CliCod = aP0;
      getdatoslegajorecibo.this.AV13empcod = aP1;
      getdatoslegajorecibo.this.AV18LegNumero = aP2;
      getdatoslegajorecibo.this.AV26LiqNro = aP3;
      getdatoslegajorecibo.this.aP4 = aP4;
      getdatoslegajorecibo.this.aP5 = aP5;
      getdatoslegajorecibo.this.aP6 = aP6;
      getdatoslegajorecibo.this.aP7 = aP7;
      getdatoslegajorecibo.this.aP8 = aP8;
      getdatoslegajorecibo.this.aP9 = aP9;
      getdatoslegajorecibo.this.aP10 = aP10;
      getdatoslegajorecibo.this.aP11 = aP11;
      getdatoslegajorecibo.this.aP12 = aP12;
      getdatoslegajorecibo.this.aP13 = aP13;
      getdatoslegajorecibo.this.aP14 = aP14;
      getdatoslegajorecibo.this.aP15 = aP15;
      getdatoslegajorecibo.this.aP16 = aP16;
      getdatoslegajorecibo.this.aP17 = aP17;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00KS2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV13empcod), Integer.valueOf(AV18LegNumero)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1582LegBanCod = P00KS2_A1582LegBanCod[0] ;
         n1582LegBanCod = P00KS2_n1582LegBanCod[0] ;
         A1580LegOsoCod = P00KS2_A1580LegOsoCod[0] ;
         n1580LegOsoCod = P00KS2_n1580LegOsoCod[0] ;
         A20ZonCod = P00KS2_A20ZonCod[0] ;
         n20ZonCod = P00KS2_n20ZonCod[0] ;
         A6LegNumero = P00KS2_A6LegNumero[0] ;
         A1EmpCod = P00KS2_A1EmpCod[0] ;
         A3CliCod = P00KS2_A3CliCod[0] ;
         A392OsoSigla = P00KS2_A392OsoSigla[0] ;
         n392OsoSigla = P00KS2_n392OsoSigla[0] ;
         A2224LegBanDes = P00KS2_A2224LegBanDes[0] ;
         A937LegConveCodigo = P00KS2_A937LegConveCodigo[0] ;
         n937LegConveCodigo = P00KS2_n937LegConveCodigo[0] ;
         A939LegCatCodigo = P00KS2_A939LegCatCodigo[0] ;
         n939LegCatCodigo = P00KS2_n939LegCatCodigo[0] ;
         A1578LegPuesCodigo = P00KS2_A1578LegPuesCodigo[0] ;
         n1578LegPuesCodigo = P00KS2_n1578LegPuesCodigo[0] ;
         A1579LegSecCodigo = P00KS2_A1579LegSecCodigo[0] ;
         n1579LegSecCodigo = P00KS2_n1579LegSecCodigo[0] ;
         A234LegCBU = P00KS2_A234LegCBU[0] ;
         n234LegCBU = P00KS2_n234LegCBU[0] ;
         A239LegCUIL = P00KS2_A239LegCUIL[0] ;
         A245LegFecIngreso = P00KS2_A245LegFecIngreso[0] ;
         A93LegId = P00KS2_A93LegId[0] ;
         n93LegId = P00KS2_n93LegId[0] ;
         A232LegBanTipCuen = P00KS2_A232LegBanTipCuen[0] ;
         n232LegBanTipCuen = P00KS2_n232LegBanTipCuen[0] ;
         A238LegCuentaBanc = P00KS2_A238LegCuentaBanc[0] ;
         n238LegCuentaBanc = P00KS2_n238LegCuentaBanc[0] ;
         A251LegNombre = P00KS2_A251LegNombre[0] ;
         A230LegApellido = P00KS2_A230LegApellido[0] ;
         A589ZonProvincia = P00KS2_A589ZonProvincia[0] ;
         A235LegClase = P00KS2_A235LegClase[0] ;
         A589ZonProvincia = P00KS2_A589ZonProvincia[0] ;
         A2224LegBanDes = P00KS2_A2224LegBanDes[0] ;
         A392OsoSigla = P00KS2_A392OsoSigla[0] ;
         n392OsoSigla = P00KS2_n392OsoSigla[0] ;
         AV8OsoSigla = A392OsoSigla ;
         AV9BanDescrip = A2224LegBanDes ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, httpContext.getMessage( "LegCatCodigo ", "")+GXutil.trim( A939LegCatCodigo)+httpContext.getMessage( " LegConveCodigo ", "")+GXutil.trim( A937LegConveCodigo)) ;
         if ( ! (GXutil.strcmp("", A939LegCatCodigo)==0) && ! (GXutil.strcmp("", A937LegConveCodigo)==0) )
         {
            GXv_int1[0] = AV28CliConveVer ;
            new web.getversiondelegajo(remoteHandle, context).execute( AV12CliCod, AV13empcod, AV18LegNumero, GXv_int1) ;
            getdatoslegajorecibo.this.AV28CliConveVer = GXv_int1[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, httpContext.getMessage( "&CliConveVer ", "")+GXutil.trim( GXutil.str( AV28CliConveVer, 6, 0))) ;
            GXv_char2[0] = AV33auxCatDescrip ;
            GXv_boolean3[0] = false ;
            new web.getcategoria(remoteHandle, context).execute( AV12CliCod, AV28CliConveVer, A937LegConveCodigo, A939LegCatCodigo, GXv_char2, GXv_boolean3) ;
            getdatoslegajorecibo.this.AV33auxCatDescrip = GXv_char2[0] ;
            AV35ConveCodigo = A937LegConveCodigo ;
            GXv_char2[0] = AV34ConveDescri ;
            GXv_boolean3[0] = false ;
            new web.getconvenio(remoteHandle, context).execute( AV12CliCod, A937LegConveCodigo, GXv_char2, GXv_boolean3) ;
            getdatoslegajorecibo.this.AV34ConveDescri = GXv_char2[0] ;
            AV11CatDescrip = GXutil.trim( AV34ConveDescri) + " - " + GXutil.trim( AV33auxCatDescrip) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, httpContext.getMessage( "&CatDescrip ", "")+GXutil.trim( AV11CatDescrip)) ;
         }
         else
         {
            GXt_char4 = AV11CatDescrip ;
            GXv_char2[0] = GXt_char4 ;
            new web.textofueradeconvenio(remoteHandle, context).execute( AV12CliCod, GXv_char2) ;
            getdatoslegajorecibo.this.GXt_char4 = GXv_char2[0] ;
            AV11CatDescrip = GXt_char4 ;
            if ( ! (GXutil.strcmp("", A1578LegPuesCodigo)==0) )
            {
               GXt_char4 = AV11CatDescrip ;
               GXv_char2[0] = GXt_char4 ;
               new web.getpuesto(remoteHandle, context).execute( AV12CliCod, A1579LegSecCodigo, A1578LegPuesCodigo, GXv_char2) ;
               getdatoslegajorecibo.this.GXt_char4 = GXv_char2[0] ;
               AV11CatDescrip = GXt_char4 ;
            }
            else
            {
               GXt_char4 = AV11CatDescrip ;
               GXv_char2[0] = GXt_char4 ;
               new web.textofueradeconvenio(remoteHandle, context).execute( AV12CliCod, GXv_char2) ;
               getdatoslegajorecibo.this.GXt_char4 = GXv_char2[0] ;
               AV11CatDescrip = GXt_char4 ;
            }
         }
         AV14LegCBU = A234LegCBU ;
         AV15LegCUIL = A239LegCUIL ;
         AV16LegFecIngreso = A245LegFecIngreso ;
         AV17LegId = A93LegId ;
         AV20LegBanTipCuen = A232LegBanTipCuen ;
         AV21LegCuentaBanc = A238LegCuentaBanc ;
         AV22LiqDetLegNomApe = GXutil.trim( A230LegApellido) + ", " + GXutil.trim( A251LegNombre) ;
         AV24ZonProvincia = A589ZonProvincia ;
         AV30LegClase = A235LegClase ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      GXt_date5 = AV25LiqPeriodo ;
      GXv_date6[0] = GXt_date5 ;
      new web.getperiodoliquidacion(remoteHandle, context).execute( AV12CliCod, AV13empcod, AV26LiqNro, GXv_date6) ;
      getdatoslegajorecibo.this.GXt_date5 = GXv_date6[0] ;
      AV25LiqPeriodo = GXt_date5 ;
      GXv_char2[0] = AV29TLiqCod ;
      new web.gettipoliq(remoteHandle, context).execute( AV12CliCod, AV13empcod, AV26LiqNro, GXv_char2) ;
      getdatoslegajorecibo.this.AV29TLiqCod = GXv_char2[0] ;
      GXv_date6[0] = AV31iniPeriodo ;
      GXv_date7[0] = AV32date ;
      new web.getrangoperiodos(remoteHandle, context).execute( AV12CliCod, AV13empcod, 0, AV18LegNumero, AV29TLiqCod, AV30LegClase, AV25LiqPeriodo, false, GXv_date6, GXv_date7) ;
      getdatoslegajorecibo.this.AV31iniPeriodo = GXv_date6[0] ;
      getdatoslegajorecibo.this.AV32date = GXv_date7[0] ;
      GXv_char2[0] = "" ;
      GXv_decimal8[0] = AV19sueldo ;
      new web.obtsueldojornal(remoteHandle, context).execute( AV12CliCod, AV13empcod, AV26LiqNro, AV18LegNumero, AV31iniPeriodo, GXv_char2, GXv_decimal8) ;
      getdatoslegajorecibo.this.AV19sueldo = GXv_decimal8[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV39Pgmname, httpContext.getMessage( "iniperiodo ", "")+GXutil.trim( localUtil.dtoc( AV31iniPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " sueldo ", "")+GXutil.trim( GXutil.str( AV19sueldo, 14, 2))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getdatoslegajorecibo.this.AV8OsoSigla;
      this.aP5[0] = getdatoslegajorecibo.this.AV9BanDescrip;
      this.aP6[0] = getdatoslegajorecibo.this.AV20LegBanTipCuen;
      this.aP7[0] = getdatoslegajorecibo.this.AV21LegCuentaBanc;
      this.aP8[0] = getdatoslegajorecibo.this.AV10CarDescrip;
      this.aP9[0] = getdatoslegajorecibo.this.AV11CatDescrip;
      this.aP10[0] = getdatoslegajorecibo.this.AV14LegCBU;
      this.aP11[0] = getdatoslegajorecibo.this.AV16LegFecIngreso;
      this.aP12[0] = getdatoslegajorecibo.this.AV17LegId;
      this.aP13[0] = getdatoslegajorecibo.this.AV22LiqDetLegNomApe;
      this.aP14[0] = getdatoslegajorecibo.this.AV15LegCUIL;
      this.aP15[0] = getdatoslegajorecibo.this.AV19sueldo;
      this.aP16[0] = getdatoslegajorecibo.this.AV24ZonProvincia;
      this.aP17[0] = getdatoslegajorecibo.this.AV35ConveCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8OsoSigla = "" ;
      AV9BanDescrip = "" ;
      AV20LegBanTipCuen = "" ;
      AV21LegCuentaBanc = "" ;
      AV10CarDescrip = "" ;
      AV11CatDescrip = "" ;
      AV14LegCBU = "" ;
      AV16LegFecIngreso = GXutil.nullDate() ;
      AV17LegId = "" ;
      AV22LiqDetLegNomApe = "" ;
      AV19sueldo = DecimalUtil.ZERO ;
      AV24ZonProvincia = "" ;
      AV35ConveCodigo = "" ;
      scmdbuf = "" ;
      P00KS2_A1582LegBanCod = new String[] {""} ;
      P00KS2_n1582LegBanCod = new boolean[] {false} ;
      P00KS2_A1580LegOsoCod = new String[] {""} ;
      P00KS2_n1580LegOsoCod = new boolean[] {false} ;
      P00KS2_A20ZonCod = new String[] {""} ;
      P00KS2_n20ZonCod = new boolean[] {false} ;
      P00KS2_A6LegNumero = new int[1] ;
      P00KS2_A1EmpCod = new short[1] ;
      P00KS2_A3CliCod = new int[1] ;
      P00KS2_A392OsoSigla = new String[] {""} ;
      P00KS2_n392OsoSigla = new boolean[] {false} ;
      P00KS2_A2224LegBanDes = new String[] {""} ;
      P00KS2_A937LegConveCodigo = new String[] {""} ;
      P00KS2_n937LegConveCodigo = new boolean[] {false} ;
      P00KS2_A939LegCatCodigo = new String[] {""} ;
      P00KS2_n939LegCatCodigo = new boolean[] {false} ;
      P00KS2_A1578LegPuesCodigo = new String[] {""} ;
      P00KS2_n1578LegPuesCodigo = new boolean[] {false} ;
      P00KS2_A1579LegSecCodigo = new String[] {""} ;
      P00KS2_n1579LegSecCodigo = new boolean[] {false} ;
      P00KS2_A234LegCBU = new String[] {""} ;
      P00KS2_n234LegCBU = new boolean[] {false} ;
      P00KS2_A239LegCUIL = new long[1] ;
      P00KS2_A245LegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      P00KS2_A93LegId = new String[] {""} ;
      P00KS2_n93LegId = new boolean[] {false} ;
      P00KS2_A232LegBanTipCuen = new String[] {""} ;
      P00KS2_n232LegBanTipCuen = new boolean[] {false} ;
      P00KS2_A238LegCuentaBanc = new String[] {""} ;
      P00KS2_n238LegCuentaBanc = new boolean[] {false} ;
      P00KS2_A251LegNombre = new String[] {""} ;
      P00KS2_A230LegApellido = new String[] {""} ;
      P00KS2_A589ZonProvincia = new String[] {""} ;
      P00KS2_A235LegClase = new byte[1] ;
      A1582LegBanCod = "" ;
      A1580LegOsoCod = "" ;
      A20ZonCod = "" ;
      A392OsoSigla = "" ;
      A2224LegBanDes = "" ;
      A937LegConveCodigo = "" ;
      A939LegCatCodigo = "" ;
      A1578LegPuesCodigo = "" ;
      A1579LegSecCodigo = "" ;
      A234LegCBU = "" ;
      A245LegFecIngreso = GXutil.nullDate() ;
      A93LegId = "" ;
      A232LegBanTipCuen = "" ;
      A238LegCuentaBanc = "" ;
      A251LegNombre = "" ;
      A230LegApellido = "" ;
      A589ZonProvincia = "" ;
      AV39Pgmname = "" ;
      GXv_int1 = new int[1] ;
      AV33auxCatDescrip = "" ;
      AV34ConveDescri = "" ;
      GXv_boolean3 = new boolean[1] ;
      GXt_char4 = "" ;
      AV25LiqPeriodo = GXutil.nullDate() ;
      GXt_date5 = GXutil.nullDate() ;
      AV29TLiqCod = "" ;
      AV31iniPeriodo = GXutil.nullDate() ;
      GXv_date6 = new java.util.Date[1] ;
      AV32date = GXutil.nullDate() ;
      GXv_date7 = new java.util.Date[1] ;
      GXv_char2 = new String[1] ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getdatoslegajorecibo__default(),
         new Object[] {
             new Object[] {
            P00KS2_A1582LegBanCod, P00KS2_n1582LegBanCod, P00KS2_A1580LegOsoCod, P00KS2_n1580LegOsoCod, P00KS2_A20ZonCod, P00KS2_n20ZonCod, P00KS2_A6LegNumero, P00KS2_A1EmpCod, P00KS2_A3CliCod, P00KS2_A392OsoSigla,
            P00KS2_n392OsoSigla, P00KS2_A2224LegBanDes, P00KS2_A937LegConveCodigo, P00KS2_n937LegConveCodigo, P00KS2_A939LegCatCodigo, P00KS2_n939LegCatCodigo, P00KS2_A1578LegPuesCodigo, P00KS2_n1578LegPuesCodigo, P00KS2_A1579LegSecCodigo, P00KS2_n1579LegSecCodigo,
            P00KS2_A234LegCBU, P00KS2_n234LegCBU, P00KS2_A239LegCUIL, P00KS2_A245LegFecIngreso, P00KS2_A93LegId, P00KS2_n93LegId, P00KS2_A232LegBanTipCuen, P00KS2_n232LegBanTipCuen, P00KS2_A238LegCuentaBanc, P00KS2_n238LegCuentaBanc,
            P00KS2_A251LegNombre, P00KS2_A230LegApellido, P00KS2_A589ZonProvincia, P00KS2_A235LegClase
            }
         }
      );
      AV39Pgmname = "getDatosLegajoRecibo" ;
      /* GeneXus formulas. */
      AV39Pgmname = "getDatosLegajoRecibo" ;
      Gx_err = (short)(0) ;
   }

   private byte A235LegClase ;
   private byte AV30LegClase ;
   private short AV13empcod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV18LegNumero ;
   private int AV26LiqNro ;
   private int A6LegNumero ;
   private int A3CliCod ;
   private int AV28CliConveVer ;
   private int GXv_int1[] ;
   private long AV15LegCUIL ;
   private long A239LegCUIL ;
   private java.math.BigDecimal AV19sueldo ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private String AV8OsoSigla ;
   private String AV20LegBanTipCuen ;
   private String AV17LegId ;
   private String AV35ConveCodigo ;
   private String scmdbuf ;
   private String A1582LegBanCod ;
   private String A1580LegOsoCod ;
   private String A20ZonCod ;
   private String A392OsoSigla ;
   private String A937LegConveCodigo ;
   private String A939LegCatCodigo ;
   private String A1578LegPuesCodigo ;
   private String A1579LegSecCodigo ;
   private String A93LegId ;
   private String A232LegBanTipCuen ;
   private String AV39Pgmname ;
   private String GXt_char4 ;
   private String AV29TLiqCod ;
   private String GXv_char2[] ;
   private java.util.Date AV16LegFecIngreso ;
   private java.util.Date A245LegFecIngreso ;
   private java.util.Date AV25LiqPeriodo ;
   private java.util.Date GXt_date5 ;
   private java.util.Date AV31iniPeriodo ;
   private java.util.Date GXv_date6[] ;
   private java.util.Date AV32date ;
   private java.util.Date GXv_date7[] ;
   private boolean n1582LegBanCod ;
   private boolean n1580LegOsoCod ;
   private boolean n20ZonCod ;
   private boolean n392OsoSigla ;
   private boolean n937LegConveCodigo ;
   private boolean n939LegCatCodigo ;
   private boolean n1578LegPuesCodigo ;
   private boolean n1579LegSecCodigo ;
   private boolean n234LegCBU ;
   private boolean n93LegId ;
   private boolean n232LegBanTipCuen ;
   private boolean n238LegCuentaBanc ;
   private boolean GXv_boolean3[] ;
   private String AV9BanDescrip ;
   private String AV21LegCuentaBanc ;
   private String AV10CarDescrip ;
   private String AV11CatDescrip ;
   private String AV14LegCBU ;
   private String AV22LiqDetLegNomApe ;
   private String AV24ZonProvincia ;
   private String A2224LegBanDes ;
   private String A234LegCBU ;
   private String A238LegCuentaBanc ;
   private String A251LegNombre ;
   private String A230LegApellido ;
   private String A589ZonProvincia ;
   private String AV33auxCatDescrip ;
   private String AV34ConveDescri ;
   private String[] aP17 ;
   private String[] aP4 ;
   private String[] aP5 ;
   private String[] aP6 ;
   private String[] aP7 ;
   private String[] aP8 ;
   private String[] aP9 ;
   private String[] aP10 ;
   private java.util.Date[] aP11 ;
   private String[] aP12 ;
   private String[] aP13 ;
   private long[] aP14 ;
   private java.math.BigDecimal[] aP15 ;
   private String[] aP16 ;
   private IDataStoreProvider pr_default ;
   private String[] P00KS2_A1582LegBanCod ;
   private boolean[] P00KS2_n1582LegBanCod ;
   private String[] P00KS2_A1580LegOsoCod ;
   private boolean[] P00KS2_n1580LegOsoCod ;
   private String[] P00KS2_A20ZonCod ;
   private boolean[] P00KS2_n20ZonCod ;
   private int[] P00KS2_A6LegNumero ;
   private short[] P00KS2_A1EmpCod ;
   private int[] P00KS2_A3CliCod ;
   private String[] P00KS2_A392OsoSigla ;
   private boolean[] P00KS2_n392OsoSigla ;
   private String[] P00KS2_A2224LegBanDes ;
   private String[] P00KS2_A937LegConveCodigo ;
   private boolean[] P00KS2_n937LegConveCodigo ;
   private String[] P00KS2_A939LegCatCodigo ;
   private boolean[] P00KS2_n939LegCatCodigo ;
   private String[] P00KS2_A1578LegPuesCodigo ;
   private boolean[] P00KS2_n1578LegPuesCodigo ;
   private String[] P00KS2_A1579LegSecCodigo ;
   private boolean[] P00KS2_n1579LegSecCodigo ;
   private String[] P00KS2_A234LegCBU ;
   private boolean[] P00KS2_n234LegCBU ;
   private long[] P00KS2_A239LegCUIL ;
   private java.util.Date[] P00KS2_A245LegFecIngreso ;
   private String[] P00KS2_A93LegId ;
   private boolean[] P00KS2_n93LegId ;
   private String[] P00KS2_A232LegBanTipCuen ;
   private boolean[] P00KS2_n232LegBanTipCuen ;
   private String[] P00KS2_A238LegCuentaBanc ;
   private boolean[] P00KS2_n238LegCuentaBanc ;
   private String[] P00KS2_A251LegNombre ;
   private String[] P00KS2_A230LegApellido ;
   private String[] P00KS2_A589ZonProvincia ;
   private byte[] P00KS2_A235LegClase ;
}

final  class getdatoslegajorecibo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00KS2", "SELECT T1.LegBanCod AS LegBanCod, T1.LegOsoCod AS LegOsoCod, T1.ZonCod, T1.LegNumero, T1.EmpCod, T1.CliCod, T4.OsoSigla, T3.BanDescrip AS LegBanDes, T1.LegConveCodigo, T1.LegCatCodigo, T1.LegPuesCodigo, T1.LegSecCodigo, T1.LegCBU, T1.LegCUIL, T1.LegFecIngreso, T1.LegId, T1.LegBanTipCuen, T1.LegCuentaBanc, T1.LegNombre, T1.LegApellido, T2.ZonProvincia, T1.LegClase FROM (((Legajo T1 LEFT JOIN Zona T2 ON T2.ZonCod = T1.ZonCod) LEFT JOIN Banco T3 ON T3.CliCod = T1.CliCod AND T3.BanCod = T1.LegBanCod) LEFT JOIN ObraSocial T4 ON T4.CliCod = T1.CliCod AND T4.OsoCod = T1.LegOsoCod) WHERE T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((String[]) buf[4])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(4);
               ((short[]) buf[7])[0] = rslt.getShort(5);
               ((int[]) buf[8])[0] = rslt.getInt(6);
               ((String[]) buf[9])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((String[]) buf[11])[0] = rslt.getVarchar(8);
               ((String[]) buf[12])[0] = rslt.getString(9, 20);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
               ((String[]) buf[14])[0] = rslt.getString(10, 40);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getString(11, 20);
               ((boolean[]) buf[17])[0] = rslt.wasNull();
               ((String[]) buf[18])[0] = rslt.getString(12, 20);
               ((boolean[]) buf[19])[0] = rslt.wasNull();
               ((String[]) buf[20])[0] = rslt.getVarchar(13);
               ((boolean[]) buf[21])[0] = rslt.wasNull();
               ((long[]) buf[22])[0] = rslt.getLong(14);
               ((java.util.Date[]) buf[23])[0] = rslt.getGXDate(15);
               ((String[]) buf[24])[0] = rslt.getString(16, 20);
               ((boolean[]) buf[25])[0] = rslt.wasNull();
               ((String[]) buf[26])[0] = rslt.getString(17, 20);
               ((boolean[]) buf[27])[0] = rslt.wasNull();
               ((String[]) buf[28])[0] = rslt.getVarchar(18);
               ((boolean[]) buf[29])[0] = rslt.wasNull();
               ((String[]) buf[30])[0] = rslt.getVarchar(19);
               ((String[]) buf[31])[0] = rslt.getVarchar(20);
               ((String[]) buf[32])[0] = rslt.getVarchar(21);
               ((byte[]) buf[33])[0] = rslt.getByte(22);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

