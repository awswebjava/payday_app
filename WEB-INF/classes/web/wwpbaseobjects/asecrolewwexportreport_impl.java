package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class asecrolewwexportreport_impl extends GXWebReport
{
   public asecrolewwexportreport_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public void webExecute( )
   {
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetNextPar( ) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( toggleJsOutput )
      {
      }
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      httpContext.setDefaultTheme("WorkWithPlusDS");
      M_top = 0 ;
      M_bot = 6 ;
      P_lines = (int)(66-M_bot) ;
      getPrinter().GxClearAttris() ;
      add_metrics( ) ;
      lineHeight = 15 ;
      PrtOffset = 0 ;
      gxXPage = 100 ;
      gxYPage = 100 ;
      getPrinter().GxSetDocName("") ;
      try
      {
         Gx_out = "FIL" ;
         if (!initPrinter (Gx_out, gxXPage, gxYPage, "GXPRN.INI", "", "", 2, 1, 1, 15840, 12240, 0, 1, 1, 0, 1, 1) )
         {
            cleanup();
            return;
         }
         getPrinter().setModal(true) ;
         P_lines = (int)(gxYPage-(lineHeight*6)) ;
         Gx_line = (int)(P_lines+1) ;
         getPrinter().setPageLines(P_lines);
         getPrinter().setLineHeight(lineHeight);
         getPrinter().setM_top(M_top);
         getPrinter().setM_bot(M_bot);
         GXt_boolean1 = AV8IsAuthorized ;
         GXv_boolean2[0] = GXt_boolean1 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWSecRole", GXv_boolean2) ;
         asecrolewwexportreport_impl.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV8IsAuthorized = GXt_boolean1 ;
         if ( ! AV8IsAuthorized )
         {
            callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV65Pgmname))}, new String[] {"GxObject"}) );
            httpContext.wjLocDisableFrm = (byte)(1) ;
         }
         if ( AV8IsAuthorized )
         {
            GXv_SdtWWPContext3[0] = AV37WWPContext;
            new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
            AV37WWPContext = GXv_SdtWWPContext3[0] ;
            /* Execute user subroutine: 'LOADGRIDSTATE' */
            S151 ();
            if ( returnInSub )
            {
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV61Title = httpContext.getMessage( "Lista de Role", "") ;
            /* Execute user subroutine: 'PRINTFILTERS' */
            S111 ();
            if ( returnInSub )
            {
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            /* Execute user subroutine: 'PRINTCOLUMNTITLES' */
            S121 ();
            if ( returnInSub )
            {
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            /* Execute user subroutine: 'PRINTDATA' */
            S131 ();
            if ( returnInSub )
            {
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            /* Execute user subroutine: 'PRINTFOOTER' */
            S171 ();
            if ( returnInSub )
            {
               getPrinter().GxEndPage() ;
               /* Close printer file */
               getPrinter().GxEndDocument() ;
               endPrinter();
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         /* Print footer for last page */
         ToSkip = (int)(P_lines+1) ;
         hBX0( true, 0) ;
         /* Close printer file */
         getPrinter().GxEndDocument() ;
         endPrinter();
      }
      catch ( ProcessInterruptedException e )
      {
      }
      if ( httpContext.willRedirect( ) )
      {
         httpContext.redirect( httpContext.wjLoc );
         httpContext.wjLoc = "" ;
      }
      cleanup();
   }

   public void S111( ) throws ProcessInterruptedException
   {
      /* 'PRINTFILTERS' Routine */
      returnInSub = false ;
      if ( AV27GridState.getgxTv_SdtWWPGridState_Dynamicfilters().size() >= 1 )
      {
         AV28GridStateDynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)((web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)AV27GridState.getgxTv_SdtWWPGridState_Dynamicfilters().elementAt(-1+1));
         AV12DynamicFiltersSelector1 = AV28GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Selected() ;
         if ( GXutil.strcmp(AV12DynamicFiltersSelector1, "SECROLENAME") == 0 )
         {
            AV13DynamicFiltersOperator1 = AV28GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Operator() ;
            AV14SecRoleName1 = AV28GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value() ;
            if ( ! (GXutil.strcmp("", AV14SecRoleName1)==0) )
            {
               if ( AV13DynamicFiltersOperator1 == 0 )
               {
                  AV29FilterSecRoleNameDescription = GXutil.format( "%1 (%2)", httpContext.getMessage( "Name", ""), httpContext.getMessage( "WWP_FilterLike", ""), "", "", "", "", "", "", "") ;
               }
               else if ( AV13DynamicFiltersOperator1 == 1 )
               {
                  AV29FilterSecRoleNameDescription = GXutil.format( "%1 (%2)", httpContext.getMessage( "Name", ""), httpContext.getMessage( "WWP_FilterContains", ""), "", "", "", "", "", "", "") ;
               }
               AV30SecRoleName = AV14SecRoleName1 ;
               hBX0( false, 20) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV29FilterSecRoleNameDescription, "")), 25, Gx_line+0, 140, Gx_line+15, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30SecRoleName, "")), 140, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
               Gx_OldLine = Gx_line ;
               Gx_line = (int)(Gx_line+20) ;
            }
         }
         if ( AV27GridState.getgxTv_SdtWWPGridState_Dynamicfilters().size() >= 2 )
         {
            AV16DynamicFiltersEnabled2 = true ;
            AV28GridStateDynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)((web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)AV27GridState.getgxTv_SdtWWPGridState_Dynamicfilters().elementAt(-1+2));
            AV17DynamicFiltersSelector2 = AV28GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Selected() ;
            if ( GXutil.strcmp(AV17DynamicFiltersSelector2, "SECROLENAME") == 0 )
            {
               AV18DynamicFiltersOperator2 = AV28GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Operator() ;
               AV19SecRoleName2 = AV28GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value() ;
               if ( ! (GXutil.strcmp("", AV19SecRoleName2)==0) )
               {
                  if ( AV18DynamicFiltersOperator2 == 0 )
                  {
                     AV29FilterSecRoleNameDescription = GXutil.format( "%1 (%2)", httpContext.getMessage( "Name", ""), httpContext.getMessage( "WWP_FilterLike", ""), "", "", "", "", "", "", "") ;
                  }
                  else if ( AV18DynamicFiltersOperator2 == 1 )
                  {
                     AV29FilterSecRoleNameDescription = GXutil.format( "%1 (%2)", httpContext.getMessage( "Name", ""), httpContext.getMessage( "WWP_FilterContains", ""), "", "", "", "", "", "", "") ;
                  }
                  AV30SecRoleName = AV19SecRoleName2 ;
                  hBX0( false, 20) ;
                  getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
                  getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV29FilterSecRoleNameDescription, "")), 25, Gx_line+0, 140, Gx_line+15, 0, 0, 0, 0) ;
                  getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
                  getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30SecRoleName, "")), 140, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
                  Gx_OldLine = Gx_line ;
                  Gx_line = (int)(Gx_line+20) ;
               }
            }
            if ( AV27GridState.getgxTv_SdtWWPGridState_Dynamicfilters().size() >= 3 )
            {
               AV21DynamicFiltersEnabled3 = true ;
               AV28GridStateDynamicFilter = (web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)((web.wwpbaseobjects.SdtWWPGridState_DynamicFilter)AV27GridState.getgxTv_SdtWWPGridState_Dynamicfilters().elementAt(-1+3));
               AV22DynamicFiltersSelector3 = AV28GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Selected() ;
               if ( GXutil.strcmp(AV22DynamicFiltersSelector3, "SECROLENAME") == 0 )
               {
                  AV23DynamicFiltersOperator3 = AV28GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Operator() ;
                  AV24SecRoleName3 = AV28GridStateDynamicFilter.getgxTv_SdtWWPGridState_DynamicFilter_Value() ;
                  if ( ! (GXutil.strcmp("", AV24SecRoleName3)==0) )
                  {
                     if ( AV23DynamicFiltersOperator3 == 0 )
                     {
                        AV29FilterSecRoleNameDescription = GXutil.format( "%1 (%2)", httpContext.getMessage( "Name", ""), httpContext.getMessage( "WWP_FilterLike", ""), "", "", "", "", "", "", "") ;
                     }
                     else if ( AV23DynamicFiltersOperator3 == 1 )
                     {
                        AV29FilterSecRoleNameDescription = GXutil.format( "%1 (%2)", httpContext.getMessage( "Name", ""), httpContext.getMessage( "WWP_FilterContains", ""), "", "", "", "", "", "", "") ;
                     }
                     AV30SecRoleName = AV24SecRoleName3 ;
                     hBX0( false, 20) ;
                     getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
                     getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV29FilterSecRoleNameDescription, "")), 25, Gx_line+0, 140, Gx_line+15, 0, 0, 0, 0) ;
                     getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
                     getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV30SecRoleName, "")), 140, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
                     Gx_OldLine = Gx_line ;
                     Gx_line = (int)(Gx_line+20) ;
                  }
               }
            }
         }
      }
      AV42TFSecRoleName_Sels.fromJSonString(AV40TFSecRoleName_SelsJson, null);
      if ( ! ( AV42TFSecRoleName_Sels.size() == 0 ) )
      {
         AV48i = 1 ;
         AV68GXV1 = 1 ;
         while ( AV68GXV1 <= AV42TFSecRoleName_Sels.size() )
         {
            AV34TFSecRoleName_Sel = (String)AV42TFSecRoleName_Sels.elementAt(-1+AV68GXV1) ;
            if ( AV48i == 1 )
            {
               AV41TFSecRoleName_SelDscs = "" ;
            }
            else
            {
               AV41TFSecRoleName_SelDscs += ", " ;
            }
            AV41TFSecRoleName_SelDscs += GXutil.trim( AV34TFSecRoleName_Sel) ;
            AV48i = (long)(AV48i+1) ;
            AV68GXV1 = (int)(AV68GXV1+1) ;
         }
         hBX0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(httpContext.getMessage( "Name", ""), 25, Gx_line+0, 140, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV41TFSecRoleName_SelDscs, "")), 140, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV33TFSecRoleName)==0) )
         {
            hBX0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(httpContext.getMessage( "Name", ""), 25, Gx_line+0, 140, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV33TFSecRoleName, "")), 140, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
      AV45TFSecRoleDescription_Sels.fromJSonString(AV43TFSecRoleDescription_SelsJson, null);
      if ( ! ( AV45TFSecRoleDescription_Sels.size() == 0 ) )
      {
         AV48i = 1 ;
         AV69GXV2 = 1 ;
         while ( AV69GXV2 <= AV45TFSecRoleDescription_Sels.size() )
         {
            AV36TFSecRoleDescription_Sel = (String)AV45TFSecRoleDescription_Sels.elementAt(-1+AV69GXV2) ;
            if ( AV48i == 1 )
            {
               AV44TFSecRoleDescription_SelDscs = "" ;
            }
            else
            {
               AV44TFSecRoleDescription_SelDscs += ", " ;
            }
            AV44TFSecRoleDescription_SelDscs += GXutil.trim( AV36TFSecRoleDescription_Sel) ;
            AV48i = (long)(AV48i+1) ;
            AV69GXV2 = (int)(AV69GXV2+1) ;
         }
         hBX0( false, 20) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(httpContext.getMessage( "Description", ""), 25, Gx_line+0, 140, Gx_line+15, 0, 0, 0, 0) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV44TFSecRoleDescription_SelDscs, "")), 140, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+20) ;
      }
      else
      {
         if ( ! (GXutil.strcmp("", AV35TFSecRoleDescription)==0) )
         {
            hBX0( false, 20) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 169, 169, 169, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(httpContext.getMessage( "Description", ""), 25, Gx_line+0, 140, Gx_line+15, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV35TFSecRoleDescription, "")), 140, Gx_line+0, 789, Gx_line+15, 0, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+20) ;
         }
      }
   }

   public void S121( ) throws ProcessInterruptedException
   {
      /* 'PRINTCOLUMNTITLES' Routine */
      returnInSub = false ;
      hBX0( false, 22) ;
      getPrinter().GxDrawLine(25, Gx_line+21, 789, Gx_line+21, 2, 79, 70, 229, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+22) ;
      hBX0( false, 37) ;
      getPrinter().GxAttris("Microsoft Sans Serif", 9, false, false, false, false, 0, 79, 70, 229, 0, 255, 255, 255) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Name", ""), 30, Gx_line+10, 406, Gx_line+27, 0, 0, 0, 0) ;
      getPrinter().GxDrawText(httpContext.getMessage( "Description", ""), 410, Gx_line+10, 787, Gx_line+27, 0, 0, 0, 0) ;
      Gx_OldLine = Gx_line ;
      Gx_line = (int)(Gx_line+37) ;
   }

   public void S131( ) throws ProcessInterruptedException
   {
      /* 'PRINTDATA' Routine */
      returnInSub = false ;
      AV71Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 = AV12DynamicFiltersSelector1 ;
      AV72Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 = AV13DynamicFiltersOperator1 ;
      AV73Wwpbaseobjects_secrolewwds_3_secrolename1 = AV14SecRoleName1 ;
      AV74Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 = AV16DynamicFiltersEnabled2 ;
      AV75Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 = AV17DynamicFiltersSelector2 ;
      AV76Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 = AV18DynamicFiltersOperator2 ;
      AV77Wwpbaseobjects_secrolewwds_7_secrolename2 = AV19SecRoleName2 ;
      AV78Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 = AV21DynamicFiltersEnabled3 ;
      AV79Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 = AV22DynamicFiltersSelector3 ;
      AV80Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 = AV23DynamicFiltersOperator3 ;
      AV81Wwpbaseobjects_secrolewwds_11_secrolename3 = AV24SecRoleName3 ;
      AV82Wwpbaseobjects_secrolewwds_12_tfsecrolename = AV33TFSecRoleName ;
      AV83Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels = AV42TFSecRoleName_Sels ;
      AV84Wwpbaseobjects_secrolewwds_14_tfsecroledescription = AV35TFSecRoleDescription ;
      AV85Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels = AV45TFSecRoleDescription_Sels ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           A355SecRoleName ,
                                           AV83Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels ,
                                           A354SecRoleDescription ,
                                           AV85Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels ,
                                           AV71Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 ,
                                           Short.valueOf(AV72Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1) ,
                                           AV73Wwpbaseobjects_secrolewwds_3_secrolename1 ,
                                           Boolean.valueOf(AV74Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2) ,
                                           AV75Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 ,
                                           Short.valueOf(AV76Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2) ,
                                           AV77Wwpbaseobjects_secrolewwds_7_secrolename2 ,
                                           Boolean.valueOf(AV78Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3) ,
                                           AV79Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 ,
                                           Short.valueOf(AV80Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3) ,
                                           AV81Wwpbaseobjects_secrolewwds_11_secrolename3 ,
                                           Integer.valueOf(AV83Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels.size()) ,
                                           AV82Wwpbaseobjects_secrolewwds_12_tfsecrolename ,
                                           Integer.valueOf(AV85Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels.size()) ,
                                           AV84Wwpbaseobjects_secrolewwds_14_tfsecroledescription ,
                                           Short.valueOf(AV10OrderedBy) ,
                                           Boolean.valueOf(AV11OrderedDsc) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.BOOLEAN,
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.BOOLEAN
                                           }
      });
      lV73Wwpbaseobjects_secrolewwds_3_secrolename1 = GXutil.concat( GXutil.rtrim( AV73Wwpbaseobjects_secrolewwds_3_secrolename1), "%", "") ;
      lV73Wwpbaseobjects_secrolewwds_3_secrolename1 = GXutil.concat( GXutil.rtrim( AV73Wwpbaseobjects_secrolewwds_3_secrolename1), "%", "") ;
      lV77Wwpbaseobjects_secrolewwds_7_secrolename2 = GXutil.concat( GXutil.rtrim( AV77Wwpbaseobjects_secrolewwds_7_secrolename2), "%", "") ;
      lV77Wwpbaseobjects_secrolewwds_7_secrolename2 = GXutil.concat( GXutil.rtrim( AV77Wwpbaseobjects_secrolewwds_7_secrolename2), "%", "") ;
      lV81Wwpbaseobjects_secrolewwds_11_secrolename3 = GXutil.concat( GXutil.rtrim( AV81Wwpbaseobjects_secrolewwds_11_secrolename3), "%", "") ;
      lV81Wwpbaseobjects_secrolewwds_11_secrolename3 = GXutil.concat( GXutil.rtrim( AV81Wwpbaseobjects_secrolewwds_11_secrolename3), "%", "") ;
      lV82Wwpbaseobjects_secrolewwds_12_tfsecrolename = GXutil.concat( GXutil.rtrim( AV82Wwpbaseobjects_secrolewwds_12_tfsecrolename), "%", "") ;
      lV84Wwpbaseobjects_secrolewwds_14_tfsecroledescription = GXutil.concat( GXutil.rtrim( AV84Wwpbaseobjects_secrolewwds_14_tfsecroledescription), "%", "") ;
      /* Using cursor P00BX2 */
      pr_default.execute(0, new Object[] {lV73Wwpbaseobjects_secrolewwds_3_secrolename1, lV73Wwpbaseobjects_secrolewwds_3_secrolename1, lV77Wwpbaseobjects_secrolewwds_7_secrolename2, lV77Wwpbaseobjects_secrolewwds_7_secrolename2, lV81Wwpbaseobjects_secrolewwds_11_secrolename3, lV81Wwpbaseobjects_secrolewwds_11_secrolename3, lV82Wwpbaseobjects_secrolewwds_12_tfsecrolename, lV84Wwpbaseobjects_secrolewwds_14_tfsecroledescription});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A354SecRoleDescription = P00BX2_A354SecRoleDescription[0] ;
         A355SecRoleName = P00BX2_A355SecRoleName[0] ;
         A65SecRoleId = P00BX2_A65SecRoleId[0] ;
         /* Execute user subroutine: 'BEFOREPRINTLINE' */
         S144 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            getPrinter().GxEndPage() ;
            /* Close printer file */
            getPrinter().GxEndDocument() ;
            endPrinter();
            returnInSub = true;
            if (true) return;
         }
         hBX0( false, 36) ;
         getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 0, 0, 0, 0, 255, 255, 255) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A355SecRoleName, "")), 30, Gx_line+10, 406, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( A354SecRoleDescription, "")), 410, Gx_line+10, 787, Gx_line+25, 0, 0, 0, 0) ;
         getPrinter().GxDrawLine(28, Gx_line+35, 789, Gx_line+35, 1, 220, 220, 220, 0) ;
         Gx_OldLine = Gx_line ;
         Gx_line = (int)(Gx_line+36) ;
         /* Execute user subroutine: 'AFTERPRINTLINE' */
         S161 ();
         if ( returnInSub )
         {
            pr_default.close(0);
            getPrinter().GxEndPage() ;
            /* Close printer file */
            getPrinter().GxEndDocument() ;
            endPrinter();
            returnInSub = true;
            if (true) return;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
   }

   public void S151( ) throws ProcessInterruptedException
   {
      /* 'LOADGRIDSTATE' Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(AV38Session.getValue("WWPBaseObjects.SecRoleWWGridState"), "") == 0 )
      {
         AV27GridState.fromxml(new web.wwpbaseobjects.loadgridstate(remoteHandle, context).executeUdp( "WWPBaseObjects.SecRoleWWGridState"), null, null);
      }
      else
      {
         AV27GridState.fromxml(AV38Session.getValue("WWPBaseObjects.SecRoleWWGridState"), null, null);
      }
      AV10OrderedBy = AV27GridState.getgxTv_SdtWWPGridState_Orderedby() ;
      AV11OrderedDsc = AV27GridState.getgxTv_SdtWWPGridState_Ordereddsc() ;
      AV86GXV3 = 1 ;
      while ( AV86GXV3 <= AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV39GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV27GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV86GXV3));
         if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLENAME") == 0 )
         {
            AV33TFSecRoleName = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLENAME_SEL") == 0 )
         {
            AV40TFSecRoleName_SelsJson = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV42TFSecRoleName_Sels.fromJSonString(AV40TFSecRoleName_SelsJson, null);
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION") == 0 )
         {
            AV35TFSecRoleDescription = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
         }
         else if ( GXutil.strcmp(AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "TFSECROLEDESCRIPTION_SEL") == 0 )
         {
            AV43TFSecRoleDescription_SelsJson = AV39GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
            AV45TFSecRoleDescription_Sels.fromJSonString(AV43TFSecRoleDescription_SelsJson, null);
         }
         AV86GXV3 = (int)(AV86GXV3+1) ;
      }
   }

   public void S144( ) throws ProcessInterruptedException
   {
      /* 'BEFOREPRINTLINE' Routine */
      returnInSub = false ;
   }

   public void S161( ) throws ProcessInterruptedException
   {
      /* 'AFTERPRINTLINE' Routine */
      returnInSub = false ;
   }

   public void S171( ) throws ProcessInterruptedException
   {
      /* 'PRINTFOOTER' Routine */
      returnInSub = false ;
   }

   public void hBX0( boolean bFoot ,
                     int Inc )
   {
      /* Skip the required number of lines */
      while ( ( ToSkip > 0 ) || ( Gx_line + Inc > P_lines ) )
      {
         if ( Gx_line + Inc >= P_lines )
         {
            if ( Gx_page > 0 )
            {
               /* Print footers */
               Gx_line = P_lines ;
               AV59PageInfo = httpContext.getMessage( "Page: ", "") + GXutil.trim( GXutil.str( Gx_page, 6, 0)) ;
               AV56DateInfo = httpContext.getMessage( "Date: ", "") + localUtil.format( Gx_date, "99/99/99") ;
               getPrinter().GxDrawRect(0, Gx_line+5, 819, Gx_line+40, 1, 0, 0, 0, 1, 79, 70, 229, 1, 1, 1, 1, 0, 0, 0, 0) ;
               getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV59PageInfo, "")), 30, Gx_line+15, 409, Gx_line+30, 0, 0, 0, 0) ;
               getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV56DateInfo, "")), 409, Gx_line+15, 789, Gx_line+30, 2, 0, 0, 0) ;
               Gx_OldLine = Gx_line ;
               Gx_line = (int)(Gx_line+40) ;
               getPrinter().GxEndPage() ;
               if ( bFoot )
               {
                  return  ;
               }
            }
            ToSkip = 0 ;
            Gx_line = 0 ;
            Gx_page = (int)(Gx_page+1) ;
            /* Skip Margin Top Lines */
            Gx_line = (int)(Gx_line+(M_top*lineHeight)) ;
            /* Print headers */
            getPrinter().GxStartPage() ;
            getPrinter().setPage(Gx_page);
            AV54AppName = httpContext.getMessage( "DVelop Software Solutions", "") ;
            AV60Phone = "+1 550 8923" ;
            AV58Mail = "info@mail.com" ;
            AV62Website = "http://www.web.com" ;
            AV51AddressLine1 = "French Boulevard 2859" ;
            AV52AddressLine2 = "Downtown" ;
            AV53AddressLine3 = "Paris, France" ;
            getPrinter().GxDrawRect(0, Gx_line+0, 819, Gx_line+108, 1, 0, 0, 0, 1, 79, 70, 229, 1, 1, 1, 1, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV54AppName, "")), 30, Gx_line+30, 283, Gx_line+45, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 20, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV61Title, "")), 30, Gx_line+45, 283, Gx_line+78, 0, 0, 0, 0) ;
            getPrinter().GxAttris("Microsoft Sans Serif", 8, false, false, false, false, 0, 255, 255, 255, 0, 255, 255, 255) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV60Phone, "")), 283, Gx_line+30, 536, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV58Mail, "")), 283, Gx_line+46, 536, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV62Website, "")), 283, Gx_line+62, 536, Gx_line+78, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV51AddressLine1, "")), 536, Gx_line+30, 789, Gx_line+46, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV52AddressLine2, "")), 536, Gx_line+46, 789, Gx_line+62, 2, 0, 0, 0) ;
            getPrinter().GxDrawText(GXutil.rtrim( localUtil.format( AV53AddressLine3, "")), 536, Gx_line+62, 789, Gx_line+78, 2, 0, 0, 0) ;
            Gx_OldLine = Gx_line ;
            Gx_line = (int)(Gx_line+128) ;
            if (true) break;
         }
         else
         {
            PrtOffset = 0 ;
            Gx_line = (int)(Gx_line+1) ;
         }
         ToSkip = (int)(ToSkip-1) ;
      }
      getPrinter().setPage(Gx_page);
   }

   public void add_metrics( )
   {
      add_metrics0( ) ;
   }

   public void add_metrics0( )
   {
      getPrinter().setMetrics("Microsoft Sans Serif", false, false, 58, 14, 72, 171,  new int[] {48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 18, 20, 23, 36, 36, 57, 43, 12, 21, 21, 25, 37, 18, 21, 18, 18, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 18, 18, 37, 37, 37, 36, 65, 43, 43, 46, 46, 43, 39, 50, 46, 18, 32, 43, 36, 53, 46, 50, 43, 50, 46, 43, 40, 46, 43, 64, 41, 42, 39, 18, 18, 18, 27, 36, 21, 36, 36, 32, 36, 36, 18, 36, 36, 14, 15, 33, 14, 55, 36, 36, 36, 36, 21, 32, 18, 36, 33, 47, 31, 31, 31, 21, 17, 21, 37, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 48, 18, 20, 36, 36, 36, 36, 17, 36, 21, 47, 24, 36, 37, 21, 47, 35, 26, 35, 21, 21, 21, 37, 34, 21, 21, 21, 23, 36, 53, 53, 53, 39, 43, 43, 43, 43, 43, 43, 64, 46, 43, 43, 43, 43, 18, 18, 18, 18, 46, 46, 50, 50, 50, 50, 50, 37, 50, 46, 46, 46, 46, 43, 43, 39, 36, 36, 36, 36, 36, 36, 57, 32, 36, 36, 36, 36, 18, 18, 18, 18, 36, 36, 36, 36, 36, 36, 36, 35, 39, 36, 36, 36, 36, 32, 36, 32}) ;
   }

   protected int getOutputType( )
   {
      return OUTPUT_PDF;
   }

   protected java.io.OutputStream getOutputStream( )
   {
      return httpContext.getOutputStream();
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      super.cleanup();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      GXKey = "" ;
      gxfirstwebparm = "" ;
      GXv_boolean2 = new boolean[1] ;
      AV65Pgmname = "" ;
      AV37WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      AV61Title = "" ;
      AV27GridState = new web.wwpbaseobjects.SdtWWPGridState(remoteHandle, context);
      AV28GridStateDynamicFilter = new web.wwpbaseobjects.SdtWWPGridState_DynamicFilter(remoteHandle, context);
      AV12DynamicFiltersSelector1 = "" ;
      AV14SecRoleName1 = "" ;
      AV29FilterSecRoleNameDescription = "" ;
      AV30SecRoleName = "" ;
      AV17DynamicFiltersSelector2 = "" ;
      AV19SecRoleName2 = "" ;
      AV22DynamicFiltersSelector3 = "" ;
      AV24SecRoleName3 = "" ;
      AV42TFSecRoleName_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV40TFSecRoleName_SelsJson = "" ;
      AV34TFSecRoleName_Sel = "" ;
      AV41TFSecRoleName_SelDscs = "" ;
      AV33TFSecRoleName = "" ;
      AV45TFSecRoleDescription_Sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV43TFSecRoleDescription_SelsJson = "" ;
      AV36TFSecRoleDescription_Sel = "" ;
      AV44TFSecRoleDescription_SelDscs = "" ;
      AV35TFSecRoleDescription = "" ;
      A355SecRoleName = "" ;
      A354SecRoleDescription = "" ;
      AV71Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 = "" ;
      AV73Wwpbaseobjects_secrolewwds_3_secrolename1 = "" ;
      AV75Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 = "" ;
      AV77Wwpbaseobjects_secrolewwds_7_secrolename2 = "" ;
      AV79Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 = "" ;
      AV81Wwpbaseobjects_secrolewwds_11_secrolename3 = "" ;
      AV82Wwpbaseobjects_secrolewwds_12_tfsecrolename = "" ;
      AV83Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      AV84Wwpbaseobjects_secrolewwds_14_tfsecroledescription = "" ;
      AV85Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels = new GXSimpleCollection<String>(String.class, "internal", "");
      scmdbuf = "" ;
      lV73Wwpbaseobjects_secrolewwds_3_secrolename1 = "" ;
      lV77Wwpbaseobjects_secrolewwds_7_secrolename2 = "" ;
      lV81Wwpbaseobjects_secrolewwds_11_secrolename3 = "" ;
      lV82Wwpbaseobjects_secrolewwds_12_tfsecrolename = "" ;
      lV84Wwpbaseobjects_secrolewwds_14_tfsecroledescription = "" ;
      P00BX2_A354SecRoleDescription = new String[] {""} ;
      P00BX2_A355SecRoleName = new String[] {""} ;
      P00BX2_A65SecRoleId = new short[1] ;
      AV38Session = httpContext.getWebSession();
      AV39GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV59PageInfo = "" ;
      AV56DateInfo = "" ;
      Gx_date = GXutil.nullDate() ;
      AV54AppName = "" ;
      AV60Phone = "" ;
      AV58Mail = "" ;
      AV62Website = "" ;
      AV51AddressLine1 = "" ;
      AV52AddressLine2 = "" ;
      AV53AddressLine3 = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.wwpbaseobjects.asecrolewwexportreport__default(),
         new Object[] {
             new Object[] {
            P00BX2_A354SecRoleDescription, P00BX2_A355SecRoleName, P00BX2_A65SecRoleId
            }
         }
      );
      Gx_date = GXutil.today( ) ;
      AV65Pgmname = "WWPBaseObjects.ASecRoleWWExportReport" ;
      /* GeneXus formulas. */
      Gx_line = 0 ;
      Gx_date = GXutil.today( ) ;
      AV65Pgmname = "WWPBaseObjects.ASecRoleWWExportReport" ;
      Gx_err = (short)(0) ;
   }

   private short gxcookieaux ;
   private short AV13DynamicFiltersOperator1 ;
   private short AV18DynamicFiltersOperator2 ;
   private short AV23DynamicFiltersOperator3 ;
   private short AV72Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 ;
   private short AV76Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 ;
   private short AV80Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 ;
   private short AV10OrderedBy ;
   private short A65SecRoleId ;
   private short Gx_err ;
   private int M_top ;
   private int M_bot ;
   private int Line ;
   private int ToSkip ;
   private int PrtOffset ;
   private int Gx_OldLine ;
   private int AV68GXV1 ;
   private int AV69GXV2 ;
   private int AV83Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size ;
   private int AV85Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size ;
   private int AV86GXV3 ;
   private long AV48i ;
   private String GXKey ;
   private String gxfirstwebparm ;
   private String AV65Pgmname ;
   private String scmdbuf ;
   private java.util.Date Gx_date ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV8IsAuthorized ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV16DynamicFiltersEnabled2 ;
   private boolean AV21DynamicFiltersEnabled3 ;
   private boolean AV74Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 ;
   private boolean AV78Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 ;
   private boolean AV11OrderedDsc ;
   private String AV40TFSecRoleName_SelsJson ;
   private String AV43TFSecRoleDescription_SelsJson ;
   private String AV61Title ;
   private String AV12DynamicFiltersSelector1 ;
   private String AV14SecRoleName1 ;
   private String AV29FilterSecRoleNameDescription ;
   private String AV30SecRoleName ;
   private String AV17DynamicFiltersSelector2 ;
   private String AV19SecRoleName2 ;
   private String AV22DynamicFiltersSelector3 ;
   private String AV24SecRoleName3 ;
   private String AV34TFSecRoleName_Sel ;
   private String AV41TFSecRoleName_SelDscs ;
   private String AV33TFSecRoleName ;
   private String AV36TFSecRoleDescription_Sel ;
   private String AV44TFSecRoleDescription_SelDscs ;
   private String AV35TFSecRoleDescription ;
   private String A355SecRoleName ;
   private String A354SecRoleDescription ;
   private String AV71Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 ;
   private String AV73Wwpbaseobjects_secrolewwds_3_secrolename1 ;
   private String AV75Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 ;
   private String AV77Wwpbaseobjects_secrolewwds_7_secrolename2 ;
   private String AV79Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 ;
   private String AV81Wwpbaseobjects_secrolewwds_11_secrolename3 ;
   private String AV82Wwpbaseobjects_secrolewwds_12_tfsecrolename ;
   private String AV84Wwpbaseobjects_secrolewwds_14_tfsecroledescription ;
   private String lV73Wwpbaseobjects_secrolewwds_3_secrolename1 ;
   private String lV77Wwpbaseobjects_secrolewwds_7_secrolename2 ;
   private String lV81Wwpbaseobjects_secrolewwds_11_secrolename3 ;
   private String lV82Wwpbaseobjects_secrolewwds_12_tfsecrolename ;
   private String lV84Wwpbaseobjects_secrolewwds_14_tfsecroledescription ;
   private String AV59PageInfo ;
   private String AV56DateInfo ;
   private String AV54AppName ;
   private String AV60Phone ;
   private String AV58Mail ;
   private String AV62Website ;
   private String AV51AddressLine1 ;
   private String AV52AddressLine2 ;
   private String AV53AddressLine3 ;
   private com.genexus.webpanels.WebSession AV38Session ;
   private IDataStoreProvider pr_default ;
   private String[] P00BX2_A354SecRoleDescription ;
   private String[] P00BX2_A355SecRoleName ;
   private short[] P00BX2_A65SecRoleId ;
   private GXSimpleCollection<String> AV42TFSecRoleName_Sels ;
   private GXSimpleCollection<String> AV45TFSecRoleDescription_Sels ;
   private GXSimpleCollection<String> AV83Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels ;
   private GXSimpleCollection<String> AV85Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels ;
   private web.wwpbaseobjects.SdtWWPGridState AV27GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV39GridStateFilterValue ;
   private web.wwpbaseobjects.SdtWWPGridState_DynamicFilter AV28GridStateDynamicFilter ;
   private web.wwpbaseobjects.SdtWWPContext AV37WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
}

final  class asecrolewwexportreport__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00BX2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A355SecRoleName ,
                                          GXSimpleCollection<String> AV83Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels ,
                                          String A354SecRoleDescription ,
                                          GXSimpleCollection<String> AV85Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels ,
                                          String AV71Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1 ,
                                          short AV72Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 ,
                                          String AV73Wwpbaseobjects_secrolewwds_3_secrolename1 ,
                                          boolean AV74Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 ,
                                          String AV75Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2 ,
                                          short AV76Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 ,
                                          String AV77Wwpbaseobjects_secrolewwds_7_secrolename2 ,
                                          boolean AV78Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 ,
                                          String AV79Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3 ,
                                          short AV80Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 ,
                                          String AV81Wwpbaseobjects_secrolewwds_11_secrolename3 ,
                                          int AV83Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size ,
                                          String AV82Wwpbaseobjects_secrolewwds_12_tfsecrolename ,
                                          int AV85Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size ,
                                          String AV84Wwpbaseobjects_secrolewwds_14_tfsecroledescription ,
                                          short AV10OrderedBy ,
                                          boolean AV11OrderedDsc )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[8];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT SecRoleDescription, SecRoleName, SecRoleId FROM SecRole" ;
      if ( ( GXutil.strcmp(AV71Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV72Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 == 0 ) && ( ! (GXutil.strcmp("", AV73Wwpbaseobjects_secrolewwds_3_secrolename1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      if ( ( GXutil.strcmp(AV71Wwpbaseobjects_secrolewwds_1_dynamicfiltersselector1, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV72Wwpbaseobjects_secrolewwds_2_dynamicfiltersoperator1 == 1 ) && ( ! (GXutil.strcmp("", AV73Wwpbaseobjects_secrolewwds_3_secrolename1)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[1] = (byte)(1) ;
      }
      if ( AV74Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 && ( GXutil.strcmp(AV75Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV76Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 == 0 ) && ( ! (GXutil.strcmp("", AV77Wwpbaseobjects_secrolewwds_7_secrolename2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int4[2] = (byte)(1) ;
      }
      if ( AV74Wwpbaseobjects_secrolewwds_4_dynamicfiltersenabled2 && ( GXutil.strcmp(AV75Wwpbaseobjects_secrolewwds_5_dynamicfiltersselector2, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV76Wwpbaseobjects_secrolewwds_6_dynamicfiltersoperator2 == 1 ) && ( ! (GXutil.strcmp("", AV77Wwpbaseobjects_secrolewwds_7_secrolename2)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[3] = (byte)(1) ;
      }
      if ( AV78Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 && ( GXutil.strcmp(AV79Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV80Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 == 0 ) && ( ! (GXutil.strcmp("", AV81Wwpbaseobjects_secrolewwds_11_secrolename3)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int4[4] = (byte)(1) ;
      }
      if ( AV78Wwpbaseobjects_secrolewwds_8_dynamicfiltersenabled3 && ( GXutil.strcmp(AV79Wwpbaseobjects_secrolewwds_9_dynamicfiltersselector3, httpContext.getMessage( "SECROLENAME", "")) == 0 ) && ( AV80Wwpbaseobjects_secrolewwds_10_dynamicfiltersoperator3 == 1 ) && ( ! (GXutil.strcmp("", AV81Wwpbaseobjects_secrolewwds_11_secrolename3)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like '%' || LOWER(?))");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      if ( ( AV83Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV82Wwpbaseobjects_secrolewwds_12_tfsecrolename)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleName) like LOWER(?))");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( AV83Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV83Wwpbaseobjects_secrolewwds_13_tfsecrolename_sels, "SecRoleName IN (", ")")+")");
      }
      if ( ( AV85Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size == 0 ) && ( ! (GXutil.strcmp("", AV84Wwpbaseobjects_secrolewwds_14_tfsecroledescription)==0) ) )
      {
         addWhere(sWhereString, "(LOWER(SecRoleDescription) like LOWER(?))");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( AV85Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels_size > 0 )
      {
         addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV85Wwpbaseobjects_secrolewwds_15_tfsecroledescription_sels, "SecRoleDescription IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      if ( ( AV10OrderedBy == 1 ) && ! AV11OrderedDsc )
      {
         scmdbuf += " ORDER BY SecRoleName" ;
      }
      else if ( ( AV10OrderedBy == 1 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SecRoleName DESC" ;
      }
      else if ( ( AV10OrderedBy == 2 ) && ! AV11OrderedDsc )
      {
         scmdbuf += " ORDER BY SecRoleDescription" ;
      }
      else if ( ( AV10OrderedBy == 2 ) && ( AV11OrderedDsc ) )
      {
         scmdbuf += " ORDER BY SecRoleDescription DESC" ;
      }
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
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
                  return conditional_P00BX2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , (String)dynConstraints[2] , (GXSimpleCollection<String>)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , (String)dynConstraints[6] , ((Boolean) dynConstraints[7]).booleanValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).shortValue() , (String)dynConstraints[10] , ((Boolean) dynConstraints[11]).booleanValue() , (String)dynConstraints[12] , ((Number) dynConstraints[13]).shortValue() , (String)dynConstraints[14] , ((Number) dynConstraints[15]).intValue() , (String)dynConstraints[16] , ((Number) dynConstraints[17]).intValue() , (String)dynConstraints[18] , ((Number) dynConstraints[19]).shortValue() , ((Boolean) dynConstraints[20]).booleanValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00BX2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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

