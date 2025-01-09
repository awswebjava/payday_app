package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class secrolewwexport extends GXProcedure
{
   public secrolewwexport( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( secrolewwexport.class ), "" );
   }

   public secrolewwexport( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String[] aP0 )
   {
      secrolewwexport.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String[] aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String[] aP0 ,
                             String[] aP1 )
   {
      secrolewwexport.this.aP0 = aP0;
      secrolewwexport.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV8IsAuthorized ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecRole", GXv_boolean2) ;
      secrolewwexport.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV8IsAuthorized = GXt_boolean1 ;
      if ( ! AV8IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV60Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      if ( AV8IsAuthorized )
      {
         GXv_SdtWWPContext3[0] = AV50WWPContext;
         new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
         AV50WWPContext = GXv_SdtWWPContext3[0] ;
         /* Execute user subroutine: 'OPENDOCUMENT' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV13CellRow = 1 ;
         AV14FirstColumn = 1 ;
         /* Execute user subroutine: 'LOADGRIDSTATE' */
         S191 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITEFILTERS' */
         S131 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITECOLUMNTITLES' */
         S141 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'WRITEDATA' */
         S151 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         /* Execute user subroutine: 'CLOSEDOCUMENT' */
         S181 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'OPENDOCUMENT' Routine */
      returnInSub = false ;
      AV15Random = (int)(GXutil.random( )*10000) ;
      AV11Filename = "SecRoleWWExport-" + GXutil.trim( GXutil.str( AV15Random, 8, 0)) + ".xlsx" ;
      AV10ExcelDocument.Open(AV11Filename);
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV10ExcelDocument.Clear();
   }

   public void S131( )
   {
      /* 'WRITEFILTERS' Routine */
      returnInSub = false ;
      if ( AV33GridState.getgxTv_SdtWWPGridState_Dynamicfilters().size() >= 1 )
      {
         AV34GridStateDynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)((web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)AV33GridState.getgxTv_SdtWWPGridState_Dynamicfilters().elementAt(-1+1));
         AV18DynamicFiltersSelector1 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Selected() ;
         if ( GXutil.strcmp(AV18DynamicFiltersSelector1, "SECROLENAME") == 0 )
         {
            AV19DynamicFiltersOperator1 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Operator() ;
            AV20SecRoleName1 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value() ;
            if ( ! (GXutil.strcmp("", AV20SecRoleName1)==0) )
            {
               AV13CellRow = (int)(AV13CellRow+1) ;
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn, 1, 1).setBold( (short)(1) );
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn, 1, 1).setColor( 3 );
               if ( AV19DynamicFiltersOperator1 == 0 )
               {
                  AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn, 1, 1).setText( GXutil.format( "%1 (%2)", httpContext.getMessage( "Name", ""), httpContext.getMessage( "WWP_FilterLike", ""), "", "", "", "", "", "", "") );
               }
               else if ( AV19DynamicFiltersOperator1 == 1 )
               {
                  AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn, 1, 1).setText( GXutil.format( "%1 (%2)", httpContext.getMessage( "Name", ""), httpContext.getMessage( "WWP_FilterContains", ""), "", "", "", "", "", "", "") );
               }
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setItalic( (short)(1) );
               GXt_char4 = "" ;
               GXv_char5[0] = GXt_char4 ;
               new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV20SecRoleName1, GXv_char5) ;
               secrolewwexport.this.GXt_char4 = GXv_char5[0] ;
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char4 );
            }
         }
         if ( AV33GridState.getgxTv_SdtWWPGridState_Dynamicfilters().size() >= 2 )
         {
            AV22DynamicFiltersEnabled2 = true ;
            AV34GridStateDynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)((web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)AV33GridState.getgxTv_SdtWWPGridState_Dynamicfilters().elementAt(-1+2));
            AV23DynamicFiltersSelector2 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Selected() ;
            if ( GXutil.strcmp(AV23DynamicFiltersSelector2, "SECROLENAME") == 0 )
            {
               AV24DynamicFiltersOperator2 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Operator() ;
               AV25SecRoleName2 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value() ;
               if ( ! (GXutil.strcmp("", AV25SecRoleName2)==0) )
               {
                  AV13CellRow = (int)(AV13CellRow+1) ;
                  AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn, 1, 1).setBold( (short)(1) );
                  AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn, 1, 1).setColor( 3 );
                  if ( AV24DynamicFiltersOperator2 == 0 )
                  {
                     AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn, 1, 1).setText( GXutil.format( "%1 (%2)", httpContext.getMessage( "Name", ""), httpContext.getMessage( "WWP_FilterLike", ""), "", "", "", "", "", "", "") );
                  }
                  else if ( AV24DynamicFiltersOperator2 == 1 )
                  {
                     AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn, 1, 1).setText( GXutil.format( "%1 (%2)", httpContext.getMessage( "Name", ""), httpContext.getMessage( "WWP_FilterContains", ""), "", "", "", "", "", "", "") );
                  }
                  AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setItalic( (short)(1) );
                  GXt_char4 = "" ;
                  GXv_char5[0] = GXt_char4 ;
                  new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV25SecRoleName2, GXv_char5) ;
                  secrolewwexport.this.GXt_char4 = GXv_char5[0] ;
                  AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char4 );
               }
            }
            if ( AV33GridState.getgxTv_SdtWWPGridState_Dynamicfilters().size() >= 3 )
            {
               AV27DynamicFiltersEnabled3 = true ;
               AV34GridStateDynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)((web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)AV33GridState.getgxTv_SdtWWPGridState_Dynamicfilters().elementAt(-1+3));
               AV28DynamicFiltersSelector3 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Selected() ;
               if ( GXutil.strcmp(AV28DynamicFiltersSelector3, "SECROLENAME") == 0 )
               {
                  AV29DynamicFiltersOperator3 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Operator() ;
                  AV30SecRoleName3 = AV34GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value() ;
                  if ( ! (GXutil.strcmp("", AV30SecRoleName3)==0) )
                  {
                     AV13CellRow = (int)(AV13CellRow+1) ;
                     AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn, 1, 1).setBold( (short)(1) );
                     AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn, 1, 1).setColor( 3 );
                     if ( AV29DynamicFiltersOperator3 == 0 )
                     {
                        AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn, 1, 1).setText( GXutil.format( "%1 (%2)", httpContext.getMessage( "Name", ""), httpContext.getMessage( "WWP_FilterLike", ""), "", "", "", "", "", "", "") );
                     }
                     else if ( AV29DynamicFiltersOperator3 == 1 )
                     {
                        AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn, 1, 1).setText( GXutil.format( "%1 (%2)", httpContext.getMessage( "Name", ""), httpContext.getMessage( "WWP_FilterContains", ""), "", "", "", "", "", "", "") );
                     }
                     AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setItalic( (short)(1) );
                     GXt_char4 = "" ;
                     GXv_char5[0] = GXt_char4 ;
                     new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV30SecRoleName3, GXv_char5) ;
                     secrolewwexport.this.GXt_char4 = GXv_char5[0] ;
                     AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char4 );
                  }
               }
            }
         }
      }
      if ( ! ( ( AV53TFSecRoleName_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV10ExcelDocument ;
         GXv_int7[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV14FirstColumn), httpContext.getMessage( "Name", "")) ;
         AV10ExcelDocument = GXv_exceldoc6[0] ;
         secrolewwexport.this.AV13CellRow = GXv_int7[0] ;
         AV46i = 1 ;
         AV61GXV1 = 1 ;
         while ( AV61GXV1 <= AV53TFSecRoleName_Sels.size() )
         {
            AV36TFSecRoleName_Sel = (String)AV53TFSecRoleName_Sels.elementAt(-1+AV61GXV1) ;
            if ( AV46i == 1 )
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV36TFSecRoleName_Sel, GXv_char5) ;
            secrolewwexport.this.GXt_char4 = GXv_char5[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+GXt_char4 );
            AV46i = (long)(AV46i+1) ;
            AV61GXV1 = (int)(AV61GXV1+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV35TFSecRoleName)==0) ) )
         {
            GXv_exceldoc6[0] = AV10ExcelDocument ;
            GXv_int7[0] = (short)(AV13CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV14FirstColumn), httpContext.getMessage( "Name", "")) ;
            AV10ExcelDocument = GXv_exceldoc6[0] ;
            secrolewwexport.this.AV13CellRow = GXv_int7[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV35TFSecRoleName, GXv_char5) ;
            secrolewwexport.this.GXt_char4 = GXv_char5[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      if ( ! ( ( AV55TFSecRoleDescription_Sels.size() == 0 ) ) )
      {
         GXv_exceldoc6[0] = AV10ExcelDocument ;
         GXv_int7[0] = (short)(AV13CellRow) ;
         new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV14FirstColumn), httpContext.getMessage( "Description", "")) ;
         AV10ExcelDocument = GXv_exceldoc6[0] ;
         secrolewwexport.this.AV13CellRow = GXv_int7[0] ;
         AV46i = 1 ;
         AV62GXV2 = 1 ;
         while ( AV62GXV2 <= AV55TFSecRoleDescription_Sels.size() )
         {
            AV38TFSecRoleDescription_Sel = (String)AV55TFSecRoleDescription_Sels.elementAt(-1+AV62GXV2) ;
            if ( AV46i == 1 )
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( "" );
            }
            else
            {
               AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+", " );
            }
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV38TFSecRoleDescription_Sel, GXv_char5) ;
            secrolewwexport.this.GXt_char4 = GXv_char5[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).getText()+GXt_char4 );
            AV46i = (long)(AV46i+1) ;
            AV62GXV2 = (int)(AV62GXV2+1) ;
         }
      }
      else
      {
         if ( ! ( (GXutil.strcmp("", AV37TFSecRoleDescription)==0) ) )
         {
            GXv_exceldoc6[0] = AV10ExcelDocument ;
            GXv_int7[0] = (short)(AV13CellRow) ;
            new web.wwpbaseobjects.wwp_exportwritefilter(remoteHandle, context).execute( GXv_exceldoc6, true, GXv_int7, (short)(AV14FirstColumn), httpContext.getMessage( "Description", "")) ;
            AV10ExcelDocument = GXv_exceldoc6[0] ;
            secrolewwexport.this.AV13CellRow = GXv_int7[0] ;
            GXt_char4 = "" ;
            GXv_char5[0] = GXt_char4 ;
            new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( AV37TFSecRoleDescription, GXv_char5) ;
            secrolewwexport.this.GXt_char4 = GXv_char5[0] ;
            AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char4 );
         }
      }
      AV13CellRow = (int)(AV13CellRow+2) ;
   }

   public void S141( )
   {
      /* 'WRITECOLUMNTITLES' Routine */
      returnInSub = false ;
      AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+0, 1, 1).setBold( (short)(1) );
      AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+0, 1, 1).setColor( 11 );
      AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+0, 1, 1).setText( httpContext.getMessage( "Name", "") );
      AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setBold( (short)(1) );
      AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setColor( 11 );
      AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( httpContext.getMessage( "Description", "") );
   }

   public void S151( )
   {
      /* 'WRITEDATA' Routine */
      returnInSub = false ;
      AV64Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 = AV18DynamicFiltersSelector1 ;
      AV65Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 = AV19DynamicFiltersOperator1 ;
      AV66Wwpbaseobjects_secrolewwds_3_secrolename1 = AV20SecRoleName1 ;
      AV67Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 = AV22DynamicFiltersEnabled2 ;
      AV68Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 = AV23DynamicFiltersSelector2 ;
      AV69Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 = AV24DynamicFiltersOperator2 ;
      AV70Wwpbaseobjects_secrolewwds_7_secrolename2 = AV25SecRoleName2 ;
      AV71Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 = AV27DynamicFiltersEnabled3 ;
      AV72Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 = AV28DynamicFiltersSelector3 ;
      AV73Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 = AV29DynamicFiltersOperator3 ;
      AV74Wwpbaseobjects_secrolewwds_11_secrolename3 = AV30SecRoleName3 ;
      AV75Wwpbaseobjects_secrolewwds_12_tfsecrolename = AV35TFSecRoleName ;
      AV76Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels = AV53TFSecRoleName_Sels ;
      AV77Wwpbaseobjects_secrolewwds_14_tfsecroledescription = AV37TFSecRoleDescription ;
      AV78Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels = AV55TFSecRoleDescription_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A355SecRoleName ,
                                           AV76Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels ,
                                           A354SecRoleDescription ,
                                           AV78Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels ,
                                           AV64Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 ,
                                           Short.valueOf(AV65Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1) ,
                                           AV66Wwpbaseobjects_secrolewwds_3_secrolename1 ,
                                           Boolean.valueOf(AV67Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2) ,
                                           AV68Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 ,
                                           Short.valueOf(AV69Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2) ,
                                           AV70Wwpbaseobjects_secrolewwds_7_secrolename2 ,
                                           Boolean.valueOf(AV71Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3) ,
                                           AV72Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 ,
                                           Short.valueOf(AV73Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3) ,
                                           AV74Wwpbaseobjects_secrolewwds_11_secrolename3 ,
                                           Integer.valueOf(AV76Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels.size()) ,
                                           AV75Wwpbaseobjects_secrolewwds_12_tfsecrolename ,
                                           Integer.valueOf(AV78Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels.size()) ,
                                           AV77Wwpbaseobjects_secrolewwds_14_tfsecroledescription ,
                                           Short.valueOf(AV16OrderedBy) ,
                                           Boolean.valueOf(AV17OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV66Wwpbaseobjects_secrolewwds_3_secrolename1 = GXutil.concat( GXutil.rtrim( AV66Wwpbaseobjects_secrolewwds_3_secrolename1), "%", "") ;
      lV66Wwpbaseobjects_secrolewwds_3_secrolename1 = GXutil.concat( GXutil.rtrim( AV66Wwpbaseobjects_secrolewwds_3_secrolename1), "%", "") ;
      lV70Wwpbaseobjects_secrolewwds_7_secrolename2 = GXutil.concat( GXutil.rtrim( AV70Wwpbaseobjects_secrolewwds_7_secrolename2), "%", "") ;
      lV70Wwpbaseobjects_secrolewwds_7_secrolename2 = GXutil.concat( GXutil.rtrim( AV70Wwpbaseobjects_secrolewwds_7_secrolename2), "%", "") ;
      lV74Wwpbaseobjects_secrolewwds_11_secrolename3 = GXutil.concat( GXutil.rtrim( AV74Wwpbaseobjects_secrolewwds_11_secrolename3), "%", "") ;
      lV74Wwpbaseobjects_secrolewwds_11_secrolename3 = GXutil.concat( GXutil.rtrim( AV74Wwpbaseobjects_secrolewwds_11_secrolename3), "%", "") ;
      lV75Wwpbaseobjects_secrolewwds_12_tfsecrolename = GXutil.concat( GXutil.rtrim( AV75Wwpbaseobjects_secrolewwds_12_tfsecrolename), "%", "") ;
      lV77Wwpbaseobjects_secrolewwds_14_tfsecroledescription = GXutil.concat( GXutil.rtrim( AV77Wwpbaseobjects_secrolewwds_14_tfsecroledescription), "%", "") ;
      /* Using cursor P00BW2 */
      pr_default.execute(0, new Object[] {lV66Wwpbaseobjects_secrolewwds_3_secrolename1, lV66Wwpbaseobjects_secrolewwds_3_secrolename1, lV70Wwpbaseobjects_secrolewwds_7_secrolename2, lV70Wwpbaseobjects_secrolewwds_7_secrolename2, lV74Wwpbaseobjects_secrolewwds_11_secrolename3, lV74Wwpbaseobjects_secrolewwds_11_secrolename3, lV75Wwpbaseobjects_secrolewwds_12_tfsecrolename, lV77Wwpbaseobjects_secrolewwds_14_tfsecroledescription});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A354SecRoleDescription = P00BW2_A354SecRoleDescription[0] ;
         A355SecRoleName = P00BW2_A355SecRoleName[0] ;
         A65SecRoleId = P00BW2_A65SecRoleId[0] ;
         AV13CellRow = (int)(AV13CellRow+1) ;
         /* Execute user subroutine: 'BEFOREWRITELINE' */
         S162 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A355SecRoleName, GXv_char5) ;
         secrolewwexport.this.GXt_char4 = GXv_char5[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+0, 1, 1).setText( GXt_char4 );
         GXt_char4 = "" ;
         GXv_char5[0] = GXt_char4 ;
         new web.wwpbaseobjects.wwp_export_securetext(remoteHandle, context).execute( A354SecRoleDescription, GXv_char5) ;
         secrolewwexport.this.GXt_char4 = GXv_char5[0] ;
         AV10ExcelDocument.Cells(AV13CellRow, AV14FirstColumn+1, 1, 1).setText( GXt_char4 );
         /* Execute user subroutine: 'AFTERWRITELINE' */
         S172 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            returnInSub = true;
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S181( )
   {
      /* 'CLOSEDOCUMENT' Routine */
      returnInSub = false ;
      AV10ExcelDocument.Save();
      /* Execute user subroutine: 'CHECKSTATUS' */
      S121 ();
      if (returnInSub) return;
      AV10ExcelDocument.Close();
   }

   public void S121( )
   {
      /* 'CHECKSTATUS' Routine */
      returnInSub = false ;
      if ( AV10ExcelDocument.getErrCode() != 0 )
      {
         AV11Filename = "" ;
         AV12ErrorMessage = AV10ExcelDocument.getErrDescription() ;
         AV10ExcelDocument.Close();
         returnInSub = true;
         if (true) return;
      }
   }

   public void S191( )
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV41Session.getValue("WWPBaseObjects.SecRoleWWGridState"), "") == 0 )
      {
         AV33GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WWPBaseObjects.SecRoleWWGridState"), null, null);
      }
      else
      {
         AV33GridState.fromxml(AV41Session.getValue("WWPBaseObjects.SecRoleWWGridState"), null, null);
      }
      AV16OrderedBy = AV33GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV17OrderedDsc = AV33GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV79GXV3 = 1 ;
      while ( AV79GXV3 <= AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV51GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV33GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV79GXV3));
         if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLENAME") == 0 )
         {
            AV35TFSecRoleName = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLENAME_SEL") == 0 )
         {
            AV52TFSecRoleName_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV53TFSecRoleName_Sels.fromJSonString(AV52TFSecRoleName_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION") == 0 )
         {
            AV37TFSecRoleDescription = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION_SEL") == 0 )
         {
            AV54TFSecRoleDescription_SelsJson = AV51GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV55TFSecRoleDescription_Sels.fromJSonString(AV54TFSecRoleDescription_SelsJson, null);
         }
         AV79GXV3 = (int)(AV79GXV3+1) ;
      }
   }

   public void S162( )
   {
      /* 'BEFOREWRITELINE' Routine */
      returnInSub = false ;
   }

   public void S172( )
   {
      /* 'AFTERWRITELINE' Routine */
      returnInSub = false ;
   }

   protected void cleanup( )
   {
      this.aP0[0] = secrolewwexport.this.AV11Filename;
      this.aP1[0] = secrolewwexport.this.AV12ErrorMessage;
      CloseOpenCursors();
      AV10ExcelDocument.cleanup();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11Filename = "" ;
      AV12ErrorMessage = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV60Pgmname = "" ;
      AV50WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV10ExcelDocument = new com.genexus.gxoffice.ExcelDoc();
      AV33GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV34GridStateDynamicFilter = new web.wwpbaseobjects.SdtWWPGridState_DynamicFilter(remoteHandle, context);
      AV18DynamicFiltersSelector1 = "" ;
      AV20SecRoleName1 = "" ;
      AV23DynamicFiltersSelector2 = "" ;
      AV25SecRoleName2 = "" ;
      AV28DynamicFiltersSelector3 = "" ;
      AV30SecRoleName3 = "" ;
      AV53TFSecRoleName_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV36TFSecRoleName_Sel = "" ;
      AV35TFSecRoleName = "" ;
      AV55TFSecRoleDescription_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV38TFSecRoleDescription_Sel = "" ;
      AV37TFSecRoleDescription = "" ;
      GXv_exceldoc6 = new com.genexus.gxoffice.ExcelDoc[1] ;
      GXv_int7 = new short[1] ;
      A355SecRoleName = "" ;
      A354SecRoleDescription = "" ;
      AV64Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 = "" ;
      AV66Wwpbaseobjects_secrolewwds_3_secrolename1 = "" ;
      AV68Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 = "" ;
      AV70Wwpbaseobjects_secrolewwds_7_secrolename2 = "" ;
      AV72Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 = "" ;
      AV74Wwpbaseobjects_secrolewwds_11_secrolename3 = "" ;
      AV75Wwpbaseobjects_secrolewwds_12_tfsecrolename = "" ;
      AV76Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV77Wwpbaseobjects_secrolewwds_14_tfsecroledescription = "" ;
      AV78Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV66Wwpbaseobjects_secrolewwds_3_secrolename1 = "" ;
      lV70Wwpbaseobjects_secrolewwds_7_secrolename2 = "" ;
      lV74Wwpbaseobjects_secrolewwds_11_secrolename3 = "" ;
      lV75Wwpbaseobjects_secrolewwds_12_tfsecrolename = "" ;
      lV77Wwpbaseobjects_secrolewwds_14_tfsecroledescription = "" ;
      P00BW2_A354SecRoleDescription = new String[] {""} ;
      P00BW2_A355SecRoleName = new String[] {""} ;
      P00BW2_A65SecRoleId = new short[1] ;
      GXt_char4 = "" ;
      GXv_char5 = new String[1] ;
      AV41Session = httpContext.getWebSession();
      AV51GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV52TFSecRoleName_SelsJson = "" ;
      AV54TFSecRoleDescription_SelsJson = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.secrolewwexport__default(),
         new Object[] {
             new Object[] {
            P00BW2_A354SecRoleDescription, P00BW2_A355SecRoleName, P00BW2_A65SecRoleId
            }
         }
      );
      AV60Pgmname = "WWPBaseObjects.SecRoleWWExport" ;
      /* GeneXus formulas. */
      AV60Pgmname = "WWPBaseObjects.SecRoleWWExport" ;
      Gx_err = (short)(0) ;
   }

   private short AV19DynamicFiltersOperator1 ;
   private short AV24DynamicFiltersOperator2 ;
   private short AV29DynamicFiltersOperator3 ;
   private short GXv_int7[] ;
   private short AV65Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 ;
   private short AV69Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 ;
   private short AV73Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 ;
   private short AV16OrderedBy ;
   private short A65SecRoleId ;
   private short Gx_err ;
   private int AV13CellRow ;
   private int AV14FirstColumn ;
   private int AV15Random ;
   private int AV61GXV1 ;
   private int AV62GXV2 ;
   private int AV76Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size ;
   private int AV78Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size ;
   private int AV79GXV3 ;
   private long AV46i ;
   private String AV60Pgmname ;
   private String scmdbuf ;
   private String GXt_char4 ;
   private String GXv_char5[] ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV22DynamicFiltersEnabled2 ;
   private boolean AV27DynamicFiltersEnabled3 ;
   private boolean AV67Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 ;
   private boolean AV71Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 ;
   private boolean AV17OrderedDsc ;
   private String AV52TFSecRoleName_SelsJson ;
   private String AV54TFSecRoleDescription_SelsJson ;
   private String AV11Filename ;
   private String AV12ErrorMessage ;
   private String AV18DynamicFiltersSelector1 ;
   private String AV20SecRoleName1 ;
   private String AV23DynamicFiltersSelector2 ;
   private String AV25SecRoleName2 ;
   private String AV28DynamicFiltersSelector3 ;
   private String AV30SecRoleName3 ;
   private String AV36TFSecRoleName_Sel ;
   private String AV35TFSecRoleName ;
   private String AV38TFSecRoleDescription_Sel ;
   private String AV37TFSecRoleDescription ;
   private String A355SecRoleName ;
   private String A354SecRoleDescription ;
   private String AV64Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 ;
   private String AV66Wwpbaseobjects_secrolewwds_3_secrolename1 ;
   private String AV68Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 ;
   private String AV70Wwpbaseobjects_secrolewwds_7_secrolename2 ;
   private String AV72Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 ;
   private String AV74Wwpbaseobjects_secrolewwds_11_secrolename3 ;
   private String AV75Wwpbaseobjects_secrolewwds_12_tfsecrolename ;
   private String AV77Wwpbaseobjects_secrolewwds_14_tfsecroledescription ;
   private String lV66Wwpbaseobjects_secrolewwds_3_secrolename1 ;
   private String lV70Wwpbaseobjects_secrolewwds_7_secrolename2 ;
   private String lV74Wwpbaseobjects_secrolewwds_11_secrolename3 ;
   private String lV75Wwpbaseobjects_secrolewwds_12_tfsecrolename ;
   private String lV77Wwpbaseobjects_secrolewwds_14_tfsecroledescription ;
   private com.genexus.webpanels.WebSession AV41Session ;
   private GXSimpleCollection<String> AV53TFSecRoleName_Sels ;
   private GXSimpleCollection<String> AV55TFSecRoleDescription_Sels ;
   private String[] aP1 ;
   private String[] aP0 ;
   private IDataStoreProvider pr_default ;
   private String[] P00BW2_A354SecRoleDescription ;
   private String[] P00BW2_A355SecRoleName ;
   private short[] P00BW2_A65SecRoleId ;
   private com.genexus.gxoffice.ExcelDoc AV10ExcelDocument ;
   private com.genexus.gxoffice.ExcelDoc GXv_exceldoc6[] ;
   private GXSimpleCollection<String> AV76Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels ;
   private GXSimpleCollection<String> AV78Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels ;
   private web.wwpbaseobjects.SdtWWPGridState AV33GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV51GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPGridState_DynamicFilter AV34GridStateDynamicFilter ;
   private web.wwpbaseobjects.SdtWWPContext AV50WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
}

final  class secrolewwexport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00BW2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A355SecRoleName ,
                                          GXSimpleCollection<String> AV76Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels ,
                                          String A354SecRoleDescription ,
                                          GXSimpleCollection<String> AV78Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels ,
                                          String AV64Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 ,
                                          short AV65Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 ,
                                          String AV66Wwpbaseobjects_secrolewwds_3_secrolename1 ,
                                          boolean AV67Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 ,
                                          String AV68Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 ,
                                          short AV69Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 ,
                                          String AV70Wwpbaseobjects_secrolewwds_7_secrolename2 ,
                                          boolean AV71Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 ,
                                          String AV72Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 ,
                                          short AV73Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 ,
                                          String AV74Wwpbaseobjects_secrolewwds_11_secrolename3 ,
                                          int AV76Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size ,
                                          String AV75Wwpbaseobjects_secrolewwds_12_tfsecrolename ,
                                          int AV78Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size ,
                                          String AV77Wwpbaseobjects_secrolewwds_14_tfsecroledescription ,
                                          short AV16OrderedBy ,
                                          boolean AV17OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[8];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT SecRoleDescription, SecRoleName, SecRoleId FROM SecRole" ;
      if ( ( GXutil.strcmp(AV64Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV65Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 == 0 ) && ( ! (GXutil.strcmp("", AV66Wwpbaseobjects_secrolewwds_3_secrolename1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      if ( ( GXutil.strcmp(AV64Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV65Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 == 1 ) && ( ! (GXutil.strcmp("", AV66Wwpbaseobjects_secrolewwds_3_secrolename1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int8[1] = (byte)(1) ;
      }
      if ( AV67Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 && ( GXutil.strcmp(AV68Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV69Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 == 0 ) && ( ! (GXutil.strcmp("", AV70Wwpbaseobjects_secrolewwds_7_secrolename2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int8[2] = (byte)(1) ;
      }
      if ( AV67Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 && ( GXutil.strcmp(AV68Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV69Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 == 1 ) && ( ! (GXutil.strcmp("", AV70Wwpbaseobjects_secrolewwds_7_secrolename2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int8[3] = (byte)(1) ;
      }
      if ( AV71Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 && ( GXutil.strcmp(AV72Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV73Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 == 0 ) && ( ! (GXutil.strcmp("", AV74Wwpbaseobjects_secrolewwds_11_secrolename3)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int8[4] = (byte)(1) ;
      }
      if ( AV71Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 && ( GXutil.strcmp(AV72Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV73Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 == 1 ) && ( ! (GXutil.strcmp("", AV74Wwpbaseobjects_secrolewwds_11_secrolename3)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int8[5] = (byte)(1) ;
      }
      if ( ( AV76Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV75Wwpbaseobjects_secrolewwds_12_tfsecrolename)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int8[6] = (byte)(1) ;
      }
      if ( AV76Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV76Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels, "SecRoleName IN (", ")")+")");
      }
      if ( ( AV78Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV77Wwpbaseobjects_secrolewwds_14_tfsecroledescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleDescription) like LOWER(?))");
      }
      else
      {
         GXv_int8[7] = (byte)(1) ;
      }
      if ( AV78Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV78Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels, "SecRoleDescription IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV16OrderedBy == 1 ) && ! AV17OrderedDsc )
      {
         scmdbuf += " ORDER BY SecRoleName" ;
      }
      else if ( ( AV16OrderedBy == 1 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SecRoleName DESC" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ! AV17OrderedDsc )
      {
         scmdbuf += " ORDER BY SecRoleDescription" ;
      }
      else if ( ( AV16OrderedBy == 2 ) && ( AV17OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SecRoleDescription DESC" ;
      }
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
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
                  return conditional_P00BW2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , (String)dynConstraints[6] , ((Boolean) dynConstraints[7]).booleanValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , (String)dynConstraints[10] , ((Boolean) dynConstraints[11]).booleanValue() , (String)dynConstraints[12] , ((Number) dynConstraints[13]).shortValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , ((Boolean) dynConstraints[20]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00BW2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
      }
   }

}

