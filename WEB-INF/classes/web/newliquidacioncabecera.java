package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newliquidacioncabecera extends GXProcedure
{
   public newliquidacioncabecera( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newliquidacioncabecera.class ), "" );
   }

   public newliquidacioncabecera( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.util.Date executeUdp( int aP0 ,
                                     short aP1 ,
                                     int aP2 ,
                                     short aP3 ,
                                     byte aP4 ,
                                     String aP5 ,
                                     String aP6 ,
                                     java.util.Date aP7 ,
                                     byte aP8 ,
                                     String aP9 ,
                                     byte aP10 ,
                                     String aP11 ,
                                     java.util.Date aP12 ,
                                     java.util.Date aP13 ,
                                     java.util.Date aP14 ,
                                     String aP15 ,
                                     byte aP16 ,
                                     byte aP17 ,
                                     String aP18 ,
                                     String aP19 ,
                                     java.util.Date aP20 ,
                                     short aP21 ,
                                     byte aP22 ,
                                     java.util.Date aP23 ,
                                     String aP24 ,
                                     int aP25 ,
                                     boolean aP26 ,
                                     String aP27 ,
                                     short aP28 )
   {
      newliquidacioncabecera.this.aP29 = new java.util.Date[] {GXutil.nullDate()};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25, aP26, aP27, aP28, aP29);
      return aP29[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short aP3 ,
                        byte aP4 ,
                        String aP5 ,
                        String aP6 ,
                        java.util.Date aP7 ,
                        byte aP8 ,
                        String aP9 ,
                        byte aP10 ,
                        String aP11 ,
                        java.util.Date aP12 ,
                        java.util.Date aP13 ,
                        java.util.Date aP14 ,
                        String aP15 ,
                        byte aP16 ,
                        byte aP17 ,
                        String aP18 ,
                        String aP19 ,
                        java.util.Date aP20 ,
                        short aP21 ,
                        byte aP22 ,
                        java.util.Date aP23 ,
                        String aP24 ,
                        int aP25 ,
                        boolean aP26 ,
                        String aP27 ,
                        short aP28 ,
                        java.util.Date[] aP29 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22, aP23, aP24, aP25, aP26, aP27, aP28, aP29);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short aP3 ,
                             byte aP4 ,
                             String aP5 ,
                             String aP6 ,
                             java.util.Date aP7 ,
                             byte aP8 ,
                             String aP9 ,
                             byte aP10 ,
                             String aP11 ,
                             java.util.Date aP12 ,
                             java.util.Date aP13 ,
                             java.util.Date aP14 ,
                             String aP15 ,
                             byte aP16 ,
                             byte aP17 ,
                             String aP18 ,
                             String aP19 ,
                             java.util.Date aP20 ,
                             short aP21 ,
                             byte aP22 ,
                             java.util.Date aP23 ,
                             String aP24 ,
                             int aP25 ,
                             boolean aP26 ,
                             String aP27 ,
                             short aP28 ,
                             java.util.Date[] aP29 )
   {
      newliquidacioncabecera.this.AV8CliCod = aP0;
      newliquidacioncabecera.this.AV9EmpCod = aP1;
      newliquidacioncabecera.this.AV17LiqNro = aP2;
      newliquidacioncabecera.this.AV18LiqPerAno = aP3;
      newliquidacioncabecera.this.AV20LiqPerMes = aP4;
      newliquidacioncabecera.this.AV22parmLiqPerPalabra = aP5;
      newliquidacioncabecera.this.AV13LiqDescrip = aP6;
      newliquidacioncabecera.this.AV15LiqFecha = aP7;
      newliquidacioncabecera.this.AV12LiqClase = aP8;
      newliquidacioncabecera.this.AV38LiqModTra = aP9;
      newliquidacioncabecera.this.AV37LiqFrecPag = aP10;
      newliquidacioncabecera.this.AV39LiqTipoTarifa = aP11;
      newliquidacioncabecera.this.AV36LiqPerDes = aP12;
      newliquidacioncabecera.this.AV35LiqPerHas = aP13;
      newliquidacioncabecera.this.AV16LiqFecPago = aP14;
      newliquidacioncabecera.this.AV23TliqCod = aP15;
      newliquidacioncabecera.this.AV14LiqEstado = aP16;
      newliquidacioncabecera.this.AV11LiqAuxEstado = aP17;
      newliquidacioncabecera.this.AV24AplicaA = aP18;
      newliquidacioncabecera.this.AV25LiqDepBanCod = aP19;
      newliquidacioncabecera.this.AV26LiqDepPrvFec = aP20;
      newliquidacioncabecera.this.AV27LiqDepPerAno = aP21;
      newliquidacioncabecera.this.AV28LiqDepPerMes = aP22;
      newliquidacioncabecera.this.AV33LiqFecImp = aP23;
      newliquidacioncabecera.this.AV32LiqNombre = aP24;
      newliquidacioncabecera.this.AV31LiqRelNro = aP25;
      newliquidacioncabecera.this.AV30LiqSac = aP26;
      newliquidacioncabecera.this.AV29LiqSacLog = aP27;
      newliquidacioncabecera.this.AV34LiqCntLeg = aP28;
      newliquidacioncabecera.this.aP29 = aP29;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV19LiqPeriodo = localUtil.ymdtod( AV18LiqPerAno, AV20LiqPerMes, 1) ;
      if ( (GXutil.strcmp("", AV22parmLiqPerPalabra)==0) )
      {
         GXv_char1[0] = AV21LiqPerPalabra ;
         new web.armaperpalabra(remoteHandle, context).execute( AV8CliCod, AV19LiqPeriodo, GXv_char1) ;
         newliquidacioncabecera.this.AV21LiqPerPalabra = GXv_char1[0] ;
      }
      else
      {
         AV21LiqPerPalabra = AV22parmLiqPerPalabra ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " empcod ", "")+GXutil.trim( GXutil.str( AV9EmpCod, 4, 0))+httpContext.getMessage( " liqperiodo ", "")+GXutil.trim( localUtil.dtoc( AV19LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " ano ", "")+GXutil.trim( GXutil.str( AV18LiqPerAno, 4, 0))+httpContext.getMessage( " mes ", "")+GXutil.trim( GXutil.str( AV20LiqPerMes, 2, 0))+httpContext.getMessage( " liqperpalabra ", "")+GXutil.trim( AV21LiqPerPalabra)) ;
      new web.newperiodo(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV19LiqPeriodo, AV18LiqPerAno, AV20LiqPerMes, AV21LiqPerPalabra) ;
      GXv_boolean2[0] = AV10existe ;
      new web.liquidacionexiste(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV17LiqNro, GXv_boolean2) ;
      newliquidacioncabecera.this.AV10existe = GXv_boolean2[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " emp ", "")+GXutil.trim( GXutil.str( AV9EmpCod, 4, 0))+httpContext.getMessage( " &LiqNro ", "")+GXutil.trim( GXutil.str( AV17LiqNro, 8, 0))+httpContext.getMessage( " existe ", "")+GXutil.trim( GXutil.booltostr( AV10existe))) ;
      if ( ! AV10existe )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, httpContext.getMessage( "antes newliq", "")) ;
         new web.newliquidacion(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV17LiqNro, AV13LiqDescrip, AV15LiqFecha, AV19LiqPeriodo, AV12LiqClase, AV38LiqModTra, AV37LiqFrecPag, AV39LiqTipoTarifa, AV36LiqPerDes, AV35LiqPerHas, AV16LiqFecPago, AV23TliqCod, AV14LiqEstado, AV11LiqAuxEstado, AV24AplicaA, AV25LiqDepBanCod, AV26LiqDepPrvFec, AV27LiqDepPerAno, AV28LiqDepPerMes, AV18LiqPerAno, AV20LiqPerMes, AV33LiqFecImp, AV19LiqPeriodo, AV32LiqNombre, AV21LiqPerPalabra, AV31LiqRelNro, AV30LiqSac, AV29LiqSacLog, AV34LiqCntLeg) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV42Pgmname, httpContext.getMessage( "despues newliq &LiqFecImp ", "")+GXutil.trim( localUtil.ttoc( AV33LiqFecImp, 8, 5, ((GXutil.strcmp(httpContext.getLanguageProperty( "time_fmt"), "12")==0) ? 1 : 0), localUtil.mapDateTimeFormat( httpContext.getLanguageProperty( "date_fmt")), "/", ":", " "))) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP29[0] = newliquidacioncabecera.this.AV19LiqPeriodo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV19LiqPeriodo = GXutil.nullDate() ;
      AV21LiqPerPalabra = "" ;
      GXv_char1 = new String[1] ;
      AV42Pgmname = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV42Pgmname = "newLiquidacionCabecera" ;
      /* GeneXus formulas. */
      AV42Pgmname = "newLiquidacionCabecera" ;
      Gx_err = (short)(0) ;
   }

   private byte AV20LiqPerMes ;
   private byte AV12LiqClase ;
   private byte AV37LiqFrecPag ;
   private byte AV14LiqEstado ;
   private byte AV11LiqAuxEstado ;
   private byte AV28LiqDepPerMes ;
   private short AV9EmpCod ;
   private short AV18LiqPerAno ;
   private short AV27LiqDepPerAno ;
   private short AV34LiqCntLeg ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV17LiqNro ;
   private int AV31LiqRelNro ;
   private String AV22parmLiqPerPalabra ;
   private String AV38LiqModTra ;
   private String AV39LiqTipoTarifa ;
   private String AV23TliqCod ;
   private String AV24AplicaA ;
   private String AV25LiqDepBanCod ;
   private String AV21LiqPerPalabra ;
   private String GXv_char1[] ;
   private String AV42Pgmname ;
   private java.util.Date AV33LiqFecImp ;
   private java.util.Date AV15LiqFecha ;
   private java.util.Date AV36LiqPerDes ;
   private java.util.Date AV35LiqPerHas ;
   private java.util.Date AV16LiqFecPago ;
   private java.util.Date AV26LiqDepPrvFec ;
   private java.util.Date AV19LiqPeriodo ;
   private boolean AV30LiqSac ;
   private boolean AV10existe ;
   private boolean GXv_boolean2[] ;
   private String AV13LiqDescrip ;
   private String AV32LiqNombre ;
   private String AV29LiqSacLog ;
   private java.util.Date[] aP29 ;
}

