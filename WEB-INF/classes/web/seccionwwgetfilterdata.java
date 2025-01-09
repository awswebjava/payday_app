package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class seccionwwgetfilterdata extends GXProcedure
{
   public seccionwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( seccionwwgetfilterdata.class ), "" );
   }

   public seccionwwgetfilterdata( int remoteHandle ,
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
      seccionwwgetfilterdata.this.aP5 = new String[] {""};
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
      seccionwwgetfilterdata.this.AV17DDOName = aP0;
      seccionwwgetfilterdata.this.AV15SearchTxt = aP1;
      seccionwwgetfilterdata.this.AV16SearchTxtTo = aP2;
      seccionwwgetfilterdata.this.aP3 = aP3;
      seccionwwgetfilterdata.this.aP4 = aP4;
      seccionwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV39EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      seccionwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV39EmpCod = GXt_int1 ;
      GXt_int3 = AV38CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      seccionwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV38CliCod = GXt_int3 ;
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV23OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV25OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSeccion", GXv_boolean6) ;
      seccionwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV17DDOName), "DDO_SECCODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADSECCODIGOOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV17DDOName), "DDO_SECDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADSECDESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV17DDOName), "DDO_SECRELREF") == 0 )
         {
            /* Execute user subroutine: 'LOADSECRELREFOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV21OptionsJson = AV20Options.toJSonString(false) ;
      AV24OptionsDescJson = AV23OptionsDesc.toJSonString(false) ;
      AV26OptionIndexesJson = AV25OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV28Session.getValue("SeccionWWGridState"), "") == 0 )
      {
         AV30GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "SeccionWWGridState"), null, null);
      }
      else
      {
         AV30GridState.fromxml(AV28Session.getValue("SeccionWWGridState"), null, null);
      }
      AV48GXV1 = 1 ;
      while ( AV48GXV1 <= AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV31GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV30GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV48GXV1));
         if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECCODIGO") == 0 )
         {
            AV10TFSecCodigo = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECCODIGO_SEL") == 0 )
         {
            AV34TFSecCodigo_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV35TFSecCodigo_Sels.fromJSonString(AV34TFSecCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECDESCRIP") == 0 )
         {
            AV12TFSecDescrip = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECDESCRIP_SEL") == 0 )
         {
            AV36TFSecDescrip_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV37TFSecDescrip_Sels.fromJSonString(AV36TFSecDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECAPOOPC_SEL") == 0 )
         {
            AV45TFSecApoOpc_Sel = (byte)(GXutil.lval( AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECRELREF") == 0 )
         {
            AV43TFSecRelRef = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECRELREF_SEL") == 0 )
         {
            AV42TFSecRelRef_SelsJson = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV44TFSecRelRef_Sels.fromJSonString(AV42TFSecRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV41MenuOpcCod = AV31GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV48GXV1 = (int)(AV48GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADSECCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV10TFSecCodigo = AV15SearchTxt ;
      AV35TFSecCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV50Seccionwwds_1_tfseccodigo = AV10TFSecCodigo ;
      AV51Seccionwwds_2_tfseccodigo_sels = AV35TFSecCodigo_Sels ;
      AV52Seccionwwds_3_tfsecdescrip = AV12TFSecDescrip ;
      AV53Seccionwwds_4_tfsecdescrip_sels = AV37TFSecDescrip_Sels ;
      AV54Seccionwwds_5_tfsecapoopc_sel = AV45TFSecApoOpc_Sel ;
      AV55Seccionwwds_6_tfsecrelref = AV43TFSecRelRef ;
      AV56Seccionwwds_7_tfsecrelref_sels = AV44TFSecRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A13SecCodigo ,
                                           AV51Seccionwwds_2_tfseccodigo_sels ,
                                           A329SecDescrip ,
                                           AV53Seccionwwds_4_tfsecdescrip_sels ,
                                           A2015SecRelRef ,
                                           AV56Seccionwwds_7_tfsecrelref_sels ,
                                           Integer.valueOf(AV51Seccionwwds_2_tfseccodigo_sels.size()) ,
                                           AV50Seccionwwds_1_tfseccodigo ,
                                           Integer.valueOf(AV53Seccionwwds_4_tfsecdescrip_sels.size()) ,
                                           AV52Seccionwwds_3_tfsecdescrip ,
                                           Byte.valueOf(AV54Seccionwwds_5_tfsecapoopc_sel) ,
                                           Integer.valueOf(AV56Seccionwwds_7_tfsecrelref_sels.size()) ,
                                           AV55Seccionwwds_6_tfsecrelref ,
                                           Boolean.valueOf(A2308SecApoOpc) ,
                                           Integer.valueOf(AV38CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV50Seccionwwds_1_tfseccodigo = GXutil.padr( GXutil.rtrim( AV50Seccionwwds_1_tfseccodigo), 20, "%") ;
      lV52Seccionwwds_3_tfsecdescrip = GXutil.concat( GXutil.rtrim( AV52Seccionwwds_3_tfsecdescrip), "%", "") ;
      lV55Seccionwwds_6_tfsecrelref = GXutil.concat( GXutil.rtrim( AV55Seccionwwds_6_tfsecrelref), "%", "") ;
      /* Using cursor P006J2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV38CliCod), lV50Seccionwwds_1_tfseccodigo, lV52Seccionwwds_3_tfsecdescrip, lV55Seccionwwds_6_tfsecrelref});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk6J2 = false ;
         A3CliCod = P006J2_A3CliCod[0] ;
         A13SecCodigo = P006J2_A13SecCodigo[0] ;
         A2015SecRelRef = P006J2_A2015SecRelRef[0] ;
         A2308SecApoOpc = P006J2_A2308SecApoOpc[0] ;
         A329SecDescrip = P006J2_A329SecDescrip[0] ;
         AV27count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P006J2_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P006J2_A13SecCodigo[0], A13SecCodigo) == 0 ) )
         {
            brk6J2 = false ;
            AV27count = (long)(AV27count+1) ;
            brk6J2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A13SecCodigo)==0) )
         {
            AV19Option = A13SecCodigo ;
            AV20Options.add(AV19Option, 0);
            AV25OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV27count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6J2 )
         {
            brk6J2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADSECDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV12TFSecDescrip = AV15SearchTxt ;
      AV37TFSecDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV50Seccionwwds_1_tfseccodigo = AV10TFSecCodigo ;
      AV51Seccionwwds_2_tfseccodigo_sels = AV35TFSecCodigo_Sels ;
      AV52Seccionwwds_3_tfsecdescrip = AV12TFSecDescrip ;
      AV53Seccionwwds_4_tfsecdescrip_sels = AV37TFSecDescrip_Sels ;
      AV54Seccionwwds_5_tfsecapoopc_sel = AV45TFSecApoOpc_Sel ;
      AV55Seccionwwds_6_tfsecrelref = AV43TFSecRelRef ;
      AV56Seccionwwds_7_tfsecrelref_sels = AV44TFSecRelRef_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A13SecCodigo ,
                                           AV51Seccionwwds_2_tfseccodigo_sels ,
                                           A329SecDescrip ,
                                           AV53Seccionwwds_4_tfsecdescrip_sels ,
                                           A2015SecRelRef ,
                                           AV56Seccionwwds_7_tfsecrelref_sels ,
                                           Integer.valueOf(AV51Seccionwwds_2_tfseccodigo_sels.size()) ,
                                           AV50Seccionwwds_1_tfseccodigo ,
                                           Integer.valueOf(AV53Seccionwwds_4_tfsecdescrip_sels.size()) ,
                                           AV52Seccionwwds_3_tfsecdescrip ,
                                           Byte.valueOf(AV54Seccionwwds_5_tfsecapoopc_sel) ,
                                           Integer.valueOf(AV56Seccionwwds_7_tfsecrelref_sels.size()) ,
                                           AV55Seccionwwds_6_tfsecrelref ,
                                           Boolean.valueOf(A2308SecApoOpc) ,
                                           Integer.valueOf(AV38CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV50Seccionwwds_1_tfseccodigo = GXutil.padr( GXutil.rtrim( AV50Seccionwwds_1_tfseccodigo), 20, "%") ;
      lV52Seccionwwds_3_tfsecdescrip = GXutil.concat( GXutil.rtrim( AV52Seccionwwds_3_tfsecdescrip), "%", "") ;
      lV55Seccionwwds_6_tfsecrelref = GXutil.concat( GXutil.rtrim( AV55Seccionwwds_6_tfsecrelref), "%", "") ;
      /* Using cursor P006J3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV38CliCod), lV50Seccionwwds_1_tfseccodigo, lV52Seccionwwds_3_tfsecdescrip, lV55Seccionwwds_6_tfsecrelref});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk6J4 = false ;
         A3CliCod = P006J3_A3CliCod[0] ;
         A329SecDescrip = P006J3_A329SecDescrip[0] ;
         A2015SecRelRef = P006J3_A2015SecRelRef[0] ;
         A2308SecApoOpc = P006J3_A2308SecApoOpc[0] ;
         A13SecCodigo = P006J3_A13SecCodigo[0] ;
         AV27count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P006J3_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P006J3_A329SecDescrip[0], A329SecDescrip) == 0 ) )
         {
            brk6J4 = false ;
            A13SecCodigo = P006J3_A13SecCodigo[0] ;
            AV27count = (long)(AV27count+1) ;
            brk6J4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A329SecDescrip)==0) )
         {
            AV19Option = A329SecDescrip ;
            AV20Options.add(AV19Option, 0);
            AV25OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV27count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6J4 )
         {
            brk6J4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADSECRELREFOPTIONS' Routine */
      returnInSub = false ;
      AV43TFSecRelRef = AV15SearchTxt ;
      AV44TFSecRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV50Seccionwwds_1_tfseccodigo = AV10TFSecCodigo ;
      AV51Seccionwwds_2_tfseccodigo_sels = AV35TFSecCodigo_Sels ;
      AV52Seccionwwds_3_tfsecdescrip = AV12TFSecDescrip ;
      AV53Seccionwwds_4_tfsecdescrip_sels = AV37TFSecDescrip_Sels ;
      AV54Seccionwwds_5_tfsecapoopc_sel = AV45TFSecApoOpc_Sel ;
      AV55Seccionwwds_6_tfsecrelref = AV43TFSecRelRef ;
      AV56Seccionwwds_7_tfsecrelref_sels = AV44TFSecRelRef_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A13SecCodigo ,
                                           AV51Seccionwwds_2_tfseccodigo_sels ,
                                           A329SecDescrip ,
                                           AV53Seccionwwds_4_tfsecdescrip_sels ,
                                           A2015SecRelRef ,
                                           AV56Seccionwwds_7_tfsecrelref_sels ,
                                           Integer.valueOf(AV51Seccionwwds_2_tfseccodigo_sels.size()) ,
                                           AV50Seccionwwds_1_tfseccodigo ,
                                           Integer.valueOf(AV53Seccionwwds_4_tfsecdescrip_sels.size()) ,
                                           AV52Seccionwwds_3_tfsecdescrip ,
                                           Byte.valueOf(AV54Seccionwwds_5_tfsecapoopc_sel) ,
                                           Integer.valueOf(AV56Seccionwwds_7_tfsecrelref_sels.size()) ,
                                           AV55Seccionwwds_6_tfsecrelref ,
                                           Boolean.valueOf(A2308SecApoOpc) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV38CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV50Seccionwwds_1_tfseccodigo = GXutil.padr( GXutil.rtrim( AV50Seccionwwds_1_tfseccodigo), 20, "%") ;
      lV52Seccionwwds_3_tfsecdescrip = GXutil.concat( GXutil.rtrim( AV52Seccionwwds_3_tfsecdescrip), "%", "") ;
      lV55Seccionwwds_6_tfsecrelref = GXutil.concat( GXutil.rtrim( AV55Seccionwwds_6_tfsecrelref), "%", "") ;
      /* Using cursor P006J4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV38CliCod), lV50Seccionwwds_1_tfseccodigo, lV52Seccionwwds_3_tfsecdescrip, lV55Seccionwwds_6_tfsecrelref});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk6J6 = false ;
         A3CliCod = P006J4_A3CliCod[0] ;
         A2015SecRelRef = P006J4_A2015SecRelRef[0] ;
         A2308SecApoOpc = P006J4_A2308SecApoOpc[0] ;
         A329SecDescrip = P006J4_A329SecDescrip[0] ;
         A13SecCodigo = P006J4_A13SecCodigo[0] ;
         AV27count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P006J4_A2015SecRelRef[0], A2015SecRelRef) == 0 ) )
         {
            brk6J6 = false ;
            A3CliCod = P006J4_A3CliCod[0] ;
            A13SecCodigo = P006J4_A13SecCodigo[0] ;
            AV27count = (long)(AV27count+1) ;
            brk6J6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A2015SecRelRef)==0) )
         {
            AV19Option = A2015SecRelRef ;
            AV20Options.add(AV19Option, 0);
            AV25OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV27count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV20Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6J6 )
         {
            brk6J6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = seccionwwgetfilterdata.this.AV21OptionsJson;
      this.aP4[0] = seccionwwgetfilterdata.this.AV24OptionsDescJson;
      this.aP5[0] = seccionwwgetfilterdata.this.AV26OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21OptionsJson = "" ;
      AV24OptionsDescJson = "" ;
      AV26OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV20Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV23OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV25OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV28Session = httpContext.getWebSession();
      AV30GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV31GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV10TFSecCodigo = "" ;
      AV34TFSecCodigo_SelsJson = "" ;
      AV35TFSecCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12TFSecDescrip = "" ;
      AV36TFSecDescrip_SelsJson = "" ;
      AV37TFSecDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43TFSecRelRef = "" ;
      AV42TFSecRelRef_SelsJson = "" ;
      AV44TFSecRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV41MenuOpcCod = "" ;
      A13SecCodigo = "" ;
      AV50Seccionwwds_1_tfseccodigo = "" ;
      AV51Seccionwwds_2_tfseccodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52Seccionwwds_3_tfsecdescrip = "" ;
      AV53Seccionwwds_4_tfsecdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV55Seccionwwds_6_tfsecrelref = "" ;
      AV56Seccionwwds_7_tfsecrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV50Seccionwwds_1_tfseccodigo = "" ;
      lV52Seccionwwds_3_tfsecdescrip = "" ;
      lV55Seccionwwds_6_tfsecrelref = "" ;
      A329SecDescrip = "" ;
      A2015SecRelRef = "" ;
      P006J2_A3CliCod = new int[1] ;
      P006J2_A13SecCodigo = new String[] {""} ;
      P006J2_A2015SecRelRef = new String[] {""} ;
      P006J2_A2308SecApoOpc = new boolean[] {false} ;
      P006J2_A329SecDescrip = new String[] {""} ;
      AV19Option = "" ;
      P006J3_A3CliCod = new int[1] ;
      P006J3_A329SecDescrip = new String[] {""} ;
      P006J3_A2015SecRelRef = new String[] {""} ;
      P006J3_A2308SecApoOpc = new boolean[] {false} ;
      P006J3_A13SecCodigo = new String[] {""} ;
      P006J4_A3CliCod = new int[1] ;
      P006J4_A2015SecRelRef = new String[] {""} ;
      P006J4_A2308SecApoOpc = new boolean[] {false} ;
      P006J4_A329SecDescrip = new String[] {""} ;
      P006J4_A13SecCodigo = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.seccionwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P006J2_A3CliCod, P006J2_A13SecCodigo, P006J2_A2015SecRelRef, P006J2_A2308SecApoOpc, P006J2_A329SecDescrip
            }
            , new Object[] {
            P006J3_A3CliCod, P006J3_A329SecDescrip, P006J3_A2015SecRelRef, P006J3_A2308SecApoOpc, P006J3_A13SecCodigo
            }
            , new Object[] {
            P006J4_A3CliCod, P006J4_A2015SecRelRef, P006J4_A2308SecApoOpc, P006J4_A329SecDescrip, P006J4_A13SecCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV45TFSecApoOpc_Sel ;
   private byte AV54Seccionwwds_5_tfsecapoopc_sel ;
   private short AV39EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV38CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV48GXV1 ;
   private int AV51Seccionwwds_2_tfseccodigo_sels_size ;
   private int AV53Seccionwwds_4_tfsecdescrip_sels_size ;
   private int AV56Seccionwwds_7_tfsecrelref_sels_size ;
   private int A3CliCod ;
   private long AV27count ;
   private String AV10TFSecCodigo ;
   private String A13SecCodigo ;
   private String AV50Seccionwwds_1_tfseccodigo ;
   private String scmdbuf ;
   private String lV50Seccionwwds_1_tfseccodigo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean A2308SecApoOpc ;
   private boolean brk6J2 ;
   private boolean brk6J4 ;
   private boolean brk6J6 ;
   private String AV21OptionsJson ;
   private String AV24OptionsDescJson ;
   private String AV26OptionIndexesJson ;
   private String AV34TFSecCodigo_SelsJson ;
   private String AV36TFSecDescrip_SelsJson ;
   private String AV42TFSecRelRef_SelsJson ;
   private String AV17DDOName ;
   private String AV15SearchTxt ;
   private String AV16SearchTxtTo ;
   private String AV12TFSecDescrip ;
   private String AV43TFSecRelRef ;
   private String AV41MenuOpcCod ;
   private String AV52Seccionwwds_3_tfsecdescrip ;
   private String AV55Seccionwwds_6_tfsecrelref ;
   private String lV52Seccionwwds_3_tfsecdescrip ;
   private String lV55Seccionwwds_6_tfsecrelref ;
   private String A329SecDescrip ;
   private String A2015SecRelRef ;
   private String AV19Option ;
   private com.genexus.webpanels.WebSession AV28Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P006J2_A3CliCod ;
   private String[] P006J2_A13SecCodigo ;
   private String[] P006J2_A2015SecRelRef ;
   private boolean[] P006J2_A2308SecApoOpc ;
   private String[] P006J2_A329SecDescrip ;
   private int[] P006J3_A3CliCod ;
   private String[] P006J3_A329SecDescrip ;
   private String[] P006J3_A2015SecRelRef ;
   private boolean[] P006J3_A2308SecApoOpc ;
   private String[] P006J3_A13SecCodigo ;
   private int[] P006J4_A3CliCod ;
   private String[] P006J4_A2015SecRelRef ;
   private boolean[] P006J4_A2308SecApoOpc ;
   private String[] P006J4_A329SecDescrip ;
   private String[] P006J4_A13SecCodigo ;
   private GXSimpleCollection<String> AV35TFSecCodigo_Sels ;
   private GXSimpleCollection<String> AV51Seccionwwds_2_tfseccodigo_sels ;
   private GXSimpleCollection<String> AV20Options ;
   private GXSimpleCollection<String> AV23OptionsDesc ;
   private GXSimpleCollection<String> AV25OptionIndexes ;
   private GXSimpleCollection<String> AV37TFSecDescrip_Sels ;
   private GXSimpleCollection<String> AV44TFSecRelRef_Sels ;
   private GXSimpleCollection<String> AV53Seccionwwds_4_tfsecdescrip_sels ;
   private GXSimpleCollection<String> AV56Seccionwwds_7_tfsecrelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV30GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV31GridStateFilterValue ;
}

final  class seccionwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P006J2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A13SecCodigo ,
                                          GXSimpleCollection<String> AV51Seccionwwds_2_tfseccodigo_sels ,
                                          String A329SecDescrip ,
                                          GXSimpleCollection<String> AV53Seccionwwds_4_tfsecdescrip_sels ,
                                          String A2015SecRelRef ,
                                          GXSimpleCollection<String> AV56Seccionwwds_7_tfsecrelref_sels ,
                                          int AV51Seccionwwds_2_tfseccodigo_sels_size ,
                                          String AV50Seccionwwds_1_tfseccodigo ,
                                          int AV53Seccionwwds_4_tfsecdescrip_sels_size ,
                                          String AV52Seccionwwds_3_tfsecdescrip ,
                                          byte AV54Seccionwwds_5_tfsecapoopc_sel ,
                                          int AV56Seccionwwds_7_tfsecrelref_sels_size ,
                                          String AV55Seccionwwds_6_tfsecrelref ,
                                          boolean A2308SecApoOpc ,
                                          int AV38CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[4];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, SecCodigo, SecRelRef, SecApoOpc, SecDescrip FROM Seccion" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV51Seccionwwds_2_tfseccodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV50Seccionwwds_1_tfseccodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV51Seccionwwds_2_tfseccodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV51Seccionwwds_2_tfseccodigo_sels, "SecCodigo IN (", ")")+")");
      }
      if ( ( AV53Seccionwwds_4_tfsecdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Seccionwwds_3_tfsecdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV53Seccionwwds_4_tfsecdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Seccionwwds_4_tfsecdescrip_sels, "SecDescrip IN (", ")")+")");
      }
      if ( AV54Seccionwwds_5_tfsecapoopc_sel == 1 )
      {
         addWhere(sWhereString, "(SecApoOpc = TRUE)");
      }
      if ( AV54Seccionwwds_5_tfsecapoopc_sel == 2 )
      {
         addWhere(sWhereString, "(SecApoOpc = FALSE)");
      }
      if ( ( AV56Seccionwwds_7_tfsecrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Seccionwwds_6_tfsecrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV56Seccionwwds_7_tfsecrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Seccionwwds_7_tfsecrelref_sels, "SecRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, SecCodigo" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P006J3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A13SecCodigo ,
                                          GXSimpleCollection<String> AV51Seccionwwds_2_tfseccodigo_sels ,
                                          String A329SecDescrip ,
                                          GXSimpleCollection<String> AV53Seccionwwds_4_tfsecdescrip_sels ,
                                          String A2015SecRelRef ,
                                          GXSimpleCollection<String> AV56Seccionwwds_7_tfsecrelref_sels ,
                                          int AV51Seccionwwds_2_tfseccodigo_sels_size ,
                                          String AV50Seccionwwds_1_tfseccodigo ,
                                          int AV53Seccionwwds_4_tfsecdescrip_sels_size ,
                                          String AV52Seccionwwds_3_tfsecdescrip ,
                                          byte AV54Seccionwwds_5_tfsecapoopc_sel ,
                                          int AV56Seccionwwds_7_tfsecrelref_sels_size ,
                                          String AV55Seccionwwds_6_tfsecrelref ,
                                          boolean A2308SecApoOpc ,
                                          int AV38CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[4];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, SecDescrip, SecRelRef, SecApoOpc, SecCodigo FROM Seccion" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV51Seccionwwds_2_tfseccodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV50Seccionwwds_1_tfseccodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV51Seccionwwds_2_tfseccodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV51Seccionwwds_2_tfseccodigo_sels, "SecCodigo IN (", ")")+")");
      }
      if ( ( AV53Seccionwwds_4_tfsecdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Seccionwwds_3_tfsecdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV53Seccionwwds_4_tfsecdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Seccionwwds_4_tfsecdescrip_sels, "SecDescrip IN (", ")")+")");
      }
      if ( AV54Seccionwwds_5_tfsecapoopc_sel == 1 )
      {
         addWhere(sWhereString, "(SecApoOpc = TRUE)");
      }
      if ( AV54Seccionwwds_5_tfsecapoopc_sel == 2 )
      {
         addWhere(sWhereString, "(SecApoOpc = FALSE)");
      }
      if ( ( AV56Seccionwwds_7_tfsecrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Seccionwwds_6_tfsecrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV56Seccionwwds_7_tfsecrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Seccionwwds_7_tfsecrelref_sels, "SecRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, SecDescrip" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P006J4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A13SecCodigo ,
                                          GXSimpleCollection<String> AV51Seccionwwds_2_tfseccodigo_sels ,
                                          String A329SecDescrip ,
                                          GXSimpleCollection<String> AV53Seccionwwds_4_tfsecdescrip_sels ,
                                          String A2015SecRelRef ,
                                          GXSimpleCollection<String> AV56Seccionwwds_7_tfsecrelref_sels ,
                                          int AV51Seccionwwds_2_tfseccodigo_sels_size ,
                                          String AV50Seccionwwds_1_tfseccodigo ,
                                          int AV53Seccionwwds_4_tfsecdescrip_sels_size ,
                                          String AV52Seccionwwds_3_tfsecdescrip ,
                                          byte AV54Seccionwwds_5_tfsecapoopc_sel ,
                                          int AV56Seccionwwds_7_tfsecrelref_sels_size ,
                                          String AV55Seccionwwds_6_tfsecrelref ,
                                          boolean A2308SecApoOpc ,
                                          int A3CliCod ,
                                          int AV38CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[4];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT CliCod, SecRelRef, SecApoOpc, SecDescrip, SecCodigo FROM Seccion" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV51Seccionwwds_2_tfseccodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV50Seccionwwds_1_tfseccodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV51Seccionwwds_2_tfseccodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV51Seccionwwds_2_tfseccodigo_sels, "SecCodigo IN (", ")")+")");
      }
      if ( ( AV53Seccionwwds_4_tfsecdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Seccionwwds_3_tfsecdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV53Seccionwwds_4_tfsecdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Seccionwwds_4_tfsecdescrip_sels, "SecDescrip IN (", ")")+")");
      }
      if ( AV54Seccionwwds_5_tfsecapoopc_sel == 1 )
      {
         addWhere(sWhereString, "(SecApoOpc = TRUE)");
      }
      if ( AV54Seccionwwds_5_tfsecapoopc_sel == 2 )
      {
         addWhere(sWhereString, "(SecApoOpc = FALSE)");
      }
      if ( ( AV56Seccionwwds_7_tfsecrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV55Seccionwwds_6_tfsecrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV56Seccionwwds_7_tfsecrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV56Seccionwwds_7_tfsecrelref_sels, "SecRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SecRelRef" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
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
                  return conditional_P006J2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() );
            case 1 :
                  return conditional_P006J3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() );
            case 2 :
                  return conditional_P006J4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).byteValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] , ((Boolean) dynConstraints[13]).booleanValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006J2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006J3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006J4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.getBoolean(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
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
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[5], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 40);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[5], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 40);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[5], 20);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 40);
               }
               return;
      }
   }

}

