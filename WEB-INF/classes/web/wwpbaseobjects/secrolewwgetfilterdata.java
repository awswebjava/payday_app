package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secrolewwgetfilterdata extends GXProcedure
{
   public secrolewwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secrolewwgetfilterdata.class ), "" );
   }

   public secrolewwgetfilterdata( int remoteHandle ,
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
      secrolewwgetfilterdata.this.aP5 = new String[] {""};
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
      secrolewwgetfilterdata.this.AV16DDOName = aP0;
      secrolewwgetfilterdata.this.AV14SearchTxt = aP1;
      secrolewwgetfilterdata.this.AV15SearchTxtTo = aP2;
      secrolewwgetfilterdata.this.aP3 = aP3;
      secrolewwgetfilterdata.this.aP4 = aP4;
      secrolewwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV24OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecRole", GXv_boolean2) ;
      secrolewwgetfilterdata.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV46WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV46WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         if ( GXutil.strcmp(GXutil.upper( AV16DDOName), "DDO_SECROLENAME") == 0 )
         {
            /* Execute user subroutine: 'LOADSECROLENAMEOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV16DDOName), "DDO_SECROLEDESCRIPTION") == 0 )
         {
            /* Execute user subroutine: 'LOADSECROLEDESCRIPTIONOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV20OptionsJson = AV19Options.toJSonString(false) ;
      AV23OptionsDescJson = AV22OptionsDesc.toJSonString(false) ;
      AV25OptionIndexesJson = AV24OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV27Session.getValue("WWPBaseObjects.SecRoleWWGridState"), "") == 0 )
      {
         AV29GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WWPBaseObjects.SecRoleWWGridState"), null, null);
      }
      else
      {
         AV29GridState.fromxml(AV27Session.getValue("WWPBaseObjects.SecRoleWWGridState"), null, null);
      }
      AV55GXV1 = 1 ;
      while ( AV55GXV1 <= AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV30GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV29GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV55GXV1));
         if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLENAME") == 0 )
         {
            AV10TFSecRoleName = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLENAME_SEL") == 0 )
         {
            AV47TFSecRoleName_SelsJson = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV48TFSecRoleName_Sels.fromJSonString(AV47TFSecRoleName_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION") == 0 )
         {
            AV12TFSecRoleDescription = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION_SEL") == 0 )
         {
            AV49TFSecRoleDescription_SelsJson = AV30GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV50TFSecRoleDescription_Sels.fromJSonString(AV49TFSecRoleDescription_SelsJson, null);
         }
         AV55GXV1 = (int)(AV55GXV1+1) ;
      }
      if ( AV29GridState.getgxTv_SdtWWPGridState_Dynamicfilters().size() >= 1 )
      {
         AV31GridStateDynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)((web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)AV29GridState.getgxTv_SdtWWPGridState_Dynamicfilters().elementAt(-1+1));
         AV32DynamicFiltersSelector1 = AV31GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Selected() ;
         if ( GXutil.strcmp(AV32DynamicFiltersSelector1, "SECROLENAME") == 0 )
         {
            AV33DynamicFiltersOperator1 = AV31GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Operator() ;
            AV34SecRoleName1 = AV31GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value() ;
         }
         if ( AV29GridState.getgxTv_SdtWWPGridState_Dynamicfilters().size() >= 2 )
         {
            AV36DynamicFiltersEnabled2 = true ;
            AV31GridStateDynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)((web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)AV29GridState.getgxTv_SdtWWPGridState_Dynamicfilters().elementAt(-1+2));
            AV37DynamicFiltersSelector2 = AV31GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Selected() ;
            if ( GXutil.strcmp(AV37DynamicFiltersSelector2, "SECROLENAME") == 0 )
            {
               AV38DynamicFiltersOperator2 = AV31GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Operator() ;
               AV39SecRoleName2 = AV31GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value() ;
            }
            if ( AV29GridState.getgxTv_SdtWWPGridState_Dynamicfilters().size() >= 3 )
            {
               AV41DynamicFiltersEnabled3 = true ;
               AV31GridStateDynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)((web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)AV29GridState.getgxTv_SdtWWPGridState_Dynamicfilters().elementAt(-1+3));
               AV42DynamicFiltersSelector3 = AV31GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Selected() ;
               if ( GXutil.strcmp(AV42DynamicFiltersSelector3, "SECROLENAME") == 0 )
               {
                  AV43DynamicFiltersOperator3 = AV31GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Operator() ;
                  AV44SecRoleName3 = AV31GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value() ;
               }
            }
         }
      }
   }

   public void S121( )
   {
      /* 'LOADSECROLENAMEOPTIONS' Routine */
      returnInSub = false ;
      AV10TFSecRoleName = AV14SearchTxt ;
      AV48TFSecRoleName_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV57Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 = AV32DynamicFiltersSelector1 ;
      AV58Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 = AV33DynamicFiltersOperator1 ;
      AV59Wwpbaseobjects_secrolewwds_3_secrolename1 = AV34SecRoleName1 ;
      AV60Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 = AV36DynamicFiltersEnabled2 ;
      AV61Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 = AV37DynamicFiltersSelector2 ;
      AV62Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 = AV38DynamicFiltersOperator2 ;
      AV63Wwpbaseobjects_secrolewwds_7_secrolename2 = AV39SecRoleName2 ;
      AV64Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 = AV41DynamicFiltersEnabled3 ;
      AV65Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 = AV42DynamicFiltersSelector3 ;
      AV66Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 = AV43DynamicFiltersOperator3 ;
      AV67Wwpbaseobjects_secrolewwds_11_secrolename3 = AV44SecRoleName3 ;
      AV68Wwpbaseobjects_secrolewwds_12_tfsecrolename = AV10TFSecRoleName ;
      AV69Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels = AV48TFSecRoleName_Sels ;
      AV70Wwpbaseobjects_secrolewwds_14_tfsecroledescription = AV12TFSecRoleDescription ;
      AV71Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels = AV50TFSecRoleDescription_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A355SecRoleName ,
                                           AV69Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels ,
                                           A354SecRoleDescription ,
                                           AV71Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels ,
                                           AV57Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 ,
                                           Short.valueOf(AV58Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1) ,
                                           AV59Wwpbaseobjects_secrolewwds_3_secrolename1 ,
                                           Boolean.valueOf(AV60Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2) ,
                                           AV61Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 ,
                                           Short.valueOf(AV62Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2) ,
                                           AV63Wwpbaseobjects_secrolewwds_7_secrolename2 ,
                                           Boolean.valueOf(AV64Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3) ,
                                           AV65Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 ,
                                           Short.valueOf(AV66Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3) ,
                                           AV67Wwpbaseobjects_secrolewwds_11_secrolename3 ,
                                           Integer.valueOf(AV69Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels.size()) ,
                                           AV68Wwpbaseobjects_secrolewwds_12_tfsecrolename ,
                                           Integer.valueOf(AV71Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels.size()) ,
                                           AV70Wwpbaseobjects_secrolewwds_14_tfsecroledescription } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING
                                           }
      });
      lV59Wwpbaseobjects_secrolewwds_3_secrolename1 = GXutil.concat( GXutil.rtrim( AV59Wwpbaseobjects_secrolewwds_3_secrolename1), "%", "") ;
      lV59Wwpbaseobjects_secrolewwds_3_secrolename1 = GXutil.concat( GXutil.rtrim( AV59Wwpbaseobjects_secrolewwds_3_secrolename1), "%", "") ;
      lV63Wwpbaseobjects_secrolewwds_7_secrolename2 = GXutil.concat( GXutil.rtrim( AV63Wwpbaseobjects_secrolewwds_7_secrolename2), "%", "") ;
      lV63Wwpbaseobjects_secrolewwds_7_secrolename2 = GXutil.concat( GXutil.rtrim( AV63Wwpbaseobjects_secrolewwds_7_secrolename2), "%", "") ;
      lV67Wwpbaseobjects_secrolewwds_11_secrolename3 = GXutil.concat( GXutil.rtrim( AV67Wwpbaseobjects_secrolewwds_11_secrolename3), "%", "") ;
      lV67Wwpbaseobjects_secrolewwds_11_secrolename3 = GXutil.concat( GXutil.rtrim( AV67Wwpbaseobjects_secrolewwds_11_secrolename3), "%", "") ;
      lV68Wwpbaseobjects_secrolewwds_12_tfsecrolename = GXutil.concat( GXutil.rtrim( AV68Wwpbaseobjects_secrolewwds_12_tfsecrolename), "%", "") ;
      lV70Wwpbaseobjects_secrolewwds_14_tfsecroledescription = GXutil.concat( GXutil.rtrim( AV70Wwpbaseobjects_secrolewwds_14_tfsecroledescription), "%", "") ;
      /* Using cursor P001L2 */
      pr_default.execute(0, new Object[] {lV59Wwpbaseobjects_secrolewwds_3_secrolename1, lV59Wwpbaseobjects_secrolewwds_3_secrolename1, lV63Wwpbaseobjects_secrolewwds_7_secrolename2, lV63Wwpbaseobjects_secrolewwds_7_secrolename2, lV67Wwpbaseobjects_secrolewwds_11_secrolename3, lV67Wwpbaseobjects_secrolewwds_11_secrolename3, lV68Wwpbaseobjects_secrolewwds_12_tfsecrolename, lV70Wwpbaseobjects_secrolewwds_14_tfsecroledescription});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1L2 = false ;
         A355SecRoleName = P001L2_A355SecRoleName[0] ;
         A354SecRoleDescription = P001L2_A354SecRoleDescription[0] ;
         A65SecRoleId = P001L2_A65SecRoleId[0] ;
         AV26count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( GXutil.strcmp(P001L2_A355SecRoleName[0], A355SecRoleName) == 0 ) )
         {
            brk1L2 = false ;
            A65SecRoleId = P001L2_A65SecRoleId[0] ;
            AV26count = (long)(AV26count+1) ;
            brk1L2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A355SecRoleName)==0) )
         {
            AV18Option = A355SecRoleName ;
            AV19Options.add(AV18Option, 0);
            AV24OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV26count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1L2 )
         {
            brk1L2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADSECROLEDESCRIPTIONOPTIONS' Routine */
      returnInSub = false ;
      AV12TFSecRoleDescription = AV14SearchTxt ;
      AV50TFSecRoleDescription_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV57Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 = AV32DynamicFiltersSelector1 ;
      AV58Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 = AV33DynamicFiltersOperator1 ;
      AV59Wwpbaseobjects_secrolewwds_3_secrolename1 = AV34SecRoleName1 ;
      AV60Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 = AV36DynamicFiltersEnabled2 ;
      AV61Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 = AV37DynamicFiltersSelector2 ;
      AV62Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 = AV38DynamicFiltersOperator2 ;
      AV63Wwpbaseobjects_secrolewwds_7_secrolename2 = AV39SecRoleName2 ;
      AV64Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 = AV41DynamicFiltersEnabled3 ;
      AV65Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 = AV42DynamicFiltersSelector3 ;
      AV66Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 = AV43DynamicFiltersOperator3 ;
      AV67Wwpbaseobjects_secrolewwds_11_secrolename3 = AV44SecRoleName3 ;
      AV68Wwpbaseobjects_secrolewwds_12_tfsecrolename = AV10TFSecRoleName ;
      AV69Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels = AV48TFSecRoleName_Sels ;
      AV70Wwpbaseobjects_secrolewwds_14_tfsecroledescription = AV12TFSecRoleDescription ;
      AV71Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels = AV50TFSecRoleDescription_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A355SecRoleName ,
                                           AV69Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels ,
                                           A354SecRoleDescription ,
                                           AV71Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels ,
                                           AV57Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 ,
                                           Short.valueOf(AV58Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1) ,
                                           AV59Wwpbaseobjects_secrolewwds_3_secrolename1 ,
                                           Boolean.valueOf(AV60Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2) ,
                                           AV61Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 ,
                                           Short.valueOf(AV62Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2) ,
                                           AV63Wwpbaseobjects_secrolewwds_7_secrolename2 ,
                                           Boolean.valueOf(AV64Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3) ,
                                           AV65Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 ,
                                           Short.valueOf(AV66Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3) ,
                                           AV67Wwpbaseobjects_secrolewwds_11_secrolename3 ,
                                           Integer.valueOf(AV69Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels.size()) ,
                                           AV68Wwpbaseobjects_secrolewwds_12_tfsecrolename ,
                                           Integer.valueOf(AV71Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels.size()) ,
                                           AV70Wwpbaseobjects_secrolewwds_14_tfsecroledescription } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING
                                           }
      });
      lV59Wwpbaseobjects_secrolewwds_3_secrolename1 = GXutil.concat( GXutil.rtrim( AV59Wwpbaseobjects_secrolewwds_3_secrolename1), "%", "") ;
      lV59Wwpbaseobjects_secrolewwds_3_secrolename1 = GXutil.concat( GXutil.rtrim( AV59Wwpbaseobjects_secrolewwds_3_secrolename1), "%", "") ;
      lV63Wwpbaseobjects_secrolewwds_7_secrolename2 = GXutil.concat( GXutil.rtrim( AV63Wwpbaseobjects_secrolewwds_7_secrolename2), "%", "") ;
      lV63Wwpbaseobjects_secrolewwds_7_secrolename2 = GXutil.concat( GXutil.rtrim( AV63Wwpbaseobjects_secrolewwds_7_secrolename2), "%", "") ;
      lV67Wwpbaseobjects_secrolewwds_11_secrolename3 = GXutil.concat( GXutil.rtrim( AV67Wwpbaseobjects_secrolewwds_11_secrolename3), "%", "") ;
      lV67Wwpbaseobjects_secrolewwds_11_secrolename3 = GXutil.concat( GXutil.rtrim( AV67Wwpbaseobjects_secrolewwds_11_secrolename3), "%", "") ;
      lV68Wwpbaseobjects_secrolewwds_12_tfsecrolename = GXutil.concat( GXutil.rtrim( AV68Wwpbaseobjects_secrolewwds_12_tfsecrolename), "%", "") ;
      lV70Wwpbaseobjects_secrolewwds_14_tfsecroledescription = GXutil.concat( GXutil.rtrim( AV70Wwpbaseobjects_secrolewwds_14_tfsecroledescription), "%", "") ;
      /* Using cursor P001L3 */
      pr_default.execute(1, new Object[] {lV59Wwpbaseobjects_secrolewwds_3_secrolename1, lV59Wwpbaseobjects_secrolewwds_3_secrolename1, lV63Wwpbaseobjects_secrolewwds_7_secrolename2, lV63Wwpbaseobjects_secrolewwds_7_secrolename2, lV67Wwpbaseobjects_secrolewwds_11_secrolename3, lV67Wwpbaseobjects_secrolewwds_11_secrolename3, lV68Wwpbaseobjects_secrolewwds_12_tfsecrolename, lV70Wwpbaseobjects_secrolewwds_14_tfsecroledescription});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk1L4 = false ;
         A354SecRoleDescription = P001L3_A354SecRoleDescription[0] ;
         A355SecRoleName = P001L3_A355SecRoleName[0] ;
         A65SecRoleId = P001L3_A65SecRoleId[0] ;
         AV26count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( GXutil.strcmp(P001L3_A354SecRoleDescription[0], A354SecRoleDescription) == 0 ) )
         {
            brk1L4 = false ;
            A65SecRoleId = P001L3_A65SecRoleId[0] ;
            AV26count = (long)(AV26count+1) ;
            brk1L4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A354SecRoleDescription)==0) )
         {
            AV18Option = A354SecRoleDescription ;
            AV19Options.add(AV18Option, 0);
            AV24OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV26count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV19Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk1L4 )
         {
            brk1L4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   protected void cleanup( )
   {
      this.aP3[0] = secrolewwgetfilterdata.this.AV20OptionsJson;
      this.aP4[0] = secrolewwgetfilterdata.this.AV23OptionsDescJson;
      this.aP5[0] = secrolewwgetfilterdata.this.AV25OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV20OptionsJson = "" ;
      AV23OptionsDescJson = "" ;
      AV25OptionIndexesJson = "" ;
      AV19Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV22OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV24OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean2 = new boolean[1] ;
      AV46WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV27Session = httpContext.getWebSession();
      AV29GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV30GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV10TFSecRoleName = "" ;
      AV47TFSecRoleName_SelsJson = "" ;
      AV48TFSecRoleName_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12TFSecRoleDescription = "" ;
      AV49TFSecRoleDescription_SelsJson = "" ;
      AV50TFSecRoleDescription_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV31GridStateDynamicFilter = new web.wwpbaseobjects.SdtWWPGridState_DynamicFilter(remoteHandle, context);
      AV32DynamicFiltersSelector1 = "" ;
      AV34SecRoleName1 = "" ;
      AV37DynamicFiltersSelector2 = "" ;
      AV39SecRoleName2 = "" ;
      AV42DynamicFiltersSelector3 = "" ;
      AV44SecRoleName3 = "" ;
      A355SecRoleName = "" ;
      AV57Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 = "" ;
      AV59Wwpbaseobjects_secrolewwds_3_secrolename1 = "" ;
      AV61Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 = "" ;
      AV63Wwpbaseobjects_secrolewwds_7_secrolename2 = "" ;
      AV65Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 = "" ;
      AV67Wwpbaseobjects_secrolewwds_11_secrolename3 = "" ;
      AV68Wwpbaseobjects_secrolewwds_12_tfsecrolename = "" ;
      AV69Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV70Wwpbaseobjects_secrolewwds_14_tfsecroledescription = "" ;
      AV71Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV59Wwpbaseobjects_secrolewwds_3_secrolename1 = "" ;
      lV63Wwpbaseobjects_secrolewwds_7_secrolename2 = "" ;
      lV67Wwpbaseobjects_secrolewwds_11_secrolename3 = "" ;
      lV68Wwpbaseobjects_secrolewwds_12_tfsecrolename = "" ;
      lV70Wwpbaseobjects_secrolewwds_14_tfsecroledescription = "" ;
      A354SecRoleDescription = "" ;
      P001L2_A355SecRoleName = new String[] {""} ;
      P001L2_A354SecRoleDescription = new String[] {""} ;
      P001L2_A65SecRoleId = new short[1] ;
      AV18Option = "" ;
      P001L3_A354SecRoleDescription = new String[] {""} ;
      P001L3_A355SecRoleName = new String[] {""} ;
      P001L3_A65SecRoleId = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.secrolewwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P001L2_A355SecRoleName, P001L2_A354SecRoleDescription, P001L2_A65SecRoleId
            }
            , new Object[] {
            P001L3_A354SecRoleDescription, P001L3_A355SecRoleName, P001L3_A65SecRoleId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV33DynamicFiltersOperator1 ;
   private short AV38DynamicFiltersOperator2 ;
   private short AV43DynamicFiltersOperator3 ;
   private short AV58Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 ;
   private short AV62Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 ;
   private short AV66Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 ;
   private short A65SecRoleId ;
   private short Gx_err ;
   private int AV55GXV1 ;
   private int AV69Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size ;
   private int AV71Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size ;
   private long AV26count ;
   private String scmdbuf ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV36DynamicFiltersEnabled2 ;
   private boolean AV41DynamicFiltersEnabled3 ;
   private boolean AV60Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 ;
   private boolean AV64Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 ;
   private boolean brk1L2 ;
   private boolean brk1L4 ;
   private String AV20OptionsJson ;
   private String AV23OptionsDescJson ;
   private String AV25OptionIndexesJson ;
   private String AV47TFSecRoleName_SelsJson ;
   private String AV49TFSecRoleDescription_SelsJson ;
   private String AV16DDOName ;
   private String AV14SearchTxt ;
   private String AV15SearchTxtTo ;
   private String AV10TFSecRoleName ;
   private String AV12TFSecRoleDescription ;
   private String AV32DynamicFiltersSelector1 ;
   private String AV34SecRoleName1 ;
   private String AV37DynamicFiltersSelector2 ;
   private String AV39SecRoleName2 ;
   private String AV42DynamicFiltersSelector3 ;
   private String AV44SecRoleName3 ;
   private String A355SecRoleName ;
   private String AV57Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 ;
   private String AV59Wwpbaseobjects_secrolewwds_3_secrolename1 ;
   private String AV61Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 ;
   private String AV63Wwpbaseobjects_secrolewwds_7_secrolename2 ;
   private String AV65Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 ;
   private String AV67Wwpbaseobjects_secrolewwds_11_secrolename3 ;
   private String AV68Wwpbaseobjects_secrolewwds_12_tfsecrolename ;
   private String AV70Wwpbaseobjects_secrolewwds_14_tfsecroledescription ;
   private String lV59Wwpbaseobjects_secrolewwds_3_secrolename1 ;
   private String lV63Wwpbaseobjects_secrolewwds_7_secrolename2 ;
   private String lV67Wwpbaseobjects_secrolewwds_11_secrolename3 ;
   private String lV68Wwpbaseobjects_secrolewwds_12_tfsecrolename ;
   private String lV70Wwpbaseobjects_secrolewwds_14_tfsecroledescription ;
   private String A354SecRoleDescription ;
   private String AV18Option ;
   private com.genexus.webpanels.WebSession AV27Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P001L2_A355SecRoleName ;
   private String[] P001L2_A354SecRoleDescription ;
   private short[] P001L2_A65SecRoleId ;
   private String[] P001L3_A354SecRoleDescription ;
   private String[] P001L3_A355SecRoleName ;
   private short[] P001L3_A65SecRoleId ;
   private GXSimpleCollection<String> AV19Options ;
   private GXSimpleCollection<String> AV22OptionsDesc ;
   private GXSimpleCollection<String> AV24OptionIndexes ;
   private GXSimpleCollection<String> AV48TFSecRoleName_Sels ;
   private GXSimpleCollection<String> AV50TFSecRoleDescription_Sels ;
   private GXSimpleCollection<String> AV69Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels ;
   private GXSimpleCollection<String> AV71Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels ;
   private web.wwpbaseobjects.SdtWWPGridState AV29GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV30GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPGridState_DynamicFilter AV31GridStateDynamicFilter ;
   private web.wwpbaseobjects.SdtWWPContext AV46WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
}

final  class secrolewwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P001L2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A355SecRoleName ,
                                          GXSimpleCollection<String> AV69Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels ,
                                          String A354SecRoleDescription ,
                                          GXSimpleCollection<String> AV71Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels ,
                                          String AV57Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 ,
                                          short AV58Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 ,
                                          String AV59Wwpbaseobjects_secrolewwds_3_secrolename1 ,
                                          boolean AV60Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 ,
                                          String AV61Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 ,
                                          short AV62Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 ,
                                          String AV63Wwpbaseobjects_secrolewwds_7_secrolename2 ,
                                          boolean AV64Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 ,
                                          String AV65Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 ,
                                          short AV66Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 ,
                                          String AV67Wwpbaseobjects_secrolewwds_11_secrolename3 ,
                                          int AV69Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size ,
                                          String AV68Wwpbaseobjects_secrolewwds_12_tfsecrolename ,
                                          int AV71Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size ,
                                          String AV70Wwpbaseobjects_secrolewwds_14_tfsecroledescription )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[8];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT SecRoleName, SecRoleDescription, SecRoleId FROM SecRole" ;
      if ( ( GXutil.strcmp(AV57Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV58Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 == 0 ) && ( ! (GXutil.strcmp("", AV59Wwpbaseobjects_secrolewwds_3_secrolename1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      if ( ( GXutil.strcmp(AV57Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV58Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 == 1 ) && ( ! (GXutil.strcmp("", AV59Wwpbaseobjects_secrolewwds_3_secrolename1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[1] = (byte)(1) ;
      }
      if ( AV60Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 && ( GXutil.strcmp(AV61Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV62Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 == 0 ) && ( ! (GXutil.strcmp("", AV63Wwpbaseobjects_secrolewwds_7_secrolename2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int4[2] = (byte)(1) ;
      }
      if ( AV60Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 && ( GXutil.strcmp(AV61Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV62Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 == 1 ) && ( ! (GXutil.strcmp("", AV63Wwpbaseobjects_secrolewwds_7_secrolename2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[3] = (byte)(1) ;
      }
      if ( AV64Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 && ( GXutil.strcmp(AV65Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV66Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 == 0 ) && ( ! (GXutil.strcmp("", AV67Wwpbaseobjects_secrolewwds_11_secrolename3)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int4[4] = (byte)(1) ;
      }
      if ( AV64Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 && ( GXutil.strcmp(AV65Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV66Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 == 1 ) && ( ! (GXutil.strcmp("", AV67Wwpbaseobjects_secrolewwds_11_secrolename3)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      if ( ( AV69Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Wwpbaseobjects_secrolewwds_12_tfsecrolename)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( AV69Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels, "SecRoleName IN (", ")")+")");
      }
      if ( ( AV71Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV70Wwpbaseobjects_secrolewwds_14_tfsecroledescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleDescription) like LOWER(?))");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( AV71Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels, "SecRoleDescription IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SecRoleName" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P001L3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A355SecRoleName ,
                                          GXSimpleCollection<String> AV69Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels ,
                                          String A354SecRoleDescription ,
                                          GXSimpleCollection<String> AV71Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels ,
                                          String AV57Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 ,
                                          short AV58Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 ,
                                          String AV59Wwpbaseobjects_secrolewwds_3_secrolename1 ,
                                          boolean AV60Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 ,
                                          String AV61Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 ,
                                          short AV62Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 ,
                                          String AV63Wwpbaseobjects_secrolewwds_7_secrolename2 ,
                                          boolean AV64Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 ,
                                          String AV65Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 ,
                                          short AV66Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 ,
                                          String AV67Wwpbaseobjects_secrolewwds_11_secrolename3 ,
                                          int AV69Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size ,
                                          String AV68Wwpbaseobjects_secrolewwds_12_tfsecrolename ,
                                          int AV71Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size ,
                                          String AV70Wwpbaseobjects_secrolewwds_14_tfsecroledescription )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[8];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT SecRoleDescription, SecRoleName, SecRoleId FROM SecRole" ;
      if ( ( GXutil.strcmp(AV57Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV58Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 == 0 ) && ( ! (GXutil.strcmp("", AV59Wwpbaseobjects_secrolewwds_3_secrolename1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int7[0] = (byte)(1) ;
      }
      if ( ( GXutil.strcmp(AV57Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV58Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 == 1 ) && ( ! (GXutil.strcmp("", AV59Wwpbaseobjects_secrolewwds_3_secrolename1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int7[1] = (byte)(1) ;
      }
      if ( AV60Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 && ( GXutil.strcmp(AV61Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV62Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 == 0 ) && ( ! (GXutil.strcmp("", AV63Wwpbaseobjects_secrolewwds_7_secrolename2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int7[2] = (byte)(1) ;
      }
      if ( AV60Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 && ( GXutil.strcmp(AV61Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV62Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 == 1 ) && ( ! (GXutil.strcmp("", AV63Wwpbaseobjects_secrolewwds_7_secrolename2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int7[3] = (byte)(1) ;
      }
      if ( AV64Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 && ( GXutil.strcmp(AV65Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV66Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 == 0 ) && ( ! (GXutil.strcmp("", AV67Wwpbaseobjects_secrolewwds_11_secrolename3)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int7[4] = (byte)(1) ;
      }
      if ( AV64Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 && ( GXutil.strcmp(AV65Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV66Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 == 1 ) && ( ! (GXutil.strcmp("", AV67Wwpbaseobjects_secrolewwds_11_secrolename3)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int7[5] = (byte)(1) ;
      }
      if ( ( AV69Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV68Wwpbaseobjects_secrolewwds_12_tfsecrolename)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int7[6] = (byte)(1) ;
      }
      if ( AV69Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV69Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels, "SecRoleName IN (", ")")+")");
      }
      if ( ( AV71Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV70Wwpbaseobjects_secrolewwds_14_tfsecroledescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleDescription) like LOWER(?))");
      }
      else
      {
         GXv_int7[7] = (byte)(1) ;
      }
      if ( AV71Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV71Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels, "SecRoleDescription IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY SecRoleDescription" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
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
                  return conditional_P001L2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , (String)dynConstraints[6] , ((Boolean) dynConstraints[7]).booleanValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , (String)dynConstraints[10] , ((Boolean) dynConstraints[11]).booleanValue() , (String)dynConstraints[12] , ((Number) dynConstraints[13]).shortValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] );
            case 1 :
                  return conditional_P001L3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , (String)dynConstraints[6] , ((Boolean) dynConstraints[7]).booleanValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , (String)dynConstraints[10] , ((Boolean) dynConstraints[11]).booleanValue() , (String)dynConstraints[12] , ((Number) dynConstraints[13]).shortValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P001L2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P001L3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
                  stmt.setVarchar(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 40);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 40);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 120);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 40);
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[10], 40);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[11], 40);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[12], 40);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[13], 40);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[14], 40);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[15], 120);
               }
               return;
      }
   }

}

