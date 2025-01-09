package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class crearcliente extends GXProcedure
{
   public crearcliente( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( crearcliente.class ), "" );
   }

   public crearcliente( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( String aP0 ,
                          long aP1 ,
                          boolean aP2 ,
                          short aP3 ,
                          String aP4 ,
                          boolean aP5 ,
                          boolean aP6 )
   {
      crearcliente.this.aP7 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
      return aP7[0];
   }

   public void execute( String aP0 ,
                        long aP1 ,
                        boolean aP2 ,
                        short aP3 ,
                        String aP4 ,
                        boolean aP5 ,
                        boolean aP6 ,
                        int[] aP7 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7);
   }

   private void execute_int( String aP0 ,
                             long aP1 ,
                             boolean aP2 ,
                             short aP3 ,
                             String aP4 ,
                             boolean aP5 ,
                             boolean aP6 ,
                             int[] aP7 )
   {
      crearcliente.this.AV9CliNom = aP0;
      crearcliente.this.AV10CliCUIT = aP1;
      crearcliente.this.AV11CliMultiEmp = aP2;
      crearcliente.this.AV12CliPaiCod = aP3;
      crearcliente.this.AV38ActComCodigo = aP4;
      crearcliente.this.AV32clienteEsNucleo = aP5;
      crearcliente.this.AV17clienteConvenioEs = aP6;
      crearcliente.this.aP7 = aP7;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV14sistemaCliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.clientenucleodepais(remoteHandle, context).execute( AV12CliPaiCod, GXv_int2) ;
      crearcliente.this.GXt_int1 = GXv_int2[0] ;
      AV14sistemaCliCod = GXt_int1 ;
      /*
         INSERT RECORD ON TABLE Cliente

      */
      A344CliNom = AV9CliNom ;
      A345CliCUIT = AV10CliCUIT ;
      A346CliFecAlta = GXutil.serverDate( context, remoteHandle, pr_default) ;
      A366CliMultiEmp = AV11CliMultiEmp ;
      if ( ! (0==AV12CliPaiCod) )
      {
         A4CliPaiCod = AV12CliPaiCod ;
         n4CliPaiCod = false ;
      }
      else
      {
         A4CliPaiCod = (short)(0) ;
         n4CliPaiCod = false ;
         n4CliPaiCod = true ;
      }
      if ( AV32clienteEsNucleo )
      {
         A747ClienteSistema = true ;
         A546ClientePadre = 0 ;
         n546ClientePadre = false ;
         n546ClientePadre = true ;
      }
      else
      {
         A747ClienteSistema = false ;
         A546ClientePadre = AV14sistemaCliCod ;
         n546ClientePadre = false ;
      }
      A1605ClienteConveniador = AV17clienteConvenioEs ;
      A1741ClienteTipo = "" ;
      n1741ClienteTipo = false ;
      A2023CliManten = false ;
      /* Using cursor P00AZ2 */
      pr_default.execute(0, new Object[] {A344CliNom, Long.valueOf(A345CliCUIT), A346CliFecAlta, Boolean.valueOf(A366CliMultiEmp), Boolean.valueOf(n546ClientePadre), Long.valueOf(A546ClientePadre), Boolean.valueOf(n4CliPaiCod), Short.valueOf(A4CliPaiCod), Boolean.valueOf(A747ClienteSistema), Boolean.valueOf(A1605ClienteConveniador), Boolean.valueOf(n1741ClienteTipo), A1741ClienteTipo, Boolean.valueOf(A2023CliManten)});
      /* Retrieving last key number assigned */
      /* Using cursor P00AZ3 */
      pr_default.execute(1);
      A3CliCod = P00AZ3_A3CliCod[0] ;
      pr_default.close(1);
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Cliente");
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
      AV8CliCod = A3CliCod ;
      if ( ! AV32clienteEsNucleo )
      {
         new web.iniesquematarifariodefault(remoteHandle, context).execute( AV8CliCod, AV12CliPaiCod) ;
         GXv_objcol_char3[0] = AV39SinCod ;
         new web.getsindicatosporactcomercial(remoteHandle, context).execute( AV12CliPaiCod, AV38ActComCodigo, GXv_objcol_char3) ;
         AV39SinCod = GXv_objcol_char3[0] ;
         pr_default.dynParam(2, new Object[]{ new Object[]{
                                              A935ConveSinCod ,
                                              AV39SinCod ,
                                              Short.valueOf(AV12CliPaiCod) ,
                                              Short.valueOf(A46PaiCod) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT
                                              }
         });
         /* Using cursor P00AZ4 */
         pr_default.execute(2, new Object[] {Short.valueOf(AV12CliPaiCod)});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A46PaiCod = P00AZ4_A46PaiCod[0] ;
            A9ConveCodigo = P00AZ4_A9ConveCodigo[0] ;
            A935ConveSinCod = P00AZ4_A935ConveSinCod[0] ;
            n935ConveSinCod = P00AZ4_n935ConveSinCod[0] ;
            /*
               INSERT RECORD ON TABLE ClienteConvenios

            */
            A3CliCod = AV8CliCod ;
            A1564CliPaiConve = A46PaiCod ;
            A1565CliConvenio = A9ConveCodigo ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "&clienteConvenioEs ", "")+GXutil.trim( GXutil.booltostr( AV17clienteConvenioEs))) ;
            if ( ! AV17clienteConvenioEs )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, "1") ;
               GXt_int1 = A1566CliConveVer ;
               GXv_int2[0] = GXt_int1 ;
               new web.ultimaversiondeconvenio(remoteHandle, context).execute( A46PaiCod, A9ConveCodigo, GXv_int2) ;
               crearcliente.this.GXt_int1 = GXv_int2[0] ;
               A1566CliConveVer = GXt_int1 ;
               n1566CliConveVer = false ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, "2") ;
               A1639CliConveHab = false ;
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, "3") ;
               A1566CliConveVer = 0 ;
               n1566CliConveVer = false ;
               n1566CliConveVer = true ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, "4") ;
               A1639CliConveHab = true ;
            }
            A2130CliConveActObl = true ;
            /* Using cursor P00AZ5 */
            pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, Boolean.valueOf(n1566CliConveVer), Integer.valueOf(A1566CliConveVer), Boolean.valueOf(A1639CliConveHab), Boolean.valueOf(A2130CliConveActObl)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenios");
            if ( (pr_default.getStatus(3) == 1) )
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
            if ( AV17clienteConvenioEs )
            {
               /*
                  INSERT RECORD ON TABLE ClienteConvenio_Particularidades

               */
               GXv_decimal4[0] = AV18ConveTopeIndem ;
               GXv_boolean5[0] = AV24ConveDefault ;
               GXv_decimal6[0] = AV19ConveMesHsPExt ;
               GXv_char7[0] = AV20ConveDiaHsPExt ;
               GXv_boolean8[0] = AV21ConveFondoCese ;
               GXv_int9[0] = AV22ConvePerVacDes ;
               GXv_int10[0] = AV23ConvePerVacHas ;
               GXv_int11[0] = AV26ConveInterDiasJor ;
               GXv_int12[0] = AV25ConveDiasAcuVac ;
               GXv_int13[0] = AV27ConveMinMesesVac ;
               GXv_int14[0] = AV29ConvePromMeses ;
               GXv_date15[0] = AV30CliConveVig ;
               GXv_objcol_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem16[0] = AV33sdt_conveVacaciones ;
               new web.defaultsconvenio(remoteHandle, context).execute( A9ConveCodigo, GXv_decimal4, GXv_boolean5, GXv_decimal6, GXv_char7, GXv_boolean8, GXv_int9, GXv_int10, GXv_int11, GXv_int12, GXv_int13, GXv_int14, GXv_date15, GXv_objcol_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem16) ;
               crearcliente.this.AV18ConveTopeIndem = GXv_decimal4[0] ;
               crearcliente.this.AV24ConveDefault = GXv_boolean5[0] ;
               crearcliente.this.AV19ConveMesHsPExt = GXv_decimal6[0] ;
               crearcliente.this.AV20ConveDiaHsPExt = GXv_char7[0] ;
               crearcliente.this.AV21ConveFondoCese = GXv_boolean8[0] ;
               crearcliente.this.AV22ConvePerVacDes = GXv_int9[0] ;
               crearcliente.this.AV23ConvePerVacHas = GXv_int10[0] ;
               crearcliente.this.AV26ConveInterDiasJor = GXv_int11[0] ;
               crearcliente.this.AV25ConveDiasAcuVac = GXv_int12[0] ;
               crearcliente.this.AV27ConveMinMesesVac = GXv_int13[0] ;
               crearcliente.this.AV29ConvePromMeses = GXv_int14[0] ;
               crearcliente.this.AV30CliConveVig = GXv_date15[0] ;
               AV33sdt_conveVacaciones = GXv_objcol_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem16[0] ;
               A3CliCod = AV8CliCod ;
               A1564CliPaiConve = A46PaiCod ;
               A1565CliConvenio = A9ConveCodigo ;
               A1575CliConveVig = AV30CliConveVig ;
               A905ConveDefault = AV24ConveDefault ;
               A1043ConveInterDiasJor = AV26ConveInterDiasJor ;
               A1044ConveDiasAcuVac = AV25ConveDiasAcuVac ;
               A1046ConveMinMesesVac = AV27ConveMinMesesVac ;
               A1269ConveMesHsPExt = AV19ConveMesHsPExt ;
               A1270ConveDiaHsPExt = AV20ConveDiaHsPExt ;
               n1270ConveDiaHsPExt = false ;
               A1401ConveFondoCese = AV21ConveFondoCese ;
               A2036ConveRelRef = "" ;
               A2037ConvePartOld = "" ;
               A1897ConveRelSec = 0 ;
               /* Using cursor P00AZ6 */
               pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A1575CliConveVig, Boolean.valueOf(A905ConveDefault), Short.valueOf(A1043ConveInterDiasJor), Byte.valueOf(A1044ConveDiasAcuVac), Byte.valueOf(A1046ConveMinMesesVac), A1269ConveMesHsPExt, Boolean.valueOf(n1270ConveDiaHsPExt), A1270ConveDiaHsPExt, Boolean.valueOf(A1401ConveFondoCese), Integer.valueOf(A1897ConveRelSec), A2036ConveRelRef, A2037ConvePartOld});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("ClienteConvenio_Particularidades");
               if ( (pr_default.getStatus(4) == 1) )
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
               AV44GXV1 = 1 ;
               while ( AV44GXV1 <= AV33sdt_conveVacaciones.size() )
               {
                  AV34itemConveVac = (web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem)((web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem)AV33sdt_conveVacaciones.elementAt(-1+AV44GXV1));
                  new web.newconveniovacaciones(remoteHandle, context).execute( AV8CliCod, A46PaiCod, A9ConveCodigo, AV30CliConveVig, AV34itemConveVac.getgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdesdeanti(), AV34itemConveVac.getgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevachastaanti(), AV34itemConveVac.getgxTv_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem_Convevacdias(), 0) ;
                  AV44GXV1 = (int)(AV44GXV1+1) ;
               }
               if ( ( GXutil.strcmp(A9ConveCodigo, new web.conveniouocra(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(A9ConveCodigo, new web.conveniouocrayac(remoteHandle, context).executeUdp( )) == 0 ) )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  AV35CliConvenio = A9ConveCodigo ;
                  new web.new_conveniotiposdetrabajo(remoteHandle, context).execute( AV8CliCod, new web.paisargentina(remoteHandle, context).executeUdp( ), AV35CliConvenio, "diurno", DecimalUtil.doubleToDec(9), DecimalUtil.doubleToDec(44), DecimalUtil.stringToDec("1.5"), DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(48), DecimalUtil.doubleToDec(320), (short)(0)) ;
                  new web.newconveniofondocese(remoteHandle, context).execute( AV8CliCod, A46PaiCod, A9ConveCodigo, AV30CliConveVig, (short)(1), (short)(0), DecimalUtil.stringToDec("0.12"), true, true, false, 0) ;
                  new web.newconveniofondocese(remoteHandle, context).execute( AV8CliCod, A46PaiCod, A9ConveCodigo, AV30CliConveVig, (short)(2), (short)(12), DecimalUtil.stringToDec("0.8"), true, true, false, 0) ;
               }
            }
            pr_default.readNext(2);
         }
         pr_default.close(2);
      }
      new web.crearcarpetaupload(remoteHandle, context).execute( AV8CliCod, (short)(0)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP7[0] = crearcliente.this.AV8CliCod;
      Application.commitDataStores(context, remoteHandle, pr_default, "crearcliente");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A344CliNom = "" ;
      A346CliFecAlta = GXutil.nullDate() ;
      A1741ClienteTipo = "" ;
      scmdbuf = "" ;
      P00AZ3_A3CliCod = new int[1] ;
      Gx_emsg = "" ;
      AV39SinCod = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char3 = new GXSimpleCollection[1] ;
      A935ConveSinCod = "" ;
      P00AZ4_A46PaiCod = new short[1] ;
      P00AZ4_A9ConveCodigo = new String[] {""} ;
      P00AZ4_A935ConveSinCod = new String[] {""} ;
      P00AZ4_n935ConveSinCod = new boolean[] {false} ;
      A9ConveCodigo = "" ;
      A1565CliConvenio = "" ;
      AV43Pgmname = "" ;
      GXv_int2 = new int[1] ;
      AV18ConveTopeIndem = DecimalUtil.ZERO ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV19ConveMesHsPExt = DecimalUtil.ZERO ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      AV20ConveDiaHsPExt = "" ;
      GXv_char7 = new String[1] ;
      GXv_boolean8 = new boolean[1] ;
      GXv_int9 = new byte[1] ;
      GXv_int10 = new byte[1] ;
      GXv_int11 = new short[1] ;
      GXv_int12 = new byte[1] ;
      GXv_int13 = new byte[1] ;
      GXv_int14 = new byte[1] ;
      AV30CliConveVig = GXutil.nullDate() ;
      GXv_date15 = new java.util.Date[1] ;
      AV33sdt_conveVacaciones = new GXBaseCollection<web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem>(web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem.class, "sdt_conveVacacionesItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem16 = new GXBaseCollection[1] ;
      A1575CliConveVig = GXutil.nullDate() ;
      A1269ConveMesHsPExt = DecimalUtil.ZERO ;
      A1270ConveDiaHsPExt = "" ;
      A2036ConveRelRef = "" ;
      A2037ConvePartOld = "" ;
      AV34itemConveVac = new web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem(remoteHandle, context);
      AV35CliConvenio = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.crearcliente__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            P00AZ3_A3CliCod
            }
            , new Object[] {
            P00AZ4_A46PaiCod, P00AZ4_A9ConveCodigo, P00AZ4_A935ConveSinCod, P00AZ4_n935ConveSinCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV43Pgmname = "crearCliente" ;
      /* GeneXus formulas. */
      AV43Pgmname = "crearCliente" ;
      Gx_err = (short)(0) ;
   }

   private byte AV22ConvePerVacDes ;
   private byte GXv_int9[] ;
   private byte AV23ConvePerVacHas ;
   private byte GXv_int10[] ;
   private byte AV25ConveDiasAcuVac ;
   private byte GXv_int12[] ;
   private byte AV27ConveMinMesesVac ;
   private byte GXv_int13[] ;
   private byte AV29ConvePromMeses ;
   private byte GXv_int14[] ;
   private byte A1044ConveDiasAcuVac ;
   private byte A1046ConveMinMesesVac ;
   private short AV12CliPaiCod ;
   private short A4CliPaiCod ;
   private short Gx_err ;
   private short A46PaiCod ;
   private short A1564CliPaiConve ;
   private short AV26ConveInterDiasJor ;
   private short GXv_int11[] ;
   private short A1043ConveInterDiasJor ;
   private int AV8CliCod ;
   private int AV14sistemaCliCod ;
   private int GX_INS49 ;
   private int A3CliCod ;
   private int GX_INS202 ;
   private int A1566CliConveVer ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int GX_INS204 ;
   private int A1897ConveRelSec ;
   private int AV44GXV1 ;
   private long AV10CliCUIT ;
   private long A345CliCUIT ;
   private long A546ClientePadre ;
   private java.math.BigDecimal AV18ConveTopeIndem ;
   private java.math.BigDecimal GXv_decimal4[] ;
   private java.math.BigDecimal AV19ConveMesHsPExt ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private java.math.BigDecimal A1269ConveMesHsPExt ;
   private String AV38ActComCodigo ;
   private String A1741ClienteTipo ;
   private String scmdbuf ;
   private String Gx_emsg ;
   private String A935ConveSinCod ;
   private String A9ConveCodigo ;
   private String A1565CliConvenio ;
   private String AV43Pgmname ;
   private String AV20ConveDiaHsPExt ;
   private String GXv_char7[] ;
   private String A1270ConveDiaHsPExt ;
   private String AV35CliConvenio ;
   private java.util.Date A346CliFecAlta ;
   private java.util.Date AV30CliConveVig ;
   private java.util.Date GXv_date15[] ;
   private java.util.Date A1575CliConveVig ;
   private boolean AV11CliMultiEmp ;
   private boolean AV32clienteEsNucleo ;
   private boolean AV17clienteConvenioEs ;
   private boolean A366CliMultiEmp ;
   private boolean n4CliPaiCod ;
   private boolean A747ClienteSistema ;
   private boolean n546ClientePadre ;
   private boolean A1605ClienteConveniador ;
   private boolean n1741ClienteTipo ;
   private boolean A2023CliManten ;
   private boolean n935ConveSinCod ;
   private boolean n1566CliConveVer ;
   private boolean A1639CliConveHab ;
   private boolean A2130CliConveActObl ;
   private boolean AV24ConveDefault ;
   private boolean GXv_boolean5[] ;
   private boolean AV21ConveFondoCese ;
   private boolean GXv_boolean8[] ;
   private boolean A905ConveDefault ;
   private boolean n1270ConveDiaHsPExt ;
   private boolean A1401ConveFondoCese ;
   private boolean Cond_result ;
   private String A2037ConvePartOld ;
   private String AV9CliNom ;
   private String A344CliNom ;
   private String A2036ConveRelRef ;
   private int[] aP7 ;
   private IDataStoreProvider pr_default ;
   private int[] P00AZ3_A3CliCod ;
   private short[] P00AZ4_A46PaiCod ;
   private String[] P00AZ4_A9ConveCodigo ;
   private String[] P00AZ4_A935ConveSinCod ;
   private boolean[] P00AZ4_n935ConveSinCod ;
   private GXSimpleCollection<String> AV39SinCod ;
   private GXSimpleCollection<String> GXv_objcol_char3[] ;
   private GXBaseCollection<web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem> AV33sdt_conveVacaciones ;
   private GXBaseCollection<web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem> GXv_objcol_Sdtsdt_conveVacaciones_sdt_conveVacacionesItem16[] ;
   private web.Sdtsdt_conveVacaciones_sdt_conveVacacionesItem AV34itemConveVac ;
}

final  class crearcliente__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00AZ4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A935ConveSinCod ,
                                          GXSimpleCollection<String> AV39SinCod ,
                                          short AV12CliPaiCod ,
                                          short A46PaiCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[1];
      Object[] GXv_Object18 = new Object[2];
      scmdbuf = "SELECT PaiCod, ConveCodigo, ConveSinCod FROM Convenio" ;
      addWhere(sWhereString, "(PaiCod = ?)");
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV39SinCod, "ConveSinCod IN (", ")")+")");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY PaiCod" ;
      GXv_Object18[0] = scmdbuf ;
      GXv_Object18[1] = GXv_int17 ;
      return GXv_Object18 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 2 :
                  return conditional_P00AZ4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P00AZ2", "SAVEPOINT gxupdate;INSERT INTO Cliente(CliNom, CliCUIT, CliFecAlta, CliMultiEmp, ClientePadre, CliPaiCod, ClienteSistema, ClienteConveniador, ClienteTipo, CliManten) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00AZ3", "SELECT currval('CliCod') ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00AZ4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00AZ5", "SAVEPOINT gxupdate;INSERT INTO ClienteConvenios(CliCod, CliPaiConve, CliConvenio, CliConveVer, CliConveHab, CliConveActObl, CliConveEsquemaEs) VALUES(?, ?, ?, ?, ?, ?, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00AZ6", "SAVEPOINT gxupdate;INSERT INTO ClienteConvenio_Particularidades(CliCod, CliPaiConve, CliConvenio, CliConveVig, ConveDefault, ConveInterDiasJor, ConveDiasAcuVac, ConveMinMesesVac, ConveMesHsPExt, ConveDiaHsPExt, ConveFondoCese, ConveRelSec, ConveRelRef, ConvePartOld, ConveGuarEdadMin, ConveGuarEdadMax) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, 0);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setLong(2, ((Number) parms[1]).longValue());
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setBoolean(4, ((Boolean) parms[3]).booleanValue());
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.NUMERIC );
               }
               else
               {
                  stmt.setLong(5, ((Number) parms[5]).longValue());
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(6, ((Number) parms[7]).shortValue());
               }
               stmt.setBoolean(7, ((Boolean) parms[8]).booleanValue());
               stmt.setBoolean(8, ((Boolean) parms[9]).booleanValue());
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(9, (String)parms[11], 20);
               }
               stmt.setBoolean(10, ((Boolean) parms[12]).booleanValue());
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[1]).shortValue());
               }
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(4, ((Number) parms[4]).intValue());
               }
               stmt.setBoolean(5, ((Boolean) parms[5]).booleanValue());
               stmt.setBoolean(6, ((Boolean) parms[6]).booleanValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 1);
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(10, (String)parms[10], 20);
               }
               stmt.setBoolean(11, ((Boolean) parms[11]).booleanValue());
               stmt.setInt(12, ((Number) parms[12]).intValue());
               stmt.setVarchar(13, (String)parms[13], 40, false);
               stmt.setNLongVarchar(14, (String)parms[14], false);
               return;
      }
   }

}

