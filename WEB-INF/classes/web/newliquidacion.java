package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newliquidacion extends GXProcedure
{
   public newliquidacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newliquidacion.class ), "" );
   }

   public newliquidacion( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        java.util.Date aP4 ,
                        java.util.Date aP5 ,
                        byte aP6 ,
                        String aP7 ,
                        byte aP8 ,
                        String aP9 ,
                        java.util.Date aP10 ,
                        java.util.Date aP11 ,
                        java.util.Date aP12 ,
                        String aP13 ,
                        byte aP14 ,
                        byte aP15 ,
                        String aP16 ,
                        String aP17 ,
                        java.util.Date aP18 ,
                        short aP19 ,
                        byte aP20 ,
                        short aP21 ,
                        byte aP22 ,
                        java.util.Date aP23 ,
                        java.util.Date aP24 ,
                        String aP25 ,
                        String aP26 ,
                        int aP27 ,
                        boolean aP28 ,
                        String aP29 ,
                        short aP30 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25, aP26, aP27, aP28, aP29, aP30);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             java.util.Date aP4 ,
                             java.util.Date aP5 ,
                             byte aP6 ,
                             String aP7 ,
                             byte aP8 ,
                             String aP9 ,
                             java.util.Date aP10 ,
                             java.util.Date aP11 ,
                             java.util.Date aP12 ,
                             String aP13 ,
                             byte aP14 ,
                             byte aP15 ,
                             String aP16 ,
                             String aP17 ,
                             java.util.Date aP18 ,
                             short aP19 ,
                             byte aP20 ,
                             short aP21 ,
                             byte aP22 ,
                             java.util.Date aP23 ,
                             java.util.Date aP24 ,
                             String aP25 ,
                             String aP26 ,
                             int aP27 ,
                             boolean aP28 ,
                             String aP29 ,
                             short aP30 )
   {
      newliquidacion.this.AV8CliCod = aP0;
      newliquidacion.this.AV9EmpCod = aP1;
      newliquidacion.this.AV10LiqNro = aP2;
      newliquidacion.this.AV11LiqDescrip = aP3;
      newliquidacion.this.AV12LiqFecha = aP4;
      newliquidacion.this.AV13LiqPeriodo = aP5;
      newliquidacion.this.AV14LiqClase = aP6;
      newliquidacion.this.AV39LiqModTra = aP7;
      newliquidacion.this.AV40LiqFrecPag = aP8;
      newliquidacion.this.AV43LiqTipoTarifa = aP9;
      newliquidacion.this.AV41LiqPerDes = aP10;
      newliquidacion.this.AV42LiqPerHas = aP11;
      newliquidacion.this.AV15LiqFecPago = aP12;
      newliquidacion.this.AV16TliqCod = aP13;
      newliquidacion.this.AV17LiqEstado = aP14;
      newliquidacion.this.AV18LiqAuxEstado = aP15;
      newliquidacion.this.AV33AplicaA = aP16;
      newliquidacion.this.AV21LiqDepBanCod = aP17;
      newliquidacion.this.AV22LiqDepPrvFec = aP18;
      newliquidacion.this.AV24LiqDepPerAno = aP19;
      newliquidacion.this.AV23LiqDepPerMes = aP20;
      newliquidacion.this.AV25LiqPerAno = aP21;
      newliquidacion.this.AV26LiqPerMes = aP22;
      newliquidacion.this.AV27LiqFecImp = aP23;
      newliquidacion.this.AV13LiqPeriodo = aP24;
      newliquidacion.this.AV29LiqNombre = aP25;
      newliquidacion.this.AV30LiqPerPalabra = aP26;
      newliquidacion.this.AV32LiqRelNro = aP27;
      newliquidacion.this.AV35LiqSac = aP28;
      newliquidacion.this.AV34LiqSacLog = aP29;
      newliquidacion.this.AV36LiqCntLeg = aP30;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.deletecolaporliqnro(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro) ;
      /*
         INSERT RECORD ON TABLE Liquidacion

      */
      A3CliCod = AV8CliCod ;
      A1EmpCod = AV9EmpCod ;
      A31LiqNro = AV10LiqNro ;
      A271LiqDescrip = AV11LiqDescrip ;
      A98LiqFecha = AV12LiqFecha ;
      A283LiqPeriodo = AV13LiqPeriodo ;
      A268LiqClase = AV14LiqClase ;
      n268LiqClase = false ;
      A2409LiqModTra = AV39LiqModTra ;
      A2414LiqFrecPag = AV40LiqFrecPag ;
      A2410LiqPerDes = AV41LiqPerDes ;
      A2411LiqPerHas = AV42LiqPerHas ;
      A2426LiqTipoTarifa = AV43LiqTipoTarifa ;
      A280LiqFecPago = AV15LiqFecPago ;
      if ( ! (GXutil.strcmp("", AV16TliqCod)==0) )
      {
         new web.msgdebug(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "&TliqCod ", "")+GXutil.trim( AV16TliqCod)+httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))) ;
         A32TLiqCod = AV16TliqCod ;
         n32TLiqCod = false ;
      }
      else
      {
         A32TLiqCod = "" ;
         n32TLiqCod = false ;
         n32TLiqCod = true ;
      }
      GXv_char1[0] = AV38TLiqDescAux ;
      new web.armartliqdescaux(remoteHandle, context).execute( AV8CliCod, AV16TliqCod, AV39LiqModTra, AV40LiqFrecPag, GXv_char1) ;
      newliquidacion.this.AV38TLiqDescAux = GXv_char1[0] ;
      A2368TLiqDescAux = AV38TLiqDescAux ;
      A278LiqEstado = (byte)(1) ;
      if ( GXutil.strcmp(AV39LiqModTra, "E") == 0 )
      {
         A2292LiqLSDDepEst = AV17LiqEstado ;
         A2293LiqContrEst = AV17LiqEstado ;
         A1403LiqAuxEstado = AV18LiqAuxEstado ;
      }
      else
      {
         A2292LiqLSDDepEst = (byte)(5) ;
         A2293LiqContrEst = (byte)(5) ;
         A1403LiqAuxEstado = (byte)(5) ;
      }
      if ( AV17LiqEstado == 4 )
      {
         A2180LiqPDFEstado = "Manual" ;
         n2180LiqPDFEstado = false ;
      }
      else
      {
         A2180LiqPDFEstado = "EnEspera" ;
         n2180LiqPDFEstado = false ;
      }
      if ( GXutil.strcmp(AV33AplicaA, httpContext.getMessage( "ALGUNOS", "")) == 0 )
      {
         A500LegEspecificos = true ;
      }
      else
      {
         A500LegEspecificos = false ;
      }
      A511LiqFecCre = GXutil.serverDate( context, remoteHandle, pr_default) ;
      GXt_char2 = A512LiqUsuCre ;
      GXv_char1[0] = GXt_char2 ;
      new web.getusulogged(remoteHandle, context).execute( GXv_char1) ;
      newliquidacion.this.GXt_char2 = GXv_char1[0] ;
      A512LiqUsuCre = GXt_char2 ;
      A513LiqPerSinDia = GXutil.trim( GXutil.str( GXutil.year( A283LiqPeriodo), 10, 0)) + "-" + GXutil.padl( GXutil.str( GXutil.month( A283LiqPeriodo), 10, 0), (short)(2), "0") ;
      if ( ! (GXutil.strcmp("", AV21LiqDepBanCod)==0) )
      {
         A33LiqDepBanCod = AV21LiqDepBanCod ;
         n33LiqDepBanCod = false ;
      }
      else
      {
         A33LiqDepBanCod = "" ;
         n33LiqDepBanCod = false ;
         n33LiqDepBanCod = true ;
      }
      A581LiqDepPrvFec = AV22LiqDepPrvFec ;
      A583LiqDepPerAno = AV24LiqDepPerAno ;
      A584LiqDepPerMes = AV23LiqDepPerMes ;
      A585LiqPerAno = AV25LiqPerAno ;
      A586LiqPerMes = AV26LiqPerMes ;
      A580LiqDepPrvPer = GXutil.padl( GXutil.str( AV23LiqDepPerMes, 2, 0), (short)(2), "0") + "/" + GXutil.trim( GXutil.str( AV24LiqDepPerAno, 4, 0)) ;
      A719LiqFecImp = AV27LiqFecImp ;
      AV28ProcesoLiquidacion = "Calculo" ;
      GXt_char2 = "" ;
      GXv_char1[0] = GXt_char2 ;
      new web.getopeclivalor_sinvalidar(remoteHandle, context).execute( AV8CliCod, "[piso_ganancias_SAC]", AV13LiqPeriodo, AV28ProcesoLiquidacion, GXv_char1) ;
      newliquidacion.this.GXt_char2 = GXv_char1[0] ;
      A744LiqPisGanSAC = CommonUtil.decimalVal( GXt_char2, ".") ;
      GXt_date3 = A746LiqPerUltNorm ;
      GXv_date4[0] = GXt_date3 ;
      new web.getperiodoultimanormativa(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, A283LiqPeriodo, A743LiqPisoGanancias, GXv_date4) ;
      newliquidacion.this.GXt_date3 = GXv_date4[0] ;
      A746LiqPerUltNorm = GXt_date3 ;
      if ( (GXutil.strcmp("", AV29LiqNombre)==0) )
      {
         GXv_char1[0] = AV30LiqPerPalabra ;
         GXv_char5[0] = AV29LiqNombre ;
         new web.armaliqnombre(remoteHandle, context).execute( AV8CliCod, AV13LiqPeriodo, GXv_char1, A32TLiqCod, A2409LiqModTra, A2414LiqFrecPag, GXv_char5) ;
         newliquidacion.this.AV30LiqPerPalabra = GXv_char1[0] ;
         newliquidacion.this.AV29LiqNombre = GXv_char5[0] ;
      }
      A874LiqNombre = AV29LiqNombre ;
      A748LiqPerPalabra = AV30LiqPerPalabra ;
      GXv_int6[0] = AV31cant ;
      new web.existeliquidacionpertipo(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, A32TLiqCod, A283LiqPeriodo, A2409LiqModTra, A2414LiqFrecPag, A2426LiqTipoTarifa, GXv_int6) ;
      newliquidacion.this.AV31cant = GXv_int6[0] ;
      if ( AV31cant > 0 )
      {
         AV31cant = (short)(AV31cant+1) ;
         A874LiqNombre += " (" + GXutil.trim( GXutil.str( AV31cant, 4, 0)) + ")" ;
      }
      A1729PeriodoLiq = AV13LiqPeriodo ;
      if ( ! (0==AV32LiqRelNro) )
      {
         A2112LiqRelNro = AV32LiqRelNro ;
         n2112LiqRelNro = false ;
      }
      else
      {
         A2112LiqRelNro = 0 ;
         n2112LiqRelNro = false ;
         n2112LiqRelNro = true ;
      }
      A2195LiqSac = AV35LiqSac ;
      n2195LiqSac = false ;
      A2196LiqSacLog = AV34LiqSacLog ;
      n2196LiqSacLog = false ;
      A361LiqGenInter = false ;
      A494LiqContabilizada = false ;
      A495LiqCntLeg = AV36LiqCntLeg ;
      A496LiqImpNeto = DecimalUtil.ZERO ;
      A497LiqImpBruto = DecimalUtil.ZERO ;
      A587LiqFecMod = GXutil.resetTime( GXutil.nullDate() );
      A588LiqUsuMod = "" ;
      A745LiqTopeDedInc = DecimalUtil.ZERO ;
      A755LiqImpDescuentos = DecimalUtil.ZERO ;
      A756LiqImpRetenGan = DecimalUtil.ZERO ;
      A766LiqError = "" ;
      A881LiqLegajosTxt = "" ;
      A885LiqSegundos = DecimalUtil.ZERO ;
      A963LiqRutaPDFTodosVertical = "" ;
      A964LiqRutaPDFTodosHorizontal = "" ;
      A965LiqRutaPDFTodosNombreVertical = "" ;
      A966LiqRutaPDFTodosNombreHorizonta = "" ;
      A1142LiqLog = "" ;
      A1404LiqErrorAux = "" ;
      A2298LiqCancel = false ;
      /* Using cursor P01Z62 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), A271LiqDescrip, A98LiqFecha, Short.valueOf(A585LiqPerAno), Byte.valueOf(A586LiqPerMes), A283LiqPeriodo, A280LiqFecPago, Boolean.valueOf(n32TLiqCod), A32TLiqCod, Byte.valueOf(A278LiqEstado), Boolean.valueOf(n268LiqClase), Byte.valueOf(A268LiqClase), Boolean.valueOf(A361LiqGenInter), Boolean.valueOf(A494LiqContabilizada), Short.valueOf(A495LiqCntLeg), A496LiqImpNeto, A497LiqImpBruto, Boolean.valueOf(A500LegEspecificos), A511LiqFecCre, A512LiqUsuCre, A513LiqPerSinDia, A580LiqDepPrvPer, A581LiqDepPrvFec, Boolean.valueOf(n33LiqDepBanCod), A33LiqDepBanCod, Short.valueOf(A583LiqDepPerAno), Byte.valueOf(A584LiqDepPerMes), A587LiqFecMod, A588LiqUsuMod, A719LiqFecImp, A744LiqPisGanSAC, A745LiqTopeDedInc, A746LiqPerUltNorm, A748LiqPerPalabra, A755LiqImpDescuentos, A756LiqImpRetenGan, A766LiqError, A874LiqNombre, A881LiqLegajosTxt, A885LiqSegundos, A963LiqRutaPDFTodosVertical, A964LiqRutaPDFTodosHorizontal, A965LiqRutaPDFTodosNombreVertical, A966LiqRutaPDFTodosNombreHorizonta, A1142LiqLog, Byte.valueOf(A1403LiqAuxEstado), A1404LiqErrorAux, A1729PeriodoLiq, Boolean.valueOf(n2112LiqRelNro), Integer.valueOf(A2112LiqRelNro), Boolean.valueOf(n2180LiqPDFEstado), A2180LiqPDFEstado, Boolean.valueOf(n2195LiqSac), Boolean.valueOf(A2195LiqSac), Boolean.valueOf(n2196LiqSacLog), A2196LiqSacLog, Byte.valueOf(A2292LiqLSDDepEst), Byte.valueOf(A2293LiqContrEst), Boolean.valueOf(A2298LiqCancel), A2368TLiqDescAux, A2409LiqModTra, A2410LiqPerDes, A2411LiqPerHas, Byte.valueOf(A2414LiqFrecPag), A2426LiqTipoTarifa});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Liquidacion");
      if ( (pr_default.getStatus(0) == 1) )
      {
         Gx_err = (short)(1) ;
         Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
      }
      else
      {
         Gx_err = (short)(0) ;
         Gx_emsg = "" ;
      }
      /* End Insert */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newliquidacion");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A271LiqDescrip = "" ;
      A98LiqFecha = GXutil.nullDate() ;
      A283LiqPeriodo = GXutil.nullDate() ;
      A2409LiqModTra = "" ;
      A2410LiqPerDes = GXutil.nullDate() ;
      A2411LiqPerHas = GXutil.nullDate() ;
      A2426LiqTipoTarifa = "" ;
      A280LiqFecPago = GXutil.nullDate() ;
      AV46Pgmname = "" ;
      A32TLiqCod = "" ;
      AV38TLiqDescAux = "" ;
      A2368TLiqDescAux = "" ;
      A2180LiqPDFEstado = "" ;
      A511LiqFecCre = GXutil.nullDate() ;
      A512LiqUsuCre = "" ;
      A513LiqPerSinDia = "" ;
      A33LiqDepBanCod = "" ;
      A581LiqDepPrvFec = GXutil.nullDate() ;
      A580LiqDepPrvPer = "" ;
      A719LiqFecImp = GXutil.resetTime( GXutil.nullDate() );
      AV28ProcesoLiquidacion = "" ;
      A744LiqPisGanSAC = DecimalUtil.ZERO ;
      GXt_char2 = "" ;
      A746LiqPerUltNorm = GXutil.nullDate() ;
      GXt_date3 = GXutil.nullDate() ;
      A743LiqPisoGanancias = DecimalUtil.ZERO ;
      GXv_date4 = new java.util.Date[1] ;
      GXv_char1 = new String[1] ;
      GXv_char5 = new String[1] ;
      A874LiqNombre = "" ;
      A748LiqPerPalabra = "" ;
      GXv_int6 = new short[1] ;
      A1729PeriodoLiq = GXutil.nullDate() ;
      A2196LiqSacLog = "" ;
      A496LiqImpNeto = DecimalUtil.ZERO ;
      A497LiqImpBruto = DecimalUtil.ZERO ;
      A587LiqFecMod = GXutil.resetTime( GXutil.nullDate() );
      A588LiqUsuMod = "" ;
      A745LiqTopeDedInc = DecimalUtil.ZERO ;
      A755LiqImpDescuentos = DecimalUtil.ZERO ;
      A756LiqImpRetenGan = DecimalUtil.ZERO ;
      A766LiqError = "" ;
      A881LiqLegajosTxt = "" ;
      A885LiqSegundos = DecimalUtil.ZERO ;
      A963LiqRutaPDFTodosVertical = "" ;
      A964LiqRutaPDFTodosHorizontal = "" ;
      A965LiqRutaPDFTodosNombreVertical = "" ;
      A966LiqRutaPDFTodosNombreHorizonta = "" ;
      A1142LiqLog = "" ;
      A1404LiqErrorAux = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newliquidacion__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      AV46Pgmname = "newLiquidacion" ;
      /* GeneXus formulas. */
      AV46Pgmname = "newLiquidacion" ;
      Gx_err = (short)(0) ;
   }

   private byte AV14LiqClase ;
   private byte AV40LiqFrecPag ;
   private byte AV17LiqEstado ;
   private byte AV18LiqAuxEstado ;
   private byte AV23LiqDepPerMes ;
   private byte AV26LiqPerMes ;
   private byte A268LiqClase ;
   private byte A2414LiqFrecPag ;
   private byte A278LiqEstado ;
   private byte A2292LiqLSDDepEst ;
   private byte A2293LiqContrEst ;
   private byte A1403LiqAuxEstado ;
   private byte A584LiqDepPerMes ;
   private byte A586LiqPerMes ;
   private short AV9EmpCod ;
   private short AV24LiqDepPerAno ;
   private short AV25LiqPerAno ;
   private short AV36LiqCntLeg ;
   private short A1EmpCod ;
   private short A583LiqDepPerAno ;
   private short A585LiqPerAno ;
   private short AV31cant ;
   private short GXv_int6[] ;
   private short A495LiqCntLeg ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LiqNro ;
   private int AV32LiqRelNro ;
   private int GX_INS25 ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A2112LiqRelNro ;
   private java.math.BigDecimal A744LiqPisGanSAC ;
   private java.math.BigDecimal A743LiqPisoGanancias ;
   private java.math.BigDecimal A496LiqImpNeto ;
   private java.math.BigDecimal A497LiqImpBruto ;
   private java.math.BigDecimal A745LiqTopeDedInc ;
   private java.math.BigDecimal A755LiqImpDescuentos ;
   private java.math.BigDecimal A756LiqImpRetenGan ;
   private java.math.BigDecimal A885LiqSegundos ;
   private String AV39LiqModTra ;
   private String AV43LiqTipoTarifa ;
   private String AV16TliqCod ;
   private String AV33AplicaA ;
   private String AV21LiqDepBanCod ;
   private String AV30LiqPerPalabra ;
   private String A2409LiqModTra ;
   private String A2426LiqTipoTarifa ;
   private String AV46Pgmname ;
   private String A32TLiqCod ;
   private String A2180LiqPDFEstado ;
   private String A513LiqPerSinDia ;
   private String A33LiqDepBanCod ;
   private String A580LiqDepPrvPer ;
   private String AV28ProcesoLiquidacion ;
   private String GXt_char2 ;
   private String GXv_char1[] ;
   private String GXv_char5[] ;
   private String A748LiqPerPalabra ;
   private String A965LiqRutaPDFTodosNombreVertical ;
   private String A966LiqRutaPDFTodosNombreHorizonta ;
   private String Gx_emsg ;
   private java.util.Date AV27LiqFecImp ;
   private java.util.Date A719LiqFecImp ;
   private java.util.Date A587LiqFecMod ;
   private java.util.Date AV12LiqFecha ;
   private java.util.Date AV13LiqPeriodo ;
   private java.util.Date AV41LiqPerDes ;
   private java.util.Date AV42LiqPerHas ;
   private java.util.Date AV15LiqFecPago ;
   private java.util.Date AV22LiqDepPrvFec ;
   private java.util.Date A98LiqFecha ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date A2410LiqPerDes ;
   private java.util.Date A2411LiqPerHas ;
   private java.util.Date A280LiqFecPago ;
   private java.util.Date A511LiqFecCre ;
   private java.util.Date A581LiqDepPrvFec ;
   private java.util.Date A746LiqPerUltNorm ;
   private java.util.Date GXt_date3 ;
   private java.util.Date GXv_date4[] ;
   private java.util.Date A1729PeriodoLiq ;
   private boolean AV35LiqSac ;
   private boolean n268LiqClase ;
   private boolean n32TLiqCod ;
   private boolean n2180LiqPDFEstado ;
   private boolean A500LegEspecificos ;
   private boolean n33LiqDepBanCod ;
   private boolean n2112LiqRelNro ;
   private boolean A2195LiqSac ;
   private boolean n2195LiqSac ;
   private boolean n2196LiqSacLog ;
   private boolean A361LiqGenInter ;
   private boolean A494LiqContabilizada ;
   private boolean A2298LiqCancel ;
   private String A1142LiqLog ;
   private String AV11LiqDescrip ;
   private String AV29LiqNombre ;
   private String AV34LiqSacLog ;
   private String A271LiqDescrip ;
   private String AV38TLiqDescAux ;
   private String A2368TLiqDescAux ;
   private String A512LiqUsuCre ;
   private String A874LiqNombre ;
   private String A2196LiqSacLog ;
   private String A588LiqUsuMod ;
   private String A766LiqError ;
   private String A881LiqLegajosTxt ;
   private String A963LiqRutaPDFTodosVertical ;
   private String A964LiqRutaPDFTodosHorizontal ;
   private String A1404LiqErrorAux ;
   private IDataStoreProvider pr_default ;
}

final  class newliquidacion__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01Z62", "SAVEPOINT gxupdate;INSERT INTO Liquidacion(CliCod, EmpCod, LiqNro, LiqDescrip, LiqFecha, LiqPerAno, LiqPerMes, LiqPeriodo, LiqFecPago, TLiqCod, LiqEstado, LiqClase, LiqGenInter, LiqContabilizada, LiqCntLeg, LiqImpNeto, LiqImpBruto, LegEspecificos, LiqFecCre, LiqUsuCre, LiqPerSinDia, LiqDepPrvPer, LiqDepPrvFec, LiqDepBanCod, LiqDepPerAno, LiqDepPerMes, LiqFecMod, LiqUsuMod, LiqFecImp, LiqPisGanSAC, LiqTopeDedInc, LiqPerUltNorm, LiqPerPalabra, LiqImpDescuentos, LiqImpRetenGan, LiqError, LiqNombre, LiqLegajosTxt, LiqSegundos, LiqRutaPDFTodosVertical, LiqRutaPDFTodosHorizontal, LiqRutaPDFTodosNombreVertical, LiqRutaPDFTodosNombreHorizonta, LiqLog, LiqAuxEstado, LiqErrorAux, PeriodoLiq, LiqRelNro, LiqPDFEstado, LiqSac, LiqSacLog, LiqLSDDepEst, LiqContrEst, LiqCancel, TLiqDescAux, LiqModTra, LiqPerDes, LiqPerHas, LiqFrecPag, LiqTipoTarifa, LiqPisoGanancias) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
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
               stmt.setVarchar(4, (String)parms[3], 400, false);
               stmt.setDate(5, (java.util.Date)parms[4]);
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setDate(8, (java.util.Date)parms[7]);
               stmt.setDate(9, (java.util.Date)parms[8]);
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(10, (String)parms[10], 20);
               }
               stmt.setByte(11, ((Number) parms[11]).byteValue());
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.NUMERIC );
               }
               else
               {
                  stmt.setByte(12, ((Number) parms[13]).byteValue());
               }
               stmt.setBoolean(13, ((Boolean) parms[14]).booleanValue());
               stmt.setBoolean(14, ((Boolean) parms[15]).booleanValue());
               stmt.setShort(15, ((Number) parms[16]).shortValue());
               stmt.setBigDecimal(16, (java.math.BigDecimal)parms[17], 2);
               stmt.setBigDecimal(17, (java.math.BigDecimal)parms[18], 2);
               stmt.setBoolean(18, ((Boolean) parms[19]).booleanValue());
               stmt.setDate(19, (java.util.Date)parms[20]);
               stmt.setVarchar(20, (String)parms[21], 100, false);
               stmt.setString(21, (String)parms[22], 20);
               stmt.setString(22, (String)parms[23], 20);
               stmt.setDate(23, (java.util.Date)parms[24]);
               if ( ((Boolean) parms[25]).booleanValue() )
               {
                  stmt.setNull( 24 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(24, (String)parms[26], 6);
               }
               stmt.setShort(25, ((Number) parms[27]).shortValue());
               stmt.setByte(26, ((Number) parms[28]).byteValue());
               stmt.setDateTime(27, (java.util.Date)parms[29], false);
               stmt.setVarchar(28, (String)parms[30], 100, false);
               stmt.setDateTime(29, (java.util.Date)parms[31], false);
               stmt.setBigDecimal(30, (java.math.BigDecimal)parms[32], 2);
               stmt.setBigDecimal(31, (java.math.BigDecimal)parms[33], 2);
               stmt.setDate(32, (java.util.Date)parms[34]);
               stmt.setString(33, (String)parms[35], 20);
               stmt.setBigDecimal(34, (java.math.BigDecimal)parms[36], 2);
               stmt.setBigDecimal(35, (java.math.BigDecimal)parms[37], 2);
               stmt.setVarchar(36, (String)parms[38], 400, false);
               stmt.setVarchar(37, (String)parms[39], 400, false);
               stmt.setVarchar(38, (String)parms[40], 1000, false);
               stmt.setBigDecimal(39, (java.math.BigDecimal)parms[41], 2);
               stmt.setVarchar(40, (String)parms[42], 400, false);
               stmt.setVarchar(41, (String)parms[43], 400, false);
               stmt.setString(42, (String)parms[44], 200);
               stmt.setString(43, (String)parms[45], 200);
               stmt.setNLongVarchar(44, (String)parms[46], false);
               stmt.setByte(45, ((Number) parms[47]).byteValue());
               stmt.setVarchar(46, (String)parms[48], 400, false);
               stmt.setDate(47, (java.util.Date)parms[49]);
               if ( ((Boolean) parms[50]).booleanValue() )
               {
                  stmt.setNull( 48 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(48, ((Number) parms[51]).intValue());
               }
               if ( ((Boolean) parms[52]).booleanValue() )
               {
                  stmt.setNull( 49 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(49, (String)parms[53], 20);
               }
               if ( ((Boolean) parms[54]).booleanValue() )
               {
                  stmt.setNull( 50 , Types.BIT );
               }
               else
               {
                  stmt.setBoolean(50, ((Boolean) parms[55]).booleanValue());
               }
               if ( ((Boolean) parms[56]).booleanValue() )
               {
                  stmt.setNull( 51 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(51, (String)parms[57], 400);
               }
               stmt.setByte(52, ((Number) parms[58]).byteValue());
               stmt.setByte(53, ((Number) parms[59]).byteValue());
               stmt.setBoolean(54, ((Boolean) parms[60]).booleanValue());
               stmt.setVarchar(55, (String)parms[61], 30, false);
               stmt.setString(56, (String)parms[62], 1);
               stmt.setDate(57, (java.util.Date)parms[63]);
               stmt.setDate(58, (java.util.Date)parms[64]);
               stmt.setByte(59, ((Number) parms[65]).byteValue());
               stmt.setString(60, (String)parms[66], 1);
               return;
      }
   }

}

