package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class clienteconvenioswwgetfilterdata extends GXProcedure
{
   public clienteconvenioswwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( clienteconvenioswwgetfilterdata.class ), "" );
   }

   public clienteconvenioswwgetfilterdata( int remoteHandle ,
                                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      clienteconvenioswwgetfilterdata.this.aP5 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
      return aP5[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String aP2 ,
                        String[] aP3 ,
                        String[] aP4 ,
                        String[] aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String aP2 ,
                             String[] aP3 ,
                             String[] aP4 ,
                             String[] aP5 )
   {
      clienteconvenioswwgetfilterdata.this.AV29DDOName = aP0;
      clienteconvenioswwgetfilterdata.this.AV30SearchTxt = aP1;
      clienteconvenioswwgetfilterdata.this.AV31SearchTxtTo = aP2;
      clienteconvenioswwgetfilterdata.this.aP3 = aP3;
      clienteconvenioswwgetfilterdata.this.aP4 = aP4;
      clienteconvenioswwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV36EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      clienteconvenioswwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV36EmpCod = GXt_int1 ;
      GXt_int3 = AV37CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      clienteconvenioswwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV37CliCod = GXt_int3 ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV21OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWClienteConvenios", GXv_boolean6) ;
      clienteconvenioswwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
      AV8IsAuthorized = GXt_boolean5 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext7[0] = AV9WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext7) ;
         AV9WWPContext = GXv_SdtWWPContext7[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV29DDOName), "DDO_CLICONVENIO") == 0 )
         {
            /* Execute user subroutine: 'LOADCLICONVENIOOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV29DDOName), "DDO_CLICONVENIODESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADCLICONVENIODESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV32OptionsJson = AV19Options.toJSonString(false) ;
      AV33OptionsDescJson = AV21OptionsDesc.toJSonString(false) ;
      AV34OptionIndexesJson = AV22OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV24Session.getValue("ClienteConveniosWWGridState"), "") == 0 )
      {
         AV26GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ClienteConveniosWWGridState"), null, null);
      }
      else
      {
         AV26GridState.fromxml(AV24Session.getValue("ClienteConveniosWWGridState"), null, null);
      }
      AV45GXV1 = 1 ;
      while ( AV45GXV1 <= AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV27GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV26GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV45GXV1));
         if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVENIO") == 0 )
         {
            AV40TFCliConvenio = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVENIO_SEL") == 0 )
         {
            AV39TFCliConvenio_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV41TFCliConvenio_Sels.fromJSonString(AV39TFCliConvenio_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVENIODESCRIP") == 0 )
         {
            AV12TFCliConvenioDescrip = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVENIODESCRIP_SEL") == 0 )
         {
            AV11TFCliConvenioDescrip_SelsJson = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFCliConvenioDescrip_Sels.fromJSonString(AV11TFCliConvenioDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICONVEHAB_SEL") == 0 )
         {
            AV38TFCliConveHab_Sel = (byte)(GXutil.lval( AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV42MenuOpcCod = AV27GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV45GXV1 = (int)(AV45GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADCLICONVENIOOPTIONS' Routine */
      returnInSub = false ;
      AV40TFCliConvenio = AV30SearchTxt ;
      AV41TFCliConvenio_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV47Clienteconvenioswwds_1_tfcliconvenio = AV40TFCliConvenio ;
      AV48Clienteconvenioswwds_2_tfcliconvenio_sels = AV41TFCliConvenio_Sels ;
      AV49Clienteconvenioswwds_3_tfcliconveniodescrip = AV12TFCliConvenioDescrip ;
      AV50Clienteconvenioswwds_4_tfcliconveniodescrip_sels = AV13TFCliConvenioDescrip_Sels ;
      AV51Clienteconvenioswwds_5_tfcliconvehab_sel = AV38TFCliConveHab_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1565CliConvenio ,
                                           AV48Clienteconvenioswwds_2_tfcliconvenio_sels ,
                                           A1567CliConvenioDescrip ,
                                           AV50Clienteconvenioswwds_4_tfcliconveniodescrip_sels ,
                                           Integer.valueOf(AV48Clienteconvenioswwds_2_tfcliconvenio_sels.size()) ,
                                           AV47Clienteconvenioswwds_1_tfcliconvenio ,
                                           Integer.valueOf(AV50Clienteconvenioswwds_4_tfcliconveniodescrip_sels.size()) ,
                                           AV49Clienteconvenioswwds_3_tfcliconveniodescrip ,
                                           Byte.valueOf(AV51Clienteconvenioswwds_5_tfcliconvehab_sel) ,
                                           Boolean.valueOf(A1639CliConveHab) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV37CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV47Clienteconvenioswwds_1_tfcliconvenio = GXutil.padr( GXutil.rtrim( AV47Clienteconvenioswwds_1_tfcliconvenio), 20, "%") ;
      lV49Clienteconvenioswwds_3_tfcliconveniodescrip = GXutil.concat( GXutil.rtrim( AV49Clienteconvenioswwds_3_tfcliconveniodescrip), "%", "") ;
      /* Using cursor P01FO2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV37CliCod), lV47Clienteconvenioswwds_1_tfcliconvenio, lV49Clienteconvenioswwds_3_tfcliconveniodescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1FO2 = false ;
         A1564CliPaiConve = P01FO2_A1564CliPaiConve[0] ;
         A3CliCod = P01FO2_A3CliCod[0] ;
         A1565CliConvenio = P01FO2_A1565CliConvenio[0] ;
         A1639CliConveHab = P01FO2_A1639CliConveHab[0] ;
         A1567CliConvenioDescrip = P01FO2_A1567CliConvenioDescrip[0] ;
         A1567CliConvenioDescrip = P01FO2_A1567CliConvenioDescrip[0] ;
         AV23count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P01FO2_A1565CliConvenio[0], A1565CliConvenio) == 0 ) )
         {
            brk1FO2 = false ;
            A1564CliPaiConve = P01FO2_A1564CliPaiConve[0] ;
            A3CliCod = P01FO2_A3CliCod[0] ;
            AV23count = (long)(AV23count+1) ;
            brk1FO2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1565CliConvenio)==0) )
         {
            AV18Option = A1565CliConvenio ;
            AV19Options.add(AV18Option, 0);
            AV22OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV23count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1FO2 )
         {
            brk1FO2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADCLICONVENIODESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV12TFCliConvenioDescrip = AV30SearchTxt ;
      AV13TFCliConvenioDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV47Clienteconvenioswwds_1_tfcliconvenio = AV40TFCliConvenio ;
      AV48Clienteconvenioswwds_2_tfcliconvenio_sels = AV41TFCliConvenio_Sels ;
      AV49Clienteconvenioswwds_3_tfcliconveniodescrip = AV12TFCliConvenioDescrip ;
      AV50Clienteconvenioswwds_4_tfcliconveniodescrip_sels = AV13TFCliConvenioDescrip_Sels ;
      AV51Clienteconvenioswwds_5_tfcliconvehab_sel = AV38TFCliConveHab_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1565CliConvenio ,
                                           AV48Clienteconvenioswwds_2_tfcliconvenio_sels ,
                                           A1567CliConvenioDescrip ,
                                           AV50Clienteconvenioswwds_4_tfcliconveniodescrip_sels ,
                                           Integer.valueOf(AV48Clienteconvenioswwds_2_tfcliconvenio_sels.size()) ,
                                           AV47Clienteconvenioswwds_1_tfcliconvenio ,
                                           Integer.valueOf(AV50Clienteconvenioswwds_4_tfcliconveniodescrip_sels.size()) ,
                                           AV49Clienteconvenioswwds_3_tfcliconveniodescrip ,
                                           Byte.valueOf(AV51Clienteconvenioswwds_5_tfcliconvehab_sel) ,
                                           Boolean.valueOf(A1639CliConveHab) ,
                                           Integer.valueOf(AV37CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV47Clienteconvenioswwds_1_tfcliconvenio = GXutil.padr( GXutil.rtrim( AV47Clienteconvenioswwds_1_tfcliconvenio), 20, "%") ;
      lV49Clienteconvenioswwds_3_tfcliconveniodescrip = GXutil.concat( GXutil.rtrim( AV49Clienteconvenioswwds_3_tfcliconveniodescrip), "%", "") ;
      /* Using cursor P01FO3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV37CliCod), lV47Clienteconvenioswwds_1_tfcliconvenio, lV49Clienteconvenioswwds_3_tfcliconveniodescrip});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1FO4 = false ;
         A3CliCod = P01FO3_A3CliCod[0] ;
         A1565CliConvenio = P01FO3_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01FO3_A1564CliPaiConve[0] ;
         A1639CliConveHab = P01FO3_A1639CliConveHab[0] ;
         A1567CliConvenioDescrip = P01FO3_A1567CliConvenioDescrip[0] ;
         A1567CliConvenioDescrip = P01FO3_A1567CliConvenioDescrip[0] ;
         AV23count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P01FO3_A3CliCod[0] == A3CliCod ) && ( P01FO3_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( GXutil.strcmp(P01FO3_A1565CliConvenio[0], A1565CliConvenio) == 0 ) )
         {
            brk1FO4 = false ;
            AV23count = (long)(AV23count+1) ;
            brk1FO4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1567CliConvenioDescrip)==0) )
         {
            AV18Option = A1567CliConvenioDescrip ;
            AV17InsertIndex = 1 ;
            while ( ( AV17InsertIndex <= AV19Options.size() ) && ( GXutil.strcmp((String)AV19Options.elementAt(-1+AV17InsertIndex), AV18Option) < 0 ) )
            {
               AV17InsertIndex = (int)(AV17InsertIndex+1) ;
            }
            AV19Options.add(AV18Option, AV17InsertIndex);
            AV22OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV23count), "Z,ZZZ,ZZZ,ZZ9")), AV17InsertIndex);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1FO4 )
         {
            brk1FO4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = clienteconvenioswwgetfilterdata.this.AV32OptionsJson;
      this.aP4[0] = clienteconvenioswwgetfilterdata.this.AV33OptionsDescJson;
      this.aP5[0] = clienteconvenioswwgetfilterdata.this.AV34OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV32OptionsJson = "" ;
      AV33OptionsDescJson = "" ;
      AV34OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV21OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV24Session = httpContext.getWebSession();
      AV26GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV27GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV40TFCliConvenio = "" ;
      AV39TFCliConvenio_SelsJson = "" ;
      AV41TFCliConvenio_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12TFCliConvenioDescrip = "" ;
      AV11TFCliConvenioDescrip_SelsJson = "" ;
      AV13TFCliConvenioDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42MenuOpcCod = "" ;
      A1565CliConvenio = "" ;
      AV47Clienteconvenioswwds_1_tfcliconvenio = "" ;
      AV48Clienteconvenioswwds_2_tfcliconvenio_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV49Clienteconvenioswwds_3_tfcliconveniodescrip = "" ;
      AV50Clienteconvenioswwds_4_tfcliconveniodescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV47Clienteconvenioswwds_1_tfcliconvenio = "" ;
      lV49Clienteconvenioswwds_3_tfcliconveniodescrip = "" ;
      A1567CliConvenioDescrip = "" ;
      P01FO2_A1564CliPaiConve = new short[1] ;
      P01FO2_A3CliCod = new int[1] ;
      P01FO2_A1565CliConvenio = new String[] {""} ;
      P01FO2_A1639CliConveHab = new boolean[] {false} ;
      P01FO2_A1567CliConvenioDescrip = new String[] {""} ;
      AV18Option = "" ;
      P01FO3_A3CliCod = new int[1] ;
      P01FO3_A1565CliConvenio = new String[] {""} ;
      P01FO3_A1564CliPaiConve = new short[1] ;
      P01FO3_A1639CliConveHab = new boolean[] {false} ;
      P01FO3_A1567CliConvenioDescrip = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.clienteconvenioswwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P01FO2_A1564CliPaiConve, P01FO2_A3CliCod, P01FO2_A1565CliConvenio, P01FO2_A1639CliConveHab, P01FO2_A1567CliConvenioDescrip
            }
            , new Object[] {
            P01FO3_A3CliCod, P01FO3_A1565CliConvenio, P01FO3_A1564CliPaiConve, P01FO3_A1639CliConveHab, P01FO3_A1567CliConvenioDescrip
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV38TFCliConveHab_Sel ;
   private byte AV51Clienteconvenioswwds_5_tfcliconvehab_sel ;
   private short AV36EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short A1564CliPaiConve ;
   private short Gx_err ;
   private int AV37CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV45GXV1 ;
   private int AV48Clienteconvenioswwds_2_tfcliconvenio_sels_size ;
   private int AV50Clienteconvenioswwds_4_tfcliconveniodescrip_sels_size ;
   private int A3CliCod ;
   private int AV17InsertIndex ;
   private long AV23count ;
   private String AV40TFCliConvenio ;
   private String A1565CliConvenio ;
   private String AV47Clienteconvenioswwds_1_tfcliconvenio ;
   private String scmdbuf ;
   private String lV47Clienteconvenioswwds_1_tfcliconvenio ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A1639CliConveHab ;
   private boolean brk1FO2 ;
   private boolean brk1FO4 ;
   private String AV32OptionsJson ;
   private String AV33OptionsDescJson ;
   private String AV34OptionIndexesJson ;
   private String AV39TFCliConvenio_SelsJson ;
   private String AV11TFCliConvenioDescrip_SelsJson ;
   private String AV29DDOName ;
   private String AV30SearchTxt ;
   private String AV31SearchTxtTo ;
   private String AV12TFCliConvenioDescrip ;
   private String AV42MenuOpcCod ;
   private String AV49Clienteconvenioswwds_3_tfcliconveniodescrip ;
   private String lV49Clienteconvenioswwds_3_tfcliconveniodescrip ;
   private String A1567CliConvenioDescrip ;
   private String AV18Option ;
   private com.genexus.webpanels.WebSession AV24Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P01FO2_A1564CliPaiConve ;
   private int[] P01FO2_A3CliCod ;
   private String[] P01FO2_A1565CliConvenio ;
   private boolean[] P01FO2_A1639CliConveHab ;
   private String[] P01FO2_A1567CliConvenioDescrip ;
   private int[] P01FO3_A3CliCod ;
   private String[] P01FO3_A1565CliConvenio ;
   private short[] P01FO3_A1564CliPaiConve ;
   private boolean[] P01FO3_A1639CliConveHab ;
   private String[] P01FO3_A1567CliConvenioDescrip ;
   private GXSimpleCollection<String> AV41TFCliConvenio_Sels ;
   private GXSimpleCollection<String> AV48Clienteconvenioswwds_2_tfcliconvenio_sels ;
   private GXSimpleCollection<String> AV19Options ;
   private GXSimpleCollection<String> AV21OptionsDesc ;
   private GXSimpleCollection<String> AV22OptionIndexes ;
   private GXSimpleCollection<String> AV13TFCliConvenioDescrip_Sels ;
   private GXSimpleCollection<String> AV50Clienteconvenioswwds_4_tfcliconveniodescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV26GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV27GridStateFilterValue ;
}

final  class clienteconvenioswwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01FO2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1565CliConvenio ,
                                          GXSimpleCollection<String> AV48Clienteconvenioswwds_2_tfcliconvenio_sels ,
                                          String A1567CliConvenioDescrip ,
                                          GXSimpleCollection<String> AV50Clienteconvenioswwds_4_tfcliconveniodescrip_sels ,
                                          int AV48Clienteconvenioswwds_2_tfcliconvenio_sels_size ,
                                          String AV47Clienteconvenioswwds_1_tfcliconvenio ,
                                          int AV50Clienteconvenioswwds_4_tfcliconveniodescrip_sels_size ,
                                          String AV49Clienteconvenioswwds_3_tfcliconveniodescrip ,
                                          byte AV51Clienteconvenioswwds_5_tfcliconvehab_sel ,
                                          boolean A1639CliConveHab ,
                                          int A3CliCod ,
                                          int AV37CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[3];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT T1.CliPaiConve AS CliPaiConve, T1.CliCod, T1.CliConvenio AS CliConvenio, T1.CliConveHab, T2.ConveDescri AS CliConvenioDescrip FROM (ClienteConvenios T1 INNER" ;
      scmdbuf += " JOIN Convenio T2 ON T2.PaiCod = T1.CliPaiConve AND T2.ConveCodigo = T1.CliConvenio)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV48Clienteconvenioswwds_2_tfcliconvenio_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV47Clienteconvenioswwds_1_tfcliconvenio)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.CliConvenio) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV48Clienteconvenioswwds_2_tfcliconvenio_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV48Clienteconvenioswwds_2_tfcliconvenio_sels, "T1.CliConvenio IN (", ")")+")");
      }
      if ( ( AV50Clienteconvenioswwds_4_tfcliconveniodescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV49Clienteconvenioswwds_3_tfcliconveniodescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ConveDescri) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV50Clienteconvenioswwds_4_tfcliconveniodescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50Clienteconvenioswwds_4_tfcliconveniodescrip_sels, "T2.ConveDescri IN (", ")")+")");
      }
      if ( AV51Clienteconvenioswwds_5_tfcliconvehab_sel == 1 )
      {
         addWhere(sWhereString, "(T1.CliConveHab = TRUE)");
      }
      if ( AV51Clienteconvenioswwds_5_tfcliconvehab_sel == 2 )
      {
         addWhere(sWhereString, "(T1.CliConveHab = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliConvenio" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P01FO3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1565CliConvenio ,
                                          GXSimpleCollection<String> AV48Clienteconvenioswwds_2_tfcliconvenio_sels ,
                                          String A1567CliConvenioDescrip ,
                                          GXSimpleCollection<String> AV50Clienteconvenioswwds_4_tfcliconveniodescrip_sels ,
                                          int AV48Clienteconvenioswwds_2_tfcliconvenio_sels_size ,
                                          String AV47Clienteconvenioswwds_1_tfcliconvenio ,
                                          int AV50Clienteconvenioswwds_4_tfcliconveniodescrip_sels_size ,
                                          String AV49Clienteconvenioswwds_3_tfcliconveniodescrip ,
                                          byte AV51Clienteconvenioswwds_5_tfcliconvehab_sel ,
                                          boolean A1639CliConveHab ,
                                          int AV37CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[3];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT T1.CliCod, T1.CliConvenio AS CliConvenio, T1.CliPaiConve AS CliPaiConve, T1.CliConveHab, T2.ConveDescri AS CliConvenioDescrip FROM (ClienteConvenios T1 INNER" ;
      scmdbuf += " JOIN Convenio T2 ON T2.PaiCod = T1.CliPaiConve AND T2.ConveCodigo = T1.CliConvenio)" ;
      addWhere(sWhereString, "(T1.CliCod = ?)");
      if ( ( AV48Clienteconvenioswwds_2_tfcliconvenio_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV47Clienteconvenioswwds_1_tfcliconvenio)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T1.CliConvenio) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV48Clienteconvenioswwds_2_tfcliconvenio_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV48Clienteconvenioswwds_2_tfcliconvenio_sels, "T1.CliConvenio IN (", ")")+")");
      }
      if ( ( AV50Clienteconvenioswwds_4_tfcliconveniodescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV49Clienteconvenioswwds_3_tfcliconveniodescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(T2.ConveDescri) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV50Clienteconvenioswwds_4_tfcliconveniodescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV50Clienteconvenioswwds_4_tfcliconveniodescrip_sels, "T2.ConveDescri IN (", ")")+")");
      }
      if ( AV51Clienteconvenioswwds_5_tfcliconvehab_sel == 1 )
      {
         addWhere(sWhereString, "(T1.CliConveHab = TRUE)");
      }
      if ( AV51Clienteconvenioswwds_5_tfcliconvehab_sel == 2 )
      {
         addWhere(sWhereString, "(T1.CliConveHab = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.CliPaiConve, T1.CliConvenio" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P01FO2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Boolean) dynConstraints[9]).booleanValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() );
            case 1 :
                  return conditional_P01FO3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Boolean) dynConstraints[9]).booleanValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01FO2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01FO3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
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
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[4], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 400);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[4], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[5], 400);
               }
               return;
      }
   }

}

