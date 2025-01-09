package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class modalidadafipwwgetfilterdata extends GXProcedure
{
   public modalidadafipwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( modalidadafipwwgetfilterdata.class ), "" );
   }

   public modalidadafipwwgetfilterdata( int remoteHandle ,
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
      modalidadafipwwgetfilterdata.this.aP5 = new String[] {""};
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
      modalidadafipwwgetfilterdata.this.AV36DDOName = aP0;
      modalidadafipwwgetfilterdata.this.AV37SearchTxt = aP1;
      modalidadafipwwgetfilterdata.this.AV38SearchTxtTo = aP2;
      modalidadafipwwgetfilterdata.this.aP3 = aP3;
      modalidadafipwwgetfilterdata.this.aP4 = aP4;
      modalidadafipwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV43EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      modalidadafipwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV43EmpCod = GXt_int1 ;
      GXt_int3 = AV44CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      modalidadafipwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV44CliCod = GXt_int3 ;
      AV26Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV28OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV29OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWModalidad", GXv_boolean6) ;
      modalidadafipwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV36DDOName), "DDO_MPRCOD") == 0 )
         {
            /* Execute user subroutine: 'LOADMPRCODOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV36DDOName), "DDO_MPRDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADMPRDESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV39OptionsJson = AV26Options.toJSonString(false) ;
      AV40OptionsDescJson = AV28OptionsDesc.toJSonString(false) ;
      AV41OptionIndexesJson = AV29OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV31Session.getValue("ModalidadAFIPWWGridState"), "") == 0 )
      {
         AV33GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ModalidadAFIPWWGridState"), null, null);
      }
      else
      {
         AV33GridState.fromxml(AV31Session.getValue("ModalidadAFIPWWGridState"), null, null);
      }
      AV50GXV1 = 1 ;
      while ( AV50GXV1 <= AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV34GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV50GXV1));
         if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMPRCOD") == 0 )
         {
            AV12TFMprCod = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMPRCOD_SEL") == 0 )
         {
            AV11TFMprCod_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFMprCod_Sels.fromJSonString(AV11TFMprCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMPRDESCRIP") == 0 )
         {
            AV15TFMprDescrip = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMPRDESCRIP_SEL") == 0 )
         {
            AV14TFMprDescrip_SelsJson = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFMprDescrip_Sels.fromJSonString(AV14TFMprDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMPRESPARCIAL_SEL") == 0 )
         {
            AV23TFMprEsParcial_Sel = (byte)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMPRNODETRAE_SEL") == 0 )
         {
            AV45TFMprNoDetrae_Sel = (byte)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMPRHORASEXTRAS_SEL") == 0 )
         {
            AV46TFMprHorasExtras_Sel = (byte)(GXutil.lval( AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV47MenuOpcCod = AV34GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV50GXV1 = (int)(AV50GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADMPRCODOPTIONS' Routine */
      returnInSub = false ;
      AV12TFMprCod = AV37SearchTxt ;
      AV13TFMprCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV52Modalidadafipwwds_1_tfmprcod = AV12TFMprCod ;
      AV53Modalidadafipwwds_2_tfmprcod_sels = AV13TFMprCod_Sels ;
      AV54Modalidadafipwwds_3_tfmprdescrip = AV15TFMprDescrip ;
      AV55Modalidadafipwwds_4_tfmprdescrip_sels = AV16TFMprDescrip_Sels ;
      AV56Modalidadafipwwds_5_tfmpresparcial_sel = AV23TFMprEsParcial_Sel ;
      AV57Modalidadafipwwds_6_tfmprnodetrae_sel = AV45TFMprNoDetrae_Sel ;
      AV58Modalidadafipwwds_7_tfmprhorasextras_sel = AV46TFMprHorasExtras_Sel ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A18MprCod ,
                                           AV53Modalidadafipwwds_2_tfmprcod_sels ,
                                           A303MprDescrip ,
                                           AV55Modalidadafipwwds_4_tfmprdescrip_sels ,
                                           Integer.valueOf(AV53Modalidadafipwwds_2_tfmprcod_sels.size()) ,
                                           AV52Modalidadafipwwds_1_tfmprcod ,
                                           Integer.valueOf(AV55Modalidadafipwwds_4_tfmprdescrip_sels.size()) ,
                                           AV54Modalidadafipwwds_3_tfmprdescrip ,
                                           Byte.valueOf(AV56Modalidadafipwwds_5_tfmpresparcial_sel) ,
                                           Byte.valueOf(AV57Modalidadafipwwds_6_tfmprnodetrae_sel) ,
                                           Byte.valueOf(AV58Modalidadafipwwds_7_tfmprhorasextras_sel) ,
                                           Boolean.valueOf(A1024MprEsParcial) ,
                                           Boolean.valueOf(A1071MprNoDetrae) ,
                                           Boolean.valueOf(A1353MprHorasExtras) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN
                                           }
      });
      lV52Modalidadafipwwds_1_tfmprcod = GXutil.padr( GXutil.rtrim( AV52Modalidadafipwwds_1_tfmprcod), 20, "%") ;
      lV54Modalidadafipwwds_3_tfmprdescrip = GXutil.concat( GXutil.rtrim( AV54Modalidadafipwwds_3_tfmprdescrip), "%", "") ;
      /* Using cursor P013D2 */
      pr_default.execute(0, new Object[] {lV52Modalidadafipwwds_1_tfmprcod, lV54Modalidadafipwwds_3_tfmprdescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1353MprHorasExtras = P013D2_A1353MprHorasExtras[0] ;
         A1071MprNoDetrae = P013D2_A1071MprNoDetrae[0] ;
         A1024MprEsParcial = P013D2_A1024MprEsParcial[0] ;
         A303MprDescrip = P013D2_A303MprDescrip[0] ;
         A18MprCod = P013D2_A18MprCod[0] ;
         if ( ! (GXutil.strcmp("", A18MprCod)==0) )
         {
            AV25Option = A18MprCod ;
            AV26Options.add(AV25Option, 0);
         }
         if ( AV26Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADMPRDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV15TFMprDescrip = AV37SearchTxt ;
      AV16TFMprDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV52Modalidadafipwwds_1_tfmprcod = AV12TFMprCod ;
      AV53Modalidadafipwwds_2_tfmprcod_sels = AV13TFMprCod_Sels ;
      AV54Modalidadafipwwds_3_tfmprdescrip = AV15TFMprDescrip ;
      AV55Modalidadafipwwds_4_tfmprdescrip_sels = AV16TFMprDescrip_Sels ;
      AV56Modalidadafipwwds_5_tfmpresparcial_sel = AV23TFMprEsParcial_Sel ;
      AV57Modalidadafipwwds_6_tfmprnodetrae_sel = AV45TFMprNoDetrae_Sel ;
      AV58Modalidadafipwwds_7_tfmprhorasextras_sel = AV46TFMprHorasExtras_Sel ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A18MprCod ,
                                           AV53Modalidadafipwwds_2_tfmprcod_sels ,
                                           A303MprDescrip ,
                                           AV55Modalidadafipwwds_4_tfmprdescrip_sels ,
                                           Integer.valueOf(AV53Modalidadafipwwds_2_tfmprcod_sels.size()) ,
                                           AV52Modalidadafipwwds_1_tfmprcod ,
                                           Integer.valueOf(AV55Modalidadafipwwds_4_tfmprdescrip_sels.size()) ,
                                           AV54Modalidadafipwwds_3_tfmprdescrip ,
                                           Byte.valueOf(AV56Modalidadafipwwds_5_tfmpresparcial_sel) ,
                                           Byte.valueOf(AV57Modalidadafipwwds_6_tfmprnodetrae_sel) ,
                                           Byte.valueOf(AV58Modalidadafipwwds_7_tfmprhorasextras_sel) ,
                                           Boolean.valueOf(A1024MprEsParcial) ,
                                           Boolean.valueOf(A1071MprNoDetrae) ,
                                           Boolean.valueOf(A1353MprHorasExtras) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BYTE, TypeConstants.BOOLEAN,
                                           TypeConstants.BOOLEAN, TypeConstants.BOOLEAN
                                           }
      });
      lV52Modalidadafipwwds_1_tfmprcod = GXutil.padr( GXutil.rtrim( AV52Modalidadafipwwds_1_tfmprcod), 20, "%") ;
      lV54Modalidadafipwwds_3_tfmprdescrip = GXutil.concat( GXutil.rtrim( AV54Modalidadafipwwds_3_tfmprdescrip), "%", "") ;
      /* Using cursor P013D3 */
      pr_default.execute(1, new Object[] {lV52Modalidadafipwwds_1_tfmprcod, lV54Modalidadafipwwds_3_tfmprdescrip});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk13D3 = false ;
         A303MprDescrip = P013D3_A303MprDescrip[0] ;
         A1353MprHorasExtras = P013D3_A1353MprHorasExtras[0] ;
         A1071MprNoDetrae = P013D3_A1071MprNoDetrae[0] ;
         A1024MprEsParcial = P013D3_A1024MprEsParcial[0] ;
         A18MprCod = P013D3_A18MprCod[0] ;
         AV30count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P013D3_A303MprDescrip[0], A303MprDescrip) == 0 ) )
         {
            brk13D3 = false ;
            A18MprCod = P013D3_A18MprCod[0] ;
            AV30count = (long)(AV30count+1) ;
            brk13D3 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A303MprDescrip)==0) )
         {
            AV25Option = A303MprDescrip ;
            AV26Options.add(AV25Option, 0);
            AV29OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV30count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV26Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk13D3 )
         {
            brk13D3 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = modalidadafipwwgetfilterdata.this.AV39OptionsJson;
      this.aP4[0] = modalidadafipwwgetfilterdata.this.AV40OptionsDescJson;
      this.aP5[0] = modalidadafipwwgetfilterdata.this.AV41OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV39OptionsJson = "" ;
      AV40OptionsDescJson = "" ;
      AV41OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV26Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV28OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV31Session = httpContext.getWebSession();
      AV33GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV34GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFMprCod = "" ;
      AV11TFMprCod_SelsJson = "" ;
      AV13TFMprCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFMprDescrip = "" ;
      AV14TFMprDescrip_SelsJson = "" ;
      AV16TFMprDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV47MenuOpcCod = "" ;
      A18MprCod = "" ;
      AV52Modalidadafipwwds_1_tfmprcod = "" ;
      AV53Modalidadafipwwds_2_tfmprcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV54Modalidadafipwwds_3_tfmprdescrip = "" ;
      AV55Modalidadafipwwds_4_tfmprdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV52Modalidadafipwwds_1_tfmprcod = "" ;
      lV54Modalidadafipwwds_3_tfmprdescrip = "" ;
      A303MprDescrip = "" ;
      P013D2_A1353MprHorasExtras = new boolean[] {false} ;
      P013D2_A1071MprNoDetrae = new boolean[] {false} ;
      P013D2_A1024MprEsParcial = new boolean[] {false} ;
      P013D2_A303MprDescrip = new String[] {""} ;
      P013D2_A18MprCod = new String[] {""} ;
      AV25Option = "" ;
      P013D3_A303MprDescrip = new String[] {""} ;
      P013D3_A1353MprHorasExtras = new boolean[] {false} ;
      P013D3_A1071MprNoDetrae = new boolean[] {false} ;
      P013D3_A1024MprEsParcial = new boolean[] {false} ;
      P013D3_A18MprCod = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.modalidadafipwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P013D2_A1353MprHorasExtras, P013D2_A1071MprNoDetrae, P013D2_A1024MprEsParcial, P013D2_A303MprDescrip, P013D2_A18MprCod
            }
            , new Object[] {
            P013D3_A303MprDescrip, P013D3_A1353MprHorasExtras, P013D3_A1071MprNoDetrae, P013D3_A1024MprEsParcial, P013D3_A18MprCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV23TFMprEsParcial_Sel ;
   private byte AV45TFMprNoDetrae_Sel ;
   private byte AV46TFMprHorasExtras_Sel ;
   private byte AV56Modalidadafipwwds_5_tfmpresparcial_sel ;
   private byte AV57Modalidadafipwwds_6_tfmprnodetrae_sel ;
   private byte AV58Modalidadafipwwds_7_tfmprhorasextras_sel ;
   private short AV43EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV44CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV50GXV1 ;
   private int AV53Modalidadafipwwds_2_tfmprcod_sels_size ;
   private int AV55Modalidadafipwwds_4_tfmprdescrip_sels_size ;
   private long AV30count ;
   private String AV12TFMprCod ;
   private String A18MprCod ;
   private String AV52Modalidadafipwwds_1_tfmprcod ;
   private String scmdbuf ;
   private String lV52Modalidadafipwwds_1_tfmprcod ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A1024MprEsParcial ;
   private boolean A1071MprNoDetrae ;
   private boolean A1353MprHorasExtras ;
   private boolean brk13D3 ;
   private String AV39OptionsJson ;
   private String AV40OptionsDescJson ;
   private String AV41OptionIndexesJson ;
   private String AV11TFMprCod_SelsJson ;
   private String AV14TFMprDescrip_SelsJson ;
   private String AV36DDOName ;
   private String AV37SearchTxt ;
   private String AV38SearchTxtTo ;
   private String AV15TFMprDescrip ;
   private String AV47MenuOpcCod ;
   private String AV54Modalidadafipwwds_3_tfmprdescrip ;
   private String lV54Modalidadafipwwds_3_tfmprdescrip ;
   private String A303MprDescrip ;
   private String AV25Option ;
   private com.genexus.webpanels.WebSession AV31Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P013D2_A1353MprHorasExtras ;
   private boolean[] P013D2_A1071MprNoDetrae ;
   private boolean[] P013D2_A1024MprEsParcial ;
   private String[] P013D2_A303MprDescrip ;
   private String[] P013D2_A18MprCod ;
   private String[] P013D3_A303MprDescrip ;
   private boolean[] P013D3_A1353MprHorasExtras ;
   private boolean[] P013D3_A1071MprNoDetrae ;
   private boolean[] P013D3_A1024MprEsParcial ;
   private String[] P013D3_A18MprCod ;
   private GXSimpleCollection<String> AV13TFMprCod_Sels ;
   private GXSimpleCollection<String> AV53Modalidadafipwwds_2_tfmprcod_sels ;
   private GXSimpleCollection<String> AV26Options ;
   private GXSimpleCollection<String> AV28OptionsDesc ;
   private GXSimpleCollection<String> AV29OptionIndexes ;
   private GXSimpleCollection<String> AV16TFMprDescrip_Sels ;
   private GXSimpleCollection<String> AV55Modalidadafipwwds_4_tfmprdescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV33GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV34GridStateFilterValue ;
}

final  class modalidadafipwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P013D2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A18MprCod ,
                                          GXSimpleCollection<String> AV53Modalidadafipwwds_2_tfmprcod_sels ,
                                          String A303MprDescrip ,
                                          GXSimpleCollection<String> AV55Modalidadafipwwds_4_tfmprdescrip_sels ,
                                          int AV53Modalidadafipwwds_2_tfmprcod_sels_size ,
                                          String AV52Modalidadafipwwds_1_tfmprcod ,
                                          int AV55Modalidadafipwwds_4_tfmprdescrip_sels_size ,
                                          String AV54Modalidadafipwwds_3_tfmprdescrip ,
                                          byte AV56Modalidadafipwwds_5_tfmpresparcial_sel ,
                                          byte AV57Modalidadafipwwds_6_tfmprnodetrae_sel ,
                                          byte AV58Modalidadafipwwds_7_tfmprhorasextras_sel ,
                                          boolean A1024MprEsParcial ,
                                          boolean A1071MprNoDetrae ,
                                          boolean A1353MprHorasExtras )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[2];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT DISTINCT NULL AS MprHorasExtras, NULL AS MprNoDetrae, NULL AS MprEsParcial, NULL AS MprDescrip, MprCod FROM ( SELECT MprHorasExtras, MprNoDetrae, MprEsParcial," ;
      scmdbuf += " MprDescrip, MprCod FROM ModalidadAFIP" ;
      if ( ( AV53Modalidadafipwwds_2_tfmprcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Modalidadafipwwds_1_tfmprcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MprCod) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( AV53Modalidadafipwwds_2_tfmprcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Modalidadafipwwds_2_tfmprcod_sels, "MprCod IN (", ")")+")");
      }
      if ( ( AV55Modalidadafipwwds_4_tfmprdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Modalidadafipwwds_3_tfmprdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MprDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV55Modalidadafipwwds_4_tfmprdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Modalidadafipwwds_4_tfmprdescrip_sels, "MprDescrip IN (", ")")+")");
      }
      if ( AV56Modalidadafipwwds_5_tfmpresparcial_sel == 1 )
      {
         addWhere(sWhereString, "(MprEsParcial = TRUE)");
      }
      if ( AV56Modalidadafipwwds_5_tfmpresparcial_sel == 2 )
      {
         addWhere(sWhereString, "(MprEsParcial = FALSE)");
      }
      if ( AV57Modalidadafipwwds_6_tfmprnodetrae_sel == 1 )
      {
         addWhere(sWhereString, "(MprNoDetrae = TRUE)");
      }
      if ( AV57Modalidadafipwwds_6_tfmprnodetrae_sel == 2 )
      {
         addWhere(sWhereString, "(MprNoDetrae = FALSE)");
      }
      if ( AV58Modalidadafipwwds_7_tfmprhorasextras_sel == 1 )
      {
         addWhere(sWhereString, "(MprHorasExtras = TRUE)");
      }
      if ( AV58Modalidadafipwwds_7_tfmprhorasextras_sel == 2 )
      {
         addWhere(sWhereString, "(MprHorasExtras = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY MprCod" ;
      scmdbuf += ") DistinctT" ;
      scmdbuf += " ORDER BY MprCod" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P013D3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A18MprCod ,
                                          GXSimpleCollection<String> AV53Modalidadafipwwds_2_tfmprcod_sels ,
                                          String A303MprDescrip ,
                                          GXSimpleCollection<String> AV55Modalidadafipwwds_4_tfmprdescrip_sels ,
                                          int AV53Modalidadafipwwds_2_tfmprcod_sels_size ,
                                          String AV52Modalidadafipwwds_1_tfmprcod ,
                                          int AV55Modalidadafipwwds_4_tfmprdescrip_sels_size ,
                                          String AV54Modalidadafipwwds_3_tfmprdescrip ,
                                          byte AV56Modalidadafipwwds_5_tfmpresparcial_sel ,
                                          byte AV57Modalidadafipwwds_6_tfmprnodetrae_sel ,
                                          byte AV58Modalidadafipwwds_7_tfmprhorasextras_sel ,
                                          boolean A1024MprEsParcial ,
                                          boolean A1071MprNoDetrae ,
                                          boolean A1353MprHorasExtras )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[2];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT MprDescrip, MprHorasExtras, MprNoDetrae, MprEsParcial, MprCod FROM ModalidadAFIP" ;
      if ( ( AV53Modalidadafipwwds_2_tfmprcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Modalidadafipwwds_1_tfmprcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MprCod) like LOWER(?))");
      }
      else
      {
         GXv_int11[0] = (byte)(1) ;
      }
      if ( AV53Modalidadafipwwds_2_tfmprcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Modalidadafipwwds_2_tfmprcod_sels, "MprCod IN (", ")")+")");
      }
      if ( ( AV55Modalidadafipwwds_4_tfmprdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Modalidadafipwwds_3_tfmprdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MprDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV55Modalidadafipwwds_4_tfmprdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Modalidadafipwwds_4_tfmprdescrip_sels, "MprDescrip IN (", ")")+")");
      }
      if ( AV56Modalidadafipwwds_5_tfmpresparcial_sel == 1 )
      {
         addWhere(sWhereString, "(MprEsParcial = TRUE)");
      }
      if ( AV56Modalidadafipwwds_5_tfmpresparcial_sel == 2 )
      {
         addWhere(sWhereString, "(MprEsParcial = FALSE)");
      }
      if ( AV57Modalidadafipwwds_6_tfmprnodetrae_sel == 1 )
      {
         addWhere(sWhereString, "(MprNoDetrae = TRUE)");
      }
      if ( AV57Modalidadafipwwds_6_tfmprnodetrae_sel == 2 )
      {
         addWhere(sWhereString, "(MprNoDetrae = FALSE)");
      }
      if ( AV58Modalidadafipwwds_7_tfmprhorasextras_sel == 1 )
      {
         addWhere(sWhereString, "(MprHorasExtras = TRUE)");
      }
      if ( AV58Modalidadafipwwds_7_tfmprhorasextras_sel == 2 )
      {
         addWhere(sWhereString, "(MprHorasExtras = FALSE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY MprDescrip" ;
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
                  return conditional_P013D2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).byteValue() , ((Number) dynConstraints[10]).byteValue() , ((Boolean) dynConstraints[11]).booleanValue() , ((Boolean) dynConstraints[12]).booleanValue() , ((Boolean) dynConstraints[13]).booleanValue() );
            case 1 :
                  return conditional_P013D3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).byteValue() , ((Number) dynConstraints[9]).byteValue() , ((Number) dynConstraints[10]).byteValue() , ((Boolean) dynConstraints[11]).booleanValue() , ((Boolean) dynConstraints[12]).booleanValue() , ((Boolean) dynConstraints[13]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P013D2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P013D3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
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
                  stmt.setString(sIdx, (String)parms[2], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 400);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[2], 20);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[3], 400);
               }
               return;
      }
   }

}

