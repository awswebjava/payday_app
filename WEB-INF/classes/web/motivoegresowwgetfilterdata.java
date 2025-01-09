package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class motivoegresowwgetfilterdata extends GXProcedure
{
   public motivoegresowwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( motivoegresowwgetfilterdata.class ), "" );
   }

   public motivoegresowwgetfilterdata( int remoteHandle ,
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
      motivoegresowwgetfilterdata.this.aP5 = new String[] {""};
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
      motivoegresowwgetfilterdata.this.AV23DDOName = aP0;
      motivoegresowwgetfilterdata.this.AV21SearchTxt = aP1;
      motivoegresowwgetfilterdata.this.AV22SearchTxtTo = aP2;
      motivoegresowwgetfilterdata.this.aP3 = aP3;
      motivoegresowwgetfilterdata.this.aP4 = aP4;
      motivoegresowwgetfilterdata.this.aP5 = aP5;
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
      motivoegresowwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV40EmpCod = GXt_int1 ;
      GXt_int3 = AV41CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      motivoegresowwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV41CliCod = GXt_int3 ;
      AV26Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV29OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV31OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWMotivoEgreso", GXv_boolean6) ;
      motivoegresowwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV23DDOName), "DDO_MEGCODIGO") == 0 )
         {
            /* Execute user subroutine: 'LOADMEGCODIGOOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV23DDOName), "DDO_MEGDESCRIP") == 0 )
         {
            /* Execute user subroutine: 'LOADMEGDESCRIPOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV23DDOName), "DDO_MEGRELREF") == 0 )
         {
            /* Execute user subroutine: 'LOADMEGRELREFOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV27OptionsJson = AV26Options.toJSonString(false) ;
      AV30OptionsDescJson = AV29OptionsDesc.toJSonString(false) ;
      AV32OptionIndexesJson = AV31OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV34Session.getValue("MotivoEgresoWWGridState"), "") == 0 )
      {
         AV36GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "MotivoEgresoWWGridState"), null, null);
      }
      else
      {
         AV36GridState.fromxml(AV34Session.getValue("MotivoEgresoWWGridState"), null, null);
      }
      AV48GXV1 = 1 ;
      while ( AV48GXV1 <= AV36GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV37GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV36GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV48GXV1));
         if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGCODIGO") == 0 )
         {
            AV12TFMegCodigo = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGCODIGO_SEL") == 0 )
         {
            AV11TFMegCodigo_SelsJson = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV13TFMegCodigo_Sels.fromJSonString(AV11TFMegCodigo_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGDESCRIP") == 0 )
         {
            AV15TFMegDescrip = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGDESCRIP_SEL") == 0 )
         {
            AV14TFMegDescrip_SelsJson = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV16TFMegDescrip_Sels.fromJSonString(AV14TFMegDescrip_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGRELREF") == 0 )
         {
            AV44TFMegRelRef = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFMEGRELREF_SEL") == 0 )
         {
            AV43TFMegRelRef_SelsJson = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV45TFMegRelRef_Sels.fromJSonString(AV43TFMegRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV42MenuOpcCod = AV37GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV48GXV1 = (int)(AV48GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADMEGCODIGOOPTIONS' Routine */
      returnInSub = false ;
      AV12TFMegCodigo = AV21SearchTxt ;
      AV13TFMegCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV50Motivoegresowwds_1_tfmegcodigo = AV12TFMegCodigo ;
      AV51Motivoegresowwds_2_tfmegcodigo_sels = AV13TFMegCodigo_Sels ;
      AV52Motivoegresowwds_3_tfmegdescrip = AV15TFMegDescrip ;
      AV53Motivoegresowwds_4_tfmegdescrip_sels = AV16TFMegDescrip_Sels ;
      AV54Motivoegresowwds_5_tfmegrelref = AV44TFMegRelRef ;
      AV55Motivoegresowwds_6_tfmegrelref_sels = AV45TFMegRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A11MegCodigo ,
                                           AV51Motivoegresowwds_2_tfmegcodigo_sels ,
                                           A300MegDescrip ,
                                           AV53Motivoegresowwds_4_tfmegdescrip_sels ,
                                           A2017MegRelRef ,
                                           AV55Motivoegresowwds_6_tfmegrelref_sels ,
                                           Integer.valueOf(AV51Motivoegresowwds_2_tfmegcodigo_sels.size()) ,
                                           AV50Motivoegresowwds_1_tfmegcodigo ,
                                           Integer.valueOf(AV53Motivoegresowwds_4_tfmegdescrip_sels.size()) ,
                                           AV52Motivoegresowwds_3_tfmegdescrip ,
                                           Integer.valueOf(AV55Motivoegresowwds_6_tfmegrelref_sels.size()) ,
                                           AV54Motivoegresowwds_5_tfmegrelref ,
                                           Integer.valueOf(AV41CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT
                                           }
      });
      lV50Motivoegresowwds_1_tfmegcodigo = GXutil.padr( GXutil.rtrim( AV50Motivoegresowwds_1_tfmegcodigo), 20, "%") ;
      lV52Motivoegresowwds_3_tfmegdescrip = GXutil.concat( GXutil.rtrim( AV52Motivoegresowwds_3_tfmegdescrip), "%", "") ;
      lV54Motivoegresowwds_5_tfmegrelref = GXutil.concat( GXutil.rtrim( AV54Motivoegresowwds_5_tfmegrelref), "%", "") ;
      /* Using cursor P006K2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV41CliCod), lV50Motivoegresowwds_1_tfmegcodigo, lV52Motivoegresowwds_3_tfmegdescrip, lV54Motivoegresowwds_5_tfmegrelref});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk6K2 = false ;
         A3CliCod = P006K2_A3CliCod[0] ;
         A11MegCodigo = P006K2_A11MegCodigo[0] ;
         A2017MegRelRef = P006K2_A2017MegRelRef[0] ;
         A300MegDescrip = P006K2_A300MegDescrip[0] ;
         AV33count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P006K2_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P006K2_A11MegCodigo[0], A11MegCodigo) == 0 ) )
         {
            brk6K2 = false ;
            AV33count = (long)(AV33count+1) ;
            brk6K2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A11MegCodigo)==0) )
         {
            AV25Option = A11MegCodigo ;
            AV26Options.add(AV25Option, 0);
            AV31OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV33count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV26Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6K2 )
         {
            brk6K2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADMEGDESCRIPOPTIONS' Routine */
      returnInSub = false ;
      AV15TFMegDescrip = AV21SearchTxt ;
      AV16TFMegDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV50Motivoegresowwds_1_tfmegcodigo = AV12TFMegCodigo ;
      AV51Motivoegresowwds_2_tfmegcodigo_sels = AV13TFMegCodigo_Sels ;
      AV52Motivoegresowwds_3_tfmegdescrip = AV15TFMegDescrip ;
      AV53Motivoegresowwds_4_tfmegdescrip_sels = AV16TFMegDescrip_Sels ;
      AV54Motivoegresowwds_5_tfmegrelref = AV44TFMegRelRef ;
      AV55Motivoegresowwds_6_tfmegrelref_sels = AV45TFMegRelRef_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A11MegCodigo ,
                                           AV51Motivoegresowwds_2_tfmegcodigo_sels ,
                                           A300MegDescrip ,
                                           AV53Motivoegresowwds_4_tfmegdescrip_sels ,
                                           A2017MegRelRef ,
                                           AV55Motivoegresowwds_6_tfmegrelref_sels ,
                                           Integer.valueOf(AV51Motivoegresowwds_2_tfmegcodigo_sels.size()) ,
                                           AV50Motivoegresowwds_1_tfmegcodigo ,
                                           Integer.valueOf(AV53Motivoegresowwds_4_tfmegdescrip_sels.size()) ,
                                           AV52Motivoegresowwds_3_tfmegdescrip ,
                                           Integer.valueOf(AV55Motivoegresowwds_6_tfmegrelref_sels.size()) ,
                                           AV54Motivoegresowwds_5_tfmegrelref ,
                                           Integer.valueOf(AV41CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT
                                           }
      });
      lV50Motivoegresowwds_1_tfmegcodigo = GXutil.padr( GXutil.rtrim( AV50Motivoegresowwds_1_tfmegcodigo), 20, "%") ;
      lV52Motivoegresowwds_3_tfmegdescrip = GXutil.concat( GXutil.rtrim( AV52Motivoegresowwds_3_tfmegdescrip), "%", "") ;
      lV54Motivoegresowwds_5_tfmegrelref = GXutil.concat( GXutil.rtrim( AV54Motivoegresowwds_5_tfmegrelref), "%", "") ;
      /* Using cursor P006K3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV41CliCod), lV50Motivoegresowwds_1_tfmegcodigo, lV52Motivoegresowwds_3_tfmegdescrip, lV54Motivoegresowwds_5_tfmegrelref});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk6K4 = false ;
         A3CliCod = P006K3_A3CliCod[0] ;
         A300MegDescrip = P006K3_A300MegDescrip[0] ;
         A2017MegRelRef = P006K3_A2017MegRelRef[0] ;
         A11MegCodigo = P006K3_A11MegCodigo[0] ;
         AV33count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P006K3_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P006K3_A300MegDescrip[0], A300MegDescrip) == 0 ) )
         {
            brk6K4 = false ;
            A11MegCodigo = P006K3_A11MegCodigo[0] ;
            AV33count = (long)(AV33count+1) ;
            brk6K4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A300MegDescrip)==0) )
         {
            AV25Option = A300MegDescrip ;
            AV26Options.add(AV25Option, 0);
            AV31OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV33count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV26Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6K4 )
         {
            brk6K4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADMEGRELREFOPTIONS' Routine */
      returnInSub = false ;
      AV44TFMegRelRef = AV21SearchTxt ;
      AV45TFMegRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV50Motivoegresowwds_1_tfmegcodigo = AV12TFMegCodigo ;
      AV51Motivoegresowwds_2_tfmegcodigo_sels = AV13TFMegCodigo_Sels ;
      AV52Motivoegresowwds_3_tfmegdescrip = AV15TFMegDescrip ;
      AV53Motivoegresowwds_4_tfmegdescrip_sels = AV16TFMegDescrip_Sels ;
      AV54Motivoegresowwds_5_tfmegrelref = AV44TFMegRelRef ;
      AV55Motivoegresowwds_6_tfmegrelref_sels = AV45TFMegRelRef_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A11MegCodigo ,
                                           AV51Motivoegresowwds_2_tfmegcodigo_sels ,
                                           A300MegDescrip ,
                                           AV53Motivoegresowwds_4_tfmegdescrip_sels ,
                                           A2017MegRelRef ,
                                           AV55Motivoegresowwds_6_tfmegrelref_sels ,
                                           Integer.valueOf(AV51Motivoegresowwds_2_tfmegcodigo_sels.size()) ,
                                           AV50Motivoegresowwds_1_tfmegcodigo ,
                                           Integer.valueOf(AV53Motivoegresowwds_4_tfmegdescrip_sels.size()) ,
                                           AV52Motivoegresowwds_3_tfmegdescrip ,
                                           Integer.valueOf(AV55Motivoegresowwds_6_tfmegrelref_sels.size()) ,
                                           AV54Motivoegresowwds_5_tfmegrelref ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV41CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.INT
                                           }
      });
      lV50Motivoegresowwds_1_tfmegcodigo = GXutil.padr( GXutil.rtrim( AV50Motivoegresowwds_1_tfmegcodigo), 20, "%") ;
      lV52Motivoegresowwds_3_tfmegdescrip = GXutil.concat( GXutil.rtrim( AV52Motivoegresowwds_3_tfmegdescrip), "%", "") ;
      lV54Motivoegresowwds_5_tfmegrelref = GXutil.concat( GXutil.rtrim( AV54Motivoegresowwds_5_tfmegrelref), "%", "") ;
      /* Using cursor P006K4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV41CliCod), lV50Motivoegresowwds_1_tfmegcodigo, lV52Motivoegresowwds_3_tfmegdescrip, lV54Motivoegresowwds_5_tfmegrelref});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk6K6 = false ;
         A3CliCod = P006K4_A3CliCod[0] ;
         A2017MegRelRef = P006K4_A2017MegRelRef[0] ;
         A300MegDescrip = P006K4_A300MegDescrip[0] ;
         A11MegCodigo = P006K4_A11MegCodigo[0] ;
         AV33count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P006K4_A2017MegRelRef[0], A2017MegRelRef) == 0 ) )
         {
            brk6K6 = false ;
            A3CliCod = P006K4_A3CliCod[0] ;
            A11MegCodigo = P006K4_A11MegCodigo[0] ;
            AV33count = (long)(AV33count+1) ;
            brk6K6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A2017MegRelRef)==0) )
         {
            AV25Option = A2017MegRelRef ;
            AV26Options.add(AV25Option, 0);
            AV31OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV33count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV26Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6K6 )
         {
            brk6K6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   protected void cleanup( )
   {
      this.aP3[0] = motivoegresowwgetfilterdata.this.AV27OptionsJson;
      this.aP4[0] = motivoegresowwgetfilterdata.this.AV30OptionsDescJson;
      this.aP5[0] = motivoegresowwgetfilterdata.this.AV32OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV27OptionsJson = "" ;
      AV30OptionsDescJson = "" ;
      AV32OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV26Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV29OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV31OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV34Session = httpContext.getWebSession();
      AV36GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV37GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV12TFMegCodigo = "" ;
      AV11TFMegCodigo_SelsJson = "" ;
      AV13TFMegCodigo_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15TFMegDescrip = "" ;
      AV14TFMegDescrip_SelsJson = "" ;
      AV16TFMegDescrip_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV44TFMegRelRef = "" ;
      AV43TFMegRelRef_SelsJson = "" ;
      AV45TFMegRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV42MenuOpcCod = "" ;
      A11MegCodigo = "" ;
      AV50Motivoegresowwds_1_tfmegcodigo = "" ;
      AV51Motivoegresowwds_2_tfmegcodigo_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV52Motivoegresowwds_3_tfmegdescrip = "" ;
      AV53Motivoegresowwds_4_tfmegdescrip_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV54Motivoegresowwds_5_tfmegrelref = "" ;
      AV55Motivoegresowwds_6_tfmegrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV50Motivoegresowwds_1_tfmegcodigo = "" ;
      lV52Motivoegresowwds_3_tfmegdescrip = "" ;
      lV54Motivoegresowwds_5_tfmegrelref = "" ;
      A300MegDescrip = "" ;
      A2017MegRelRef = "" ;
      P006K2_A3CliCod = new int[1] ;
      P006K2_A11MegCodigo = new String[] {""} ;
      P006K2_A2017MegRelRef = new String[] {""} ;
      P006K2_A300MegDescrip = new String[] {""} ;
      AV25Option = "" ;
      P006K3_A3CliCod = new int[1] ;
      P006K3_A300MegDescrip = new String[] {""} ;
      P006K3_A2017MegRelRef = new String[] {""} ;
      P006K3_A11MegCodigo = new String[] {""} ;
      P006K4_A3CliCod = new int[1] ;
      P006K4_A2017MegRelRef = new String[] {""} ;
      P006K4_A300MegDescrip = new String[] {""} ;
      P006K4_A11MegCodigo = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.motivoegresowwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P006K2_A3CliCod, P006K2_A11MegCodigo, P006K2_A2017MegRelRef, P006K2_A300MegDescrip
            }
            , new Object[] {
            P006K3_A3CliCod, P006K3_A300MegDescrip, P006K3_A2017MegRelRef, P006K3_A11MegCodigo
            }
            , new Object[] {
            P006K4_A3CliCod, P006K4_A2017MegRelRef, P006K4_A300MegDescrip, P006K4_A11MegCodigo
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV40EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV41CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV48GXV1 ;
   private int AV51Motivoegresowwds_2_tfmegcodigo_sels_size ;
   private int AV53Motivoegresowwds_4_tfmegdescrip_sels_size ;
   private int AV55Motivoegresowwds_6_tfmegrelref_sels_size ;
   private int A3CliCod ;
   private long AV33count ;
   private String AV12TFMegCodigo ;
   private String A11MegCodigo ;
   private String AV50Motivoegresowwds_1_tfmegcodigo ;
   private String scmdbuf ;
   private String lV50Motivoegresowwds_1_tfmegcodigo ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk6K2 ;
   private boolean brk6K4 ;
   private boolean brk6K6 ;
   private String AV27OptionsJson ;
   private String AV30OptionsDescJson ;
   private String AV32OptionIndexesJson ;
   private String AV11TFMegCodigo_SelsJson ;
   private String AV14TFMegDescrip_SelsJson ;
   private String AV43TFMegRelRef_SelsJson ;
   private String AV23DDOName ;
   private String AV21SearchTxt ;
   private String AV22SearchTxtTo ;
   private String AV15TFMegDescrip ;
   private String AV44TFMegRelRef ;
   private String AV42MenuOpcCod ;
   private String AV52Motivoegresowwds_3_tfmegdescrip ;
   private String AV54Motivoegresowwds_5_tfmegrelref ;
   private String lV52Motivoegresowwds_3_tfmegdescrip ;
   private String lV54Motivoegresowwds_5_tfmegrelref ;
   private String A300MegDescrip ;
   private String A2017MegRelRef ;
   private String AV25Option ;
   private com.genexus.webpanels.WebSession AV34Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P006K2_A3CliCod ;
   private String[] P006K2_A11MegCodigo ;
   private String[] P006K2_A2017MegRelRef ;
   private String[] P006K2_A300MegDescrip ;
   private int[] P006K3_A3CliCod ;
   private String[] P006K3_A300MegDescrip ;
   private String[] P006K3_A2017MegRelRef ;
   private String[] P006K3_A11MegCodigo ;
   private int[] P006K4_A3CliCod ;
   private String[] P006K4_A2017MegRelRef ;
   private String[] P006K4_A300MegDescrip ;
   private String[] P006K4_A11MegCodigo ;
   private GXSimpleCollection<String> AV13TFMegCodigo_Sels ;
   private GXSimpleCollection<String> AV51Motivoegresowwds_2_tfmegcodigo_sels ;
   private GXSimpleCollection<String> AV26Options ;
   private GXSimpleCollection<String> AV29OptionsDesc ;
   private GXSimpleCollection<String> AV31OptionIndexes ;
   private GXSimpleCollection<String> AV16TFMegDescrip_Sels ;
   private GXSimpleCollection<String> AV45TFMegRelRef_Sels ;
   private GXSimpleCollection<String> AV53Motivoegresowwds_4_tfmegdescrip_sels ;
   private GXSimpleCollection<String> AV55Motivoegresowwds_6_tfmegrelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV36GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV37GridStateFilterValue ;
}

final  class motivoegresowwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P006K2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A11MegCodigo ,
                                          GXSimpleCollection<String> AV51Motivoegresowwds_2_tfmegcodigo_sels ,
                                          String A300MegDescrip ,
                                          GXSimpleCollection<String> AV53Motivoegresowwds_4_tfmegdescrip_sels ,
                                          String A2017MegRelRef ,
                                          GXSimpleCollection<String> AV55Motivoegresowwds_6_tfmegrelref_sels ,
                                          int AV51Motivoegresowwds_2_tfmegcodigo_sels_size ,
                                          String AV50Motivoegresowwds_1_tfmegcodigo ,
                                          int AV53Motivoegresowwds_4_tfmegdescrip_sels_size ,
                                          String AV52Motivoegresowwds_3_tfmegdescrip ,
                                          int AV55Motivoegresowwds_6_tfmegrelref_sels_size ,
                                          String AV54Motivoegresowwds_5_tfmegrelref ,
                                          int AV41CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[4];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, MegCodigo, MegRelRef, MegDescrip FROM MotivoEgreso" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV51Motivoegresowwds_2_tfmegcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV50Motivoegresowwds_1_tfmegcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MegCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV51Motivoegresowwds_2_tfmegcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV51Motivoegresowwds_2_tfmegcodigo_sels, "MegCodigo IN (", ")")+")");
      }
      if ( ( AV53Motivoegresowwds_4_tfmegdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Motivoegresowwds_3_tfmegdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MegDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV53Motivoegresowwds_4_tfmegdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Motivoegresowwds_4_tfmegdescrip_sels, "MegDescrip IN (", ")")+")");
      }
      if ( ( AV55Motivoegresowwds_6_tfmegrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Motivoegresowwds_5_tfmegrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MegRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV55Motivoegresowwds_6_tfmegrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Motivoegresowwds_6_tfmegrelref_sels, "MegRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, MegCodigo" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P006K3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A11MegCodigo ,
                                          GXSimpleCollection<String> AV51Motivoegresowwds_2_tfmegcodigo_sels ,
                                          String A300MegDescrip ,
                                          GXSimpleCollection<String> AV53Motivoegresowwds_4_tfmegdescrip_sels ,
                                          String A2017MegRelRef ,
                                          GXSimpleCollection<String> AV55Motivoegresowwds_6_tfmegrelref_sels ,
                                          int AV51Motivoegresowwds_2_tfmegcodigo_sels_size ,
                                          String AV50Motivoegresowwds_1_tfmegcodigo ,
                                          int AV53Motivoegresowwds_4_tfmegdescrip_sels_size ,
                                          String AV52Motivoegresowwds_3_tfmegdescrip ,
                                          int AV55Motivoegresowwds_6_tfmegrelref_sels_size ,
                                          String AV54Motivoegresowwds_5_tfmegrelref ,
                                          int AV41CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[4];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, MegDescrip, MegRelRef, MegCodigo FROM MotivoEgreso" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV51Motivoegresowwds_2_tfmegcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV50Motivoegresowwds_1_tfmegcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MegCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV51Motivoegresowwds_2_tfmegcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV51Motivoegresowwds_2_tfmegcodigo_sels, "MegCodigo IN (", ")")+")");
      }
      if ( ( AV53Motivoegresowwds_4_tfmegdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Motivoegresowwds_3_tfmegdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MegDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV53Motivoegresowwds_4_tfmegdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Motivoegresowwds_4_tfmegdescrip_sels, "MegDescrip IN (", ")")+")");
      }
      if ( ( AV55Motivoegresowwds_6_tfmegrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Motivoegresowwds_5_tfmegrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MegRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV55Motivoegresowwds_6_tfmegrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Motivoegresowwds_6_tfmegrelref_sels, "MegRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, MegDescrip" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P006K4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A11MegCodigo ,
                                          GXSimpleCollection<String> AV51Motivoegresowwds_2_tfmegcodigo_sels ,
                                          String A300MegDescrip ,
                                          GXSimpleCollection<String> AV53Motivoegresowwds_4_tfmegdescrip_sels ,
                                          String A2017MegRelRef ,
                                          GXSimpleCollection<String> AV55Motivoegresowwds_6_tfmegrelref_sels ,
                                          int AV51Motivoegresowwds_2_tfmegcodigo_sels_size ,
                                          String AV50Motivoegresowwds_1_tfmegcodigo ,
                                          int AV53Motivoegresowwds_4_tfmegdescrip_sels_size ,
                                          String AV52Motivoegresowwds_3_tfmegdescrip ,
                                          int AV55Motivoegresowwds_6_tfmegrelref_sels_size ,
                                          String AV54Motivoegresowwds_5_tfmegrelref ,
                                          int A3CliCod ,
                                          int AV41CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[4];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT CliCod, MegRelRef, MegDescrip, MegCodigo FROM MotivoEgreso" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV51Motivoegresowwds_2_tfmegcodigo_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV50Motivoegresowwds_1_tfmegcodigo)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MegCodigo) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV51Motivoegresowwds_2_tfmegcodigo_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV51Motivoegresowwds_2_tfmegcodigo_sels, "MegCodigo IN (", ")")+")");
      }
      if ( ( AV53Motivoegresowwds_4_tfmegdescrip_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Motivoegresowwds_3_tfmegdescrip)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MegDescrip) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV53Motivoegresowwds_4_tfmegdescrip_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Motivoegresowwds_4_tfmegdescrip_sels, "MegDescrip IN (", ")")+")");
      }
      if ( ( AV55Motivoegresowwds_6_tfmegrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Motivoegresowwds_5_tfmegrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(MegRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV55Motivoegresowwds_6_tfmegrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Motivoegresowwds_6_tfmegrelref_sels, "MegRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY MegRelRef" ;
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
                  return conditional_P006K2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() );
            case 1 :
                  return conditional_P006K3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() );
            case 2 :
                  return conditional_P006K4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006K2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006K3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006K4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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

