package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class paramwwgetfilterdata extends GXProcedure
{
   public paramwwgetfilterdata( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( paramwwgetfilterdata.class ), "" );
   }

   public paramwwgetfilterdata( int remoteHandle ,
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
      paramwwgetfilterdata.this.aP5 = new String[] {""};
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
      paramwwgetfilterdata.this.AV18DDOName = aP0;
      paramwwgetfilterdata.this.AV16SearchTxt = aP1;
      paramwwgetfilterdata.this.AV17SearchTxtTo = aP2;
      paramwwgetfilterdata.this.aP3 = aP3;
      paramwwgetfilterdata.this.aP4 = aP4;
      paramwwgetfilterdata.this.aP5 = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_int1 = AV42EmpCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int2) ;
      paramwwgetfilterdata.this.GXt_int1 = GXv_int2[0] ;
      AV42EmpCod = GXt_int1 ;
      GXt_int3 = AV41CliCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int4) ;
      paramwwgetfilterdata.this.GXt_int3 = GXv_int4[0] ;
      AV41CliCod = GXt_int3 ;
      AV21Options = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV24OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV26OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "") ;
      GXt_boolean5 = AV8IsAuthorized ;
      GXv_boolean6[0] = GXt_boolean5 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWParam", GXv_boolean6) ;
      paramwwgetfilterdata.this.GXt_boolean5 = GXv_boolean6[0] ;
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
         if ( GXutil.strcmp(GXutil.upper( AV18DDOName), "DDO_PARMCOD") == 0 )
         {
            /* Execute user subroutine: 'LOADPARMCODOPTIONS' */
            S121 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV18DDOName), "DDO_PARMDESCRI") == 0 )
         {
            /* Execute user subroutine: 'LOADPARMDESCRIOPTIONS' */
            S131 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV18DDOName), "DDO_PARMVALUE") == 0 )
         {
            /* Execute user subroutine: 'LOADPARMVALUEOPTIONS' */
            S141 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         else if ( GXutil.strcmp(GXutil.upper( AV18DDOName), "DDO_PARMRELREF") == 0 )
         {
            /* Execute user subroutine: 'LOADPARMRELREFOPTIONS' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      AV22OptionsJson = AV21Options.toJSonString(false) ;
      AV25OptionsDescJson = AV24OptionsDesc.toJSonString(false) ;
      AV27OptionIndexesJson = AV26OptionIndexes.toJSonString(false) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV29Session.getValue("ParamWWGridState"), "") == 0 )
      {
         AV31GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "ParamWWGridState"), null, null);
      }
      else
      {
         AV31GridState.fromxml(AV29Session.getValue("ParamWWGridState"), null, null);
      }
      AV50GXV1 = 1 ;
      while ( AV50GXV1 <= AV31GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV32GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV31GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV50GXV1));
         if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPARMCOD") == 0 )
         {
            AV10TFParmCod = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPARMCOD_SEL") == 0 )
         {
            AV35TFParmCod_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV36TFParmCod_Sels.fromJSonString(AV35TFParmCod_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPARMDESCRI") == 0 )
         {
            AV14TFParmDescri = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPARMDESCRI_SEL") == 0 )
         {
            AV39TFParmDescri_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV40TFParmDescri_Sels.fromJSonString(AV39TFParmDescri_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPARMVALUE") == 0 )
         {
            AV12TFParmValue = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPARMVALUE_SEL") == 0 )
         {
            AV37TFParmValue_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV38TFParmValue_Sels.fromJSonString(AV37TFParmValue_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPARMRELREF") == 0 )
         {
            AV46TFParmRelRef = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFPARMRELREF_SEL") == 0 )
         {
            AV45TFParmRelRef_SelsJson = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV47TFParmRelRef_Sels.fromJSonString(AV45TFParmRelRef_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "PARM_&MENUOPCCOD") == 0 )
         {
            AV44MenuOpcCod = AV32GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         AV50GXV1 = (int)(AV50GXV1+1) ;
      }
   }

   public void S121( )
   {
      /* 'LOADPARMCODOPTIONS' Routine */
      returnInSub = false ;
      AV10TFParmCod = AV16SearchTxt ;
      AV36TFParmCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV52Paramwwds_1_tfparmcod = AV10TFParmCod ;
      AV53Paramwwds_2_tfparmcod_sels = AV36TFParmCod_Sels ;
      AV54Paramwwds_3_tfparmdescri = AV14TFParmDescri ;
      AV55Paramwwds_4_tfparmdescri_sels = AV40TFParmDescri_Sels ;
      AV56Paramwwds_5_tfparmvalue = AV12TFParmValue ;
      AV57Paramwwds_6_tfparmvalue_sels = AV38TFParmValue_Sels ;
      AV58Paramwwds_7_tfparmrelref = AV46TFParmRelRef ;
      AV59Paramwwds_8_tfparmrelref_sels = AV47TFParmRelRef_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A61ParmCod ,
                                           AV53Paramwwds_2_tfparmcod_sels ,
                                           A315ParmDescri ,
                                           AV55Paramwwds_4_tfparmdescri_sels ,
                                           A316ParmValue ,
                                           AV57Paramwwds_6_tfparmvalue_sels ,
                                           A2019ParmRelRef ,
                                           AV59Paramwwds_8_tfparmrelref_sels ,
                                           Integer.valueOf(AV53Paramwwds_2_tfparmcod_sels.size()) ,
                                           AV52Paramwwds_1_tfparmcod ,
                                           Integer.valueOf(AV55Paramwwds_4_tfparmdescri_sels.size()) ,
                                           AV54Paramwwds_3_tfparmdescri ,
                                           Integer.valueOf(AV57Paramwwds_6_tfparmvalue_sels.size()) ,
                                           AV56Paramwwds_5_tfparmvalue ,
                                           Integer.valueOf(AV59Paramwwds_8_tfparmrelref_sels.size()) ,
                                           AV58Paramwwds_7_tfparmrelref ,
                                           Integer.valueOf(AV41CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV52Paramwwds_1_tfparmcod = GXutil.padr( GXutil.rtrim( AV52Paramwwds_1_tfparmcod), 30, "%") ;
      lV54Paramwwds_3_tfparmdescri = GXutil.concat( GXutil.rtrim( AV54Paramwwds_3_tfparmdescri), "%", "") ;
      lV56Paramwwds_5_tfparmvalue = GXutil.concat( GXutil.rtrim( AV56Paramwwds_5_tfparmvalue), "%", "") ;
      lV58Paramwwds_7_tfparmrelref = GXutil.concat( GXutil.rtrim( AV58Paramwwds_7_tfparmrelref), "%", "") ;
      /* Using cursor P006D2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV41CliCod), lV52Paramwwds_1_tfparmcod, lV54Paramwwds_3_tfparmdescri, lV56Paramwwds_5_tfparmvalue, lV58Paramwwds_7_tfparmrelref});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk6D2 = false ;
         A3CliCod = P006D2_A3CliCod[0] ;
         A61ParmCod = P006D2_A61ParmCod[0] ;
         A2019ParmRelRef = P006D2_A2019ParmRelRef[0] ;
         A316ParmValue = P006D2_A316ParmValue[0] ;
         A315ParmDescri = P006D2_A315ParmDescri[0] ;
         AV28count = 0 ;
         while ( (pr_default.getStatus(0) != 101) && ( P006D2_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P006D2_A61ParmCod[0], A61ParmCod) == 0 ) )
         {
            brk6D2 = false ;
            AV28count = (long)(AV28count+1) ;
            brk6D2 = true ;
            pr_default.readNext(0);
         }
         if ( ! (GXutil.strcmp("", A61ParmCod)==0) )
         {
            AV20Option = A61ParmCod ;
            AV21Options.add(AV20Option, 0);
            AV26OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV28count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV21Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6D2 )
         {
            brk6D2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
   }

   public void S131( )
   {
      /* 'LOADPARMDESCRIOPTIONS' Routine */
      returnInSub = false ;
      AV14TFParmDescri = AV16SearchTxt ;
      AV40TFParmDescri_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV52Paramwwds_1_tfparmcod = AV10TFParmCod ;
      AV53Paramwwds_2_tfparmcod_sels = AV36TFParmCod_Sels ;
      AV54Paramwwds_3_tfparmdescri = AV14TFParmDescri ;
      AV55Paramwwds_4_tfparmdescri_sels = AV40TFParmDescri_Sels ;
      AV56Paramwwds_5_tfparmvalue = AV12TFParmValue ;
      AV57Paramwwds_6_tfparmvalue_sels = AV38TFParmValue_Sels ;
      AV58Paramwwds_7_tfparmrelref = AV46TFParmRelRef ;
      AV59Paramwwds_8_tfparmrelref_sels = AV47TFParmRelRef_Sels ;
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           A61ParmCod ,
                                           AV53Paramwwds_2_tfparmcod_sels ,
                                           A315ParmDescri ,
                                           AV55Paramwwds_4_tfparmdescri_sels ,
                                           A316ParmValue ,
                                           AV57Paramwwds_6_tfparmvalue_sels ,
                                           A2019ParmRelRef ,
                                           AV59Paramwwds_8_tfparmrelref_sels ,
                                           Integer.valueOf(AV53Paramwwds_2_tfparmcod_sels.size()) ,
                                           AV52Paramwwds_1_tfparmcod ,
                                           Integer.valueOf(AV55Paramwwds_4_tfparmdescri_sels.size()) ,
                                           AV54Paramwwds_3_tfparmdescri ,
                                           Integer.valueOf(AV57Paramwwds_6_tfparmvalue_sels.size()) ,
                                           AV56Paramwwds_5_tfparmvalue ,
                                           Integer.valueOf(AV59Paramwwds_8_tfparmrelref_sels.size()) ,
                                           AV58Paramwwds_7_tfparmrelref ,
                                           Integer.valueOf(AV41CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV52Paramwwds_1_tfparmcod = GXutil.padr( GXutil.rtrim( AV52Paramwwds_1_tfparmcod), 30, "%") ;
      lV54Paramwwds_3_tfparmdescri = GXutil.concat( GXutil.rtrim( AV54Paramwwds_3_tfparmdescri), "%", "") ;
      lV56Paramwwds_5_tfparmvalue = GXutil.concat( GXutil.rtrim( AV56Paramwwds_5_tfparmvalue), "%", "") ;
      lV58Paramwwds_7_tfparmrelref = GXutil.concat( GXutil.rtrim( AV58Paramwwds_7_tfparmrelref), "%", "") ;
      /* Using cursor P006D3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV41CliCod), lV52Paramwwds_1_tfparmcod, lV54Paramwwds_3_tfparmdescri, lV56Paramwwds_5_tfparmvalue, lV58Paramwwds_7_tfparmrelref});
      while ( (pr_default.getStatus(1) != 101) )
      {
         brk6D4 = false ;
         A3CliCod = P006D3_A3CliCod[0] ;
         A315ParmDescri = P006D3_A315ParmDescri[0] ;
         A2019ParmRelRef = P006D3_A2019ParmRelRef[0] ;
         A316ParmValue = P006D3_A316ParmValue[0] ;
         A61ParmCod = P006D3_A61ParmCod[0] ;
         AV28count = 0 ;
         while ( (pr_default.getStatus(1) != 101) && ( P006D3_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(P006D3_A315ParmDescri[0], A315ParmDescri) == 0 ) )
         {
            brk6D4 = false ;
            A61ParmCod = P006D3_A61ParmCod[0] ;
            AV28count = (long)(AV28count+1) ;
            brk6D4 = true ;
            pr_default.readNext(1);
         }
         if ( ! (GXutil.strcmp("", A315ParmDescri)==0) )
         {
            AV20Option = A315ParmDescri ;
            AV21Options.add(AV20Option, 0);
            AV26OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV28count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV21Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6D4 )
         {
            brk6D4 = true ;
            pr_default.readNext(1);
         }
      }
      pr_default.close(1);
   }

   public void S141( )
   {
      /* 'LOADPARMVALUEOPTIONS' Routine */
      returnInSub = false ;
      AV12TFParmValue = AV16SearchTxt ;
      AV38TFParmValue_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV52Paramwwds_1_tfparmcod = AV10TFParmCod ;
      AV53Paramwwds_2_tfparmcod_sels = AV36TFParmCod_Sels ;
      AV54Paramwwds_3_tfparmdescri = AV14TFParmDescri ;
      AV55Paramwwds_4_tfparmdescri_sels = AV40TFParmDescri_Sels ;
      AV56Paramwwds_5_tfparmvalue = AV12TFParmValue ;
      AV57Paramwwds_6_tfparmvalue_sels = AV38TFParmValue_Sels ;
      AV58Paramwwds_7_tfparmrelref = AV46TFParmRelRef ;
      AV59Paramwwds_8_tfparmrelref_sels = AV47TFParmRelRef_Sels ;
      pr_default.dynParam(2, new Object[]{ new Object[]{
                                           A61ParmCod ,
                                           AV53Paramwwds_2_tfparmcod_sels ,
                                           A315ParmDescri ,
                                           AV55Paramwwds_4_tfparmdescri_sels ,
                                           A316ParmValue ,
                                           AV57Paramwwds_6_tfparmvalue_sels ,
                                           A2019ParmRelRef ,
                                           AV59Paramwwds_8_tfparmrelref_sels ,
                                           Integer.valueOf(AV53Paramwwds_2_tfparmcod_sels.size()) ,
                                           AV52Paramwwds_1_tfparmcod ,
                                           Integer.valueOf(AV55Paramwwds_4_tfparmdescri_sels.size()) ,
                                           AV54Paramwwds_3_tfparmdescri ,
                                           Integer.valueOf(AV57Paramwwds_6_tfparmvalue_sels.size()) ,
                                           AV56Paramwwds_5_tfparmvalue ,
                                           Integer.valueOf(AV59Paramwwds_8_tfparmrelref_sels.size()) ,
                                           AV58Paramwwds_7_tfparmrelref ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV41CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV52Paramwwds_1_tfparmcod = GXutil.padr( GXutil.rtrim( AV52Paramwwds_1_tfparmcod), 30, "%") ;
      lV54Paramwwds_3_tfparmdescri = GXutil.concat( GXutil.rtrim( AV54Paramwwds_3_tfparmdescri), "%", "") ;
      lV56Paramwwds_5_tfparmvalue = GXutil.concat( GXutil.rtrim( AV56Paramwwds_5_tfparmvalue), "%", "") ;
      lV58Paramwwds_7_tfparmrelref = GXutil.concat( GXutil.rtrim( AV58Paramwwds_7_tfparmrelref), "%", "") ;
      /* Using cursor P006D4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV41CliCod), lV52Paramwwds_1_tfparmcod, lV54Paramwwds_3_tfparmdescri, lV56Paramwwds_5_tfparmvalue, lV58Paramwwds_7_tfparmrelref});
      while ( (pr_default.getStatus(2) != 101) )
      {
         brk6D6 = false ;
         A3CliCod = P006D4_A3CliCod[0] ;
         A316ParmValue = P006D4_A316ParmValue[0] ;
         A2019ParmRelRef = P006D4_A2019ParmRelRef[0] ;
         A315ParmDescri = P006D4_A315ParmDescri[0] ;
         A61ParmCod = P006D4_A61ParmCod[0] ;
         AV28count = 0 ;
         while ( (pr_default.getStatus(2) != 101) && ( GXutil.strcmp(P006D4_A316ParmValue[0], A316ParmValue) == 0 ) )
         {
            brk6D6 = false ;
            A3CliCod = P006D4_A3CliCod[0] ;
            A61ParmCod = P006D4_A61ParmCod[0] ;
            AV28count = (long)(AV28count+1) ;
            brk6D6 = true ;
            pr_default.readNext(2);
         }
         if ( ! (GXutil.strcmp("", A316ParmValue)==0) )
         {
            AV20Option = A316ParmValue ;
            AV21Options.add(AV20Option, 0);
            AV26OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV28count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV21Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6D6 )
         {
            brk6D6 = true ;
            pr_default.readNext(2);
         }
      }
      pr_default.close(2);
   }

   public void S151( )
   {
      /* 'LOADPARMRELREFOPTIONS' Routine */
      returnInSub = false ;
      AV46TFParmRelRef = AV16SearchTxt ;
      AV47TFParmRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "") ;
      AV52Paramwwds_1_tfparmcod = AV10TFParmCod ;
      AV53Paramwwds_2_tfparmcod_sels = AV36TFParmCod_Sels ;
      AV54Paramwwds_3_tfparmdescri = AV14TFParmDescri ;
      AV55Paramwwds_4_tfparmdescri_sels = AV40TFParmDescri_Sels ;
      AV56Paramwwds_5_tfparmvalue = AV12TFParmValue ;
      AV57Paramwwds_6_tfparmvalue_sels = AV38TFParmValue_Sels ;
      AV58Paramwwds_7_tfparmrelref = AV46TFParmRelRef ;
      AV59Paramwwds_8_tfparmrelref_sels = AV47TFParmRelRef_Sels ;
      pr_default.dynParam(3, new Object[]{ new Object[]{
                                           A61ParmCod ,
                                           AV53Paramwwds_2_tfparmcod_sels ,
                                           A315ParmDescri ,
                                           AV55Paramwwds_4_tfparmdescri_sels ,
                                           A316ParmValue ,
                                           AV57Paramwwds_6_tfparmvalue_sels ,
                                           A2019ParmRelRef ,
                                           AV59Paramwwds_8_tfparmrelref_sels ,
                                           Integer.valueOf(AV53Paramwwds_2_tfparmcod_sels.size()) ,
                                           AV52Paramwwds_1_tfparmcod ,
                                           Integer.valueOf(AV55Paramwwds_4_tfparmdescri_sels.size()) ,
                                           AV54Paramwwds_3_tfparmdescri ,
                                           Integer.valueOf(AV57Paramwwds_6_tfparmvalue_sels.size()) ,
                                           AV56Paramwwds_5_tfparmvalue ,
                                           Integer.valueOf(AV59Paramwwds_8_tfparmrelref_sels.size()) ,
                                           AV58Paramwwds_7_tfparmrelref ,
                                           Integer.valueOf(A3CliCod) ,
                                           Integer.valueOf(AV41CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      lV52Paramwwds_1_tfparmcod = GXutil.padr( GXutil.rtrim( AV52Paramwwds_1_tfparmcod), 30, "%") ;
      lV54Paramwwds_3_tfparmdescri = GXutil.concat( GXutil.rtrim( AV54Paramwwds_3_tfparmdescri), "%", "") ;
      lV56Paramwwds_5_tfparmvalue = GXutil.concat( GXutil.rtrim( AV56Paramwwds_5_tfparmvalue), "%", "") ;
      lV58Paramwwds_7_tfparmrelref = GXutil.concat( GXutil.rtrim( AV58Paramwwds_7_tfparmrelref), "%", "") ;
      /* Using cursor P006D5 */
      pr_default.execute(3, new Object[] {Integer.valueOf(AV41CliCod), lV52Paramwwds_1_tfparmcod, lV54Paramwwds_3_tfparmdescri, lV56Paramwwds_5_tfparmvalue, lV58Paramwwds_7_tfparmrelref});
      while ( (pr_default.getStatus(3) != 101) )
      {
         brk6D8 = false ;
         A3CliCod = P006D5_A3CliCod[0] ;
         A2019ParmRelRef = P006D5_A2019ParmRelRef[0] ;
         A316ParmValue = P006D5_A316ParmValue[0] ;
         A315ParmDescri = P006D5_A315ParmDescri[0] ;
         A61ParmCod = P006D5_A61ParmCod[0] ;
         AV28count = 0 ;
         while ( (pr_default.getStatus(3) != 101) && ( GXutil.strcmp(P006D5_A2019ParmRelRef[0], A2019ParmRelRef) == 0 ) )
         {
            brk6D8 = false ;
            A3CliCod = P006D5_A3CliCod[0] ;
            A61ParmCod = P006D5_A61ParmCod[0] ;
            AV28count = (long)(AV28count+1) ;
            brk6D8 = true ;
            pr_default.readNext(3);
         }
         if ( ! (GXutil.strcmp("", A2019ParmRelRef)==0) )
         {
            AV20Option = A2019ParmRelRef ;
            AV21Options.add(AV20Option, 0);
            AV26OptionIndexes.add(GXutil.trim( localUtil.format( DecimalUtil.doubleToDec(AV28count), "Z,ZZZ,ZZZ,ZZ9")), 0);
         }
         if ( AV21Options.size() == 50 )
         {
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         if ( ! brk6D8 )
         {
            brk6D8 = true ;
            pr_default.readNext(3);
         }
      }
      pr_default.close(3);
   }

   protected void cleanup( )
   {
      this.aP3[0] = paramwwgetfilterdata.this.AV22OptionsJson;
      this.aP4[0] = paramwwgetfilterdata.this.AV25OptionsDescJson;
      this.aP5[0] = paramwwgetfilterdata.this.AV27OptionIndexesJson;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV22OptionsJson = "" ;
      AV25OptionsDescJson = "" ;
      AV27OptionIndexesJson = "" ;
      GXv_int2 = new short[1] ;
      GXv_int4 = new int[1] ;
      AV21Options = new GXSimpleCollection<String>(String.class, "internal", "");
      AV24OptionsDesc = new GXSimpleCollection<String>(String.class, "internal", "");
      AV26OptionIndexes = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_boolean6 = new boolean[1] ;
      AV9WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext7 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV29Session = httpContext.getWebSession();
      AV31GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV32GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV10TFParmCod = "" ;
      AV35TFParmCod_SelsJson = "" ;
      AV36TFParmCod_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV14TFParmDescri = "" ;
      AV39TFParmDescri_SelsJson = "" ;
      AV40TFParmDescri_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV12TFParmValue = "" ;
      AV37TFParmValue_SelsJson = "" ;
      AV38TFParmValue_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV46TFParmRelRef = "" ;
      AV45TFParmRelRef_SelsJson = "" ;
      AV47TFParmRelRef_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV44MenuOpcCod = "" ;
      A61ParmCod = "" ;
      AV52Paramwwds_1_tfparmcod = "" ;
      AV53Paramwwds_2_tfparmcod_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV54Paramwwds_3_tfparmdescri = "" ;
      AV55Paramwwds_4_tfparmdescri_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV56Paramwwds_5_tfparmvalue = "" ;
      AV57Paramwwds_6_tfparmvalue_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV58Paramwwds_7_tfparmrelref = "" ;
      AV59Paramwwds_8_tfparmrelref_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV52Paramwwds_1_tfparmcod = "" ;
      lV54Paramwwds_3_tfparmdescri = "" ;
      lV56Paramwwds_5_tfparmvalue = "" ;
      lV58Paramwwds_7_tfparmrelref = "" ;
      A315ParmDescri = "" ;
      A316ParmValue = "" ;
      A2019ParmRelRef = "" ;
      P006D2_A3CliCod = new int[1] ;
      P006D2_A61ParmCod = new String[] {""} ;
      P006D2_A2019ParmRelRef = new String[] {""} ;
      P006D2_A316ParmValue = new String[] {""} ;
      P006D2_A315ParmDescri = new String[] {""} ;
      AV20Option = "" ;
      P006D3_A3CliCod = new int[1] ;
      P006D3_A315ParmDescri = new String[] {""} ;
      P006D3_A2019ParmRelRef = new String[] {""} ;
      P006D3_A316ParmValue = new String[] {""} ;
      P006D3_A61ParmCod = new String[] {""} ;
      P006D4_A3CliCod = new int[1] ;
      P006D4_A316ParmValue = new String[] {""} ;
      P006D4_A2019ParmRelRef = new String[] {""} ;
      P006D4_A315ParmDescri = new String[] {""} ;
      P006D4_A61ParmCod = new String[] {""} ;
      P006D5_A3CliCod = new int[1] ;
      P006D5_A2019ParmRelRef = new String[] {""} ;
      P006D5_A316ParmValue = new String[] {""} ;
      P006D5_A315ParmDescri = new String[] {""} ;
      P006D5_A61ParmCod = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.paramwwgetfilterdata__default(),
         new Object[] {
             new Object[] {
            P006D2_A3CliCod, P006D2_A61ParmCod, P006D2_A2019ParmRelRef, P006D2_A316ParmValue, P006D2_A315ParmDescri
            }
            , new Object[] {
            P006D3_A3CliCod, P006D3_A315ParmDescri, P006D3_A2019ParmRelRef, P006D3_A316ParmValue, P006D3_A61ParmCod
            }
            , new Object[] {
            P006D4_A3CliCod, P006D4_A316ParmValue, P006D4_A2019ParmRelRef, P006D4_A315ParmDescri, P006D4_A61ParmCod
            }
            , new Object[] {
            P006D5_A3CliCod, P006D5_A2019ParmRelRef, P006D5_A316ParmValue, P006D5_A315ParmDescri, P006D5_A61ParmCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV42EmpCod ;
   private short GXt_int1 ;
   private short GXv_int2[] ;
   private short Gx_err ;
   private int AV41CliCod ;
   private int GXt_int3 ;
   private int GXv_int4[] ;
   private int AV50GXV1 ;
   private int AV53Paramwwds_2_tfparmcod_sels_size ;
   private int AV55Paramwwds_4_tfparmdescri_sels_size ;
   private int AV57Paramwwds_6_tfparmvalue_sels_size ;
   private int AV59Paramwwds_8_tfparmrelref_sels_size ;
   private int A3CliCod ;
   private long AV28count ;
   private String AV10TFParmCod ;
   private String A61ParmCod ;
   private String AV52Paramwwds_1_tfparmcod ;
   private String scmdbuf ;
   private String lV52Paramwwds_1_tfparmcod ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean5 ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean brk6D2 ;
   private boolean brk6D4 ;
   private boolean brk6D6 ;
   private boolean brk6D8 ;
   private String AV22OptionsJson ;
   private String AV25OptionsDescJson ;
   private String AV27OptionIndexesJson ;
   private String AV35TFParmCod_SelsJson ;
   private String AV39TFParmDescri_SelsJson ;
   private String AV37TFParmValue_SelsJson ;
   private String AV45TFParmRelRef_SelsJson ;
   private String A316ParmValue ;
   private String AV18DDOName ;
   private String AV16SearchTxt ;
   private String AV17SearchTxtTo ;
   private String AV14TFParmDescri ;
   private String AV12TFParmValue ;
   private String AV46TFParmRelRef ;
   private String AV44MenuOpcCod ;
   private String AV54Paramwwds_3_tfparmdescri ;
   private String AV56Paramwwds_5_tfparmvalue ;
   private String AV58Paramwwds_7_tfparmrelref ;
   private String lV54Paramwwds_3_tfparmdescri ;
   private String lV56Paramwwds_5_tfparmvalue ;
   private String lV58Paramwwds_7_tfparmrelref ;
   private String A315ParmDescri ;
   private String A2019ParmRelRef ;
   private String AV20Option ;
   private com.genexus.webpanels.WebSession AV29Session ;
   private String[] aP5 ;
   private String[] aP3 ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private int[] P006D2_A3CliCod ;
   private String[] P006D2_A61ParmCod ;
   private String[] P006D2_A2019ParmRelRef ;
   private String[] P006D2_A316ParmValue ;
   private String[] P006D2_A315ParmDescri ;
   private int[] P006D3_A3CliCod ;
   private String[] P006D3_A315ParmDescri ;
   private String[] P006D3_A2019ParmRelRef ;
   private String[] P006D3_A316ParmValue ;
   private String[] P006D3_A61ParmCod ;
   private int[] P006D4_A3CliCod ;
   private String[] P006D4_A316ParmValue ;
   private String[] P006D4_A2019ParmRelRef ;
   private String[] P006D4_A315ParmDescri ;
   private String[] P006D4_A61ParmCod ;
   private int[] P006D5_A3CliCod ;
   private String[] P006D5_A2019ParmRelRef ;
   private String[] P006D5_A316ParmValue ;
   private String[] P006D5_A315ParmDescri ;
   private String[] P006D5_A61ParmCod ;
   private GXSimpleCollection<String> AV36TFParmCod_Sels ;
   private GXSimpleCollection<String> AV53Paramwwds_2_tfparmcod_sels ;
   private GXSimpleCollection<String> AV21Options ;
   private GXSimpleCollection<String> AV24OptionsDesc ;
   private GXSimpleCollection<String> AV26OptionIndexes ;
   private GXSimpleCollection<String> AV40TFParmDescri_Sels ;
   private GXSimpleCollection<String> AV38TFParmValue_Sels ;
   private GXSimpleCollection<String> AV47TFParmRelRef_Sels ;
   private GXSimpleCollection<String> AV55Paramwwds_4_tfparmdescri_sels ;
   private GXSimpleCollection<String> AV57Paramwwds_6_tfparmvalue_sels ;
   private GXSimpleCollection<String> AV59Paramwwds_8_tfparmrelref_sels ;
   private web.wwpbaseobjects.SdtWWPContext AV9WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext7[] ;
   private web.wwpbaseobjects.SdtWWPGridState AV31GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV32GridStateFilterValue ;
}

final  class paramwwgetfilterdata__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P006D2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A61ParmCod ,
                                          GXSimpleCollection<String> AV53Paramwwds_2_tfparmcod_sels ,
                                          String A315ParmDescri ,
                                          GXSimpleCollection<String> AV55Paramwwds_4_tfparmdescri_sels ,
                                          String A316ParmValue ,
                                          GXSimpleCollection<String> AV57Paramwwds_6_tfparmvalue_sels ,
                                          String A2019ParmRelRef ,
                                          GXSimpleCollection<String> AV59Paramwwds_8_tfparmrelref_sels ,
                                          int AV53Paramwwds_2_tfparmcod_sels_size ,
                                          String AV52Paramwwds_1_tfparmcod ,
                                          int AV55Paramwwds_4_tfparmdescri_sels_size ,
                                          String AV54Paramwwds_3_tfparmdescri ,
                                          int AV57Paramwwds_6_tfparmvalue_sels_size ,
                                          String AV56Paramwwds_5_tfparmvalue ,
                                          int AV59Paramwwds_8_tfparmrelref_sels_size ,
                                          String AV58Paramwwds_7_tfparmrelref ,
                                          int AV41CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[5];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, ParmCod, ParmRelRef, ParmValue, ParmDescri FROM Param" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV53Paramwwds_2_tfparmcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Paramwwds_1_tfparmcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ParmCod) like LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV53Paramwwds_2_tfparmcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Paramwwds_2_tfparmcod_sels, "ParmCod IN (", ")")+")");
      }
      if ( ( AV55Paramwwds_4_tfparmdescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Paramwwds_3_tfparmdescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ParmDescri) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV55Paramwwds_4_tfparmdescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Paramwwds_4_tfparmdescri_sels, "ParmDescri IN (", ")")+")");
      }
      if ( ( AV57Paramwwds_6_tfparmvalue_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56Paramwwds_5_tfparmvalue)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ParmValue) like LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV57Paramwwds_6_tfparmvalue_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57Paramwwds_6_tfparmvalue_sels, "ParmValue IN (", ")")+")");
      }
      if ( ( AV59Paramwwds_8_tfparmrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV58Paramwwds_7_tfparmrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ParmRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV59Paramwwds_8_tfparmrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Paramwwds_8_tfparmrelref_sels, "ParmRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, ParmCod" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   protected Object[] conditional_P006D3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A61ParmCod ,
                                          GXSimpleCollection<String> AV53Paramwwds_2_tfparmcod_sels ,
                                          String A315ParmDescri ,
                                          GXSimpleCollection<String> AV55Paramwwds_4_tfparmdescri_sels ,
                                          String A316ParmValue ,
                                          GXSimpleCollection<String> AV57Paramwwds_6_tfparmvalue_sels ,
                                          String A2019ParmRelRef ,
                                          GXSimpleCollection<String> AV59Paramwwds_8_tfparmrelref_sels ,
                                          int AV53Paramwwds_2_tfparmcod_sels_size ,
                                          String AV52Paramwwds_1_tfparmcod ,
                                          int AV55Paramwwds_4_tfparmdescri_sels_size ,
                                          String AV54Paramwwds_3_tfparmdescri ,
                                          int AV57Paramwwds_6_tfparmvalue_sels_size ,
                                          String AV56Paramwwds_5_tfparmvalue ,
                                          int AV59Paramwwds_8_tfparmrelref_sels_size ,
                                          String AV58Paramwwds_7_tfparmrelref ,
                                          int AV41CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int11 = new byte[5];
      Object[] GXv_Object12 = new Object[2];
      scmdbuf = "SELECT CliCod, ParmDescri, ParmRelRef, ParmValue, ParmCod FROM Param" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV53Paramwwds_2_tfparmcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Paramwwds_1_tfparmcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ParmCod) like LOWER(?))");
      }
      else
      {
         GXv_int11[1] = (byte)(1) ;
      }
      if ( AV53Paramwwds_2_tfparmcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Paramwwds_2_tfparmcod_sels, "ParmCod IN (", ")")+")");
      }
      if ( ( AV55Paramwwds_4_tfparmdescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Paramwwds_3_tfparmdescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ParmDescri) like LOWER(?))");
      }
      else
      {
         GXv_int11[2] = (byte)(1) ;
      }
      if ( AV55Paramwwds_4_tfparmdescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Paramwwds_4_tfparmdescri_sels, "ParmDescri IN (", ")")+")");
      }
      if ( ( AV57Paramwwds_6_tfparmvalue_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56Paramwwds_5_tfparmvalue)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ParmValue) like LOWER(?))");
      }
      else
      {
         GXv_int11[3] = (byte)(1) ;
      }
      if ( AV57Paramwwds_6_tfparmvalue_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57Paramwwds_6_tfparmvalue_sels, "ParmValue IN (", ")")+")");
      }
      if ( ( AV59Paramwwds_8_tfparmrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV58Paramwwds_7_tfparmrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ParmRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int11[4] = (byte)(1) ;
      }
      if ( AV59Paramwwds_8_tfparmrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Paramwwds_8_tfparmrelref_sels, "ParmRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, ParmDescri" ;
      GXv_Object12[0] = scmdbuf ;
      GXv_Object12[1] = GXv_int11 ;
      return GXv_Object12 ;
   }

   protected Object[] conditional_P006D4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A61ParmCod ,
                                          GXSimpleCollection<String> AV53Paramwwds_2_tfparmcod_sels ,
                                          String A315ParmDescri ,
                                          GXSimpleCollection<String> AV55Paramwwds_4_tfparmdescri_sels ,
                                          String A316ParmValue ,
                                          GXSimpleCollection<String> AV57Paramwwds_6_tfparmvalue_sels ,
                                          String A2019ParmRelRef ,
                                          GXSimpleCollection<String> AV59Paramwwds_8_tfparmrelref_sels ,
                                          int AV53Paramwwds_2_tfparmcod_sels_size ,
                                          String AV52Paramwwds_1_tfparmcod ,
                                          int AV55Paramwwds_4_tfparmdescri_sels_size ,
                                          String AV54Paramwwds_3_tfparmdescri ,
                                          int AV57Paramwwds_6_tfparmvalue_sels_size ,
                                          String AV56Paramwwds_5_tfparmvalue ,
                                          int AV59Paramwwds_8_tfparmrelref_sels_size ,
                                          String AV58Paramwwds_7_tfparmrelref ,
                                          int A3CliCod ,
                                          int AV41CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int14 = new byte[5];
      Object[] GXv_Object15 = new Object[2];
      scmdbuf = "SELECT CliCod, ParmValue, ParmRelRef, ParmDescri, ParmCod FROM Param" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV53Paramwwds_2_tfparmcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Paramwwds_1_tfparmcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ParmCod) like LOWER(?))");
      }
      else
      {
         GXv_int14[1] = (byte)(1) ;
      }
      if ( AV53Paramwwds_2_tfparmcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Paramwwds_2_tfparmcod_sels, "ParmCod IN (", ")")+")");
      }
      if ( ( AV55Paramwwds_4_tfparmdescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Paramwwds_3_tfparmdescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ParmDescri) like LOWER(?))");
      }
      else
      {
         GXv_int14[2] = (byte)(1) ;
      }
      if ( AV55Paramwwds_4_tfparmdescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Paramwwds_4_tfparmdescri_sels, "ParmDescri IN (", ")")+")");
      }
      if ( ( AV57Paramwwds_6_tfparmvalue_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56Paramwwds_5_tfparmvalue)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ParmValue) like LOWER(?))");
      }
      else
      {
         GXv_int14[3] = (byte)(1) ;
      }
      if ( AV57Paramwwds_6_tfparmvalue_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57Paramwwds_6_tfparmvalue_sels, "ParmValue IN (", ")")+")");
      }
      if ( ( AV59Paramwwds_8_tfparmrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV58Paramwwds_7_tfparmrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ParmRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int14[4] = (byte)(1) ;
      }
      if ( AV59Paramwwds_8_tfparmrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Paramwwds_8_tfparmrelref_sels, "ParmRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ParmValue" ;
      GXv_Object15[0] = scmdbuf ;
      GXv_Object15[1] = GXv_int14 ;
      return GXv_Object15 ;
   }

   protected Object[] conditional_P006D5( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A61ParmCod ,
                                          GXSimpleCollection<String> AV53Paramwwds_2_tfparmcod_sels ,
                                          String A315ParmDescri ,
                                          GXSimpleCollection<String> AV55Paramwwds_4_tfparmdescri_sels ,
                                          String A316ParmValue ,
                                          GXSimpleCollection<String> AV57Paramwwds_6_tfparmvalue_sels ,
                                          String A2019ParmRelRef ,
                                          GXSimpleCollection<String> AV59Paramwwds_8_tfparmrelref_sels ,
                                          int AV53Paramwwds_2_tfparmcod_sels_size ,
                                          String AV52Paramwwds_1_tfparmcod ,
                                          int AV55Paramwwds_4_tfparmdescri_sels_size ,
                                          String AV54Paramwwds_3_tfparmdescri ,
                                          int AV57Paramwwds_6_tfparmvalue_sels_size ,
                                          String AV56Paramwwds_5_tfparmvalue ,
                                          int AV59Paramwwds_8_tfparmrelref_sels_size ,
                                          String AV58Paramwwds_7_tfparmrelref ,
                                          int A3CliCod ,
                                          int AV41CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int17 = new byte[5];
      Object[] GXv_Object18 = new Object[2];
      scmdbuf = "SELECT CliCod, ParmRelRef, ParmValue, ParmDescri, ParmCod FROM Param" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ( AV53Paramwwds_2_tfparmcod_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV52Paramwwds_1_tfparmcod)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ParmCod) like LOWER(?))");
      }
      else
      {
         GXv_int17[1] = (byte)(1) ;
      }
      if ( AV53Paramwwds_2_tfparmcod_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV53Paramwwds_2_tfparmcod_sels, "ParmCod IN (", ")")+")");
      }
      if ( ( AV55Paramwwds_4_tfparmdescri_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV54Paramwwds_3_tfparmdescri)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ParmDescri) like LOWER(?))");
      }
      else
      {
         GXv_int17[2] = (byte)(1) ;
      }
      if ( AV55Paramwwds_4_tfparmdescri_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV55Paramwwds_4_tfparmdescri_sels, "ParmDescri IN (", ")")+")");
      }
      if ( ( AV57Paramwwds_6_tfparmvalue_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV56Paramwwds_5_tfparmvalue)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ParmValue) like LOWER(?))");
      }
      else
      {
         GXv_int17[3] = (byte)(1) ;
      }
      if ( AV57Paramwwds_6_tfparmvalue_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV57Paramwwds_6_tfparmvalue_sels, "ParmValue IN (", ")")+")");
      }
      if ( ( AV59Paramwwds_8_tfparmrelref_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV58Paramwwds_7_tfparmrelref)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(ParmRelRef) like LOWER(?))");
      }
      else
      {
         GXv_int17[4] = (byte)(1) ;
      }
      if ( AV59Paramwwds_8_tfparmrelref_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV59Paramwwds_8_tfparmrelref_sels, "ParmRelRef IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY ParmRelRef" ;
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
            case 0 :
                  return conditional_P006D2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() );
            case 1 :
                  return conditional_P006D3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() );
            case 2 :
                  return conditional_P006D4(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() );
            case 3 :
                  return conditional_P006D5(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , (GXSimpleCollection<String>)dynConstraints[5] , (String)dynConstraints[6] , (GXSimpleCollection<String>)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , (String)dynConstraints[9] , ((Number) dynConstraints[10]).intValue() , (String)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P006D2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006D3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006D4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P006D5", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 30);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getLongVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 30);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 30);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getLongVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 30);
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
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 30);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 200);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 40);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 30);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 200);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 40);
               }
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 30);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 200);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 40);
               }
               return;
            case 3 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[6], 30);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[7], 400);
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[8], 200);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 40);
               }
               return;
      }
   }

}

