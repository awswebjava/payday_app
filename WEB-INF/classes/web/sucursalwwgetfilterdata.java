package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class sucursalwwgetfilterdata extends GXProcedure
{
   public sucursalwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( sucursalwwgetfilterdata.class ), "" );
   }

   public sucursalwwgetfilterdata( int remoteHandle ,
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
      sucursalwwgetfilterdata.this.aP5 = new String[] {""};
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
      sucursalwwgetfilterdata.this.AV33DDOName = aP0;
      sucursalwwgetfilterdata.this.AV34SearchTxt = aP1;
      sucursalwwgetfilterdata.this.AV35SearchTxtTo = aP2;
      sucursalwwgetfilterdata.this.aP3 = aP3;
      sucursalwwgetfilterdata.this.aP4 = aP4;
      sucursalwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV40EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      sucursalwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV40EmpCod = GXt_int1 ;
      GXt_int3 = AV41CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      sucursalwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV41CliCod = GXt_int3 ;
      AV23Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV26OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSucursal", GXv_boolean6) ;
      sucursalwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_SUCCODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADSUCCODIGOOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV33DDOName), "DDO_SUCDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADSUCDESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV36OptionsJson = AV23Options.toJSonString(false) ;
      AV37OptionsDescJson = AV25OptionsDesc.toJSonString(false) ;
      AV38OptionIndexesJson = AV26OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV28Session.getValue("SucursalWWGridState"), "") == 0 )
      {
         AV30GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "SucursalWWGridState"), null, null);
      }
      else
      {
         AV30GridState.fromxml(AV28Session.getValue("SucursalWWGridState"), null, null);
      }
      AV44GXV1 = 1 ;
      while ( AV44GXV1 <= AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV31GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV44GXV1));
         if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFCLICOD") == 0 )
         {
            AV11TFCliCod = (int)(GXutil.lval( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV12TFCliCod_To = (int)(GXutil.lval( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFEMPCOD") == 0 )
         {
            AV13TFEmpCod = (short)(GXutil.lval( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
            AV14TFEmpCod_To = (short)(GXutil.lval( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Valueto())) ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSUCCODIGO") == 0 )
         {
            AV16TFSucCodigo = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSUCCODIGO_SEL") == 0 )
         {
            AV15TFSucCodigo_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV17TFSucCodigo_Sels.fromJSonString(AV15TFSucCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSUCDESCRIP") == 0 )
         {
            AV19TFSucDescrip = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSUCDESCRIP_SEL") == 0 )
         {
            AV18TFSucDescrip_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV20TFSucDescrip_Sels.fromJSonString(AV18TFSucDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV39MenuOpcCod = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV44GXV1 = (int)(AV44GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSUCCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV16TFSucCodigo = AV34SearchTxt ;
      AV17TFSucCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV46Sucursalwwds_1_tfclicod = AV11TFCliCod ;
      AV47Sucursalwwds_2_tfclicod_to = AV12TFCliCod_To ;
      AV48Sucursalwwds_3_tfempcod = AV13TFEmpCod ;
      AV49Sucursalwwds_4_tfempcod_to = AV14TFEmpCod_To ;
      AV50Sucursalwwds_5_tfsuccodigo = AV16TFSucCodigo ;
      AV51Sucursalwwds_6_tfsuccodigo_sels = AV17TFSucCodigo_Sels ;
      AV52Sucursalwwds_7_tfsucdescrip = AV19TFSucDescrip ;
      AV53Sucursalwwds_8_tfsucdescrip_sels = AV20TFSucDescrip_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A1243SucCodigo ,
                                           AV51Sucursalwwds_6_tfsuccodigo_sels ,
                                           A1244SucDescrip ,
                                           AV53Sucursalwwds_8_tfsucdescrip_sels ,
                                           Integer.valueOf(AV46Sucursalwwds_1_tfclicod) ,
                                           Integer.valueOf(AV47Sucursalwwds_2_tfclicod_to) ,
                                           Short.valueOf(AV48Sucursalwwds_3_tfempcod) ,
                                           Short.valueOf(AV49Sucursalwwds_4_tfempcod_to) ,
                                           Integer.valueOf(AV51Sucursalwwds_6_tfsuccodigo_sels.size()) ,
                                           AV50Sucursalwwds_5_tfsuccodigo ,
                                           Integer.valueOf(AV53Sucursalwwds_8_tfsucdescrip_sels.size()) ,
                                           AV52Sucursalwwds_7_tfsucdescrip ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(AV41CliCod) ,
                                           Short.valueOf(AV40EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV50Sucursalwwds_5_tfsuccodigo = GXutil.padr( GXutil.rtrim( AV50Sucursalwwds_5_tfsuccodigo), 20, "%") ;
      lV52Sucursalwwds_7_tfsucdescrip = GXutil.concat( GXutil.rtrim( AV52Sucursalwwds_7_tfsucdescrip), "%", "") ;
      /* Using cursor P02KQ2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV41CliCod), Short.valueOf(AV40EmpCod), Integer.valueOf(AV46Sucursalwwds_1_tfclicod), Integer.valueOf(AV47Sucursalwwds_2_tfclicod_to), Short.valueOf(AV48Sucursalwwds_3_tfempcod), Short.valueOf(AV49Sucursalwwds_4_tfempcod_to), lV50Sucursalwwds_5_tfsuccodigo, lV52Sucursalwwds_7_tfsucdescrip});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk2KQ2 = false ;
         A1EmpCod = P02KQ2_A1EmpCod[0] ;
         A3CliCod = P02KQ2_A3CliCod[0] ;
         A1243SucCodigo = P02KQ2_A1243SucCodigo[0] ;
         A1244SucDescrip = P02KQ2_A1244SucDescrip[0] ;
         AV27count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P02KQ2_A3CliCod[0] == A3CliCod ) && ( P02KQ2_A1EmpCod[0] == A1EmpCod ) && ( GXutil.strcmp(P02KQ2_A1243SucCodigo[0], A1243SucCodigo) == 0 ) )
         {
            brk2KQ2 = false ;
            AV27count = (long)(AV27count+1) ;
            brk2KQ2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A1243SucCodigo)==0) )
         {
            AV22Option = A1243SucCodigo ;
            AV23Options.add(AV22Option, 0);
            AV26OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV27count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV23Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2KQ2 )
         {
            brk2KQ2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADSUCDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV19TFSucDescrip = AV34SearchTxt ;
      AV20TFSucDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV46Sucursalwwds_1_tfclicod = AV11TFCliCod ;
      AV47Sucursalwwds_2_tfclicod_to = AV12TFCliCod_To ;
      AV48Sucursalwwds_3_tfempcod = AV13TFEmpCod ;
      AV49Sucursalwwds_4_tfempcod_to = AV14TFEmpCod_To ;
      AV50Sucursalwwds_5_tfsuccodigo = AV16TFSucCodigo ;
      AV51Sucursalwwds_6_tfsuccodigo_sels = AV17TFSucCodigo_Sels ;
      AV52Sucursalwwds_7_tfsucdescrip = AV19TFSucDescrip ;
      AV53Sucursalwwds_8_tfsucdescrip_sels = AV20TFSucDescrip_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A1243SucCodigo ,
                                           AV51Sucursalwwds_6_tfsuccodigo_sels ,
                                           A1244SucDescrip ,
                                           AV53Sucursalwwds_8_tfsucdescrip_sels ,
                                           Integer.valueOf(AV46Sucursalwwds_1_tfclicod) ,
                                           Integer.valueOf(AV47Sucursalwwds_2_tfclicod_to) ,
                                           Short.valueOf(AV48Sucursalwwds_3_tfempcod) ,
                                           Short.valueOf(AV49Sucursalwwds_4_tfempcod_to) ,
                                           Integer.valueOf(AV51Sucursalwwds_6_tfsuccodigo_sels.size()) ,
                                           AV50Sucursalwwds_5_tfsuccodigo ,
                                           Integer.valueOf(AV53Sucursalwwds_8_tfsucdescrip_sels.size()) ,
                                           AV52Sucursalwwds_7_tfsucdescrip ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(AV41CliCod) ,
                                           Short.valueOf(AV40EmpCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      lV50Sucursalwwds_5_tfsuccodigo = GXutil.padr( GXutil.rtrim( AV50Sucursalwwds_5_tfsuccodigo), 20, "%") ;
      lV52Sucursalwwds_7_tfsucdescrip = GXutil.concat( GXutil.rtrim( AV52Sucursalwwds_7_tfsucdescrip), "%", "") ;
      /* Using cursor P02KQ3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV41CliCod), Short.valueOf(AV40EmpCod), Integer.valueOf(AV46Sucursalwwds_1_tfclicod), Integer.valueOf(AV47Sucursalwwds_2_tfclicod_to), Short.valueOf(AV48Sucursalwwds_3_tfempcod), Short.valueOf(AV49Sucursalwwds_4_tfempcod_to), lV50Sucursalwwds_5_tfsuccodigo, lV52Sucursalwwds_7_tfsucdescrip});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk2KQ4 = false ;
         A3CliCod = P02KQ3_A3CliCod[0] ;
         A1EmpCod = P02KQ3_A1EmpCod[0] ;
         A1244SucDescrip = P02KQ3_A1244SucDescrip[0] ;
         A1243SucCodigo = P02KQ3_A1243SucCodigo[0] ;
         AV27count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P02KQ3_A1244SucDescrip[0], A1244SucDescrip) == 0 ) )
         {
            brk2KQ4 = false ;
            A3CliCod = P02KQ3_A3CliCod[0] ;
            A1EmpCod = P02KQ3_A1EmpCod[0] ;
            A1243SucCodigo = P02KQ3_A1243SucCodigo[0] ;
            AV27count = (long)(AV27count+1) ;
            brk2KQ4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A1244SucDescrip)==0) )
         {
            AV22Option = A1244SucDescrip ;
            AV23Options.add(AV22Option, 0);
            AV26OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV27count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV23Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk2KQ4 )
         {
            brk2KQ4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = sucursalwwgetfilterdata.this.AV36OptionsJson;
      this.aP4[0] = sucursalwwgetfilterdata.this.AV37OptionsDescJson;
      this.aP5[0] = sucursalwwgetfilterdata.this.AV38OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV36OptionsJson = "" ;
      AV37OptionsDescJson = "" ;
      AV38OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV23Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV28Session = httpContext.getWebSession();
      AV30GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV31GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV16TFSucCodigo = "" ;
      AV15TFSucCodigo_SelsJson = "" ;
      AV17TFSucCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV19TFSucDescrip = "" ;
      AV18TFSucDescrip_SelsJson = "" ;
      AV20TFSucDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV39MenuOpcCod = "" ;
      A1243SucCodigo = "" ;
      AV50Sucursalwwds_5_tfsuccodigo = "" ;
      AV51Sucursalwwds_6_tfsuccodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52Sucursalwwds_7_tfsucdescrip = "" ;
      AV53Sucursalwwds_8_tfsucdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV50Sucursalwwds_5_tfsuccodigo = "" ;
      lV52Sucursalwwds_7_tfsucdescrip = "" ;
      A1244SucDescrip = "" ;
      P02KQ2_A1EmpCod = new short[1] ;
      P02KQ2_A3CliCod = new int[1] ;
      P02KQ2_A1243SucCodigo = new String[] {""} ;
      P02KQ2_A1244SucDescrip = new String[] {""} ;
      AV22Option = "" ;
      P02KQ3_A3CliCod = new int[1] ;
      P02KQ3_A1EmpCod = new short[1] ;
      P02KQ3_A1244SucDescrip = new String[] {""} ;
      P02KQ3_A1243SucCodigo = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.sucursalwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P02KQ2_A1EmpCod, P02KQ2_A3CliCod, P02KQ2_A1243SucCodigo, P02KQ2_A1244SucDescrip
            }
            , new Object[] {
            P02KQ3_A3CliCod, P02KQ3_A1EmpCod, P02KQ3_A1244SucDescrip, P02KQ3_A1243SucCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV40EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short AV13TFEmpCod ;
   private short AV14TFEmpCod_To ;
   private short AV48Sucursalwwds_3_tfempcod ;
   private short AV49Sucursalwwds_4_tfempcod_to ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV41CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV44GXV1 ;
   private int AV11TFCliCod ;
   private int AV12TFCliCod_To ;
   private int AV46Sucursalwwds_1_tfclicod ;
   private int AV47Sucursalwwds_2_tfclicod_to ;
   private int AV51Sucursalwwds_6_tfsuccodigo_sels_size ;
   private int AV53Sucursalwwds_8_tfsucdescrip_sels_size ;
   private int A3CliCod ;
   private long AV27count ;
   private String AV16TFSucCodigo ;
   private String A1243SucCodigo ;
   private String AV50Sucursalwwds_5_tfsuccodigo ;
   private String scmdbuf ;
   private String lV50Sucursalwwds_5_tfsuccodigo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk2KQ2 ;
   private boolean brk2KQ4 ;
   private String AV36OptionsJson ;
   private String AV37OptionsDescJson ;
   private String AV38OptionIndexesJson ;
   private String AV15TFSucCodigo_SelsJson ;
   private String AV18TFSucDescrip_SelsJson ;
   private String AV33DDOName ;
   private String AV34SearchTxt ;
   private String AV35SearchTxtTo ;
   private String AV19TFSucDescrip ;
   private String AV39MenuOpcCod ;
   private String AV52Sucursalwwds_7_tfsucdescrip ;
   private String lV52Sucursalwwds_7_tfsucdescrip ;
   private String A1244SucDescrip ;
   private String AV22Option ;
   private com.genexus.webpanels.WebSession AV28Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private short[] P02KQ2_A1EmpCod ;
   private int[] P02KQ2_A3CliCod ;
   private String[] P02KQ2_A1243SucCodigo ;
   private String[] P02KQ2_A1244SucDescrip ;
   private int[] P02KQ3_A3CliCod ;
   private short[] P02KQ3_A1EmpCod ;
   private String[] P02KQ3_A1244SucDescrip ;
   private String[] P02KQ3_A1243SucCodigo ;
   private GXSimpleCollection<String> AV17TFSucCodigo_Sels ;
   private GXSimpleCollection<String> AV51Sucursalwwds_6_tfsuccodigo_sels ;
   private GXSimpleCollection<String> AV23Options ;
   private GXSimpleCollection<String> AV25OptionsDesc ;
   private GXSimpleCollection<String> AV26OptionIndexes ;
   private GXSimpleCollection<String> AV20TFSucDescrip_Sels ;
   private GXSimpleCollection<String> AV53Sucursalwwds_8_tfsucdescrip_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV30GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV31GridStateFilterValue ;
}

final  class sucursalwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02KQ2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1243SucCodigo ,
                                          GXSimpleCollection<String> AV51Sucursalwwds_6_tfsuccodigo_sels ,
                                          String A1244SucDescrip ,
                                          GXSimpleCollection<String> AV53Sucursalwwds_8_tfsucdescrip_sels ,
                                          int AV46Sucursalwwds_1_tfclicod ,
                                          int AV47Sucursalwwds_2_tfclicod_to ,
                                          short AV48Sucursalwwds_3_tfempcod ,
                                          short AV49Sucursalwwds_4_tfempcod_to ,
                                          int AV51Sucursalwwds_6_tfsuccodigo_sels_size ,
                                          String AV50Sucursalwwds_5_tfsuccodigo ,
                                          int AV53Sucursalwwds_8_tfsucdescrip_sels_size ,
                                          String AV52Sucursalwwds_7_tfsucdescrip ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int AV41CliCod ,
                                          short AV40EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[8];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT EmpCod, CliCod, SucCodigo, SucDescrip FROM Sucursal" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ?)");
      if ( ! (0==AV46Sucursalwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( ! (0==AV47Sucursalwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( ! (0==AV48Sucursalwwds_3_tfempcod) )
      {
         addWhere(sWhereString, "(EmpCod >= ?)");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( ! (0==AV49Sucursalwwds_4_tfempcod_to) )
      {
         addWhere(sWhereString, "(EmpCod <= ?)");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ( AV51Sucursalwwds_6_tfsuccodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV50Sucursalwwds_5_tfsuccodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SucCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( AV51Sucursalwwds_6_tfsuccodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV51Sucursalwwds_6_tfsuccodigo_sels, "SucCodigo IN (", ")")+")");
      }
      if ( ( AV53Sucursalwwds_8_tfsucdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Sucursalwwds_7_tfsucdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SucDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( AV53Sucursalwwds_8_tfsucdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Sucursalwwds_8_tfsucdescrip_sels, "SucDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, SucCodigo" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P02KQ3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A1243SucCodigo ,
                                          GXSimpleCollection<String> AV51Sucursalwwds_6_tfsuccodigo_sels ,
                                          String A1244SucDescrip ,
                                          GXSimpleCollection<String> AV53Sucursalwwds_8_tfsucdescrip_sels ,
                                          int AV46Sucursalwwds_1_tfclicod ,
                                          int AV47Sucursalwwds_2_tfclicod_to ,
                                          short AV48Sucursalwwds_3_tfempcod ,
                                          short AV49Sucursalwwds_4_tfempcod_to ,
                                          int AV51Sucursalwwds_6_tfsuccodigo_sels_size ,
                                          String AV50Sucursalwwds_5_tfsuccodigo ,
                                          int AV53Sucursalwwds_8_tfsucdescrip_sels_size ,
                                          String AV52Sucursalwwds_7_tfsucdescrip ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int AV41CliCod ,
                                          short AV40EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[8];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, SucDescrip, SucCodigo FROM Sucursal" ;
      addWhere(sWhereString, "(CliCod = ?)");
      addWhere(sWhereString, "(EmpCod = ?)");
      if ( ! (0==AV46Sucursalwwds_1_tfclicod) )
      {
         addWhere(sWhereString, "(CliCod >= ?)");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( ! (0==AV47Sucursalwwds_2_tfclicod_to) )
      {
         addWhere(sWhereString, "(CliCod <= ?)");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( ! (0==AV48Sucursalwwds_3_tfempcod) )
      {
         addWhere(sWhereString, "(EmpCod >= ?)");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( ! (0==AV49Sucursalwwds_4_tfempcod_to) )
      {
         addWhere(sWhereString, "(EmpCod <= ?)");
      }
      else
      {
         GXv_int11[5] = (byte)(1) ;
      }
      if ( ( AV51Sucursalwwds_6_tfsuccodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV50Sucursalwwds_5_tfsuccodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SucCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int11[6] = (byte)(1) ;
      }
      if ( AV51Sucursalwwds_6_tfsuccodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV51Sucursalwwds_6_tfsuccodigo_sels, "SucCodigo IN (", ")")+")");
      }
      if ( ( AV53Sucursalwwds_8_tfsucdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Sucursalwwds_7_tfsucdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SucDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[7] = (byte)(1) ;
      }
      if ( AV53Sucursalwwds_8_tfsucdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Sucursalwwds_8_tfsucdescrip_sels, "SucDescrip IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SucDescrip" ;
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
                  return conditional_P02KQ2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() );
            case 1 :
                  return conditional_P02KQ3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).shortValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02KQ2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P02KQ3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
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
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 20);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 30);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 20);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 30);
               }
               return;
      }
   }

}

