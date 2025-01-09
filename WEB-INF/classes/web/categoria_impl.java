package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class categoria_impl extends GXDataArea
{
   public void initenv( )
   {
      if ( GxWebError != 0 )
      {
         return  ;
      }
   }

   public void inittrn( )
   {
      initialize_properties( ) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel2"+"_"+"CLIPAICONVE") == 0 )
      {
         AV29CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV29CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29CliPaiConve), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV29CliPaiConve), "ZZZ9")));
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx2asaclipaiconve09205( AV29CliPaiConve, AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel3"+"_"+"CLICONVENIO") == 0 )
      {
         AV30CliConvenio = httpContext.GetPar( "CliConvenio") ;
         httpContext.ajax_rsp_assign_attri("", false, "AV30CliConvenio", AV30CliConvenio);
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV30CliConvenio, ""))));
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         AV8EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
         Gx_BScreen = (byte)(GXutil.lval( httpContext.GetPar( "Gx_BScreen"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx3asacliconvenio09205( AV30CliConvenio, AV7CliCod, AV8EmpCod, Gx_BScreen) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_20") == 0 )
      {
         A2200CatPaiCod = (short)(GXutil.lval( httpContext.GetPar( "CatPaiCod"))) ;
         A2201CatProvCod = (short)(GXutil.lval( httpContext.GetPar( "CatProvCod"))) ;
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_20( A2200CatPaiCod, A2201CatProvCod) ;
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
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel1") == 0 )
      {
         gxnrgridlevel1_newrow_invoke( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridlevel2") == 0 )
      {
         gxnrgridlevel2_newrow_invoke( ) ;
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
      if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
      {
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
            AV29CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV29CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV29CliPaiConve), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV29CliPaiConve), "ZZZ9")));
            AV30CliConvenio = httpContext.GetPar( "CliConvenio") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV30CliConvenio", AV30CliConvenio);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV30CliConvenio, ""))));
            AV9CatCodigo = httpContext.GetPar( "CatCodigo") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9CatCodigo", AV9CatCodigo);
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCATCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CatCodigo, ""))));
         }
      }
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
      if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
      {
         gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
      }
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_web_controls( ) ;
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "Categoria", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCatCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridlevel1_newrow_invoke( )
   {
      nRC_GXsfl_30 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_30"))) ;
      nGXsfl_30_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_30_idx"))) ;
      sGXsfl_30_idx = httpContext.GetPar( "sGXsfl_30_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel1_newrow( ) ;
      /* End function gxnrGridlevel1_newrow_invoke */
   }

   public void gxnrgridlevel2_newrow_invoke( )
   {
      nRC_GXsfl_40 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_40"))) ;
      nGXsfl_40_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_40_idx"))) ;
      sGXsfl_40_idx = httpContext.GetPar( "sGXsfl_40_idx") ;
      edtCatProvCod_Horizontalalignment = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatProvCod_Internalname, "Horizontalalignment", edtCatProvCod_Horizontalalignment, !bGXsfl_40_Refreshing);
      edtCatPaiCod_Horizontalalignment = httpContext.GetNextPar( ) ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatPaiCod_Internalname, "Horizontalalignment", edtCatPaiCod_Horizontalalignment, !bGXsfl_40_Refreshing);
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel2_newrow( ) ;
      /* End function gxnrGridlevel2_newrow_invoke */
   }

   public categoria_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public categoria_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( categoria_impl.class ));
   }

   public categoria_impl( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.newmasterpage");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
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
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public void fix_multi_value_controls( )
   {
   }

   public void draw( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         disable_std_buttons( ) ;
         enableDisable( ) ;
         set_caption( ) ;
         /* Form start */
         drawControls( ) ;
         fix_multi_value_controls( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMain", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 Padding0", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemainfix_Internalname, tblTablemainfix_Internalname, "", "W100", 0, "", "", 1, 2, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablecontent_Internalname, 1, 0, "px", 0, "px", "TableContentPadding", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* User Defined Control */
      ucDvpanel_tableattributes.setProperty("Width", Dvpanel_tableattributes_Width);
      ucDvpanel_tableattributes.setProperty("AutoWidth", Dvpanel_tableattributes_Autowidth);
      ucDvpanel_tableattributes.setProperty("AutoHeight", Dvpanel_tableattributes_Autoheight);
      ucDvpanel_tableattributes.setProperty("Cls", Dvpanel_tableattributes_Cls);
      ucDvpanel_tableattributes.setProperty("Title", Dvpanel_tableattributes_Title);
      ucDvpanel_tableattributes.setProperty("Collapsible", Dvpanel_tableattributes_Collapsible);
      ucDvpanel_tableattributes.setProperty("Collapsed", Dvpanel_tableattributes_Collapsed);
      ucDvpanel_tableattributes.setProperty("ShowCollapseIcon", Dvpanel_tableattributes_Showcollapseicon);
      ucDvpanel_tableattributes.setProperty("IconPosition", Dvpanel_tableattributes_Iconposition);
      ucDvpanel_tableattributes.setProperty("AutoScroll", Dvpanel_tableattributes_Autoscroll);
      ucDvpanel_tableattributes.render(context, "dvelop.gxbootstrap.panel_al", Dvpanel_tableattributes_Internalname, "DVPANEL_TABLEATTRIBUTESContainer");
      httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"DVPANEL_TABLEATTRIBUTESContainer"+"TableAttributes"+"\" style=\"display:none;\">") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCatCodigo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCatCodigo_Internalname, httpContext.getMessage( "Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCatCodigo_Internalname, GXutil.rtrim( A8CatCodigo), GXutil.rtrim( localUtil.format( A8CatCodigo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCatCodigo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCatCodigo_Enabled, 1, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Categoria.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 RequiredDataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCatDescrip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtCatDescrip_Internalname, httpContext.getMessage( "Categoría", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtCatDescrip_Internalname, A123CatDescrip, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", (short)(0), 1, edtCatDescrip_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_Categoria.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol30( ) ;
      nGXsfl_30_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount206 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_206 = (short)(1) ;
            scanStart09206( ) ;
            while ( RcdFound206 != 0 )
            {
               init_level_properties206( ) ;
               getByPrimaryKey09206( ) ;
               addRow09206( ) ;
               scanNext09206( ) ;
            }
            scanEnd09206( ) ;
            nBlankRcdCount206 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal09206( ) ;
         standaloneModal09206( ) ;
         sMode206 = Gx_mode ;
         while ( nGXsfl_30_idx < nRC_GXsfl_30 )
         {
            bGXsfl_30_Refreshing = true ;
            readRow09206( ) ;
            edtCatVigencia_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATVIGENCIA_"+sGXsfl_30_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtCatVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatVigencia_Enabled), 5, 0), !bGXsfl_30_Refreshing);
            edtCatBasico_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATBASICO_"+sGXsfl_30_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtCatBasico_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatBasico_Enabled), 5, 0), !bGXsfl_30_Refreshing);
            edtCatAdicional_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATADICIONAL_"+sGXsfl_30_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtCatAdicional_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatAdicional_Enabled), 5, 0), !bGXsfl_30_Refreshing);
            edtCatValorHora_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATVALORHORA_"+sGXsfl_30_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtCatValorHora_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatValorHora_Enabled), 5, 0), !bGXsfl_30_Refreshing);
            edtCatAdiHora_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATADIHORA_"+sGXsfl_30_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtCatAdiHora_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatAdiHora_Enabled), 5, 0), !bGXsfl_30_Refreshing);
            edtEscBasico_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ESCBASICO_"+sGXsfl_30_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtEscBasico_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEscBasico_Enabled), 5, 0), !bGXsfl_30_Refreshing);
            edtEscAdicional_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ESCADICIONAL_"+sGXsfl_30_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtEscAdicional_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEscAdicional_Enabled), 5, 0), !bGXsfl_30_Refreshing);
            if ( ( nRcdExists_206 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal09206( ) ;
            }
            sendRow09206( ) ;
            bGXsfl_30_Refreshing = false ;
         }
         Gx_mode = sMode206 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount206 = (short)(5) ;
         nRcdExists_206 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart09206( ) ;
            while ( RcdFound206 != 0 )
            {
               sGXsfl_30_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_30_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_30206( ) ;
               init_level_properties206( ) ;
               standaloneNotModal09206( ) ;
               getByPrimaryKey09206( ) ;
               standaloneModal09206( ) ;
               addRow09206( ) ;
               scanNext09206( ) ;
            }
            scanEnd09206( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode206 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_30_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_30_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_30206( ) ;
         initAll09206( ) ;
         init_level_properties206( ) ;
         nRcdExists_206 = (short)(0) ;
         nIsMod_206 = (short)(0) ;
         nRcdDeleted_206 = (short)(0) ;
         nBlankRcdCount206 = (short)(nBlankRcdUsr206+nBlankRcdCount206) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount206 > 0 )
         {
            standaloneNotModal09206( ) ;
            standaloneModal09206( ) ;
            addRow09206( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtCatVigencia_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount206 = (short)(nBlankRcdCount206-1) ;
         }
         Gx_mode = sMode206 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel1Container"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel1", Gridlevel1Container, subGridlevel1_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel1ContainerData", Gridlevel1Container.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel1ContainerData"+"V", Gridlevel1Container.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel1ContainerData"+"V"+"\" value='"+Gridlevel1Container.GridValuesHidden()+"'/>") ;
      }
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /*  Grid Control  */
      startgridcontrol40( ) ;
      nGXsfl_40_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount274 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_274 = (short)(1) ;
            scanStart09274( ) ;
            while ( RcdFound274 != 0 )
            {
               init_level_properties274( ) ;
               getByPrimaryKey09274( ) ;
               addRow09274( ) ;
               scanNext09274( ) ;
            }
            scanEnd09274( ) ;
            nBlankRcdCount274 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal09274( ) ;
         standaloneModal09274( ) ;
         sMode274 = Gx_mode ;
         while ( nGXsfl_40_idx < nRC_GXsfl_40 )
         {
            bGXsfl_40_Refreshing = true ;
            readRow09274( ) ;
            edtCatPaiCod_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATPAICOD_"+sGXsfl_40_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtCatPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatPaiCod_Enabled), 5, 0), !bGXsfl_40_Refreshing);
            edtCatPaiCod_Horizontalalignment = httpContext.cgiGet( "CATPAICOD_"+sGXsfl_40_idx+"Horizontalalignment") ;
            httpContext.ajax_rsp_assign_prop("", false, edtCatPaiCod_Internalname, "Horizontalalignment", edtCatPaiCod_Horizontalalignment, !bGXsfl_40_Refreshing);
            edtCatProvCod_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATPROVCOD_"+sGXsfl_40_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtCatProvCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatProvCod_Enabled), 5, 0), !bGXsfl_40_Refreshing);
            edtCatProvCod_Horizontalalignment = httpContext.cgiGet( "CATPROVCOD_"+sGXsfl_40_idx+"Horizontalalignment") ;
            httpContext.ajax_rsp_assign_prop("", false, edtCatProvCod_Internalname, "Horizontalalignment", edtCatProvCod_Horizontalalignment, !bGXsfl_40_Refreshing);
            if ( ( nRcdExists_274 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal09274( ) ;
            }
            sendRow09274( ) ;
            bGXsfl_40_Refreshing = false ;
         }
         Gx_mode = sMode274 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount274 = (short)(5) ;
         nRcdExists_274 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart09274( ) ;
            while ( RcdFound274 != 0 )
            {
               sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_40274( ) ;
               init_level_properties274( ) ;
               standaloneNotModal09274( ) ;
               getByPrimaryKey09274( ) ;
               standaloneModal09274( ) ;
               addRow09274( ) ;
               scanNext09274( ) ;
            }
            scanEnd09274( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode274 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_40274( ) ;
         initAll09274( ) ;
         init_level_properties274( ) ;
         nRcdExists_274 = (short)(0) ;
         nIsMod_274 = (short)(0) ;
         nRcdDeleted_274 = (short)(0) ;
         nBlankRcdCount274 = (short)(nBlankRcdUsr274+nBlankRcdCount274) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount274 > 0 )
         {
            standaloneNotModal09274( ) ;
            standaloneModal09274( ) ;
            addRow09274( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtCatPaiCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount274 = (short)(nBlankRcdCount274-1) ;
         }
         Gx_mode = sMode274 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridlevel2Container"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridlevel2", Gridlevel2Container, subGridlevel2_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel2ContainerData", Gridlevel2Container.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         web.GxWebStd.gx_hidden_field( httpContext, "Gridlevel2ContainerData"+"V", Gridlevel2Container.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridlevel2ContainerData"+"V"+"\" value='"+Gridlevel2Container.GridValuesHidden()+"'/>") ;
      }
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      ClassString = "ErrorViewer" ;
      StyleString = "" ;
      web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group TableContentPadding", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Categoria.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Categoria.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_delete_Internalname, "", httpContext.getMessage( "GX_BtnDelete", ""), bttBtntrn_delete_Jsonclick, 5, httpContext.getMessage( "GX_BtnDelete", ""), "", StyleString, ClassString, bttBtntrn_delete_Visible, bttBtntrn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Categoria.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      /* End of table */
      httpContext.writeText( "</table>") ;
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
      /* User Defined Control */
      ucCombo_catpaicod.setProperty("Caption", Combo_catpaicod_Caption);
      ucCombo_catpaicod.setProperty("Cls", Combo_catpaicod_Cls);
      ucCombo_catpaicod.setProperty("IsGridItem", Combo_catpaicod_Isgriditem);
      ucCombo_catpaicod.setProperty("HasDescription", Combo_catpaicod_Hasdescription);
      ucCombo_catpaicod.setProperty("DataListProc", Combo_catpaicod_Datalistproc);
      ucCombo_catpaicod.setProperty("DataListProcParametersPrefix", Combo_catpaicod_Datalistprocparametersprefix);
      ucCombo_catpaicod.setProperty("EmptyItem", Combo_catpaicod_Emptyitem);
      ucCombo_catpaicod.setProperty("DropDownOptionsTitleSettingsIcons", AV23DDO_TitleSettingsIcons);
      ucCombo_catpaicod.setProperty("DropDownOptionsData", AV34CatPaiCod_Data);
      ucCombo_catpaicod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_catpaicod_Internalname, "COMBO_CATPAICODContainer");
      /* User Defined Control */
      ucCombo_catprovcod.setProperty("Caption", Combo_catprovcod_Caption);
      ucCombo_catprovcod.setProperty("Cls", Combo_catprovcod_Cls);
      ucCombo_catprovcod.setProperty("IsGridItem", Combo_catprovcod_Isgriditem);
      ucCombo_catprovcod.setProperty("HasDescription", Combo_catprovcod_Hasdescription);
      ucCombo_catprovcod.setProperty("DataListProc", Combo_catprovcod_Datalistproc);
      ucCombo_catprovcod.setProperty("EmptyItem", Combo_catprovcod_Emptyitem);
      ucCombo_catprovcod.setProperty("DropDownOptionsTitleSettingsIcons", AV23DDO_TitleSettingsIcons);
      ucCombo_catprovcod.setProperty("DropDownOptionsData", AV35CatProvCod_Data);
      ucCombo_catprovcod.render(context, "dvelop.gxbootstrap.ddoextendedcombo", Combo_catprovcod_Internalname, "COMBO_CATPROVCODContainer");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void userMain( )
   {
      standaloneStartup( ) ;
   }

   public void userMainFullajax( )
   {
      initenv( ) ;
      inittrn( ) ;
      userMain( ) ;
      draw( ) ;
      sendCloseFormHiddens( ) ;
   }

   public void standaloneStartup( )
   {
      standaloneStartupServer( ) ;
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11092 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vDDO_TITLESETTINGSICONS"), AV23DDO_TitleSettingsIcons);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCATPAICOD_DATA"), AV34CatPaiCod_Data);
            httpContext.ajax_req_read_hidden_sdt(httpContext.cgiGet( "vCATPROVCOD_DATA"), AV35CatProvCod_Data);
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "Z1564CliPaiConve"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1565CliConvenio = httpContext.cgiGet( "Z1565CliConvenio") ;
            Z8CatCodigo = httpContext.cgiGet( "Z8CatCodigo") ;
            Z123CatDescrip = httpContext.cgiGet( "Z123CatDescrip") ;
            Z676CatDescripSinAc = httpContext.cgiGet( "Z676CatDescripSinAc") ;
            Z1838CatClase = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1838CatClase"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z2416CatTipoTarifa = httpContext.cgiGet( "Z2416CatTipoTarifa") ;
            Z1914CatFrecAct = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1914CatFrecAct"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1894CatRelSec = (short)(localUtil.ctol( httpContext.cgiGet( "Z1894CatRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1894CatRelSec = ((0==A1894CatRelSec) ? true : false) ;
            Z2040CatRelRef = httpContext.cgiGet( "Z2040CatRelRef") ;
            Z2198CatAfipCod = httpContext.cgiGet( "Z2198CatAfipCod") ;
            n2198CatAfipCod = ((GXutil.strcmp("", A2198CatAfipCod)==0) ? true : false) ;
            A676CatDescripSinAc = httpContext.cgiGet( "Z676CatDescripSinAc") ;
            A1838CatClase = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1838CatClase"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2416CatTipoTarifa = httpContext.cgiGet( "Z2416CatTipoTarifa") ;
            A1914CatFrecAct = (byte)(localUtil.ctol( httpContext.cgiGet( "Z1914CatFrecAct"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1894CatRelSec = (short)(localUtil.ctol( httpContext.cgiGet( "Z1894CatRelSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1894CatRelSec = false ;
            n1894CatRelSec = ((0==A1894CatRelSec) ? true : false) ;
            A2040CatRelRef = httpContext.cgiGet( "Z2040CatRelRef") ;
            A2198CatAfipCod = httpContext.cgiGet( "Z2198CatAfipCod") ;
            n2198CatAfipCod = false ;
            n2198CatAfipCod = ((GXutil.strcmp("", A2198CatAfipCod)==0) ? true : false) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_40 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_40"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            nRC_GXsfl_30 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_30"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "CLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV29CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "vCLIPAICONVE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1564CliPaiConve = (short)(localUtil.ctol( httpContext.cgiGet( "CLIPAICONVE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV30CliConvenio = httpContext.cgiGet( "vCLICONVENIO") ;
            AV8EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_BScreen = (byte)(localUtil.ctol( httpContext.cgiGet( "vGXBSCREEN"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1565CliConvenio = httpContext.cgiGet( "CLICONVENIO") ;
            AV9CatCodigo = httpContext.cgiGet( "vCATCODIGO") ;
            A676CatDescripSinAc = httpContext.cgiGet( "CATDESCRIPSINAC") ;
            A1838CatClase = (byte)(localUtil.ctol( httpContext.cgiGet( "CATCLASE"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A2416CatTipoTarifa = httpContext.cgiGet( "CATTIPOTARIFA") ;
            A1914CatFrecAct = (byte)(localUtil.ctol( httpContext.cgiGet( "CATFRECACT"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            A1894CatRelSec = (short)(localUtil.ctol( httpContext.cgiGet( "CATRELSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n1894CatRelSec = ((0==A1894CatRelSec) ? true : false) ;
            A2040CatRelRef = httpContext.cgiGet( "CATRELREF") ;
            A2041CatOld = httpContext.cgiGet( "CATOLD") ;
            A2198CatAfipCod = httpContext.cgiGet( "CATAFIPCOD") ;
            n2198CatAfipCod = ((GXutil.strcmp("", A2198CatAfipCod)==0) ? true : false) ;
            AV38Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            A2202CatProvRelSec = (int)(localUtil.ctol( httpContext.cgiGet( "CATPROVRELSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n2202CatProvRelSec = false ;
            n2202CatProvRelSec = ((0==A2202CatProvRelSec) ? true : false) ;
            A2203CatProvRelRef = httpContext.cgiGet( "CATPROVRELREF") ;
            n2203CatProvRelRef = false ;
            n2203CatProvRelRef = ((GXutil.strcmp("", A2203CatProvRelRef)==0) ? true : false) ;
            A2204CatProvOld = httpContext.cgiGet( "CATPROVOLD") ;
            n2204CatProvOld = false ;
            n2204CatProvOld = ((GXutil.strcmp("", A2204CatProvOld)==0) ? true : false) ;
            Dvpanel_tableattributes_Objectcall = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Objectcall") ;
            Dvpanel_tableattributes_Class = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Class") ;
            Dvpanel_tableattributes_Enabled = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Enabled")) ;
            Dvpanel_tableattributes_Width = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Width") ;
            Dvpanel_tableattributes_Height = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Height") ;
            Dvpanel_tableattributes_Autowidth = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autowidth")) ;
            Dvpanel_tableattributes_Autoheight = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoheight")) ;
            Dvpanel_tableattributes_Cls = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Cls") ;
            Dvpanel_tableattributes_Showheader = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showheader")) ;
            Dvpanel_tableattributes_Title = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Title") ;
            Dvpanel_tableattributes_Collapsible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsible")) ;
            Dvpanel_tableattributes_Collapsed = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Collapsed")) ;
            Dvpanel_tableattributes_Showcollapseicon = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Showcollapseicon")) ;
            Dvpanel_tableattributes_Iconposition = httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Iconposition") ;
            Dvpanel_tableattributes_Autoscroll = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Autoscroll")) ;
            Dvpanel_tableattributes_Visible = GXutil.strtobool( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Visible")) ;
            Dvpanel_tableattributes_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "DVPANEL_TABLEATTRIBUTES_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_catpaicod_Objectcall = httpContext.cgiGet( "COMBO_CATPAICOD_Objectcall") ;
            Combo_catpaicod_Class = httpContext.cgiGet( "COMBO_CATPAICOD_Class") ;
            Combo_catpaicod_Icontype = httpContext.cgiGet( "COMBO_CATPAICOD_Icontype") ;
            Combo_catpaicod_Icon = httpContext.cgiGet( "COMBO_CATPAICOD_Icon") ;
            Combo_catpaicod_Caption = httpContext.cgiGet( "COMBO_CATPAICOD_Caption") ;
            Combo_catpaicod_Tooltip = httpContext.cgiGet( "COMBO_CATPAICOD_Tooltip") ;
            Combo_catpaicod_Cls = httpContext.cgiGet( "COMBO_CATPAICOD_Cls") ;
            Combo_catpaicod_Selectedvalue_set = httpContext.cgiGet( "COMBO_CATPAICOD_Selectedvalue_set") ;
            Combo_catpaicod_Selectedvalue_get = httpContext.cgiGet( "COMBO_CATPAICOD_Selectedvalue_get") ;
            Combo_catpaicod_Selectedtext_set = httpContext.cgiGet( "COMBO_CATPAICOD_Selectedtext_set") ;
            Combo_catpaicod_Selectedtext_get = httpContext.cgiGet( "COMBO_CATPAICOD_Selectedtext_get") ;
            Combo_catpaicod_Gamoauthtoken = httpContext.cgiGet( "COMBO_CATPAICOD_Gamoauthtoken") ;
            Combo_catpaicod_Ddointernalname = httpContext.cgiGet( "COMBO_CATPAICOD_Ddointernalname") ;
            Combo_catpaicod_Titlecontrolalign = httpContext.cgiGet( "COMBO_CATPAICOD_Titlecontrolalign") ;
            Combo_catpaicod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CATPAICOD_Dropdownoptionstype") ;
            Combo_catpaicod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPAICOD_Enabled")) ;
            Combo_catpaicod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPAICOD_Visible")) ;
            Combo_catpaicod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CATPAICOD_Titlecontrolidtoreplace") ;
            Combo_catpaicod_Datalisttype = httpContext.cgiGet( "COMBO_CATPAICOD_Datalisttype") ;
            Combo_catpaicod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPAICOD_Allowmultipleselection")) ;
            Combo_catpaicod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CATPAICOD_Datalistfixedvalues") ;
            Combo_catpaicod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPAICOD_Isgriditem")) ;
            Combo_catpaicod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPAICOD_Hasdescription")) ;
            Combo_catpaicod_Datalistproc = httpContext.cgiGet( "COMBO_CATPAICOD_Datalistproc") ;
            Combo_catpaicod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CATPAICOD_Datalistprocparametersprefix") ;
            Combo_catpaicod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CATPAICOD_Remoteservicesparameters") ;
            Combo_catpaicod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CATPAICOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_catpaicod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPAICOD_Includeonlyselectedoption")) ;
            Combo_catpaicod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPAICOD_Includeselectalloption")) ;
            Combo_catpaicod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPAICOD_Emptyitem")) ;
            Combo_catpaicod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPAICOD_Includeaddnewoption")) ;
            Combo_catpaicod_Htmltemplate = httpContext.cgiGet( "COMBO_CATPAICOD_Htmltemplate") ;
            Combo_catpaicod_Multiplevaluestype = httpContext.cgiGet( "COMBO_CATPAICOD_Multiplevaluestype") ;
            Combo_catpaicod_Loadingdata = httpContext.cgiGet( "COMBO_CATPAICOD_Loadingdata") ;
            Combo_catpaicod_Noresultsfound = httpContext.cgiGet( "COMBO_CATPAICOD_Noresultsfound") ;
            Combo_catpaicod_Emptyitemtext = httpContext.cgiGet( "COMBO_CATPAICOD_Emptyitemtext") ;
            Combo_catpaicod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CATPAICOD_Onlyselectedvalues") ;
            Combo_catpaicod_Selectalltext = httpContext.cgiGet( "COMBO_CATPAICOD_Selectalltext") ;
            Combo_catpaicod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CATPAICOD_Multiplevaluesseparator") ;
            Combo_catpaicod_Addnewoptiontext = httpContext.cgiGet( "COMBO_CATPAICOD_Addnewoptiontext") ;
            Combo_catpaicod_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CATPAICOD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_catprovcod_Objectcall = httpContext.cgiGet( "COMBO_CATPROVCOD_Objectcall") ;
            Combo_catprovcod_Class = httpContext.cgiGet( "COMBO_CATPROVCOD_Class") ;
            Combo_catprovcod_Icontype = httpContext.cgiGet( "COMBO_CATPROVCOD_Icontype") ;
            Combo_catprovcod_Icon = httpContext.cgiGet( "COMBO_CATPROVCOD_Icon") ;
            Combo_catprovcod_Caption = httpContext.cgiGet( "COMBO_CATPROVCOD_Caption") ;
            Combo_catprovcod_Tooltip = httpContext.cgiGet( "COMBO_CATPROVCOD_Tooltip") ;
            Combo_catprovcod_Cls = httpContext.cgiGet( "COMBO_CATPROVCOD_Cls") ;
            Combo_catprovcod_Selectedvalue_set = httpContext.cgiGet( "COMBO_CATPROVCOD_Selectedvalue_set") ;
            Combo_catprovcod_Selectedvalue_get = httpContext.cgiGet( "COMBO_CATPROVCOD_Selectedvalue_get") ;
            Combo_catprovcod_Selectedtext_set = httpContext.cgiGet( "COMBO_CATPROVCOD_Selectedtext_set") ;
            Combo_catprovcod_Selectedtext_get = httpContext.cgiGet( "COMBO_CATPROVCOD_Selectedtext_get") ;
            Combo_catprovcod_Gamoauthtoken = httpContext.cgiGet( "COMBO_CATPROVCOD_Gamoauthtoken") ;
            Combo_catprovcod_Ddointernalname = httpContext.cgiGet( "COMBO_CATPROVCOD_Ddointernalname") ;
            Combo_catprovcod_Titlecontrolalign = httpContext.cgiGet( "COMBO_CATPROVCOD_Titlecontrolalign") ;
            Combo_catprovcod_Dropdownoptionstype = httpContext.cgiGet( "COMBO_CATPROVCOD_Dropdownoptionstype") ;
            Combo_catprovcod_Enabled = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPROVCOD_Enabled")) ;
            Combo_catprovcod_Visible = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPROVCOD_Visible")) ;
            Combo_catprovcod_Titlecontrolidtoreplace = httpContext.cgiGet( "COMBO_CATPROVCOD_Titlecontrolidtoreplace") ;
            Combo_catprovcod_Datalisttype = httpContext.cgiGet( "COMBO_CATPROVCOD_Datalisttype") ;
            Combo_catprovcod_Allowmultipleselection = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPROVCOD_Allowmultipleselection")) ;
            Combo_catprovcod_Datalistfixedvalues = httpContext.cgiGet( "COMBO_CATPROVCOD_Datalistfixedvalues") ;
            Combo_catprovcod_Isgriditem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPROVCOD_Isgriditem")) ;
            Combo_catprovcod_Hasdescription = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPROVCOD_Hasdescription")) ;
            Combo_catprovcod_Datalistproc = httpContext.cgiGet( "COMBO_CATPROVCOD_Datalistproc") ;
            Combo_catprovcod_Datalistprocparametersprefix = httpContext.cgiGet( "COMBO_CATPROVCOD_Datalistprocparametersprefix") ;
            Combo_catprovcod_Remoteservicesparameters = httpContext.cgiGet( "COMBO_CATPROVCOD_Remoteservicesparameters") ;
            Combo_catprovcod_Datalistupdateminimumcharacters = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CATPROVCOD_Datalistupdateminimumcharacters"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Combo_catprovcod_Includeonlyselectedoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPROVCOD_Includeonlyselectedoption")) ;
            Combo_catprovcod_Includeselectalloption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPROVCOD_Includeselectalloption")) ;
            Combo_catprovcod_Emptyitem = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPROVCOD_Emptyitem")) ;
            Combo_catprovcod_Includeaddnewoption = GXutil.strtobool( httpContext.cgiGet( "COMBO_CATPROVCOD_Includeaddnewoption")) ;
            Combo_catprovcod_Htmltemplate = httpContext.cgiGet( "COMBO_CATPROVCOD_Htmltemplate") ;
            Combo_catprovcod_Multiplevaluestype = httpContext.cgiGet( "COMBO_CATPROVCOD_Multiplevaluestype") ;
            Combo_catprovcod_Loadingdata = httpContext.cgiGet( "COMBO_CATPROVCOD_Loadingdata") ;
            Combo_catprovcod_Noresultsfound = httpContext.cgiGet( "COMBO_CATPROVCOD_Noresultsfound") ;
            Combo_catprovcod_Emptyitemtext = httpContext.cgiGet( "COMBO_CATPROVCOD_Emptyitemtext") ;
            Combo_catprovcod_Onlyselectedvalues = httpContext.cgiGet( "COMBO_CATPROVCOD_Onlyselectedvalues") ;
            Combo_catprovcod_Selectalltext = httpContext.cgiGet( "COMBO_CATPROVCOD_Selectalltext") ;
            Combo_catprovcod_Multiplevaluesseparator = httpContext.cgiGet( "COMBO_CATPROVCOD_Multiplevaluesseparator") ;
            Combo_catprovcod_Addnewoptiontext = httpContext.cgiGet( "COMBO_CATPROVCOD_Addnewoptiontext") ;
            Combo_catprovcod_Gxcontroltype = (int)(localUtil.ctol( httpContext.cgiGet( "COMBO_CATPROVCOD_Gxcontroltype"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            /* Read variables values. */
            A8CatCodigo = httpContext.cgiGet( edtCatCodigo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
            A123CatDescrip = httpContext.cgiGet( edtCatDescrip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Categoria");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("CatDescripSinAc", GXutil.rtrim( localUtil.format( A676CatDescripSinAc, "")));
            forbiddenHiddens.add("CatClase", localUtil.format( DecimalUtil.doubleToDec(A1838CatClase), "9"));
            forbiddenHiddens.add("CatTipoTarifa", GXutil.rtrim( localUtil.format( A2416CatTipoTarifa, "")));
            forbiddenHiddens.add("CatFrecAct", localUtil.format( DecimalUtil.doubleToDec(A1914CatFrecAct), "Z9"));
            forbiddenHiddens.add("CatRelSec", localUtil.format( DecimalUtil.doubleToDec(A1894CatRelSec), "ZZZ9"));
            forbiddenHiddens.add("CatRelRef", GXutil.rtrim( localUtil.format( A2040CatRelRef, "")));
            forbiddenHiddens.add("CatAfipCod", GXutil.rtrim( localUtil.format( A2198CatAfipCod, "")));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( GXutil.strcmp(A8CatCodigo, Z8CatCodigo) != 0 ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("categoria:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            /* Check if conditions changed and reset current page numbers */
            /* Check if conditions changed and reset current page numbers */
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1564CliPaiConve = (short)(GXutil.lval( httpContext.GetPar( "CliPaiConve"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = httpContext.GetPar( "CliConvenio") ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A8CatCodigo = httpContext.GetPar( "CatCodigo") ;
               httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
               getEqualNoModal( ) ;
               if ( ! (GXutil.strcmp("", AV30CliConvenio)==0) )
               {
                  A1565CliConvenio = AV30CliConvenio ;
                  httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               }
               else
               {
                  if ( isIns( )  && (GXutil.strcmp("", A1565CliConvenio)==0) && ( Gx_BScreen == 0 ) )
                  {
                     GXt_char1 = A1565CliConvenio ;
                     GXv_char2[0] = GXt_char1 ;
                     new web.getconveniodefault(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, "", GXv_char2) ;
                     categoria_impl.this.GXt_char1 = GXv_char2[0] ;
                     A1565CliConvenio = GXt_char1 ;
                     httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
                  }
               }
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode205 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  if ( ! (GXutil.strcmp("", AV30CliConvenio)==0) )
                  {
                     A1565CliConvenio = AV30CliConvenio ;
                     httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
                  }
                  else
                  {
                     if ( isIns( )  && (GXutil.strcmp("", A1565CliConvenio)==0) && ( Gx_BScreen == 0 ) )
                     {
                        GXt_char1 = A1565CliConvenio ;
                        GXv_char2[0] = GXt_char1 ;
                        new web.getconveniodefault(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, "", GXv_char2) ;
                        categoria_impl.this.GXt_char1 = GXv_char2[0] ;
                        A1565CliConvenio = GXt_char1 ;
                        httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
                     }
                  }
                  Gx_mode = sMode205 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound205 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_090( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "CATCODIGO");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCatCodigo_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
   }

   public void process( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read Transaction buttons. */
         sEvt = httpContext.cgiGet( "_EventName") ;
         EvtGridId = httpContext.cgiGet( "_EventGridId") ;
         EvtRowId = httpContext.cgiGet( "_EventRowId") ;
         if ( GXutil.len( sEvt) > 0 )
         {
            sEvtType = GXutil.left( sEvt, 1) ;
            sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
            if ( GXutil.strcmp(sEvtType, "M") != 0 )
            {
               if ( GXutil.strcmp(sEvtType, "E") == 0 )
               {
                  sEvtType = GXutil.right( sEvt, 1) ;
                  if ( GXutil.strcmp(sEvtType, ".") == 0 )
                  {
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e11092 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12092 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! isDsp( ) )
                        {
                           btn_enter( ) ;
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                  }
                  else
                  {
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                  }
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e12092 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll09205( ) ;
            standaloneNotModal( ) ;
            standaloneModal( ) ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public void disable_std_buttons( )
   {
      bttBtntrn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
      if ( isDsp( ) || isDlt( ) )
      {
         bttBtntrn_delete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Visible), 5, 0), true);
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes09205( ) ;
      }
   }

   public void set_caption( )
   {
      if ( ( IsConfirmed == 1 ) && ( AnyError == 0 ) )
      {
         if ( isDlt( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_confdelete"), 0, "", true);
         }
         else
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_mustconfirm"), 0, "", true);
         }
      }
   }

   public void confirm_090( )
   {
      beforeValidate09205( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls09205( ) ;
         }
         else
         {
            checkExtendedTable09205( ) ;
            closeExtendedTableCursors09205( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode205 = Gx_mode ;
         confirm_09274( ) ;
         if ( AnyError == 0 )
         {
            confirm_09206( ) ;
            if ( AnyError == 0 )
            {
               /* Restore parent mode. */
               Gx_mode = sMode205 ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               IsConfirmed = (short)(1) ;
               httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
            }
         }
         /* Restore parent mode. */
         Gx_mode = sMode205 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_09206( )
   {
      nGXsfl_30_idx = 0 ;
      while ( nGXsfl_30_idx < nRC_GXsfl_30 )
      {
         readRow09206( ) ;
         if ( ( nRcdExists_206 != 0 ) || ( nIsMod_206 != 0 ) )
         {
            getKey09206( ) ;
            if ( ( nRcdExists_206 == 0 ) && ( nRcdDeleted_206 == 0 ) )
            {
               if ( RcdFound206 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate09206( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable09206( ) ;
                     closeExtendedTableCursors09206( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "CATVIGENCIA_" + sGXsfl_30_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCatVigencia_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound206 != 0 )
               {
                  if ( nRcdDeleted_206 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey09206( ) ;
                     load09206( ) ;
                     beforeValidate09206( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls09206( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_206 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate09206( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable09206( ) ;
                           closeExtendedTableCursors09206( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_206 == 0 )
                  {
                     GXCCtl = "CATVIGENCIA_" + sGXsfl_30_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCatVigencia_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtCatVigencia_Internalname, localUtil.format(A907CatVigencia, "99/99/9999")) ;
         httpContext.changePostValue( edtCatBasico_Internalname, GXutil.ltrim( localUtil.ntoc( A122CatBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtCatAdicional_Internalname, GXutil.ltrim( localUtil.ntoc( A908CatAdicional, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtCatValorHora_Internalname, GXutil.ltrim( localUtil.ntoc( A731CatValorHora, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtCatAdiHora_Internalname, GXutil.ltrim( localUtil.ntoc( A909CatAdiHora, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtEscBasico_Internalname, GXutil.ltrim( localUtil.ntoc( A1892EscBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtEscAdicional_Internalname, GXutil.ltrim( localUtil.ntoc( A1893EscAdicional, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z907CatVigencia_"+sGXsfl_30_idx, localUtil.dtoc( Z907CatVigencia, 0, "/")) ;
         httpContext.changePostValue( "ZT_"+"Z122CatBasico_"+sGXsfl_30_idx, GXutil.ltrim( localUtil.ntoc( Z122CatBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z731CatValorHora_"+sGXsfl_30_idx, GXutil.ltrim( localUtil.ntoc( Z731CatValorHora, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z908CatAdicional_"+sGXsfl_30_idx, GXutil.ltrim( localUtil.ntoc( Z908CatAdicional, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z909CatAdiHora_"+sGXsfl_30_idx, GXutil.ltrim( localUtil.ntoc( Z909CatAdiHora, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1892EscBasico_"+sGXsfl_30_idx, GXutil.ltrim( localUtil.ntoc( Z1892EscBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1893EscAdicional_"+sGXsfl_30_idx, GXutil.ltrim( localUtil.ntoc( Z1893EscAdicional, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_206_"+sGXsfl_30_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_206_"+sGXsfl_30_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_206_"+sGXsfl_30_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_206 != 0 )
         {
            httpContext.changePostValue( "CATVIGENCIA_"+sGXsfl_30_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatVigencia_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATBASICO_"+sGXsfl_30_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatBasico_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATADICIONAL_"+sGXsfl_30_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatAdicional_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATVALORHORA_"+sGXsfl_30_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatValorHora_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATADIHORA_"+sGXsfl_30_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatAdiHora_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ESCBASICO_"+sGXsfl_30_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEscBasico_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ESCADICIONAL_"+sGXsfl_30_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEscAdicional_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void confirm_09274( )
   {
      nGXsfl_40_idx = 0 ;
      while ( nGXsfl_40_idx < nRC_GXsfl_40 )
      {
         readRow09274( ) ;
         if ( ( nRcdExists_274 != 0 ) || ( nIsMod_274 != 0 ) )
         {
            getKey09274( ) ;
            if ( ( nRcdExists_274 == 0 ) && ( nRcdDeleted_274 == 0 ) )
            {
               if ( RcdFound274 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate09274( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable09274( ) ;
                     closeExtendedTableCursors09274( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "CATPAICOD_" + sGXsfl_40_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCatPaiCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound274 != 0 )
               {
                  if ( nRcdDeleted_274 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey09274( ) ;
                     load09274( ) ;
                     beforeValidate09274( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls09274( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_274 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate09274( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable09274( ) ;
                           closeExtendedTableCursors09274( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_274 == 0 )
                  {
                     GXCCtl = "CATPAICOD_" + sGXsfl_40_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCatPaiCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtCatPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A2200CatPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtCatProvCod_Internalname, GXutil.ltrim( localUtil.ntoc( A2201CatProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2200CatPaiCod_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( Z2200CatPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2201CatProvCod_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( Z2201CatProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2202CatProvRelSec_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( Z2202CatProvRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2203CatProvRelRef_"+sGXsfl_40_idx, Z2203CatProvRelRef) ;
         httpContext.changePostValue( "nRcdDeleted_274_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_274, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_274_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_274, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_274_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_274, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_274 != 0 )
         {
            httpContext.changePostValue( "CATPAICOD_"+sGXsfl_40_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatPaiCod_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATPAICOD_"+sGXsfl_40_idx+"Horizontalalignment", GXutil.rtrim( edtCatPaiCod_Horizontalalignment)) ;
            httpContext.changePostValue( "CATPROVCOD_"+sGXsfl_40_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatProvCod_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATPROVCOD_"+sGXsfl_40_idx+"Horizontalalignment", GXutil.rtrim( edtCatProvCod_Horizontalalignment)) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption090( )
   {
   }

   public void e11092( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext3[0] = AV10WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext3) ;
      AV10WWPContext = GXv_SdtWWPContext3[0] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = AV23DDO_TitleSettingsIcons;
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5[0] = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4;
      new web.wwpbaseobjects.getwwptitlesettingsicons(remoteHandle, context).execute( GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5) ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5[0] ;
      AV23DDO_TitleSettingsIcons = GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4;
      Combo_catprovcod_Titlecontrolidtoreplace = edtCatProvCod_Internalname ;
      ucCombo_catprovcod.sendProperty(context, "", false, Combo_catprovcod_Internalname, "TitleControlIdToReplace", Combo_catprovcod_Titlecontrolidtoreplace);
      edtCatProvCod_Horizontalalignment = "Left" ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatProvCod_Internalname, "Horizontalalignment", edtCatProvCod_Horizontalalignment, !bGXsfl_40_Refreshing);
      Combo_catpaicod_Titlecontrolidtoreplace = edtCatPaiCod_Internalname ;
      ucCombo_catpaicod.sendProperty(context, "", false, Combo_catpaicod_Internalname, "TitleControlIdToReplace", Combo_catpaicod_Titlecontrolidtoreplace);
      edtCatPaiCod_Horizontalalignment = "Left" ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatPaiCod_Internalname, "Horizontalalignment", edtCatPaiCod_Horizontalalignment, !bGXsfl_40_Refreshing);
      /* Execute user subroutine: 'LOADCOMBOCATPROVCOD' */
      S112 ();
      if ( returnInSub )
      {
         pr_default.close(7);
         pr_default.close(6);
         pr_default.close(4);
         pr_default.close(3);
         pr_default.close(1);
         returnInSub = true;
         if (true) return;
      }
      AV13IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean6 = AV13IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCategoria_Insert", GXv_boolean7) ;
         categoria_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV13IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean6 = AV13IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCategoria_Update", GXv_boolean7) ;
         categoria_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV13IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean6 = AV13IsAuthorized ;
         GXv_boolean7[0] = GXt_boolean6 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWCategoria_Delete", GXv_boolean7) ;
         categoria_impl.this.GXt_boolean6 = GXv_boolean7[0] ;
         AV13IsAuthorized = GXt_boolean6 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV13IsAuthorized", AV13IsAuthorized);
      }
      if ( ! AV13IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV38Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV11TrnContext.fromxml(AV12WebSession.getValue("TrnContext"), null, null);
      GXt_int8 = AV7CliCod ;
      GXv_int9[0] = GXt_int8 ;
      new web.getclicod(remoteHandle, context).execute( GXv_int9) ;
      categoria_impl.this.GXt_int8 = GXv_int9[0] ;
      AV7CliCod = GXt_int8 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      GXt_int10 = AV8EmpCod ;
      GXv_int11[0] = GXt_int10 ;
      new web.getempcod(remoteHandle, context).execute( GXv_int11) ;
      categoria_impl.this.GXt_int10 = GXv_int11[0] ;
      AV8EmpCod = GXt_int10 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV8EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8EmpCod), 4, 0));
      GXt_objcol_char12 = AV17SinCod ;
      GXv_objcol_char13[0] = GXt_objcol_char12 ;
      new web.getsindicatosactividadempresa(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, GXv_objcol_char13) ;
      GXt_objcol_char12 = GXv_objcol_char13[0] ;
      AV17SinCod = GXt_objcol_char12 ;
   }

   public void e12092( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(7);
      pr_default.close(6);
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void S112( )
   {
      /* 'LOADCOMBOCATPROVCOD' Routine */
      returnInSub = false ;
      Combo_catprovcod_Datalistprocparametersprefix = GXutil.format( " \"ComboName\": \"CatProvCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"CliPaiConve\": 0, \"CliConvenio\": \"\", \"CatCodigo\": \"\", \"Cond_CatPaiCod\": \"#%1#\"", edtCatPaiCod_Internalname, "", "", "", "", "", "", "", "") ;
      ucCombo_catprovcod.sendProperty(context, "", false, Combo_catprovcod_Internalname, "DataListProcParametersPrefix", Combo_catprovcod_Datalistprocparametersprefix);
   }

   public void zm09205( int GX_JID )
   {
      if ( ( GX_JID == 17 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z123CatDescrip = T00098_A123CatDescrip[0] ;
            Z676CatDescripSinAc = T00098_A676CatDescripSinAc[0] ;
            Z1838CatClase = T00098_A1838CatClase[0] ;
            Z2416CatTipoTarifa = T00098_A2416CatTipoTarifa[0] ;
            Z1914CatFrecAct = T00098_A1914CatFrecAct[0] ;
            Z1894CatRelSec = T00098_A1894CatRelSec[0] ;
            Z2040CatRelRef = T00098_A2040CatRelRef[0] ;
            Z2198CatAfipCod = T00098_A2198CatAfipCod[0] ;
         }
         else
         {
            Z123CatDescrip = A123CatDescrip ;
            Z676CatDescripSinAc = A676CatDescripSinAc ;
            Z1838CatClase = A1838CatClase ;
            Z2416CatTipoTarifa = A2416CatTipoTarifa ;
            Z1914CatFrecAct = A1914CatFrecAct ;
            Z1894CatRelSec = A1894CatRelSec ;
            Z2040CatRelRef = A2040CatRelRef ;
            Z2198CatAfipCod = A2198CatAfipCod ;
         }
      }
      if ( GX_JID == -17 )
      {
         Z8CatCodigo = A8CatCodigo ;
         Z123CatDescrip = A123CatDescrip ;
         Z676CatDescripSinAc = A676CatDescripSinAc ;
         Z1838CatClase = A1838CatClase ;
         Z2416CatTipoTarifa = A2416CatTipoTarifa ;
         Z1914CatFrecAct = A1914CatFrecAct ;
         Z1894CatRelSec = A1894CatRelSec ;
         Z2040CatRelRef = A2040CatRelRef ;
         Z2041CatOld = A2041CatOld ;
         Z2198CatAfipCod = A2198CatAfipCod ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
      }
   }

   public void standaloneNotModal( )
   {
      Gx_BScreen = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      bttBtntrn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      if ( ! (0==AV29CliPaiConve) )
      {
         A1564CliPaiConve = AV29CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int10 = A1564CliPaiConve ;
            GXv_int11[0] = GXt_int10 ;
            new web.clientegetpais(remoteHandle, context).execute( AV7CliCod, GXv_int11) ;
            categoria_impl.this.GXt_int10 = GXv_int11[0] ;
            A1564CliPaiConve = GXt_int10 ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         }
      }
      if ( ! (GXutil.strcmp("", AV9CatCodigo)==0) )
      {
         A8CatCodigo = AV9CatCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
      }
      if ( ! (GXutil.strcmp("", AV9CatCodigo)==0) )
      {
         edtCatCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatCodigo_Enabled), 5, 0), true);
      }
      else
      {
         edtCatCodigo_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatCodigo_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV9CatCodigo)==0) )
      {
         edtCatCodigo_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatCodigo_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtntrn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtntrn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Enabled), 5, 0), true);
      }
      if ( ! (GXutil.strcmp("", AV30CliConvenio)==0) )
      {
         A1565CliConvenio = AV30CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      }
      else
      {
         if ( isIns( )  && (GXutil.strcmp("", A1565CliConvenio)==0) && ( Gx_BScreen == 0 ) )
         {
            GXt_char1 = A1565CliConvenio ;
            GXv_char2[0] = GXt_char1 ;
            new web.getconveniodefault(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, "", GXv_char2) ;
            categoria_impl.this.GXt_char1 = GXv_char2[0] ;
            A1565CliConvenio = GXt_char1 ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         }
      }
      /* Using cursor T00099 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Cliente Convenios", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CLICONVENIO");
         AnyError = (short)(1) ;
      }
      pr_default.close(7);
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV38Pgmname = "Categoria" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38Pgmname", AV38Pgmname);
      }
   }

   public void load09205( )
   {
      /* Using cursor T000910 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      if ( (pr_default.getStatus(8) != 101) )
      {
         RcdFound205 = (short)(1) ;
         A123CatDescrip = T000910_A123CatDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
         A676CatDescripSinAc = T000910_A676CatDescripSinAc[0] ;
         A1838CatClase = T000910_A1838CatClase[0] ;
         A2416CatTipoTarifa = T000910_A2416CatTipoTarifa[0] ;
         A1914CatFrecAct = T000910_A1914CatFrecAct[0] ;
         A1894CatRelSec = T000910_A1894CatRelSec[0] ;
         n1894CatRelSec = T000910_n1894CatRelSec[0] ;
         A2040CatRelRef = T000910_A2040CatRelRef[0] ;
         A2041CatOld = T000910_A2041CatOld[0] ;
         A2198CatAfipCod = T000910_A2198CatAfipCod[0] ;
         n2198CatAfipCod = T000910_n2198CatAfipCod[0] ;
         zm09205( -17) ;
      }
      pr_default.close(8);
      onLoadActions09205( ) ;
   }

   public void onLoadActions09205( )
   {
      AV38Pgmname = "Categoria" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38Pgmname", AV38Pgmname);
   }

   public void checkExtendedTable09205( )
   {
      nIsDirty_205 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal( ) ;
      AV38Pgmname = "Categoria" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV38Pgmname", AV38Pgmname);
      if ( (GXutil.strcmp("", A8CatCodigo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Categoria", ""), "", "", "", "", "", "", "", ""), 1, "CATCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A123CatDescrip)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Categoría", ""), "", "", "", "", "", "", "", ""), 1, "CATDESCRIP");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatDescrip_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors09205( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey09205( )
   {
      /* Using cursor T000911 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound205 = (short)(1) ;
      }
      else
      {
         RcdFound205 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00098 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm09205( 17) ;
         RcdFound205 = (short)(1) ;
         A8CatCodigo = T00098_A8CatCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
         A123CatDescrip = T00098_A123CatDescrip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
         A676CatDescripSinAc = T00098_A676CatDescripSinAc[0] ;
         A1838CatClase = T00098_A1838CatClase[0] ;
         A2416CatTipoTarifa = T00098_A2416CatTipoTarifa[0] ;
         A1914CatFrecAct = T00098_A1914CatFrecAct[0] ;
         A1894CatRelSec = T00098_A1894CatRelSec[0] ;
         n1894CatRelSec = T00098_n1894CatRelSec[0] ;
         A2040CatRelRef = T00098_A2040CatRelRef[0] ;
         A2041CatOld = T00098_A2041CatOld[0] ;
         A2198CatAfipCod = T00098_A2198CatAfipCod[0] ;
         n2198CatAfipCod = T00098_n2198CatAfipCod[0] ;
         A3CliCod = T00098_A3CliCod[0] ;
         A1564CliPaiConve = T00098_A1564CliPaiConve[0] ;
         A1565CliConvenio = T00098_A1565CliConvenio[0] ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
         sMode205 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load09205( ) ;
         if ( AnyError == 1 )
         {
            RcdFound205 = (short)(0) ;
            initializeNonKey09205( ) ;
         }
         Gx_mode = sMode205 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound205 = (short)(0) ;
         initializeNonKey09205( ) ;
         sMode205 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode205 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey09205( ) ;
      if ( RcdFound205 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound205 = (short)(0) ;
      /* Using cursor T000912 */
      pr_default.execute(10, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A8CatCodigo});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( ( T000912_A3CliCod[0] < A3CliCod ) || ( T000912_A3CliCod[0] == A3CliCod ) && ( T000912_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T000912_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T000912_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T000912_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T000912_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T000912_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T000912_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T000912_A8CatCodigo[0], A8CatCodigo) < 0 ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( ( T000912_A3CliCod[0] > A3CliCod ) || ( T000912_A3CliCod[0] == A3CliCod ) && ( T000912_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T000912_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T000912_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T000912_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T000912_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T000912_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T000912_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T000912_A8CatCodigo[0], A8CatCodigo) > 0 ) ) )
         {
            A3CliCod = T000912_A3CliCod[0] ;
            A1564CliPaiConve = T000912_A1564CliPaiConve[0] ;
            A1565CliConvenio = T000912_A1565CliConvenio[0] ;
            A8CatCodigo = T000912_A8CatCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
            RcdFound205 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void move_previous( )
   {
      RcdFound205 = (short)(0) ;
      /* Using cursor T000913 */
      pr_default.execute(11, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A1565CliConvenio, A1565CliConvenio, Short.valueOf(A1564CliPaiConve), Integer.valueOf(A3CliCod), A8CatCodigo});
      if ( (pr_default.getStatus(11) != 101) )
      {
         while ( (pr_default.getStatus(11) != 101) && ( ( T000913_A3CliCod[0] > A3CliCod ) || ( T000913_A3CliCod[0] == A3CliCod ) && ( T000913_A1564CliPaiConve[0] > A1564CliPaiConve ) || ( T000913_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T000913_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T000913_A1565CliConvenio[0], A1565CliConvenio) > 0 ) || ( GXutil.strcmp(T000913_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T000913_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T000913_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T000913_A8CatCodigo[0], A8CatCodigo) > 0 ) ) )
         {
            pr_default.readNext(11);
         }
         if ( (pr_default.getStatus(11) != 101) && ( ( T000913_A3CliCod[0] < A3CliCod ) || ( T000913_A3CliCod[0] == A3CliCod ) && ( T000913_A1564CliPaiConve[0] < A1564CliPaiConve ) || ( T000913_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T000913_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T000913_A1565CliConvenio[0], A1565CliConvenio) < 0 ) || ( GXutil.strcmp(T000913_A1565CliConvenio[0], A1565CliConvenio) == 0 ) && ( T000913_A1564CliPaiConve[0] == A1564CliPaiConve ) && ( T000913_A3CliCod[0] == A3CliCod ) && ( GXutil.strcmp(T000913_A8CatCodigo[0], A8CatCodigo) < 0 ) ) )
         {
            A3CliCod = T000913_A3CliCod[0] ;
            A1564CliPaiConve = T000913_A1564CliPaiConve[0] ;
            A1565CliConvenio = T000913_A1565CliConvenio[0] ;
            A8CatCodigo = T000913_A8CatCodigo[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
            RcdFound205 = (short)(1) ;
         }
      }
      pr_default.close(11);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey09205( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCatCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert09205( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound205 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A8CatCodigo, Z8CatCodigo) != 0 ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1564CliPaiConve = Z1564CliPaiConve ;
               httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
               A1565CliConvenio = Z1565CliConvenio ;
               httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
               A8CatCodigo = Z8CatCodigo ;
               httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CATCODIGO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCatCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCatCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update09205( ) ;
               GX_FocusControl = edtCatCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A8CatCodigo, Z8CatCodigo) != 0 ) )
            {
               /* Insert record */
               GX_FocusControl = edtCatCodigo_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert09205( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CATCODIGO");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCatCodigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtCatCodigo_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert09205( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
      if ( isUpd( ) || isDlt( ) )
      {
         if ( AnyError == 0 )
         {
            httpContext.nUserReturn = (byte)(1) ;
         }
      }
   }

   public void btn_delete( )
   {
      if ( ( A3CliCod != Z3CliCod ) || ( A1564CliPaiConve != Z1564CliPaiConve ) || ( GXutil.strcmp(A1565CliConvenio, Z1565CliConvenio) != 0 ) || ( GXutil.strcmp(A8CatCodigo, Z8CatCodigo) != 0 ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1564CliPaiConve = Z1564CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         A1565CliConvenio = Z1565CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         A8CatCodigo = Z8CatCodigo ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CATCODIGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCatCodigo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency09205( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00097 */
         pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
         if ( (pr_default.getStatus(5) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Categoria1"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(5) == 101) || ( GXutil.strcmp(Z123CatDescrip, T00097_A123CatDescrip[0]) != 0 ) || ( GXutil.strcmp(Z676CatDescripSinAc, T00097_A676CatDescripSinAc[0]) != 0 ) || ( Z1838CatClase != T00097_A1838CatClase[0] ) || ( GXutil.strcmp(Z2416CatTipoTarifa, T00097_A2416CatTipoTarifa[0]) != 0 ) || ( Z1914CatFrecAct != T00097_A1914CatFrecAct[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z1894CatRelSec != T00097_A1894CatRelSec[0] ) || ( GXutil.strcmp(Z2040CatRelRef, T00097_A2040CatRelRef[0]) != 0 ) || ( GXutil.strcmp(Z2198CatAfipCod, T00097_A2198CatAfipCod[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z123CatDescrip, T00097_A123CatDescrip[0]) != 0 )
            {
               GXutil.writeLogln("categoria:[seudo value changed for attri]"+"CatDescrip");
               GXutil.writeLogRaw("Old: ",Z123CatDescrip);
               GXutil.writeLogRaw("Current: ",T00097_A123CatDescrip[0]);
            }
            if ( GXutil.strcmp(Z676CatDescripSinAc, T00097_A676CatDescripSinAc[0]) != 0 )
            {
               GXutil.writeLogln("categoria:[seudo value changed for attri]"+"CatDescripSinAc");
               GXutil.writeLogRaw("Old: ",Z676CatDescripSinAc);
               GXutil.writeLogRaw("Current: ",T00097_A676CatDescripSinAc[0]);
            }
            if ( Z1838CatClase != T00097_A1838CatClase[0] )
            {
               GXutil.writeLogln("categoria:[seudo value changed for attri]"+"CatClase");
               GXutil.writeLogRaw("Old: ",Z1838CatClase);
               GXutil.writeLogRaw("Current: ",T00097_A1838CatClase[0]);
            }
            if ( GXutil.strcmp(Z2416CatTipoTarifa, T00097_A2416CatTipoTarifa[0]) != 0 )
            {
               GXutil.writeLogln("categoria:[seudo value changed for attri]"+"CatTipoTarifa");
               GXutil.writeLogRaw("Old: ",Z2416CatTipoTarifa);
               GXutil.writeLogRaw("Current: ",T00097_A2416CatTipoTarifa[0]);
            }
            if ( Z1914CatFrecAct != T00097_A1914CatFrecAct[0] )
            {
               GXutil.writeLogln("categoria:[seudo value changed for attri]"+"CatFrecAct");
               GXutil.writeLogRaw("Old: ",Z1914CatFrecAct);
               GXutil.writeLogRaw("Current: ",T00097_A1914CatFrecAct[0]);
            }
            if ( Z1894CatRelSec != T00097_A1894CatRelSec[0] )
            {
               GXutil.writeLogln("categoria:[seudo value changed for attri]"+"CatRelSec");
               GXutil.writeLogRaw("Old: ",Z1894CatRelSec);
               GXutil.writeLogRaw("Current: ",T00097_A1894CatRelSec[0]);
            }
            if ( GXutil.strcmp(Z2040CatRelRef, T00097_A2040CatRelRef[0]) != 0 )
            {
               GXutil.writeLogln("categoria:[seudo value changed for attri]"+"CatRelRef");
               GXutil.writeLogRaw("Old: ",Z2040CatRelRef);
               GXutil.writeLogRaw("Current: ",T00097_A2040CatRelRef[0]);
            }
            if ( GXutil.strcmp(Z2198CatAfipCod, T00097_A2198CatAfipCod[0]) != 0 )
            {
               GXutil.writeLogln("categoria:[seudo value changed for attri]"+"CatAfipCod");
               GXutil.writeLogRaw("Old: ",Z2198CatAfipCod);
               GXutil.writeLogRaw("Current: ",T00097_A2198CatAfipCod[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Categoria1"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert09205( )
   {
      beforeValidate09205( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable09205( ) ;
      }
      if ( AnyError == 0 )
      {
         zm09205( 0) ;
         checkOptimisticConcurrency09205( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm09205( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert09205( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000914 */
                  pr_default.execute(12, new Object[] {A8CatCodigo, A123CatDescrip, A676CatDescripSinAc, Byte.valueOf(A1838CatClase), A2416CatTipoTarifa, Byte.valueOf(A1914CatFrecAct), Boolean.valueOf(n1894CatRelSec), Short.valueOf(A1894CatRelSec), A2040CatRelRef, A2041CatOld, Boolean.valueOf(n2198CatAfipCod), A2198CatAfipCod, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoria1");
                  if ( (pr_default.getStatus(12) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel09205( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption090( ) ;
                        }
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load09205( ) ;
         }
         endLevel09205( ) ;
      }
      closeExtendedTableCursors09205( ) ;
   }

   public void update09205( )
   {
      beforeValidate09205( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable09205( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency09205( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm09205( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate09205( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000915 */
                  pr_default.execute(13, new Object[] {A123CatDescrip, A676CatDescripSinAc, Byte.valueOf(A1838CatClase), A2416CatTipoTarifa, Byte.valueOf(A1914CatFrecAct), Boolean.valueOf(n1894CatRelSec), Short.valueOf(A1894CatRelSec), A2040CatRelRef, A2041CatOld, Boolean.valueOf(n2198CatAfipCod), A2198CatAfipCod, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoria1");
                  if ( (pr_default.getStatus(13) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Categoria1"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate09205( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel09205( ) ;
                        if ( AnyError == 0 )
                        {
                           if ( isUpd( ) || isDlt( ) )
                           {
                              if ( AnyError == 0 )
                              {
                                 httpContext.nUserReturn = (byte)(1) ;
                              }
                           }
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel09205( ) ;
      }
      closeExtendedTableCursors09205( ) ;
   }

   public void deferredUpdate09205( )
   {
   }

   public void delete( )
   {
      beforeValidate09205( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency09205( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls09205( ) ;
         afterConfirm09205( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete09205( ) ;
            if ( AnyError == 0 )
            {
               scanStart09274( ) ;
               while ( RcdFound274 != 0 )
               {
                  getByPrimaryKey09274( ) ;
                  delete09274( ) ;
                  scanNext09274( ) ;
               }
               scanEnd09274( ) ;
               scanStart09206( ) ;
               while ( RcdFound206 != 0 )
               {
                  getByPrimaryKey09206( ) ;
                  delete09206( ) ;
                  scanNext09206( ) ;
               }
               scanEnd09206( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000916 */
                  pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoria1");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( delete) rules */
                     /* End of After( delete) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( AnyError == 0 )
                           {
                              httpContext.nUserReturn = (byte)(1) ;
                           }
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
      }
      sMode205 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel09205( ) ;
      Gx_mode = sMode205 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls09205( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV38Pgmname = "Categoria" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV38Pgmname", AV38Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000917 */
         pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
         if ( (pr_default.getStatus(15) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {httpContext.getMessage( "LiquidacionCategoria", "")}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(15);
      }
   }

   public void processNestedLevel09274( )
   {
      nGXsfl_40_idx = 0 ;
      while ( nGXsfl_40_idx < nRC_GXsfl_40 )
      {
         readRow09274( ) ;
         if ( ( nRcdExists_274 != 0 ) || ( nIsMod_274 != 0 ) )
         {
            standaloneNotModal09274( ) ;
            getKey09274( ) ;
            if ( ( nRcdExists_274 == 0 ) && ( nRcdDeleted_274 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert09274( ) ;
            }
            else
            {
               if ( RcdFound274 != 0 )
               {
                  if ( ( nRcdDeleted_274 != 0 ) && ( nRcdExists_274 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete09274( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_274 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update09274( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_274 == 0 )
                  {
                     GXCCtl = "CATPAICOD_" + sGXsfl_40_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCatPaiCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtCatPaiCod_Internalname, GXutil.ltrim( localUtil.ntoc( A2200CatPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtCatProvCod_Internalname, GXutil.ltrim( localUtil.ntoc( A2201CatProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2200CatPaiCod_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( Z2200CatPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2201CatProvCod_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( Z2201CatProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2202CatProvRelSec_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( Z2202CatProvRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2203CatProvRelRef_"+sGXsfl_40_idx, Z2203CatProvRelRef) ;
         httpContext.changePostValue( "nRcdDeleted_274_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_274, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_274_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_274, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_274_"+sGXsfl_40_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_274, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_274 != 0 )
         {
            httpContext.changePostValue( "CATPAICOD_"+sGXsfl_40_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatPaiCod_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATPAICOD_"+sGXsfl_40_idx+"Horizontalalignment", GXutil.rtrim( edtCatPaiCod_Horizontalalignment)) ;
            httpContext.changePostValue( "CATPROVCOD_"+sGXsfl_40_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatProvCod_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATPROVCOD_"+sGXsfl_40_idx+"Horizontalalignment", GXutil.rtrim( edtCatProvCod_Horizontalalignment)) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll09274( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_274 = (short)(0) ;
      nIsMod_274 = (short)(0) ;
      nRcdDeleted_274 = (short)(0) ;
   }

   public void processNestedLevel09206( )
   {
      nGXsfl_30_idx = 0 ;
      while ( nGXsfl_30_idx < nRC_GXsfl_30 )
      {
         readRow09206( ) ;
         if ( ( nRcdExists_206 != 0 ) || ( nIsMod_206 != 0 ) )
         {
            standaloneNotModal09206( ) ;
            getKey09206( ) ;
            if ( ( nRcdExists_206 == 0 ) && ( nRcdDeleted_206 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert09206( ) ;
            }
            else
            {
               if ( RcdFound206 != 0 )
               {
                  if ( ( nRcdDeleted_206 != 0 ) && ( nRcdExists_206 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete09206( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_206 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update09206( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_206 == 0 )
                  {
                     GXCCtl = "CATVIGENCIA_" + sGXsfl_30_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCatVigencia_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtCatVigencia_Internalname, localUtil.format(A907CatVigencia, "99/99/9999")) ;
         httpContext.changePostValue( edtCatBasico_Internalname, GXutil.ltrim( localUtil.ntoc( A122CatBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtCatAdicional_Internalname, GXutil.ltrim( localUtil.ntoc( A908CatAdicional, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtCatValorHora_Internalname, GXutil.ltrim( localUtil.ntoc( A731CatValorHora, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtCatAdiHora_Internalname, GXutil.ltrim( localUtil.ntoc( A909CatAdiHora, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtEscBasico_Internalname, GXutil.ltrim( localUtil.ntoc( A1892EscBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtEscAdicional_Internalname, GXutil.ltrim( localUtil.ntoc( A1893EscAdicional, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z907CatVigencia_"+sGXsfl_30_idx, localUtil.dtoc( Z907CatVigencia, 0, "/")) ;
         httpContext.changePostValue( "ZT_"+"Z122CatBasico_"+sGXsfl_30_idx, GXutil.ltrim( localUtil.ntoc( Z122CatBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z731CatValorHora_"+sGXsfl_30_idx, GXutil.ltrim( localUtil.ntoc( Z731CatValorHora, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z908CatAdicional_"+sGXsfl_30_idx, GXutil.ltrim( localUtil.ntoc( Z908CatAdicional, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z909CatAdiHora_"+sGXsfl_30_idx, GXutil.ltrim( localUtil.ntoc( Z909CatAdiHora, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1892EscBasico_"+sGXsfl_30_idx, GXutil.ltrim( localUtil.ntoc( Z1892EscBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z1893EscAdicional_"+sGXsfl_30_idx, GXutil.ltrim( localUtil.ntoc( Z1893EscAdicional, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdDeleted_206_"+sGXsfl_30_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_206_"+sGXsfl_30_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_206_"+sGXsfl_30_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_206 != 0 )
         {
            httpContext.changePostValue( "CATVIGENCIA_"+sGXsfl_30_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatVigencia_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATBASICO_"+sGXsfl_30_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatBasico_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATADICIONAL_"+sGXsfl_30_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatAdicional_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATVALORHORA_"+sGXsfl_30_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatValorHora_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CATADIHORA_"+sGXsfl_30_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatAdiHora_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ESCBASICO_"+sGXsfl_30_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEscBasico_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "ESCADICIONAL_"+sGXsfl_30_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEscAdicional_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll09206( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_206 = (short)(0) ;
      nIsMod_206 = (short)(0) ;
      nRcdDeleted_206 = (short)(0) ;
   }

   public void processLevel09205( )
   {
      /* Save parent mode. */
      sMode205 = Gx_mode ;
      processNestedLevel09274( ) ;
      processNestedLevel09206( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode205 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel09205( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(5);
      }
      if ( AnyError == 0 )
      {
         beforeComplete09205( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "categoria");
         if ( AnyError == 0 )
         {
            confirmValues090( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "categoria");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart09205( )
   {
      /* Scan By routine */
      /* Using cursor T000918 */
      pr_default.execute(16);
      RcdFound205 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound205 = (short)(1) ;
         A3CliCod = T000918_A3CliCod[0] ;
         A1564CliPaiConve = T000918_A1564CliPaiConve[0] ;
         A1565CliConvenio = T000918_A1565CliConvenio[0] ;
         A8CatCodigo = T000918_A8CatCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
      }
      /* Load Subordinate Levels */
   }

   public void scanNext09205( )
   {
      /* Scan next routine */
      pr_default.readNext(16);
      RcdFound205 = (short)(0) ;
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound205 = (short)(1) ;
         A3CliCod = T000918_A3CliCod[0] ;
         A1564CliPaiConve = T000918_A1564CliPaiConve[0] ;
         A1565CliConvenio = T000918_A1565CliConvenio[0] ;
         A8CatCodigo = T000918_A8CatCodigo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
      }
   }

   public void scanEnd09205( )
   {
      pr_default.close(16);
   }

   public void afterConfirm09205( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert09205( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate09205( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete09205( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete09205( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate09205( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes09205( )
   {
      edtCatCodigo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatCodigo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatCodigo_Enabled), 5, 0), true);
      edtCatDescrip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatDescrip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatDescrip_Enabled), 5, 0), true);
   }

   public void zm09274( int GX_JID )
   {
      if ( ( GX_JID == 19 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2202CatProvRelSec = T00095_A2202CatProvRelSec[0] ;
            Z2203CatProvRelRef = T00095_A2203CatProvRelRef[0] ;
         }
         else
         {
            Z2202CatProvRelSec = A2202CatProvRelSec ;
            Z2203CatProvRelRef = A2203CatProvRelRef ;
         }
      }
      if ( GX_JID == -19 )
      {
         Z3CliCod = A3CliCod ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
         Z2202CatProvRelSec = A2202CatProvRelSec ;
         Z2203CatProvRelRef = A2203CatProvRelRef ;
         Z2204CatProvOld = A2204CatProvOld ;
         Z2200CatPaiCod = A2200CatPaiCod ;
         Z2201CatProvCod = A2201CatProvCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
      }
   }

   public void standaloneNotModal09274( )
   {
   }

   public void standaloneModal09274( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtCatPaiCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatPaiCod_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      }
      else
      {
         edtCatPaiCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatPaiCod_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      }
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtCatProvCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatProvCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatProvCod_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      }
      else
      {
         edtCatProvCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatProvCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatProvCod_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      }
   }

   public void load09274( )
   {
      /* Using cursor T000919 */
      pr_default.execute(17, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
      if ( (pr_default.getStatus(17) != 101) )
      {
         RcdFound274 = (short)(1) ;
         A2202CatProvRelSec = T000919_A2202CatProvRelSec[0] ;
         n2202CatProvRelSec = T000919_n2202CatProvRelSec[0] ;
         A2203CatProvRelRef = T000919_A2203CatProvRelRef[0] ;
         n2203CatProvRelRef = T000919_n2203CatProvRelRef[0] ;
         A2204CatProvOld = T000919_A2204CatProvOld[0] ;
         n2204CatProvOld = T000919_n2204CatProvOld[0] ;
         zm09274( -19) ;
      }
      pr_default.close(17);
      onLoadActions09274( ) ;
   }

   public void onLoadActions09274( )
   {
   }

   public void checkExtendedTable09274( )
   {
      nIsDirty_274 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal09274( ) ;
      /* Using cursor T00096 */
      pr_default.execute(4, new Object[] {Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         GXCCtl = "CATPROVCOD_" + sGXsfl_40_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Provincia Categoria", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(4);
   }

   public void closeExtendedTableCursors09274( )
   {
      pr_default.close(4);
   }

   public void enableDisable09274( )
   {
   }

   public void gxload_20( short A2200CatPaiCod ,
                          short A2201CatProvCod )
   {
      /* Using cursor T000920 */
      pr_default.execute(18, new Object[] {Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
      if ( (pr_default.getStatus(18) == 101) )
      {
         GXCCtl = "CATPROVCOD_" + sGXsfl_40_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Provincia Categoria", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatPaiCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(18) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(18);
   }

   public void getKey09274( )
   {
      /* Using cursor T000921 */
      pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound274 = (short)(1) ;
      }
      else
      {
         RcdFound274 = (short)(0) ;
      }
      pr_default.close(19);
   }

   public void getByPrimaryKey09274( )
   {
      /* Using cursor T00095 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         zm09274( 19) ;
         RcdFound274 = (short)(1) ;
         initializeNonKey09274( ) ;
         A2202CatProvRelSec = T00095_A2202CatProvRelSec[0] ;
         n2202CatProvRelSec = T00095_n2202CatProvRelSec[0] ;
         A2203CatProvRelRef = T00095_A2203CatProvRelRef[0] ;
         n2203CatProvRelRef = T00095_n2203CatProvRelRef[0] ;
         A2204CatProvOld = T00095_A2204CatProvOld[0] ;
         n2204CatProvOld = T00095_n2204CatProvOld[0] ;
         A2200CatPaiCod = T00095_A2200CatPaiCod[0] ;
         A2201CatProvCod = T00095_A2201CatProvCod[0] ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
         Z2200CatPaiCod = A2200CatPaiCod ;
         Z2201CatProvCod = A2201CatProvCod ;
         sMode274 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load09274( ) ;
         Gx_mode = sMode274 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound274 = (short)(0) ;
         initializeNonKey09274( ) ;
         sMode274 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal09274( ) ;
         Gx_mode = sMode274 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes09274( ) ;
      }
      pr_default.close(3);
   }

   public void checkOptimisticConcurrency09274( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00094 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
         if ( (pr_default.getStatus(2) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CategoriaProvincias"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(2) == 101) || ( Z2202CatProvRelSec != T00094_A2202CatProvRelSec[0] ) || ( GXutil.strcmp(Z2203CatProvRelRef, T00094_A2203CatProvRelRef[0]) != 0 ) )
         {
            if ( Z2202CatProvRelSec != T00094_A2202CatProvRelSec[0] )
            {
               GXutil.writeLogln("categoria:[seudo value changed for attri]"+"CatProvRelSec");
               GXutil.writeLogRaw("Old: ",Z2202CatProvRelSec);
               GXutil.writeLogRaw("Current: ",T00094_A2202CatProvRelSec[0]);
            }
            if ( GXutil.strcmp(Z2203CatProvRelRef, T00094_A2203CatProvRelRef[0]) != 0 )
            {
               GXutil.writeLogln("categoria:[seudo value changed for attri]"+"CatProvRelRef");
               GXutil.writeLogRaw("Old: ",Z2203CatProvRelRef);
               GXutil.writeLogRaw("Current: ",T00094_A2203CatProvRelRef[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"CategoriaProvincias"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert09274( )
   {
      beforeValidate09274( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable09274( ) ;
      }
      if ( AnyError == 0 )
      {
         zm09274( 0) ;
         checkOptimisticConcurrency09274( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm09274( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert09274( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000922 */
                  pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), A1565CliConvenio, A8CatCodigo, Boolean.valueOf(n2202CatProvRelSec), Integer.valueOf(A2202CatProvRelSec), Boolean.valueOf(n2203CatProvRelRef), A2203CatProvRelRef, Boolean.valueOf(n2204CatProvOld), A2204CatProvOld, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod), Short.valueOf(A1564CliPaiConve)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("CategoriaProvincias");
                  if ( (pr_default.getStatus(20) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load09274( ) ;
         }
         endLevel09274( ) ;
      }
      closeExtendedTableCursors09274( ) ;
   }

   public void update09274( )
   {
      beforeValidate09274( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable09274( ) ;
      }
      if ( ( nIsMod_274 != 0 ) || ( nIsDirty_274 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency09274( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm09274( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate09274( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T000923 */
                     pr_default.execute(21, new Object[] {Boolean.valueOf(n2202CatProvRelSec), Integer.valueOf(A2202CatProvRelSec), Boolean.valueOf(n2203CatProvRelRef), A2203CatProvRelRef, Boolean.valueOf(n2204CatProvOld), A2204CatProvOld, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("CategoriaProvincias");
                     if ( (pr_default.getStatus(21) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CategoriaProvincias"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate09274( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey09274( ) ;
                        }
                     }
                     else
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                        AnyError = (short)(1) ;
                     }
                  }
               }
            }
            endLevel09274( ) ;
         }
      }
      closeExtendedTableCursors09274( ) ;
   }

   public void deferredUpdate09274( )
   {
   }

   public void delete09274( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate09274( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency09274( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls09274( ) ;
         afterConfirm09274( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete09274( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000924 */
               pr_default.execute(22, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("CategoriaProvincias");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode274 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel09274( ) ;
      Gx_mode = sMode274 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls09274( )
   {
      standaloneModal09274( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel09274( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(2);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart09274( )
   {
      /* Scan By routine */
      /* Using cursor T000925 */
      pr_default.execute(23, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      RcdFound274 = (short)(0) ;
      if ( (pr_default.getStatus(23) != 101) )
      {
         RcdFound274 = (short)(1) ;
         A2200CatPaiCod = T000925_A2200CatPaiCod[0] ;
         A2201CatProvCod = T000925_A2201CatProvCod[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext09274( )
   {
      /* Scan next routine */
      pr_default.readNext(23);
      RcdFound274 = (short)(0) ;
      if ( (pr_default.getStatus(23) != 101) )
      {
         RcdFound274 = (short)(1) ;
         A2200CatPaiCod = T000925_A2200CatPaiCod[0] ;
         A2201CatProvCod = T000925_A2201CatProvCod[0] ;
      }
   }

   public void scanEnd09274( )
   {
      pr_default.close(23);
   }

   public void afterConfirm09274( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert09274( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate09274( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete09274( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete09274( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate09274( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes09274( )
   {
      edtCatPaiCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatPaiCod_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtCatProvCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatProvCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatProvCod_Enabled), 5, 0), !bGXsfl_40_Refreshing);
   }

   public void send_integrity_lvl_hashes09274( )
   {
   }

   public void zm09206( int GX_JID )
   {
      if ( ( GX_JID == 21 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z122CatBasico = T00093_A122CatBasico[0] ;
            Z731CatValorHora = T00093_A731CatValorHora[0] ;
            Z908CatAdicional = T00093_A908CatAdicional[0] ;
            Z909CatAdiHora = T00093_A909CatAdiHora[0] ;
            Z1892EscBasico = T00093_A1892EscBasico[0] ;
            Z1893EscAdicional = T00093_A1893EscAdicional[0] ;
         }
         else
         {
            Z122CatBasico = A122CatBasico ;
            Z731CatValorHora = A731CatValorHora ;
            Z908CatAdicional = A908CatAdicional ;
            Z909CatAdiHora = A909CatAdiHora ;
            Z1892EscBasico = A1892EscBasico ;
            Z1893EscAdicional = A1893EscAdicional ;
         }
      }
      if ( GX_JID == -21 )
      {
         Z3CliCod = A3CliCod ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
         Z907CatVigencia = A907CatVigencia ;
         Z122CatBasico = A122CatBasico ;
         Z731CatValorHora = A731CatValorHora ;
         Z908CatAdicional = A908CatAdicional ;
         Z909CatAdiHora = A909CatAdiHora ;
         Z1892EscBasico = A1892EscBasico ;
         Z1893EscAdicional = A1893EscAdicional ;
         Z1564CliPaiConve = A1564CliPaiConve ;
      }
   }

   public void standaloneNotModal09206( )
   {
      edtCatBasico_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatBasico_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatBasico_Enabled), 5, 0), !bGXsfl_30_Refreshing);
      edtCatAdicional_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatAdicional_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatAdicional_Enabled), 5, 0), !bGXsfl_30_Refreshing);
      edtCatValorHora_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatValorHora_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatValorHora_Enabled), 5, 0), !bGXsfl_30_Refreshing);
      edtCatAdiHora_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatAdiHora_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatAdiHora_Enabled), 5, 0), !bGXsfl_30_Refreshing);
   }

   public void standaloneModal09206( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtCatVigencia_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatVigencia_Enabled), 5, 0), !bGXsfl_30_Refreshing);
      }
      else
      {
         edtCatVigencia_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCatVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatVigencia_Enabled), 5, 0), !bGXsfl_30_Refreshing);
      }
   }

   public void load09206( )
   {
      /* Using cursor T000926 */
      pr_default.execute(24, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
      if ( (pr_default.getStatus(24) != 101) )
      {
         RcdFound206 = (short)(1) ;
         A122CatBasico = T000926_A122CatBasico[0] ;
         n122CatBasico = T000926_n122CatBasico[0] ;
         A731CatValorHora = T000926_A731CatValorHora[0] ;
         n731CatValorHora = T000926_n731CatValorHora[0] ;
         A908CatAdicional = T000926_A908CatAdicional[0] ;
         n908CatAdicional = T000926_n908CatAdicional[0] ;
         A909CatAdiHora = T000926_A909CatAdiHora[0] ;
         n909CatAdiHora = T000926_n909CatAdiHora[0] ;
         A1892EscBasico = T000926_A1892EscBasico[0] ;
         A1893EscAdicional = T000926_A1893EscAdicional[0] ;
         zm09206( -21) ;
      }
      pr_default.close(24);
      onLoadActions09206( ) ;
   }

   public void onLoadActions09206( )
   {
   }

   public void checkExtendedTable09206( )
   {
      nIsDirty_206 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_BScreen", GXutil.str( Gx_BScreen, 1, 0));
      standaloneModal09206( ) ;
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A907CatVigencia)) )
      {
         GXCCtl = "CATVIGENCIA_" + sGXsfl_30_idx ;
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Vigencia desde", ""), "", "", "", "", "", "", "", ""), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatVigencia_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void closeExtendedTableCursors09206( )
   {
   }

   public void enableDisable09206( )
   {
   }

   public void getKey09206( )
   {
      /* Using cursor T000927 */
      pr_default.execute(25, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
      if ( (pr_default.getStatus(25) != 101) )
      {
         RcdFound206 = (short)(1) ;
      }
      else
      {
         RcdFound206 = (short)(0) ;
      }
      pr_default.close(25);
   }

   public void getByPrimaryKey09206( )
   {
      /* Using cursor T00093 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm09206( 21) ;
         RcdFound206 = (short)(1) ;
         initializeNonKey09206( ) ;
         A907CatVigencia = T00093_A907CatVigencia[0] ;
         A122CatBasico = T00093_A122CatBasico[0] ;
         n122CatBasico = T00093_n122CatBasico[0] ;
         A731CatValorHora = T00093_A731CatValorHora[0] ;
         n731CatValorHora = T00093_n731CatValorHora[0] ;
         A908CatAdicional = T00093_A908CatAdicional[0] ;
         n908CatAdicional = T00093_n908CatAdicional[0] ;
         A909CatAdiHora = T00093_A909CatAdiHora[0] ;
         n909CatAdiHora = T00093_n909CatAdiHora[0] ;
         A1892EscBasico = T00093_A1892EscBasico[0] ;
         A1893EscAdicional = T00093_A1893EscAdicional[0] ;
         Z3CliCod = A3CliCod ;
         Z1564CliPaiConve = A1564CliPaiConve ;
         Z1565CliConvenio = A1565CliConvenio ;
         Z8CatCodigo = A8CatCodigo ;
         Z907CatVigencia = A907CatVigencia ;
         sMode206 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load09206( ) ;
         Gx_mode = sMode206 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound206 = (short)(0) ;
         initializeNonKey09206( ) ;
         sMode206 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal09206( ) ;
         Gx_mode = sMode206 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes09206( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency09206( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00092 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Categoriavalores1"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( DecimalUtil.compareTo(Z122CatBasico, T00092_A122CatBasico[0]) != 0 ) || ( DecimalUtil.compareTo(Z731CatValorHora, T00092_A731CatValorHora[0]) != 0 ) || ( DecimalUtil.compareTo(Z908CatAdicional, T00092_A908CatAdicional[0]) != 0 ) || ( DecimalUtil.compareTo(Z909CatAdiHora, T00092_A909CatAdiHora[0]) != 0 ) || ( DecimalUtil.compareTo(Z1892EscBasico, T00092_A1892EscBasico[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( DecimalUtil.compareTo(Z1893EscAdicional, T00092_A1893EscAdicional[0]) != 0 ) )
         {
            if ( DecimalUtil.compareTo(Z122CatBasico, T00092_A122CatBasico[0]) != 0 )
            {
               GXutil.writeLogln("categoria:[seudo value changed for attri]"+"CatBasico");
               GXutil.writeLogRaw("Old: ",Z122CatBasico);
               GXutil.writeLogRaw("Current: ",T00092_A122CatBasico[0]);
            }
            if ( DecimalUtil.compareTo(Z731CatValorHora, T00092_A731CatValorHora[0]) != 0 )
            {
               GXutil.writeLogln("categoria:[seudo value changed for attri]"+"CatValorHora");
               GXutil.writeLogRaw("Old: ",Z731CatValorHora);
               GXutil.writeLogRaw("Current: ",T00092_A731CatValorHora[0]);
            }
            if ( DecimalUtil.compareTo(Z908CatAdicional, T00092_A908CatAdicional[0]) != 0 )
            {
               GXutil.writeLogln("categoria:[seudo value changed for attri]"+"CatAdicional");
               GXutil.writeLogRaw("Old: ",Z908CatAdicional);
               GXutil.writeLogRaw("Current: ",T00092_A908CatAdicional[0]);
            }
            if ( DecimalUtil.compareTo(Z909CatAdiHora, T00092_A909CatAdiHora[0]) != 0 )
            {
               GXutil.writeLogln("categoria:[seudo value changed for attri]"+"CatAdiHora");
               GXutil.writeLogRaw("Old: ",Z909CatAdiHora);
               GXutil.writeLogRaw("Current: ",T00092_A909CatAdiHora[0]);
            }
            if ( DecimalUtil.compareTo(Z1892EscBasico, T00092_A1892EscBasico[0]) != 0 )
            {
               GXutil.writeLogln("categoria:[seudo value changed for attri]"+"EscBasico");
               GXutil.writeLogRaw("Old: ",Z1892EscBasico);
               GXutil.writeLogRaw("Current: ",T00092_A1892EscBasico[0]);
            }
            if ( DecimalUtil.compareTo(Z1893EscAdicional, T00092_A1893EscAdicional[0]) != 0 )
            {
               GXutil.writeLogln("categoria:[seudo value changed for attri]"+"EscAdicional");
               GXutil.writeLogRaw("Old: ",Z1893EscAdicional);
               GXutil.writeLogRaw("Current: ",T00092_A1893EscAdicional[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Categoriavalores1"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert09206( )
   {
      beforeValidate09206( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable09206( ) ;
      }
      if ( AnyError == 0 )
      {
         zm09206( 0) ;
         checkOptimisticConcurrency09206( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm09206( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert09206( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000928 */
                  pr_default.execute(26, new Object[] {Integer.valueOf(A3CliCod), A1565CliConvenio, A8CatCodigo, A907CatVigencia, Boolean.valueOf(n122CatBasico), A122CatBasico, Boolean.valueOf(n731CatValorHora), A731CatValorHora, Boolean.valueOf(n908CatAdicional), A908CatAdicional, Boolean.valueOf(n909CatAdiHora), A909CatAdiHora, A1892EscBasico, A1893EscAdicional, Short.valueOf(A1564CliPaiConve)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
                  if ( (pr_default.getStatus(26) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load09206( ) ;
         }
         endLevel09206( ) ;
      }
      closeExtendedTableCursors09206( ) ;
   }

   public void update09206( )
   {
      beforeValidate09206( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable09206( ) ;
      }
      if ( ( nIsMod_206 != 0 ) || ( nIsDirty_206 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency09206( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm09206( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate09206( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T000929 */
                     pr_default.execute(27, new Object[] {Boolean.valueOf(n122CatBasico), A122CatBasico, Boolean.valueOf(n731CatValorHora), A731CatValorHora, Boolean.valueOf(n908CatAdicional), A908CatAdicional, Boolean.valueOf(n909CatAdiHora), A909CatAdiHora, A1892EscBasico, A1893EscAdicional, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
                     if ( (pr_default.getStatus(27) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Categoriavalores1"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate09206( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey09206( ) ;
                        }
                     }
                     else
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                        AnyError = (short)(1) ;
                     }
                  }
               }
            }
            endLevel09206( ) ;
         }
      }
      closeExtendedTableCursors09206( ) ;
   }

   public void deferredUpdate09206( )
   {
   }

   public void delete09206( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate09206( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency09206( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls09206( ) ;
         afterConfirm09206( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete09206( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000930 */
               pr_default.execute(28, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode206 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel09206( ) ;
      Gx_mode = sMode206 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls09206( )
   {
      standaloneModal09206( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel09206( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart09206( )
   {
      /* Scan By routine */
      /* Using cursor T000931 */
      pr_default.execute(29, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
      RcdFound206 = (short)(0) ;
      if ( (pr_default.getStatus(29) != 101) )
      {
         RcdFound206 = (short)(1) ;
         A907CatVigencia = T000931_A907CatVigencia[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext09206( )
   {
      /* Scan next routine */
      pr_default.readNext(29);
      RcdFound206 = (short)(0) ;
      if ( (pr_default.getStatus(29) != 101) )
      {
         RcdFound206 = (short)(1) ;
         A907CatVigencia = T000931_A907CatVigencia[0] ;
      }
   }

   public void scanEnd09206( )
   {
      pr_default.close(29);
   }

   public void afterConfirm09206( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert09206( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate09206( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete09206( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete09206( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate09206( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes09206( )
   {
      edtCatVigencia_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatVigencia_Enabled), 5, 0), !bGXsfl_30_Refreshing);
      edtCatBasico_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatBasico_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatBasico_Enabled), 5, 0), !bGXsfl_30_Refreshing);
      edtCatAdicional_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatAdicional_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatAdicional_Enabled), 5, 0), !bGXsfl_30_Refreshing);
      edtCatValorHora_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatValorHora_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatValorHora_Enabled), 5, 0), !bGXsfl_30_Refreshing);
      edtCatAdiHora_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatAdiHora_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatAdiHora_Enabled), 5, 0), !bGXsfl_30_Refreshing);
      edtEscBasico_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEscBasico_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEscBasico_Enabled), 5, 0), !bGXsfl_30_Refreshing);
      edtEscAdicional_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEscAdicional_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEscAdicional_Enabled), 5, 0), !bGXsfl_30_Refreshing);
   }

   public void send_integrity_lvl_hashes09206( )
   {
   }

   public void send_integrity_lvl_hashes09205( )
   {
   }

   public void subsflControlProps_40274( )
   {
      edtCatPaiCod_Internalname = "CATPAICOD_"+sGXsfl_40_idx ;
      edtCatProvCod_Internalname = "CATPROVCOD_"+sGXsfl_40_idx ;
   }

   public void subsflControlProps_fel_40274( )
   {
      edtCatPaiCod_Internalname = "CATPAICOD_"+sGXsfl_40_fel_idx ;
      edtCatProvCod_Internalname = "CATPROVCOD_"+sGXsfl_40_fel_idx ;
   }

   public void addRow09274( )
   {
      nGXsfl_40_idx = (int)(nGXsfl_40_idx+1) ;
      sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_40274( ) ;
      sendRow09274( ) ;
   }

   public void sendRow09274( )
   {
      Gridlevel2Row = GXWebRow.GetNew(context) ;
      if ( subGridlevel2_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel2_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel2_Class, "") != 0 )
         {
            subGridlevel2_Linesclass = subGridlevel2_Class+"Odd" ;
         }
      }
      else if ( subGridlevel2_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel2_Backstyle = (byte)(0) ;
         subGridlevel2_Backcolor = subGridlevel2_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel2_Class, "") != 0 )
         {
            subGridlevel2_Linesclass = subGridlevel2_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel2_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel2_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel2_Class, "") != 0 )
         {
            subGridlevel2_Linesclass = subGridlevel2_Class+"Odd" ;
         }
         subGridlevel2_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel2_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel2_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_40_idx) % (2))) == 0 )
         {
            subGridlevel2_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel2_Class, "") != 0 )
            {
               subGridlevel2_Linesclass = subGridlevel2_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel2_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel2_Class, "") != 0 )
            {
               subGridlevel2_Linesclass = subGridlevel2_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_274_" + sGXsfl_40_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 41,'',false,'" + sGXsfl_40_idx + "',40)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCatPaiCod_Internalname,GXutil.ltrim( localUtil.ntoc( A2200CatPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2200CatPaiCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,41);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCatPaiCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtCatPaiCod_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico",edtCatPaiCod_Horizontalalignment,Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_274_" + sGXsfl_40_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 42,'',false,'" + sGXsfl_40_idx + "',40)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel2Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCatProvCod_Internalname,GXutil.ltrim( localUtil.ntoc( A2201CatProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A2201CatProvCod), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,42);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCatProvCod_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtCatProvCod_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"CodigoChico",edtCatProvCod_Horizontalalignment,Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridlevel2Row);
      send_integrity_lvl_hashes09274( ) ;
      GXCCtl = "Z2200CatPaiCod_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2200CatPaiCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z2201CatProvCod_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2201CatProvCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z2202CatProvRelSec_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2202CatProvRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z2203CatProvRelRef_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z2203CatProvRelRef);
      GXCCtl = "nRcdDeleted_274_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_274, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_274_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_274, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_274_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_274, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vCLICOD_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vCLIPAICONVE_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV29CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vCLICONVENIO_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV30CliConvenio));
      GXCCtl = "vCATCODIGO_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV9CatCodigo));
      GXCCtl = "CLICOD_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "CLIPAICONVE_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "CLICONVENIO_" + sGXsfl_40_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( A1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "CATPAICOD_"+sGXsfl_40_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatPaiCod_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATPAICOD_"+sGXsfl_40_idx+"Horizontalalignment", GXutil.rtrim( edtCatPaiCod_Horizontalalignment));
      web.GxWebStd.gx_hidden_field( httpContext, "CATPROVCOD_"+sGXsfl_40_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatProvCod_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATPROVCOD_"+sGXsfl_40_idx+"Horizontalalignment", GXutil.rtrim( edtCatProvCod_Horizontalalignment));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel2Container.AddRow(Gridlevel2Row);
   }

   public void readRow09274( )
   {
      nGXsfl_40_idx = (int)(nGXsfl_40_idx+1) ;
      sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_40274( ) ;
      edtCatPaiCod_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATPAICOD_"+sGXsfl_40_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtCatPaiCod_Horizontalalignment = httpContext.cgiGet( "CATPAICOD_"+sGXsfl_40_idx+"Horizontalalignment") ;
      edtCatProvCod_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATPROVCOD_"+sGXsfl_40_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtCatProvCod_Horizontalalignment = httpContext.cgiGet( "CATPROVCOD_"+sGXsfl_40_idx+"Horizontalalignment") ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCatPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCatPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
      {
         GXCCtl = "CATPAICOD_" + sGXsfl_40_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatPaiCod_Internalname ;
         wbErr = true ;
         A2200CatPaiCod = (short)(0) ;
      }
      else
      {
         A2200CatPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( edtCatPaiCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCatProvCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCatProvCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
      {
         GXCCtl = "CATPROVCOD_" + sGXsfl_40_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatProvCod_Internalname ;
         wbErr = true ;
         A2201CatProvCod = (short)(0) ;
      }
      else
      {
         A2201CatProvCod = (short)(localUtil.ctol( httpContext.cgiGet( edtCatProvCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      }
      GXCCtl = "Z2200CatPaiCod_" + sGXsfl_40_idx ;
      Z2200CatPaiCod = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z2201CatProvCod_" + sGXsfl_40_idx ;
      Z2201CatProvCod = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z2202CatProvRelSec_" + sGXsfl_40_idx ;
      Z2202CatProvRelSec = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      n2202CatProvRelSec = ((0==A2202CatProvRelSec) ? true : false) ;
      GXCCtl = "Z2203CatProvRelRef_" + sGXsfl_40_idx ;
      Z2203CatProvRelRef = httpContext.cgiGet( GXCCtl) ;
      n2203CatProvRelRef = ((GXutil.strcmp("", A2203CatProvRelRef)==0) ? true : false) ;
      GXCCtl = "Z2202CatProvRelSec_" + sGXsfl_40_idx ;
      A2202CatProvRelSec = (int)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      n2202CatProvRelSec = false ;
      n2202CatProvRelSec = ((0==A2202CatProvRelSec) ? true : false) ;
      GXCCtl = "Z2203CatProvRelRef_" + sGXsfl_40_idx ;
      A2203CatProvRelRef = httpContext.cgiGet( GXCCtl) ;
      n2203CatProvRelRef = false ;
      n2203CatProvRelRef = ((GXutil.strcmp("", A2203CatProvRelRef)==0) ? true : false) ;
      GXCCtl = "nRcdDeleted_274_" + sGXsfl_40_idx ;
      nRcdDeleted_274 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_274_" + sGXsfl_40_idx ;
      nRcdExists_274 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_274_" + sGXsfl_40_idx ;
      nIsMod_274 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void subsflControlProps_30206( )
   {
      edtCatVigencia_Internalname = "CATVIGENCIA_"+sGXsfl_30_idx ;
      edtCatBasico_Internalname = "CATBASICO_"+sGXsfl_30_idx ;
      edtCatAdicional_Internalname = "CATADICIONAL_"+sGXsfl_30_idx ;
      edtCatValorHora_Internalname = "CATVALORHORA_"+sGXsfl_30_idx ;
      edtCatAdiHora_Internalname = "CATADIHORA_"+sGXsfl_30_idx ;
      edtEscBasico_Internalname = "ESCBASICO_"+sGXsfl_30_idx ;
      edtEscAdicional_Internalname = "ESCADICIONAL_"+sGXsfl_30_idx ;
   }

   public void subsflControlProps_fel_30206( )
   {
      edtCatVigencia_Internalname = "CATVIGENCIA_"+sGXsfl_30_fel_idx ;
      edtCatBasico_Internalname = "CATBASICO_"+sGXsfl_30_fel_idx ;
      edtCatAdicional_Internalname = "CATADICIONAL_"+sGXsfl_30_fel_idx ;
      edtCatValorHora_Internalname = "CATVALORHORA_"+sGXsfl_30_fel_idx ;
      edtCatAdiHora_Internalname = "CATADIHORA_"+sGXsfl_30_fel_idx ;
      edtEscBasico_Internalname = "ESCBASICO_"+sGXsfl_30_fel_idx ;
      edtEscAdicional_Internalname = "ESCADICIONAL_"+sGXsfl_30_fel_idx ;
   }

   public void addRow09206( )
   {
      nGXsfl_30_idx = (int)(nGXsfl_30_idx+1) ;
      sGXsfl_30_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_30_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_30206( ) ;
      sendRow09206( ) ;
   }

   public void sendRow09206( )
   {
      Gridlevel1Row = GXWebRow.GetNew(context) ;
      if ( subGridlevel1_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
         {
            subGridlevel1_Linesclass = subGridlevel1_Class+"Odd" ;
         }
      }
      else if ( subGridlevel1_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(0) ;
         subGridlevel1_Backcolor = subGridlevel1_Allbackcolor ;
         if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
         {
            subGridlevel1_Linesclass = subGridlevel1_Class+"Uniform" ;
         }
      }
      else if ( subGridlevel1_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
         {
            subGridlevel1_Linesclass = subGridlevel1_Class+"Odd" ;
         }
         subGridlevel1_Backcolor = (int)(0x0) ;
      }
      else if ( subGridlevel1_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridlevel1_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_30_idx) % (2))) == 0 )
         {
            subGridlevel1_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
            {
               subGridlevel1_Linesclass = subGridlevel1_Class+"Even" ;
            }
         }
         else
         {
            subGridlevel1_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridlevel1_Class, "") != 0 )
            {
               subGridlevel1_Linesclass = subGridlevel1_Class+"Odd" ;
            }
         }
      }
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_206_" + sGXsfl_30_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 31,'',false,'" + sGXsfl_30_idx + "',30)\"" ;
      ROClassString = "AttributeDate" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCatVigencia_Internalname,localUtil.format(A907CatVigencia, "99/99/9999"),localUtil.format( A907CatVigencia, "99/99/9999"),TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,31);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCatVigencia_Jsonclick,Integer.valueOf(0),"AttributeDate","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtCatVigencia_Enabled),Integer.valueOf(1),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCatBasico_Internalname,GXutil.ltrim( localUtil.ntoc( A122CatBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtCatBasico_Enabled!=0) ? localUtil.format( A122CatBasico, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A122CatBasico, "ZZ,ZZZ,ZZZ,ZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCatBasico_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(0),Integer.valueOf(edtCatBasico_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCatAdicional_Internalname,GXutil.ltrim( localUtil.ntoc( A908CatAdicional, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtCatAdicional_Enabled!=0) ? localUtil.format( A908CatAdicional, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A908CatAdicional, "ZZ,ZZZ,ZZZ,ZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCatAdicional_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(0),Integer.valueOf(edtCatAdicional_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCatValorHora_Internalname,GXutil.ltrim( localUtil.ntoc( A731CatValorHora, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtCatValorHora_Enabled!=0) ? localUtil.format( A731CatValorHora, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A731CatValorHora, "ZZ,ZZZ,ZZZ,ZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCatValorHora_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(0),Integer.valueOf(edtCatValorHora_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCatAdiHora_Internalname,GXutil.ltrim( localUtil.ntoc( A909CatAdiHora, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtCatAdiHora_Enabled!=0) ? localUtil.format( A909CatAdiHora, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A909CatAdiHora, "ZZ,ZZZ,ZZZ,ZZ9.99"))),"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCatAdiHora_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(0),Integer.valueOf(edtCatAdiHora_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_206_" + sGXsfl_30_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 36,'',false,'" + sGXsfl_30_idx + "',30)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEscBasico_Internalname,GXutil.ltrim( localUtil.ntoc( A1892EscBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtEscBasico_Enabled!=0) ? localUtil.format( A1892EscBasico, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1892EscBasico, "ZZ,ZZZ,ZZZ,ZZ9.99"))),TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,36);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEscBasico_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtEscBasico_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_206_" + sGXsfl_30_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 37,'',false,'" + sGXsfl_30_idx + "',30)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtEscAdicional_Internalname,GXutil.ltrim( localUtil.ntoc( A1893EscAdicional, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtEscAdicional_Enabled!=0) ? localUtil.format( A1893EscAdicional, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A1893EscAdicional, "ZZ,ZZZ,ZZZ,ZZ9.99"))),TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,37);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtEscAdicional_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtEscAdicional_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(17),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(30),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Importes","right",Boolean.valueOf(false),""});
      httpContext.ajax_sending_grid_row(Gridlevel1Row);
      send_integrity_lvl_hashes09206( ) ;
      GXCCtl = "Z907CatVigencia_" + sGXsfl_30_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, localUtil.dtoc( Z907CatVigencia, 0, "/"));
      GXCCtl = "Z122CatBasico_" + sGXsfl_30_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z122CatBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z731CatValorHora_" + sGXsfl_30_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z731CatValorHora, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z908CatAdicional_" + sGXsfl_30_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z908CatAdicional, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z909CatAdiHora_" + sGXsfl_30_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z909CatAdiHora, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1892EscBasico_" + sGXsfl_30_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1892EscBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z1893EscAdicional_" + sGXsfl_30_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z1893EscAdicional, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdDeleted_206_" + sGXsfl_30_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_206_" + sGXsfl_30_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_206_" + sGXsfl_30_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_206, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMODE_" + sGXsfl_30_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vCLICOD_" + sGXsfl_30_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vCLIPAICONVE_" + sGXsfl_30_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV29CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vCLICONVENIO_" + sGXsfl_30_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV30CliConvenio));
      GXCCtl = "vCATCODIGO_" + sGXsfl_30_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV9CatCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "CATVIGENCIA_"+sGXsfl_30_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatVigencia_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATBASICO_"+sGXsfl_30_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatBasico_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATADICIONAL_"+sGXsfl_30_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatAdicional_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATVALORHORA_"+sGXsfl_30_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatValorHora_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATADIHORA_"+sGXsfl_30_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCatAdiHora_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "ESCBASICO_"+sGXsfl_30_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEscBasico_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "ESCADICIONAL_"+sGXsfl_30_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtEscAdicional_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel1Container.AddRow(Gridlevel1Row);
   }

   public void readRow09206( )
   {
      nGXsfl_30_idx = (int)(nGXsfl_30_idx+1) ;
      sGXsfl_30_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_30_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_30206( ) ;
      edtCatVigencia_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATVIGENCIA_"+sGXsfl_30_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtCatBasico_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATBASICO_"+sGXsfl_30_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtCatAdicional_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATADICIONAL_"+sGXsfl_30_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtCatValorHora_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATVALORHORA_"+sGXsfl_30_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtCatAdiHora_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CATADIHORA_"+sGXsfl_30_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtEscBasico_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ESCBASICO_"+sGXsfl_30_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtEscAdicional_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "ESCADICIONAL_"+sGXsfl_30_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      if ( localUtil.vcdate( httpContext.cgiGet( edtCatVigencia_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
      {
         GXCCtl = "CATVIGENCIA_" + sGXsfl_30_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatVigencia_Internalname ;
         wbErr = true ;
         A907CatVigencia = GXutil.nullDate() ;
      }
      else
      {
         A907CatVigencia = localUtil.ctod( httpContext.cgiGet( edtCatVigencia_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
      }
      A122CatBasico = localUtil.ctond( httpContext.cgiGet( edtCatBasico_Internalname)) ;
      n122CatBasico = false ;
      A908CatAdicional = localUtil.ctond( httpContext.cgiGet( edtCatAdicional_Internalname)) ;
      n908CatAdicional = false ;
      A731CatValorHora = localUtil.ctond( httpContext.cgiGet( edtCatValorHora_Internalname)) ;
      n731CatValorHora = false ;
      A909CatAdiHora = localUtil.ctond( httpContext.cgiGet( edtCatAdiHora_Internalname)) ;
      n909CatAdiHora = false ;
      if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEscBasico_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEscBasico_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
      {
         GXCCtl = "ESCBASICO_" + sGXsfl_30_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtEscBasico_Internalname ;
         wbErr = true ;
         A1892EscBasico = DecimalUtil.ZERO ;
      }
      else
      {
         A1892EscBasico = localUtil.ctond( httpContext.cgiGet( edtEscBasico_Internalname)) ;
      }
      if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEscAdicional_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtEscAdicional_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
      {
         GXCCtl = "ESCADICIONAL_" + sGXsfl_30_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtEscAdicional_Internalname ;
         wbErr = true ;
         A1893EscAdicional = DecimalUtil.ZERO ;
      }
      else
      {
         A1893EscAdicional = localUtil.ctond( httpContext.cgiGet( edtEscAdicional_Internalname)) ;
      }
      GXCCtl = "Z907CatVigencia_" + sGXsfl_30_idx ;
      Z907CatVigencia = localUtil.ctod( httpContext.cgiGet( GXCCtl), 0) ;
      GXCCtl = "Z122CatBasico_" + sGXsfl_30_idx ;
      Z122CatBasico = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      n122CatBasico = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A122CatBasico)==0) ? true : false) ;
      GXCCtl = "Z731CatValorHora_" + sGXsfl_30_idx ;
      Z731CatValorHora = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      n731CatValorHora = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A731CatValorHora)==0) ? true : false) ;
      GXCCtl = "Z908CatAdicional_" + sGXsfl_30_idx ;
      Z908CatAdicional = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      n908CatAdicional = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A908CatAdicional)==0) ? true : false) ;
      GXCCtl = "Z909CatAdiHora_" + sGXsfl_30_idx ;
      Z909CatAdiHora = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      n909CatAdiHora = ((DecimalUtil.compareTo(DecimalUtil.ZERO, A909CatAdiHora)==0) ? true : false) ;
      GXCCtl = "Z1892EscBasico_" + sGXsfl_30_idx ;
      Z1892EscBasico = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z1893EscAdicional_" + sGXsfl_30_idx ;
      Z1893EscAdicional = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "nRcdDeleted_206_" + sGXsfl_30_idx ;
      nRcdDeleted_206 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_206_" + sGXsfl_30_idx ;
      nRcdExists_206 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_206_" + sGXsfl_30_idx ;
      nIsMod_206 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtCatProvCod_Enabled = edtCatProvCod_Enabled ;
      defedtCatPaiCod_Enabled = edtCatPaiCod_Enabled ;
      defedtCatAdiHora_Enabled = edtCatAdiHora_Enabled ;
      defedtCatValorHora_Enabled = edtCatValorHora_Enabled ;
      defedtCatAdicional_Enabled = edtCatAdicional_Enabled ;
      defedtCatBasico_Enabled = edtCatBasico_Enabled ;
      defedtCatVigencia_Enabled = edtCatVigencia_Enabled ;
   }

   public void confirmValues090( )
   {
      nGXsfl_30_idx = 0 ;
      sGXsfl_30_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_30_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_30206( ) ;
      while ( nGXsfl_30_idx < nRC_GXsfl_30 )
      {
         nGXsfl_30_idx = (int)(nGXsfl_30_idx+1) ;
         sGXsfl_30_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_30_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_30206( ) ;
         httpContext.changePostValue( "Z907CatVigencia_"+sGXsfl_30_idx, httpContext.cgiGet( "ZT_"+"Z907CatVigencia_"+sGXsfl_30_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z907CatVigencia_"+sGXsfl_30_idx) ;
         httpContext.changePostValue( "Z122CatBasico_"+sGXsfl_30_idx, httpContext.cgiGet( "ZT_"+"Z122CatBasico_"+sGXsfl_30_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z122CatBasico_"+sGXsfl_30_idx) ;
         httpContext.changePostValue( "Z731CatValorHora_"+sGXsfl_30_idx, httpContext.cgiGet( "ZT_"+"Z731CatValorHora_"+sGXsfl_30_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z731CatValorHora_"+sGXsfl_30_idx) ;
         httpContext.changePostValue( "Z908CatAdicional_"+sGXsfl_30_idx, httpContext.cgiGet( "ZT_"+"Z908CatAdicional_"+sGXsfl_30_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z908CatAdicional_"+sGXsfl_30_idx) ;
         httpContext.changePostValue( "Z909CatAdiHora_"+sGXsfl_30_idx, httpContext.cgiGet( "ZT_"+"Z909CatAdiHora_"+sGXsfl_30_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z909CatAdiHora_"+sGXsfl_30_idx) ;
         httpContext.changePostValue( "Z1892EscBasico_"+sGXsfl_30_idx, httpContext.cgiGet( "ZT_"+"Z1892EscBasico_"+sGXsfl_30_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1892EscBasico_"+sGXsfl_30_idx) ;
         httpContext.changePostValue( "Z1893EscAdicional_"+sGXsfl_30_idx, httpContext.cgiGet( "ZT_"+"Z1893EscAdicional_"+sGXsfl_30_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z1893EscAdicional_"+sGXsfl_30_idx) ;
      }
      nGXsfl_40_idx = 0 ;
      sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_40274( ) ;
      while ( nGXsfl_40_idx < nRC_GXsfl_40 )
      {
         nGXsfl_40_idx = (int)(nGXsfl_40_idx+1) ;
         sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_40274( ) ;
         httpContext.changePostValue( "Z2200CatPaiCod_"+sGXsfl_40_idx, httpContext.cgiGet( "ZT_"+"Z2200CatPaiCod_"+sGXsfl_40_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2200CatPaiCod_"+sGXsfl_40_idx) ;
         httpContext.changePostValue( "Z2201CatProvCod_"+sGXsfl_40_idx, httpContext.cgiGet( "ZT_"+"Z2201CatProvCod_"+sGXsfl_40_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2201CatProvCod_"+sGXsfl_40_idx) ;
         httpContext.changePostValue( "Z2202CatProvRelSec_"+sGXsfl_40_idx, httpContext.cgiGet( "ZT_"+"Z2202CatProvRelSec_"+sGXsfl_40_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2202CatProvRelSec_"+sGXsfl_40_idx) ;
         httpContext.changePostValue( "Z2203CatProvRelRef_"+sGXsfl_40_idx, httpContext.cgiGet( "ZT_"+"Z2203CatProvRelRef_"+sGXsfl_40_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2203CatProvRelRef_"+sGXsfl_40_idx) ;
      }
   }

   public void renderHtmlHeaders( )
   {
      web.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
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
      MasterPageObj.master_styles();
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
      httpContext.AddJavascriptSource("calendar.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-setup.js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("calendar-"+GXutil.substring( httpContext.getLanguageProperty( "culture"), 1, 2)+".js", "?"+httpContext.getBuildNumber( 214800), false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      bodyStyle += "-moz-opacity:0;opacity:0;" ;
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.categoria", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV29CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV30CliConvenio)),GXutil.URLEncode(GXutil.rtrim(AV9CatCodigo))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","CatCodigo"}) +"\">") ;
      web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"Categoria");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("CatDescripSinAc", GXutil.rtrim( localUtil.format( A676CatDescripSinAc, "")));
      forbiddenHiddens.add("CatClase", localUtil.format( DecimalUtil.doubleToDec(A1838CatClase), "9"));
      forbiddenHiddens.add("CatTipoTarifa", GXutil.rtrim( localUtil.format( A2416CatTipoTarifa, "")));
      forbiddenHiddens.add("CatFrecAct", localUtil.format( DecimalUtil.doubleToDec(A1914CatFrecAct), "Z9"));
      forbiddenHiddens.add("CatRelSec", localUtil.format( DecimalUtil.doubleToDec(A1894CatRelSec), "ZZZ9"));
      forbiddenHiddens.add("CatRelRef", GXutil.rtrim( localUtil.format( A2040CatRelRef, "")));
      forbiddenHiddens.add("CatAfipCod", GXutil.rtrim( localUtil.format( A2198CatAfipCod, "")));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("categoria:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1564CliPaiConve", GXutil.ltrim( localUtil.ntoc( Z1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1565CliConvenio", GXutil.rtrim( Z1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "Z8CatCodigo", GXutil.rtrim( Z8CatCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z123CatDescrip", Z123CatDescrip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z676CatDescripSinAc", Z676CatDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1838CatClase", GXutil.ltrim( localUtil.ntoc( Z1838CatClase, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2416CatTipoTarifa", GXutil.rtrim( Z2416CatTipoTarifa));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1914CatFrecAct", GXutil.ltrim( localUtil.ntoc( Z1914CatFrecAct, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1894CatRelSec", GXutil.ltrim( localUtil.ntoc( Z1894CatRelSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2040CatRelRef", Z2040CatRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2198CatAfipCod", GXutil.rtrim( Z2198CatAfipCod));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_40", GXutil.ltrim( localUtil.ntoc( nGXsfl_40_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_30", GXutil.ltrim( localUtil.ntoc( nGXsfl_30_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vDDO_TITLESETTINGSICONS", AV23DDO_TitleSettingsIcons);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vDDO_TITLESETTINGSICONS", AV23DDO_TitleSettingsIcons);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCATPAICOD_DATA", AV34CatPaiCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCATPAICOD_DATA", AV34CatPaiCod_Data);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vCATPROVCOD_DATA", AV35CatProvCod_Data);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vCATPROVCOD_DATA", AV35CatProvCod_Data);
      }
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLIPAICONVE", GXutil.ltrim( localUtil.ntoc( AV29CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLIPAICONVE", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV29CliPaiConve), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLIPAICONVE", GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICONVENIO", GXutil.rtrim( AV30CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICONVENIO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV30CliConvenio, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV8EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vGXBSCREEN", GXutil.ltrim( localUtil.ntoc( Gx_BScreen, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CLICONVENIO", GXutil.rtrim( A1565CliConvenio));
      web.GxWebStd.gx_hidden_field( httpContext, "vCATCODIGO", GXutil.rtrim( AV9CatCodigo));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCATCODIGO", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV9CatCodigo, ""))));
      web.GxWebStd.gx_hidden_field( httpContext, "CATDESCRIPSINAC", A676CatDescripSinAc);
      web.GxWebStd.gx_hidden_field( httpContext, "CATCLASE", GXutil.ltrim( localUtil.ntoc( A1838CatClase, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATTIPOTARIFA", GXutil.rtrim( A2416CatTipoTarifa));
      web.GxWebStd.gx_hidden_field( httpContext, "CATFRECACT", GXutil.ltrim( localUtil.ntoc( A1914CatFrecAct, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATRELSEC", GXutil.ltrim( localUtil.ntoc( A1894CatRelSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATRELREF", A2040CatRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "CATOLD", A2041CatOld);
      web.GxWebStd.gx_hidden_field( httpContext, "CATAFIPCOD", GXutil.rtrim( A2198CatAfipCod));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV38Pgmname));
      web.GxWebStd.gx_hidden_field( httpContext, "CATPROVRELSEC", GXutil.ltrim( localUtil.ntoc( A2202CatProvRelSec, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "CATPROVRELREF", A2203CatProvRelRef);
      web.GxWebStd.gx_hidden_field( httpContext, "CATPROVOLD", A2204CatProvOld);
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Objectcall", GXutil.rtrim( Dvpanel_tableattributes_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Enabled", GXutil.booltostr( Dvpanel_tableattributes_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Width", GXutil.rtrim( Dvpanel_tableattributes_Width));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autowidth", GXutil.booltostr( Dvpanel_tableattributes_Autowidth));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoheight", GXutil.booltostr( Dvpanel_tableattributes_Autoheight));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Cls", GXutil.rtrim( Dvpanel_tableattributes_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Title", GXutil.rtrim( Dvpanel_tableattributes_Title));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsible", GXutil.booltostr( Dvpanel_tableattributes_Collapsible));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Collapsed", GXutil.booltostr( Dvpanel_tableattributes_Collapsed));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Showcollapseicon", GXutil.booltostr( Dvpanel_tableattributes_Showcollapseicon));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Iconposition", GXutil.rtrim( Dvpanel_tableattributes_Iconposition));
      web.GxWebStd.gx_hidden_field( httpContext, "DVPANEL_TABLEATTRIBUTES_Autoscroll", GXutil.booltostr( Dvpanel_tableattributes_Autoscroll));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPAICOD_Objectcall", GXutil.rtrim( Combo_catpaicod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPAICOD_Cls", GXutil.rtrim( Combo_catpaicod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPAICOD_Enabled", GXutil.booltostr( Combo_catpaicod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPAICOD_Titlecontrolidtoreplace", GXutil.rtrim( Combo_catpaicod_Titlecontrolidtoreplace));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPAICOD_Isgriditem", GXutil.booltostr( Combo_catpaicod_Isgriditem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPAICOD_Hasdescription", GXutil.booltostr( Combo_catpaicod_Hasdescription));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPAICOD_Datalistproc", GXutil.rtrim( Combo_catpaicod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPAICOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_catpaicod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPAICOD_Emptyitem", GXutil.booltostr( Combo_catpaicod_Emptyitem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPROVCOD_Objectcall", GXutil.rtrim( Combo_catprovcod_Objectcall));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPROVCOD_Cls", GXutil.rtrim( Combo_catprovcod_Cls));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPROVCOD_Enabled", GXutil.booltostr( Combo_catprovcod_Enabled));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPROVCOD_Titlecontrolidtoreplace", GXutil.rtrim( Combo_catprovcod_Titlecontrolidtoreplace));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPROVCOD_Isgriditem", GXutil.booltostr( Combo_catprovcod_Isgriditem));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPROVCOD_Hasdescription", GXutil.booltostr( Combo_catprovcod_Hasdescription));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPROVCOD_Datalistproc", GXutil.rtrim( Combo_catprovcod_Datalistproc));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPROVCOD_Datalistprocparametersprefix", GXutil.rtrim( Combo_catprovcod_Datalistprocparametersprefix));
      web.GxWebStd.gx_hidden_field( httpContext, "COMBO_CATPROVCOD_Emptyitem", GXutil.booltostr( Combo_catprovcod_Emptyitem));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
      httpContext.SendComponentObjects();
      httpContext.SendServerCommands();
      httpContext.SendState();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      httpContext.writeTextNL( "</form>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      include_jscripts( ) ;
      httpContext.writeText( "<script type=\"text/javascript\">") ;
      httpContext.writeText( "gx.setLanguageCode(\""+httpContext.getLanguageProperty( "code")+"\");") ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         httpContext.writeText( "gx.setDateFormat(\""+httpContext.getLanguageProperty( "date_fmt")+"\");") ;
         httpContext.writeText( "gx.setTimeFormat("+httpContext.getLanguageProperty( "time_fmt")+");") ;
         httpContext.writeText( "gx.setCenturyFirstYear("+40+");") ;
         httpContext.writeText( "gx.setDecimalPoint(\""+httpContext.getLanguageProperty( "decimal_point")+"\");") ;
         httpContext.writeText( "gx.setThousandSeparator(\""+httpContext.getLanguageProperty( "thousand_sep")+"\");") ;
         httpContext.writeText( "gx.StorageTimeZone = "+1+";") ;
      }
      httpContext.writeText( "</script>") ;
   }

   public byte executeStartEvent( )
   {
      standaloneStartup( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      return gxajaxcallmode ;
   }

   public void renderHtmlContent( )
   {
      httpContext.writeText( "<div") ;
      web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
      httpContext.writeText( ">") ;
      draw( ) ;
      httpContext.writeText( "</div>") ;
   }

   public void dispatchEvents( )
   {
      process( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.categoria", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV29CliPaiConve,4,0)),GXutil.URLEncode(GXutil.rtrim(AV30CliConvenio)),GXutil.URLEncode(GXutil.rtrim(AV9CatCodigo))}, new String[] {"Gx_mode","CliCod","CliPaiConve","CliConvenio","CatCodigo"})  ;
   }

   public String getPgmname( )
   {
      return "Categoria" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Categoria", "") ;
   }

   public void initializeNonKey09205( )
   {
      A123CatDescrip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A123CatDescrip", A123CatDescrip);
      A676CatDescripSinAc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A676CatDescripSinAc", A676CatDescripSinAc);
      A1838CatClase = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1838CatClase", GXutil.str( A1838CatClase, 1, 0));
      A2416CatTipoTarifa = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2416CatTipoTarifa", A2416CatTipoTarifa);
      A1914CatFrecAct = (byte)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1914CatFrecAct", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1914CatFrecAct), 2, 0));
      A1894CatRelSec = (short)(0) ;
      n1894CatRelSec = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1894CatRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1894CatRelSec), 4, 0));
      A2040CatRelRef = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2040CatRelRef", A2040CatRelRef);
      A2041CatOld = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2041CatOld", A2041CatOld);
      A2198CatAfipCod = "" ;
      n2198CatAfipCod = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2198CatAfipCod", A2198CatAfipCod);
      Z123CatDescrip = "" ;
      Z676CatDescripSinAc = "" ;
      Z1838CatClase = (byte)(0) ;
      Z2416CatTipoTarifa = "" ;
      Z1914CatFrecAct = (byte)(0) ;
      Z1894CatRelSec = (short)(0) ;
      Z2040CatRelRef = "" ;
      Z2198CatAfipCod = "" ;
   }

   public void initAll09205( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1564CliPaiConve = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      A1565CliConvenio = new web.getconveniodefault(remoteHandle, context).executeUdp( AV7CliCod, AV8EmpCod, "") ;
      httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      A8CatCodigo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A8CatCodigo", A8CatCodigo);
      initializeNonKey09205( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey09274( )
   {
      A2202CatProvRelSec = 0 ;
      n2202CatProvRelSec = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2202CatProvRelSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2202CatProvRelSec), 6, 0));
      A2203CatProvRelRef = "" ;
      n2203CatProvRelRef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2203CatProvRelRef", A2203CatProvRelRef);
      A2204CatProvOld = "" ;
      n2204CatProvOld = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2204CatProvOld", A2204CatProvOld);
      Z2202CatProvRelSec = 0 ;
      Z2203CatProvRelRef = "" ;
   }

   public void initAll09274( )
   {
      A2200CatPaiCod = (short)(0) ;
      A2201CatProvCod = (short)(0) ;
      initializeNonKey09274( ) ;
   }

   public void standaloneModalInsert09274( )
   {
   }

   public void initializeNonKey09206( )
   {
      A122CatBasico = DecimalUtil.ZERO ;
      n122CatBasico = false ;
      A731CatValorHora = DecimalUtil.ZERO ;
      n731CatValorHora = false ;
      A908CatAdicional = DecimalUtil.ZERO ;
      n908CatAdicional = false ;
      A909CatAdiHora = DecimalUtil.ZERO ;
      n909CatAdiHora = false ;
      A1892EscBasico = DecimalUtil.ZERO ;
      A1893EscAdicional = DecimalUtil.ZERO ;
      Z122CatBasico = DecimalUtil.ZERO ;
      Z731CatValorHora = DecimalUtil.ZERO ;
      Z908CatAdicional = DecimalUtil.ZERO ;
      Z909CatAdiHora = DecimalUtil.ZERO ;
      Z1892EscBasico = DecimalUtil.ZERO ;
      Z1893EscAdicional = DecimalUtil.ZERO ;
   }

   public void initAll09206( )
   {
      A907CatVigencia = GXutil.nullDate() ;
      initializeNonKey09206( ) ;
   }

   public void standaloneModalInsert09206( )
   {
   }

   public void define_styles( )
   {
      httpContext.AddStyleSheetFile("calendar-system.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171325525", true, true);
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
      httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("categoria.js", "?2025171325525", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/DropDownOptions/BootstrapDropDownOptionsRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties274( )
   {
      edtCatProvCod_Enabled = defedtCatProvCod_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatProvCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatProvCod_Enabled), 5, 0), !bGXsfl_40_Refreshing);
      edtCatPaiCod_Enabled = defedtCatPaiCod_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatPaiCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatPaiCod_Enabled), 5, 0), !bGXsfl_40_Refreshing);
   }

   public void init_level_properties206( )
   {
      edtCatAdiHora_Enabled = defedtCatAdiHora_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatAdiHora_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatAdiHora_Enabled), 5, 0), !bGXsfl_30_Refreshing);
      edtCatValorHora_Enabled = defedtCatValorHora_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatValorHora_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatValorHora_Enabled), 5, 0), !bGXsfl_30_Refreshing);
      edtCatAdicional_Enabled = defedtCatAdicional_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatAdicional_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatAdicional_Enabled), 5, 0), !bGXsfl_30_Refreshing);
      edtCatBasico_Enabled = defedtCatBasico_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatBasico_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatBasico_Enabled), 5, 0), !bGXsfl_30_Refreshing);
      edtCatVigencia_Enabled = defedtCatVigencia_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtCatVigencia_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCatVigencia_Enabled), 5, 0), !bGXsfl_30_Refreshing);
   }

   public void startgridcontrol30( )
   {
      Gridlevel1Container.AddObjectProperty("GridName", "Gridlevel1");
      Gridlevel1Container.AddObjectProperty("Header", subGridlevel1_Header);
      Gridlevel1Container.AddObjectProperty("Class", "WorkWith");
      Gridlevel1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("CmpContext", "");
      Gridlevel1Container.AddObjectProperty("InMasterPage", "false");
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", localUtil.format(A907CatVigencia, "99/99/9999"));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCatVigencia_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A122CatBasico, (byte)(17), (byte)(2), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCatBasico_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A908CatAdicional, (byte)(17), (byte)(2), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCatAdicional_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A731CatValorHora, (byte)(17), (byte)(2), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCatValorHora_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A909CatAdiHora, (byte)(17), (byte)(2), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCatAdiHora_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1892EscBasico, (byte)(17), (byte)(2), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtEscBasico_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A1893EscAdicional, (byte)(17), (byte)(2), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtEscAdicional_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void startgridcontrol40( )
   {
      Gridlevel2Container.AddObjectProperty("GridName", "Gridlevel2");
      Gridlevel2Container.AddObjectProperty("Header", subGridlevel2_Header);
      Gridlevel2Container.AddObjectProperty("Class", "WorkWith");
      Gridlevel2Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridlevel2Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridlevel2Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridlevel2_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridlevel2Container.AddObjectProperty("CmpContext", "");
      Gridlevel2Container.AddObjectProperty("InMasterPage", "false");
      Gridlevel2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel2Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2200CatPaiCod, (byte)(4), (byte)(0), ".", "")));
      Gridlevel2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCatPaiCod_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel2Column.AddObjectProperty("Horizontalalignment", GXutil.rtrim( edtCatPaiCod_Horizontalalignment));
      Gridlevel2Container.AddColumnProperties(Gridlevel2Column);
      Gridlevel2Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel2Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2201CatProvCod, (byte)(4), (byte)(0), ".", "")));
      Gridlevel2Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCatProvCod_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel2Column.AddObjectProperty("Horizontalalignment", GXutil.rtrim( edtCatProvCod_Horizontalalignment));
      Gridlevel2Container.AddColumnProperties(Gridlevel2Column);
      Gridlevel2Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel2_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel2Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel2_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel2Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel2_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel2Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel2_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel2Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel2_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel2Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel2_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel2Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel2_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      edtCatCodigo_Internalname = "CATCODIGO" ;
      edtCatDescrip_Internalname = "CATDESCRIP" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      edtCatVigencia_Internalname = "CATVIGENCIA" ;
      edtCatBasico_Internalname = "CATBASICO" ;
      edtCatAdicional_Internalname = "CATADICIONAL" ;
      edtCatValorHora_Internalname = "CATVALORHORA" ;
      edtCatAdiHora_Internalname = "CATADIHORA" ;
      edtEscBasico_Internalname = "ESCBASICO" ;
      edtEscAdicional_Internalname = "ESCADICIONAL" ;
      edtCatPaiCod_Internalname = "CATPAICOD" ;
      edtCatProvCod_Internalname = "CATPROVCOD" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      bttBtntrn_delete_Internalname = "BTNTRN_DELETE" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      Combo_catpaicod_Internalname = "COMBO_CATPAICOD" ;
      Combo_catprovcod_Internalname = "COMBO_CATPROVCOD" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel1_Internalname = "GRIDLEVEL1" ;
      subGridlevel2_Internalname = "GRIDLEVEL2" ;
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("WorkWithPlusDS");
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      subGridlevel2_Allowcollapsing = (byte)(0) ;
      subGridlevel2_Allowselection = (byte)(0) ;
      subGridlevel2_Header = "" ;
      subGridlevel1_Allowcollapsing = (byte)(0) ;
      subGridlevel1_Allowselection = (byte)(0) ;
      subGridlevel1_Header = "" ;
      Combo_catprovcod_Enabled = GXutil.toBoolean( -1) ;
      Combo_catpaicod_Enabled = GXutil.toBoolean( -1) ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Categoria", "") );
      edtEscAdicional_Jsonclick = "" ;
      edtEscBasico_Jsonclick = "" ;
      edtCatAdiHora_Jsonclick = "" ;
      edtCatValorHora_Jsonclick = "" ;
      edtCatAdicional_Jsonclick = "" ;
      edtCatBasico_Jsonclick = "" ;
      edtCatVigencia_Jsonclick = "" ;
      subGridlevel1_Class = "WorkWith" ;
      subGridlevel1_Backcolorstyle = (byte)(0) ;
      edtCatProvCod_Jsonclick = "" ;
      edtCatPaiCod_Jsonclick = "" ;
      subGridlevel2_Class = "WorkWith" ;
      subGridlevel2_Backcolorstyle = (byte)(0) ;
      Combo_catprovcod_Datalistprocparametersprefix = "" ;
      Combo_catpaicod_Titlecontrolidtoreplace = "" ;
      Combo_catprovcod_Titlecontrolidtoreplace = "" ;
      Combo_catprovcod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_catprovcod_Datalistproc = "CategoriaLoadDVCombo" ;
      Combo_catprovcod_Hasdescription = GXutil.toBoolean( -1) ;
      Combo_catprovcod_Isgriditem = GXutil.toBoolean( -1) ;
      Combo_catprovcod_Cls = "ExtendedCombo" ;
      Combo_catprovcod_Caption = "" ;
      Combo_catpaicod_Emptyitem = GXutil.toBoolean( 0) ;
      Combo_catpaicod_Datalistprocparametersprefix = " \"ComboName\": \"CatPaiCod\", \"TrnMode\": \"INS\", \"IsDynamicCall\": true, \"CliCod\": 0, \"CliPaiConve\": 0, \"CliConvenio\": \"\", \"CatCodigo\": \"\"" ;
      Combo_catpaicod_Datalistproc = "CategoriaLoadDVCombo" ;
      Combo_catpaicod_Hasdescription = GXutil.toBoolean( -1) ;
      Combo_catpaicod_Isgriditem = GXutil.toBoolean( -1) ;
      Combo_catpaicod_Cls = "ExtendedCombo" ;
      Combo_catpaicod_Caption = "" ;
      bttBtntrn_delete_Enabled = 0 ;
      bttBtntrn_delete_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtCatProvCod_Enabled = 1 ;
      edtCatPaiCod_Enabled = 1 ;
      edtEscAdicional_Enabled = 1 ;
      edtEscBasico_Enabled = 1 ;
      edtCatAdiHora_Enabled = 0 ;
      edtCatValorHora_Enabled = 0 ;
      edtCatAdicional_Enabled = 0 ;
      edtCatBasico_Enabled = 0 ;
      edtCatVigencia_Enabled = 1 ;
      edtCatDescrip_Enabled = 1 ;
      edtCatCodigo_Jsonclick = "" ;
      edtCatCodigo_Enabled = 1 ;
      Dvpanel_tableattributes_Autoscroll = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Iconposition = "Right" ;
      Dvpanel_tableattributes_Showcollapseicon = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsed = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Collapsible = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Title = httpContext.getMessage( "WWP_TemplateDataPanelTitle", "") ;
      Dvpanel_tableattributes_Cls = "PanelCard_GrayTitle" ;
      Dvpanel_tableattributes_Autoheight = GXutil.toBoolean( -1) ;
      Dvpanel_tableattributes_Autowidth = GXutil.toBoolean( 0) ;
      Dvpanel_tableattributes_Width = "100%" ;
      divLayoutmaintable_Class = "Table" ;
      edtCatPaiCod_Horizontalalignment = "right" ;
      edtCatProvCod_Horizontalalignment = "right" ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gx2asaclipaiconve09205( short AV29CliPaiConve ,
                                       int AV7CliCod )
   {
      if ( ! (0==AV29CliPaiConve) )
      {
         A1564CliPaiConve = AV29CliPaiConve ;
         httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int10 = A1564CliPaiConve ;
            GXv_int11[0] = GXt_int10 ;
            new web.clientegetpais(remoteHandle, context).execute( AV7CliCod, GXv_int11) ;
            categoria_impl.this.GXt_int10 = GXv_int11[0] ;
            A1564CliPaiConve = GXt_int10 ;
            httpContext.ajax_rsp_assign_attri("", false, "A1564CliPaiConve", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1564CliPaiConve), 4, 0));
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A1564CliPaiConve, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx3asacliconvenio09205( String AV30CliConvenio ,
                                       int AV7CliCod ,
                                       short AV8EmpCod ,
                                       byte Gx_BScreen )
   {
      if ( ! (GXutil.strcmp("", AV30CliConvenio)==0) )
      {
         A1565CliConvenio = AV30CliConvenio ;
         httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
      }
      else
      {
         if ( isIns( )  && (GXutil.strcmp("", A1565CliConvenio)==0) && ( Gx_BScreen == 0 ) )
         {
            GXt_char1 = A1565CliConvenio ;
            GXv_char2[0] = GXt_char1 ;
            new web.getconveniodefault(remoteHandle, context).execute( AV7CliCod, AV8EmpCod, "", GXv_char2) ;
            categoria_impl.this.GXt_char1 = GXv_char2[0] ;
            A1565CliConvenio = GXt_char1 ;
            httpContext.ajax_rsp_assign_attri("", false, "A1565CliConvenio", A1565CliConvenio);
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.rtrim( A1565CliConvenio))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxnrgridlevel2_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_40274( ) ;
      while ( nGXsfl_40_idx <= nRC_GXsfl_40 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal09274( ) ;
         standaloneModal09274( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow09274( ) ;
         nGXsfl_40_idx = (int)(nGXsfl_40_idx+1) ;
         sGXsfl_40_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_40_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_40274( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel2Container)) ;
      /* End function gxnrGridlevel2_newrow */
   }

   public void gxnrgridlevel1_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_30206( ) ;
      while ( nGXsfl_30_idx <= nRC_GXsfl_30 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal09206( ) ;
         standaloneModal09206( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow09206( ) ;
         nGXsfl_30_idx = (int)(nGXsfl_30_idx+1) ;
         sGXsfl_30_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_30_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_30206( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel1Container)) ;
      /* End function gxnrGridlevel1_newrow */
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public void valid_Catprovcod( )
   {
      /* Using cursor T000932 */
      pr_default.execute(30, new Object[] {Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod)});
      if ( (pr_default.getStatus(30) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Provincia Categoria", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "CATPROVCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCatPaiCod_Internalname ;
      }
      pr_default.close(30);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV29CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV30CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV9CatCodigo',fld:'vCATCODIGO',pic:'',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV29CliPaiConve',fld:'vCLIPAICONVE',pic:'ZZZ9',hsh:true},{av:'AV30CliConvenio',fld:'vCLICONVENIO',pic:'',hsh:true},{av:'AV9CatCodigo',fld:'vCATCODIGO',pic:'',hsh:true},{av:'A676CatDescripSinAc',fld:'CATDESCRIPSINAC',pic:''},{av:'A1838CatClase',fld:'CATCLASE',pic:'9'},{av:'A2416CatTipoTarifa',fld:'CATTIPOTARIFA',pic:''},{av:'A1914CatFrecAct',fld:'CATFRECACT',pic:'Z9'},{av:'A1894CatRelSec',fld:'CATRELSEC',pic:'ZZZ9'},{av:'A2040CatRelRef',fld:'CATRELREF',pic:''},{av:'A2198CatAfipCod',fld:'CATAFIPCOD',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12092',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_CATCODIGO","{handler:'valid_Catcodigo',iparms:[]");
      setEventMetadata("VALID_CATCODIGO",",oparms:[]}");
      setEventMetadata("VALID_CATDESCRIP","{handler:'valid_Catdescrip',iparms:[]");
      setEventMetadata("VALID_CATDESCRIP",",oparms:[]}");
      setEventMetadata("VALID_CATVIGENCIA","{handler:'valid_Catvigencia',iparms:[]");
      setEventMetadata("VALID_CATVIGENCIA",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Escadicional',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
      setEventMetadata("VALID_CATPAICOD","{handler:'valid_Catpaicod',iparms:[]");
      setEventMetadata("VALID_CATPAICOD",",oparms:[]}");
      setEventMetadata("VALID_CATPROVCOD","{handler:'valid_Catprovcod',iparms:[{av:'A2200CatPaiCod',fld:'CATPAICOD',pic:'ZZZ9'},{av:'A2201CatProvCod',fld:'CATPROVCOD',pic:'ZZZ9'}]");
      setEventMetadata("VALID_CATPROVCOD",",oparms:[]}");
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
      return "categoria_Execute";
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
      pr_default.close(30);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      wcpOAV30CliConvenio = "" ;
      wcpOAV9CatCodigo = "" ;
      Z1565CliConvenio = "" ;
      Z8CatCodigo = "" ;
      Z123CatDescrip = "" ;
      Z676CatDescripSinAc = "" ;
      Z2416CatTipoTarifa = "" ;
      Z2040CatRelRef = "" ;
      Z2198CatAfipCod = "" ;
      Z2203CatProvRelRef = "" ;
      Z907CatVigencia = GXutil.nullDate() ;
      Z122CatBasico = DecimalUtil.ZERO ;
      Z731CatValorHora = DecimalUtil.ZERO ;
      Z908CatAdicional = DecimalUtil.ZERO ;
      Z909CatAdiHora = DecimalUtil.ZERO ;
      Z1892EscBasico = DecimalUtil.ZERO ;
      Z1893EscAdicional = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV30CliConvenio = "" ;
      Gx_mode = "" ;
      AV9CatCodigo = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A8CatCodigo = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A123CatDescrip = "" ;
      Gridlevel1Container = new com.genexus.webpanels.GXWebGrid(context);
      sMode206 = "" ;
      Gridlevel2Container = new com.genexus.webpanels.GXWebGrid(context);
      sMode274 = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      bttBtntrn_delete_Jsonclick = "" ;
      ucCombo_catpaicod = new com.genexus.webpanels.GXUserControl();
      AV23DDO_TitleSettingsIcons = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      AV34CatPaiCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      ucCombo_catprovcod = new com.genexus.webpanels.GXUserControl();
      AV35CatProvCod_Data = new GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item>(web.wwpbaseobjects.SdtDVB_SDTComboData_Item.class, "Item", "", remoteHandle);
      A2198CatAfipCod = "" ;
      A676CatDescripSinAc = "" ;
      A2416CatTipoTarifa = "" ;
      A2040CatRelRef = "" ;
      A1565CliConvenio = "" ;
      A2041CatOld = "" ;
      AV38Pgmname = "" ;
      A2203CatProvRelRef = "" ;
      A2204CatProvOld = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      Combo_catpaicod_Objectcall = "" ;
      Combo_catpaicod_Class = "" ;
      Combo_catpaicod_Icontype = "" ;
      Combo_catpaicod_Icon = "" ;
      Combo_catpaicod_Tooltip = "" ;
      Combo_catpaicod_Selectedvalue_set = "" ;
      Combo_catpaicod_Selectedvalue_get = "" ;
      Combo_catpaicod_Selectedtext_set = "" ;
      Combo_catpaicod_Selectedtext_get = "" ;
      Combo_catpaicod_Gamoauthtoken = "" ;
      Combo_catpaicod_Ddointernalname = "" ;
      Combo_catpaicod_Titlecontrolalign = "" ;
      Combo_catpaicod_Dropdownoptionstype = "" ;
      Combo_catpaicod_Datalisttype = "" ;
      Combo_catpaicod_Datalistfixedvalues = "" ;
      Combo_catpaicod_Remoteservicesparameters = "" ;
      Combo_catpaicod_Htmltemplate = "" ;
      Combo_catpaicod_Multiplevaluestype = "" ;
      Combo_catpaicod_Loadingdata = "" ;
      Combo_catpaicod_Noresultsfound = "" ;
      Combo_catpaicod_Emptyitemtext = "" ;
      Combo_catpaicod_Onlyselectedvalues = "" ;
      Combo_catpaicod_Selectalltext = "" ;
      Combo_catpaicod_Multiplevaluesseparator = "" ;
      Combo_catpaicod_Addnewoptiontext = "" ;
      Combo_catprovcod_Objectcall = "" ;
      Combo_catprovcod_Class = "" ;
      Combo_catprovcod_Icontype = "" ;
      Combo_catprovcod_Icon = "" ;
      Combo_catprovcod_Tooltip = "" ;
      Combo_catprovcod_Selectedvalue_set = "" ;
      Combo_catprovcod_Selectedvalue_get = "" ;
      Combo_catprovcod_Selectedtext_set = "" ;
      Combo_catprovcod_Selectedtext_get = "" ;
      Combo_catprovcod_Gamoauthtoken = "" ;
      Combo_catprovcod_Ddointernalname = "" ;
      Combo_catprovcod_Titlecontrolalign = "" ;
      Combo_catprovcod_Dropdownoptionstype = "" ;
      Combo_catprovcod_Datalisttype = "" ;
      Combo_catprovcod_Datalistfixedvalues = "" ;
      Combo_catprovcod_Remoteservicesparameters = "" ;
      Combo_catprovcod_Htmltemplate = "" ;
      Combo_catprovcod_Multiplevaluestype = "" ;
      Combo_catprovcod_Loadingdata = "" ;
      Combo_catprovcod_Noresultsfound = "" ;
      Combo_catprovcod_Emptyitemtext = "" ;
      Combo_catprovcod_Onlyselectedvalues = "" ;
      Combo_catprovcod_Selectalltext = "" ;
      Combo_catprovcod_Multiplevaluesseparator = "" ;
      Combo_catprovcod_Addnewoptiontext = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode205 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A907CatVigencia = GXutil.nullDate() ;
      A122CatBasico = DecimalUtil.ZERO ;
      A908CatAdicional = DecimalUtil.ZERO ;
      A731CatValorHora = DecimalUtil.ZERO ;
      A909CatAdiHora = DecimalUtil.ZERO ;
      A1892EscBasico = DecimalUtil.ZERO ;
      A1893EscAdicional = DecimalUtil.ZERO ;
      AV10WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext3 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons(remoteHandle, context);
      GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5 = new web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons[1] ;
      GXv_boolean7 = new boolean[1] ;
      AV11TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV12WebSession = httpContext.getWebSession();
      GXv_int9 = new int[1] ;
      AV17SinCod = new GXSimpleCollection<String>(String.class, "internal", "");
      GXt_objcol_char12 = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char13 = new GXSimpleCollection[1] ;
      Z2041CatOld = "" ;
      T00099_A3CliCod = new int[1] ;
      T000910_A8CatCodigo = new String[] {""} ;
      T000910_A123CatDescrip = new String[] {""} ;
      T000910_A676CatDescripSinAc = new String[] {""} ;
      T000910_A1838CatClase = new byte[1] ;
      T000910_A2416CatTipoTarifa = new String[] {""} ;
      T000910_A1914CatFrecAct = new byte[1] ;
      T000910_A1894CatRelSec = new short[1] ;
      T000910_n1894CatRelSec = new boolean[] {false} ;
      T000910_A2040CatRelRef = new String[] {""} ;
      T000910_A2041CatOld = new String[] {""} ;
      T000910_A2198CatAfipCod = new String[] {""} ;
      T000910_n2198CatAfipCod = new boolean[] {false} ;
      T000910_A3CliCod = new int[1] ;
      T000910_A1564CliPaiConve = new short[1] ;
      T000910_A1565CliConvenio = new String[] {""} ;
      T000911_A3CliCod = new int[1] ;
      T000911_A1564CliPaiConve = new short[1] ;
      T000911_A1565CliConvenio = new String[] {""} ;
      T000911_A8CatCodigo = new String[] {""} ;
      T00098_A8CatCodigo = new String[] {""} ;
      T00098_A123CatDescrip = new String[] {""} ;
      T00098_A676CatDescripSinAc = new String[] {""} ;
      T00098_A1838CatClase = new byte[1] ;
      T00098_A2416CatTipoTarifa = new String[] {""} ;
      T00098_A1914CatFrecAct = new byte[1] ;
      T00098_A1894CatRelSec = new short[1] ;
      T00098_n1894CatRelSec = new boolean[] {false} ;
      T00098_A2040CatRelRef = new String[] {""} ;
      T00098_A2041CatOld = new String[] {""} ;
      T00098_A2198CatAfipCod = new String[] {""} ;
      T00098_n2198CatAfipCod = new boolean[] {false} ;
      T00098_A3CliCod = new int[1] ;
      T00098_A1564CliPaiConve = new short[1] ;
      T00098_A1565CliConvenio = new String[] {""} ;
      T000912_A3CliCod = new int[1] ;
      T000912_A1564CliPaiConve = new short[1] ;
      T000912_A1565CliConvenio = new String[] {""} ;
      T000912_A8CatCodigo = new String[] {""} ;
      T000913_A3CliCod = new int[1] ;
      T000913_A1564CliPaiConve = new short[1] ;
      T000913_A1565CliConvenio = new String[] {""} ;
      T000913_A8CatCodigo = new String[] {""} ;
      T00097_A8CatCodigo = new String[] {""} ;
      T00097_A123CatDescrip = new String[] {""} ;
      T00097_A676CatDescripSinAc = new String[] {""} ;
      T00097_A1838CatClase = new byte[1] ;
      T00097_A2416CatTipoTarifa = new String[] {""} ;
      T00097_A1914CatFrecAct = new byte[1] ;
      T00097_A1894CatRelSec = new short[1] ;
      T00097_n1894CatRelSec = new boolean[] {false} ;
      T00097_A2040CatRelRef = new String[] {""} ;
      T00097_A2041CatOld = new String[] {""} ;
      T00097_A2198CatAfipCod = new String[] {""} ;
      T00097_n2198CatAfipCod = new boolean[] {false} ;
      T00097_A3CliCod = new int[1] ;
      T00097_A1564CliPaiConve = new short[1] ;
      T00097_A1565CliConvenio = new String[] {""} ;
      T000917_A3CliCod = new int[1] ;
      T000917_A1EmpCod = new short[1] ;
      T000917_A31LiqNro = new int[1] ;
      T000917_A2142LiqPaiConve = new short[1] ;
      T000917_A2143LiqConvenio = new String[] {""} ;
      T000917_A2144LiqCatCodigo = new String[] {""} ;
      T000918_A3CliCod = new int[1] ;
      T000918_A1564CliPaiConve = new short[1] ;
      T000918_A1565CliConvenio = new String[] {""} ;
      T000918_A8CatCodigo = new String[] {""} ;
      Z2204CatProvOld = "" ;
      T000919_A3CliCod = new int[1] ;
      T000919_A1565CliConvenio = new String[] {""} ;
      T000919_A8CatCodigo = new String[] {""} ;
      T000919_A2202CatProvRelSec = new int[1] ;
      T000919_n2202CatProvRelSec = new boolean[] {false} ;
      T000919_A2203CatProvRelRef = new String[] {""} ;
      T000919_n2203CatProvRelRef = new boolean[] {false} ;
      T000919_A2204CatProvOld = new String[] {""} ;
      T000919_n2204CatProvOld = new boolean[] {false} ;
      T000919_A2200CatPaiCod = new short[1] ;
      T000919_A2201CatProvCod = new short[1] ;
      T000919_A1564CliPaiConve = new short[1] ;
      T00096_A2200CatPaiCod = new short[1] ;
      T000920_A2200CatPaiCod = new short[1] ;
      T000921_A3CliCod = new int[1] ;
      T000921_A1564CliPaiConve = new short[1] ;
      T000921_A1565CliConvenio = new String[] {""} ;
      T000921_A8CatCodigo = new String[] {""} ;
      T000921_A2200CatPaiCod = new short[1] ;
      T000921_A2201CatProvCod = new short[1] ;
      T00095_A3CliCod = new int[1] ;
      T00095_A1565CliConvenio = new String[] {""} ;
      T00095_A8CatCodigo = new String[] {""} ;
      T00095_A2202CatProvRelSec = new int[1] ;
      T00095_n2202CatProvRelSec = new boolean[] {false} ;
      T00095_A2203CatProvRelRef = new String[] {""} ;
      T00095_n2203CatProvRelRef = new boolean[] {false} ;
      T00095_A2204CatProvOld = new String[] {""} ;
      T00095_n2204CatProvOld = new boolean[] {false} ;
      T00095_A2200CatPaiCod = new short[1] ;
      T00095_A2201CatProvCod = new short[1] ;
      T00095_A1564CliPaiConve = new short[1] ;
      T00094_A3CliCod = new int[1] ;
      T00094_A1565CliConvenio = new String[] {""} ;
      T00094_A8CatCodigo = new String[] {""} ;
      T00094_A2202CatProvRelSec = new int[1] ;
      T00094_n2202CatProvRelSec = new boolean[] {false} ;
      T00094_A2203CatProvRelRef = new String[] {""} ;
      T00094_n2203CatProvRelRef = new boolean[] {false} ;
      T00094_A2204CatProvOld = new String[] {""} ;
      T00094_n2204CatProvOld = new boolean[] {false} ;
      T00094_A2200CatPaiCod = new short[1] ;
      T00094_A2201CatProvCod = new short[1] ;
      T00094_A1564CliPaiConve = new short[1] ;
      T000925_A3CliCod = new int[1] ;
      T000925_A1564CliPaiConve = new short[1] ;
      T000925_A1565CliConvenio = new String[] {""} ;
      T000925_A8CatCodigo = new String[] {""} ;
      T000925_A2200CatPaiCod = new short[1] ;
      T000925_A2201CatProvCod = new short[1] ;
      T000926_A3CliCod = new int[1] ;
      T000926_A1565CliConvenio = new String[] {""} ;
      T000926_A8CatCodigo = new String[] {""} ;
      T000926_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T000926_A122CatBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000926_n122CatBasico = new boolean[] {false} ;
      T000926_A731CatValorHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000926_n731CatValorHora = new boolean[] {false} ;
      T000926_A908CatAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000926_n908CatAdicional = new boolean[] {false} ;
      T000926_A909CatAdiHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000926_n909CatAdiHora = new boolean[] {false} ;
      T000926_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000926_A1893EscAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000926_A1564CliPaiConve = new short[1] ;
      T000927_A3CliCod = new int[1] ;
      T000927_A1564CliPaiConve = new short[1] ;
      T000927_A1565CliConvenio = new String[] {""} ;
      T000927_A8CatCodigo = new String[] {""} ;
      T000927_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T00093_A3CliCod = new int[1] ;
      T00093_A1565CliConvenio = new String[] {""} ;
      T00093_A8CatCodigo = new String[] {""} ;
      T00093_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T00093_A122CatBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00093_n122CatBasico = new boolean[] {false} ;
      T00093_A731CatValorHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00093_n731CatValorHora = new boolean[] {false} ;
      T00093_A908CatAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00093_n908CatAdicional = new boolean[] {false} ;
      T00093_A909CatAdiHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00093_n909CatAdiHora = new boolean[] {false} ;
      T00093_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00093_A1893EscAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00093_A1564CliPaiConve = new short[1] ;
      T00092_A3CliCod = new int[1] ;
      T00092_A1565CliConvenio = new String[] {""} ;
      T00092_A8CatCodigo = new String[] {""} ;
      T00092_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      T00092_A122CatBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00092_n122CatBasico = new boolean[] {false} ;
      T00092_A731CatValorHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00092_n731CatValorHora = new boolean[] {false} ;
      T00092_A908CatAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00092_n908CatAdicional = new boolean[] {false} ;
      T00092_A909CatAdiHora = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00092_n909CatAdiHora = new boolean[] {false} ;
      T00092_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00092_A1893EscAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00092_A1564CliPaiConve = new short[1] ;
      T000931_A3CliCod = new int[1] ;
      T000931_A1564CliPaiConve = new short[1] ;
      T000931_A1565CliConvenio = new String[] {""} ;
      T000931_A8CatCodigo = new String[] {""} ;
      T000931_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      Gridlevel2Row = new com.genexus.webpanels.GXWebRow();
      subGridlevel2_Linesclass = "" ;
      ROClassString = "" ;
      Gridlevel1Row = new com.genexus.webpanels.GXWebRow();
      subGridlevel1_Linesclass = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridlevel1Column = new com.genexus.webpanels.GXWebColumn();
      Gridlevel2Column = new com.genexus.webpanels.GXWebColumn();
      GXv_int11 = new short[1] ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      T000932_A2200CatPaiCod = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.categoria__default(),
         new Object[] {
             new Object[] {
            T00092_A3CliCod, T00092_A1565CliConvenio, T00092_A8CatCodigo, T00092_A907CatVigencia, T00092_A122CatBasico, T00092_n122CatBasico, T00092_A731CatValorHora, T00092_n731CatValorHora, T00092_A908CatAdicional, T00092_n908CatAdicional,
            T00092_A909CatAdiHora, T00092_n909CatAdiHora, T00092_A1892EscBasico, T00092_A1893EscAdicional, T00092_A1564CliPaiConve
            }
            , new Object[] {
            T00093_A3CliCod, T00093_A1565CliConvenio, T00093_A8CatCodigo, T00093_A907CatVigencia, T00093_A122CatBasico, T00093_n122CatBasico, T00093_A731CatValorHora, T00093_n731CatValorHora, T00093_A908CatAdicional, T00093_n908CatAdicional,
            T00093_A909CatAdiHora, T00093_n909CatAdiHora, T00093_A1892EscBasico, T00093_A1893EscAdicional, T00093_A1564CliPaiConve
            }
            , new Object[] {
            T00094_A3CliCod, T00094_A1565CliConvenio, T00094_A8CatCodigo, T00094_A2202CatProvRelSec, T00094_n2202CatProvRelSec, T00094_A2203CatProvRelRef, T00094_n2203CatProvRelRef, T00094_A2204CatProvOld, T00094_n2204CatProvOld, T00094_A2200CatPaiCod,
            T00094_A2201CatProvCod, T00094_A1564CliPaiConve
            }
            , new Object[] {
            T00095_A3CliCod, T00095_A1565CliConvenio, T00095_A8CatCodigo, T00095_A2202CatProvRelSec, T00095_n2202CatProvRelSec, T00095_A2203CatProvRelRef, T00095_n2203CatProvRelRef, T00095_A2204CatProvOld, T00095_n2204CatProvOld, T00095_A2200CatPaiCod,
            T00095_A2201CatProvCod, T00095_A1564CliPaiConve
            }
            , new Object[] {
            T00096_A2200CatPaiCod
            }
            , new Object[] {
            T00097_A8CatCodigo, T00097_A123CatDescrip, T00097_A676CatDescripSinAc, T00097_A1838CatClase, T00097_A2416CatTipoTarifa, T00097_A1914CatFrecAct, T00097_A1894CatRelSec, T00097_n1894CatRelSec, T00097_A2040CatRelRef, T00097_A2041CatOld,
            T00097_A2198CatAfipCod, T00097_n2198CatAfipCod, T00097_A3CliCod, T00097_A1564CliPaiConve, T00097_A1565CliConvenio
            }
            , new Object[] {
            T00098_A8CatCodigo, T00098_A123CatDescrip, T00098_A676CatDescripSinAc, T00098_A1838CatClase, T00098_A2416CatTipoTarifa, T00098_A1914CatFrecAct, T00098_A1894CatRelSec, T00098_n1894CatRelSec, T00098_A2040CatRelRef, T00098_A2041CatOld,
            T00098_A2198CatAfipCod, T00098_n2198CatAfipCod, T00098_A3CliCod, T00098_A1564CliPaiConve, T00098_A1565CliConvenio
            }
            , new Object[] {
            T00099_A3CliCod
            }
            , new Object[] {
            T000910_A8CatCodigo, T000910_A123CatDescrip, T000910_A676CatDescripSinAc, T000910_A1838CatClase, T000910_A2416CatTipoTarifa, T000910_A1914CatFrecAct, T000910_A1894CatRelSec, T000910_n1894CatRelSec, T000910_A2040CatRelRef, T000910_A2041CatOld,
            T000910_A2198CatAfipCod, T000910_n2198CatAfipCod, T000910_A3CliCod, T000910_A1564CliPaiConve, T000910_A1565CliConvenio
            }
            , new Object[] {
            T000911_A3CliCod, T000911_A1564CliPaiConve, T000911_A1565CliConvenio, T000911_A8CatCodigo
            }
            , new Object[] {
            T000912_A3CliCod, T000912_A1564CliPaiConve, T000912_A1565CliConvenio, T000912_A8CatCodigo
            }
            , new Object[] {
            T000913_A3CliCod, T000913_A1564CliPaiConve, T000913_A1565CliConvenio, T000913_A8CatCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000917_A3CliCod, T000917_A1EmpCod, T000917_A31LiqNro, T000917_A2142LiqPaiConve, T000917_A2143LiqConvenio, T000917_A2144LiqCatCodigo
            }
            , new Object[] {
            T000918_A3CliCod, T000918_A1564CliPaiConve, T000918_A1565CliConvenio, T000918_A8CatCodigo
            }
            , new Object[] {
            T000919_A3CliCod, T000919_A1565CliConvenio, T000919_A8CatCodigo, T000919_A2202CatProvRelSec, T000919_n2202CatProvRelSec, T000919_A2203CatProvRelRef, T000919_n2203CatProvRelRef, T000919_A2204CatProvOld, T000919_n2204CatProvOld, T000919_A2200CatPaiCod,
            T000919_A2201CatProvCod, T000919_A1564CliPaiConve
            }
            , new Object[] {
            T000920_A2200CatPaiCod
            }
            , new Object[] {
            T000921_A3CliCod, T000921_A1564CliPaiConve, T000921_A1565CliConvenio, T000921_A8CatCodigo, T000921_A2200CatPaiCod, T000921_A2201CatProvCod
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000925_A3CliCod, T000925_A1564CliPaiConve, T000925_A1565CliConvenio, T000925_A8CatCodigo, T000925_A2200CatPaiCod, T000925_A2201CatProvCod
            }
            , new Object[] {
            T000926_A3CliCod, T000926_A1565CliConvenio, T000926_A8CatCodigo, T000926_A907CatVigencia, T000926_A122CatBasico, T000926_n122CatBasico, T000926_A731CatValorHora, T000926_n731CatValorHora, T000926_A908CatAdicional, T000926_n908CatAdicional,
            T000926_A909CatAdiHora, T000926_n909CatAdiHora, T000926_A1892EscBasico, T000926_A1893EscAdicional, T000926_A1564CliPaiConve
            }
            , new Object[] {
            T000927_A3CliCod, T000927_A1564CliPaiConve, T000927_A1565CliConvenio, T000927_A8CatCodigo, T000927_A907CatVigencia
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000931_A3CliCod, T000931_A1564CliPaiConve, T000931_A1565CliConvenio, T000931_A8CatCodigo, T000931_A907CatVigencia
            }
            , new Object[] {
            T000932_A2200CatPaiCod
            }
         }
      );
      AV38Pgmname = "Categoria" ;
      Z1565CliConvenio = "" ;
      A1565CliConvenio = "" ;
   }

   private byte Z1838CatClase ;
   private byte Z1914CatFrecAct ;
   private byte GxWebError ;
   private byte Gx_BScreen ;
   private byte nKeyPressed ;
   private byte A1838CatClase ;
   private byte A1914CatFrecAct ;
   private byte subGridlevel2_Backcolorstyle ;
   private byte subGridlevel2_Backstyle ;
   private byte subGridlevel1_Backcolorstyle ;
   private byte subGridlevel1_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridlevel1_Allowselection ;
   private byte subGridlevel1_Allowhovering ;
   private byte subGridlevel1_Allowcollapsing ;
   private byte subGridlevel1_Collapsed ;
   private byte subGridlevel2_Allowselection ;
   private byte subGridlevel2_Allowhovering ;
   private byte subGridlevel2_Allowcollapsing ;
   private byte subGridlevel2_Collapsed ;
   private short wcpOAV29CliPaiConve ;
   private short Z1564CliPaiConve ;
   private short Z1894CatRelSec ;
   private short Z2200CatPaiCod ;
   private short Z2201CatProvCod ;
   private short nRcdDeleted_274 ;
   private short nRcdExists_274 ;
   private short nIsMod_274 ;
   private short nRcdDeleted_206 ;
   private short nRcdExists_206 ;
   private short nIsMod_206 ;
   private short AV29CliPaiConve ;
   private short AV8EmpCod ;
   private short A2200CatPaiCod ;
   private short A2201CatProvCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount206 ;
   private short RcdFound206 ;
   private short nBlankRcdUsr206 ;
   private short nBlankRcdCount274 ;
   private short RcdFound274 ;
   private short nBlankRcdUsr274 ;
   private short A1894CatRelSec ;
   private short A1564CliPaiConve ;
   private short RcdFound205 ;
   private short nIsDirty_205 ;
   private short nIsDirty_274 ;
   private short nIsDirty_206 ;
   private short GXt_int10 ;
   private short GXv_int11[] ;
   private int wcpOAV7CliCod ;
   private int Z3CliCod ;
   private int nRC_GXsfl_40 ;
   private int nGXsfl_40_idx=1 ;
   private int nRC_GXsfl_30 ;
   private int nGXsfl_30_idx=1 ;
   private int Z2202CatProvRelSec ;
   private int AV7CliCod ;
   private int trnEnded ;
   private int edtCatCodigo_Enabled ;
   private int edtCatDescrip_Enabled ;
   private int edtCatVigencia_Enabled ;
   private int edtCatBasico_Enabled ;
   private int edtCatAdicional_Enabled ;
   private int edtCatValorHora_Enabled ;
   private int edtCatAdiHora_Enabled ;
   private int edtEscBasico_Enabled ;
   private int edtEscAdicional_Enabled ;
   private int fRowAdded ;
   private int edtCatPaiCod_Enabled ;
   private int edtCatProvCod_Enabled ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int bttBtntrn_delete_Visible ;
   private int bttBtntrn_delete_Enabled ;
   private int A3CliCod ;
   private int A2202CatProvRelSec ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int Combo_catpaicod_Datalistupdateminimumcharacters ;
   private int Combo_catpaicod_Gxcontroltype ;
   private int Combo_catprovcod_Datalistupdateminimumcharacters ;
   private int Combo_catprovcod_Gxcontroltype ;
   private int GXt_int8 ;
   private int GXv_int9[] ;
   private int GX_JID ;
   private int subGridlevel2_Backcolor ;
   private int subGridlevel2_Allbackcolor ;
   private int subGridlevel1_Backcolor ;
   private int subGridlevel1_Allbackcolor ;
   private int defedtCatProvCod_Enabled ;
   private int defedtCatPaiCod_Enabled ;
   private int defedtCatAdiHora_Enabled ;
   private int defedtCatValorHora_Enabled ;
   private int defedtCatAdicional_Enabled ;
   private int defedtCatBasico_Enabled ;
   private int defedtCatVigencia_Enabled ;
   private int idxLst ;
   private int subGridlevel1_Selectedindex ;
   private int subGridlevel1_Selectioncolor ;
   private int subGridlevel1_Hoveringcolor ;
   private int subGridlevel2_Selectedindex ;
   private int subGridlevel2_Selectioncolor ;
   private int subGridlevel2_Hoveringcolor ;
   private long GRIDLEVEL2_nFirstRecordOnPage ;
   private long GRIDLEVEL1_nFirstRecordOnPage ;
   private java.math.BigDecimal Z122CatBasico ;
   private java.math.BigDecimal Z731CatValorHora ;
   private java.math.BigDecimal Z908CatAdicional ;
   private java.math.BigDecimal Z909CatAdiHora ;
   private java.math.BigDecimal Z1892EscBasico ;
   private java.math.BigDecimal Z1893EscAdicional ;
   private java.math.BigDecimal A122CatBasico ;
   private java.math.BigDecimal A908CatAdicional ;
   private java.math.BigDecimal A731CatValorHora ;
   private java.math.BigDecimal A909CatAdiHora ;
   private java.math.BigDecimal A1892EscBasico ;
   private java.math.BigDecimal A1893EscAdicional ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String wcpOAV30CliConvenio ;
   private String wcpOAV9CatCodigo ;
   private String Z1565CliConvenio ;
   private String Z8CatCodigo ;
   private String Z2416CatTipoTarifa ;
   private String Z2198CatAfipCod ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV30CliConvenio ;
   private String Gx_mode ;
   private String AV9CatCodigo ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCatCodigo_Internalname ;
   private String sGXsfl_30_idx="0001" ;
   private String sGXsfl_40_idx="0001" ;
   private String edtCatProvCod_Horizontalalignment ;
   private String edtCatProvCod_Internalname ;
   private String edtCatPaiCod_Horizontalalignment ;
   private String edtCatPaiCod_Internalname ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String sStyleString ;
   private String tblTablemainfix_Internalname ;
   private String divTablecontent_Internalname ;
   private String Dvpanel_tableattributes_Width ;
   private String Dvpanel_tableattributes_Cls ;
   private String Dvpanel_tableattributes_Title ;
   private String Dvpanel_tableattributes_Iconposition ;
   private String Dvpanel_tableattributes_Internalname ;
   private String divTableattributes_Internalname ;
   private String TempTags ;
   private String A8CatCodigo ;
   private String edtCatCodigo_Jsonclick ;
   private String edtCatDescrip_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String sMode206 ;
   private String edtCatVigencia_Internalname ;
   private String edtCatBasico_Internalname ;
   private String edtCatAdicional_Internalname ;
   private String edtCatValorHora_Internalname ;
   private String edtCatAdiHora_Internalname ;
   private String edtEscBasico_Internalname ;
   private String edtEscAdicional_Internalname ;
   private String subGridlevel1_Internalname ;
   private String sMode274 ;
   private String subGridlevel2_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String bttBtntrn_delete_Internalname ;
   private String bttBtntrn_delete_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String Combo_catpaicod_Caption ;
   private String Combo_catpaicod_Cls ;
   private String Combo_catpaicod_Datalistproc ;
   private String Combo_catpaicod_Datalistprocparametersprefix ;
   private String Combo_catpaicod_Internalname ;
   private String Combo_catprovcod_Caption ;
   private String Combo_catprovcod_Cls ;
   private String Combo_catprovcod_Datalistproc ;
   private String Combo_catprovcod_Internalname ;
   private String A2198CatAfipCod ;
   private String A2416CatTipoTarifa ;
   private String A1565CliConvenio ;
   private String AV38Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String Combo_catpaicod_Objectcall ;
   private String Combo_catpaicod_Class ;
   private String Combo_catpaicod_Icontype ;
   private String Combo_catpaicod_Icon ;
   private String Combo_catpaicod_Tooltip ;
   private String Combo_catpaicod_Selectedvalue_set ;
   private String Combo_catpaicod_Selectedvalue_get ;
   private String Combo_catpaicod_Selectedtext_set ;
   private String Combo_catpaicod_Selectedtext_get ;
   private String Combo_catpaicod_Gamoauthtoken ;
   private String Combo_catpaicod_Ddointernalname ;
   private String Combo_catpaicod_Titlecontrolalign ;
   private String Combo_catpaicod_Dropdownoptionstype ;
   private String Combo_catpaicod_Titlecontrolidtoreplace ;
   private String Combo_catpaicod_Datalisttype ;
   private String Combo_catpaicod_Datalistfixedvalues ;
   private String Combo_catpaicod_Remoteservicesparameters ;
   private String Combo_catpaicod_Htmltemplate ;
   private String Combo_catpaicod_Multiplevaluestype ;
   private String Combo_catpaicod_Loadingdata ;
   private String Combo_catpaicod_Noresultsfound ;
   private String Combo_catpaicod_Emptyitemtext ;
   private String Combo_catpaicod_Onlyselectedvalues ;
   private String Combo_catpaicod_Selectalltext ;
   private String Combo_catpaicod_Multiplevaluesseparator ;
   private String Combo_catpaicod_Addnewoptiontext ;
   private String Combo_catprovcod_Objectcall ;
   private String Combo_catprovcod_Class ;
   private String Combo_catprovcod_Icontype ;
   private String Combo_catprovcod_Icon ;
   private String Combo_catprovcod_Tooltip ;
   private String Combo_catprovcod_Selectedvalue_set ;
   private String Combo_catprovcod_Selectedvalue_get ;
   private String Combo_catprovcod_Selectedtext_set ;
   private String Combo_catprovcod_Selectedtext_get ;
   private String Combo_catprovcod_Gamoauthtoken ;
   private String Combo_catprovcod_Ddointernalname ;
   private String Combo_catprovcod_Titlecontrolalign ;
   private String Combo_catprovcod_Dropdownoptionstype ;
   private String Combo_catprovcod_Titlecontrolidtoreplace ;
   private String Combo_catprovcod_Datalisttype ;
   private String Combo_catprovcod_Datalistfixedvalues ;
   private String Combo_catprovcod_Datalistprocparametersprefix ;
   private String Combo_catprovcod_Remoteservicesparameters ;
   private String Combo_catprovcod_Htmltemplate ;
   private String Combo_catprovcod_Multiplevaluestype ;
   private String Combo_catprovcod_Loadingdata ;
   private String Combo_catprovcod_Noresultsfound ;
   private String Combo_catprovcod_Emptyitemtext ;
   private String Combo_catprovcod_Onlyselectedvalues ;
   private String Combo_catprovcod_Selectalltext ;
   private String Combo_catprovcod_Multiplevaluesseparator ;
   private String Combo_catprovcod_Addnewoptiontext ;
   private String hsh ;
   private String sMode205 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String sGXsfl_40_fel_idx="0001" ;
   private String subGridlevel2_Class ;
   private String subGridlevel2_Linesclass ;
   private String ROClassString ;
   private String edtCatPaiCod_Jsonclick ;
   private String edtCatProvCod_Jsonclick ;
   private String sGXsfl_30_fel_idx="0001" ;
   private String subGridlevel1_Class ;
   private String subGridlevel1_Linesclass ;
   private String edtCatVigencia_Jsonclick ;
   private String edtCatBasico_Jsonclick ;
   private String edtCatAdicional_Jsonclick ;
   private String edtCatValorHora_Jsonclick ;
   private String edtCatAdiHora_Jsonclick ;
   private String edtEscBasico_Jsonclick ;
   private String edtEscAdicional_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel1_Header ;
   private String subGridlevel2_Header ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private java.util.Date Z907CatVigencia ;
   private java.util.Date A907CatVigencia ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean bGXsfl_40_Refreshing=false ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean bGXsfl_30_Refreshing=false ;
   private boolean Combo_catpaicod_Isgriditem ;
   private boolean Combo_catpaicod_Hasdescription ;
   private boolean Combo_catpaicod_Emptyitem ;
   private boolean Combo_catprovcod_Isgriditem ;
   private boolean Combo_catprovcod_Hasdescription ;
   private boolean Combo_catprovcod_Emptyitem ;
   private boolean n1894CatRelSec ;
   private boolean n2198CatAfipCod ;
   private boolean n2202CatProvRelSec ;
   private boolean n2203CatProvRelRef ;
   private boolean n2204CatProvOld ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean Combo_catpaicod_Enabled ;
   private boolean Combo_catpaicod_Visible ;
   private boolean Combo_catpaicod_Allowmultipleselection ;
   private boolean Combo_catpaicod_Includeonlyselectedoption ;
   private boolean Combo_catpaicod_Includeselectalloption ;
   private boolean Combo_catpaicod_Includeaddnewoption ;
   private boolean Combo_catprovcod_Enabled ;
   private boolean Combo_catprovcod_Visible ;
   private boolean Combo_catprovcod_Allowmultipleselection ;
   private boolean Combo_catprovcod_Includeonlyselectedoption ;
   private boolean Combo_catprovcod_Includeselectalloption ;
   private boolean Combo_catprovcod_Includeaddnewoption ;
   private boolean returnInSub ;
   private boolean AV13IsAuthorized ;
   private boolean GXt_boolean6 ;
   private boolean GXv_boolean7[] ;
   private boolean Gx_longc ;
   private boolean n122CatBasico ;
   private boolean n731CatValorHora ;
   private boolean n908CatAdicional ;
   private boolean n909CatAdiHora ;
   private String A2041CatOld ;
   private String A2204CatProvOld ;
   private String Z2041CatOld ;
   private String Z2204CatProvOld ;
   private String Z123CatDescrip ;
   private String Z676CatDescripSinAc ;
   private String Z2040CatRelRef ;
   private String Z2203CatProvRelRef ;
   private String A123CatDescrip ;
   private String A676CatDescripSinAc ;
   private String A2040CatRelRef ;
   private String A2203CatProvRelRef ;
   private com.genexus.webpanels.GXWebGrid Gridlevel1Container ;
   private com.genexus.webpanels.GXWebGrid Gridlevel2Container ;
   private com.genexus.webpanels.GXWebRow Gridlevel2Row ;
   private com.genexus.webpanels.GXWebRow Gridlevel1Row ;
   private com.genexus.webpanels.GXWebColumn Gridlevel1Column ;
   private com.genexus.webpanels.GXWebColumn Gridlevel2Column ;
   private com.genexus.webpanels.WebSession AV12WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.webpanels.GXUserControl ucCombo_catpaicod ;
   private com.genexus.webpanels.GXUserControl ucCombo_catprovcod ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private int[] T00099_A3CliCod ;
   private String[] T000910_A8CatCodigo ;
   private String[] T000910_A123CatDescrip ;
   private String[] T000910_A676CatDescripSinAc ;
   private byte[] T000910_A1838CatClase ;
   private String[] T000910_A2416CatTipoTarifa ;
   private byte[] T000910_A1914CatFrecAct ;
   private short[] T000910_A1894CatRelSec ;
   private boolean[] T000910_n1894CatRelSec ;
   private String[] T000910_A2040CatRelRef ;
   private String[] T000910_A2041CatOld ;
   private String[] T000910_A2198CatAfipCod ;
   private boolean[] T000910_n2198CatAfipCod ;
   private int[] T000910_A3CliCod ;
   private short[] T000910_A1564CliPaiConve ;
   private String[] T000910_A1565CliConvenio ;
   private int[] T000911_A3CliCod ;
   private short[] T000911_A1564CliPaiConve ;
   private String[] T000911_A1565CliConvenio ;
   private String[] T000911_A8CatCodigo ;
   private String[] T00098_A8CatCodigo ;
   private String[] T00098_A123CatDescrip ;
   private String[] T00098_A676CatDescripSinAc ;
   private byte[] T00098_A1838CatClase ;
   private String[] T00098_A2416CatTipoTarifa ;
   private byte[] T00098_A1914CatFrecAct ;
   private short[] T00098_A1894CatRelSec ;
   private boolean[] T00098_n1894CatRelSec ;
   private String[] T00098_A2040CatRelRef ;
   private String[] T00098_A2041CatOld ;
   private String[] T00098_A2198CatAfipCod ;
   private boolean[] T00098_n2198CatAfipCod ;
   private int[] T00098_A3CliCod ;
   private short[] T00098_A1564CliPaiConve ;
   private String[] T00098_A1565CliConvenio ;
   private int[] T000912_A3CliCod ;
   private short[] T000912_A1564CliPaiConve ;
   private String[] T000912_A1565CliConvenio ;
   private String[] T000912_A8CatCodigo ;
   private int[] T000913_A3CliCod ;
   private short[] T000913_A1564CliPaiConve ;
   private String[] T000913_A1565CliConvenio ;
   private String[] T000913_A8CatCodigo ;
   private String[] T00097_A8CatCodigo ;
   private String[] T00097_A123CatDescrip ;
   private String[] T00097_A676CatDescripSinAc ;
   private byte[] T00097_A1838CatClase ;
   private String[] T00097_A2416CatTipoTarifa ;
   private byte[] T00097_A1914CatFrecAct ;
   private short[] T00097_A1894CatRelSec ;
   private boolean[] T00097_n1894CatRelSec ;
   private String[] T00097_A2040CatRelRef ;
   private String[] T00097_A2041CatOld ;
   private String[] T00097_A2198CatAfipCod ;
   private boolean[] T00097_n2198CatAfipCod ;
   private int[] T00097_A3CliCod ;
   private short[] T00097_A1564CliPaiConve ;
   private String[] T00097_A1565CliConvenio ;
   private int[] T000917_A3CliCod ;
   private short[] T000917_A1EmpCod ;
   private int[] T000917_A31LiqNro ;
   private short[] T000917_A2142LiqPaiConve ;
   private String[] T000917_A2143LiqConvenio ;
   private String[] T000917_A2144LiqCatCodigo ;
   private int[] T000918_A3CliCod ;
   private short[] T000918_A1564CliPaiConve ;
   private String[] T000918_A1565CliConvenio ;
   private String[] T000918_A8CatCodigo ;
   private int[] T000919_A3CliCod ;
   private String[] T000919_A1565CliConvenio ;
   private String[] T000919_A8CatCodigo ;
   private int[] T000919_A2202CatProvRelSec ;
   private boolean[] T000919_n2202CatProvRelSec ;
   private String[] T000919_A2203CatProvRelRef ;
   private boolean[] T000919_n2203CatProvRelRef ;
   private String[] T000919_A2204CatProvOld ;
   private boolean[] T000919_n2204CatProvOld ;
   private short[] T000919_A2200CatPaiCod ;
   private short[] T000919_A2201CatProvCod ;
   private short[] T000919_A1564CliPaiConve ;
   private short[] T00096_A2200CatPaiCod ;
   private short[] T000920_A2200CatPaiCod ;
   private int[] T000921_A3CliCod ;
   private short[] T000921_A1564CliPaiConve ;
   private String[] T000921_A1565CliConvenio ;
   private String[] T000921_A8CatCodigo ;
   private short[] T000921_A2200CatPaiCod ;
   private short[] T000921_A2201CatProvCod ;
   private int[] T00095_A3CliCod ;
   private String[] T00095_A1565CliConvenio ;
   private String[] T00095_A8CatCodigo ;
   private int[] T00095_A2202CatProvRelSec ;
   private boolean[] T00095_n2202CatProvRelSec ;
   private String[] T00095_A2203CatProvRelRef ;
   private boolean[] T00095_n2203CatProvRelRef ;
   private String[] T00095_A2204CatProvOld ;
   private boolean[] T00095_n2204CatProvOld ;
   private short[] T00095_A2200CatPaiCod ;
   private short[] T00095_A2201CatProvCod ;
   private short[] T00095_A1564CliPaiConve ;
   private int[] T00094_A3CliCod ;
   private String[] T00094_A1565CliConvenio ;
   private String[] T00094_A8CatCodigo ;
   private int[] T00094_A2202CatProvRelSec ;
   private boolean[] T00094_n2202CatProvRelSec ;
   private String[] T00094_A2203CatProvRelRef ;
   private boolean[] T00094_n2203CatProvRelRef ;
   private String[] T00094_A2204CatProvOld ;
   private boolean[] T00094_n2204CatProvOld ;
   private short[] T00094_A2200CatPaiCod ;
   private short[] T00094_A2201CatProvCod ;
   private short[] T00094_A1564CliPaiConve ;
   private int[] T000925_A3CliCod ;
   private short[] T000925_A1564CliPaiConve ;
   private String[] T000925_A1565CliConvenio ;
   private String[] T000925_A8CatCodigo ;
   private short[] T000925_A2200CatPaiCod ;
   private short[] T000925_A2201CatProvCod ;
   private int[] T000926_A3CliCod ;
   private String[] T000926_A1565CliConvenio ;
   private String[] T000926_A8CatCodigo ;
   private java.util.Date[] T000926_A907CatVigencia ;
   private java.math.BigDecimal[] T000926_A122CatBasico ;
   private boolean[] T000926_n122CatBasico ;
   private java.math.BigDecimal[] T000926_A731CatValorHora ;
   private boolean[] T000926_n731CatValorHora ;
   private java.math.BigDecimal[] T000926_A908CatAdicional ;
   private boolean[] T000926_n908CatAdicional ;
   private java.math.BigDecimal[] T000926_A909CatAdiHora ;
   private boolean[] T000926_n909CatAdiHora ;
   private java.math.BigDecimal[] T000926_A1892EscBasico ;
   private java.math.BigDecimal[] T000926_A1893EscAdicional ;
   private short[] T000926_A1564CliPaiConve ;
   private int[] T000927_A3CliCod ;
   private short[] T000927_A1564CliPaiConve ;
   private String[] T000927_A1565CliConvenio ;
   private String[] T000927_A8CatCodigo ;
   private java.util.Date[] T000927_A907CatVigencia ;
   private int[] T00093_A3CliCod ;
   private String[] T00093_A1565CliConvenio ;
   private String[] T00093_A8CatCodigo ;
   private java.util.Date[] T00093_A907CatVigencia ;
   private java.math.BigDecimal[] T00093_A122CatBasico ;
   private boolean[] T00093_n122CatBasico ;
   private java.math.BigDecimal[] T00093_A731CatValorHora ;
   private boolean[] T00093_n731CatValorHora ;
   private java.math.BigDecimal[] T00093_A908CatAdicional ;
   private boolean[] T00093_n908CatAdicional ;
   private java.math.BigDecimal[] T00093_A909CatAdiHora ;
   private boolean[] T00093_n909CatAdiHora ;
   private java.math.BigDecimal[] T00093_A1892EscBasico ;
   private java.math.BigDecimal[] T00093_A1893EscAdicional ;
   private short[] T00093_A1564CliPaiConve ;
   private int[] T00092_A3CliCod ;
   private String[] T00092_A1565CliConvenio ;
   private String[] T00092_A8CatCodigo ;
   private java.util.Date[] T00092_A907CatVigencia ;
   private java.math.BigDecimal[] T00092_A122CatBasico ;
   private boolean[] T00092_n122CatBasico ;
   private java.math.BigDecimal[] T00092_A731CatValorHora ;
   private boolean[] T00092_n731CatValorHora ;
   private java.math.BigDecimal[] T00092_A908CatAdicional ;
   private boolean[] T00092_n908CatAdicional ;
   private java.math.BigDecimal[] T00092_A909CatAdiHora ;
   private boolean[] T00092_n909CatAdiHora ;
   private java.math.BigDecimal[] T00092_A1892EscBasico ;
   private java.math.BigDecimal[] T00092_A1893EscAdicional ;
   private short[] T00092_A1564CliPaiConve ;
   private int[] T000931_A3CliCod ;
   private short[] T000931_A1564CliPaiConve ;
   private String[] T000931_A1565CliConvenio ;
   private String[] T000931_A8CatCodigo ;
   private java.util.Date[] T000931_A907CatVigencia ;
   private short[] T000932_A2200CatPaiCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV17SinCod ;
   private GXSimpleCollection<String> GXt_objcol_char12 ;
   private GXSimpleCollection<String> GXv_objcol_char13[] ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV34CatPaiCod_Data ;
   private GXBaseCollection<web.wwpbaseobjects.SdtDVB_SDTComboData_Item> AV35CatProvCod_Data ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV11TrnContext ;
   private web.wwpbaseobjects.SdtWWPContext AV10WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext3[] ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons AV23DDO_TitleSettingsIcons ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXt_SdtDVB_SDTDropDownOptionsTitleSettingsIcons4 ;
   private web.wwpbaseobjects.SdtDVB_SDTDropDownOptionsTitleSettingsIcons GXv_SdtDVB_SDTDropDownOptionsTitleSettingsIcons5[] ;
}

final  class categoria__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00092", "SELECT CliCod, CliConvenio, CatCodigo, CatVigencia, CatBasico, CatValorHora, CatAdicional, CatAdiHora, EscBasico, EscAdicional, CliPaiConve FROM Categoriavalores1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ?  FOR UPDATE OF Categoriavalores1 NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00093", "SELECT CliCod, CliConvenio, CatCodigo, CatVigencia, CatBasico, CatValorHora, CatAdicional, CatAdiHora, EscBasico, EscAdicional, CliPaiConve FROM Categoriavalores1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00094", "SELECT CliCod, CliConvenio, CatCodigo, CatProvRelSec, CatProvRelRef, CatProvOld, CatPaiCod, CatProvCod, CliPaiConve FROM CategoriaProvincias WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatPaiCod = ? AND CatProvCod = ?  FOR UPDATE OF CategoriaProvincias NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00095", "SELECT CliCod, CliConvenio, CatCodigo, CatProvRelSec, CatProvRelRef, CatProvOld, CatPaiCod, CatProvCod, CliPaiConve FROM CategoriaProvincias WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatPaiCod = ? AND CatProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00096", "SELECT PaiCod AS CatPaiCod FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00097", "SELECT CatCodigo, CatDescrip, CatDescripSinAc, CatClase, CatTipoTarifa, CatFrecAct, CatRelSec, CatRelRef, CatOld, CatAfipCod, CliCod, CliPaiConve, CliConvenio FROM Categoria1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ?  FOR UPDATE OF Categoria1 NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00098", "SELECT CatCodigo, CatDescrip, CatDescripSinAc, CatClase, CatTipoTarifa, CatFrecAct, CatRelSec, CatRelRef, CatOld, CatAfipCod, CliCod, CliPaiConve, CliConvenio FROM Categoria1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00099", "SELECT CliCod FROM ClienteConvenios WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000910", "SELECT TM1.CatCodigo, TM1.CatDescrip, TM1.CatDescripSinAc, TM1.CatClase, TM1.CatTipoTarifa, TM1.CatFrecAct, TM1.CatRelSec, TM1.CatRelRef, TM1.CatOld, TM1.CatAfipCod, TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio FROM Categoria1 TM1 WHERE TM1.CliCod = ? and TM1.CliPaiConve = ? and TM1.CliConvenio = ( ?) and TM1.CatCodigo = ( ?) ORDER BY TM1.CliCod, TM1.CliPaiConve, TM1.CliConvenio, TM1.CatCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000911", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo FROM Categoria1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000912", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo FROM Categoria1 WHERE ( CliCod > ? or CliCod = ? and CliPaiConve > ? or CliPaiConve = ? and CliCod = ? and CliConvenio > ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CatCodigo > ( ?)) ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000913", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo FROM Categoria1 WHERE ( CliCod < ? or CliCod = ? and CliPaiConve < ? or CliPaiConve = ? and CliCod = ? and CliConvenio < ( ?) or CliConvenio = ( ?) and CliPaiConve = ? and CliCod = ? and CatCodigo < ( ?)) ORDER BY CliCod DESC, CliPaiConve DESC, CliConvenio DESC, CatCodigo DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000914", "SAVEPOINT gxupdate;INSERT INTO Categoria1(CatCodigo, CatDescrip, CatDescripSinAc, CatClase, CatTipoTarifa, CatFrecAct, CatRelSec, CatRelRef, CatOld, CatAfipCod, CliCod, CliPaiConve, CliConvenio) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000915", "SAVEPOINT gxupdate;UPDATE Categoria1 SET CatDescrip=?, CatDescripSinAc=?, CatClase=?, CatTipoTarifa=?, CatFrecAct=?, CatRelSec=?, CatRelRef=?, CatOld=?, CatAfipCod=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000916", "SAVEPOINT gxupdate;DELETE FROM Categoria1  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000917", "SELECT CliCod, EmpCod, LiqNro, LiqPaiConve, LiqConvenio, LiqCatCodigo FROM LiquidacionCategoria WHERE CliCod = ? AND LiqPaiConve = ? AND LiqConvenio = ? AND LiqCatCodigo = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000918", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo FROM Categoria1 ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000919", "SELECT CliCod, CliConvenio, CatCodigo, CatProvRelSec, CatProvRelRef, CatProvOld, CatPaiCod, CatProvCod, CliPaiConve FROM CategoriaProvincias WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) and CatPaiCod = ? and CatProvCod = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatPaiCod, CatProvCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000920", "SELECT PaiCod AS CatPaiCod FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000921", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatPaiCod, CatProvCod FROM CategoriaProvincias WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatPaiCod = ? AND CatProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000922", "SAVEPOINT gxupdate;INSERT INTO CategoriaProvincias(CliCod, CliConvenio, CatCodigo, CatProvRelSec, CatProvRelRef, CatProvOld, CatPaiCod, CatProvCod, CliPaiConve) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000923", "SAVEPOINT gxupdate;UPDATE CategoriaProvincias SET CatProvRelSec=?, CatProvRelRef=?, CatProvOld=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatPaiCod = ? AND CatProvCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000924", "SAVEPOINT gxupdate;DELETE FROM CategoriaProvincias  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatPaiCod = ? AND CatProvCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000925", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatPaiCod, CatProvCod FROM CategoriaProvincias WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatPaiCod, CatProvCod ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000926", "SELECT CliCod, CliConvenio, CatCodigo, CatVigencia, CatBasico, CatValorHora, CatAdicional, CatAdiHora, EscBasico, EscAdicional, CliPaiConve FROM Categoriavalores1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) and CatVigencia = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000927", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia FROM Categoriavalores1 WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000928", "SAVEPOINT gxupdate;INSERT INTO Categoriavalores1(CliCod, CliConvenio, CatCodigo, CatVigencia, CatBasico, CatValorHora, CatAdicional, CatAdiHora, EscBasico, EscAdicional, CliPaiConve, CatSalRelSec, CatSalRelRef, CatSalOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, 0, '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000929", "SAVEPOINT gxupdate;UPDATE Categoriavalores1 SET CatBasico=?, CatValorHora=?, CatAdicional=?, CatAdiHora=?, EscBasico=?, EscAdicional=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000930", "SAVEPOINT gxupdate;DELETE FROM Categoriavalores1  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000931", "SELECT CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia FROM Categoriavalores1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000932", "SELECT PaiCod AS CatPaiCod FROM Provincia WHERE PaiCod = ? AND ProvCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(10,2);
               ((short[]) buf[14])[0] = rslt.getShort(11);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(10,2);
               ((short[]) buf[14])[0] = rslt.getShort(11);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((short[]) buf[9])[0] = rslt.getShort(7);
               ((short[]) buf[10])[0] = rslt.getShort(8);
               ((short[]) buf[11])[0] = rslt.getShort(9);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((short[]) buf[9])[0] = rslt.getShort(7);
               ((short[]) buf[10])[0] = rslt.getShort(8);
               ((short[]) buf[11])[0] = rslt.getShort(9);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 5 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 6);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((String[]) buf[14])[0] = rslt.getString(13, 20);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 6);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((String[]) buf[14])[0] = rslt.getString(13, 20);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getString(1, 40);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 1);
               ((byte[]) buf[5])[0] = rslt.getByte(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((String[]) buf[8])[0] = rslt.getVarchar(8);
               ((String[]) buf[9])[0] = rslt.getLongVarchar(9);
               ((String[]) buf[10])[0] = rslt.getString(10, 6);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(11);
               ((short[]) buf[13])[0] = rslt.getShort(12);
               ((String[]) buf[14])[0] = rslt.getString(13, 20);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getString(6, 40);
               return;
            case 16 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               return;
            case 17 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((String[]) buf[5])[0] = rslt.getVarchar(5);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getLongVarchar(6);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((short[]) buf[9])[0] = rslt.getShort(7);
               ((short[]) buf[10])[0] = rslt.getShort(8);
               ((short[]) buf[11])[0] = rslt.getShort(9);
               return;
            case 18 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 23 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               return;
            case 24 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((String[]) buf[2])[0] = rslt.getString(3, 40);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((java.math.BigDecimal[]) buf[4])[0] = rslt.getBigDecimal(5,2);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(6,2);
               ((boolean[]) buf[7])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(10,2);
               ((short[]) buf[14])[0] = rslt.getShort(11);
               return;
            case 25 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
            case 29 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((String[]) buf[3])[0] = rslt.getString(4, 40);
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(5);
               return;
      }
      getresults30( cursor, rslt, buf) ;
   }

   public void getresults30( int cursor ,
                             IFieldGetter rslt ,
                             Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setString(10, (String)parms[9], 40);
               return;
            case 11 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setString(6, (String)parms[5], 20);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setShort(8, ((Number) parms[7]).shortValue());
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setString(10, (String)parms[9], 40);
               return;
            case 12 :
               stmt.setString(1, (String)parms[0], 40);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setByte(4, ((Number) parms[3]).byteValue());
               stmt.setString(5, (String)parms[4], 1);
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(7, ((Number) parms[7]).shortValue());
               }
               stmt.setVarchar(8, (String)parms[8], 40, false);
               stmt.setNLongVarchar(9, (String)parms[9], false);
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 10 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(10, (String)parms[11], 6);
               }
               stmt.setInt(11, ((Number) parms[12]).intValue());
               stmt.setShort(12, ((Number) parms[13]).shortValue());
               stmt.setString(13, (String)parms[14], 20);
               return;
            case 13 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 1);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(6, ((Number) parms[6]).shortValue());
               }
               stmt.setVarchar(7, (String)parms[7], 40, false);
               stmt.setNLongVarchar(8, (String)parms[8], false);
               if ( ((Boolean) parms[9]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(9, (String)parms[10], 6);
               }
               stmt.setInt(10, ((Number) parms[11]).intValue());
               stmt.setShort(11, ((Number) parms[12]).shortValue());
               stmt.setString(12, (String)parms[13], 20);
               stmt.setString(13, (String)parms[14], 40);
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 17 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 40);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(4, ((Number) parms[4]).intValue());
               }
               if ( ((Boolean) parms[5]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(5, (String)parms[6], 40);
               }
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(6, (String)parms[8]);
               }
               stmt.setShort(7, ((Number) parms[9]).shortValue());
               stmt.setShort(8, ((Number) parms[10]).shortValue());
               stmt.setShort(9, ((Number) parms[11]).shortValue());
               return;
            case 21 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(2, (String)parms[3], 40);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(3, (String)parms[5]);
               }
               stmt.setInt(4, ((Number) parms[6]).intValue());
               stmt.setShort(5, ((Number) parms[7]).shortValue());
               stmt.setString(6, (String)parms[8], 20);
               stmt.setString(7, (String)parms[9], 40);
               stmt.setShort(8, ((Number) parms[10]).shortValue());
               stmt.setShort(9, ((Number) parms[11]).shortValue());
               return;
            case 22 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 23 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
            case 24 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 25 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 26 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 40);
               stmt.setDate(4, (java.util.Date)parms[3]);
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 5 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(5, (java.math.BigDecimal)parms[5], 2);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 6 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(6, (java.math.BigDecimal)parms[7], 2);
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(7, (java.math.BigDecimal)parms[9], 2);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(8, (java.math.BigDecimal)parms[11], 2);
               }
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[12], 2);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[13], 2);
               stmt.setShort(11, ((Number) parms[14]).shortValue());
               return;
            case 27 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(1, (java.math.BigDecimal)parms[1], 2);
               }
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 2 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(2, (java.math.BigDecimal)parms[3], 2);
               }
               if ( ((Boolean) parms[4]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(3, (java.math.BigDecimal)parms[5], 2);
               }
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 4 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(4, (java.math.BigDecimal)parms[7], 2);
               }
               stmt.setBigDecimal(5, (java.math.BigDecimal)parms[8], 2);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[9], 2);
               stmt.setInt(7, ((Number) parms[10]).intValue());
               stmt.setShort(8, ((Number) parms[11]).shortValue());
               stmt.setString(9, (String)parms[12], 20);
               stmt.setString(10, (String)parms[13], 40);
               stmt.setDate(11, (java.util.Date)parms[14]);
               return;
            case 28 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 29 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               return;
      }
      setparameters30( cursor, stmt, parms) ;
   }

   public void setparameters30( int cursor ,
                                IFieldSetter stmt ,
                                Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 30 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

