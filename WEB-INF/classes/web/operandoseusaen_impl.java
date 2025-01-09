package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class operandoseusaen_impl extends GXWebComponent
{
   public operandoseusaen_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public operandoseusaen_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( operandoseusaen_impl.class ));
   }

   public operandoseusaen_impl( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void setPrefix( String sPPrefix )
   {
      sPrefix = sPPrefix;
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( nGotPars == 0 )
         {
            entryPointCalled = false ;
            gxfirstwebparm = httpContext.GetFirstPar( "ConOperFor") ;
            gxfirstwebparm_bkp = gxfirstwebparm ;
            gxfirstwebparm = httpContext.DecryptAjaxCall( gxfirstwebparm) ;
            toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
            if ( GXutil.strcmp(gxfirstwebparm, "dyncall") == 0 )
            {
               httpContext.setAjaxCallMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               dyncall( httpContext.GetNextPar( )) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "dyncomponent") == 0 )
            {
               httpContext.setAjaxEventMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               nDynComponent = (byte)(1) ;
               sCompPrefix = httpContext.GetPar( "sCompPrefix") ;
               sSFPrefix = httpContext.GetPar( "sSFPrefix") ;
               A923ConOperFor = httpContext.GetPar( "ConOperFor") ;
               setjustcreated();
               componentprepare(new Object[] {sCompPrefix,sSFPrefix,A923ConOperFor});
               componentstart();
               httpContext.ajax_rspStartCmp(sPrefix);
               componentdraw();
               httpContext.ajax_rspEndCmp();
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
            {
               httpContext.setAjaxEventMode();
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "ConOperFor") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
            {
               if ( ! httpContext.IsValidAjaxCall( true) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = httpContext.GetFirstPar( "ConOperFor") ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid1") == 0 )
            {
               gxnrgrid1_newrow_invoke( ) ;
               return  ;
            }
            else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid1") == 0 )
            {
               gxgrgrid1_refresh_invoke( ) ;
               return  ;
            }
            else
            {
               if ( ! httpContext.IsValidAjaxCall( false) )
               {
                  GxWebError = (byte)(1) ;
                  return  ;
               }
               gxfirstwebparm = gxfirstwebparm_bkp ;
            }
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isLocalStorageSupported( ) )
         {
            httpContext.pushCurrentUrl();
         }
      }
   }

   public void gxnrgrid1_newrow_invoke( )
   {
      nRC_GXsfl_18 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_18"))) ;
      nGXsfl_18_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_18_idx"))) ;
      sGXsfl_18_idx = httpContext.GetPar( "sGXsfl_18_idx") ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgrid1_newrow( ) ;
      /* End function gxnrGrid1_newrow_invoke */
   }

   public void gxgrgrid1_refresh_invoke( )
   {
      subGrid1_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid1_Rows"))) ;
      A923ConOperFor = httpContext.GetPar( "ConOperFor") ;
      AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
      sPrefix = httpContext.GetPar( "sPrefix") ;
      init_default_properties( ) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid1_refresh( subGrid1_Rows, A923ConOperFor, AV7CliCod, sPrefix) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid1_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         paA72( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            validateSpaRequest();
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( ! isAjaxCallMode( ) )
            {
               if ( nDynComponent == 0 )
               {
                  httpContext.sendError( 404 );
                  GXutil.writeLog("send_http_error_code 404");
                  GxWebError = (byte)(1) ;
               }
            }
         }
         if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
         {
            if ( nDynComponent == 0 )
            {
               throw new RuntimeException("WebComponent is not allowed to run");
            }
         }
         if ( ( GxWebError == 0 ) && httpContext.isAjaxRequest( ) )
         {
            httpContext.enableOutput();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
            }
            if ( ! httpContext.willRedirect( ) )
            {
               addString( httpContext.getJSONResponse( )) ;
            }
            else
            {
               if ( httpContext.isAjaxRequest( ) )
               {
                  httpContext.disableOutput();
               }
               renderHtmlHeaders( ) ;
               httpContext.redirect( httpContext.wjLoc );
               httpContext.dispatchAjaxCommands();
            }
         }
      }
      cleanup();
   }

   public void renderHtmlHeaders( )
   {
      web.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         httpContext.writeText( "<title>") ;
         httpContext.writeValue( httpContext.getMessage( "Operando Se Usa En", "")) ;
         httpContext.writeTextNL( "</title>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         if ( GXutil.len( sDynURL) > 0 )
         {
            httpContext.writeText( "<BASE href=\""+sDynURL+"\" />") ;
         }
         define_styles( ) ;
      }
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.closeHtmlHeader();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
         httpContext.writeText( "<body ") ;
         bodyStyle = "" ;
         if ( nGXWrapped == 0 )
         {
            bodyStyle += "-moz-opacity:0;opacity:0;" ;
         }
         httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
         httpContext.writeText( FormProcess+">") ;
         httpContext.skipLines( 1 );
         if ( nGXWrapped != 1 )
         {
            httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.operandoseusaen", new String[] {GXutil.URLEncode(GXutil.rtrim(A923ConOperFor))}, new String[] {"ConOperFor"}) +"\">") ;
            web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
            web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
            web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
            httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
            httpContext.ajax_rsp_assign_prop(sPrefix, false, "FORM", "Class", "form-horizontal Form", true);
         }
      }
      else
      {
         boolean toggleHtmlOutput = httpContext.isOutputEnabled( );
         if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableOutput();
            }
         }
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gxwebcomponent-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         if ( toggleHtmlOutput )
         {
            if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableOutput();
               }
            }
         }
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      if ( GXutil.strSearch( sPrefix, "MP", 1) == 1 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"nRC_GXsfl_18", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_18, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRID1PAGECOUNT", GXutil.ltrim( localUtil.ntoc( AV13Grid1PageCount, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vGRID1APPLIEDFILTERS", AV14Grid1AppliedFilters);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"wcpOA923ConOperFor", wcpOA923ConOperFor);
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1_nEOF", GXutil.ltrim( localUtil.ntoc( GRID1_nEOF, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1_Rows", GXutil.ltrim( localUtil.ntoc( subGrid1_Rows, (byte)(6), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1PAGINATIONBAR_Class", GXutil.rtrim( Grid1paginationbar_Class));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1PAGINATIONBAR_Showfirst", GXutil.booltostr( Grid1paginationbar_Showfirst));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1PAGINATIONBAR_Showprevious", GXutil.booltostr( Grid1paginationbar_Showprevious));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1PAGINATIONBAR_Shownext", GXutil.booltostr( Grid1paginationbar_Shownext));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1PAGINATIONBAR_Showlast", GXutil.booltostr( Grid1paginationbar_Showlast));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1PAGINATIONBAR_Pagestoshow", GXutil.ltrim( localUtil.ntoc( Grid1paginationbar_Pagestoshow, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1PAGINATIONBAR_Pagingbuttonsposition", GXutil.rtrim( Grid1paginationbar_Pagingbuttonsposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1PAGINATIONBAR_Pagingcaptionposition", GXutil.rtrim( Grid1paginationbar_Pagingcaptionposition));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1PAGINATIONBAR_Emptygridclass", GXutil.rtrim( Grid1paginationbar_Emptygridclass));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1PAGINATIONBAR_Rowsperpageselector", GXutil.booltostr( Grid1paginationbar_Rowsperpageselector));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1PAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Grid1paginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1PAGINATIONBAR_Rowsperpageoptions", GXutil.rtrim( Grid1paginationbar_Rowsperpageoptions));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1PAGINATIONBAR_Previous", GXutil.rtrim( Grid1paginationbar_Previous));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1PAGINATIONBAR_Next", GXutil.rtrim( Grid1paginationbar_Next));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1PAGINATIONBAR_Caption", GXutil.rtrim( Grid1paginationbar_Caption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1PAGINATIONBAR_Emptygridcaption", GXutil.rtrim( Grid1paginationbar_Emptygridcaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1PAGINATIONBAR_Rowsperpagecaption", GXutil.rtrim( Grid1paginationbar_Rowsperpagecaption));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1_EMPOWERER_Gridinternalname", GXutil.rtrim( Grid1_empowerer_Gridinternalname));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1PAGINATIONBAR_Selectedpage", GXutil.rtrim( Grid1paginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1PAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Grid1paginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1PAGINATIONBAR_Selectedpage", GXutil.rtrim( Grid1paginationbar_Selectedpage));
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1PAGINATIONBAR_Rowsperpageselectedvalue", GXutil.ltrim( localUtil.ntoc( Grid1paginationbar_Rowsperpageselectedvalue, (byte)(9), (byte)(0), ".", "")));
   }

   public void renderHtmlCloseFormA72( )
   {
      sendCloseFormHiddens( ) ;
      if ( ( GXutil.len( sPrefix) != 0 ) && ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) ) )
      {
         componentjscripts();
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GX_FocusControl", GX_FocusControl);
      define_styles( ) ;
      sendSecurityToken(sPrefix);
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.SendAjaxEncryptionKey();
         httpContext.SendComponentObjects();
         httpContext.SendServerCommands();
         httpContext.SendState();
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
         if ( nGXWrapped != 1 )
         {
            httpContext.writeTextNL( "</form>") ;
         }
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
         include_jscripts( ) ;
         httpContext.writeTextNL( "</body>") ;
         httpContext.writeTextNL( "</html>") ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableOutput();
         }
      }
      else
      {
         httpContext.SendWebComponentState();
         httpContext.writeText( "</div>") ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
   }

   public String getPgmname( )
   {
      return "OperandoSeUsaEn" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Operando Se Usa En", "") ;
   }

   public void wbA70( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( GXutil.len( sPrefix) == 0 )
         {
            renderHtmlHeaders( ) ;
         }
         renderHtmlOpenForm( ) ;
         if ( GXutil.len( sPrefix) != 0 )
         {
            web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"_CMPPGM", "web.operandoseusaen");
            httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
            httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
         }
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         ClassString = "ErrorViewer" ;
         StyleString = "" ;
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, sPrefix, "false");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 HasGridEmpowerer", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divGrid1tablewithpaginationbar_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         Grid1Container.SetWrapped(nGXWrapped);
         startgridcontrol18( ) ;
      }
      if ( wbEnd == 18 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_18 = (int)(nGXsfl_18_idx-1) ;
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+sPrefix+"Grid1Container"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Grid1", Grid1Container, subGrid1_Internalname);
            if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Grid1ContainerData", Grid1Container.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Grid1ContainerData"+"V", Grid1Container.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"Grid1ContainerData"+"V"+"\" value='"+Grid1Container.GridValuesHidden()+"'/>") ;
            }
         }
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucGrid1paginationbar.setProperty("Class", Grid1paginationbar_Class);
         ucGrid1paginationbar.setProperty("ShowFirst", Grid1paginationbar_Showfirst);
         ucGrid1paginationbar.setProperty("ShowPrevious", Grid1paginationbar_Showprevious);
         ucGrid1paginationbar.setProperty("ShowNext", Grid1paginationbar_Shownext);
         ucGrid1paginationbar.setProperty("ShowLast", Grid1paginationbar_Showlast);
         ucGrid1paginationbar.setProperty("PagesToShow", Grid1paginationbar_Pagestoshow);
         ucGrid1paginationbar.setProperty("PagingButtonsPosition", Grid1paginationbar_Pagingbuttonsposition);
         ucGrid1paginationbar.setProperty("PagingCaptionPosition", Grid1paginationbar_Pagingcaptionposition);
         ucGrid1paginationbar.setProperty("EmptyGridClass", Grid1paginationbar_Emptygridclass);
         ucGrid1paginationbar.setProperty("RowsPerPageSelector", Grid1paginationbar_Rowsperpageselector);
         ucGrid1paginationbar.setProperty("RowsPerPageOptions", Grid1paginationbar_Rowsperpageoptions);
         ucGrid1paginationbar.setProperty("Previous", Grid1paginationbar_Previous);
         ucGrid1paginationbar.setProperty("Next", Grid1paginationbar_Next);
         ucGrid1paginationbar.setProperty("Caption", Grid1paginationbar_Caption);
         ucGrid1paginationbar.setProperty("EmptyGridCaption", Grid1paginationbar_Emptygridcaption);
         ucGrid1paginationbar.setProperty("RowsPerPageCaption", Grid1paginationbar_Rowsperpagecaption);
         ucGrid1paginationbar.setProperty("CurrentPage", AV12Grid1CurrentPage);
         ucGrid1paginationbar.setProperty("PageCount", AV13Grid1PageCount);
         ucGrid1paginationbar.setProperty("AppliedFilters", AV14Grid1AppliedFilters);
         ucGrid1paginationbar.render(context, "dvelop.dvpaginationbar", Grid1paginationbar_Internalname, sPrefix+"GRID1PAGINATIONBARContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divHtml_bottomauxiliarcontrols_Internalname, 1, 0, "px", 0, "px", "Section", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'" + sPrefix + "',false,'" + sGXsfl_18_idx + "',0)\"" ;
         web.GxWebStd.gx_single_line_edit( httpContext, edtavGrid1currentpage_Internalname, GXutil.ltrim( localUtil.ntoc( AV12Grid1CurrentPage, (byte)(10), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(AV12Grid1CurrentPage), "ZZZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,29);\"", "'"+sPrefix+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavGrid1currentpage_Jsonclick, 0, "Attribute", "", "", "", "", edtavGrid1currentpage_Visible, 1, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_OperandoSeUsaEn.htm");
         /* User Defined Control */
         ucGrid1_empowerer.render(context, "wwp.gridempowerer", Grid1_empowerer_Internalname, sPrefix+"GRID1_EMPOWERERContainer");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 18 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Grid1Container.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+sPrefix+"Grid1Container"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid(sPrefix+"_"+"Grid1", Grid1Container, subGrid1_Internalname);
               if ( ! isAjaxCallMode( ) && ! httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Grid1ContainerData", Grid1Container.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"Grid1ContainerData"+"V", Grid1Container.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+sPrefix+"Grid1ContainerData"+"V"+"\" value='"+Grid1Container.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void startA72( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( ! httpContext.isSpaRequest( ) )
         {
            if ( httpContext.exposeMetadata( ) )
            {
               Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
            }
            Form.getMeta().addItem("description", httpContext.getMessage( "Operando Se Usa En", ""), (short)(0)) ;
         }
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
         httpContext.wbHandled = (byte)(0) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            sXEvt = httpContext.cgiGet( "_EventName") ;
            if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
            {
            }
         }
      }
      wbErr = false ;
      if ( ( GXutil.len( sPrefix) == 0 ) || ( nDraw == 1 ) )
      {
         if ( nDoneStart == 0 )
         {
            strupA70( ) ;
         }
      }
   }

   public void wsA72( )
   {
      startA72( ) ;
      evtA72( ) ;
   }

   public void evtA72( )
   {
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ( ( ( GXutil.len( sPrefix) == 0 ) ) || ( GXutil.strSearch( sXEvt, sPrefix, 1) > 0 ) ) && ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            if ( httpContext.wbHandled == 0 )
            {
               if ( GXutil.len( sPrefix) == 0 )
               {
                  sEvt = httpContext.cgiGet( "_EventName") ;
                  EvtGridId = httpContext.cgiGet( "_EventGridId") ;
                  EvtRowId = httpContext.cgiGet( "_EventRowId") ;
               }
               if ( GXutil.len( sEvt) > 0 )
               {
                  sEvtType = GXutil.left( sEvt, 1) ;
                  sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupA70( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRID1PAGINATIONBAR.CHANGEPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupA70( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e11A72 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "GRID1PAGINATIONBAR.CHANGEROWSPERPAGE") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupA70( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 e12A72 ();
                              }
                           }
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupA70( ) ;
                           }
                           if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                           {
                              httpContext.wbHandled = (byte)(1) ;
                              if ( ! wbErr )
                              {
                                 dynload_actions( ) ;
                                 GX_FocusControl = edtavGrid1currentpage_Internalname ;
                                 httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                              }
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 7), "REFRESH") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 10), "GRID1.LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 6), "CANCEL") == 0 ) )
                        {
                           if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                           {
                              strupA70( ) ;
                           }
                           nGXsfl_18_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_18_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_18_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_182( ) ;
                           A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
                           if ( GXutil.len( sPrefix) == 0 )
                           {
                              A923ConOperFor = httpContext.cgiGet( edtConOperFor_Internalname) ;
                           }
                           A26ConCodigo = httpContext.cgiGet( edtConCodigo_Internalname) ;
                           A41ConDescrip = httpContext.cgiGet( edtConDescrip_Internalname) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavGrid1currentpage_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Start */
                                       e13A72 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "REFRESH") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavGrid1currentpage_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       /* Execute user event: Refresh */
                                       e14A72 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "GRID1.LOAD") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavGrid1currentpage_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                       e15A72 ();
                                    }
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       if ( ! wbErr )
                                       {
                                          Rfr0gs = false ;
                                          if ( ! Rfr0gs )
                                          {
                                          }
                                          dynload_actions( ) ;
                                       }
                                    }
                                 }
                                 /* No code required for Cancel button. It is implemented as the Reset button. */
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 if ( ( GXutil.len( sPrefix) != 0 ) && ( nDoneStart == 0 ) )
                                 {
                                    strupA70( ) ;
                                 }
                                 if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
                                 {
                                    httpContext.wbHandled = (byte)(1) ;
                                    if ( ! wbErr )
                                    {
                                       dynload_actions( ) ;
                                       GX_FocusControl = edtavGrid1currentpage_Internalname ;
                                       httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
                                    }
                                 }
                              }
                           }
                           else
                           {
                           }
                        }
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void weA72( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            renderHtmlCloseFormA72( ) ;
         }
      }
   }

   public void paA72( )
   {
      if ( nDonePA == 0 )
      {
         if ( GXutil.len( sPrefix) != 0 )
         {
            initialize_properties( ) ;
         }
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
            {
               gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
            }
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.disableJsOutput();
            }
         }
         init_web_controls( ) ;
         if ( GXutil.len( sPrefix) == 0 )
         {
            if ( toggleJsOutput )
            {
               if ( httpContext.isSpaRequest( ) )
               {
                  httpContext.enableJsOutput();
               }
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = edtavGrid1currentpage_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgrid1_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_182( ) ;
      while ( nGXsfl_18_idx <= nRC_GXsfl_18 )
      {
         sendrow_182( ) ;
         nGXsfl_18_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_18_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_18_idx+1) ;
         sGXsfl_18_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_18_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_182( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Grid1Container)) ;
      /* End function gxnrGrid1_newrow */
   }

   public void gxgrgrid1_refresh( int subGrid1_Rows ,
                                  String A923ConOperFor ,
                                  int AV7CliCod ,
                                  String sPrefix )
   {
      initialize_formulas( ) ;
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      /* Execute user event: Refresh */
      e14A72 ();
      GRID1_nCurrentRecord = 0 ;
      rfA72( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid1_refresh */
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rfA72( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   public void rfA72( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Grid1Container.ClearRows();
      }
      wbStart = (short)(18) ;
      /* Execute user event: Refresh */
      e14A72 ();
      nGXsfl_18_idx = 1 ;
      sGXsfl_18_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_18_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_182( ) ;
      bGXsfl_18_Refreshing = true ;
      Grid1Container.AddObjectProperty("GridName", "Grid1");
      Grid1Container.AddObjectProperty("CmpContext", sPrefix);
      Grid1Container.AddObjectProperty("InMasterPage", "false");
      Grid1Container.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
      Grid1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Grid1Container.setPageSize( subgrid1_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_182( ) ;
         GXPagingFrom2 = (int)(((subGrid1_Rows==0) ? 0 : GRID1_nFirstRecordOnPage)) ;
         GXPagingTo2 = ((subGrid1_Rows==0) ? 10000 : subgrid1_fnc_recordsperpage( )+1) ;
         /* Using cursor H00A72 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV7CliCod), A923ConOperFor, Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_18_idx = 1 ;
         sGXsfl_18_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_18_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_182( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( ( subGrid1_Rows == 0 ) || ( GRID1_nCurrentRecord < subgrid1_fnc_recordsperpage( ) ) ) ) )
         {
            A41ConDescrip = H00A72_A41ConDescrip[0] ;
            A26ConCodigo = H00A72_A26ConCodigo[0] ;
            A3CliCod = H00A72_A3CliCod[0] ;
            A41ConDescrip = H00A72_A41ConDescrip[0] ;
            e15A72 ();
            pr_default.readNext(0);
         }
         GRID1_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1_nEOF", GXutil.ltrim( localUtil.ntoc( GRID1_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(18) ;
         wbA70( ) ;
      }
      bGXsfl_18_Refreshing = true ;
   }

   public void send_integrity_lvl_hashesA72( )
   {
   }

   public int subgrid1_fnc_pagecount( )
   {
      GRID1_nRecordCount = subgrid1_fnc_recordcount( ) ;
      if ( ((int)((GRID1_nRecordCount) % (subgrid1_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( GRID1_nRecordCount/ (double) (subgrid1_fnc_recordsperpage( )))) ;
      }
      return (int)(GXutil.Int( GRID1_nRecordCount/ (double) (subgrid1_fnc_recordsperpage( )))+1) ;
   }

   public int subgrid1_fnc_recordcount( )
   {
      /* Using cursor H00A73 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV7CliCod), A923ConOperFor});
      GRID1_nRecordCount = H00A73_AGRID1_nRecordCount[0] ;
      pr_default.close(1);
      return (int)(GRID1_nRecordCount) ;
   }

   public int subgrid1_fnc_recordsperpage( )
   {
      if ( subGrid1_Rows > 0 )
      {
         return subGrid1_Rows*1 ;
      }
      else
      {
         return -1 ;
      }
   }

   public int subgrid1_fnc_currentpage( )
   {
      return (int)(GXutil.Int( GRID1_nFirstRecordOnPage/ (double) (subgrid1_fnc_recordsperpage( )))+1) ;
   }

   public short subgrid1_firstpage( )
   {
      GRID1_nFirstRecordOnPage = 0 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGrid1_Rows, A923ConOperFor, AV7CliCod, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid1_nextpage( )
   {
      GRID1_nRecordCount = subgrid1_fnc_recordcount( ) ;
      if ( ( GRID1_nRecordCount >= subgrid1_fnc_recordsperpage( ) ) && ( GRID1_nEOF == 0 ) )
      {
         GRID1_nFirstRecordOnPage = (long)(GRID1_nFirstRecordOnPage+subgrid1_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("GRID1_nFirstRecordOnPage", GRID1_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGrid1_Rows, A923ConOperFor, AV7CliCod, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID1_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid1_previouspage( )
   {
      if ( GRID1_nFirstRecordOnPage >= subgrid1_fnc_recordsperpage( ) )
      {
         GRID1_nFirstRecordOnPage = (long)(GRID1_nFirstRecordOnPage-subgrid1_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGrid1_Rows, A923ConOperFor, AV7CliCod, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid1_lastpage( )
   {
      GRID1_nRecordCount = subgrid1_fnc_recordcount( ) ;
      if ( GRID1_nRecordCount > subgrid1_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRID1_nRecordCount) % (subgrid1_fnc_recordsperpage( )))) == 0 )
         {
            GRID1_nFirstRecordOnPage = (long)(GRID1_nRecordCount-subgrid1_fnc_recordsperpage( )) ;
         }
         else
         {
            GRID1_nFirstRecordOnPage = (long)(GRID1_nRecordCount-((int)((GRID1_nRecordCount) % (subgrid1_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRID1_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGrid1_Rows, A923ConOperFor, AV7CliCod, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid1_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRID1_nFirstRecordOnPage = (long)(subgrid1_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRID1_nFirstRecordOnPage = 0 ;
      }
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGrid1_Rows, A923ConOperFor, AV7CliCod, sPrefix) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strupA70( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e13A72 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      nDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      sXEvt = httpContext.cgiGet( "_EventName") ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_18 = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"nRC_GXsfl_18"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         AV13Grid1PageCount = localUtil.ctol( httpContext.cgiGet( sPrefix+"vGRID1PAGECOUNT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         AV14Grid1AppliedFilters = httpContext.cgiGet( sPrefix+"vGRID1APPLIEDFILTERS") ;
         wcpOA923ConOperFor = httpContext.cgiGet( sPrefix+"wcpOA923ConOperFor") ;
         GRID1_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID1_nFirstRecordOnPage"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
         GRID1_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID1_nEOF"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         subGrid1_Rows = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID1_Rows"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1_Rows", GXutil.ltrim( localUtil.ntoc( subGrid1_Rows, (byte)(6), (byte)(0), ".", "")));
         Grid1paginationbar_Class = httpContext.cgiGet( sPrefix+"GRID1PAGINATIONBAR_Class") ;
         Grid1paginationbar_Showfirst = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRID1PAGINATIONBAR_Showfirst")) ;
         Grid1paginationbar_Showprevious = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRID1PAGINATIONBAR_Showprevious")) ;
         Grid1paginationbar_Shownext = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRID1PAGINATIONBAR_Shownext")) ;
         Grid1paginationbar_Showlast = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRID1PAGINATIONBAR_Showlast")) ;
         Grid1paginationbar_Pagestoshow = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID1PAGINATIONBAR_Pagestoshow"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Grid1paginationbar_Pagingbuttonsposition = httpContext.cgiGet( sPrefix+"GRID1PAGINATIONBAR_Pagingbuttonsposition") ;
         Grid1paginationbar_Pagingcaptionposition = httpContext.cgiGet( sPrefix+"GRID1PAGINATIONBAR_Pagingcaptionposition") ;
         Grid1paginationbar_Emptygridclass = httpContext.cgiGet( sPrefix+"GRID1PAGINATIONBAR_Emptygridclass") ;
         Grid1paginationbar_Rowsperpageselector = GXutil.strtobool( httpContext.cgiGet( sPrefix+"GRID1PAGINATIONBAR_Rowsperpageselector")) ;
         Grid1paginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID1PAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         Grid1paginationbar_Rowsperpageoptions = httpContext.cgiGet( sPrefix+"GRID1PAGINATIONBAR_Rowsperpageoptions") ;
         Grid1paginationbar_Previous = httpContext.cgiGet( sPrefix+"GRID1PAGINATIONBAR_Previous") ;
         Grid1paginationbar_Next = httpContext.cgiGet( sPrefix+"GRID1PAGINATIONBAR_Next") ;
         Grid1paginationbar_Caption = httpContext.cgiGet( sPrefix+"GRID1PAGINATIONBAR_Caption") ;
         Grid1paginationbar_Emptygridcaption = httpContext.cgiGet( sPrefix+"GRID1PAGINATIONBAR_Emptygridcaption") ;
         Grid1paginationbar_Rowsperpagecaption = httpContext.cgiGet( sPrefix+"GRID1PAGINATIONBAR_Rowsperpagecaption") ;
         Grid1_empowerer_Gridinternalname = httpContext.cgiGet( sPrefix+"GRID1_EMPOWERER_Gridinternalname") ;
         Grid1paginationbar_Selectedpage = httpContext.cgiGet( sPrefix+"GRID1PAGINATIONBAR_Selectedpage") ;
         Grid1paginationbar_Rowsperpageselectedvalue = (int)(localUtil.ctol( httpContext.cgiGet( sPrefix+"GRID1PAGINATIONBAR_Rowsperpageselectedvalue"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavGrid1currentpage_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavGrid1currentpage_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vGRID1CURRENTPAGE");
            GX_FocusControl = edtavGrid1currentpage_Internalname ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV12Grid1CurrentPage = 0 ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12Grid1CurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Grid1CurrentPage), 10, 0));
         }
         else
         {
            AV12Grid1CurrentPage = localUtil.ctol( httpContext.cgiGet( edtavGrid1currentpage_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) ;
            httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12Grid1CurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Grid1CurrentPage), 10, 0));
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e13A72 ();
      if (returnInSub) return;
   }

   public void e13A72( )
   {
      /* Start Routine */
      returnInSub = false ;
      GXt_int1 = AV7CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      operandoseusaen_impl.this.GXt_int1 = GXv_int2[0] ;
      AV7CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      Grid1_empowerer_Gridinternalname = subGrid1_Internalname ;
      ucGrid1_empowerer.sendProperty(context, sPrefix, false, Grid1_empowerer_Internalname, "GridInternalName", Grid1_empowerer_Gridinternalname);
      subGrid1_Rows = 10 ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1_Rows", GXutil.ltrim( localUtil.ntoc( subGrid1_Rows, (byte)(6), (byte)(0), ".", "")));
      AV12Grid1CurrentPage = 1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12Grid1CurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Grid1CurrentPage), 10, 0));
      edtavGrid1currentpage_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop(sPrefix, false, edtavGrid1currentpage_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavGrid1currentpage_Visible), 5, 0), true);
      AV13Grid1PageCount = -1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV13Grid1PageCount", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Grid1PageCount), 10, 0));
      Grid1paginationbar_Rowsperpageselectedvalue = subGrid1_Rows ;
      ucGrid1paginationbar.sendProperty(context, sPrefix, false, Grid1paginationbar_Internalname, "RowsPerPageSelectedValue", GXutil.ltrimstr( DecimalUtil.doubleToDec(Grid1paginationbar_Rowsperpageselectedvalue), 9, 0));
   }

   public void e14A72( )
   {
      if ( gx_refresh_fired )
      {
         return  ;
      }
      gx_refresh_fired = true ;
      /* Refresh Routine */
      returnInSub = false ;
      GXt_int1 = AV7CliCod ;
      GXv_int2[0] = GXt_int1 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int2) ;
      operandoseusaen_impl.this.GXt_int1 = GXv_int2[0] ;
      AV7CliCod = GXt_int1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      /*  Sending Event outputs  */
   }

   private void e15A72( )
   {
      /* Grid1_Load Routine */
      returnInSub = false ;
      /* Load Method */
      if ( wbStart != -1 )
      {
         wbStart = (short)(18) ;
      }
      sendrow_182( ) ;
      GRID1_nCurrentRecord = (long)(GRID1_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_18_Refreshing )
      {
         httpContext.doAjaxLoad(18, Grid1Row);
      }
   }

   public void e11A72( )
   {
      /* Grid1paginationbar_Changepage Routine */
      returnInSub = false ;
      if ( GXutil.strcmp(Grid1paginationbar_Selectedpage, "Previous") == 0 )
      {
         AV12Grid1CurrentPage = (long)(AV12Grid1CurrentPage-1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12Grid1CurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Grid1CurrentPage), 10, 0));
         subgrid1_previouspage( ) ;
      }
      else if ( GXutil.strcmp(Grid1paginationbar_Selectedpage, "Next") == 0 )
      {
         AV12Grid1CurrentPage = (long)(AV12Grid1CurrentPage+1) ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12Grid1CurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Grid1CurrentPage), 10, 0));
         subgrid1_nextpage( ) ;
      }
      else
      {
         AV11PageToGo = (int)(GXutil.lval( Grid1paginationbar_Selectedpage)) ;
         AV12Grid1CurrentPage = AV11PageToGo ;
         httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12Grid1CurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Grid1CurrentPage), 10, 0));
         subgrid1_gotopage( AV11PageToGo) ;
      }
      httpContext.doAjaxRefreshCmp(sPrefix);
      /*  Sending Event outputs  */
   }

   public void e12A72( )
   {
      /* Grid1paginationbar_Changerowsperpage Routine */
      returnInSub = false ;
      subGrid1_Rows = Grid1paginationbar_Rowsperpageselectedvalue ;
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"GRID1_Rows", GXutil.ltrim( localUtil.ntoc( subGrid1_Rows, (byte)(6), (byte)(0), ".", "")));
      AV12Grid1CurrentPage = 1 ;
      httpContext.ajax_rsp_assign_attri(sPrefix, false, "AV12Grid1CurrentPage", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Grid1CurrentPage), 10, 0));
      subgrid1_firstpage( ) ;
      /*  Sending Event outputs  */
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A923ConOperFor = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public String getresponse( String sGXDynURL )
   {
      initialize_properties( ) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      sDynURL = sGXDynURL ;
      nGotPars = 1 ;
      nGXWrapped = 1 ;
      httpContext.setWrapped(true);
      paA72( ) ;
      wsA72( ) ;
      weA72( ) ;
      httpContext.setWrapped(false);
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
      String response = "";
      try
      {
         response = ((java.io.ByteArrayOutputStream) httpContext.getOutputStream()).toString("UTF8");
      }
      catch (java.io.UnsupportedEncodingException e)
      {
         Application.printWarning(e.getMessage(), e);
      }
      finally
      {
         httpContext.closeOutputStream();
      }
      return response;
   }

   public void responsestatic( String sGXDynURL )
   {
   }

   public void componentbind( Object[] obj )
   {
      if ( IsUrlCreated( ) )
      {
         return  ;
      }
      sCtrlA923ConOperFor = (String)getParm(obj,0,TypeConstants.STRING) ;
   }

   public void componentrestorestate( String sPPrefix ,
                                      String sPSFPrefix )
   {
      sPrefix = sPPrefix + sPSFPrefix ;
      paA72( ) ;
      wcparametersget( ) ;
   }

   @SuppressWarnings("unchecked")
   public void componentprepare( Object[] obj )
   {
      wbLoad = false ;
      sCompPrefix = (String)getParm(obj,0,TypeConstants.STRING) ;
      sSFPrefix = (String)getParm(obj,1,TypeConstants.STRING) ;
      sPrefix = sCompPrefix + sSFPrefix ;
      httpContext.AddComponentObject(sPrefix, "operandoseusaen", GetJustCreated( ));
      if ( ( nDoneStart == 0 ) && ( nDynComponent == 0 ) )
      {
         initweb( ) ;
      }
      else
      {
         init_default_properties( ) ;
         init_web_controls( ) ;
      }
      paA72( ) ;
      if ( ! GetJustCreated( ) && ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 ) && ( httpContext.wbGlbDoneStart == 0 ) )
      {
         wcparametersget( ) ;
      }
      else
      {
         A923ConOperFor = (String)getParm(obj,2,TypeConstants.STRING) ;
      }
      wcpOA923ConOperFor = httpContext.cgiGet( sPrefix+"wcpOA923ConOperFor") ;
      if ( ! GetJustCreated( ) && ( ( GXutil.strcmp(A923ConOperFor, wcpOA923ConOperFor) != 0 ) ) )
      {
         setjustcreated();
      }
      wcpOA923ConOperFor = A923ConOperFor ;
   }

   public void wcparametersget( )
   {
      /* Read Component Parameters. */
      sCtrlA923ConOperFor = httpContext.cgiGet( sPrefix+"A923ConOperFor_CTRL") ;
      if ( GXutil.len( sCtrlA923ConOperFor) > 0 )
      {
         A923ConOperFor = httpContext.cgiGet( sCtrlA923ConOperFor) ;
      }
      else
      {
         A923ConOperFor = httpContext.cgiGet( sPrefix+"A923ConOperFor_PARM") ;
      }
   }

   public void componentprocess( String sPPrefix ,
                                 String sPSFPrefix ,
                                 String sCompEvt )
   {
      sCompPrefix = sPPrefix ;
      sSFPrefix = sPSFPrefix ;
      sPrefix = sCompPrefix + sSFPrefix ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      initweb( ) ;
      nDraw = (byte)(0) ;
      paA72( ) ;
      sEvt = sCompEvt ;
      wcparametersget( ) ;
      wsA72( ) ;
      if ( isFullAjaxMode( ) )
      {
         componentdraw();
      }
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void componentstart( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
   }

   public void wcstart( )
   {
      nDraw = (byte)(1) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wsA72( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void wcparametersset( )
   {
      web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A923ConOperFor_PARM", A923ConOperFor);
      if ( GXutil.len( GXutil.rtrim( sCtrlA923ConOperFor)) > 0 )
      {
         web.GxWebStd.gx_hidden_field( httpContext, sPrefix+"A923ConOperFor_CTRL", GXutil.rtrim( sCtrlA923ConOperFor));
      }
   }

   public void componentdraw( )
   {
      if ( nDoneStart == 0 )
      {
         wcstart( ) ;
      }
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      wcparametersset( ) ;
      weA72( ) ;
      httpContext.SaveComponentMsgList(sPrefix);
      httpContext.GX_msglist = BackMsgLst ;
   }

   public String componentgetstring( String sGXControl )
   {
      String sCtrlName;
      if ( GXutil.strcmp(GXutil.substring( sGXControl, 1, 1), "&") == 0 )
      {
         sCtrlName = GXutil.substring( sGXControl, 2, GXutil.len( sGXControl)-1) ;
      }
      else
      {
         sCtrlName = sGXControl ;
      }
      return httpContext.cgiGet( sPrefix+"v"+GXutil.upper( sCtrlName)) ;
   }

   public void componentjscripts( )
   {
      include_jscripts( ) ;
   }

   public void componentthemes( )
   {
      define_styles( ) ;
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("DVelop/DVPaginationBar/DVPaginationBar.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025181755861", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      if ( nGXWrapped != 1 )
      {
         httpContext.AddJavascriptSource("operandoseusaen.js", "?2025181755861", false, true);
         httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/DVPaginationBar/DVPaginationBarRender.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
         httpContext.AddJavascriptSource("DVelop/GridEmpowerer/GridEmpowererRender.js", "", false, true);
      }
      /* End function include_jscripts */
   }

   public void subsflControlProps_182( )
   {
      edtCliCod_Internalname = sPrefix+"CLICOD_"+sGXsfl_18_idx ;
      edtConOperFor_Internalname = sPrefix+"CONOPERFOR_"+sGXsfl_18_idx ;
      edtConCodigo_Internalname = sPrefix+"CONCODIGO_"+sGXsfl_18_idx ;
      edtConDescrip_Internalname = sPrefix+"CONDESCRIP_"+sGXsfl_18_idx ;
   }

   public void subsflControlProps_fel_182( )
   {
      edtCliCod_Internalname = sPrefix+"CLICOD_"+sGXsfl_18_fel_idx ;
      edtConOperFor_Internalname = sPrefix+"CONOPERFOR_"+sGXsfl_18_fel_idx ;
      edtConCodigo_Internalname = sPrefix+"CONCODIGO_"+sGXsfl_18_fel_idx ;
      edtConDescrip_Internalname = sPrefix+"CONDESCRIP_"+sGXsfl_18_fel_idx ;
   }

   public void sendrow_182( )
   {
      subsflControlProps_182( ) ;
      wbA70( ) ;
      if ( ( subGrid1_Rows * 1 == 0 ) || ( nGXsfl_18_idx <= subgrid1_fnc_recordsperpage( ) * 1 ) )
      {
         Grid1Row = GXWebRow.GetNew(context,Grid1Container) ;
         if ( subGrid1_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGrid1_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Odd" ;
            }
         }
         else if ( subGrid1_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGrid1_Backstyle = (byte)(0) ;
            subGrid1_Backcolor = subGrid1_Allbackcolor ;
            if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Uniform" ;
            }
         }
         else if ( subGrid1_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGrid1_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Odd" ;
            }
            subGrid1_Backcolor = (int)(0x0) ;
         }
         else if ( subGrid1_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrid1_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_18_idx) % (2))) == 0 )
            {
               subGrid1_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
               {
                  subGrid1_Linesclass = subGrid1_Class+"Even" ;
               }
            }
            else
            {
               subGrid1_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
               {
                  subGrid1_Linesclass = subGrid1_Class+"Odd" ;
               }
            }
         }
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"GridWithPaginationBar WorkWith"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_18_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCliCod_Internalname,GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtCliCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(18),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+"display:none;"+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConOperFor_Internalname,A923ConOperFor,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtConOperFor_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(100),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(18),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConCodigo_Internalname,GXutil.rtrim( A26ConCodigo),"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtConCodigo_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(18),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"CodConcepto","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtConDescrip_Internalname,A41ConDescrip,"","","'"+sPrefix+"'"+",false,"+"'"+""+"'","","","","",edtConDescrip_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(400),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(18),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"DescripcionEnorme","left",Boolean.valueOf(true),""});
         send_integrity_lvl_hashesA72( ) ;
         Grid1Container.AddRow(Grid1Row);
         nGXsfl_18_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_18_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_18_idx+1) ;
         sGXsfl_18_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_18_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_182( ) ;
      }
      /* End function sendrow_182 */
   }

   public void startgridcontrol18( )
   {
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+sPrefix+"Grid1Container"+"DivS\" data-gxgridid=\"18\">") ;
         sStyleString = "" ;
         web.GxWebStd.gx_table_start( httpContext, subGrid1_Internalname, subGrid1_Internalname, "", "GridWithPaginationBar WorkWith", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGrid1_Backcolorstyle == 0 )
         {
            subGrid1_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGrid1_Class) > 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Title" ;
            }
         }
         else
         {
            subGrid1_Titlebackstyle = (byte)(1) ;
            if ( subGrid1_Backcolorstyle == 1 )
            {
               subGrid1_Titlebackcolor = subGrid1_Allbackcolor ;
               if ( GXutil.len( subGrid1_Class) > 0 )
               {
                  subGrid1_Linesclass = subGrid1_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGrid1_Class) > 0 )
               {
                  subGrid1_Linesclass = subGrid1_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Cli Cod", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+"display:none;"+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Con Oper For", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Código", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( httpContext.getMessage( "Descripción", "")) ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Grid1Container.AddObjectProperty("GridName", "Grid1");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            Grid1Container = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            Grid1Container.Clear();
         }
         Grid1Container.SetWrapped(nGXWrapped);
         Grid1Container.AddObjectProperty("GridName", "Grid1");
         Grid1Container.AddObjectProperty("Header", subGrid1_Header);
         Grid1Container.AddObjectProperty("Class", "GridWithPaginationBar WorkWith");
         Grid1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("CmpContext", sPrefix);
         Grid1Container.AddObjectProperty("InMasterPage", "false");
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", A923ConOperFor);
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", GXutil.rtrim( A26ConCodigo));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", A41ConDescrip);
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid1_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid1_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid1_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid1_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid1_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid1_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid1_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      edtCliCod_Internalname = sPrefix+"CLICOD" ;
      edtConOperFor_Internalname = sPrefix+"CONOPERFOR" ;
      edtConCodigo_Internalname = sPrefix+"CONCODIGO" ;
      edtConDescrip_Internalname = sPrefix+"CONDESCRIP" ;
      Grid1paginationbar_Internalname = sPrefix+"GRID1PAGINATIONBAR" ;
      divGrid1tablewithpaginationbar_Internalname = sPrefix+"GRID1TABLEWITHPAGINATIONBAR" ;
      divTablecontent_Internalname = sPrefix+"TABLECONTENT" ;
      divTablemain_Internalname = sPrefix+"TABLEMAIN" ;
      edtavGrid1currentpage_Internalname = sPrefix+"vGRID1CURRENTPAGE" ;
      Grid1_empowerer_Internalname = sPrefix+"GRID1_EMPOWERER" ;
      divHtml_bottomauxiliarcontrols_Internalname = sPrefix+"HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = sPrefix+"LAYOUTMAINTABLE" ;
      Form.setInternalname( sPrefix+"FORM" );
      subGrid1_Internalname = sPrefix+"GRID1" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      if ( GXutil.len( sPrefix) == 0 )
      {
         httpContext.setDefaultTheme("WorkWithPlusDS");
      }
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
      }
      init_default_properties( ) ;
      subGrid1_Allowcollapsing = (byte)(0) ;
      subGrid1_Allowselection = (byte)(0) ;
      subGrid1_Header = "" ;
      edtConDescrip_Jsonclick = "" ;
      edtConCodigo_Jsonclick = "" ;
      edtConOperFor_Jsonclick = "" ;
      edtCliCod_Jsonclick = "" ;
      subGrid1_Class = "GridWithPaginationBar WorkWith" ;
      subGrid1_Backcolorstyle = (byte)(0) ;
      edtavGrid1currentpage_Jsonclick = "" ;
      edtavGrid1currentpage_Visible = 1 ;
      Grid1paginationbar_Rowsperpagecaption = "WWP_PagingRowsPerPage" ;
      Grid1paginationbar_Emptygridcaption = "WWP_PagingEmptyGridCaption" ;
      Grid1paginationbar_Caption = httpContext.getMessage( "WWP_PagingCaption", "") ;
      Grid1paginationbar_Next = "WWP_PagingNextCaption" ;
      Grid1paginationbar_Previous = "WWP_PagingPreviousCaption" ;
      Grid1paginationbar_Rowsperpageoptions = "5:WWP_Rows5,10:WWP_Rows10,20:WWP_Rows20,50:WWP_Rows50" ;
      Grid1paginationbar_Rowsperpageselectedvalue = 10 ;
      Grid1paginationbar_Rowsperpageselector = GXutil.toBoolean( -1) ;
      Grid1paginationbar_Emptygridclass = "PaginationBarEmptyGrid" ;
      Grid1paginationbar_Pagingcaptionposition = "Left" ;
      Grid1paginationbar_Pagingbuttonsposition = "Right" ;
      Grid1paginationbar_Pagestoshow = 5 ;
      Grid1paginationbar_Showlast = GXutil.toBoolean( 0) ;
      Grid1paginationbar_Shownext = GXutil.toBoolean( -1) ;
      Grid1paginationbar_Showprevious = GXutil.toBoolean( -1) ;
      Grid1paginationbar_Showfirst = GXutil.toBoolean( 0) ;
      Grid1paginationbar_Class = "PaginationBar" ;
      subGrid1_Rows = 0 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( GXutil.len( sPrefix) == 0 )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'A923ConOperFor',fld:'CONOPERFOR',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'sPrefix'}]");
      setEventMetadata("REFRESH",",oparms:[{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("GRID1.LOAD","{handler:'e15A72',iparms:[]");
      setEventMetadata("GRID1.LOAD",",oparms:[]}");
      setEventMetadata("GRID1PAGINATIONBAR.CHANGEPAGE","{handler:'e11A72',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'A923ConOperFor',fld:'CONOPERFOR',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'sPrefix'},{av:'Grid1paginationbar_Selectedpage',ctrl:'GRID1PAGINATIONBAR',prop:'SelectedPage'},{av:'AV12Grid1CurrentPage',fld:'vGRID1CURRENTPAGE',pic:'ZZZZZZZZZ9'}]");
      setEventMetadata("GRID1PAGINATIONBAR.CHANGEPAGE",",oparms:[{av:'AV12Grid1CurrentPage',fld:'vGRID1CURRENTPAGE',pic:'ZZZZZZZZZ9'},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'}]}");
      setEventMetadata("GRID1PAGINATIONBAR.CHANGEROWSPERPAGE","{handler:'e12A72',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'A923ConOperFor',fld:'CONOPERFOR',pic:''},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9'},{av:'sPrefix'},{av:'Grid1paginationbar_Rowsperpageselectedvalue',ctrl:'GRID1PAGINATIONBAR',prop:'RowsPerPageSelectedValue'}]");
      setEventMetadata("GRID1PAGINATIONBAR.CHANGEROWSPERPAGE",",oparms:[{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV12Grid1CurrentPage',fld:'vGRID1CURRENTPAGE',pic:'ZZZZZZZZZ9'}]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_CONCODIGO","{handler:'valid_Concodigo',iparms:[]");
      setEventMetadata("VALID_CONCODIGO",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Condescrip',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
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
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      wcpOA923ConOperFor = "" ;
      Grid1paginationbar_Selectedpage = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      sPrefix = "" ;
      A923ConOperFor = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      AV14Grid1AppliedFilters = "" ;
      Grid1_empowerer_Gridinternalname = "" ;
      GX_FocusControl = "" ;
      ClassString = "" ;
      StyleString = "" ;
      Grid1Container = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      ucGrid1paginationbar = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      ucGrid1_empowerer = new com.genexus.webpanels.GXUserControl();
      sXEvt = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      A26ConCodigo = "" ;
      A41ConDescrip = "" ;
      scmdbuf = "" ;
      H00A72_A2119ConOpeId = new String[] {""} ;
      H00A72_A923ConOperFor = new String[] {""} ;
      H00A72_A41ConDescrip = new String[] {""} ;
      H00A72_A26ConCodigo = new String[] {""} ;
      H00A72_A3CliCod = new int[1] ;
      H00A73_AGRID1_nRecordCount = new long[1] ;
      GXv_int2 = new int[1] ;
      Grid1Row = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      sCtrlA923ConOperFor = "" ;
      subGrid1_Linesclass = "" ;
      ROClassString = "" ;
      Grid1Column = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.operandoseusaen__default(),
         new Object[] {
             new Object[] {
            H00A72_A2119ConOpeId, H00A72_A923ConOperFor, H00A72_A41ConDescrip, H00A72_A26ConCodigo, H00A72_A3CliCod
            }
            , new Object[] {
            H00A73_AGRID1_nRecordCount
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte GRID1_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte nDynComponent ;
   private byte nGXWrapped ;
   private byte nDraw ;
   private byte nDoneStart ;
   private byte nDonePA ;
   private byte subGrid1_Backcolorstyle ;
   private byte subGrid1_Backstyle ;
   private byte subGrid1_Titlebackstyle ;
   private byte subGrid1_Allowselection ;
   private byte subGrid1_Allowhovering ;
   private byte subGrid1_Allowcollapsing ;
   private byte subGrid1_Collapsed ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int Grid1paginationbar_Rowsperpageselectedvalue ;
   private int nRC_GXsfl_18 ;
   private int subGrid1_Rows ;
   private int nGXsfl_18_idx=1 ;
   private int AV7CliCod ;
   private int Grid1paginationbar_Pagestoshow ;
   private int edtavGrid1currentpage_Visible ;
   private int A3CliCod ;
   private int subGrid1_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int GXt_int1 ;
   private int GXv_int2[] ;
   private int AV11PageToGo ;
   private int idxLst ;
   private int subGrid1_Backcolor ;
   private int subGrid1_Allbackcolor ;
   private int subGrid1_Titlebackcolor ;
   private int subGrid1_Selectedindex ;
   private int subGrid1_Selectioncolor ;
   private int subGrid1_Hoveringcolor ;
   private long GRID1_nFirstRecordOnPage ;
   private long AV13Grid1PageCount ;
   private long AV12Grid1CurrentPage ;
   private long GRID1_nCurrentRecord ;
   private long GRID1_nRecordCount ;
   private String Grid1paginationbar_Selectedpage ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sPrefix ;
   private String sCompPrefix ;
   private String sSFPrefix ;
   private String sGXsfl_18_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String Grid1paginationbar_Class ;
   private String Grid1paginationbar_Pagingbuttonsposition ;
   private String Grid1paginationbar_Pagingcaptionposition ;
   private String Grid1paginationbar_Emptygridclass ;
   private String Grid1paginationbar_Rowsperpageoptions ;
   private String Grid1paginationbar_Previous ;
   private String Grid1paginationbar_Next ;
   private String Grid1paginationbar_Caption ;
   private String Grid1paginationbar_Emptygridcaption ;
   private String Grid1paginationbar_Rowsperpagecaption ;
   private String Grid1_empowerer_Gridinternalname ;
   private String GX_FocusControl ;
   private String divLayoutmaintable_Internalname ;
   private String divTablemain_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String divTablecontent_Internalname ;
   private String divGrid1tablewithpaginationbar_Internalname ;
   private String sStyleString ;
   private String subGrid1_Internalname ;
   private String Grid1paginationbar_Internalname ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String TempTags ;
   private String edtavGrid1currentpage_Internalname ;
   private String edtavGrid1currentpage_Jsonclick ;
   private String Grid1_empowerer_Internalname ;
   private String sXEvt ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtCliCod_Internalname ;
   private String edtConOperFor_Internalname ;
   private String A26ConCodigo ;
   private String edtConCodigo_Internalname ;
   private String edtConDescrip_Internalname ;
   private String scmdbuf ;
   private String sCtrlA923ConOperFor ;
   private String sGXsfl_18_fel_idx="0001" ;
   private String subGrid1_Class ;
   private String subGrid1_Linesclass ;
   private String ROClassString ;
   private String edtCliCod_Jsonclick ;
   private String edtConOperFor_Jsonclick ;
   private String edtConCodigo_Jsonclick ;
   private String edtConDescrip_Jsonclick ;
   private String subGrid1_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean Grid1paginationbar_Showfirst ;
   private boolean Grid1paginationbar_Showprevious ;
   private boolean Grid1paginationbar_Shownext ;
   private boolean Grid1paginationbar_Showlast ;
   private boolean Grid1paginationbar_Rowsperpageselector ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_18_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean gx_refresh_fired ;
   private String wcpOA923ConOperFor ;
   private String A923ConOperFor ;
   private String AV14Grid1AppliedFilters ;
   private String A41ConDescrip ;
   private com.genexus.webpanels.GXWebGrid Grid1Container ;
   private com.genexus.webpanels.GXWebRow Grid1Row ;
   private com.genexus.webpanels.GXWebColumn Grid1Column ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.genexus.webpanels.GXUserControl ucGrid1paginationbar ;
   private com.genexus.webpanels.GXUserControl ucGrid1_empowerer ;
   private IDataStoreProvider pr_default ;
   private String[] H00A72_A2119ConOpeId ;
   private String[] H00A72_A923ConOperFor ;
   private String[] H00A72_A41ConDescrip ;
   private String[] H00A72_A26ConCodigo ;
   private int[] H00A72_A3CliCod ;
   private long[] H00A73_AGRID1_nRecordCount ;
}

final  class operandoseusaen__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00A72", "SELECT T1.ConOpeId, T1.ConOperFor, T2.ConDescrip, T1.ConCodigo, T1.CliCod FROM (concepto_operandos T1 INNER JOIN Concepto T2 ON T2.CliCod = T1.CliCod AND T2.ConCodigo = T1.ConCodigo) WHERE (T1.CliCod = ?) AND (T1.ConOperFor = ( ?)) ORDER BY T1.CliCod  OFFSET ? LIMIT CASE WHEN ? > 0 THEN ? ELSE 1e9 END",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H00A73", "SELECT COUNT(*) FROM (concepto_operandos T1 INNER JOIN Concepto T2 ON T2.CliCod = T1.CliCod AND T2.ConCodigo = T1.ConCodigo) WHERE (T1.CliCod = ?) AND (T1.ConOperFor = ( ?)) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 100, false);
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 100, false);
               return;
      }
   }

}

