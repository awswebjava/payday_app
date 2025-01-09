package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class importacion_legajo_impl extends GXDataArea
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action34") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A626MigrLegId = httpContext.GetPar( "MigrLegId") ;
         httpContext.ajax_rsp_assign_attri("", false, "A626MigrLegId", A626MigrLegId);
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_34_0175( A3CliCod, A1EmpCod, A626MigrLegId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxJX_Action36") == 0 )
      {
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         xc_36_0175( ) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel1"+"_"+"CLICOD") == 0 )
      {
         AV7CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CliCod), 6, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx1asaclicod0175( AV7CliCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxAggSel3"+"_"+"EMPCOD") == 0 )
      {
         AV18EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18EmpCod), 4, 0));
         web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18EmpCod), "ZZZ9")));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gx3asaempcod0175( AV18EmpCod) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_40") == 0 )
      {
         A3CliCod = (int)(GXutil.lval( httpContext.GetPar( "CliCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_40( A3CliCod, A1EmpCod) ;
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
            AV18EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV18EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV18EmpCod), 4, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18EmpCod), "ZZZ9")));
            AV40MigrLegNumero = (int)(GXutil.lval( httpContext.GetPar( "MigrLegNumero"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV40MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV40MigrLegNumero), 8, 0));
            web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMIGRLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV40MigrLegNumero), "ZZZZZZZ9")));
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
         Form.getMeta().addItem("description", httpContext.getMessage( "Importación de Legajos", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtMigrLegId_Internalname ;
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
      nRC_GXsfl_203 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_203"))) ;
      nGXsfl_203_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_203_idx"))) ;
      sGXsfl_203_idx = httpContext.GetPar( "sGXsfl_203_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridlevel1_newrow( ) ;
      /* End function gxnrGridlevel1_newrow_invoke */
   }

   public importacion_legajo_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public importacion_legajo_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importacion_legajo_impl.class ));
   }

   public importacion_legajo_impl( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
      cmbMigrLegSindicato = new HTMLChoice();
      cmbMigrLegConvenio = new HTMLChoice();
      cmbMigrLegCategoria = new HTMLChoice();
      cmbMigrLegArea = new HTMLChoice();
      cmbMigrLegObraSocial = new HTMLChoice();
      cmbMigrLegModalidad = new HTMLChoice();
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
      if ( cmbMigrLegSindicato.getItemCount() > 0 )
      {
         A613MigrLegSindicato = cmbMigrLegSindicato.getValidValue(A613MigrLegSindicato) ;
         httpContext.ajax_rsp_assign_attri("", false, "A613MigrLegSindicato", A613MigrLegSindicato);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbMigrLegSindicato.setValue( GXutil.rtrim( A613MigrLegSindicato) );
         httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegSindicato.getInternalname(), "Values", cmbMigrLegSindicato.ToJavascriptSource(), true);
      }
      if ( cmbMigrLegConvenio.getItemCount() > 0 )
      {
         A627MigrLegConvenio = cmbMigrLegConvenio.getValidValue(A627MigrLegConvenio) ;
         httpContext.ajax_rsp_assign_attri("", false, "A627MigrLegConvenio", A627MigrLegConvenio);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbMigrLegConvenio.setValue( GXutil.rtrim( A627MigrLegConvenio) );
         httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegConvenio.getInternalname(), "Values", cmbMigrLegConvenio.ToJavascriptSource(), true);
      }
      if ( cmbMigrLegCategoria.getItemCount() > 0 )
      {
         A604MigrLegCategoria = cmbMigrLegCategoria.getValidValue(A604MigrLegCategoria) ;
         httpContext.ajax_rsp_assign_attri("", false, "A604MigrLegCategoria", A604MigrLegCategoria);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbMigrLegCategoria.setValue( GXutil.rtrim( A604MigrLegCategoria) );
         httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegCategoria.getInternalname(), "Values", cmbMigrLegCategoria.ToJavascriptSource(), true);
      }
      if ( cmbMigrLegArea.getItemCount() > 0 )
      {
         A605MigrLegArea = cmbMigrLegArea.getValidValue(A605MigrLegArea) ;
         httpContext.ajax_rsp_assign_attri("", false, "A605MigrLegArea", A605MigrLegArea);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbMigrLegArea.setValue( GXutil.rtrim( A605MigrLegArea) );
         httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegArea.getInternalname(), "Values", cmbMigrLegArea.ToJavascriptSource(), true);
      }
      if ( cmbMigrLegObraSocial.getItemCount() > 0 )
      {
         A614MigrLegObraSocial = cmbMigrLegObraSocial.getValidValue(A614MigrLegObraSocial) ;
         httpContext.ajax_rsp_assign_attri("", false, "A614MigrLegObraSocial", A614MigrLegObraSocial);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbMigrLegObraSocial.setValue( GXutil.rtrim( A614MigrLegObraSocial) );
         httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegObraSocial.getInternalname(), "Values", cmbMigrLegObraSocial.ToJavascriptSource(), true);
      }
      if ( cmbMigrLegModalidad.getItemCount() > 0 )
      {
         A617MigrLegModalidad = cmbMigrLegModalidad.getValidValue(A617MigrLegModalidad) ;
         httpContext.ajax_rsp_assign_attri("", false, "A617MigrLegModalidad", A617MigrLegModalidad);
      }
      if ( httpContext.isAjaxRequest( ) )
      {
         cmbMigrLegModalidad.setValue( GXutil.rtrim( A617MigrLegModalidad) );
         httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegModalidad.getInternalname(), "Values", cmbMigrLegModalidad.ToJavascriptSource(), true);
      }
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegId_Internalname, httpContext.getMessage( "ID/Código", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 22,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegId_Internalname, GXutil.rtrim( A626MigrLegId), GXutil.rtrim( localUtil.format( A626MigrLegId, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,22);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegId_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegCUIL_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegCUIL_Internalname, httpContext.getMessage( "CUIL", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegCUIL_Internalname, GXutil.rtrim( A597MigrLegCUIL), GXutil.rtrim( localUtil.format( A597MigrLegCUIL, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,27);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegCUIL_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegCUIL_Enabled, 0, "text", "", 13, "chr", 1, "row", 13, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Cuit", "left", true, "", "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegApellido_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegApellido_Internalname, httpContext.getMessage( "Apellido", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 32,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegApellido_Internalname, A592MigrLegApellido, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,32);\"", (short)(0), 1, edtMigrLegApellido_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegNombre_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegNombre_Internalname, httpContext.getMessage( "Nombres", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 37,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegNombre_Internalname, A593MigrLegNombre, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,37);\"", (short)(0), 1, edtMigrLegNombre_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegModTra_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegModTra_Internalname, httpContext.getMessage( "Relación laboral", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 42,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegModTra_Internalname, A2415MigrLegModTra, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,42);\"", (short)(0), 1, edtMigrLegModTra_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegTipoTarifa_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegTipoTarifa_Internalname, httpContext.getMessage( "Tipo Tarifa", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 47,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegTipoTarifa_Internalname, A2427MigrLegTipoTarifa, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,47);\"", (short)(0), 1, edtMigrLegTipoTarifa_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegClase_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegClase_Internalname, httpContext.getMessage( "Clase (Mensual o Jornal)", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegClase_Internalname, A607MigrLegClase, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,52);\"", (short)(0), 1, edtMigrLegClase_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegFecNac_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegFecNac_Internalname, httpContext.getMessage( "Fecha de Nacimiento", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 57,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtMigrLegFecNac_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegFecNac_Internalname, localUtil.format(A594MigrLegFecNac, "99/99/9999"), localUtil.format( A594MigrLegFecNac, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,57);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegFecNac_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtMigrLegFecNac_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtMigrLegFecNac_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtMigrLegFecNac_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_importacion_legajo.htm");
      httpContext.writeTextNL( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegFecIngreso_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegFecIngreso_Internalname, httpContext.getMessage( "Fecha a ingresar", ""), "col-sm-3 AttributeDateLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 62,'',false,'',0)\"" ;
      httpContext.writeText( "<div id=\""+edtMigrLegFecIngreso_Internalname+"_dp_container\" class=\"dp_container\" style=\"white-space:nowrap;display:inline;\">") ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegFecIngreso_Internalname, localUtil.format(A603MigrLegFecIngreso, "99/99/9999"), localUtil.format( A603MigrLegFecIngreso, "99/99/9999"), TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,62);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegFecIngreso_Jsonclick, 0, "AttributeDate", "", "", "", "", 1, edtMigrLegFecIngreso_Enabled, 0, "text", "", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Fecha", "right", false, "", "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_bitmap( httpContext, edtMigrLegFecIngreso_Internalname+"_dp_trigger", context.getHttpContext().getImagePath( "61b9b5d3-dff6-4d59-9b00-da61bc2cbe93", "", context.getHttpContext().getTheme( )), "", "", "", "", ((1==0)||(edtMigrLegFecIngreso_Enabled==0) ? 0 : 1), 0, "Date selector", "Date selector", 0, 1, 0, "", 0, "", 0, 0, 0, "", "", "cursor: pointer;", "", "", "", "", "", "", "", "", 1, false, false, "", "HLP_importacion_legajo.htm");
      httpContext.writeTextNL( "</div>") ;
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegSexo_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegSexo_Internalname, httpContext.getMessage( "Género", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 67,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegSexo_Internalname, GXutil.rtrim( A595MigrLegSexo), GXutil.rtrim( localUtil.format( A595MigrLegSexo, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,67);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegSexo_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegSexo_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegDomici_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegDomici_Internalname, httpContext.getMessage( "Domicilio", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 72,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegDomici_Internalname, A599MigrLegDomici, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,72);\"", (short)(0), 1, edtMigrLegDomici_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "4000", -1, 0, "", "", (byte)(-1), true, "VarcharTextArea", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegCodPos_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegCodPos_Internalname, httpContext.getMessage( "Código Postal", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 77,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegCodPos_Internalname, A601MigrLegCodPos, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,77);\"", (short)(0), 1, edtMigrLegCodPos_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegTelefono_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegTelefono_Internalname, httpContext.getMessage( "Teléfono", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 82,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegTelefono_Internalname, A602MigrLegTelefono, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,82);\"", (short)(0), 1, edtMigrLegTelefono_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegEmail_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegEmail_Internalname, httpContext.getMessage( "Email", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 87,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegEmail_Internalname, A600MigrLegEmail, GXutil.rtrim( localUtil.format( A600MigrLegEmail, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,87);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegEmail_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegEmail_Enabled, 0, "text", "", 80, "chr", 1, "row", 100, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegEstadoCivil_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegEstadoCivil_Internalname, httpContext.getMessage( "Estado Civil", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 92,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegEstadoCivil_Internalname, A596MigrLegEstadoCivil, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,92);\"", (short)(0), 1, edtMigrLegEstadoCivil_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegsindicato_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegsindicato_Internalname, httpContext.getMessage( "Sindicato", ""), "", "", lblTextblockmigrlegsindicato_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegsindicato_Internalname, tblTablemergedmigrlegsindicato_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbMigrLegSindicato.getInternalname(), httpContext.getMessage( "Sindicato", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 104,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbMigrLegSindicato, cmbMigrLegSindicato.getInternalname(), GXutil.rtrim( A613MigrLegSindicato), 1, cmbMigrLegSindicato.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbMigrLegSindicato.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,104);\"", "", true, (byte)(0), "HLP_importacion_legajo.htm");
      cmbMigrLegSindicato.setValue( GXutil.rtrim( A613MigrLegSindicato) );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegSindicato.getInternalname(), "Values", cmbMigrLegSindicato.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegsindicato_righttext_Internalname, httpContext.getMessage( "right text", ""), "", "", lblMigrlegsindicato_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajo.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegconvenio_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegconvenio_Internalname, httpContext.getMessage( "Convenio", ""), "", "", lblTextblockmigrlegconvenio_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegconvenio_Internalname, tblTablemergedmigrlegconvenio_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbMigrLegConvenio.getInternalname(), httpContext.getMessage( "Convenio", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 118,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbMigrLegConvenio, cmbMigrLegConvenio.getInternalname(), GXutil.rtrim( A627MigrLegConvenio), 1, cmbMigrLegConvenio.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbMigrLegConvenio.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,118);\"", "", true, (byte)(0), "HLP_importacion_legajo.htm");
      cmbMigrLegConvenio.setValue( GXutil.rtrim( A627MigrLegConvenio) );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegConvenio.getInternalname(), "Values", cmbMigrLegConvenio.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegconvenio_righttext_Internalname, httpContext.getMessage( "right text", ""), "", "", lblMigrlegconvenio_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajo.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegcategoria_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegcategoria_Internalname, httpContext.getMessage( "Categoría", ""), "", "", lblTextblockmigrlegcategoria_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegcategoria_Internalname, tblTablemergedmigrlegcategoria_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbMigrLegCategoria.getInternalname(), httpContext.getMessage( "Categoría", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 132,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbMigrLegCategoria, cmbMigrLegCategoria.getInternalname(), GXutil.rtrim( A604MigrLegCategoria), 1, cmbMigrLegCategoria.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbMigrLegCategoria.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,132);\"", "", true, (byte)(0), "HLP_importacion_legajo.htm");
      cmbMigrLegCategoria.setValue( GXutil.rtrim( A604MigrLegCategoria) );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegCategoria.getInternalname(), "Values", cmbMigrLegCategoria.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegcategoria_righttext_Internalname, httpContext.getMessage( "right text", ""), "", "", lblMigrlegcategoria_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajo.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegarea_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegarea_Internalname, httpContext.getMessage( "Área", ""), "", "", lblTextblockmigrlegarea_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegarea_Internalname, tblTablemergedmigrlegarea_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbMigrLegArea.getInternalname(), httpContext.getMessage( "Área", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 146,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbMigrLegArea, cmbMigrLegArea.getInternalname(), GXutil.rtrim( A605MigrLegArea), 1, cmbMigrLegArea.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbMigrLegArea.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,146);\"", "", true, (byte)(0), "HLP_importacion_legajo.htm");
      cmbMigrLegArea.setValue( GXutil.rtrim( A605MigrLegArea) );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegArea.getInternalname(), "Values", cmbMigrLegArea.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegarea_righttext_Internalname, httpContext.getMessage( "right text", ""), "", "", lblMigrlegarea_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajo.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegBasico_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegBasico_Internalname, httpContext.getMessage( "Sueldo bàsico", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 153,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegBasico_Internalname, GXutil.ltrim( localUtil.ntoc( A608MigrLegBasico, (byte)(17), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtMigrLegBasico_Enabled!=0) ? localUtil.format( A608MigrLegBasico, "ZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A608MigrLegBasico, "ZZ,ZZZ,ZZZ,ZZ9.99"))), TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'2');"+";gx.evt.onblur(this,153);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegBasico_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegBasico_Enabled, 0, "text", "", 17, "chr", 1, "row", 17, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes", "right", false, "", "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegobrasocial_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegobrasocial_Internalname, httpContext.getMessage( "Obra Social", ""), "", "", lblTextblockmigrlegobrasocial_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegobrasocial_Internalname, tblTablemergedmigrlegobrasocial_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbMigrLegObraSocial.getInternalname(), httpContext.getMessage( "Obra Social", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 165,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbMigrLegObraSocial, cmbMigrLegObraSocial.getInternalname(), GXutil.rtrim( A614MigrLegObraSocial), 1, cmbMigrLegObraSocial.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbMigrLegObraSocial.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,165);\"", "", true, (byte)(0), "HLP_importacion_legajo.htm");
      cmbMigrLegObraSocial.setValue( GXutil.rtrim( A614MigrLegObraSocial) );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegObraSocial.getInternalname(), "Values", cmbMigrLegObraSocial.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegobrasocial_righttext_Internalname, httpContext.getMessage( "right text", ""), "", "", lblMigrlegobrasocial_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajo.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegOSAfip_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegOSAfip_Internalname, httpContext.getMessage( "Código AFIP de Obra Social", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 172,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegOSAfip_Internalname, GXutil.rtrim( A634MigrLegOSAfip), GXutil.rtrim( localUtil.format( A634MigrLegOSAfip, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,172);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegOSAfip_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegOSAfip_Enabled, 1, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegCBU_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegCBU_Internalname, httpContext.getMessage( "CBU", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 177,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegCBU_Internalname, A621MigrLegCBU, GXutil.rtrim( localUtil.format( A621MigrLegCBU, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,177);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegCBU_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtMigrLegCBU_Enabled, 0, "text", "", 22, "chr", 1, "row", 22, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "CBU", "left", true, "", "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, divTablesplittedmigrlegmodalidad_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 MergeLabelCell", "left", "top", "", "", "div");
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblTextblockmigrlegmodalidad_Internalname, httpContext.getMessage( "Modalidad", ""), "", "", lblTextblockmigrlegmodalidad_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "Label", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9", "left", "top", "", "", "div");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblTablemergedmigrlegmodalidad_Internalname, tblTablemergedmigrlegmodalidad_Internalname, "", "TableMerged", 0, "", "", 0, 0, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td class='MergeDataCell'>") ;
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, cmbMigrLegModalidad.getInternalname(), httpContext.getMessage( "Migr Leg Modalidad", ""), "gx-form-item AttributeLabel", 0, true, "width: 25%;");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 189,'',false,'',0)\"" ;
      /* ComboBox */
      web.GxWebStd.gx_combobox_ctrl1( httpContext, cmbMigrLegModalidad, cmbMigrLegModalidad.getInternalname(), GXutil.rtrim( A617MigrLegModalidad), 1, cmbMigrLegModalidad.getJsonclick(), 0, "'"+""+"'"+",false,"+"'"+""+"'", "svchar", "", 1, cmbMigrLegModalidad.getEnabled(), 0, (short)(0), 0, "em", 0, "", "", "Attribute", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,189);\"", "", true, (byte)(0), "HLP_importacion_legajo.htm");
      cmbMigrLegModalidad.setValue( GXutil.rtrim( A617MigrLegModalidad) );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegModalidad.getInternalname(), "Values", cmbMigrLegModalidad.ToJavascriptSource(), true);
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "<td>") ;
      /* Text block */
      web.GxWebStd.gx_label_ctrl( httpContext, lblMigrlegmodalidad_righttext_Internalname, httpContext.getMessage( "right text", ""), "", "", lblMigrlegmodalidad_righttext_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "DataDescription", 0, "", 1, 1, 0, (short)(0), "HLP_importacion_legajo.htm");
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
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 DataContentCell", "left", "top", "", "", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtMigrLegObs_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      web.GxWebStd.gx_label_element( httpContext, edtMigrLegObs_Internalname, httpContext.getMessage( "Observaciones", ""), "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 196,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegObs_Internalname, A628MigrLegObs, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,196);\"", (short)(0), 1, edtMigrLegObs_Enabled, 0, 80, "chr", 10, "row", (byte)(0), StyleString, ClassString, "", "", "2000", -1, 0, "", "", (byte)(-1), true, "Obs", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajo.htm");
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
      /* Control Group */
      web.GxWebStd.gx_group_start( httpContext, grpUnnamedgroup2_Internalname, httpContext.getMessage( "Familiares", ""), 1, 0, "px", 0, "px", "Group", "", "HLP_importacion_legajo.htm");
      /* Table start */
      sStyleString = "" ;
      web.GxWebStd.gx_table_start( httpContext, tblUnnamedtable1_Internalname, tblUnnamedtable1_Internalname, "", "", 0, "", "", 1, 2, sStyleString, "", "", 0);
      httpContext.writeText( "<tr>") ;
      httpContext.writeText( "<td>") ;
      /*  Grid Control  */
      startgridcontrol203( ) ;
      nGXsfl_203_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount262 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_262 = (short)(1) ;
            scanStart01262( ) ;
            while ( RcdFound262 != 0 )
            {
               init_level_properties262( ) ;
               getByPrimaryKey01262( ) ;
               addRow01262( ) ;
               scanNext01262( ) ;
            }
            scanEnd01262( ) ;
            nBlankRcdCount262 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         B634MigrLegOSAfip = A634MigrLegOSAfip ;
         httpContext.ajax_rsp_assign_attri("", false, "A634MigrLegOSAfip", A634MigrLegOSAfip);
         standaloneNotModal01262( ) ;
         standaloneModal01262( ) ;
         sMode262 = Gx_mode ;
         while ( nGXsfl_203_idx < nRC_GXsfl_203 )
         {
            bGXsfl_203_Refreshing = true ;
            readRow01262( ) ;
            edtMigrLegFamSec_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MIGRLEGFAMSEC_"+sGXsfl_203_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamSec_Enabled), 5, 0), !bGXsfl_203_Refreshing);
            edtMigrLegFamParen_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MIGRLEGFAMPAREN_"+sGXsfl_203_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamParen_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamParen_Enabled), 5, 0), !bGXsfl_203_Refreshing);
            edtMigrLegFamNroDoc_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MIGRLEGFAMNRODOC_"+sGXsfl_203_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamNroDoc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamNroDoc_Enabled), 5, 0), !bGXsfl_203_Refreshing);
            edtMigrLegFamNomApe_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MIGRLEGFAMNOMAPE_"+sGXsfl_203_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamNomApe_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamNomApe_Enabled), 5, 0), !bGXsfl_203_Refreshing);
            edtMigrLegFamFecNac_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MIGRLEGFAMFECNAC_"+sGXsfl_203_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamFecNac_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamFecNac_Enabled), 5, 0), !bGXsfl_203_Refreshing);
            edtMigrLegFamDedGan_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MIGRLEGFAMDEDGAN_"+sGXsfl_203_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamDedGan_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamDedGan_Enabled), 5, 0), !bGXsfl_203_Refreshing);
            edtMigrLegFamAdh_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MIGRLEGFAMADH_"+sGXsfl_203_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamAdh_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamAdh_Enabled), 5, 0), !bGXsfl_203_Refreshing);
            edtMigrLegFamDiscap_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MIGRLEGFAMDISCAP_"+sGXsfl_203_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamDiscap_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamDiscap_Enabled), 5, 0), !bGXsfl_203_Refreshing);
            if ( ( nRcdExists_262 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal01262( ) ;
            }
            sendRow01262( ) ;
            bGXsfl_203_Refreshing = false ;
         }
         Gx_mode = sMode262 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A634MigrLegOSAfip = B634MigrLegOSAfip ;
         httpContext.ajax_rsp_assign_attri("", false, "A634MigrLegOSAfip", A634MigrLegOSAfip);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount262 = (short)(5) ;
         nRcdExists_262 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart01262( ) ;
            while ( RcdFound262 != 0 )
            {
               sGXsfl_203_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_203_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_203262( ) ;
               init_level_properties262( ) ;
               standaloneNotModal01262( ) ;
               getByPrimaryKey01262( ) ;
               standaloneModal01262( ) ;
               addRow01262( ) ;
               scanNext01262( ) ;
            }
            scanEnd01262( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode262 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_203_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_203_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_203262( ) ;
         initAll01262( ) ;
         init_level_properties262( ) ;
         B634MigrLegOSAfip = A634MigrLegOSAfip ;
         httpContext.ajax_rsp_assign_attri("", false, "A634MigrLegOSAfip", A634MigrLegOSAfip);
         nRcdExists_262 = (short)(0) ;
         nIsMod_262 = (short)(0) ;
         nRcdDeleted_262 = (short)(0) ;
         nBlankRcdCount262 = (short)(nBlankRcdUsr262+nBlankRcdCount262) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount262 > 0 )
         {
            standaloneNotModal01262( ) ;
            standaloneModal01262( ) ;
            addRow01262( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtMigrLegFamParen_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount262 = (short)(nBlankRcdCount262-1) ;
         }
         Gx_mode = sMode262 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         A634MigrLegOSAfip = B634MigrLegOSAfip ;
         httpContext.ajax_rsp_assign_attri("", false, "A634MigrLegOSAfip", A634MigrLegOSAfip);
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
      httpContext.writeText( "</td>") ;
      httpContext.writeText( "</tr>") ;
      /* End of table */
      httpContext.writeText( "</table>") ;
      httpContext.writeText( "</fieldset>") ;
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 219,'',false,'',0)\"" ;
      ClassString = "ButtonColorFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_enter_Internalname, "", httpContext.getMessage( "GX_BtnEnter", ""), bttBtntrn_enter_Jsonclick, 5, httpContext.getMessage( "GX_BtnEnter", ""), "", StyleString, ClassString, bttBtntrn_enter_Visible, bttBtntrn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_importacion_legajo.htm");
      web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 221,'',false,'',0)\"" ;
      ClassString = "ButtonColorNotFilled" ;
      StyleString = "" ;
      web.GxWebStd.gx_button_ctrl( httpContext, bttBtntrn_cancel_Internalname, "", httpContext.getMessage( "GX_BtnCancel", ""), bttBtntrn_cancel_Jsonclick, 1, httpContext.getMessage( "GX_BtnCancel", ""), "", StyleString, ClassString, bttBtntrn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_importacion_legajo.htm");
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
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 225,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtCliCod_Internalname, GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CliCod), "ZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,225);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCliCod_Jsonclick, 0, "Attribute", "", "", "", "", edtCliCod_Visible, edtCliCod_Enabled, 1, "text", "1", 6, "chr", 1, "row", 6, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_importacion_legajo.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 226,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtEmpCod_Internalname, GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A1EmpCod), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,226);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtEmpCod_Jsonclick, 0, "Attribute", "", "", "", "", edtEmpCod_Visible, edtEmpCod_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoChico", "right", false, "", "HLP_importacion_legajo.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 227,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegNumero_Internalname, GXutil.ltrim( localUtil.ntoc( A87MigrLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A87MigrLegNumero), "ZZZZZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,227);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegNumero_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegNumero_Visible, edtMigrLegNumero_Enabled, 1, "text", "1", 8, "chr", 1, "row", 8, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "CodigoMedio", "right", false, "", "HLP_importacion_legajo.htm");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 228,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegZona_Internalname, A620MigrLegZona, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,228);\"", (short)(0), edtMigrLegZona_Visible, edtMigrLegZona_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajo.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 229,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegDiscapacidad_Internalname, GXutil.rtrim( A598MigrLegDiscapacidad), GXutil.rtrim( localUtil.format( A598MigrLegDiscapacidad, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,229);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegDiscapacidad_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegDiscapacidad_Visible, edtMigrLegDiscapacidad_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajo.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 230,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegLugarDePago_Internalname, A606MigrLegLugarDePago, GXutil.rtrim( localUtil.format( A606MigrLegLugarDePago, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,230);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegLugarDePago_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegLugarDePago_Visible, edtMigrLegLugarDePago_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionCorta", "left", true, "", "HLP_importacion_legajo.htm");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 231,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegBanco_Internalname, A610MigrLegBanco, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,231);\"", (short)(0), edtMigrLegBanco_Visible, edtMigrLegBanco_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajo.htm");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 232,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegBanSuc_Internalname, A611MigrLegBanSuc, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,232);\"", (short)(0), edtMigrLegBanSuc_Visible, edtMigrLegBanSuc_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajo.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 233,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegBanTipCuen_Internalname, A612MigrLegBanTipCuen, GXutil.rtrim( localUtil.format( A612MigrLegBanTipCuen, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,233);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegBanTipCuen_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegBanTipCuen_Visible, edtMigrLegBanTipCuen_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionCorta", "left", true, "", "HLP_importacion_legajo.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 234,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegCuentaBanc_Internalname, A619MigrLegCuentaBanc, GXutil.rtrim( localUtil.format( A619MigrLegCuentaBanc, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,234);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegCuentaBanc_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegCuentaBanc_Visible, edtMigrLegCuentaBanc_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionCorta", "left", true, "", "HLP_importacion_legajo.htm");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 235,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegFormaPago_Internalname, A609MigrLegFormaPago, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,235);\"", (short)(0), edtMigrLegFormaPago_Visible, edtMigrLegFormaPago_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajo.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 236,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegActividad_Internalname, A616MigrLegActividad, GXutil.rtrim( localUtil.format( A616MigrLegActividad, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,236);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegActividad_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegActividad_Visible, edtMigrLegActividad_Enabled, 0, "text", "", 80, "chr", 1, "row", 150, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajo.htm");
      drawcontrols1( ) ;
   }

   public void drawcontrols1( )
   {
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 237,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegSituacionRevista_Internalname, A623MigrLegSituacionRevista, GXutil.rtrim( localUtil.format( A623MigrLegSituacionRevista, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,237);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegSituacionRevista_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegSituacionRevista_Visible, edtMigrLegSituacionRevista_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionLarga", "left", true, "", "HLP_importacion_legajo.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 238,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegCondicion_Internalname, A624MigrLegCondicion, GXutil.rtrim( localUtil.format( A624MigrLegCondicion, "@!")), TempTags+" onchange=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"this.value=this.value.toUpperCase();"+";gx.evt.onblur(this,238);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegCondicion_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegCondicion_Visible, edtMigrLegCondicion_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "DescripcionLarga", "left", true, "", "HLP_importacion_legajo.htm");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 239,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegSiniestrado_Internalname, A625MigrLegSiniestrado, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,239);\"", (short)(0), edtMigrLegSiniestrado_Visible, edtMigrLegSiniestrado_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajo.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 240,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrLegSCVO_Internalname, GXutil.rtrim( A622MigrLegSCVO), GXutil.rtrim( localUtil.format( A622MigrLegSCVO, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,240);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrLegSCVO_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrLegSCVO_Visible, edtMigrLegSCVO_Enabled, 0, "text", "", 2, "chr", 1, "row", 2, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajo.htm");
      /* Multiple line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 241,'',false,'',0)\"" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      ClassString = "Attribute" ;
      StyleString = "" ;
      web.GxWebStd.gx_html_textarea( httpContext, edtMigrLegPlanMedico_Internalname, A615MigrLegPlanMedico, "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,241);\"", (short)(0), edtMigrLegPlanMedico_Visible, edtMigrLegPlanMedico_Enabled, 0, 80, "chr", 5, "row", (byte)(0), StyleString, ClassString, "", "", "400", -1, 0, "", "", (byte)(-1), true, "DescripcionEnorme", "'"+""+"'"+",false,"+"'"+""+"'", 0, "HLP_importacion_legajo.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 242,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrTieneConyuge_Internalname, GXutil.rtrim( A631MigrTieneConyuge), GXutil.rtrim( localUtil.format( A631MigrTieneConyuge, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,242);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrTieneConyuge_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrTieneConyuge_Visible, edtMigrTieneConyuge_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_importacion_legajo.htm");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 243,'',false,'',0)\"" ;
      web.GxWebStd.gx_single_line_edit( httpContext, edtMigrCantidadHijos_Internalname, GXutil.ltrim( localUtil.ntoc( A632MigrCantidadHijos, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtMigrCantidadHijos_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A632MigrCantidadHijos), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A632MigrCantidadHijos), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,gx.thousandSeparator);"+";gx.evt.onblur(this,243);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtMigrCantidadHijos_Jsonclick, 0, "Attribute", "", "", "", "", edtMigrCantidadHijos_Visible, edtMigrCantidadHijos_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_importacion_legajo.htm");
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
      e11012 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "Z3CliCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "Z1EmpCod"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z87MigrLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "Z87MigrLegNumero"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z592MigrLegApellido = httpContext.cgiGet( "Z592MigrLegApellido") ;
            Z593MigrLegNombre = httpContext.cgiGet( "Z593MigrLegNombre") ;
            Z594MigrLegFecNac = localUtil.ctod( httpContext.cgiGet( "Z594MigrLegFecNac"), 0) ;
            Z595MigrLegSexo = httpContext.cgiGet( "Z595MigrLegSexo") ;
            Z596MigrLegEstadoCivil = httpContext.cgiGet( "Z596MigrLegEstadoCivil") ;
            Z597MigrLegCUIL = httpContext.cgiGet( "Z597MigrLegCUIL") ;
            Z598MigrLegDiscapacidad = httpContext.cgiGet( "Z598MigrLegDiscapacidad") ;
            Z599MigrLegDomici = httpContext.cgiGet( "Z599MigrLegDomici") ;
            Z600MigrLegEmail = httpContext.cgiGet( "Z600MigrLegEmail") ;
            Z601MigrLegCodPos = httpContext.cgiGet( "Z601MigrLegCodPos") ;
            Z602MigrLegTelefono = httpContext.cgiGet( "Z602MigrLegTelefono") ;
            Z603MigrLegFecIngreso = localUtil.ctod( httpContext.cgiGet( "Z603MigrLegFecIngreso"), 0) ;
            Z604MigrLegCategoria = httpContext.cgiGet( "Z604MigrLegCategoria") ;
            Z605MigrLegArea = httpContext.cgiGet( "Z605MigrLegArea") ;
            Z606MigrLegLugarDePago = httpContext.cgiGet( "Z606MigrLegLugarDePago") ;
            Z2415MigrLegModTra = httpContext.cgiGet( "Z2415MigrLegModTra") ;
            Z2427MigrLegTipoTarifa = httpContext.cgiGet( "Z2427MigrLegTipoTarifa") ;
            Z607MigrLegClase = httpContext.cgiGet( "Z607MigrLegClase") ;
            Z608MigrLegBasico = localUtil.ctond( httpContext.cgiGet( "Z608MigrLegBasico")) ;
            Z609MigrLegFormaPago = httpContext.cgiGet( "Z609MigrLegFormaPago") ;
            Z691MigrLegClaseDef = GXutil.strtobool( httpContext.cgiGet( "Z691MigrLegClaseDef")) ;
            Z610MigrLegBanco = httpContext.cgiGet( "Z610MigrLegBanco") ;
            Z611MigrLegBanSuc = httpContext.cgiGet( "Z611MigrLegBanSuc") ;
            Z612MigrLegBanTipCuen = httpContext.cgiGet( "Z612MigrLegBanTipCuen") ;
            Z613MigrLegSindicato = httpContext.cgiGet( "Z613MigrLegSindicato") ;
            Z614MigrLegObraSocial = httpContext.cgiGet( "Z614MigrLegObraSocial") ;
            Z634MigrLegOSAfip = httpContext.cgiGet( "Z634MigrLegOSAfip") ;
            Z615MigrLegPlanMedico = httpContext.cgiGet( "Z615MigrLegPlanMedico") ;
            Z616MigrLegActividad = httpContext.cgiGet( "Z616MigrLegActividad") ;
            Z617MigrLegModalidad = httpContext.cgiGet( "Z617MigrLegModalidad") ;
            Z618MigrLegFecUltMod = localUtil.ctod( httpContext.cgiGet( "Z618MigrLegFecUltMod"), 0) ;
            Z619MigrLegCuentaBanc = httpContext.cgiGet( "Z619MigrLegCuentaBanc") ;
            Z620MigrLegZona = httpContext.cgiGet( "Z620MigrLegZona") ;
            Z621MigrLegCBU = httpContext.cgiGet( "Z621MigrLegCBU") ;
            Z622MigrLegSCVO = httpContext.cgiGet( "Z622MigrLegSCVO") ;
            Z623MigrLegSituacionRevista = httpContext.cgiGet( "Z623MigrLegSituacionRevista") ;
            Z624MigrLegCondicion = httpContext.cgiGet( "Z624MigrLegCondicion") ;
            Z625MigrLegSiniestrado = httpContext.cgiGet( "Z625MigrLegSiniestrado") ;
            Z626MigrLegId = httpContext.cgiGet( "Z626MigrLegId") ;
            Z627MigrLegConvenio = httpContext.cgiGet( "Z627MigrLegConvenio") ;
            Z631MigrTieneConyuge = httpContext.cgiGet( "Z631MigrTieneConyuge") ;
            Z632MigrCantidadHijos = (short)(localUtil.ctol( httpContext.cgiGet( "Z632MigrCantidadHijos"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Z635MigrEncontroOsoSigla = GXutil.strtobool( httpContext.cgiGet( "Z635MigrEncontroOsoSigla")) ;
            Z1398MigrTraDiurno = httpContext.cgiGet( "Z1398MigrTraDiurno") ;
            Z1399MigrTraNoct = httpContext.cgiGet( "Z1399MigrTraNoct") ;
            Z1400MigrTraIns = httpContext.cgiGet( "Z1400MigrTraIns") ;
            Z1820MigrEncontroOsoAfip = GXutil.strtobool( httpContext.cgiGet( "Z1820MigrEncontroOsoAfip")) ;
            Z2190MigrPeriodo = localUtil.ctod( httpContext.cgiGet( "Z2190MigrPeriodo"), 0) ;
            Z695MigrLegModalidadDef = GXutil.strtobool( httpContext.cgiGet( "Z695MigrLegModalidadDef")) ;
            Z696MigrLegZonaDef = GXutil.strtobool( httpContext.cgiGet( "Z696MigrLegZonaDef")) ;
            Z698MigrLegSituacionDef = GXutil.strtobool( httpContext.cgiGet( "Z698MigrLegSituacionDef")) ;
            Z690MigrLegEstadoCivilDef = GXutil.strtobool( httpContext.cgiGet( "Z690MigrLegEstadoCivilDef")) ;
            Z692MigrLegFormaPagoDef = GXutil.strtobool( httpContext.cgiGet( "Z692MigrLegFormaPagoDef")) ;
            Z693MigrLegTipoCuentaDef = GXutil.strtobool( httpContext.cgiGet( "Z693MigrLegTipoCuentaDef")) ;
            Z694MigrLegActividadDef = GXutil.strtobool( httpContext.cgiGet( "Z694MigrLegActividadDef")) ;
            Z699MigrLegCondicionDef = GXutil.strtobool( httpContext.cgiGet( "Z699MigrLegCondicionDef")) ;
            Z700MigrLegSiniestradoDef = GXutil.strtobool( httpContext.cgiGet( "Z700MigrLegSiniestradoDef")) ;
            Z2197MigrValCadaSave = GXutil.strtobool( httpContext.cgiGet( "Z2197MigrValCadaSave")) ;
            Z2205MigrLegFecEgreso = localUtil.ctod( httpContext.cgiGet( "Z2205MigrLegFecEgreso"), 0) ;
            Z2216MigrPuesto = httpContext.cgiGet( "Z2216MigrPuesto") ;
            Z2221MigrLegMarcaCCT = httpContext.cgiGet( "Z2221MigrLegMarcaCCT") ;
            n2221MigrLegMarcaCCT = ((GXutil.strcmp("", A2221MigrLegMarcaCCT)==0) ? true : false) ;
            Z2222MigrArchSec = (short)(localUtil.ctol( httpContext.cgiGet( "Z2222MigrArchSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n2222MigrArchSec = ((0==A2222MigrArchSec) ? true : false) ;
            Z2239MigrLegActLabClas = httpContext.cgiGet( "Z2239MigrLegActLabClas") ;
            Z2240MigrLegPueAfip = httpContext.cgiGet( "Z2240MigrLegPueAfip") ;
            Z2275MigrLegHorSem = localUtil.ctond( httpContext.cgiGet( "Z2275MigrLegHorSem")) ;
            A691MigrLegClaseDef = GXutil.strtobool( httpContext.cgiGet( "Z691MigrLegClaseDef")) ;
            A618MigrLegFecUltMod = localUtil.ctod( httpContext.cgiGet( "Z618MigrLegFecUltMod"), 0) ;
            A635MigrEncontroOsoSigla = GXutil.strtobool( httpContext.cgiGet( "Z635MigrEncontroOsoSigla")) ;
            A1398MigrTraDiurno = httpContext.cgiGet( "Z1398MigrTraDiurno") ;
            A1399MigrTraNoct = httpContext.cgiGet( "Z1399MigrTraNoct") ;
            A1400MigrTraIns = httpContext.cgiGet( "Z1400MigrTraIns") ;
            A1820MigrEncontroOsoAfip = GXutil.strtobool( httpContext.cgiGet( "Z1820MigrEncontroOsoAfip")) ;
            A2190MigrPeriodo = localUtil.ctod( httpContext.cgiGet( "Z2190MigrPeriodo"), 0) ;
            A695MigrLegModalidadDef = GXutil.strtobool( httpContext.cgiGet( "Z695MigrLegModalidadDef")) ;
            A696MigrLegZonaDef = GXutil.strtobool( httpContext.cgiGet( "Z696MigrLegZonaDef")) ;
            A698MigrLegSituacionDef = GXutil.strtobool( httpContext.cgiGet( "Z698MigrLegSituacionDef")) ;
            A690MigrLegEstadoCivilDef = GXutil.strtobool( httpContext.cgiGet( "Z690MigrLegEstadoCivilDef")) ;
            A692MigrLegFormaPagoDef = GXutil.strtobool( httpContext.cgiGet( "Z692MigrLegFormaPagoDef")) ;
            A693MigrLegTipoCuentaDef = GXutil.strtobool( httpContext.cgiGet( "Z693MigrLegTipoCuentaDef")) ;
            A694MigrLegActividadDef = GXutil.strtobool( httpContext.cgiGet( "Z694MigrLegActividadDef")) ;
            A699MigrLegCondicionDef = GXutil.strtobool( httpContext.cgiGet( "Z699MigrLegCondicionDef")) ;
            A700MigrLegSiniestradoDef = GXutil.strtobool( httpContext.cgiGet( "Z700MigrLegSiniestradoDef")) ;
            A2197MigrValCadaSave = GXutil.strtobool( httpContext.cgiGet( "Z2197MigrValCadaSave")) ;
            A2205MigrLegFecEgreso = localUtil.ctod( httpContext.cgiGet( "Z2205MigrLegFecEgreso"), 0) ;
            A2216MigrPuesto = httpContext.cgiGet( "Z2216MigrPuesto") ;
            A2221MigrLegMarcaCCT = httpContext.cgiGet( "Z2221MigrLegMarcaCCT") ;
            n2221MigrLegMarcaCCT = false ;
            n2221MigrLegMarcaCCT = ((GXutil.strcmp("", A2221MigrLegMarcaCCT)==0) ? true : false) ;
            A2222MigrArchSec = (short)(localUtil.ctol( httpContext.cgiGet( "Z2222MigrArchSec"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n2222MigrArchSec = false ;
            n2222MigrArchSec = ((0==A2222MigrArchSec) ? true : false) ;
            A2239MigrLegActLabClas = httpContext.cgiGet( "Z2239MigrLegActLabClas") ;
            A2240MigrLegPueAfip = httpContext.cgiGet( "Z2240MigrLegPueAfip") ;
            A2275MigrLegHorSem = localUtil.ctond( httpContext.cgiGet( "Z2275MigrLegHorSem")) ;
            O634MigrLegOSAfip = httpContext.cgiGet( "O634MigrLegOSAfip") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_203 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_203"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            N634MigrLegOSAfip = httpContext.cgiGet( "N634MigrLegOSAfip") ;
            AV7CliCod = (int)(localUtil.ctol( httpContext.cgiGet( "vCLICOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV18EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( "vEMPCOD"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV40MigrLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( "vMIGRLEGNUMERO"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV64AuxMigrLegCategoria = httpContext.cgiGet( "vAUXMIGRLEGCATEGORIA") ;
            AV65LegNumeroPorId = (int)(localUtil.ctol( httpContext.cgiGet( "vLEGNUMEROPORID"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV62LegNomApe = httpContext.cgiGet( "vLEGNOMAPE") ;
            AV66LegNumeroPorCUIL = (int)(localUtil.ctol( httpContext.cgiGet( "vLEGNUMEROPORCUIL"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            AV63LegIdNomApe = httpContext.cgiGet( "vLEGIDNOMAPE") ;
            A691MigrLegClaseDef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGCLASEDEF")) ;
            A618MigrLegFecUltMod = localUtil.ctod( httpContext.cgiGet( "MIGRLEGFECULTMOD"), 0) ;
            A629MigrLegErrores = httpContext.cgiGet( "MIGRLEGERRORES") ;
            A633MigrLegWarnings = httpContext.cgiGet( "MIGRLEGWARNINGS") ;
            A635MigrEncontroOsoSigla = GXutil.strtobool( httpContext.cgiGet( "MIGRENCONTROOSOSIGLA")) ;
            A1398MigrTraDiurno = httpContext.cgiGet( "MIGRTRADIURNO") ;
            A1399MigrTraNoct = httpContext.cgiGet( "MIGRTRANOCT") ;
            A1400MigrTraIns = httpContext.cgiGet( "MIGRTRAINS") ;
            A1820MigrEncontroOsoAfip = GXutil.strtobool( httpContext.cgiGet( "MIGRENCONTROOSOAFIP")) ;
            A2189MigrSueldos = httpContext.cgiGet( "MIGRSUELDOS") ;
            A2190MigrPeriodo = localUtil.ctod( httpContext.cgiGet( "MIGRPERIODO"), 0) ;
            A695MigrLegModalidadDef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGMODALIDADDEF")) ;
            A696MigrLegZonaDef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGZONADEF")) ;
            A698MigrLegSituacionDef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGSITUACIONDEF")) ;
            A690MigrLegEstadoCivilDef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGESTADOCIVILDEF")) ;
            A692MigrLegFormaPagoDef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGFORMAPAGODEF")) ;
            A693MigrLegTipoCuentaDef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGTIPOCUENTADEF")) ;
            A694MigrLegActividadDef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGACTIVIDADDEF")) ;
            A699MigrLegCondicionDef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGCONDICIONDEF")) ;
            A700MigrLegSiniestradoDef = GXutil.strtobool( httpContext.cgiGet( "MIGRLEGSINIESTRADODEF")) ;
            A2197MigrValCadaSave = GXutil.strtobool( httpContext.cgiGet( "MIGRVALCADASAVE")) ;
            A2205MigrLegFecEgreso = localUtil.ctod( httpContext.cgiGet( "MIGRLEGFECEGRESO"), 0) ;
            A2206MigrOtrosDatos = httpContext.cgiGet( "MIGROTROSDATOS") ;
            A2216MigrPuesto = httpContext.cgiGet( "MIGRPUESTO") ;
            A2221MigrLegMarcaCCT = httpContext.cgiGet( "MIGRLEGMARCACCT") ;
            n2221MigrLegMarcaCCT = ((GXutil.strcmp("", A2221MigrLegMarcaCCT)==0) ? true : false) ;
            A2222MigrArchSec = (short)(localUtil.ctol( httpContext.cgiGet( "MIGRARCHSEC"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
            n2222MigrArchSec = ((0==A2222MigrArchSec) ? true : false) ;
            A2239MigrLegActLabClas = httpContext.cgiGet( "MIGRLEGACTLABCLAS") ;
            A2240MigrLegPueAfip = httpContext.cgiGet( "MIGRLEGPUEAFIP") ;
            A2275MigrLegHorSem = localUtil.ctond( httpContext.cgiGet( "MIGRLEGHORSEM")) ;
            AV69Pgmname = httpContext.cgiGet( "vPGMNAME") ;
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
            /* Read variables values. */
            A626MigrLegId = httpContext.cgiGet( edtMigrLegId_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A626MigrLegId", A626MigrLegId);
            A597MigrLegCUIL = httpContext.cgiGet( edtMigrLegCUIL_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A597MigrLegCUIL", A597MigrLegCUIL);
            A592MigrLegApellido = httpContext.cgiGet( edtMigrLegApellido_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A592MigrLegApellido", A592MigrLegApellido);
            A593MigrLegNombre = httpContext.cgiGet( edtMigrLegNombre_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A593MigrLegNombre", A593MigrLegNombre);
            A2415MigrLegModTra = httpContext.cgiGet( edtMigrLegModTra_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2415MigrLegModTra", A2415MigrLegModTra);
            A2427MigrLegTipoTarifa = httpContext.cgiGet( edtMigrLegTipoTarifa_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A2427MigrLegTipoTarifa", A2427MigrLegTipoTarifa);
            A607MigrLegClase = httpContext.cgiGet( edtMigrLegClase_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A607MigrLegClase", A607MigrLegClase);
            if ( localUtil.vcdate( httpContext.cgiGet( edtMigrLegFecNac_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "MIGRLEGFECNAC");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMigrLegFecNac_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A594MigrLegFecNac = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A594MigrLegFecNac", localUtil.format(A594MigrLegFecNac, "99/99/9999"));
            }
            else
            {
               A594MigrLegFecNac = localUtil.ctod( httpContext.cgiGet( edtMigrLegFecNac_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A594MigrLegFecNac", localUtil.format(A594MigrLegFecNac, "99/99/9999"));
            }
            if ( localUtil.vcdate( httpContext.cgiGet( edtMigrLegFecIngreso_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, "MIGRLEGFECINGRESO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMigrLegFecIngreso_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A603MigrLegFecIngreso = GXutil.nullDate() ;
               httpContext.ajax_rsp_assign_attri("", false, "A603MigrLegFecIngreso", localUtil.format(A603MigrLegFecIngreso, "99/99/9999"));
            }
            else
            {
               A603MigrLegFecIngreso = localUtil.ctod( httpContext.cgiGet( edtMigrLegFecIngreso_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A603MigrLegFecIngreso", localUtil.format(A603MigrLegFecIngreso, "99/99/9999"));
            }
            A595MigrLegSexo = httpContext.cgiGet( edtMigrLegSexo_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A595MigrLegSexo", A595MigrLegSexo);
            A599MigrLegDomici = httpContext.cgiGet( edtMigrLegDomici_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A599MigrLegDomici", A599MigrLegDomici);
            A601MigrLegCodPos = httpContext.cgiGet( edtMigrLegCodPos_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A601MigrLegCodPos", A601MigrLegCodPos);
            A602MigrLegTelefono = httpContext.cgiGet( edtMigrLegTelefono_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A602MigrLegTelefono", A602MigrLegTelefono);
            A600MigrLegEmail = httpContext.cgiGet( edtMigrLegEmail_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A600MigrLegEmail", A600MigrLegEmail);
            A596MigrLegEstadoCivil = httpContext.cgiGet( edtMigrLegEstadoCivil_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A596MigrLegEstadoCivil", A596MigrLegEstadoCivil);
            cmbMigrLegSindicato.setName( cmbMigrLegSindicato.getInternalname() );
            cmbMigrLegSindicato.setValue( httpContext.cgiGet( cmbMigrLegSindicato.getInternalname()) );
            A613MigrLegSindicato = httpContext.cgiGet( cmbMigrLegSindicato.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A613MigrLegSindicato", A613MigrLegSindicato);
            cmbMigrLegConvenio.setName( cmbMigrLegConvenio.getInternalname() );
            cmbMigrLegConvenio.setValue( httpContext.cgiGet( cmbMigrLegConvenio.getInternalname()) );
            A627MigrLegConvenio = httpContext.cgiGet( cmbMigrLegConvenio.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A627MigrLegConvenio", A627MigrLegConvenio);
            cmbMigrLegCategoria.setName( cmbMigrLegCategoria.getInternalname() );
            cmbMigrLegCategoria.setValue( httpContext.cgiGet( cmbMigrLegCategoria.getInternalname()) );
            A604MigrLegCategoria = httpContext.cgiGet( cmbMigrLegCategoria.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A604MigrLegCategoria", A604MigrLegCategoria);
            cmbMigrLegArea.setName( cmbMigrLegArea.getInternalname() );
            cmbMigrLegArea.setValue( httpContext.cgiGet( cmbMigrLegArea.getInternalname()) );
            A605MigrLegArea = httpContext.cgiGet( cmbMigrLegArea.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A605MigrLegArea", A605MigrLegArea);
            if ( ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtMigrLegBasico_Internalname)), DecimalUtil.stringToDec("-9999999999.99")) < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtMigrLegBasico_Internalname)), DecimalUtil.stringToDec("99999999999.99")) > 0 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "MIGRLEGBASICO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMigrLegBasico_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A608MigrLegBasico = DecimalUtil.ZERO ;
               httpContext.ajax_rsp_assign_attri("", false, "A608MigrLegBasico", GXutil.ltrimstr( A608MigrLegBasico, 14, 2));
            }
            else
            {
               A608MigrLegBasico = localUtil.ctond( httpContext.cgiGet( edtMigrLegBasico_Internalname)) ;
               httpContext.ajax_rsp_assign_attri("", false, "A608MigrLegBasico", GXutil.ltrimstr( A608MigrLegBasico, 14, 2));
            }
            cmbMigrLegObraSocial.setName( cmbMigrLegObraSocial.getInternalname() );
            cmbMigrLegObraSocial.setValue( httpContext.cgiGet( cmbMigrLegObraSocial.getInternalname()) );
            A614MigrLegObraSocial = httpContext.cgiGet( cmbMigrLegObraSocial.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A614MigrLegObraSocial", A614MigrLegObraSocial);
            A634MigrLegOSAfip = httpContext.cgiGet( edtMigrLegOSAfip_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A634MigrLegOSAfip", A634MigrLegOSAfip);
            A621MigrLegCBU = httpContext.cgiGet( edtMigrLegCBU_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A621MigrLegCBU", A621MigrLegCBU);
            cmbMigrLegModalidad.setName( cmbMigrLegModalidad.getInternalname() );
            cmbMigrLegModalidad.setValue( httpContext.cgiGet( cmbMigrLegModalidad.getInternalname()) );
            A617MigrLegModalidad = httpContext.cgiGet( cmbMigrLegModalidad.getInternalname()) ;
            httpContext.ajax_rsp_assign_attri("", false, "A617MigrLegModalidad", A617MigrLegModalidad);
            A628MigrLegObs = httpContext.cgiGet( edtMigrLegObs_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A628MigrLegObs", A628MigrLegObs);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A3CliCod = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            else
            {
               A3CliCod = (int)(localUtil.ctol( httpContext.cgiGet( edtCliCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "EMPCOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtEmpCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A1EmpCod = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            }
            else
            {
               A1EmpCod = (short)(localUtil.ctol( httpContext.cgiGet( edtEmpCod_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            }
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtMigrLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtMigrLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 99999999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "MIGRLEGNUMERO");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMigrLegNumero_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A87MigrLegNumero = 0 ;
               httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
            }
            else
            {
               A87MigrLegNumero = (int)(localUtil.ctol( httpContext.cgiGet( edtMigrLegNumero_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
            }
            A620MigrLegZona = httpContext.cgiGet( edtMigrLegZona_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A620MigrLegZona", A620MigrLegZona);
            A598MigrLegDiscapacidad = httpContext.cgiGet( edtMigrLegDiscapacidad_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A598MigrLegDiscapacidad", A598MigrLegDiscapacidad);
            A606MigrLegLugarDePago = GXutil.upper( httpContext.cgiGet( edtMigrLegLugarDePago_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A606MigrLegLugarDePago", A606MigrLegLugarDePago);
            A610MigrLegBanco = httpContext.cgiGet( edtMigrLegBanco_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A610MigrLegBanco", A610MigrLegBanco);
            A611MigrLegBanSuc = httpContext.cgiGet( edtMigrLegBanSuc_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A611MigrLegBanSuc", A611MigrLegBanSuc);
            A612MigrLegBanTipCuen = GXutil.upper( httpContext.cgiGet( edtMigrLegBanTipCuen_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A612MigrLegBanTipCuen", A612MigrLegBanTipCuen);
            A619MigrLegCuentaBanc = GXutil.upper( httpContext.cgiGet( edtMigrLegCuentaBanc_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A619MigrLegCuentaBanc", A619MigrLegCuentaBanc);
            A609MigrLegFormaPago = httpContext.cgiGet( edtMigrLegFormaPago_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A609MigrLegFormaPago", A609MigrLegFormaPago);
            A616MigrLegActividad = httpContext.cgiGet( edtMigrLegActividad_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A616MigrLegActividad", A616MigrLegActividad);
            A623MigrLegSituacionRevista = GXutil.upper( httpContext.cgiGet( edtMigrLegSituacionRevista_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A623MigrLegSituacionRevista", A623MigrLegSituacionRevista);
            A624MigrLegCondicion = GXutil.upper( httpContext.cgiGet( edtMigrLegCondicion_Internalname)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A624MigrLegCondicion", A624MigrLegCondicion);
            A625MigrLegSiniestrado = httpContext.cgiGet( edtMigrLegSiniestrado_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A625MigrLegSiniestrado", A625MigrLegSiniestrado);
            A622MigrLegSCVO = httpContext.cgiGet( edtMigrLegSCVO_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A622MigrLegSCVO", A622MigrLegSCVO);
            A615MigrLegPlanMedico = httpContext.cgiGet( edtMigrLegPlanMedico_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A615MigrLegPlanMedico", A615MigrLegPlanMedico);
            A631MigrTieneConyuge = httpContext.cgiGet( edtMigrTieneConyuge_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A631MigrTieneConyuge", A631MigrTieneConyuge);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtMigrCantidadHijos_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtMigrCantidadHijos_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep")) > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "MIGRCANTIDADHIJOS");
               AnyError = (short)(1) ;
               GX_FocusControl = edtMigrCantidadHijos_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A632MigrCantidadHijos = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A632MigrCantidadHijos", GXutil.ltrimstr( DecimalUtil.doubleToDec(A632MigrCantidadHijos), 4, 0));
            }
            else
            {
               A632MigrCantidadHijos = (short)(localUtil.ctol( httpContext.cgiGet( edtMigrCantidadHijos_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A632MigrCantidadHijos", GXutil.ltrimstr( DecimalUtil.doubleToDec(A632MigrCantidadHijos), 4, 0));
            }
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"importacion_legajo");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("MigrLegClaseDef", GXutil.booltostr( A691MigrLegClaseDef));
            forbiddenHiddens.add("MigrLegFecUltMod", localUtil.format(A618MigrLegFecUltMod, "99/99/9999"));
            forbiddenHiddens.add("MigrEncontroOsoSigla", GXutil.booltostr( A635MigrEncontroOsoSigla));
            forbiddenHiddens.add("MigrTraDiurno", GXutil.rtrim( localUtil.format( A1398MigrTraDiurno, "")));
            forbiddenHiddens.add("MigrTraNoct", GXutil.rtrim( localUtil.format( A1399MigrTraNoct, "")));
            forbiddenHiddens.add("MigrTraIns", GXutil.rtrim( localUtil.format( A1400MigrTraIns, "")));
            forbiddenHiddens.add("MigrEncontroOsoAfip", GXutil.booltostr( A1820MigrEncontroOsoAfip));
            forbiddenHiddens.add("MigrPeriodo", localUtil.format(A2190MigrPeriodo, "99/99/99"));
            forbiddenHiddens.add("MigrLegModalidadDef", GXutil.booltostr( A695MigrLegModalidadDef));
            forbiddenHiddens.add("MigrLegZonaDef", GXutil.booltostr( A696MigrLegZonaDef));
            forbiddenHiddens.add("MigrLegSituacionDef", GXutil.booltostr( A698MigrLegSituacionDef));
            forbiddenHiddens.add("MigrLegEstadoCivilDef", GXutil.booltostr( A690MigrLegEstadoCivilDef));
            forbiddenHiddens.add("MigrLegFormaPagoDef", GXutil.booltostr( A692MigrLegFormaPagoDef));
            forbiddenHiddens.add("MigrLegTipoCuentaDef", GXutil.booltostr( A693MigrLegTipoCuentaDef));
            forbiddenHiddens.add("MigrLegActividadDef", GXutil.booltostr( A694MigrLegActividadDef));
            forbiddenHiddens.add("MigrLegCondicionDef", GXutil.booltostr( A699MigrLegCondicionDef));
            forbiddenHiddens.add("MigrLegSiniestradoDef", GXutil.booltostr( A700MigrLegSiniestradoDef));
            forbiddenHiddens.add("MigrValCadaSave", GXutil.booltostr( A2197MigrValCadaSave));
            forbiddenHiddens.add("MigrLegFecEgreso", localUtil.format(A2205MigrLegFecEgreso, "99/99/99"));
            forbiddenHiddens.add("MigrPuesto", GXutil.rtrim( localUtil.format( A2216MigrPuesto, "")));
            forbiddenHiddens.add("MigrLegMarcaCCT", GXutil.rtrim( localUtil.format( A2221MigrLegMarcaCCT, "")));
            forbiddenHiddens.add("MigrArchSec", localUtil.format( DecimalUtil.doubleToDec(A2222MigrArchSec), "ZZZ9"));
            forbiddenHiddens.add("MigrLegActLabClas", GXutil.rtrim( localUtil.format( A2239MigrLegActLabClas, "")));
            forbiddenHiddens.add("MigrLegPueAfip", GXutil.rtrim( localUtil.format( A2240MigrLegPueAfip, "")));
            forbiddenHiddens.add("MigrLegHorSem", localUtil.format( A2275MigrLegHorSem, "Z9.9"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ( ! ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A87MigrLegNumero != Z87MigrLegNumero ) ) || ( GXutil.strcmp(Gx_mode, "INS") == 0 ) ) && ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("importacion_legajo:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
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
               A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A87MigrLegNumero = (int)(GXutil.lval( httpContext.GetPar( "MigrLegNumero"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode75 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode75 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound75 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_010( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtntrn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "CLICOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCliCod_Internalname ;
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
                        e11012 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12012 ();
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
         e12012 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll0175( ) ;
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
      if ( isDsp( ) || isDlt( ) )
      {
         if ( isDsp( ) )
         {
            bttBtntrn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtntrn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtntrn_enter_Visible), 5, 0), true);
         }
         disableAttributes0175( ) ;
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

   public void confirm_010( )
   {
      beforeValidate0175( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0175( ) ;
         }
         else
         {
            checkExtendedTable0175( ) ;
            closeExtendedTableCursors0175( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode75 = Gx_mode ;
         confirm_01262( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode75 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode75 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_01262( )
   {
      nGXsfl_203_idx = 0 ;
      while ( nGXsfl_203_idx < nRC_GXsfl_203 )
      {
         readRow01262( ) ;
         if ( ( nRcdExists_262 != 0 ) || ( nIsMod_262 != 0 ) )
         {
            getKey01262( ) ;
            if ( ( nRcdExists_262 == 0 ) && ( nRcdDeleted_262 == 0 ) )
            {
               if ( RcdFound262 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate01262( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable01262( ) ;
                     closeExtendedTableCursors01262( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "CLICOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCliCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound262 != 0 )
               {
                  if ( nRcdDeleted_262 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey01262( ) ;
                     load01262( ) ;
                     beforeValidate01262( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls01262( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_262 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate01262( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable01262( ) ;
                           closeExtendedTableCursors01262( ) ;
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
                  if ( nRcdDeleted_262 == 0 )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CLICOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCliCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtMigrLegFamSec_Internalname, GXutil.ltrim( localUtil.ntoc( A2078MigrLegFamSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtMigrLegFamParen_Internalname, A2079MigrLegFamParen) ;
         httpContext.changePostValue( edtMigrLegFamNroDoc_Internalname, A2080MigrLegFamNroDoc) ;
         httpContext.changePostValue( edtMigrLegFamNomApe_Internalname, A2088MigrLegFamNomApe) ;
         httpContext.changePostValue( edtMigrLegFamFecNac_Internalname, localUtil.format(A2089MigrLegFamFecNac, "99/99/9999")) ;
         httpContext.changePostValue( edtMigrLegFamDedGan_Internalname, GXutil.ltrim( localUtil.ntoc( A2081MigrLegFamDedGan, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtMigrLegFamAdh_Internalname, GXutil.rtrim( A2082MigrLegFamAdh)) ;
         httpContext.changePostValue( edtMigrLegFamDiscap_Internalname, GXutil.rtrim( A2086MigrLegFamDiscap)) ;
         httpContext.changePostValue( "ZT_"+"Z2078MigrLegFamSec_"+sGXsfl_203_idx, GXutil.ltrim( localUtil.ntoc( Z2078MigrLegFamSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2079MigrLegFamParen_"+sGXsfl_203_idx, Z2079MigrLegFamParen) ;
         httpContext.changePostValue( "ZT_"+"Z2080MigrLegFamNroDoc_"+sGXsfl_203_idx, Z2080MigrLegFamNroDoc) ;
         httpContext.changePostValue( "ZT_"+"Z2081MigrLegFamDedGan_"+sGXsfl_203_idx, GXutil.ltrim( localUtil.ntoc( Z2081MigrLegFamDedGan, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2082MigrLegFamAdh_"+sGXsfl_203_idx, GXutil.rtrim( Z2082MigrLegFamAdh)) ;
         httpContext.changePostValue( "ZT_"+"Z2086MigrLegFamDiscap_"+sGXsfl_203_idx, GXutil.rtrim( Z2086MigrLegFamDiscap)) ;
         httpContext.changePostValue( "ZT_"+"Z2088MigrLegFamNomApe_"+sGXsfl_203_idx, Z2088MigrLegFamNomApe) ;
         httpContext.changePostValue( "ZT_"+"Z2089MigrLegFamFecNac_"+sGXsfl_203_idx, localUtil.dtoc( Z2089MigrLegFamFecNac, 0, "/")) ;
         httpContext.changePostValue( "nRcdDeleted_262_"+sGXsfl_203_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_262, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_262_"+sGXsfl_203_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_262, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_262_"+sGXsfl_203_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_262, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_262 != 0 )
         {
            httpContext.changePostValue( "MIGRLEGFAMSEC_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamSec_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MIGRLEGFAMPAREN_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamParen_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MIGRLEGFAMNRODOC_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamNroDoc_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MIGRLEGFAMNOMAPE_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamNomApe_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MIGRLEGFAMFECNAC_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamFecNac_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MIGRLEGFAMDEDGAN_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamDedGan_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MIGRLEGFAMADH_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamAdh_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MIGRLEGFAMDISCAP_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamDiscap_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption010( )
   {
   }

   public void e11012( )
   {
      /* Start Routine */
      returnInSub = false ;
      new web.setopcionmenusesion(remoteHandle, context).execute( "", Gx_mode, "") ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
      GXv_SdtWWPContext1[0] = AV56WWPContext;
      new web.wwpbaseobjects.loadwwpcontext(remoteHandle, context).execute( GXv_SdtWWPContext1) ;
      AV56WWPContext = GXv_SdtWWPContext1[0] ;
      AV22IsAuthorized = true ;
      httpContext.ajax_rsp_assign_attri("", false, "AV22IsAuthorized", AV22IsAuthorized);
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         GXt_boolean2 = AV22IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_legajo_Insert", GXv_boolean3) ;
         importacion_legajo_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV22IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22IsAuthorized", AV22IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
      {
         GXt_boolean2 = AV22IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_legajo_Update", GXv_boolean3) ;
         importacion_legajo_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV22IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22IsAuthorized", AV22IsAuthorized);
      }
      if ( GXutil.strcmp(Gx_mode, "DLT") == 0 )
      {
         GXt_boolean2 = AV22IsAuthorized ;
         GXv_boolean3[0] = GXt_boolean2 ;
         new web.wwpbaseobjects.secisauthbyfunctionalitykey(remoteHandle, context).execute( "WWimportacion_legajo_Delete", GXv_boolean3) ;
         importacion_legajo_impl.this.GXt_boolean2 = GXv_boolean3[0] ;
         AV22IsAuthorized = GXt_boolean2 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV22IsAuthorized", AV22IsAuthorized);
      }
      if ( ! AV22IsAuthorized )
      {
         callWebObject(formatLink("web.wwpbaseobjects.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV69Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV54TrnContext.fromxml(AV55WebSession.getValue("TrnContext"), null, null);
      edtCliCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Visible), 5, 0), true);
      edtEmpCod_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Visible), 5, 0), true);
      edtMigrLegNumero_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegNumero_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegNumero_Visible), 5, 0), true);
      edtMigrLegZona_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegZona_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegZona_Visible), 5, 0), true);
      edtMigrLegDiscapacidad_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegDiscapacidad_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegDiscapacidad_Visible), 5, 0), true);
      edtMigrLegLugarDePago_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegLugarDePago_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegLugarDePago_Visible), 5, 0), true);
      edtMigrLegBanco_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegBanco_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegBanco_Visible), 5, 0), true);
      edtMigrLegBanSuc_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegBanSuc_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegBanSuc_Visible), 5, 0), true);
      edtMigrLegBanTipCuen_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegBanTipCuen_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegBanTipCuen_Visible), 5, 0), true);
      edtMigrLegCuentaBanc_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegCuentaBanc_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegCuentaBanc_Visible), 5, 0), true);
      edtMigrLegFormaPago_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFormaPago_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFormaPago_Visible), 5, 0), true);
      edtMigrLegActividad_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegActividad_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegActividad_Visible), 5, 0), true);
      edtMigrLegSituacionRevista_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegSituacionRevista_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSituacionRevista_Visible), 5, 0), true);
      edtMigrLegCondicion_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegCondicion_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegCondicion_Visible), 5, 0), true);
      edtMigrLegSiniestrado_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegSiniestrado_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSiniestrado_Visible), 5, 0), true);
      edtMigrLegSCVO_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegSCVO_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSCVO_Visible), 5, 0), true);
      edtMigrLegPlanMedico_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegPlanMedico_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegPlanMedico_Visible), 5, 0), true);
      edtMigrTieneConyuge_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrTieneConyuge_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrTieneConyuge_Visible), 5, 0), true);
      edtMigrCantidadHijos_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrCantidadHijos_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrCantidadHijos_Visible), 5, 0), true);
   }

   public void e12012( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      new web.msgdebug7(remoteHandle, context).execute( AV69Pgmname, httpContext.getMessage( "&Mode ", "")+Gx_mode) ;
      if ( ( A2197MigrValCadaSave ) && ( ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "INS", "")) == 0 ) || ( GXutil.strcmp(Gx_mode, httpContext.getMessage( "UPD", "")) == 0 ) ) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV69Pgmname, httpContext.getMessage( "llama a validarRegistroMigracion", "")) ;
         GXv_objcol_svchar4[0] = AV67errores ;
         GXv_objcol_svchar5[0] = AV68warnings ;
         new web.validarregistromigracion(remoteHandle, context).execute( A3CliCod, A1EmpCod, A87MigrLegNumero, false, false, (short)(0), GXv_objcol_svchar4, GXv_objcol_svchar5) ;
         AV67errores = GXv_objcol_svchar4[0] ;
         AV68warnings = GXv_objcol_svchar5[0] ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm0175( int GX_JID )
   {
      if ( ( GX_JID == 39 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z592MigrLegApellido = T00015_A592MigrLegApellido[0] ;
            Z593MigrLegNombre = T00015_A593MigrLegNombre[0] ;
            Z594MigrLegFecNac = T00015_A594MigrLegFecNac[0] ;
            Z595MigrLegSexo = T00015_A595MigrLegSexo[0] ;
            Z596MigrLegEstadoCivil = T00015_A596MigrLegEstadoCivil[0] ;
            Z597MigrLegCUIL = T00015_A597MigrLegCUIL[0] ;
            Z598MigrLegDiscapacidad = T00015_A598MigrLegDiscapacidad[0] ;
            Z599MigrLegDomici = T00015_A599MigrLegDomici[0] ;
            Z600MigrLegEmail = T00015_A600MigrLegEmail[0] ;
            Z601MigrLegCodPos = T00015_A601MigrLegCodPos[0] ;
            Z602MigrLegTelefono = T00015_A602MigrLegTelefono[0] ;
            Z603MigrLegFecIngreso = T00015_A603MigrLegFecIngreso[0] ;
            Z604MigrLegCategoria = T00015_A604MigrLegCategoria[0] ;
            Z605MigrLegArea = T00015_A605MigrLegArea[0] ;
            Z606MigrLegLugarDePago = T00015_A606MigrLegLugarDePago[0] ;
            Z2415MigrLegModTra = T00015_A2415MigrLegModTra[0] ;
            Z2427MigrLegTipoTarifa = T00015_A2427MigrLegTipoTarifa[0] ;
            Z607MigrLegClase = T00015_A607MigrLegClase[0] ;
            Z608MigrLegBasico = T00015_A608MigrLegBasico[0] ;
            Z609MigrLegFormaPago = T00015_A609MigrLegFormaPago[0] ;
            Z691MigrLegClaseDef = T00015_A691MigrLegClaseDef[0] ;
            Z610MigrLegBanco = T00015_A610MigrLegBanco[0] ;
            Z611MigrLegBanSuc = T00015_A611MigrLegBanSuc[0] ;
            Z612MigrLegBanTipCuen = T00015_A612MigrLegBanTipCuen[0] ;
            Z613MigrLegSindicato = T00015_A613MigrLegSindicato[0] ;
            Z614MigrLegObraSocial = T00015_A614MigrLegObraSocial[0] ;
            Z634MigrLegOSAfip = T00015_A634MigrLegOSAfip[0] ;
            Z615MigrLegPlanMedico = T00015_A615MigrLegPlanMedico[0] ;
            Z616MigrLegActividad = T00015_A616MigrLegActividad[0] ;
            Z617MigrLegModalidad = T00015_A617MigrLegModalidad[0] ;
            Z618MigrLegFecUltMod = T00015_A618MigrLegFecUltMod[0] ;
            Z619MigrLegCuentaBanc = T00015_A619MigrLegCuentaBanc[0] ;
            Z620MigrLegZona = T00015_A620MigrLegZona[0] ;
            Z621MigrLegCBU = T00015_A621MigrLegCBU[0] ;
            Z622MigrLegSCVO = T00015_A622MigrLegSCVO[0] ;
            Z623MigrLegSituacionRevista = T00015_A623MigrLegSituacionRevista[0] ;
            Z624MigrLegCondicion = T00015_A624MigrLegCondicion[0] ;
            Z625MigrLegSiniestrado = T00015_A625MigrLegSiniestrado[0] ;
            Z626MigrLegId = T00015_A626MigrLegId[0] ;
            Z627MigrLegConvenio = T00015_A627MigrLegConvenio[0] ;
            Z631MigrTieneConyuge = T00015_A631MigrTieneConyuge[0] ;
            Z632MigrCantidadHijos = T00015_A632MigrCantidadHijos[0] ;
            Z635MigrEncontroOsoSigla = T00015_A635MigrEncontroOsoSigla[0] ;
            Z1398MigrTraDiurno = T00015_A1398MigrTraDiurno[0] ;
            Z1399MigrTraNoct = T00015_A1399MigrTraNoct[0] ;
            Z1400MigrTraIns = T00015_A1400MigrTraIns[0] ;
            Z1820MigrEncontroOsoAfip = T00015_A1820MigrEncontroOsoAfip[0] ;
            Z2190MigrPeriodo = T00015_A2190MigrPeriodo[0] ;
            Z695MigrLegModalidadDef = T00015_A695MigrLegModalidadDef[0] ;
            Z696MigrLegZonaDef = T00015_A696MigrLegZonaDef[0] ;
            Z698MigrLegSituacionDef = T00015_A698MigrLegSituacionDef[0] ;
            Z690MigrLegEstadoCivilDef = T00015_A690MigrLegEstadoCivilDef[0] ;
            Z692MigrLegFormaPagoDef = T00015_A692MigrLegFormaPagoDef[0] ;
            Z693MigrLegTipoCuentaDef = T00015_A693MigrLegTipoCuentaDef[0] ;
            Z694MigrLegActividadDef = T00015_A694MigrLegActividadDef[0] ;
            Z699MigrLegCondicionDef = T00015_A699MigrLegCondicionDef[0] ;
            Z700MigrLegSiniestradoDef = T00015_A700MigrLegSiniestradoDef[0] ;
            Z2197MigrValCadaSave = T00015_A2197MigrValCadaSave[0] ;
            Z2205MigrLegFecEgreso = T00015_A2205MigrLegFecEgreso[0] ;
            Z2216MigrPuesto = T00015_A2216MigrPuesto[0] ;
            Z2221MigrLegMarcaCCT = T00015_A2221MigrLegMarcaCCT[0] ;
            Z2222MigrArchSec = T00015_A2222MigrArchSec[0] ;
            Z2239MigrLegActLabClas = T00015_A2239MigrLegActLabClas[0] ;
            Z2240MigrLegPueAfip = T00015_A2240MigrLegPueAfip[0] ;
            Z2275MigrLegHorSem = T00015_A2275MigrLegHorSem[0] ;
         }
         else
         {
            Z592MigrLegApellido = A592MigrLegApellido ;
            Z593MigrLegNombre = A593MigrLegNombre ;
            Z594MigrLegFecNac = A594MigrLegFecNac ;
            Z595MigrLegSexo = A595MigrLegSexo ;
            Z596MigrLegEstadoCivil = A596MigrLegEstadoCivil ;
            Z597MigrLegCUIL = A597MigrLegCUIL ;
            Z598MigrLegDiscapacidad = A598MigrLegDiscapacidad ;
            Z599MigrLegDomici = A599MigrLegDomici ;
            Z600MigrLegEmail = A600MigrLegEmail ;
            Z601MigrLegCodPos = A601MigrLegCodPos ;
            Z602MigrLegTelefono = A602MigrLegTelefono ;
            Z603MigrLegFecIngreso = A603MigrLegFecIngreso ;
            Z604MigrLegCategoria = A604MigrLegCategoria ;
            Z605MigrLegArea = A605MigrLegArea ;
            Z606MigrLegLugarDePago = A606MigrLegLugarDePago ;
            Z2415MigrLegModTra = A2415MigrLegModTra ;
            Z2427MigrLegTipoTarifa = A2427MigrLegTipoTarifa ;
            Z607MigrLegClase = A607MigrLegClase ;
            Z608MigrLegBasico = A608MigrLegBasico ;
            Z609MigrLegFormaPago = A609MigrLegFormaPago ;
            Z691MigrLegClaseDef = A691MigrLegClaseDef ;
            Z610MigrLegBanco = A610MigrLegBanco ;
            Z611MigrLegBanSuc = A611MigrLegBanSuc ;
            Z612MigrLegBanTipCuen = A612MigrLegBanTipCuen ;
            Z613MigrLegSindicato = A613MigrLegSindicato ;
            Z614MigrLegObraSocial = A614MigrLegObraSocial ;
            Z634MigrLegOSAfip = A634MigrLegOSAfip ;
            Z615MigrLegPlanMedico = A615MigrLegPlanMedico ;
            Z616MigrLegActividad = A616MigrLegActividad ;
            Z617MigrLegModalidad = A617MigrLegModalidad ;
            Z618MigrLegFecUltMod = A618MigrLegFecUltMod ;
            Z619MigrLegCuentaBanc = A619MigrLegCuentaBanc ;
            Z620MigrLegZona = A620MigrLegZona ;
            Z621MigrLegCBU = A621MigrLegCBU ;
            Z622MigrLegSCVO = A622MigrLegSCVO ;
            Z623MigrLegSituacionRevista = A623MigrLegSituacionRevista ;
            Z624MigrLegCondicion = A624MigrLegCondicion ;
            Z625MigrLegSiniestrado = A625MigrLegSiniestrado ;
            Z626MigrLegId = A626MigrLegId ;
            Z627MigrLegConvenio = A627MigrLegConvenio ;
            Z631MigrTieneConyuge = A631MigrTieneConyuge ;
            Z632MigrCantidadHijos = A632MigrCantidadHijos ;
            Z635MigrEncontroOsoSigla = A635MigrEncontroOsoSigla ;
            Z1398MigrTraDiurno = A1398MigrTraDiurno ;
            Z1399MigrTraNoct = A1399MigrTraNoct ;
            Z1400MigrTraIns = A1400MigrTraIns ;
            Z1820MigrEncontroOsoAfip = A1820MigrEncontroOsoAfip ;
            Z2190MigrPeriodo = A2190MigrPeriodo ;
            Z695MigrLegModalidadDef = A695MigrLegModalidadDef ;
            Z696MigrLegZonaDef = A696MigrLegZonaDef ;
            Z698MigrLegSituacionDef = A698MigrLegSituacionDef ;
            Z690MigrLegEstadoCivilDef = A690MigrLegEstadoCivilDef ;
            Z692MigrLegFormaPagoDef = A692MigrLegFormaPagoDef ;
            Z693MigrLegTipoCuentaDef = A693MigrLegTipoCuentaDef ;
            Z694MigrLegActividadDef = A694MigrLegActividadDef ;
            Z699MigrLegCondicionDef = A699MigrLegCondicionDef ;
            Z700MigrLegSiniestradoDef = A700MigrLegSiniestradoDef ;
            Z2197MigrValCadaSave = A2197MigrValCadaSave ;
            Z2205MigrLegFecEgreso = A2205MigrLegFecEgreso ;
            Z2216MigrPuesto = A2216MigrPuesto ;
            Z2221MigrLegMarcaCCT = A2221MigrLegMarcaCCT ;
            Z2222MigrArchSec = A2222MigrArchSec ;
            Z2239MigrLegActLabClas = A2239MigrLegActLabClas ;
            Z2240MigrLegPueAfip = A2240MigrLegPueAfip ;
            Z2275MigrLegHorSem = A2275MigrLegHorSem ;
         }
      }
      if ( GX_JID == -39 )
      {
         Z87MigrLegNumero = A87MigrLegNumero ;
         Z592MigrLegApellido = A592MigrLegApellido ;
         Z593MigrLegNombre = A593MigrLegNombre ;
         Z594MigrLegFecNac = A594MigrLegFecNac ;
         Z595MigrLegSexo = A595MigrLegSexo ;
         Z596MigrLegEstadoCivil = A596MigrLegEstadoCivil ;
         Z597MigrLegCUIL = A597MigrLegCUIL ;
         Z598MigrLegDiscapacidad = A598MigrLegDiscapacidad ;
         Z599MigrLegDomici = A599MigrLegDomici ;
         Z600MigrLegEmail = A600MigrLegEmail ;
         Z601MigrLegCodPos = A601MigrLegCodPos ;
         Z602MigrLegTelefono = A602MigrLegTelefono ;
         Z603MigrLegFecIngreso = A603MigrLegFecIngreso ;
         Z604MigrLegCategoria = A604MigrLegCategoria ;
         Z605MigrLegArea = A605MigrLegArea ;
         Z606MigrLegLugarDePago = A606MigrLegLugarDePago ;
         Z2415MigrLegModTra = A2415MigrLegModTra ;
         Z2427MigrLegTipoTarifa = A2427MigrLegTipoTarifa ;
         Z607MigrLegClase = A607MigrLegClase ;
         Z608MigrLegBasico = A608MigrLegBasico ;
         Z609MigrLegFormaPago = A609MigrLegFormaPago ;
         Z691MigrLegClaseDef = A691MigrLegClaseDef ;
         Z610MigrLegBanco = A610MigrLegBanco ;
         Z611MigrLegBanSuc = A611MigrLegBanSuc ;
         Z612MigrLegBanTipCuen = A612MigrLegBanTipCuen ;
         Z613MigrLegSindicato = A613MigrLegSindicato ;
         Z614MigrLegObraSocial = A614MigrLegObraSocial ;
         Z634MigrLegOSAfip = A634MigrLegOSAfip ;
         Z615MigrLegPlanMedico = A615MigrLegPlanMedico ;
         Z616MigrLegActividad = A616MigrLegActividad ;
         Z617MigrLegModalidad = A617MigrLegModalidad ;
         Z618MigrLegFecUltMod = A618MigrLegFecUltMod ;
         Z619MigrLegCuentaBanc = A619MigrLegCuentaBanc ;
         Z620MigrLegZona = A620MigrLegZona ;
         Z621MigrLegCBU = A621MigrLegCBU ;
         Z622MigrLegSCVO = A622MigrLegSCVO ;
         Z623MigrLegSituacionRevista = A623MigrLegSituacionRevista ;
         Z624MigrLegCondicion = A624MigrLegCondicion ;
         Z625MigrLegSiniestrado = A625MigrLegSiniestrado ;
         Z626MigrLegId = A626MigrLegId ;
         Z627MigrLegConvenio = A627MigrLegConvenio ;
         Z628MigrLegObs = A628MigrLegObs ;
         Z629MigrLegErrores = A629MigrLegErrores ;
         Z633MigrLegWarnings = A633MigrLegWarnings ;
         Z631MigrTieneConyuge = A631MigrTieneConyuge ;
         Z632MigrCantidadHijos = A632MigrCantidadHijos ;
         Z635MigrEncontroOsoSigla = A635MigrEncontroOsoSigla ;
         Z1398MigrTraDiurno = A1398MigrTraDiurno ;
         Z1399MigrTraNoct = A1399MigrTraNoct ;
         Z1400MigrTraIns = A1400MigrTraIns ;
         Z1820MigrEncontroOsoAfip = A1820MigrEncontroOsoAfip ;
         Z2189MigrSueldos = A2189MigrSueldos ;
         Z2190MigrPeriodo = A2190MigrPeriodo ;
         Z695MigrLegModalidadDef = A695MigrLegModalidadDef ;
         Z696MigrLegZonaDef = A696MigrLegZonaDef ;
         Z698MigrLegSituacionDef = A698MigrLegSituacionDef ;
         Z690MigrLegEstadoCivilDef = A690MigrLegEstadoCivilDef ;
         Z692MigrLegFormaPagoDef = A692MigrLegFormaPagoDef ;
         Z693MigrLegTipoCuentaDef = A693MigrLegTipoCuentaDef ;
         Z694MigrLegActividadDef = A694MigrLegActividadDef ;
         Z699MigrLegCondicionDef = A699MigrLegCondicionDef ;
         Z700MigrLegSiniestradoDef = A700MigrLegSiniestradoDef ;
         Z2197MigrValCadaSave = A2197MigrValCadaSave ;
         Z2205MigrLegFecEgreso = A2205MigrLegFecEgreso ;
         Z2206MigrOtrosDatos = A2206MigrOtrosDatos ;
         Z2216MigrPuesto = A2216MigrPuesto ;
         Z2221MigrLegMarcaCCT = A2221MigrLegMarcaCCT ;
         Z2222MigrArchSec = A2222MigrArchSec ;
         Z2239MigrLegActLabClas = A2239MigrLegActLabClas ;
         Z2240MigrLegPueAfip = A2240MigrLegPueAfip ;
         Z2275MigrLegHorSem = A2275MigrLegHorSem ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
      }
   }

   public void standaloneNotModal( )
   {
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int6 = A3CliCod ;
            GXv_int7[0] = GXt_int6 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int7) ;
            importacion_legajo_impl.this.GXt_int6 = GXv_int7[0] ;
            A3CliCod = GXt_int6 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      else
      {
         edtCliCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV7CliCod) )
      {
         edtCliCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV18EmpCod) )
      {
         A1EmpCod = AV18EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int8 = A1EmpCod ;
            GXv_int9[0] = GXt_int8 ;
            new web.getempcod(remoteHandle, context).execute( GXv_int9) ;
            importacion_legajo_impl.this.GXt_int8 = GXv_int9[0] ;
            A1EmpCod = GXt_int8 ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         }
      }
      if ( ! (0==AV18EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      else
      {
         edtEmpCod_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV18EmpCod) )
      {
         edtEmpCod_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      }
      if ( ! (0==AV40MigrLegNumero) )
      {
         A87MigrLegNumero = AV40MigrLegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
      }
      if ( ! (0==AV40MigrLegNumero) )
      {
         edtMigrLegNumero_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMigrLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegNumero_Enabled), 5, 0), true);
      }
      else
      {
         edtMigrLegNumero_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMigrLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegNumero_Enabled), 5, 0), true);
      }
      if ( ! (0==AV40MigrLegNumero) )
      {
         edtMigrLegNumero_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMigrLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegNumero_Enabled), 5, 0), true);
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
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV69Pgmname = "importacion_legajo" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV69Pgmname", AV69Pgmname);
      }
   }

   public void load0175( )
   {
      /* Using cursor T00017 */
      pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound75 = (short)(1) ;
         A592MigrLegApellido = T00017_A592MigrLegApellido[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A592MigrLegApellido", A592MigrLegApellido);
         A593MigrLegNombre = T00017_A593MigrLegNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A593MigrLegNombre", A593MigrLegNombre);
         A594MigrLegFecNac = T00017_A594MigrLegFecNac[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A594MigrLegFecNac", localUtil.format(A594MigrLegFecNac, "99/99/9999"));
         A595MigrLegSexo = T00017_A595MigrLegSexo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A595MigrLegSexo", A595MigrLegSexo);
         A596MigrLegEstadoCivil = T00017_A596MigrLegEstadoCivil[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A596MigrLegEstadoCivil", A596MigrLegEstadoCivil);
         A597MigrLegCUIL = T00017_A597MigrLegCUIL[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A597MigrLegCUIL", A597MigrLegCUIL);
         A598MigrLegDiscapacidad = T00017_A598MigrLegDiscapacidad[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A598MigrLegDiscapacidad", A598MigrLegDiscapacidad);
         A599MigrLegDomici = T00017_A599MigrLegDomici[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A599MigrLegDomici", A599MigrLegDomici);
         A600MigrLegEmail = T00017_A600MigrLegEmail[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A600MigrLegEmail", A600MigrLegEmail);
         A601MigrLegCodPos = T00017_A601MigrLegCodPos[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A601MigrLegCodPos", A601MigrLegCodPos);
         A602MigrLegTelefono = T00017_A602MigrLegTelefono[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A602MigrLegTelefono", A602MigrLegTelefono);
         A603MigrLegFecIngreso = T00017_A603MigrLegFecIngreso[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A603MigrLegFecIngreso", localUtil.format(A603MigrLegFecIngreso, "99/99/9999"));
         A604MigrLegCategoria = T00017_A604MigrLegCategoria[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A604MigrLegCategoria", A604MigrLegCategoria);
         A605MigrLegArea = T00017_A605MigrLegArea[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A605MigrLegArea", A605MigrLegArea);
         A606MigrLegLugarDePago = T00017_A606MigrLegLugarDePago[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A606MigrLegLugarDePago", A606MigrLegLugarDePago);
         A2415MigrLegModTra = T00017_A2415MigrLegModTra[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2415MigrLegModTra", A2415MigrLegModTra);
         A2427MigrLegTipoTarifa = T00017_A2427MigrLegTipoTarifa[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2427MigrLegTipoTarifa", A2427MigrLegTipoTarifa);
         A607MigrLegClase = T00017_A607MigrLegClase[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A607MigrLegClase", A607MigrLegClase);
         A608MigrLegBasico = T00017_A608MigrLegBasico[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A608MigrLegBasico", GXutil.ltrimstr( A608MigrLegBasico, 14, 2));
         A609MigrLegFormaPago = T00017_A609MigrLegFormaPago[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A609MigrLegFormaPago", A609MigrLegFormaPago);
         A691MigrLegClaseDef = T00017_A691MigrLegClaseDef[0] ;
         A610MigrLegBanco = T00017_A610MigrLegBanco[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A610MigrLegBanco", A610MigrLegBanco);
         A611MigrLegBanSuc = T00017_A611MigrLegBanSuc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A611MigrLegBanSuc", A611MigrLegBanSuc);
         A612MigrLegBanTipCuen = T00017_A612MigrLegBanTipCuen[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A612MigrLegBanTipCuen", A612MigrLegBanTipCuen);
         A613MigrLegSindicato = T00017_A613MigrLegSindicato[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A613MigrLegSindicato", A613MigrLegSindicato);
         A614MigrLegObraSocial = T00017_A614MigrLegObraSocial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A614MigrLegObraSocial", A614MigrLegObraSocial);
         A634MigrLegOSAfip = T00017_A634MigrLegOSAfip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A634MigrLegOSAfip", A634MigrLegOSAfip);
         A615MigrLegPlanMedico = T00017_A615MigrLegPlanMedico[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A615MigrLegPlanMedico", A615MigrLegPlanMedico);
         A616MigrLegActividad = T00017_A616MigrLegActividad[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A616MigrLegActividad", A616MigrLegActividad);
         A617MigrLegModalidad = T00017_A617MigrLegModalidad[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A617MigrLegModalidad", A617MigrLegModalidad);
         A618MigrLegFecUltMod = T00017_A618MigrLegFecUltMod[0] ;
         A619MigrLegCuentaBanc = T00017_A619MigrLegCuentaBanc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A619MigrLegCuentaBanc", A619MigrLegCuentaBanc);
         A620MigrLegZona = T00017_A620MigrLegZona[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A620MigrLegZona", A620MigrLegZona);
         A621MigrLegCBU = T00017_A621MigrLegCBU[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A621MigrLegCBU", A621MigrLegCBU);
         A622MigrLegSCVO = T00017_A622MigrLegSCVO[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A622MigrLegSCVO", A622MigrLegSCVO);
         A623MigrLegSituacionRevista = T00017_A623MigrLegSituacionRevista[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A623MigrLegSituacionRevista", A623MigrLegSituacionRevista);
         A624MigrLegCondicion = T00017_A624MigrLegCondicion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A624MigrLegCondicion", A624MigrLegCondicion);
         A625MigrLegSiniestrado = T00017_A625MigrLegSiniestrado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A625MigrLegSiniestrado", A625MigrLegSiniestrado);
         A626MigrLegId = T00017_A626MigrLegId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A626MigrLegId", A626MigrLegId);
         A627MigrLegConvenio = T00017_A627MigrLegConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A627MigrLegConvenio", A627MigrLegConvenio);
         A628MigrLegObs = T00017_A628MigrLegObs[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A628MigrLegObs", A628MigrLegObs);
         A629MigrLegErrores = T00017_A629MigrLegErrores[0] ;
         A633MigrLegWarnings = T00017_A633MigrLegWarnings[0] ;
         A631MigrTieneConyuge = T00017_A631MigrTieneConyuge[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A631MigrTieneConyuge", A631MigrTieneConyuge);
         A632MigrCantidadHijos = T00017_A632MigrCantidadHijos[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A632MigrCantidadHijos", GXutil.ltrimstr( DecimalUtil.doubleToDec(A632MigrCantidadHijos), 4, 0));
         A635MigrEncontroOsoSigla = T00017_A635MigrEncontroOsoSigla[0] ;
         A1398MigrTraDiurno = T00017_A1398MigrTraDiurno[0] ;
         A1399MigrTraNoct = T00017_A1399MigrTraNoct[0] ;
         A1400MigrTraIns = T00017_A1400MigrTraIns[0] ;
         A1820MigrEncontroOsoAfip = T00017_A1820MigrEncontroOsoAfip[0] ;
         A2189MigrSueldos = T00017_A2189MigrSueldos[0] ;
         A2190MigrPeriodo = T00017_A2190MigrPeriodo[0] ;
         A695MigrLegModalidadDef = T00017_A695MigrLegModalidadDef[0] ;
         A696MigrLegZonaDef = T00017_A696MigrLegZonaDef[0] ;
         A698MigrLegSituacionDef = T00017_A698MigrLegSituacionDef[0] ;
         A690MigrLegEstadoCivilDef = T00017_A690MigrLegEstadoCivilDef[0] ;
         A692MigrLegFormaPagoDef = T00017_A692MigrLegFormaPagoDef[0] ;
         A693MigrLegTipoCuentaDef = T00017_A693MigrLegTipoCuentaDef[0] ;
         A694MigrLegActividadDef = T00017_A694MigrLegActividadDef[0] ;
         A699MigrLegCondicionDef = T00017_A699MigrLegCondicionDef[0] ;
         A700MigrLegSiniestradoDef = T00017_A700MigrLegSiniestradoDef[0] ;
         A2197MigrValCadaSave = T00017_A2197MigrValCadaSave[0] ;
         A2205MigrLegFecEgreso = T00017_A2205MigrLegFecEgreso[0] ;
         A2206MigrOtrosDatos = T00017_A2206MigrOtrosDatos[0] ;
         A2216MigrPuesto = T00017_A2216MigrPuesto[0] ;
         A2221MigrLegMarcaCCT = T00017_A2221MigrLegMarcaCCT[0] ;
         n2221MigrLegMarcaCCT = T00017_n2221MigrLegMarcaCCT[0] ;
         A2222MigrArchSec = T00017_A2222MigrArchSec[0] ;
         n2222MigrArchSec = T00017_n2222MigrArchSec[0] ;
         A2239MigrLegActLabClas = T00017_A2239MigrLegActLabClas[0] ;
         A2240MigrLegPueAfip = T00017_A2240MigrLegPueAfip[0] ;
         A2275MigrLegHorSem = T00017_A2275MigrLegHorSem[0] ;
         zm0175( -39) ;
      }
      pr_default.close(5);
      onLoadActions0175( ) ;
   }

   public void onLoadActions0175( )
   {
      AV69Pgmname = "importacion_legajo" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV69Pgmname", AV69Pgmname);
      AV64AuxMigrLegCategoria = A604MigrLegCategoria ;
      httpContext.ajax_rsp_assign_attri("", false, "AV64AuxMigrLegCategoria", AV64AuxMigrLegCategoria);
      if ( GXutil.strcmp(O634MigrLegOSAfip, "") != 0 )
      {
         edtMigrLegOSAfip_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMigrLegOSAfip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegOSAfip_Enabled), 5, 0), true);
      }
      else
      {
         edtMigrLegOSAfip_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMigrLegOSAfip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegOSAfip_Enabled), 5, 0), true);
      }
   }

   public void checkExtendedTable0175( )
   {
      nIsDirty_75 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV69Pgmname = "importacion_legajo" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV69Pgmname", AV69Pgmname);
      /* Using cursor T00016 */
      pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      pr_default.close(4);
      GXv_int7[0] = AV65LegNumeroPorId ;
      GXv_char10[0] = AV62LegNomApe ;
      new web.getlegnumeroynomporid(remoteHandle, context).execute( A3CliCod, A1EmpCod, A626MigrLegId, GXv_int7, GXv_char10) ;
      importacion_legajo_impl.this.AV65LegNumeroPorId = GXv_int7[0] ;
      importacion_legajo_impl.this.AV62LegNomApe = GXv_char10[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65LegNumeroPorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65LegNumeroPorId), 8, 0));
      httpContext.ajax_rsp_assign_attri("", false, "AV62LegNomApe", AV62LegNomApe);
      GXv_int7[0] = AV66LegNumeroPorCUIL ;
      GXv_char10[0] = AV63LegIdNomApe ;
      new web.getlegnumeroynomidporcuil(remoteHandle, context).execute( A3CliCod, A1EmpCod, (long)(DecimalUtil.decToDouble(CommonUtil.decimalVal( A597MigrLegCUIL, "."))), GXv_int7, GXv_char10) ;
      importacion_legajo_impl.this.AV66LegNumeroPorCUIL = GXv_int7[0] ;
      importacion_legajo_impl.this.AV63LegIdNomApe = GXv_char10[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66LegNumeroPorCUIL", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV66LegNumeroPorCUIL), 8, 0));
      httpContext.ajax_rsp_assign_attri("", false, "AV63LegIdNomApe", AV63LegIdNomApe);
      AV64AuxMigrLegCategoria = A604MigrLegCategoria ;
      httpContext.ajax_rsp_assign_attri("", false, "AV64AuxMigrLegCategoria", AV64AuxMigrLegCategoria);
      if ( GXutil.strcmp(O634MigrLegOSAfip, "") != 0 )
      {
         edtMigrLegOSAfip_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMigrLegOSAfip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegOSAfip_Enabled), 5, 0), true);
      }
      else
      {
         edtMigrLegOSAfip_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtMigrLegOSAfip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegOSAfip_Enabled), 5, 0), true);
      }
   }

   public void closeExtendedTableCursors0175( )
   {
      pr_default.close(4);
   }

   public void enableDisable( )
   {
   }

   public void gxload_40( int A3CliCod ,
                          short A1EmpCod )
   {
      /* Using cursor T00018 */
      pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void getKey0175( )
   {
      /* Using cursor T00019 */
      pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         RcdFound75 = (short)(1) ;
      }
      else
      {
         RcdFound75 = (short)(0) ;
      }
      pr_default.close(7);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00015 */
      pr_default.execute(3, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         zm0175( 39) ;
         RcdFound75 = (short)(1) ;
         A87MigrLegNumero = T00015_A87MigrLegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
         A592MigrLegApellido = T00015_A592MigrLegApellido[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A592MigrLegApellido", A592MigrLegApellido);
         A593MigrLegNombre = T00015_A593MigrLegNombre[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A593MigrLegNombre", A593MigrLegNombre);
         A594MigrLegFecNac = T00015_A594MigrLegFecNac[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A594MigrLegFecNac", localUtil.format(A594MigrLegFecNac, "99/99/9999"));
         A595MigrLegSexo = T00015_A595MigrLegSexo[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A595MigrLegSexo", A595MigrLegSexo);
         A596MigrLegEstadoCivil = T00015_A596MigrLegEstadoCivil[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A596MigrLegEstadoCivil", A596MigrLegEstadoCivil);
         A597MigrLegCUIL = T00015_A597MigrLegCUIL[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A597MigrLegCUIL", A597MigrLegCUIL);
         A598MigrLegDiscapacidad = T00015_A598MigrLegDiscapacidad[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A598MigrLegDiscapacidad", A598MigrLegDiscapacidad);
         A599MigrLegDomici = T00015_A599MigrLegDomici[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A599MigrLegDomici", A599MigrLegDomici);
         A600MigrLegEmail = T00015_A600MigrLegEmail[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A600MigrLegEmail", A600MigrLegEmail);
         A601MigrLegCodPos = T00015_A601MigrLegCodPos[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A601MigrLegCodPos", A601MigrLegCodPos);
         A602MigrLegTelefono = T00015_A602MigrLegTelefono[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A602MigrLegTelefono", A602MigrLegTelefono);
         A603MigrLegFecIngreso = T00015_A603MigrLegFecIngreso[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A603MigrLegFecIngreso", localUtil.format(A603MigrLegFecIngreso, "99/99/9999"));
         A604MigrLegCategoria = T00015_A604MigrLegCategoria[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A604MigrLegCategoria", A604MigrLegCategoria);
         A605MigrLegArea = T00015_A605MigrLegArea[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A605MigrLegArea", A605MigrLegArea);
         A606MigrLegLugarDePago = T00015_A606MigrLegLugarDePago[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A606MigrLegLugarDePago", A606MigrLegLugarDePago);
         A2415MigrLegModTra = T00015_A2415MigrLegModTra[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2415MigrLegModTra", A2415MigrLegModTra);
         A2427MigrLegTipoTarifa = T00015_A2427MigrLegTipoTarifa[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A2427MigrLegTipoTarifa", A2427MigrLegTipoTarifa);
         A607MigrLegClase = T00015_A607MigrLegClase[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A607MigrLegClase", A607MigrLegClase);
         A608MigrLegBasico = T00015_A608MigrLegBasico[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A608MigrLegBasico", GXutil.ltrimstr( A608MigrLegBasico, 14, 2));
         A609MigrLegFormaPago = T00015_A609MigrLegFormaPago[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A609MigrLegFormaPago", A609MigrLegFormaPago);
         A691MigrLegClaseDef = T00015_A691MigrLegClaseDef[0] ;
         A610MigrLegBanco = T00015_A610MigrLegBanco[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A610MigrLegBanco", A610MigrLegBanco);
         A611MigrLegBanSuc = T00015_A611MigrLegBanSuc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A611MigrLegBanSuc", A611MigrLegBanSuc);
         A612MigrLegBanTipCuen = T00015_A612MigrLegBanTipCuen[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A612MigrLegBanTipCuen", A612MigrLegBanTipCuen);
         A613MigrLegSindicato = T00015_A613MigrLegSindicato[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A613MigrLegSindicato", A613MigrLegSindicato);
         A614MigrLegObraSocial = T00015_A614MigrLegObraSocial[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A614MigrLegObraSocial", A614MigrLegObraSocial);
         A634MigrLegOSAfip = T00015_A634MigrLegOSAfip[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A634MigrLegOSAfip", A634MigrLegOSAfip);
         A615MigrLegPlanMedico = T00015_A615MigrLegPlanMedico[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A615MigrLegPlanMedico", A615MigrLegPlanMedico);
         A616MigrLegActividad = T00015_A616MigrLegActividad[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A616MigrLegActividad", A616MigrLegActividad);
         A617MigrLegModalidad = T00015_A617MigrLegModalidad[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A617MigrLegModalidad", A617MigrLegModalidad);
         A618MigrLegFecUltMod = T00015_A618MigrLegFecUltMod[0] ;
         A619MigrLegCuentaBanc = T00015_A619MigrLegCuentaBanc[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A619MigrLegCuentaBanc", A619MigrLegCuentaBanc);
         A620MigrLegZona = T00015_A620MigrLegZona[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A620MigrLegZona", A620MigrLegZona);
         A621MigrLegCBU = T00015_A621MigrLegCBU[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A621MigrLegCBU", A621MigrLegCBU);
         A622MigrLegSCVO = T00015_A622MigrLegSCVO[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A622MigrLegSCVO", A622MigrLegSCVO);
         A623MigrLegSituacionRevista = T00015_A623MigrLegSituacionRevista[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A623MigrLegSituacionRevista", A623MigrLegSituacionRevista);
         A624MigrLegCondicion = T00015_A624MigrLegCondicion[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A624MigrLegCondicion", A624MigrLegCondicion);
         A625MigrLegSiniestrado = T00015_A625MigrLegSiniestrado[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A625MigrLegSiniestrado", A625MigrLegSiniestrado);
         A626MigrLegId = T00015_A626MigrLegId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A626MigrLegId", A626MigrLegId);
         A627MigrLegConvenio = T00015_A627MigrLegConvenio[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A627MigrLegConvenio", A627MigrLegConvenio);
         A628MigrLegObs = T00015_A628MigrLegObs[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A628MigrLegObs", A628MigrLegObs);
         A629MigrLegErrores = T00015_A629MigrLegErrores[0] ;
         A633MigrLegWarnings = T00015_A633MigrLegWarnings[0] ;
         A631MigrTieneConyuge = T00015_A631MigrTieneConyuge[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A631MigrTieneConyuge", A631MigrTieneConyuge);
         A632MigrCantidadHijos = T00015_A632MigrCantidadHijos[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A632MigrCantidadHijos", GXutil.ltrimstr( DecimalUtil.doubleToDec(A632MigrCantidadHijos), 4, 0));
         A635MigrEncontroOsoSigla = T00015_A635MigrEncontroOsoSigla[0] ;
         A1398MigrTraDiurno = T00015_A1398MigrTraDiurno[0] ;
         A1399MigrTraNoct = T00015_A1399MigrTraNoct[0] ;
         A1400MigrTraIns = T00015_A1400MigrTraIns[0] ;
         A1820MigrEncontroOsoAfip = T00015_A1820MigrEncontroOsoAfip[0] ;
         A2189MigrSueldos = T00015_A2189MigrSueldos[0] ;
         A2190MigrPeriodo = T00015_A2190MigrPeriodo[0] ;
         A695MigrLegModalidadDef = T00015_A695MigrLegModalidadDef[0] ;
         A696MigrLegZonaDef = T00015_A696MigrLegZonaDef[0] ;
         A698MigrLegSituacionDef = T00015_A698MigrLegSituacionDef[0] ;
         A690MigrLegEstadoCivilDef = T00015_A690MigrLegEstadoCivilDef[0] ;
         A692MigrLegFormaPagoDef = T00015_A692MigrLegFormaPagoDef[0] ;
         A693MigrLegTipoCuentaDef = T00015_A693MigrLegTipoCuentaDef[0] ;
         A694MigrLegActividadDef = T00015_A694MigrLegActividadDef[0] ;
         A699MigrLegCondicionDef = T00015_A699MigrLegCondicionDef[0] ;
         A700MigrLegSiniestradoDef = T00015_A700MigrLegSiniestradoDef[0] ;
         A2197MigrValCadaSave = T00015_A2197MigrValCadaSave[0] ;
         A2205MigrLegFecEgreso = T00015_A2205MigrLegFecEgreso[0] ;
         A2206MigrOtrosDatos = T00015_A2206MigrOtrosDatos[0] ;
         A2216MigrPuesto = T00015_A2216MigrPuesto[0] ;
         A2221MigrLegMarcaCCT = T00015_A2221MigrLegMarcaCCT[0] ;
         n2221MigrLegMarcaCCT = T00015_n2221MigrLegMarcaCCT[0] ;
         A2222MigrArchSec = T00015_A2222MigrArchSec[0] ;
         n2222MigrArchSec = T00015_n2222MigrArchSec[0] ;
         A2239MigrLegActLabClas = T00015_A2239MigrLegActLabClas[0] ;
         A2240MigrLegPueAfip = T00015_A2240MigrLegPueAfip[0] ;
         A2275MigrLegHorSem = T00015_A2275MigrLegHorSem[0] ;
         A3CliCod = T00015_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T00015_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         O634MigrLegOSAfip = A634MigrLegOSAfip ;
         httpContext.ajax_rsp_assign_attri("", false, "A634MigrLegOSAfip", A634MigrLegOSAfip);
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z87MigrLegNumero = A87MigrLegNumero ;
         sMode75 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0175( ) ;
         if ( AnyError == 1 )
         {
            RcdFound75 = (short)(0) ;
            initializeNonKey0175( ) ;
         }
         Gx_mode = sMode75 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound75 = (short)(0) ;
         initializeNonKey0175( ) ;
         sMode75 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode75 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(3);
   }

   public void getEqualNoModal( )
   {
      getKey0175( ) ;
      if ( RcdFound75 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound75 = (short)(0) ;
      /* Using cursor T000110 */
      pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A87MigrLegNumero)});
      if ( (pr_default.getStatus(8) != 101) )
      {
         while ( (pr_default.getStatus(8) != 101) && ( ( T000110_A3CliCod[0] < A3CliCod ) || ( T000110_A3CliCod[0] == A3CliCod ) && ( T000110_A1EmpCod[0] < A1EmpCod ) || ( T000110_A1EmpCod[0] == A1EmpCod ) && ( T000110_A3CliCod[0] == A3CliCod ) && ( T000110_A87MigrLegNumero[0] < A87MigrLegNumero ) ) )
         {
            pr_default.readNext(8);
         }
         if ( (pr_default.getStatus(8) != 101) && ( ( T000110_A3CliCod[0] > A3CliCod ) || ( T000110_A3CliCod[0] == A3CliCod ) && ( T000110_A1EmpCod[0] > A1EmpCod ) || ( T000110_A1EmpCod[0] == A1EmpCod ) && ( T000110_A3CliCod[0] == A3CliCod ) && ( T000110_A87MigrLegNumero[0] > A87MigrLegNumero ) ) )
         {
            A3CliCod = T000110_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T000110_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A87MigrLegNumero = T000110_A87MigrLegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
            RcdFound75 = (short)(1) ;
         }
      }
      pr_default.close(8);
   }

   public void move_previous( )
   {
      RcdFound75 = (short)(0) ;
      /* Using cursor T000111 */
      pr_default.execute(9, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A1EmpCod), Integer.valueOf(A3CliCod), Integer.valueOf(A87MigrLegNumero)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         while ( (pr_default.getStatus(9) != 101) && ( ( T000111_A3CliCod[0] > A3CliCod ) || ( T000111_A3CliCod[0] == A3CliCod ) && ( T000111_A1EmpCod[0] > A1EmpCod ) || ( T000111_A1EmpCod[0] == A1EmpCod ) && ( T000111_A3CliCod[0] == A3CliCod ) && ( T000111_A87MigrLegNumero[0] > A87MigrLegNumero ) ) )
         {
            pr_default.readNext(9);
         }
         if ( (pr_default.getStatus(9) != 101) && ( ( T000111_A3CliCod[0] < A3CliCod ) || ( T000111_A3CliCod[0] == A3CliCod ) && ( T000111_A1EmpCod[0] < A1EmpCod ) || ( T000111_A1EmpCod[0] == A1EmpCod ) && ( T000111_A3CliCod[0] == A3CliCod ) && ( T000111_A87MigrLegNumero[0] < A87MigrLegNumero ) ) )
         {
            A3CliCod = T000111_A3CliCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            A1EmpCod = T000111_A1EmpCod[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
            A87MigrLegNumero = T000111_A87MigrLegNumero[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
            RcdFound75 = (short)(1) ;
         }
      }
      pr_default.close(9);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0175( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtMigrLegId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert0175( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound75 == 1 )
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A87MigrLegNumero != Z87MigrLegNumero ) )
            {
               A3CliCod = Z3CliCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
               A1EmpCod = Z1EmpCod ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A87MigrLegNumero = Z87MigrLegNumero ;
               httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "CLICOD");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCliCod_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtMigrLegId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update0175( ) ;
               GX_FocusControl = edtMigrLegId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A87MigrLegNumero != Z87MigrLegNumero ) )
            {
               /* Insert record */
               GX_FocusControl = edtMigrLegId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert0175( ) ;
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
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CLICOD");
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCliCod_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtMigrLegId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert0175( ) ;
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
      if ( ( A3CliCod != Z3CliCod ) || ( A1EmpCod != Z1EmpCod ) || ( A87MigrLegNumero != Z87MigrLegNumero ) )
      {
         A3CliCod = Z3CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = Z1EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A87MigrLegNumero = Z87MigrLegNumero ;
         httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "CLICOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtMigrLegId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency0175( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00014 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
         if ( (pr_default.getStatus(2) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_legajo"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(2) == 101) || ( GXutil.strcmp(Z592MigrLegApellido, T00014_A592MigrLegApellido[0]) != 0 ) || ( GXutil.strcmp(Z593MigrLegNombre, T00014_A593MigrLegNombre[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z594MigrLegFecNac), GXutil.resetTime(T00014_A594MigrLegFecNac[0])) ) || ( GXutil.strcmp(Z595MigrLegSexo, T00014_A595MigrLegSexo[0]) != 0 ) || ( GXutil.strcmp(Z596MigrLegEstadoCivil, T00014_A596MigrLegEstadoCivil[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z597MigrLegCUIL, T00014_A597MigrLegCUIL[0]) != 0 ) || ( GXutil.strcmp(Z598MigrLegDiscapacidad, T00014_A598MigrLegDiscapacidad[0]) != 0 ) || ( GXutil.strcmp(Z599MigrLegDomici, T00014_A599MigrLegDomici[0]) != 0 ) || ( GXutil.strcmp(Z600MigrLegEmail, T00014_A600MigrLegEmail[0]) != 0 ) || ( GXutil.strcmp(Z601MigrLegCodPos, T00014_A601MigrLegCodPos[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z602MigrLegTelefono, T00014_A602MigrLegTelefono[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z603MigrLegFecIngreso), GXutil.resetTime(T00014_A603MigrLegFecIngreso[0])) ) || ( GXutil.strcmp(Z604MigrLegCategoria, T00014_A604MigrLegCategoria[0]) != 0 ) || ( GXutil.strcmp(Z605MigrLegArea, T00014_A605MigrLegArea[0]) != 0 ) || ( GXutil.strcmp(Z606MigrLegLugarDePago, T00014_A606MigrLegLugarDePago[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2415MigrLegModTra, T00014_A2415MigrLegModTra[0]) != 0 ) || ( GXutil.strcmp(Z2427MigrLegTipoTarifa, T00014_A2427MigrLegTipoTarifa[0]) != 0 ) || ( GXutil.strcmp(Z607MigrLegClase, T00014_A607MigrLegClase[0]) != 0 ) || ( DecimalUtil.compareTo(Z608MigrLegBasico, T00014_A608MigrLegBasico[0]) != 0 ) || ( GXutil.strcmp(Z609MigrLegFormaPago, T00014_A609MigrLegFormaPago[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z691MigrLegClaseDef != T00014_A691MigrLegClaseDef[0] ) || ( GXutil.strcmp(Z610MigrLegBanco, T00014_A610MigrLegBanco[0]) != 0 ) || ( GXutil.strcmp(Z611MigrLegBanSuc, T00014_A611MigrLegBanSuc[0]) != 0 ) || ( GXutil.strcmp(Z612MigrLegBanTipCuen, T00014_A612MigrLegBanTipCuen[0]) != 0 ) || ( GXutil.strcmp(Z613MigrLegSindicato, T00014_A613MigrLegSindicato[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z614MigrLegObraSocial, T00014_A614MigrLegObraSocial[0]) != 0 ) || ( GXutil.strcmp(Z634MigrLegOSAfip, T00014_A634MigrLegOSAfip[0]) != 0 ) || ( GXutil.strcmp(Z615MigrLegPlanMedico, T00014_A615MigrLegPlanMedico[0]) != 0 ) || ( GXutil.strcmp(Z616MigrLegActividad, T00014_A616MigrLegActividad[0]) != 0 ) || ( GXutil.strcmp(Z617MigrLegModalidad, T00014_A617MigrLegModalidad[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || !( GXutil.dateCompare(GXutil.resetTime(Z618MigrLegFecUltMod), GXutil.resetTime(T00014_A618MigrLegFecUltMod[0])) ) || ( GXutil.strcmp(Z619MigrLegCuentaBanc, T00014_A619MigrLegCuentaBanc[0]) != 0 ) || ( GXutil.strcmp(Z620MigrLegZona, T00014_A620MigrLegZona[0]) != 0 ) || ( GXutil.strcmp(Z621MigrLegCBU, T00014_A621MigrLegCBU[0]) != 0 ) || ( GXutil.strcmp(Z622MigrLegSCVO, T00014_A622MigrLegSCVO[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z623MigrLegSituacionRevista, T00014_A623MigrLegSituacionRevista[0]) != 0 ) || ( GXutil.strcmp(Z624MigrLegCondicion, T00014_A624MigrLegCondicion[0]) != 0 ) || ( GXutil.strcmp(Z625MigrLegSiniestrado, T00014_A625MigrLegSiniestrado[0]) != 0 ) || ( GXutil.strcmp(Z626MigrLegId, T00014_A626MigrLegId[0]) != 0 ) || ( GXutil.strcmp(Z627MigrLegConvenio, T00014_A627MigrLegConvenio[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z631MigrTieneConyuge, T00014_A631MigrTieneConyuge[0]) != 0 ) || ( Z632MigrCantidadHijos != T00014_A632MigrCantidadHijos[0] ) || ( Z635MigrEncontroOsoSigla != T00014_A635MigrEncontroOsoSigla[0] ) || ( GXutil.strcmp(Z1398MigrTraDiurno, T00014_A1398MigrTraDiurno[0]) != 0 ) || ( GXutil.strcmp(Z1399MigrTraNoct, T00014_A1399MigrTraNoct[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z1400MigrTraIns, T00014_A1400MigrTraIns[0]) != 0 ) || ( Z1820MigrEncontroOsoAfip != T00014_A1820MigrEncontroOsoAfip[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z2190MigrPeriodo), GXutil.resetTime(T00014_A2190MigrPeriodo[0])) ) || ( Z695MigrLegModalidadDef != T00014_A695MigrLegModalidadDef[0] ) || ( Z696MigrLegZonaDef != T00014_A696MigrLegZonaDef[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z698MigrLegSituacionDef != T00014_A698MigrLegSituacionDef[0] ) || ( Z690MigrLegEstadoCivilDef != T00014_A690MigrLegEstadoCivilDef[0] ) || ( Z692MigrLegFormaPagoDef != T00014_A692MigrLegFormaPagoDef[0] ) || ( Z693MigrLegTipoCuentaDef != T00014_A693MigrLegTipoCuentaDef[0] ) || ( Z694MigrLegActividadDef != T00014_A694MigrLegActividadDef[0] ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( Z699MigrLegCondicionDef != T00014_A699MigrLegCondicionDef[0] ) || ( Z700MigrLegSiniestradoDef != T00014_A700MigrLegSiniestradoDef[0] ) || ( Z2197MigrValCadaSave != T00014_A2197MigrValCadaSave[0] ) || !( GXutil.dateCompare(GXutil.resetTime(Z2205MigrLegFecEgreso), GXutil.resetTime(T00014_A2205MigrLegFecEgreso[0])) ) || ( GXutil.strcmp(Z2216MigrPuesto, T00014_A2216MigrPuesto[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2221MigrLegMarcaCCT, T00014_A2221MigrLegMarcaCCT[0]) != 0 ) || ( Z2222MigrArchSec != T00014_A2222MigrArchSec[0] ) || ( GXutil.strcmp(Z2239MigrLegActLabClas, T00014_A2239MigrLegActLabClas[0]) != 0 ) || ( GXutil.strcmp(Z2240MigrLegPueAfip, T00014_A2240MigrLegPueAfip[0]) != 0 ) || ( DecimalUtil.compareTo(Z2275MigrLegHorSem, T00014_A2275MigrLegHorSem[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z592MigrLegApellido, T00014_A592MigrLegApellido[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegApellido");
               GXutil.writeLogRaw("Old: ",Z592MigrLegApellido);
               GXutil.writeLogRaw("Current: ",T00014_A592MigrLegApellido[0]);
            }
            if ( GXutil.strcmp(Z593MigrLegNombre, T00014_A593MigrLegNombre[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegNombre");
               GXutil.writeLogRaw("Old: ",Z593MigrLegNombre);
               GXutil.writeLogRaw("Current: ",T00014_A593MigrLegNombre[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z594MigrLegFecNac), GXutil.resetTime(T00014_A594MigrLegFecNac[0])) ) )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegFecNac");
               GXutil.writeLogRaw("Old: ",Z594MigrLegFecNac);
               GXutil.writeLogRaw("Current: ",T00014_A594MigrLegFecNac[0]);
            }
            if ( GXutil.strcmp(Z595MigrLegSexo, T00014_A595MigrLegSexo[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegSexo");
               GXutil.writeLogRaw("Old: ",Z595MigrLegSexo);
               GXutil.writeLogRaw("Current: ",T00014_A595MigrLegSexo[0]);
            }
            if ( GXutil.strcmp(Z596MigrLegEstadoCivil, T00014_A596MigrLegEstadoCivil[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegEstadoCivil");
               GXutil.writeLogRaw("Old: ",Z596MigrLegEstadoCivil);
               GXutil.writeLogRaw("Current: ",T00014_A596MigrLegEstadoCivil[0]);
            }
            if ( GXutil.strcmp(Z597MigrLegCUIL, T00014_A597MigrLegCUIL[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegCUIL");
               GXutil.writeLogRaw("Old: ",Z597MigrLegCUIL);
               GXutil.writeLogRaw("Current: ",T00014_A597MigrLegCUIL[0]);
            }
            if ( GXutil.strcmp(Z598MigrLegDiscapacidad, T00014_A598MigrLegDiscapacidad[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegDiscapacidad");
               GXutil.writeLogRaw("Old: ",Z598MigrLegDiscapacidad);
               GXutil.writeLogRaw("Current: ",T00014_A598MigrLegDiscapacidad[0]);
            }
            if ( GXutil.strcmp(Z599MigrLegDomici, T00014_A599MigrLegDomici[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegDomici");
               GXutil.writeLogRaw("Old: ",Z599MigrLegDomici);
               GXutil.writeLogRaw("Current: ",T00014_A599MigrLegDomici[0]);
            }
            if ( GXutil.strcmp(Z600MigrLegEmail, T00014_A600MigrLegEmail[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegEmail");
               GXutil.writeLogRaw("Old: ",Z600MigrLegEmail);
               GXutil.writeLogRaw("Current: ",T00014_A600MigrLegEmail[0]);
            }
            if ( GXutil.strcmp(Z601MigrLegCodPos, T00014_A601MigrLegCodPos[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegCodPos");
               GXutil.writeLogRaw("Old: ",Z601MigrLegCodPos);
               GXutil.writeLogRaw("Current: ",T00014_A601MigrLegCodPos[0]);
            }
            if ( GXutil.strcmp(Z602MigrLegTelefono, T00014_A602MigrLegTelefono[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegTelefono");
               GXutil.writeLogRaw("Old: ",Z602MigrLegTelefono);
               GXutil.writeLogRaw("Current: ",T00014_A602MigrLegTelefono[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z603MigrLegFecIngreso), GXutil.resetTime(T00014_A603MigrLegFecIngreso[0])) ) )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegFecIngreso");
               GXutil.writeLogRaw("Old: ",Z603MigrLegFecIngreso);
               GXutil.writeLogRaw("Current: ",T00014_A603MigrLegFecIngreso[0]);
            }
            if ( GXutil.strcmp(Z604MigrLegCategoria, T00014_A604MigrLegCategoria[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegCategoria");
               GXutil.writeLogRaw("Old: ",Z604MigrLegCategoria);
               GXutil.writeLogRaw("Current: ",T00014_A604MigrLegCategoria[0]);
            }
            if ( GXutil.strcmp(Z605MigrLegArea, T00014_A605MigrLegArea[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegArea");
               GXutil.writeLogRaw("Old: ",Z605MigrLegArea);
               GXutil.writeLogRaw("Current: ",T00014_A605MigrLegArea[0]);
            }
            if ( GXutil.strcmp(Z606MigrLegLugarDePago, T00014_A606MigrLegLugarDePago[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegLugarDePago");
               GXutil.writeLogRaw("Old: ",Z606MigrLegLugarDePago);
               GXutil.writeLogRaw("Current: ",T00014_A606MigrLegLugarDePago[0]);
            }
            if ( GXutil.strcmp(Z2415MigrLegModTra, T00014_A2415MigrLegModTra[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegModTra");
               GXutil.writeLogRaw("Old: ",Z2415MigrLegModTra);
               GXutil.writeLogRaw("Current: ",T00014_A2415MigrLegModTra[0]);
            }
            if ( GXutil.strcmp(Z2427MigrLegTipoTarifa, T00014_A2427MigrLegTipoTarifa[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegTipoTarifa");
               GXutil.writeLogRaw("Old: ",Z2427MigrLegTipoTarifa);
               GXutil.writeLogRaw("Current: ",T00014_A2427MigrLegTipoTarifa[0]);
            }
            if ( GXutil.strcmp(Z607MigrLegClase, T00014_A607MigrLegClase[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegClase");
               GXutil.writeLogRaw("Old: ",Z607MigrLegClase);
               GXutil.writeLogRaw("Current: ",T00014_A607MigrLegClase[0]);
            }
            if ( DecimalUtil.compareTo(Z608MigrLegBasico, T00014_A608MigrLegBasico[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegBasico");
               GXutil.writeLogRaw("Old: ",Z608MigrLegBasico);
               GXutil.writeLogRaw("Current: ",T00014_A608MigrLegBasico[0]);
            }
            if ( GXutil.strcmp(Z609MigrLegFormaPago, T00014_A609MigrLegFormaPago[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegFormaPago");
               GXutil.writeLogRaw("Old: ",Z609MigrLegFormaPago);
               GXutil.writeLogRaw("Current: ",T00014_A609MigrLegFormaPago[0]);
            }
            if ( Z691MigrLegClaseDef != T00014_A691MigrLegClaseDef[0] )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegClaseDef");
               GXutil.writeLogRaw("Old: ",Z691MigrLegClaseDef);
               GXutil.writeLogRaw("Current: ",T00014_A691MigrLegClaseDef[0]);
            }
            if ( GXutil.strcmp(Z610MigrLegBanco, T00014_A610MigrLegBanco[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegBanco");
               GXutil.writeLogRaw("Old: ",Z610MigrLegBanco);
               GXutil.writeLogRaw("Current: ",T00014_A610MigrLegBanco[0]);
            }
            if ( GXutil.strcmp(Z611MigrLegBanSuc, T00014_A611MigrLegBanSuc[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegBanSuc");
               GXutil.writeLogRaw("Old: ",Z611MigrLegBanSuc);
               GXutil.writeLogRaw("Current: ",T00014_A611MigrLegBanSuc[0]);
            }
            if ( GXutil.strcmp(Z612MigrLegBanTipCuen, T00014_A612MigrLegBanTipCuen[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegBanTipCuen");
               GXutil.writeLogRaw("Old: ",Z612MigrLegBanTipCuen);
               GXutil.writeLogRaw("Current: ",T00014_A612MigrLegBanTipCuen[0]);
            }
            if ( GXutil.strcmp(Z613MigrLegSindicato, T00014_A613MigrLegSindicato[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegSindicato");
               GXutil.writeLogRaw("Old: ",Z613MigrLegSindicato);
               GXutil.writeLogRaw("Current: ",T00014_A613MigrLegSindicato[0]);
            }
            if ( GXutil.strcmp(Z614MigrLegObraSocial, T00014_A614MigrLegObraSocial[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegObraSocial");
               GXutil.writeLogRaw("Old: ",Z614MigrLegObraSocial);
               GXutil.writeLogRaw("Current: ",T00014_A614MigrLegObraSocial[0]);
            }
            if ( GXutil.strcmp(Z634MigrLegOSAfip, T00014_A634MigrLegOSAfip[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegOSAfip");
               GXutil.writeLogRaw("Old: ",Z634MigrLegOSAfip);
               GXutil.writeLogRaw("Current: ",T00014_A634MigrLegOSAfip[0]);
            }
            if ( GXutil.strcmp(Z615MigrLegPlanMedico, T00014_A615MigrLegPlanMedico[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegPlanMedico");
               GXutil.writeLogRaw("Old: ",Z615MigrLegPlanMedico);
               GXutil.writeLogRaw("Current: ",T00014_A615MigrLegPlanMedico[0]);
            }
            if ( GXutil.strcmp(Z616MigrLegActividad, T00014_A616MigrLegActividad[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegActividad");
               GXutil.writeLogRaw("Old: ",Z616MigrLegActividad);
               GXutil.writeLogRaw("Current: ",T00014_A616MigrLegActividad[0]);
            }
            if ( GXutil.strcmp(Z617MigrLegModalidad, T00014_A617MigrLegModalidad[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegModalidad");
               GXutil.writeLogRaw("Old: ",Z617MigrLegModalidad);
               GXutil.writeLogRaw("Current: ",T00014_A617MigrLegModalidad[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z618MigrLegFecUltMod), GXutil.resetTime(T00014_A618MigrLegFecUltMod[0])) ) )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegFecUltMod");
               GXutil.writeLogRaw("Old: ",Z618MigrLegFecUltMod);
               GXutil.writeLogRaw("Current: ",T00014_A618MigrLegFecUltMod[0]);
            }
            if ( GXutil.strcmp(Z619MigrLegCuentaBanc, T00014_A619MigrLegCuentaBanc[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegCuentaBanc");
               GXutil.writeLogRaw("Old: ",Z619MigrLegCuentaBanc);
               GXutil.writeLogRaw("Current: ",T00014_A619MigrLegCuentaBanc[0]);
            }
            if ( GXutil.strcmp(Z620MigrLegZona, T00014_A620MigrLegZona[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegZona");
               GXutil.writeLogRaw("Old: ",Z620MigrLegZona);
               GXutil.writeLogRaw("Current: ",T00014_A620MigrLegZona[0]);
            }
            if ( GXutil.strcmp(Z621MigrLegCBU, T00014_A621MigrLegCBU[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegCBU");
               GXutil.writeLogRaw("Old: ",Z621MigrLegCBU);
               GXutil.writeLogRaw("Current: ",T00014_A621MigrLegCBU[0]);
            }
            if ( GXutil.strcmp(Z622MigrLegSCVO, T00014_A622MigrLegSCVO[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegSCVO");
               GXutil.writeLogRaw("Old: ",Z622MigrLegSCVO);
               GXutil.writeLogRaw("Current: ",T00014_A622MigrLegSCVO[0]);
            }
            if ( GXutil.strcmp(Z623MigrLegSituacionRevista, T00014_A623MigrLegSituacionRevista[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegSituacionRevista");
               GXutil.writeLogRaw("Old: ",Z623MigrLegSituacionRevista);
               GXutil.writeLogRaw("Current: ",T00014_A623MigrLegSituacionRevista[0]);
            }
            if ( GXutil.strcmp(Z624MigrLegCondicion, T00014_A624MigrLegCondicion[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegCondicion");
               GXutil.writeLogRaw("Old: ",Z624MigrLegCondicion);
               GXutil.writeLogRaw("Current: ",T00014_A624MigrLegCondicion[0]);
            }
            if ( GXutil.strcmp(Z625MigrLegSiniestrado, T00014_A625MigrLegSiniestrado[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegSiniestrado");
               GXutil.writeLogRaw("Old: ",Z625MigrLegSiniestrado);
               GXutil.writeLogRaw("Current: ",T00014_A625MigrLegSiniestrado[0]);
            }
            if ( GXutil.strcmp(Z626MigrLegId, T00014_A626MigrLegId[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegId");
               GXutil.writeLogRaw("Old: ",Z626MigrLegId);
               GXutil.writeLogRaw("Current: ",T00014_A626MigrLegId[0]);
            }
            if ( GXutil.strcmp(Z627MigrLegConvenio, T00014_A627MigrLegConvenio[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegConvenio");
               GXutil.writeLogRaw("Old: ",Z627MigrLegConvenio);
               GXutil.writeLogRaw("Current: ",T00014_A627MigrLegConvenio[0]);
            }
            if ( GXutil.strcmp(Z631MigrTieneConyuge, T00014_A631MigrTieneConyuge[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrTieneConyuge");
               GXutil.writeLogRaw("Old: ",Z631MigrTieneConyuge);
               GXutil.writeLogRaw("Current: ",T00014_A631MigrTieneConyuge[0]);
            }
            if ( Z632MigrCantidadHijos != T00014_A632MigrCantidadHijos[0] )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrCantidadHijos");
               GXutil.writeLogRaw("Old: ",Z632MigrCantidadHijos);
               GXutil.writeLogRaw("Current: ",T00014_A632MigrCantidadHijos[0]);
            }
            if ( Z635MigrEncontroOsoSigla != T00014_A635MigrEncontroOsoSigla[0] )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrEncontroOsoSigla");
               GXutil.writeLogRaw("Old: ",Z635MigrEncontroOsoSigla);
               GXutil.writeLogRaw("Current: ",T00014_A635MigrEncontroOsoSigla[0]);
            }
            if ( GXutil.strcmp(Z1398MigrTraDiurno, T00014_A1398MigrTraDiurno[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrTraDiurno");
               GXutil.writeLogRaw("Old: ",Z1398MigrTraDiurno);
               GXutil.writeLogRaw("Current: ",T00014_A1398MigrTraDiurno[0]);
            }
            if ( GXutil.strcmp(Z1399MigrTraNoct, T00014_A1399MigrTraNoct[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrTraNoct");
               GXutil.writeLogRaw("Old: ",Z1399MigrTraNoct);
               GXutil.writeLogRaw("Current: ",T00014_A1399MigrTraNoct[0]);
            }
            if ( GXutil.strcmp(Z1400MigrTraIns, T00014_A1400MigrTraIns[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrTraIns");
               GXutil.writeLogRaw("Old: ",Z1400MigrTraIns);
               GXutil.writeLogRaw("Current: ",T00014_A1400MigrTraIns[0]);
            }
            if ( Z1820MigrEncontroOsoAfip != T00014_A1820MigrEncontroOsoAfip[0] )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrEncontroOsoAfip");
               GXutil.writeLogRaw("Old: ",Z1820MigrEncontroOsoAfip);
               GXutil.writeLogRaw("Current: ",T00014_A1820MigrEncontroOsoAfip[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z2190MigrPeriodo), GXutil.resetTime(T00014_A2190MigrPeriodo[0])) ) )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrPeriodo");
               GXutil.writeLogRaw("Old: ",Z2190MigrPeriodo);
               GXutil.writeLogRaw("Current: ",T00014_A2190MigrPeriodo[0]);
            }
            if ( Z695MigrLegModalidadDef != T00014_A695MigrLegModalidadDef[0] )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegModalidadDef");
               GXutil.writeLogRaw("Old: ",Z695MigrLegModalidadDef);
               GXutil.writeLogRaw("Current: ",T00014_A695MigrLegModalidadDef[0]);
            }
            if ( Z696MigrLegZonaDef != T00014_A696MigrLegZonaDef[0] )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegZonaDef");
               GXutil.writeLogRaw("Old: ",Z696MigrLegZonaDef);
               GXutil.writeLogRaw("Current: ",T00014_A696MigrLegZonaDef[0]);
            }
            if ( Z698MigrLegSituacionDef != T00014_A698MigrLegSituacionDef[0] )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegSituacionDef");
               GXutil.writeLogRaw("Old: ",Z698MigrLegSituacionDef);
               GXutil.writeLogRaw("Current: ",T00014_A698MigrLegSituacionDef[0]);
            }
            if ( Z690MigrLegEstadoCivilDef != T00014_A690MigrLegEstadoCivilDef[0] )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegEstadoCivilDef");
               GXutil.writeLogRaw("Old: ",Z690MigrLegEstadoCivilDef);
               GXutil.writeLogRaw("Current: ",T00014_A690MigrLegEstadoCivilDef[0]);
            }
            if ( Z692MigrLegFormaPagoDef != T00014_A692MigrLegFormaPagoDef[0] )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegFormaPagoDef");
               GXutil.writeLogRaw("Old: ",Z692MigrLegFormaPagoDef);
               GXutil.writeLogRaw("Current: ",T00014_A692MigrLegFormaPagoDef[0]);
            }
            if ( Z693MigrLegTipoCuentaDef != T00014_A693MigrLegTipoCuentaDef[0] )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegTipoCuentaDef");
               GXutil.writeLogRaw("Old: ",Z693MigrLegTipoCuentaDef);
               GXutil.writeLogRaw("Current: ",T00014_A693MigrLegTipoCuentaDef[0]);
            }
            if ( Z694MigrLegActividadDef != T00014_A694MigrLegActividadDef[0] )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegActividadDef");
               GXutil.writeLogRaw("Old: ",Z694MigrLegActividadDef);
               GXutil.writeLogRaw("Current: ",T00014_A694MigrLegActividadDef[0]);
            }
            if ( Z699MigrLegCondicionDef != T00014_A699MigrLegCondicionDef[0] )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegCondicionDef");
               GXutil.writeLogRaw("Old: ",Z699MigrLegCondicionDef);
               GXutil.writeLogRaw("Current: ",T00014_A699MigrLegCondicionDef[0]);
            }
            if ( Z700MigrLegSiniestradoDef != T00014_A700MigrLegSiniestradoDef[0] )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegSiniestradoDef");
               GXutil.writeLogRaw("Old: ",Z700MigrLegSiniestradoDef);
               GXutil.writeLogRaw("Current: ",T00014_A700MigrLegSiniestradoDef[0]);
            }
            if ( Z2197MigrValCadaSave != T00014_A2197MigrValCadaSave[0] )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrValCadaSave");
               GXutil.writeLogRaw("Old: ",Z2197MigrValCadaSave);
               GXutil.writeLogRaw("Current: ",T00014_A2197MigrValCadaSave[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z2205MigrLegFecEgreso), GXutil.resetTime(T00014_A2205MigrLegFecEgreso[0])) ) )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegFecEgreso");
               GXutil.writeLogRaw("Old: ",Z2205MigrLegFecEgreso);
               GXutil.writeLogRaw("Current: ",T00014_A2205MigrLegFecEgreso[0]);
            }
            if ( GXutil.strcmp(Z2216MigrPuesto, T00014_A2216MigrPuesto[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrPuesto");
               GXutil.writeLogRaw("Old: ",Z2216MigrPuesto);
               GXutil.writeLogRaw("Current: ",T00014_A2216MigrPuesto[0]);
            }
            if ( GXutil.strcmp(Z2221MigrLegMarcaCCT, T00014_A2221MigrLegMarcaCCT[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegMarcaCCT");
               GXutil.writeLogRaw("Old: ",Z2221MigrLegMarcaCCT);
               GXutil.writeLogRaw("Current: ",T00014_A2221MigrLegMarcaCCT[0]);
            }
            if ( Z2222MigrArchSec != T00014_A2222MigrArchSec[0] )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrArchSec");
               GXutil.writeLogRaw("Old: ",Z2222MigrArchSec);
               GXutil.writeLogRaw("Current: ",T00014_A2222MigrArchSec[0]);
            }
            if ( GXutil.strcmp(Z2239MigrLegActLabClas, T00014_A2239MigrLegActLabClas[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegActLabClas");
               GXutil.writeLogRaw("Old: ",Z2239MigrLegActLabClas);
               GXutil.writeLogRaw("Current: ",T00014_A2239MigrLegActLabClas[0]);
            }
            if ( GXutil.strcmp(Z2240MigrLegPueAfip, T00014_A2240MigrLegPueAfip[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegPueAfip");
               GXutil.writeLogRaw("Old: ",Z2240MigrLegPueAfip);
               GXutil.writeLogRaw("Current: ",T00014_A2240MigrLegPueAfip[0]);
            }
            if ( DecimalUtil.compareTo(Z2275MigrLegHorSem, T00014_A2275MigrLegHorSem[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegHorSem");
               GXutil.writeLogRaw("Old: ",Z2275MigrLegHorSem);
               GXutil.writeLogRaw("Current: ",T00014_A2275MigrLegHorSem[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"importacion_legajo"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0175( )
   {
      beforeValidate0175( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0175( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0175( 0) ;
         checkOptimisticConcurrency0175( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0175( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0175( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000112 */
                  pr_default.execute(10, new Object[] {Integer.valueOf(A87MigrLegNumero), A592MigrLegApellido, A593MigrLegNombre, A594MigrLegFecNac, A595MigrLegSexo, A596MigrLegEstadoCivil, A597MigrLegCUIL, A598MigrLegDiscapacidad, A599MigrLegDomici, A600MigrLegEmail, A601MigrLegCodPos, A602MigrLegTelefono, A603MigrLegFecIngreso, A604MigrLegCategoria, A605MigrLegArea, A606MigrLegLugarDePago, A2415MigrLegModTra, A2427MigrLegTipoTarifa, A607MigrLegClase, A608MigrLegBasico, A609MigrLegFormaPago, Boolean.valueOf(A691MigrLegClaseDef), A610MigrLegBanco, A611MigrLegBanSuc, A612MigrLegBanTipCuen, A613MigrLegSindicato, A614MigrLegObraSocial, A634MigrLegOSAfip, A615MigrLegPlanMedico, A616MigrLegActividad, A617MigrLegModalidad, A618MigrLegFecUltMod, A619MigrLegCuentaBanc, A620MigrLegZona, A621MigrLegCBU, A622MigrLegSCVO, A623MigrLegSituacionRevista, A624MigrLegCondicion, A625MigrLegSiniestrado, A626MigrLegId, A627MigrLegConvenio, A628MigrLegObs, A629MigrLegErrores, A633MigrLegWarnings, A631MigrTieneConyuge, Short.valueOf(A632MigrCantidadHijos), Boolean.valueOf(A635MigrEncontroOsoSigla), A1398MigrTraDiurno, A1399MigrTraNoct, A1400MigrTraIns, Boolean.valueOf(A1820MigrEncontroOsoAfip), A2189MigrSueldos, A2190MigrPeriodo, Boolean.valueOf(A695MigrLegModalidadDef), Boolean.valueOf(A696MigrLegZonaDef), Boolean.valueOf(A698MigrLegSituacionDef), Boolean.valueOf(A690MigrLegEstadoCivilDef), Boolean.valueOf(A692MigrLegFormaPagoDef), Boolean.valueOf(A693MigrLegTipoCuentaDef), Boolean.valueOf(A694MigrLegActividadDef), Boolean.valueOf(A699MigrLegCondicionDef), Boolean.valueOf(A700MigrLegSiniestradoDef), Boolean.valueOf(A2197MigrValCadaSave), A2205MigrLegFecEgreso, A2206MigrOtrosDatos, A2216MigrPuesto, Boolean.valueOf(n2221MigrLegMarcaCCT), A2221MigrLegMarcaCCT, Boolean.valueOf(n2222MigrArchSec), Short.valueOf(A2222MigrArchSec), A2239MigrLegActLabClas, A2240MigrLegPueAfip, A2275MigrLegHorSem, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajo");
                  if ( (pr_default.getStatus(10) == 1) )
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
                        processLevel0175( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption010( ) ;
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
            load0175( ) ;
         }
         endLevel0175( ) ;
      }
      closeExtendedTableCursors0175( ) ;
   }

   public void update0175( )
   {
      beforeValidate0175( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0175( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0175( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0175( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0175( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000113 */
                  pr_default.execute(11, new Object[] {A592MigrLegApellido, A593MigrLegNombre, A594MigrLegFecNac, A595MigrLegSexo, A596MigrLegEstadoCivil, A597MigrLegCUIL, A598MigrLegDiscapacidad, A599MigrLegDomici, A600MigrLegEmail, A601MigrLegCodPos, A602MigrLegTelefono, A603MigrLegFecIngreso, A604MigrLegCategoria, A605MigrLegArea, A606MigrLegLugarDePago, A2415MigrLegModTra, A2427MigrLegTipoTarifa, A607MigrLegClase, A608MigrLegBasico, A609MigrLegFormaPago, Boolean.valueOf(A691MigrLegClaseDef), A610MigrLegBanco, A611MigrLegBanSuc, A612MigrLegBanTipCuen, A613MigrLegSindicato, A614MigrLegObraSocial, A634MigrLegOSAfip, A615MigrLegPlanMedico, A616MigrLegActividad, A617MigrLegModalidad, A618MigrLegFecUltMod, A619MigrLegCuentaBanc, A620MigrLegZona, A621MigrLegCBU, A622MigrLegSCVO, A623MigrLegSituacionRevista, A624MigrLegCondicion, A625MigrLegSiniestrado, A626MigrLegId, A627MigrLegConvenio, A628MigrLegObs, A629MigrLegErrores, A633MigrLegWarnings, A631MigrTieneConyuge, Short.valueOf(A632MigrCantidadHijos), Boolean.valueOf(A635MigrEncontroOsoSigla), A1398MigrTraDiurno, A1399MigrTraNoct, A1400MigrTraIns, Boolean.valueOf(A1820MigrEncontroOsoAfip), A2189MigrSueldos, A2190MigrPeriodo, Boolean.valueOf(A695MigrLegModalidadDef), Boolean.valueOf(A696MigrLegZonaDef), Boolean.valueOf(A698MigrLegSituacionDef), Boolean.valueOf(A690MigrLegEstadoCivilDef), Boolean.valueOf(A692MigrLegFormaPagoDef), Boolean.valueOf(A693MigrLegTipoCuentaDef), Boolean.valueOf(A694MigrLegActividadDef), Boolean.valueOf(A699MigrLegCondicionDef), Boolean.valueOf(A700MigrLegSiniestradoDef), Boolean.valueOf(A2197MigrValCadaSave), A2205MigrLegFecEgreso, A2206MigrOtrosDatos, A2216MigrPuesto, Boolean.valueOf(n2221MigrLegMarcaCCT), A2221MigrLegMarcaCCT, Boolean.valueOf(n2222MigrArchSec), Short.valueOf(A2222MigrArchSec), A2239MigrLegActLabClas, A2240MigrLegPueAfip, A2275MigrLegHorSem, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajo");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_legajo"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0175( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0175( ) ;
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
         endLevel0175( ) ;
      }
      closeExtendedTableCursors0175( ) ;
   }

   public void deferredUpdate0175( )
   {
   }

   public void delete( )
   {
      beforeValidate0175( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0175( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0175( ) ;
         afterConfirm0175( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0175( ) ;
            if ( AnyError == 0 )
            {
               scanStart01262( ) ;
               while ( RcdFound262 != 0 )
               {
                  getByPrimaryKey01262( ) ;
                  delete01262( ) ;
                  scanNext01262( ) ;
               }
               scanEnd01262( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000114 */
                  pr_default.execute(12, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajo");
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
      sMode75 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0175( ) ;
      Gx_mode = sMode75 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0175( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV69Pgmname = "importacion_legajo" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV69Pgmname", AV69Pgmname);
         AV64AuxMigrLegCategoria = A604MigrLegCategoria ;
         httpContext.ajax_rsp_assign_attri("", false, "AV64AuxMigrLegCategoria", AV64AuxMigrLegCategoria);
         if ( GXutil.strcmp(O634MigrLegOSAfip, "") != 0 )
         {
            edtMigrLegOSAfip_Enabled = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, edtMigrLegOSAfip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegOSAfip_Enabled), 5, 0), true);
         }
         else
         {
            edtMigrLegOSAfip_Enabled = 1 ;
            httpContext.ajax_rsp_assign_prop("", false, edtMigrLegOSAfip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegOSAfip_Enabled), 5, 0), true);
         }
      }
   }

   public void processNestedLevel01262( )
   {
      nGXsfl_203_idx = 0 ;
      while ( nGXsfl_203_idx < nRC_GXsfl_203 )
      {
         readRow01262( ) ;
         if ( ( nRcdExists_262 != 0 ) || ( nIsMod_262 != 0 ) )
         {
            standaloneNotModal01262( ) ;
            getKey01262( ) ;
            if ( ( nRcdExists_262 == 0 ) && ( nRcdDeleted_262 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert01262( ) ;
            }
            else
            {
               if ( RcdFound262 != 0 )
               {
                  if ( ( nRcdDeleted_262 != 0 ) && ( nRcdExists_262 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete01262( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_262 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update01262( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_262 == 0 )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "CLICOD");
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCliCod_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtMigrLegFamSec_Internalname, GXutil.ltrim( localUtil.ntoc( A2078MigrLegFamSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtMigrLegFamParen_Internalname, A2079MigrLegFamParen) ;
         httpContext.changePostValue( edtMigrLegFamNroDoc_Internalname, A2080MigrLegFamNroDoc) ;
         httpContext.changePostValue( edtMigrLegFamNomApe_Internalname, A2088MigrLegFamNomApe) ;
         httpContext.changePostValue( edtMigrLegFamFecNac_Internalname, localUtil.format(A2089MigrLegFamFecNac, "99/99/9999")) ;
         httpContext.changePostValue( edtMigrLegFamDedGan_Internalname, GXutil.ltrim( localUtil.ntoc( A2081MigrLegFamDedGan, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( edtMigrLegFamAdh_Internalname, GXutil.rtrim( A2082MigrLegFamAdh)) ;
         httpContext.changePostValue( edtMigrLegFamDiscap_Internalname, GXutil.rtrim( A2086MigrLegFamDiscap)) ;
         httpContext.changePostValue( "ZT_"+"Z2078MigrLegFamSec_"+sGXsfl_203_idx, GXutil.ltrim( localUtil.ntoc( Z2078MigrLegFamSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2079MigrLegFamParen_"+sGXsfl_203_idx, Z2079MigrLegFamParen) ;
         httpContext.changePostValue( "ZT_"+"Z2080MigrLegFamNroDoc_"+sGXsfl_203_idx, Z2080MigrLegFamNroDoc) ;
         httpContext.changePostValue( "ZT_"+"Z2081MigrLegFamDedGan_"+sGXsfl_203_idx, GXutil.ltrim( localUtil.ntoc( Z2081MigrLegFamDedGan, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "ZT_"+"Z2082MigrLegFamAdh_"+sGXsfl_203_idx, GXutil.rtrim( Z2082MigrLegFamAdh)) ;
         httpContext.changePostValue( "ZT_"+"Z2086MigrLegFamDiscap_"+sGXsfl_203_idx, GXutil.rtrim( Z2086MigrLegFamDiscap)) ;
         httpContext.changePostValue( "ZT_"+"Z2088MigrLegFamNomApe_"+sGXsfl_203_idx, Z2088MigrLegFamNomApe) ;
         httpContext.changePostValue( "ZT_"+"Z2089MigrLegFamFecNac_"+sGXsfl_203_idx, localUtil.dtoc( Z2089MigrLegFamFecNac, 0, "/")) ;
         httpContext.changePostValue( "nRcdDeleted_262_"+sGXsfl_203_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_262, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nRcdExists_262_"+sGXsfl_203_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_262, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         httpContext.changePostValue( "nIsMod_262_"+sGXsfl_203_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_262, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), ""))) ;
         if ( nIsMod_262 != 0 )
         {
            httpContext.changePostValue( "MIGRLEGFAMSEC_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamSec_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MIGRLEGFAMPAREN_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamParen_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MIGRLEGFAMNRODOC_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamNroDoc_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MIGRLEGFAMNOMAPE_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamNomApe_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MIGRLEGFAMFECNAC_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamFecNac_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MIGRLEGFAMDEDGAN_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamDedGan_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MIGRLEGFAMADH_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamAdh_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "MIGRLEGFAMDISCAP_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamDiscap_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll01262( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_262 = (short)(0) ;
      nIsMod_262 = (short)(0) ;
      nRcdDeleted_262 = (short)(0) ;
   }

   public void processLevel0175( )
   {
      /* Save parent mode. */
      sMode75 = Gx_mode ;
      processNestedLevel01262( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode75 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel0175( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(2);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0175( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "importacion_legajo");
         if ( AnyError == 0 )
         {
            confirmValues010( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "importacion_legajo");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0175( )
   {
      /* Scan By routine */
      /* Using cursor T000115 */
      pr_default.execute(13);
      RcdFound75 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound75 = (short)(1) ;
         A3CliCod = T000115_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T000115_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A87MigrLegNumero = T000115_A87MigrLegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0175( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound75 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound75 = (short)(1) ;
         A3CliCod = T000115_A3CliCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         A1EmpCod = T000115_A1EmpCod[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         A87MigrLegNumero = T000115_A87MigrLegNumero[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
      }
   }

   public void scanEnd0175( )
   {
      pr_default.close(13);
   }

   public void afterConfirm0175( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0175( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0175( )
   {
      /* Before Update Rules */
      if ( (GXutil.strcmp("", A592MigrLegApellido)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Apellido", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGAPELLIDO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegApellido_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A593MigrLegNombre)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Nombres", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGNOMBRE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegNombre_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A594MigrLegFecNac)) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Fec. Nac.", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGFECNAC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegFecNac_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A595MigrLegSexo)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Sexo", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGSEXO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegSexo_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A596MigrLegEstadoCivil)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Estado Civil", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGESTADOCIVIL");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegEstadoCivil_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A597MigrLegCUIL)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "CUIL", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGCUIL");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegCUIL_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! (0==AV66LegNumeroPorCUIL) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "El CUIL ", "")+GXutil.trim( A597MigrLegCUIL)+httpContext.getMessage( " ya existe en la empresa, legajo \"", "")+GXutil.trim( AV63LegIdNomApe)+"\"", 1, "MIGRLEGCUIL");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegCUIL_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A603MigrLegFecIngreso)) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Fecha de Ingreso", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGFECINGRESO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegFecIngreso_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      GXt_dtime11 = GXutil.resetTime( A594MigrLegFecNac );
      GXt_dtime12 = GXutil.resetTime( A603MigrLegFecIngreso );
      if ( ( GXutil.age( GXt_dtime11, GXt_dtime12) < 16 ) && ! GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A594MigrLegFecNac)) && !( GXutil.dateCompare(GXutil.resetTime(A603MigrLegFecIngreso), GXutil.resetTime(localUtil.ymdtod( 2900, 1, 1))) ) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "La edad a la fecha de ingreso no puede ser menor a 16", ""), 1, "MIGRLEGFECNAC");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegFecNac_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A605MigrLegArea)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Area", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGAREA");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbMigrLegArea.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A607MigrLegClase)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Clase", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGCLASE");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegClase_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, A608MigrLegBasico)==0) && ( (GXutil.strcmp("", AV64AuxMigrLegCategoria)==0) ) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "Debe ingresar Sueldo Básico fuera de convenio", ""), 1, "MIGRLEGBASICO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegBasico_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A609MigrLegFormaPago)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Forma de Pago", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGFORMAPAGO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegFormaPago_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A614MigrLegObraSocial)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Obra Social", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGOBRASOCIAL");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbMigrLegObraSocial.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A634MigrLegOSAfip)==0) && ! (GXutil.strcmp("", A614MigrLegObraSocial)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Código AFIP de Obra Social", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGOBRASOCIAL");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbMigrLegObraSocial.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A616MigrLegActividad)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Actividad", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGACTIVIDAD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegActividad_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A617MigrLegModalidad)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Modalidad de Contratación", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGMODALIDAD");
         AnyError = (short)(1) ;
         GX_FocusControl = cmbMigrLegModalidad.getInternalname() ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A620MigrLegZona)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Zona", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGZONA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegZona_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A623MigrLegSituacionRevista)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Situacion de Revista", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGSITUACIONREVISTA");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegSituacionRevista_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A624MigrLegCondicion)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Condicion", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGCONDICION");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegCondicion_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A625MigrLegSiniestrado)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "Siniestrado", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGSINIESTRADO");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegSiniestrado_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( (GXutil.strcmp("", A626MigrLegId)==0) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "WWP_RequiredAttribute", ""), httpContext.getMessage( "ID", ""), "", "", "", "", "", "", "", ""), 1, "MIGRLEGID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( ! (0==AV65LegNumeroPorId) )
      {
         httpContext.GX_msglist.addItem(httpContext.getMessage( "El id ", "")+GXutil.trim( A626MigrLegId)+httpContext.getMessage( " ya existe en la empresa, legajo \"", "")+GXutil.trim( AV62LegNomApe)+"\"", 1, "MIGRLEGID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
   }

   public void beforeDelete0175( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0175( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0175( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0175( )
   {
      edtMigrLegId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegId_Enabled), 5, 0), true);
      edtMigrLegCUIL_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegCUIL_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegCUIL_Enabled), 5, 0), true);
      edtMigrLegApellido_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegApellido_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegApellido_Enabled), 5, 0), true);
      edtMigrLegNombre_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegNombre_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegNombre_Enabled), 5, 0), true);
      edtMigrLegModTra_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegModTra_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegModTra_Enabled), 5, 0), true);
      edtMigrLegTipoTarifa_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegTipoTarifa_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegTipoTarifa_Enabled), 5, 0), true);
      edtMigrLegClase_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegClase_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegClase_Enabled), 5, 0), true);
      edtMigrLegFecNac_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFecNac_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFecNac_Enabled), 5, 0), true);
      edtMigrLegFecIngreso_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFecIngreso_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFecIngreso_Enabled), 5, 0), true);
      edtMigrLegSexo_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegSexo_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSexo_Enabled), 5, 0), true);
      edtMigrLegDomici_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegDomici_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegDomici_Enabled), 5, 0), true);
      edtMigrLegCodPos_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegCodPos_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegCodPos_Enabled), 5, 0), true);
      edtMigrLegTelefono_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegTelefono_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegTelefono_Enabled), 5, 0), true);
      edtMigrLegEmail_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegEmail_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegEmail_Enabled), 5, 0), true);
      edtMigrLegEstadoCivil_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegEstadoCivil_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegEstadoCivil_Enabled), 5, 0), true);
      cmbMigrLegSindicato.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegSindicato.getInternalname(), "Enabled", GXutil.ltrimstr( cmbMigrLegSindicato.getEnabled(), 5, 0), true);
      cmbMigrLegConvenio.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegConvenio.getInternalname(), "Enabled", GXutil.ltrimstr( cmbMigrLegConvenio.getEnabled(), 5, 0), true);
      cmbMigrLegCategoria.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegCategoria.getInternalname(), "Enabled", GXutil.ltrimstr( cmbMigrLegCategoria.getEnabled(), 5, 0), true);
      cmbMigrLegArea.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegArea.getInternalname(), "Enabled", GXutil.ltrimstr( cmbMigrLegArea.getEnabled(), 5, 0), true);
      edtMigrLegBasico_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegBasico_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegBasico_Enabled), 5, 0), true);
      cmbMigrLegObraSocial.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegObraSocial.getInternalname(), "Enabled", GXutil.ltrimstr( cmbMigrLegObraSocial.getEnabled(), 5, 0), true);
      edtMigrLegOSAfip_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegOSAfip_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegOSAfip_Enabled), 5, 0), true);
      edtMigrLegCBU_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegCBU_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegCBU_Enabled), 5, 0), true);
      cmbMigrLegModalidad.setEnabled( 0 );
      httpContext.ajax_rsp_assign_prop("", false, cmbMigrLegModalidad.getInternalname(), "Enabled", GXutil.ltrimstr( cmbMigrLegModalidad.getEnabled(), 5, 0), true);
      edtMigrLegObs_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegObs_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegObs_Enabled), 5, 0), true);
      edtCliCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCliCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCliCod_Enabled), 5, 0), true);
      edtEmpCod_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtEmpCod_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtEmpCod_Enabled), 5, 0), true);
      edtMigrLegNumero_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegNumero_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegNumero_Enabled), 5, 0), true);
      edtMigrLegZona_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegZona_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegZona_Enabled), 5, 0), true);
      edtMigrLegDiscapacidad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegDiscapacidad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegDiscapacidad_Enabled), 5, 0), true);
      edtMigrLegLugarDePago_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegLugarDePago_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegLugarDePago_Enabled), 5, 0), true);
      edtMigrLegBanco_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegBanco_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegBanco_Enabled), 5, 0), true);
      edtMigrLegBanSuc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegBanSuc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegBanSuc_Enabled), 5, 0), true);
      edtMigrLegBanTipCuen_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegBanTipCuen_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegBanTipCuen_Enabled), 5, 0), true);
      edtMigrLegCuentaBanc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegCuentaBanc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegCuentaBanc_Enabled), 5, 0), true);
      edtMigrLegFormaPago_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFormaPago_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFormaPago_Enabled), 5, 0), true);
      edtMigrLegActividad_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegActividad_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegActividad_Enabled), 5, 0), true);
      edtMigrLegSituacionRevista_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegSituacionRevista_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSituacionRevista_Enabled), 5, 0), true);
      edtMigrLegCondicion_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegCondicion_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegCondicion_Enabled), 5, 0), true);
      edtMigrLegSiniestrado_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegSiniestrado_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSiniestrado_Enabled), 5, 0), true);
      edtMigrLegSCVO_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegSCVO_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegSCVO_Enabled), 5, 0), true);
      edtMigrLegPlanMedico_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegPlanMedico_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegPlanMedico_Enabled), 5, 0), true);
      edtMigrTieneConyuge_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrTieneConyuge_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrTieneConyuge_Enabled), 5, 0), true);
      edtMigrCantidadHijos_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrCantidadHijos_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrCantidadHijos_Enabled), 5, 0), true);
   }

   public void zm01262( int GX_JID )
   {
      if ( ( GX_JID == 41 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z2079MigrLegFamParen = T00013_A2079MigrLegFamParen[0] ;
            Z2080MigrLegFamNroDoc = T00013_A2080MigrLegFamNroDoc[0] ;
            Z2081MigrLegFamDedGan = T00013_A2081MigrLegFamDedGan[0] ;
            Z2082MigrLegFamAdh = T00013_A2082MigrLegFamAdh[0] ;
            Z2086MigrLegFamDiscap = T00013_A2086MigrLegFamDiscap[0] ;
            Z2088MigrLegFamNomApe = T00013_A2088MigrLegFamNomApe[0] ;
            Z2089MigrLegFamFecNac = T00013_A2089MigrLegFamFecNac[0] ;
         }
         else
         {
            Z2079MigrLegFamParen = A2079MigrLegFamParen ;
            Z2080MigrLegFamNroDoc = A2080MigrLegFamNroDoc ;
            Z2081MigrLegFamDedGan = A2081MigrLegFamDedGan ;
            Z2082MigrLegFamAdh = A2082MigrLegFamAdh ;
            Z2086MigrLegFamDiscap = A2086MigrLegFamDiscap ;
            Z2088MigrLegFamNomApe = A2088MigrLegFamNomApe ;
            Z2089MigrLegFamFecNac = A2089MigrLegFamFecNac ;
         }
      }
      if ( GX_JID == -41 )
      {
         Z1EmpCod = A1EmpCod ;
         Z87MigrLegNumero = A87MigrLegNumero ;
         Z2078MigrLegFamSec = A2078MigrLegFamSec ;
         Z2079MigrLegFamParen = A2079MigrLegFamParen ;
         Z2080MigrLegFamNroDoc = A2080MigrLegFamNroDoc ;
         Z2081MigrLegFamDedGan = A2081MigrLegFamDedGan ;
         Z2082MigrLegFamAdh = A2082MigrLegFamAdh ;
         Z2086MigrLegFamDiscap = A2086MigrLegFamDiscap ;
         Z2088MigrLegFamNomApe = A2088MigrLegFamNomApe ;
         Z2089MigrLegFamFecNac = A2089MigrLegFamFecNac ;
         Z3CliCod = A3CliCod ;
      }
   }

   public void standaloneNotModal01262( )
   {
      edtMigrLegFamSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamSec_Enabled), 5, 0), !bGXsfl_203_Refreshing);
   }

   public void standaloneModal01262( )
   {
   }

   public void load01262( )
   {
      /* Using cursor T000116 */
      pr_default.execute(14, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound262 = (short)(1) ;
         A2079MigrLegFamParen = T000116_A2079MigrLegFamParen[0] ;
         A2080MigrLegFamNroDoc = T000116_A2080MigrLegFamNroDoc[0] ;
         A2081MigrLegFamDedGan = T000116_A2081MigrLegFamDedGan[0] ;
         A2082MigrLegFamAdh = T000116_A2082MigrLegFamAdh[0] ;
         A2086MigrLegFamDiscap = T000116_A2086MigrLegFamDiscap[0] ;
         A2088MigrLegFamNomApe = T000116_A2088MigrLegFamNomApe[0] ;
         A2089MigrLegFamFecNac = T000116_A2089MigrLegFamFecNac[0] ;
         zm01262( -41) ;
      }
      pr_default.close(14);
      onLoadActions01262( ) ;
   }

   public void onLoadActions01262( )
   {
   }

   public void checkExtendedTable01262( )
   {
      nIsDirty_262 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal01262( ) ;
   }

   public void closeExtendedTableCursors01262( )
   {
   }

   public void enableDisable01262( )
   {
   }

   public void getKey01262( )
   {
      /* Using cursor T000117 */
      pr_default.execute(15, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound262 = (short)(1) ;
      }
      else
      {
         RcdFound262 = (short)(0) ;
      }
      pr_default.close(15);
   }

   public void getByPrimaryKey01262( )
   {
      /* Using cursor T00013 */
      pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm01262( 41) ;
         RcdFound262 = (short)(1) ;
         initializeNonKey01262( ) ;
         A2078MigrLegFamSec = T00013_A2078MigrLegFamSec[0] ;
         A2079MigrLegFamParen = T00013_A2079MigrLegFamParen[0] ;
         A2080MigrLegFamNroDoc = T00013_A2080MigrLegFamNroDoc[0] ;
         A2081MigrLegFamDedGan = T00013_A2081MigrLegFamDedGan[0] ;
         A2082MigrLegFamAdh = T00013_A2082MigrLegFamAdh[0] ;
         A2086MigrLegFamDiscap = T00013_A2086MigrLegFamDiscap[0] ;
         A2088MigrLegFamNomApe = T00013_A2088MigrLegFamNomApe[0] ;
         A2089MigrLegFamFecNac = T00013_A2089MigrLegFamFecNac[0] ;
         Z3CliCod = A3CliCod ;
         Z1EmpCod = A1EmpCod ;
         Z87MigrLegNumero = A87MigrLegNumero ;
         Z2078MigrLegFamSec = A2078MigrLegFamSec ;
         sMode262 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load01262( ) ;
         Gx_mode = sMode262 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound262 = (short)(0) ;
         initializeNonKey01262( ) ;
         sMode262 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal01262( ) ;
         Gx_mode = sMode262 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes01262( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency01262( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00012 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_legajoFamilia"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         Gx_longc = false ;
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z2079MigrLegFamParen, T00012_A2079MigrLegFamParen[0]) != 0 ) || ( GXutil.strcmp(Z2080MigrLegFamNroDoc, T00012_A2080MigrLegFamNroDoc[0]) != 0 ) || ( DecimalUtil.compareTo(Z2081MigrLegFamDedGan, T00012_A2081MigrLegFamDedGan[0]) != 0 ) || ( GXutil.strcmp(Z2082MigrLegFamAdh, T00012_A2082MigrLegFamAdh[0]) != 0 ) || ( GXutil.strcmp(Z2086MigrLegFamDiscap, T00012_A2086MigrLegFamDiscap[0]) != 0 ) )
         {
            Gx_longc = true ;
         }
         if ( Gx_longc || ( GXutil.strcmp(Z2088MigrLegFamNomApe, T00012_A2088MigrLegFamNomApe[0]) != 0 ) || !( GXutil.dateCompare(GXutil.resetTime(Z2089MigrLegFamFecNac), GXutil.resetTime(T00012_A2089MigrLegFamFecNac[0])) ) )
         {
            if ( GXutil.strcmp(Z2079MigrLegFamParen, T00012_A2079MigrLegFamParen[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegFamParen");
               GXutil.writeLogRaw("Old: ",Z2079MigrLegFamParen);
               GXutil.writeLogRaw("Current: ",T00012_A2079MigrLegFamParen[0]);
            }
            if ( GXutil.strcmp(Z2080MigrLegFamNroDoc, T00012_A2080MigrLegFamNroDoc[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegFamNroDoc");
               GXutil.writeLogRaw("Old: ",Z2080MigrLegFamNroDoc);
               GXutil.writeLogRaw("Current: ",T00012_A2080MigrLegFamNroDoc[0]);
            }
            if ( DecimalUtil.compareTo(Z2081MigrLegFamDedGan, T00012_A2081MigrLegFamDedGan[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegFamDedGan");
               GXutil.writeLogRaw("Old: ",Z2081MigrLegFamDedGan);
               GXutil.writeLogRaw("Current: ",T00012_A2081MigrLegFamDedGan[0]);
            }
            if ( GXutil.strcmp(Z2082MigrLegFamAdh, T00012_A2082MigrLegFamAdh[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegFamAdh");
               GXutil.writeLogRaw("Old: ",Z2082MigrLegFamAdh);
               GXutil.writeLogRaw("Current: ",T00012_A2082MigrLegFamAdh[0]);
            }
            if ( GXutil.strcmp(Z2086MigrLegFamDiscap, T00012_A2086MigrLegFamDiscap[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegFamDiscap");
               GXutil.writeLogRaw("Old: ",Z2086MigrLegFamDiscap);
               GXutil.writeLogRaw("Current: ",T00012_A2086MigrLegFamDiscap[0]);
            }
            if ( GXutil.strcmp(Z2088MigrLegFamNomApe, T00012_A2088MigrLegFamNomApe[0]) != 0 )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegFamNomApe");
               GXutil.writeLogRaw("Old: ",Z2088MigrLegFamNomApe);
               GXutil.writeLogRaw("Current: ",T00012_A2088MigrLegFamNomApe[0]);
            }
            if ( !( GXutil.dateCompare(GXutil.resetTime(Z2089MigrLegFamFecNac), GXutil.resetTime(T00012_A2089MigrLegFamFecNac[0])) ) )
            {
               GXutil.writeLogln("importacion_legajo:[seudo value changed for attri]"+"MigrLegFamFecNac");
               GXutil.writeLogRaw("Old: ",Z2089MigrLegFamFecNac);
               GXutil.writeLogRaw("Current: ",T00012_A2089MigrLegFamFecNac[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"importacion_legajoFamilia"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert01262( )
   {
      beforeValidate01262( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable01262( ) ;
      }
      if ( AnyError == 0 )
      {
         zm01262( 0) ;
         checkOptimisticConcurrency01262( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm01262( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert01262( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000118 */
                  pr_default.execute(16, new Object[] {Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec), A2079MigrLegFamParen, A2080MigrLegFamNroDoc, A2081MigrLegFamDedGan, A2082MigrLegFamAdh, A2086MigrLegFamDiscap, A2088MigrLegFamNomApe, A2089MigrLegFamFecNac, Integer.valueOf(A3CliCod)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajoFamilia");
                  if ( (pr_default.getStatus(16) == 1) )
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
            load01262( ) ;
         }
         endLevel01262( ) ;
      }
      closeExtendedTableCursors01262( ) ;
   }

   public void update01262( )
   {
      beforeValidate01262( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable01262( ) ;
      }
      if ( ( nIsMod_262 != 0 ) || ( nIsDirty_262 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency01262( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm01262( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate01262( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T000119 */
                     pr_default.execute(17, new Object[] {A2079MigrLegFamParen, A2080MigrLegFamNroDoc, A2081MigrLegFamDedGan, A2082MigrLegFamAdh, A2086MigrLegFamDiscap, A2088MigrLegFamNomApe, A2089MigrLegFamFecNac, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajoFamilia");
                     if ( (pr_default.getStatus(17) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"importacion_legajoFamilia"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate01262( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey01262( ) ;
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
            endLevel01262( ) ;
         }
      }
      closeExtendedTableCursors01262( ) ;
   }

   public void deferredUpdate01262( )
   {
   }

   public void delete01262( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate01262( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency01262( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls01262( ) ;
         afterConfirm01262( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete01262( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000120 */
               pr_default.execute(18, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero), Short.valueOf(A2078MigrLegFamSec)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_legajoFamilia");
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
      sMode262 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel01262( ) ;
      Gx_mode = sMode262 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls01262( )
   {
      standaloneModal01262( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel01262( )
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

   public void scanStart01262( )
   {
      /* Scan By routine */
      /* Using cursor T000121 */
      pr_default.execute(19, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A87MigrLegNumero)});
      RcdFound262 = (short)(0) ;
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound262 = (short)(1) ;
         A2078MigrLegFamSec = T000121_A2078MigrLegFamSec[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext01262( )
   {
      /* Scan next routine */
      pr_default.readNext(19);
      RcdFound262 = (short)(0) ;
      if ( (pr_default.getStatus(19) != 101) )
      {
         RcdFound262 = (short)(1) ;
         A2078MigrLegFamSec = T000121_A2078MigrLegFamSec[0] ;
      }
   }

   public void scanEnd01262( )
   {
      pr_default.close(19);
   }

   public void afterConfirm01262( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert01262( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate01262( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete01262( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete01262( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate01262( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes01262( )
   {
      edtMigrLegFamSec_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamSec_Enabled), 5, 0), !bGXsfl_203_Refreshing);
      edtMigrLegFamParen_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamParen_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamParen_Enabled), 5, 0), !bGXsfl_203_Refreshing);
      edtMigrLegFamNroDoc_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamNroDoc_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamNroDoc_Enabled), 5, 0), !bGXsfl_203_Refreshing);
      edtMigrLegFamNomApe_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamNomApe_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamNomApe_Enabled), 5, 0), !bGXsfl_203_Refreshing);
      edtMigrLegFamFecNac_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamFecNac_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamFecNac_Enabled), 5, 0), !bGXsfl_203_Refreshing);
      edtMigrLegFamDedGan_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamDedGan_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamDedGan_Enabled), 5, 0), !bGXsfl_203_Refreshing);
      edtMigrLegFamAdh_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamAdh_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamAdh_Enabled), 5, 0), !bGXsfl_203_Refreshing);
      edtMigrLegFamDiscap_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamDiscap_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamDiscap_Enabled), 5, 0), !bGXsfl_203_Refreshing);
   }

   public void send_integrity_lvl_hashes01262( )
   {
   }

   public void send_integrity_lvl_hashes0175( )
   {
   }

   public void subsflControlProps_203262( )
   {
      edtMigrLegFamSec_Internalname = "MIGRLEGFAMSEC_"+sGXsfl_203_idx ;
      edtMigrLegFamParen_Internalname = "MIGRLEGFAMPAREN_"+sGXsfl_203_idx ;
      edtMigrLegFamNroDoc_Internalname = "MIGRLEGFAMNRODOC_"+sGXsfl_203_idx ;
      edtMigrLegFamNomApe_Internalname = "MIGRLEGFAMNOMAPE_"+sGXsfl_203_idx ;
      edtMigrLegFamFecNac_Internalname = "MIGRLEGFAMFECNAC_"+sGXsfl_203_idx ;
      edtMigrLegFamDedGan_Internalname = "MIGRLEGFAMDEDGAN_"+sGXsfl_203_idx ;
      edtMigrLegFamAdh_Internalname = "MIGRLEGFAMADH_"+sGXsfl_203_idx ;
      edtMigrLegFamDiscap_Internalname = "MIGRLEGFAMDISCAP_"+sGXsfl_203_idx ;
   }

   public void subsflControlProps_fel_203262( )
   {
      edtMigrLegFamSec_Internalname = "MIGRLEGFAMSEC_"+sGXsfl_203_fel_idx ;
      edtMigrLegFamParen_Internalname = "MIGRLEGFAMPAREN_"+sGXsfl_203_fel_idx ;
      edtMigrLegFamNroDoc_Internalname = "MIGRLEGFAMNRODOC_"+sGXsfl_203_fel_idx ;
      edtMigrLegFamNomApe_Internalname = "MIGRLEGFAMNOMAPE_"+sGXsfl_203_fel_idx ;
      edtMigrLegFamFecNac_Internalname = "MIGRLEGFAMFECNAC_"+sGXsfl_203_fel_idx ;
      edtMigrLegFamDedGan_Internalname = "MIGRLEGFAMDEDGAN_"+sGXsfl_203_fel_idx ;
      edtMigrLegFamAdh_Internalname = "MIGRLEGFAMADH_"+sGXsfl_203_fel_idx ;
      edtMigrLegFamDiscap_Internalname = "MIGRLEGFAMDISCAP_"+sGXsfl_203_fel_idx ;
   }

   public void addRow01262( )
   {
      nGXsfl_203_idx = (int)(nGXsfl_203_idx+1) ;
      sGXsfl_203_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_203_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_203262( ) ;
      sendRow01262( ) ;
   }

   public void sendRow01262( )
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
         if ( ((int)((nGXsfl_203_idx) % (2))) == 0 )
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
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegFamSec_Internalname,GXutil.ltrim( localUtil.ntoc( A2078MigrLegFamSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtMigrLegFamSec_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A2078MigrLegFamSec), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A2078MigrLegFamSec), "ZZZ9")))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegFamSec_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(0),Integer.valueOf(edtMigrLegFamSec_Enabled),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(203),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_262_" + sGXsfl_203_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 205,'',false,'" + sGXsfl_203_idx + "',203)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegFamParen_Internalname,A2079MigrLegFamParen,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,205);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegFamParen_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtMigrLegFamParen_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(203),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_262_" + sGXsfl_203_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 206,'',false,'" + sGXsfl_203_idx + "',203)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegFamNroDoc_Internalname,A2080MigrLegFamNroDoc,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,206);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegFamNroDoc_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtMigrLegFamNroDoc_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(203),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_262_" + sGXsfl_203_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 207,'',false,'" + sGXsfl_203_idx + "',203)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegFamNomApe_Internalname,A2088MigrLegFamNomApe,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,207);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegFamNomApe_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtMigrLegFamNomApe_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(203),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_262_" + sGXsfl_203_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 208,'',false,'" + sGXsfl_203_idx + "',203)\"" ;
      ROClassString = "AttributeDate" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegFamFecNac_Internalname,localUtil.format(A2089MigrLegFamFecNac, "99/99/9999"),localUtil.format( A2089MigrLegFamFecNac, "99/99/9999"),TempTags+" onchange=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.date.valid_date(this, 10,'"+httpContext.getLanguageProperty( "date_fmt")+"',0,"+httpContext.getLanguageProperty( "time_fmt")+",'"+httpContext.getLanguageProperty( "code")+"',false,0);"+";gx.evt.onblur(this,208);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegFamFecNac_Jsonclick,Integer.valueOf(0),"AttributeDate","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtMigrLegFamFecNac_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(10),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(203),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Fecha","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_262_" + sGXsfl_203_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 209,'',false,'" + sGXsfl_203_idx + "',203)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegFamDedGan_Internalname,GXutil.ltrim( localUtil.ntoc( A2081MigrLegFamDedGan, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")),GXutil.ltrim( ((edtMigrLegFamDedGan_Enabled!=0) ? localUtil.format( A2081MigrLegFamDedGan, "9.9999") : localUtil.format( A2081MigrLegFamDedGan, "9.9999"))),TempTags+" onchange=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_decimal( this, gx.thousandSeparator,gx.decimalPoint,'4');"+";gx.evt.onblur(this,209);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegFamDedGan_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtMigrLegFamDedGan_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(6),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(203),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"porUnaje","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_262_" + sGXsfl_203_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 210,'',false,'" + sGXsfl_203_idx + "',203)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegFamAdh_Internalname,GXutil.rtrim( A2082MigrLegFamAdh),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,210);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegFamAdh_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtMigrLegFamAdh_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(203),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_262_" + sGXsfl_203_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 211,'',false,'" + sGXsfl_203_idx + "',203)\"" ;
      ROClassString = "Attribute" ;
      Gridlevel1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtMigrLegFamDiscap_Internalname,GXutil.rtrim( A2086MigrLegFamDiscap),"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,211);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtMigrLegFamDiscap_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"TrnColumn","",Integer.valueOf(-1),Integer.valueOf(edtMigrLegFamDiscap_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(20),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(203),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"","left",Boolean.valueOf(true),""});
      httpContext.ajax_sending_grid_row(Gridlevel1Row);
      send_integrity_lvl_hashes01262( ) ;
      GXCCtl = "Z2078MigrLegFamSec_" + sGXsfl_203_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2078MigrLegFamSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z2079MigrLegFamParen_" + sGXsfl_203_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z2079MigrLegFamParen);
      GXCCtl = "Z2080MigrLegFamNroDoc_" + sGXsfl_203_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z2080MigrLegFamNroDoc);
      GXCCtl = "Z2081MigrLegFamDedGan_" + sGXsfl_203_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z2081MigrLegFamDedGan, (byte)(6), (byte)(4), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "Z2082MigrLegFamAdh_" + sGXsfl_203_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z2082MigrLegFamAdh));
      GXCCtl = "Z2086MigrLegFamDiscap_" + sGXsfl_203_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Z2086MigrLegFamDiscap));
      GXCCtl = "Z2088MigrLegFamNomApe_" + sGXsfl_203_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z2088MigrLegFamNomApe);
      GXCCtl = "Z2089MigrLegFamFecNac_" + sGXsfl_203_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, localUtil.dtoc( Z2089MigrLegFamFecNac, 0, "/"));
      GXCCtl = "nRcdDeleted_262_" + sGXsfl_203_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_262, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nRcdExists_262_" + sGXsfl_203_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_262, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "nIsMod_262_" + sGXsfl_203_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_262, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vPGMNAME_" + sGXsfl_203_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( AV69Pgmname));
      GXCCtl = "vMODE_" + sGXsfl_203_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "MIGRVALCADASAVE_" + sGXsfl_203_idx ;
      web.GxWebStd.gx_boolean_hidden_field( httpContext, GXCCtl, A2197MigrValCadaSave);
      GXCCtl = "vCLICOD_" + sGXsfl_203_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vEMPCOD_" + sGXsfl_203_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV18EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      GXCCtl = "vMIGRLEGNUMERO_" + sGXsfl_203_idx ;
      web.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV40MigrLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGFAMSEC_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamSec_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGFAMPAREN_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamParen_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGFAMNRODOC_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamNroDoc_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGFAMNOMAPE_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamNomApe_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGFAMFECNAC_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamFecNac_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGFAMDEDGAN_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamDedGan_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGFAMADH_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamAdh_Enabled, (byte)(5), (byte)(0), ".", "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGFAMDISCAP_"+sGXsfl_203_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamDiscap_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridlevel1Container.AddRow(Gridlevel1Row);
   }

   public void readRow01262( )
   {
      nGXsfl_203_idx = (int)(nGXsfl_203_idx+1) ;
      sGXsfl_203_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_203_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_203262( ) ;
      edtMigrLegFamSec_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MIGRLEGFAMSEC_"+sGXsfl_203_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtMigrLegFamParen_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MIGRLEGFAMPAREN_"+sGXsfl_203_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtMigrLegFamNroDoc_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MIGRLEGFAMNRODOC_"+sGXsfl_203_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtMigrLegFamNomApe_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MIGRLEGFAMNOMAPE_"+sGXsfl_203_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtMigrLegFamFecNac_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MIGRLEGFAMFECNAC_"+sGXsfl_203_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtMigrLegFamDedGan_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MIGRLEGFAMDEDGAN_"+sGXsfl_203_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtMigrLegFamAdh_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MIGRLEGFAMADH_"+sGXsfl_203_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      edtMigrLegFamDiscap_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "MIGRLEGFAMDISCAP_"+sGXsfl_203_idx+"Enabled"), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      A2078MigrLegFamSec = (short)(localUtil.ctol( httpContext.cgiGet( edtMigrLegFamSec_Internalname), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      A2079MigrLegFamParen = httpContext.cgiGet( edtMigrLegFamParen_Internalname) ;
      A2080MigrLegFamNroDoc = httpContext.cgiGet( edtMigrLegFamNroDoc_Internalname) ;
      A2088MigrLegFamNomApe = httpContext.cgiGet( edtMigrLegFamNomApe_Internalname) ;
      if ( localUtil.vcdate( httpContext.cgiGet( edtMigrLegFamFecNac_Internalname), (byte)(localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")))) == 0 )
      {
         GXCCtl = "MIGRLEGFAMFECNAC_" + sGXsfl_203_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_faildate", new Object[] {}), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegFamFecNac_Internalname ;
         wbErr = true ;
         A2089MigrLegFamFecNac = GXutil.nullDate() ;
      }
      else
      {
         A2089MigrLegFamFecNac = localUtil.ctod( httpContext.cgiGet( edtMigrLegFamFecNac_Internalname), localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt"))) ;
      }
      if ( ( ( localUtil.ctond( httpContext.cgiGet( edtMigrLegFamDedGan_Internalname)).doubleValue() < 0 ) ) || ( ( DecimalUtil.compareTo(localUtil.ctond( httpContext.cgiGet( edtMigrLegFamDedGan_Internalname)), DecimalUtil.stringToDec("9.9999")) > 0 ) ) )
      {
         GXCCtl = "MIGRLEGFAMDEDGAN_" + sGXsfl_203_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtMigrLegFamDedGan_Internalname ;
         wbErr = true ;
         A2081MigrLegFamDedGan = DecimalUtil.ZERO ;
      }
      else
      {
         A2081MigrLegFamDedGan = localUtil.ctond( httpContext.cgiGet( edtMigrLegFamDedGan_Internalname)) ;
      }
      A2082MigrLegFamAdh = httpContext.cgiGet( edtMigrLegFamAdh_Internalname) ;
      A2086MigrLegFamDiscap = httpContext.cgiGet( edtMigrLegFamDiscap_Internalname) ;
      GXCCtl = "Z2078MigrLegFamSec_" + sGXsfl_203_idx ;
      Z2078MigrLegFamSec = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "Z2079MigrLegFamParen_" + sGXsfl_203_idx ;
      Z2079MigrLegFamParen = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z2080MigrLegFamNroDoc_" + sGXsfl_203_idx ;
      Z2080MigrLegFamNroDoc = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z2081MigrLegFamDedGan_" + sGXsfl_203_idx ;
      Z2081MigrLegFamDedGan = localUtil.ctond( httpContext.cgiGet( GXCCtl)) ;
      GXCCtl = "Z2082MigrLegFamAdh_" + sGXsfl_203_idx ;
      Z2082MigrLegFamAdh = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z2086MigrLegFamDiscap_" + sGXsfl_203_idx ;
      Z2086MigrLegFamDiscap = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z2088MigrLegFamNomApe_" + sGXsfl_203_idx ;
      Z2088MigrLegFamNomApe = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "Z2089MigrLegFamFecNac_" + sGXsfl_203_idx ;
      Z2089MigrLegFamFecNac = localUtil.ctod( httpContext.cgiGet( GXCCtl), 0) ;
      GXCCtl = "nRcdDeleted_262_" + sGXsfl_203_idx ;
      nRcdDeleted_262 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nRcdExists_262_" + sGXsfl_203_idx ;
      nRcdExists_262 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
      GXCCtl = "nIsMod_262_" + sGXsfl_203_idx ;
      nIsMod_262 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), httpContext.getLanguageProperty( "decimal_point"), httpContext.getLanguageProperty( "thousand_sep"))) ;
   }

   public void assign_properties_default( )
   {
      defedtMigrLegFamSec_Enabled = edtMigrLegFamSec_Enabled ;
   }

   public void confirmValues010( )
   {
      nGXsfl_203_idx = 0 ;
      sGXsfl_203_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_203_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_203262( ) ;
      while ( nGXsfl_203_idx < nRC_GXsfl_203 )
      {
         nGXsfl_203_idx = (int)(nGXsfl_203_idx+1) ;
         sGXsfl_203_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_203_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_203262( ) ;
         httpContext.changePostValue( "Z2078MigrLegFamSec_"+sGXsfl_203_idx, httpContext.cgiGet( "ZT_"+"Z2078MigrLegFamSec_"+sGXsfl_203_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2078MigrLegFamSec_"+sGXsfl_203_idx) ;
         httpContext.changePostValue( "Z2079MigrLegFamParen_"+sGXsfl_203_idx, httpContext.cgiGet( "ZT_"+"Z2079MigrLegFamParen_"+sGXsfl_203_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2079MigrLegFamParen_"+sGXsfl_203_idx) ;
         httpContext.changePostValue( "Z2080MigrLegFamNroDoc_"+sGXsfl_203_idx, httpContext.cgiGet( "ZT_"+"Z2080MigrLegFamNroDoc_"+sGXsfl_203_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2080MigrLegFamNroDoc_"+sGXsfl_203_idx) ;
         httpContext.changePostValue( "Z2081MigrLegFamDedGan_"+sGXsfl_203_idx, httpContext.cgiGet( "ZT_"+"Z2081MigrLegFamDedGan_"+sGXsfl_203_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2081MigrLegFamDedGan_"+sGXsfl_203_idx) ;
         httpContext.changePostValue( "Z2082MigrLegFamAdh_"+sGXsfl_203_idx, httpContext.cgiGet( "ZT_"+"Z2082MigrLegFamAdh_"+sGXsfl_203_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2082MigrLegFamAdh_"+sGXsfl_203_idx) ;
         httpContext.changePostValue( "Z2086MigrLegFamDiscap_"+sGXsfl_203_idx, httpContext.cgiGet( "ZT_"+"Z2086MigrLegFamDiscap_"+sGXsfl_203_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2086MigrLegFamDiscap_"+sGXsfl_203_idx) ;
         httpContext.changePostValue( "Z2088MigrLegFamNomApe_"+sGXsfl_203_idx, httpContext.cgiGet( "ZT_"+"Z2088MigrLegFamNomApe_"+sGXsfl_203_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2088MigrLegFamNomApe_"+sGXsfl_203_idx) ;
         httpContext.changePostValue( "Z2089MigrLegFamFecNac_"+sGXsfl_203_idx, httpContext.cgiGet( "ZT_"+"Z2089MigrLegFamFecNac_"+sGXsfl_203_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z2089MigrLegFamFecNac_"+sGXsfl_203_idx) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.importacion_legajo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV18EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV40MigrLegNumero,8,0))}, new String[] {"Gx_mode","CliCod","EmpCod","MigrLegNumero"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"importacion_legajo");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("MigrLegClaseDef", GXutil.booltostr( A691MigrLegClaseDef));
      forbiddenHiddens.add("MigrLegFecUltMod", localUtil.format(A618MigrLegFecUltMod, "99/99/9999"));
      forbiddenHiddens.add("MigrEncontroOsoSigla", GXutil.booltostr( A635MigrEncontroOsoSigla));
      forbiddenHiddens.add("MigrTraDiurno", GXutil.rtrim( localUtil.format( A1398MigrTraDiurno, "")));
      forbiddenHiddens.add("MigrTraNoct", GXutil.rtrim( localUtil.format( A1399MigrTraNoct, "")));
      forbiddenHiddens.add("MigrTraIns", GXutil.rtrim( localUtil.format( A1400MigrTraIns, "")));
      forbiddenHiddens.add("MigrEncontroOsoAfip", GXutil.booltostr( A1820MigrEncontroOsoAfip));
      forbiddenHiddens.add("MigrPeriodo", localUtil.format(A2190MigrPeriodo, "99/99/99"));
      forbiddenHiddens.add("MigrLegModalidadDef", GXutil.booltostr( A695MigrLegModalidadDef));
      forbiddenHiddens.add("MigrLegZonaDef", GXutil.booltostr( A696MigrLegZonaDef));
      forbiddenHiddens.add("MigrLegSituacionDef", GXutil.booltostr( A698MigrLegSituacionDef));
      forbiddenHiddens.add("MigrLegEstadoCivilDef", GXutil.booltostr( A690MigrLegEstadoCivilDef));
      forbiddenHiddens.add("MigrLegFormaPagoDef", GXutil.booltostr( A692MigrLegFormaPagoDef));
      forbiddenHiddens.add("MigrLegTipoCuentaDef", GXutil.booltostr( A693MigrLegTipoCuentaDef));
      forbiddenHiddens.add("MigrLegActividadDef", GXutil.booltostr( A694MigrLegActividadDef));
      forbiddenHiddens.add("MigrLegCondicionDef", GXutil.booltostr( A699MigrLegCondicionDef));
      forbiddenHiddens.add("MigrLegSiniestradoDef", GXutil.booltostr( A700MigrLegSiniestradoDef));
      forbiddenHiddens.add("MigrValCadaSave", GXutil.booltostr( A2197MigrValCadaSave));
      forbiddenHiddens.add("MigrLegFecEgreso", localUtil.format(A2205MigrLegFecEgreso, "99/99/99"));
      forbiddenHiddens.add("MigrPuesto", GXutil.rtrim( localUtil.format( A2216MigrPuesto, "")));
      forbiddenHiddens.add("MigrLegMarcaCCT", GXutil.rtrim( localUtil.format( A2221MigrLegMarcaCCT, "")));
      forbiddenHiddens.add("MigrArchSec", localUtil.format( DecimalUtil.doubleToDec(A2222MigrArchSec), "ZZZ9"));
      forbiddenHiddens.add("MigrLegActLabClas", GXutil.rtrim( localUtil.format( A2239MigrLegActLabClas, "")));
      forbiddenHiddens.add("MigrLegPueAfip", GXutil.rtrim( localUtil.format( A2240MigrLegPueAfip, "")));
      forbiddenHiddens.add("MigrLegHorSem", localUtil.format( A2275MigrLegHorSem, "Z9.9"));
      web.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("importacion_legajo:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      web.GxWebStd.gx_hidden_field( httpContext, "Z3CliCod", GXutil.ltrim( localUtil.ntoc( Z3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1EmpCod", GXutil.ltrim( localUtil.ntoc( Z1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z87MigrLegNumero", GXutil.ltrim( localUtil.ntoc( Z87MigrLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z592MigrLegApellido", Z592MigrLegApellido);
      web.GxWebStd.gx_hidden_field( httpContext, "Z593MigrLegNombre", Z593MigrLegNombre);
      web.GxWebStd.gx_hidden_field( httpContext, "Z594MigrLegFecNac", localUtil.dtoc( Z594MigrLegFecNac, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z595MigrLegSexo", GXutil.rtrim( Z595MigrLegSexo));
      web.GxWebStd.gx_hidden_field( httpContext, "Z596MigrLegEstadoCivil", Z596MigrLegEstadoCivil);
      web.GxWebStd.gx_hidden_field( httpContext, "Z597MigrLegCUIL", GXutil.rtrim( Z597MigrLegCUIL));
      web.GxWebStd.gx_hidden_field( httpContext, "Z598MigrLegDiscapacidad", GXutil.rtrim( Z598MigrLegDiscapacidad));
      web.GxWebStd.gx_hidden_field( httpContext, "Z599MigrLegDomici", Z599MigrLegDomici);
      web.GxWebStd.gx_hidden_field( httpContext, "Z600MigrLegEmail", Z600MigrLegEmail);
      web.GxWebStd.gx_hidden_field( httpContext, "Z601MigrLegCodPos", Z601MigrLegCodPos);
      web.GxWebStd.gx_hidden_field( httpContext, "Z602MigrLegTelefono", Z602MigrLegTelefono);
      web.GxWebStd.gx_hidden_field( httpContext, "Z603MigrLegFecIngreso", localUtil.dtoc( Z603MigrLegFecIngreso, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z604MigrLegCategoria", Z604MigrLegCategoria);
      web.GxWebStd.gx_hidden_field( httpContext, "Z605MigrLegArea", Z605MigrLegArea);
      web.GxWebStd.gx_hidden_field( httpContext, "Z606MigrLegLugarDePago", Z606MigrLegLugarDePago);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2415MigrLegModTra", Z2415MigrLegModTra);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2427MigrLegTipoTarifa", Z2427MigrLegTipoTarifa);
      web.GxWebStd.gx_hidden_field( httpContext, "Z607MigrLegClase", Z607MigrLegClase);
      web.GxWebStd.gx_hidden_field( httpContext, "Z608MigrLegBasico", GXutil.ltrim( localUtil.ntoc( Z608MigrLegBasico, (byte)(14), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z609MigrLegFormaPago", Z609MigrLegFormaPago);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z691MigrLegClaseDef", Z691MigrLegClaseDef);
      web.GxWebStd.gx_hidden_field( httpContext, "Z610MigrLegBanco", Z610MigrLegBanco);
      web.GxWebStd.gx_hidden_field( httpContext, "Z611MigrLegBanSuc", Z611MigrLegBanSuc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z612MigrLegBanTipCuen", Z612MigrLegBanTipCuen);
      web.GxWebStd.gx_hidden_field( httpContext, "Z613MigrLegSindicato", Z613MigrLegSindicato);
      web.GxWebStd.gx_hidden_field( httpContext, "Z614MigrLegObraSocial", Z614MigrLegObraSocial);
      web.GxWebStd.gx_hidden_field( httpContext, "Z634MigrLegOSAfip", GXutil.rtrim( Z634MigrLegOSAfip));
      web.GxWebStd.gx_hidden_field( httpContext, "Z615MigrLegPlanMedico", Z615MigrLegPlanMedico);
      web.GxWebStd.gx_hidden_field( httpContext, "Z616MigrLegActividad", Z616MigrLegActividad);
      web.GxWebStd.gx_hidden_field( httpContext, "Z617MigrLegModalidad", Z617MigrLegModalidad);
      web.GxWebStd.gx_hidden_field( httpContext, "Z618MigrLegFecUltMod", localUtil.dtoc( Z618MigrLegFecUltMod, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z619MigrLegCuentaBanc", Z619MigrLegCuentaBanc);
      web.GxWebStd.gx_hidden_field( httpContext, "Z620MigrLegZona", Z620MigrLegZona);
      web.GxWebStd.gx_hidden_field( httpContext, "Z621MigrLegCBU", Z621MigrLegCBU);
      web.GxWebStd.gx_hidden_field( httpContext, "Z622MigrLegSCVO", GXutil.rtrim( Z622MigrLegSCVO));
      web.GxWebStd.gx_hidden_field( httpContext, "Z623MigrLegSituacionRevista", Z623MigrLegSituacionRevista);
      web.GxWebStd.gx_hidden_field( httpContext, "Z624MigrLegCondicion", Z624MigrLegCondicion);
      web.GxWebStd.gx_hidden_field( httpContext, "Z625MigrLegSiniestrado", Z625MigrLegSiniestrado);
      web.GxWebStd.gx_hidden_field( httpContext, "Z626MigrLegId", GXutil.rtrim( Z626MigrLegId));
      web.GxWebStd.gx_hidden_field( httpContext, "Z627MigrLegConvenio", Z627MigrLegConvenio);
      web.GxWebStd.gx_hidden_field( httpContext, "Z631MigrTieneConyuge", GXutil.rtrim( Z631MigrTieneConyuge));
      web.GxWebStd.gx_hidden_field( httpContext, "Z632MigrCantidadHijos", GXutil.ltrim( localUtil.ntoc( Z632MigrCantidadHijos, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z635MigrEncontroOsoSigla", Z635MigrEncontroOsoSigla);
      web.GxWebStd.gx_hidden_field( httpContext, "Z1398MigrTraDiurno", GXutil.rtrim( Z1398MigrTraDiurno));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1399MigrTraNoct", GXutil.rtrim( Z1399MigrTraNoct));
      web.GxWebStd.gx_hidden_field( httpContext, "Z1400MigrTraIns", GXutil.rtrim( Z1400MigrTraIns));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z1820MigrEncontroOsoAfip", Z1820MigrEncontroOsoAfip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2190MigrPeriodo", localUtil.dtoc( Z2190MigrPeriodo, 0, "/"));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z695MigrLegModalidadDef", Z695MigrLegModalidadDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z696MigrLegZonaDef", Z696MigrLegZonaDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z698MigrLegSituacionDef", Z698MigrLegSituacionDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z690MigrLegEstadoCivilDef", Z690MigrLegEstadoCivilDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z692MigrLegFormaPagoDef", Z692MigrLegFormaPagoDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z693MigrLegTipoCuentaDef", Z693MigrLegTipoCuentaDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z694MigrLegActividadDef", Z694MigrLegActividadDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z699MigrLegCondicionDef", Z699MigrLegCondicionDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z700MigrLegSiniestradoDef", Z700MigrLegSiniestradoDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "Z2197MigrValCadaSave", Z2197MigrValCadaSave);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2205MigrLegFecEgreso", localUtil.dtoc( Z2205MigrLegFecEgreso, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2216MigrPuesto", Z2216MigrPuesto);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2221MigrLegMarcaCCT", GXutil.rtrim( Z2221MigrLegMarcaCCT));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2222MigrArchSec", GXutil.ltrim( localUtil.ntoc( Z2222MigrArchSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Z2239MigrLegActLabClas", Z2239MigrLegActLabClas);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2240MigrLegPueAfip", Z2240MigrLegPueAfip);
      web.GxWebStd.gx_hidden_field( httpContext, "Z2275MigrLegHorSem", GXutil.ltrim( localUtil.ntoc( Z2275MigrLegHorSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "O634MigrLegOSAfip", GXutil.rtrim( O634MigrLegOSAfip));
      web.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_203", GXutil.ltrim( localUtil.ntoc( nGXsfl_203_idx, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "N634MigrLegOSAfip", GXutil.rtrim( A634MigrLegOSAfip));
      web.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      web.GxWebStd.gx_hidden_field( httpContext, "vCLICOD", GXutil.ltrim( localUtil.ntoc( AV7CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCLICOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CliCod), "ZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vEMPCOD", GXutil.ltrim( localUtil.ntoc( AV18EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vEMPCOD", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV18EmpCod), "ZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vMIGRLEGNUMERO", GXutil.ltrim( localUtil.ntoc( AV40MigrLegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMIGRLEGNUMERO", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV40MigrLegNumero), "ZZZZZZZ9")));
      web.GxWebStd.gx_hidden_field( httpContext, "vAUXMIGRLEGCATEGORIA", AV64AuxMigrLegCategoria);
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMEROPORID", GXutil.ltrim( localUtil.ntoc( AV65LegNumeroPorId, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNOMAPE", AV62LegNomApe);
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGNUMEROPORCUIL", GXutil.ltrim( localUtil.ntoc( AV66LegNumeroPorCUIL, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vLEGIDNOMAPE", AV63LegIdNomApe);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGCLASEDEF", A691MigrLegClaseDef);
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGFECULTMOD", localUtil.dtoc( A618MigrLegFecUltMod, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGERRORES", A629MigrLegErrores);
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGWARNINGS", A633MigrLegWarnings);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRENCONTROOSOSIGLA", A635MigrEncontroOsoSigla);
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRTRADIURNO", GXutil.rtrim( A1398MigrTraDiurno));
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRTRANOCT", GXutil.rtrim( A1399MigrTraNoct));
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRTRAINS", GXutil.rtrim( A1400MigrTraIns));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRENCONTROOSOAFIP", A1820MigrEncontroOsoAfip);
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRSUELDOS", A2189MigrSueldos);
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRPERIODO", localUtil.dtoc( A2190MigrPeriodo, 0, "/"));
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGMODALIDADDEF", A695MigrLegModalidadDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGZONADEF", A696MigrLegZonaDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGSITUACIONDEF", A698MigrLegSituacionDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGESTADOCIVILDEF", A690MigrLegEstadoCivilDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGFORMAPAGODEF", A692MigrLegFormaPagoDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGTIPOCUENTADEF", A693MigrLegTipoCuentaDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGACTIVIDADDEF", A694MigrLegActividadDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGCONDICIONDEF", A699MigrLegCondicionDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRLEGSINIESTRADODEF", A700MigrLegSiniestradoDef);
      web.GxWebStd.gx_boolean_hidden_field( httpContext, "MIGRVALCADASAVE", A2197MigrValCadaSave);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_MIGRVALCADASAVE", getSecureSignedToken( "", A2197MigrValCadaSave));
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGFECEGRESO", localUtil.dtoc( A2205MigrLegFecEgreso, 0, "/"));
      web.GxWebStd.gx_hidden_field( httpContext, "MIGROTROSDATOS", A2206MigrOtrosDatos);
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRPUESTO", A2216MigrPuesto);
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGMARCACCT", GXutil.rtrim( A2221MigrLegMarcaCCT));
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRARCHSEC", GXutil.ltrim( localUtil.ntoc( A2222MigrArchSec, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGACTLABCLAS", A2239MigrLegActLabClas);
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGPUEAFIP", A2240MigrLegPueAfip);
      web.GxWebStd.gx_hidden_field( httpContext, "MIGRLEGHORSEM", GXutil.ltrim( localUtil.ntoc( A2275MigrLegHorSem, (byte)(4), (byte)(1), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV69Pgmname));
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
      return formatLink("web.importacion_legajo", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(AV18EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(AV40MigrLegNumero,8,0))}, new String[] {"Gx_mode","CliCod","EmpCod","MigrLegNumero"})  ;
   }

   public String getPgmname( )
   {
      return "importacion_legajo" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Importación de Legajos", "") ;
   }

   public void initializeNonKey0175( )
   {
      AV64AuxMigrLegCategoria = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV64AuxMigrLegCategoria", AV64AuxMigrLegCategoria);
      AV65LegNumeroPorId = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65LegNumeroPorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65LegNumeroPorId), 8, 0));
      AV62LegNomApe = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV62LegNomApe", AV62LegNomApe);
      AV66LegNumeroPorCUIL = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66LegNumeroPorCUIL", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV66LegNumeroPorCUIL), 8, 0));
      AV63LegIdNomApe = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV63LegIdNomApe", AV63LegIdNomApe);
      A592MigrLegApellido = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A592MigrLegApellido", A592MigrLegApellido);
      A593MigrLegNombre = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A593MigrLegNombre", A593MigrLegNombre);
      A594MigrLegFecNac = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A594MigrLegFecNac", localUtil.format(A594MigrLegFecNac, "99/99/9999"));
      A595MigrLegSexo = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A595MigrLegSexo", A595MigrLegSexo);
      A596MigrLegEstadoCivil = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A596MigrLegEstadoCivil", A596MigrLegEstadoCivil);
      A597MigrLegCUIL = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A597MigrLegCUIL", A597MigrLegCUIL);
      A598MigrLegDiscapacidad = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A598MigrLegDiscapacidad", A598MigrLegDiscapacidad);
      A599MigrLegDomici = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A599MigrLegDomici", A599MigrLegDomici);
      A600MigrLegEmail = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A600MigrLegEmail", A600MigrLegEmail);
      A601MigrLegCodPos = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A601MigrLegCodPos", A601MigrLegCodPos);
      A602MigrLegTelefono = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A602MigrLegTelefono", A602MigrLegTelefono);
      A603MigrLegFecIngreso = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A603MigrLegFecIngreso", localUtil.format(A603MigrLegFecIngreso, "99/99/9999"));
      A604MigrLegCategoria = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A604MigrLegCategoria", A604MigrLegCategoria);
      A605MigrLegArea = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A605MigrLegArea", A605MigrLegArea);
      A606MigrLegLugarDePago = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A606MigrLegLugarDePago", A606MigrLegLugarDePago);
      A2415MigrLegModTra = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2415MigrLegModTra", A2415MigrLegModTra);
      A2427MigrLegTipoTarifa = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2427MigrLegTipoTarifa", A2427MigrLegTipoTarifa);
      A607MigrLegClase = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A607MigrLegClase", A607MigrLegClase);
      A608MigrLegBasico = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A608MigrLegBasico", GXutil.ltrimstr( A608MigrLegBasico, 14, 2));
      A609MigrLegFormaPago = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A609MigrLegFormaPago", A609MigrLegFormaPago);
      A691MigrLegClaseDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A691MigrLegClaseDef", A691MigrLegClaseDef);
      A610MigrLegBanco = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A610MigrLegBanco", A610MigrLegBanco);
      A611MigrLegBanSuc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A611MigrLegBanSuc", A611MigrLegBanSuc);
      A612MigrLegBanTipCuen = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A612MigrLegBanTipCuen", A612MigrLegBanTipCuen);
      A613MigrLegSindicato = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A613MigrLegSindicato", A613MigrLegSindicato);
      A614MigrLegObraSocial = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A614MigrLegObraSocial", A614MigrLegObraSocial);
      A634MigrLegOSAfip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A634MigrLegOSAfip", A634MigrLegOSAfip);
      A615MigrLegPlanMedico = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A615MigrLegPlanMedico", A615MigrLegPlanMedico);
      A616MigrLegActividad = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A616MigrLegActividad", A616MigrLegActividad);
      A617MigrLegModalidad = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A617MigrLegModalidad", A617MigrLegModalidad);
      A618MigrLegFecUltMod = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A618MigrLegFecUltMod", localUtil.format(A618MigrLegFecUltMod, "99/99/9999"));
      A619MigrLegCuentaBanc = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A619MigrLegCuentaBanc", A619MigrLegCuentaBanc);
      A620MigrLegZona = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A620MigrLegZona", A620MigrLegZona);
      A621MigrLegCBU = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A621MigrLegCBU", A621MigrLegCBU);
      A622MigrLegSCVO = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A622MigrLegSCVO", A622MigrLegSCVO);
      A623MigrLegSituacionRevista = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A623MigrLegSituacionRevista", A623MigrLegSituacionRevista);
      A624MigrLegCondicion = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A624MigrLegCondicion", A624MigrLegCondicion);
      A625MigrLegSiniestrado = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A625MigrLegSiniestrado", A625MigrLegSiniestrado);
      A626MigrLegId = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A626MigrLegId", A626MigrLegId);
      A627MigrLegConvenio = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A627MigrLegConvenio", A627MigrLegConvenio);
      A628MigrLegObs = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A628MigrLegObs", A628MigrLegObs);
      A629MigrLegErrores = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A629MigrLegErrores", A629MigrLegErrores);
      A633MigrLegWarnings = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A633MigrLegWarnings", A633MigrLegWarnings);
      A631MigrTieneConyuge = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A631MigrTieneConyuge", A631MigrTieneConyuge);
      A632MigrCantidadHijos = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A632MigrCantidadHijos", GXutil.ltrimstr( DecimalUtil.doubleToDec(A632MigrCantidadHijos), 4, 0));
      A635MigrEncontroOsoSigla = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A635MigrEncontroOsoSigla", A635MigrEncontroOsoSigla);
      A1398MigrTraDiurno = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1398MigrTraDiurno", A1398MigrTraDiurno);
      A1399MigrTraNoct = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1399MigrTraNoct", A1399MigrTraNoct);
      A1400MigrTraIns = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A1400MigrTraIns", A1400MigrTraIns);
      A1820MigrEncontroOsoAfip = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A1820MigrEncontroOsoAfip", A1820MigrEncontroOsoAfip);
      A2189MigrSueldos = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2189MigrSueldos", A2189MigrSueldos);
      A2190MigrPeriodo = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A2190MigrPeriodo", localUtil.format(A2190MigrPeriodo, "99/99/99"));
      A695MigrLegModalidadDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A695MigrLegModalidadDef", A695MigrLegModalidadDef);
      A696MigrLegZonaDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A696MigrLegZonaDef", A696MigrLegZonaDef);
      A698MigrLegSituacionDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A698MigrLegSituacionDef", A698MigrLegSituacionDef);
      A690MigrLegEstadoCivilDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A690MigrLegEstadoCivilDef", A690MigrLegEstadoCivilDef);
      A692MigrLegFormaPagoDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A692MigrLegFormaPagoDef", A692MigrLegFormaPagoDef);
      A693MigrLegTipoCuentaDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A693MigrLegTipoCuentaDef", A693MigrLegTipoCuentaDef);
      A694MigrLegActividadDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A694MigrLegActividadDef", A694MigrLegActividadDef);
      A699MigrLegCondicionDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A699MigrLegCondicionDef", A699MigrLegCondicionDef);
      A700MigrLegSiniestradoDef = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A700MigrLegSiniestradoDef", A700MigrLegSiniestradoDef);
      A2197MigrValCadaSave = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2197MigrValCadaSave", A2197MigrValCadaSave);
      web.GxWebStd.gx_hidden_field( httpContext, "gxhash_MIGRVALCADASAVE", getSecureSignedToken( "", A2197MigrValCadaSave));
      A2205MigrLegFecEgreso = GXutil.nullDate() ;
      httpContext.ajax_rsp_assign_attri("", false, "A2205MigrLegFecEgreso", localUtil.format(A2205MigrLegFecEgreso, "99/99/99"));
      A2206MigrOtrosDatos = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2206MigrOtrosDatos", A2206MigrOtrosDatos);
      A2216MigrPuesto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2216MigrPuesto", A2216MigrPuesto);
      A2221MigrLegMarcaCCT = "" ;
      n2221MigrLegMarcaCCT = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2221MigrLegMarcaCCT", A2221MigrLegMarcaCCT);
      A2222MigrArchSec = (short)(0) ;
      n2222MigrArchSec = false ;
      httpContext.ajax_rsp_assign_attri("", false, "A2222MigrArchSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A2222MigrArchSec), 4, 0));
      A2239MigrLegActLabClas = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2239MigrLegActLabClas", A2239MigrLegActLabClas);
      A2240MigrLegPueAfip = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A2240MigrLegPueAfip", A2240MigrLegPueAfip);
      A2275MigrLegHorSem = DecimalUtil.ZERO ;
      httpContext.ajax_rsp_assign_attri("", false, "A2275MigrLegHorSem", GXutil.ltrimstr( A2275MigrLegHorSem, 4, 1));
      O634MigrLegOSAfip = A634MigrLegOSAfip ;
      httpContext.ajax_rsp_assign_attri("", false, "A634MigrLegOSAfip", A634MigrLegOSAfip);
      Z592MigrLegApellido = "" ;
      Z593MigrLegNombre = "" ;
      Z594MigrLegFecNac = GXutil.nullDate() ;
      Z595MigrLegSexo = "" ;
      Z596MigrLegEstadoCivil = "" ;
      Z597MigrLegCUIL = "" ;
      Z598MigrLegDiscapacidad = "" ;
      Z599MigrLegDomici = "" ;
      Z600MigrLegEmail = "" ;
      Z601MigrLegCodPos = "" ;
      Z602MigrLegTelefono = "" ;
      Z603MigrLegFecIngreso = GXutil.nullDate() ;
      Z604MigrLegCategoria = "" ;
      Z605MigrLegArea = "" ;
      Z606MigrLegLugarDePago = "" ;
      Z2415MigrLegModTra = "" ;
      Z2427MigrLegTipoTarifa = "" ;
      Z607MigrLegClase = "" ;
      Z608MigrLegBasico = DecimalUtil.ZERO ;
      Z609MigrLegFormaPago = "" ;
      Z691MigrLegClaseDef = false ;
      Z610MigrLegBanco = "" ;
      Z611MigrLegBanSuc = "" ;
      Z612MigrLegBanTipCuen = "" ;
      Z613MigrLegSindicato = "" ;
      Z614MigrLegObraSocial = "" ;
      Z634MigrLegOSAfip = "" ;
      Z615MigrLegPlanMedico = "" ;
      Z616MigrLegActividad = "" ;
      Z617MigrLegModalidad = "" ;
      Z618MigrLegFecUltMod = GXutil.nullDate() ;
      Z619MigrLegCuentaBanc = "" ;
      Z620MigrLegZona = "" ;
      Z621MigrLegCBU = "" ;
      Z622MigrLegSCVO = "" ;
      Z623MigrLegSituacionRevista = "" ;
      Z624MigrLegCondicion = "" ;
      Z625MigrLegSiniestrado = "" ;
      Z626MigrLegId = "" ;
      Z627MigrLegConvenio = "" ;
      Z631MigrTieneConyuge = "" ;
      Z632MigrCantidadHijos = (short)(0) ;
      Z635MigrEncontroOsoSigla = false ;
      Z1398MigrTraDiurno = "" ;
      Z1399MigrTraNoct = "" ;
      Z1400MigrTraIns = "" ;
      Z1820MigrEncontroOsoAfip = false ;
      Z2190MigrPeriodo = GXutil.nullDate() ;
      Z695MigrLegModalidadDef = false ;
      Z696MigrLegZonaDef = false ;
      Z698MigrLegSituacionDef = false ;
      Z690MigrLegEstadoCivilDef = false ;
      Z692MigrLegFormaPagoDef = false ;
      Z693MigrLegTipoCuentaDef = false ;
      Z694MigrLegActividadDef = false ;
      Z699MigrLegCondicionDef = false ;
      Z700MigrLegSiniestradoDef = false ;
      Z2197MigrValCadaSave = false ;
      Z2205MigrLegFecEgreso = GXutil.nullDate() ;
      Z2216MigrPuesto = "" ;
      Z2221MigrLegMarcaCCT = "" ;
      Z2222MigrArchSec = (short)(0) ;
      Z2239MigrLegActLabClas = "" ;
      Z2240MigrLegPueAfip = "" ;
      Z2275MigrLegHorSem = DecimalUtil.ZERO ;
   }

   public void initAll0175( )
   {
      A3CliCod = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A87MigrLegNumero = 0 ;
      httpContext.ajax_rsp_assign_attri("", false, "A87MigrLegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A87MigrLegNumero), 8, 0));
      initializeNonKey0175( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey01262( )
   {
      A2079MigrLegFamParen = "" ;
      A2080MigrLegFamNroDoc = "" ;
      A2081MigrLegFamDedGan = DecimalUtil.ZERO ;
      A2082MigrLegFamAdh = "" ;
      A2086MigrLegFamDiscap = "" ;
      A2088MigrLegFamNomApe = "" ;
      A2089MigrLegFamFecNac = GXutil.nullDate() ;
      Z2079MigrLegFamParen = "" ;
      Z2080MigrLegFamNroDoc = "" ;
      Z2081MigrLegFamDedGan = DecimalUtil.ZERO ;
      Z2082MigrLegFamAdh = "" ;
      Z2086MigrLegFamDiscap = "" ;
      Z2088MigrLegFamNomApe = "" ;
      Z2089MigrLegFamFecNac = GXutil.nullDate() ;
   }

   public void initAll01262( )
   {
      A2078MigrLegFamSec = (short)(0) ;
      initializeNonKey01262( ) ;
   }

   public void standaloneModalInsert01262( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2025171341666", true, true);
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
      httpContext.AddJavascriptSource("importacion_legajo.js", "?2025171341666", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Shared/DVelopBootstrap.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Shared/WorkWithPlusCommon.js", "", false, true);
      httpContext.AddJavascriptSource("DVelop/Bootstrap/Panel/BootstrapPanelRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties262( )
   {
      edtMigrLegFamSec_Enabled = defedtMigrLegFamSec_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtMigrLegFamSec_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtMigrLegFamSec_Enabled), 5, 0), !bGXsfl_203_Refreshing);
   }

   public void startgridcontrol203( )
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
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2078MigrLegFamSec, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamSec_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", A2079MigrLegFamParen);
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamParen_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", A2080MigrLegFamNroDoc);
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamNroDoc_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", A2088MigrLegFamNomApe);
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamNomApe_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", localUtil.format(A2089MigrLegFamFecNac, "99/99/9999"));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamFecNac_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.ltrim( localUtil.ntoc( A2081MigrLegFamDedGan, (byte)(6), (byte)(4), ".", "")));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamDedGan_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.rtrim( A2082MigrLegFamAdh));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamAdh_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridlevel1Column.AddObjectProperty("Value", GXutil.rtrim( A2086MigrLegFamDiscap));
      Gridlevel1Column.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtMigrLegFamDiscap_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridlevel1Container.AddColumnProperties(Gridlevel1Column);
      Gridlevel1Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridlevel1Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridlevel1_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      edtMigrLegId_Internalname = "MIGRLEGID" ;
      edtMigrLegCUIL_Internalname = "MIGRLEGCUIL" ;
      edtMigrLegApellido_Internalname = "MIGRLEGAPELLIDO" ;
      edtMigrLegNombre_Internalname = "MIGRLEGNOMBRE" ;
      edtMigrLegModTra_Internalname = "MIGRLEGMODTRA" ;
      edtMigrLegTipoTarifa_Internalname = "MIGRLEGTIPOTARIFA" ;
      edtMigrLegClase_Internalname = "MIGRLEGCLASE" ;
      edtMigrLegFecNac_Internalname = "MIGRLEGFECNAC" ;
      edtMigrLegFecIngreso_Internalname = "MIGRLEGFECINGRESO" ;
      edtMigrLegSexo_Internalname = "MIGRLEGSEXO" ;
      edtMigrLegDomici_Internalname = "MIGRLEGDOMICI" ;
      edtMigrLegCodPos_Internalname = "MIGRLEGCODPOS" ;
      edtMigrLegTelefono_Internalname = "MIGRLEGTELEFONO" ;
      edtMigrLegEmail_Internalname = "MIGRLEGEMAIL" ;
      edtMigrLegEstadoCivil_Internalname = "MIGRLEGESTADOCIVIL" ;
      lblTextblockmigrlegsindicato_Internalname = "TEXTBLOCKMIGRLEGSINDICATO" ;
      cmbMigrLegSindicato.setInternalname( "MIGRLEGSINDICATO" );
      lblMigrlegsindicato_righttext_Internalname = "MIGRLEGSINDICATO_RIGHTTEXT" ;
      tblTablemergedmigrlegsindicato_Internalname = "TABLEMERGEDMIGRLEGSINDICATO" ;
      divTablesplittedmigrlegsindicato_Internalname = "TABLESPLITTEDMIGRLEGSINDICATO" ;
      lblTextblockmigrlegconvenio_Internalname = "TEXTBLOCKMIGRLEGCONVENIO" ;
      cmbMigrLegConvenio.setInternalname( "MIGRLEGCONVENIO" );
      lblMigrlegconvenio_righttext_Internalname = "MIGRLEGCONVENIO_RIGHTTEXT" ;
      tblTablemergedmigrlegconvenio_Internalname = "TABLEMERGEDMIGRLEGCONVENIO" ;
      divTablesplittedmigrlegconvenio_Internalname = "TABLESPLITTEDMIGRLEGCONVENIO" ;
      lblTextblockmigrlegcategoria_Internalname = "TEXTBLOCKMIGRLEGCATEGORIA" ;
      cmbMigrLegCategoria.setInternalname( "MIGRLEGCATEGORIA" );
      lblMigrlegcategoria_righttext_Internalname = "MIGRLEGCATEGORIA_RIGHTTEXT" ;
      tblTablemergedmigrlegcategoria_Internalname = "TABLEMERGEDMIGRLEGCATEGORIA" ;
      divTablesplittedmigrlegcategoria_Internalname = "TABLESPLITTEDMIGRLEGCATEGORIA" ;
      lblTextblockmigrlegarea_Internalname = "TEXTBLOCKMIGRLEGAREA" ;
      cmbMigrLegArea.setInternalname( "MIGRLEGAREA" );
      lblMigrlegarea_righttext_Internalname = "MIGRLEGAREA_RIGHTTEXT" ;
      tblTablemergedmigrlegarea_Internalname = "TABLEMERGEDMIGRLEGAREA" ;
      divTablesplittedmigrlegarea_Internalname = "TABLESPLITTEDMIGRLEGAREA" ;
      edtMigrLegBasico_Internalname = "MIGRLEGBASICO" ;
      lblTextblockmigrlegobrasocial_Internalname = "TEXTBLOCKMIGRLEGOBRASOCIAL" ;
      cmbMigrLegObraSocial.setInternalname( "MIGRLEGOBRASOCIAL" );
      lblMigrlegobrasocial_righttext_Internalname = "MIGRLEGOBRASOCIAL_RIGHTTEXT" ;
      tblTablemergedmigrlegobrasocial_Internalname = "TABLEMERGEDMIGRLEGOBRASOCIAL" ;
      divTablesplittedmigrlegobrasocial_Internalname = "TABLESPLITTEDMIGRLEGOBRASOCIAL" ;
      edtMigrLegOSAfip_Internalname = "MIGRLEGOSAFIP" ;
      edtMigrLegCBU_Internalname = "MIGRLEGCBU" ;
      lblTextblockmigrlegmodalidad_Internalname = "TEXTBLOCKMIGRLEGMODALIDAD" ;
      cmbMigrLegModalidad.setInternalname( "MIGRLEGMODALIDAD" );
      lblMigrlegmodalidad_righttext_Internalname = "MIGRLEGMODALIDAD_RIGHTTEXT" ;
      tblTablemergedmigrlegmodalidad_Internalname = "TABLEMERGEDMIGRLEGMODALIDAD" ;
      divTablesplittedmigrlegmodalidad_Internalname = "TABLESPLITTEDMIGRLEGMODALIDAD" ;
      edtMigrLegObs_Internalname = "MIGRLEGOBS" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      Dvpanel_tableattributes_Internalname = "DVPANEL_TABLEATTRIBUTES" ;
      edtMigrLegFamSec_Internalname = "MIGRLEGFAMSEC" ;
      edtMigrLegFamParen_Internalname = "MIGRLEGFAMPAREN" ;
      edtMigrLegFamNroDoc_Internalname = "MIGRLEGFAMNRODOC" ;
      edtMigrLegFamNomApe_Internalname = "MIGRLEGFAMNOMAPE" ;
      edtMigrLegFamFecNac_Internalname = "MIGRLEGFAMFECNAC" ;
      edtMigrLegFamDedGan_Internalname = "MIGRLEGFAMDEDGAN" ;
      edtMigrLegFamAdh_Internalname = "MIGRLEGFAMADH" ;
      edtMigrLegFamDiscap_Internalname = "MIGRLEGFAMDISCAP" ;
      tblUnnamedtable1_Internalname = "UNNAMEDTABLE1" ;
      grpUnnamedgroup2_Internalname = "UNNAMEDGROUP2" ;
      divTablecontent_Internalname = "TABLECONTENT" ;
      bttBtntrn_enter_Internalname = "BTNTRN_ENTER" ;
      bttBtntrn_cancel_Internalname = "BTNTRN_CANCEL" ;
      tblTablemainfix_Internalname = "TABLEMAINFIX" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      edtCliCod_Internalname = "CLICOD" ;
      edtEmpCod_Internalname = "EMPCOD" ;
      edtMigrLegNumero_Internalname = "MIGRLEGNUMERO" ;
      edtMigrLegZona_Internalname = "MIGRLEGZONA" ;
      edtMigrLegDiscapacidad_Internalname = "MIGRLEGDISCAPACIDAD" ;
      edtMigrLegLugarDePago_Internalname = "MIGRLEGLUGARDEPAGO" ;
      edtMigrLegBanco_Internalname = "MIGRLEGBANCO" ;
      edtMigrLegBanSuc_Internalname = "MIGRLEGBANSUC" ;
      edtMigrLegBanTipCuen_Internalname = "MIGRLEGBANTIPCUEN" ;
      edtMigrLegCuentaBanc_Internalname = "MIGRLEGCUENTABANC" ;
      edtMigrLegFormaPago_Internalname = "MIGRLEGFORMAPAGO" ;
      edtMigrLegActividad_Internalname = "MIGRLEGACTIVIDAD" ;
      edtMigrLegSituacionRevista_Internalname = "MIGRLEGSITUACIONREVISTA" ;
      edtMigrLegCondicion_Internalname = "MIGRLEGCONDICION" ;
      edtMigrLegSiniestrado_Internalname = "MIGRLEGSINIESTRADO" ;
      edtMigrLegSCVO_Internalname = "MIGRLEGSCVO" ;
      edtMigrLegPlanMedico_Internalname = "MIGRLEGPLANMEDICO" ;
      edtMigrTieneConyuge_Internalname = "MIGRTIENECONYUGE" ;
      edtMigrCantidadHijos_Internalname = "MIGRCANTIDADHIJOS" ;
      divHtml_bottomauxiliarcontrols_Internalname = "HTML_BOTTOMAUXILIARCONTROLS" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridlevel1_Internalname = "GRIDLEVEL1" ;
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
      subGridlevel1_Allowcollapsing = (byte)(0) ;
      subGridlevel1_Allowselection = (byte)(0) ;
      subGridlevel1_Header = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Importación de Legajos", "") );
      edtMigrLegFamDiscap_Jsonclick = "" ;
      edtMigrLegFamAdh_Jsonclick = "" ;
      edtMigrLegFamDedGan_Jsonclick = "" ;
      edtMigrLegFamFecNac_Jsonclick = "" ;
      edtMigrLegFamNomApe_Jsonclick = "" ;
      edtMigrLegFamNroDoc_Jsonclick = "" ;
      edtMigrLegFamParen_Jsonclick = "" ;
      edtMigrLegFamSec_Jsonclick = "" ;
      subGridlevel1_Class = "WorkWith" ;
      subGridlevel1_Backcolorstyle = (byte)(0) ;
      edtMigrCantidadHijos_Jsonclick = "" ;
      edtMigrCantidadHijos_Enabled = 1 ;
      edtMigrCantidadHijos_Visible = 1 ;
      edtMigrTieneConyuge_Jsonclick = "" ;
      edtMigrTieneConyuge_Enabled = 1 ;
      edtMigrTieneConyuge_Visible = 1 ;
      edtMigrLegPlanMedico_Enabled = 1 ;
      edtMigrLegPlanMedico_Visible = 1 ;
      edtMigrLegSCVO_Jsonclick = "" ;
      edtMigrLegSCVO_Enabled = 1 ;
      edtMigrLegSCVO_Visible = 1 ;
      edtMigrLegSiniestrado_Enabled = 1 ;
      edtMigrLegSiniestrado_Visible = 1 ;
      edtMigrLegCondicion_Jsonclick = "" ;
      edtMigrLegCondicion_Enabled = 1 ;
      edtMigrLegCondicion_Visible = 1 ;
      edtMigrLegSituacionRevista_Jsonclick = "" ;
      edtMigrLegSituacionRevista_Enabled = 1 ;
      edtMigrLegSituacionRevista_Visible = 1 ;
      edtMigrLegActividad_Jsonclick = "" ;
      edtMigrLegActividad_Enabled = 1 ;
      edtMigrLegActividad_Visible = 1 ;
      edtMigrLegFormaPago_Enabled = 1 ;
      edtMigrLegFormaPago_Visible = 1 ;
      edtMigrLegCuentaBanc_Jsonclick = "" ;
      edtMigrLegCuentaBanc_Enabled = 1 ;
      edtMigrLegCuentaBanc_Visible = 1 ;
      edtMigrLegBanTipCuen_Jsonclick = "" ;
      edtMigrLegBanTipCuen_Enabled = 1 ;
      edtMigrLegBanTipCuen_Visible = 1 ;
      edtMigrLegBanSuc_Enabled = 1 ;
      edtMigrLegBanSuc_Visible = 1 ;
      edtMigrLegBanco_Enabled = 1 ;
      edtMigrLegBanco_Visible = 1 ;
      edtMigrLegLugarDePago_Jsonclick = "" ;
      edtMigrLegLugarDePago_Enabled = 1 ;
      edtMigrLegLugarDePago_Visible = 1 ;
      edtMigrLegDiscapacidad_Jsonclick = "" ;
      edtMigrLegDiscapacidad_Enabled = 1 ;
      edtMigrLegDiscapacidad_Visible = 1 ;
      edtMigrLegZona_Enabled = 1 ;
      edtMigrLegZona_Visible = 1 ;
      edtMigrLegNumero_Jsonclick = "" ;
      edtMigrLegNumero_Enabled = 1 ;
      edtMigrLegNumero_Visible = 1 ;
      edtEmpCod_Jsonclick = "" ;
      edtEmpCod_Enabled = 1 ;
      edtEmpCod_Visible = 1 ;
      edtCliCod_Jsonclick = "" ;
      edtCliCod_Enabled = 1 ;
      edtCliCod_Visible = 1 ;
      bttBtntrn_cancel_Visible = 1 ;
      bttBtntrn_enter_Enabled = 1 ;
      bttBtntrn_enter_Visible = 1 ;
      edtMigrLegFamDiscap_Enabled = 1 ;
      edtMigrLegFamAdh_Enabled = 1 ;
      edtMigrLegFamDedGan_Enabled = 1 ;
      edtMigrLegFamFecNac_Enabled = 1 ;
      edtMigrLegFamNomApe_Enabled = 1 ;
      edtMigrLegFamNroDoc_Enabled = 1 ;
      edtMigrLegFamParen_Enabled = 1 ;
      edtMigrLegFamSec_Enabled = 0 ;
      edtMigrLegObs_Enabled = 1 ;
      cmbMigrLegModalidad.setJsonclick( "" );
      cmbMigrLegModalidad.setEnabled( 1 );
      edtMigrLegCBU_Jsonclick = "" ;
      edtMigrLegCBU_Enabled = 1 ;
      edtMigrLegOSAfip_Jsonclick = "" ;
      edtMigrLegOSAfip_Enabled = 1 ;
      cmbMigrLegObraSocial.setJsonclick( "" );
      cmbMigrLegObraSocial.setEnabled( 1 );
      edtMigrLegBasico_Jsonclick = "" ;
      edtMigrLegBasico_Enabled = 1 ;
      cmbMigrLegArea.setJsonclick( "" );
      cmbMigrLegArea.setEnabled( 1 );
      cmbMigrLegCategoria.setJsonclick( "" );
      cmbMigrLegCategoria.setEnabled( 1 );
      cmbMigrLegConvenio.setJsonclick( "" );
      cmbMigrLegConvenio.setEnabled( 1 );
      cmbMigrLegSindicato.setJsonclick( "" );
      cmbMigrLegSindicato.setEnabled( 1 );
      edtMigrLegEstadoCivil_Enabled = 1 ;
      edtMigrLegEmail_Jsonclick = "" ;
      edtMigrLegEmail_Enabled = 1 ;
      edtMigrLegTelefono_Enabled = 1 ;
      edtMigrLegCodPos_Enabled = 1 ;
      edtMigrLegDomici_Enabled = 1 ;
      edtMigrLegSexo_Jsonclick = "" ;
      edtMigrLegSexo_Enabled = 1 ;
      edtMigrLegFecIngreso_Jsonclick = "" ;
      edtMigrLegFecIngreso_Enabled = 1 ;
      edtMigrLegFecNac_Jsonclick = "" ;
      edtMigrLegFecNac_Enabled = 1 ;
      edtMigrLegClase_Enabled = 1 ;
      edtMigrLegTipoTarifa_Enabled = 1 ;
      edtMigrLegModTra_Enabled = 1 ;
      edtMigrLegNombre_Enabled = 1 ;
      edtMigrLegApellido_Enabled = 1 ;
      edtMigrLegCUIL_Jsonclick = "" ;
      edtMigrLegCUIL_Enabled = 1 ;
      edtMigrLegId_Jsonclick = "" ;
      edtMigrLegId_Enabled = 1 ;
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

   public void gx1asaclicod0175( int AV7CliCod )
   {
      if ( ! (0==AV7CliCod) )
      {
         A3CliCod = AV7CliCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int6 = A3CliCod ;
            GXv_int7[0] = GXt_int6 ;
            new web.getclicod(remoteHandle, context).execute( GXv_int7) ;
            importacion_legajo_impl.this.GXt_int6 = GXv_int7[0] ;
            A3CliCod = GXt_int6 ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gx3asaempcod0175( short AV18EmpCod )
   {
      if ( ! (0==AV18EmpCod) )
      {
         A1EmpCod = AV18EmpCod ;
         httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      }
      else
      {
         if ( GXutil.strcmp(Gx_mode, httpContext.getMessage( httpContext.getMessage( "INS", ""), "")) == 0 )
         {
            GXt_int8 = A1EmpCod ;
            GXv_int9[0] = GXt_int8 ;
            new web.getempcod(remoteHandle, context).execute( GXv_int9) ;
            importacion_legajo_impl.this.GXt_int8 = GXv_int9[0] ;
            A1EmpCod = GXt_int8 ;
            httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
         }
      }
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), ".", "")))+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_34_0175( int A3CliCod ,
                           short A1EmpCod ,
                           String A626MigrLegId )
   {
      GXv_int7[0] = AV65LegNumeroPorId ;
      GXv_char10[0] = AV62LegNomApe ;
      new web.getlegnumeroynomporid(remoteHandle, context).execute( A3CliCod, A1EmpCod, A626MigrLegId, GXv_int7, GXv_char10) ;
      AV65LegNumeroPorId = GXv_int7[0] ;
      AV62LegNomApe = GXv_char10[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV65LegNumeroPorId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV65LegNumeroPorId), 8, 0));
      httpContext.ajax_rsp_assign_attri("", false, "AV62LegNomApe", AV62LegNomApe);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( AV65LegNumeroPorId, (byte)(8), (byte)(0), ".", "")))+"\""+","+"\""+PrivateUtilities.encodeJSConstant( AV62LegNomApe)+"\"") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void xc_36_0175( )
   {
      GXv_int7[0] = AV66LegNumeroPorCUIL ;
      GXv_char10[0] = AV63LegIdNomApe ;
      new web.getlegnumeroynomidporcuil(remoteHandle, context).execute( A3CliCod, A1EmpCod, (long)(DecimalUtil.decToDouble(CommonUtil.decimalVal( A597MigrLegCUIL, "."))), GXv_int7, GXv_char10) ;
      AV66LegNumeroPorCUIL = GXv_int7[0] ;
      AV63LegIdNomApe = GXv_char10[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "AV66LegNumeroPorCUIL", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV66LegNumeroPorCUIL), 8, 0));
      httpContext.ajax_rsp_assign_attri("", false, "AV63LegIdNomApe", AV63LegIdNomApe);
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "]") ;
      if ( true )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
   }

   public void gxnrgridlevel1_newrow( )
   {
      web.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_203262( ) ;
      while ( nGXsfl_203_idx <= nRC_GXsfl_203 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal01262( ) ;
         standaloneModal01262( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow01262( ) ;
         nGXsfl_203_idx = (int)(nGXsfl_203_idx+1) ;
         sGXsfl_203_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_203_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_203262( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridlevel1Container)) ;
      /* End function gxnrGridlevel1_newrow */
   }

   public void init_web_controls( )
   {
      cmbMigrLegSindicato.setName( "MIGRLEGSINDICATO" );
      cmbMigrLegSindicato.setWebtags( "" );
      if ( cmbMigrLegSindicato.getItemCount() > 0 )
      {
         A613MigrLegSindicato = cmbMigrLegSindicato.getValidValue(A613MigrLegSindicato) ;
         httpContext.ajax_rsp_assign_attri("", false, "A613MigrLegSindicato", A613MigrLegSindicato);
      }
      cmbMigrLegConvenio.setName( "MIGRLEGCONVENIO" );
      cmbMigrLegConvenio.setWebtags( "" );
      if ( cmbMigrLegConvenio.getItemCount() > 0 )
      {
         A627MigrLegConvenio = cmbMigrLegConvenio.getValidValue(A627MigrLegConvenio) ;
         httpContext.ajax_rsp_assign_attri("", false, "A627MigrLegConvenio", A627MigrLegConvenio);
      }
      cmbMigrLegCategoria.setName( "MIGRLEGCATEGORIA" );
      cmbMigrLegCategoria.setWebtags( "" );
      if ( cmbMigrLegCategoria.getItemCount() > 0 )
      {
         A604MigrLegCategoria = cmbMigrLegCategoria.getValidValue(A604MigrLegCategoria) ;
         httpContext.ajax_rsp_assign_attri("", false, "A604MigrLegCategoria", A604MigrLegCategoria);
      }
      cmbMigrLegArea.setName( "MIGRLEGAREA" );
      cmbMigrLegArea.setWebtags( "" );
      if ( cmbMigrLegArea.getItemCount() > 0 )
      {
         A605MigrLegArea = cmbMigrLegArea.getValidValue(A605MigrLegArea) ;
         httpContext.ajax_rsp_assign_attri("", false, "A605MigrLegArea", A605MigrLegArea);
      }
      cmbMigrLegObraSocial.setName( "MIGRLEGOBRASOCIAL" );
      cmbMigrLegObraSocial.setWebtags( "" );
      if ( cmbMigrLegObraSocial.getItemCount() > 0 )
      {
         A614MigrLegObraSocial = cmbMigrLegObraSocial.getValidValue(A614MigrLegObraSocial) ;
         httpContext.ajax_rsp_assign_attri("", false, "A614MigrLegObraSocial", A614MigrLegObraSocial);
      }
      cmbMigrLegModalidad.setName( "MIGRLEGMODALIDAD" );
      cmbMigrLegModalidad.setWebtags( "" );
      if ( cmbMigrLegModalidad.getItemCount() > 0 )
      {
         A617MigrLegModalidad = cmbMigrLegModalidad.getValidValue(A617MigrLegModalidad) ;
         httpContext.ajax_rsp_assign_attri("", false, "A617MigrLegModalidad", A617MigrLegModalidad);
      }
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

   public void valid_Empcod( )
   {
      /* Using cursor T000122 */
      pr_default.execute(20, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod)});
      if ( (pr_default.getStatus(20) == 101) )
      {
         httpContext.GX_msglist.addItem(GXutil.format( httpContext.getMessage( "GXSPC_ForeignKeyNotFound", ""), httpContext.getMessage( "Empresa", ""), "", "", "", "", "", "", "", ""), "ForeignKeyNotFound", 1, "EMPCOD");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCliCod_Internalname ;
      }
      pr_default.close(20);
      dynload_actions( ) ;
      /*  Sending validation outputs */
   }

   public void valid_Migrlegid( )
   {
      GXv_int7[0] = AV65LegNumeroPorId ;
      GXv_char10[0] = AV62LegNomApe ;
      new web.getlegnumeroynomporid(remoteHandle, context).execute( A3CliCod, A1EmpCod, A626MigrLegId, GXv_int7, GXv_char10) ;
      importacion_legajo_impl.this.AV65LegNumeroPorId = GXv_int7[0] ;
      AV65LegNumeroPorId = this.AV65LegNumeroPorId ;
      importacion_legajo_impl.this.AV62LegNomApe = GXv_char10[0] ;
      AV62LegNomApe = this.AV62LegNomApe ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV65LegNumeroPorId", GXutil.ltrim( localUtil.ntoc( AV65LegNumeroPorId, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "AV62LegNomApe", AV62LegNomApe);
   }

   public void valid_Migrlegcuil( )
   {
      GXv_int7[0] = AV66LegNumeroPorCUIL ;
      GXv_char10[0] = AV63LegIdNomApe ;
      new web.getlegnumeroynomidporcuil(remoteHandle, context).execute( A3CliCod, A1EmpCod, (long)(DecimalUtil.decToDouble(CommonUtil.decimalVal( A597MigrLegCUIL, "."))), GXv_int7, GXv_char10) ;
      importacion_legajo_impl.this.AV66LegNumeroPorCUIL = GXv_int7[0] ;
      AV66LegNumeroPorCUIL = this.AV66LegNumeroPorCUIL ;
      importacion_legajo_impl.this.AV63LegIdNomApe = GXv_char10[0] ;
      AV63LegIdNomApe = this.AV63LegIdNomApe ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV66LegNumeroPorCUIL", GXutil.ltrim( localUtil.ntoc( AV66LegNumeroPorCUIL, (byte)(8), (byte)(0), ".", "")));
      httpContext.ajax_rsp_assign_attri("", false, "AV63LegIdNomApe", AV63LegIdNomApe);
   }

   public void valid_Migrlegcategoria( )
   {
      A604MigrLegCategoria = cmbMigrLegCategoria.getValue() ;
      AV64AuxMigrLegCategoria = A604MigrLegCategoria ;
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "AV64AuxMigrLegCategoria", AV64AuxMigrLegCategoria);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV40MigrLegNumero',fld:'vMIGRLEGNUMERO',pic:'ZZZZZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A2197MigrValCadaSave',fld:'MIGRVALCADASAVE',pic:'',hsh:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CliCod',fld:'vCLICOD',pic:'ZZZZZ9',hsh:true},{av:'AV18EmpCod',fld:'vEMPCOD',pic:'ZZZ9',hsh:true},{av:'AV40MigrLegNumero',fld:'vMIGRLEGNUMERO',pic:'ZZZZZZZ9',hsh:true},{av:'A691MigrLegClaseDef',fld:'MIGRLEGCLASEDEF',pic:''},{av:'A618MigrLegFecUltMod',fld:'MIGRLEGFECULTMOD',pic:''},{av:'A635MigrEncontroOsoSigla',fld:'MIGRENCONTROOSOSIGLA',pic:''},{av:'A1398MigrTraDiurno',fld:'MIGRTRADIURNO',pic:''},{av:'A1399MigrTraNoct',fld:'MIGRTRANOCT',pic:''},{av:'A1400MigrTraIns',fld:'MIGRTRAINS',pic:''},{av:'A1820MigrEncontroOsoAfip',fld:'MIGRENCONTROOSOAFIP',pic:''},{av:'A2190MigrPeriodo',fld:'MIGRPERIODO',pic:''},{av:'A695MigrLegModalidadDef',fld:'MIGRLEGMODALIDADDEF',pic:''},{av:'A696MigrLegZonaDef',fld:'MIGRLEGZONADEF',pic:''},{av:'A698MigrLegSituacionDef',fld:'MIGRLEGSITUACIONDEF',pic:''},{av:'A690MigrLegEstadoCivilDef',fld:'MIGRLEGESTADOCIVILDEF',pic:''},{av:'A692MigrLegFormaPagoDef',fld:'MIGRLEGFORMAPAGODEF',pic:''},{av:'A693MigrLegTipoCuentaDef',fld:'MIGRLEGTIPOCUENTADEF',pic:''},{av:'A694MigrLegActividadDef',fld:'MIGRLEGACTIVIDADDEF',pic:''},{av:'A699MigrLegCondicionDef',fld:'MIGRLEGCONDICIONDEF',pic:''},{av:'A700MigrLegSiniestradoDef',fld:'MIGRLEGSINIESTRADODEF',pic:''},{av:'A2205MigrLegFecEgreso',fld:'MIGRLEGFECEGRESO',pic:''},{av:'A2216MigrPuesto',fld:'MIGRPUESTO',pic:''},{av:'A2221MigrLegMarcaCCT',fld:'MIGRLEGMARCACCT',pic:''},{av:'A2222MigrArchSec',fld:'MIGRARCHSEC',pic:'ZZZ9'},{av:'A2239MigrLegActLabClas',fld:'MIGRLEGACTLABCLAS',pic:''},{av:'A2240MigrLegPueAfip',fld:'MIGRLEGPUEAFIP',pic:''},{av:'A2275MigrLegHorSem',fld:'MIGRLEGHORSEM',pic:'Z9.9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12012',iparms:[{av:'AV69Pgmname',fld:'vPGMNAME',pic:''},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'A2197MigrValCadaSave',fld:'MIGRVALCADASAVE',pic:'',hsh:true},{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A87MigrLegNumero',fld:'MIGRLEGNUMERO',pic:'ZZZZZZZ9'}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGID","{handler:'valid_Migrlegid',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A626MigrLegId',fld:'MIGRLEGID',pic:''},{av:'AV65LegNumeroPorId',fld:'vLEGNUMEROPORID',pic:'ZZZZZZZ9'},{av:'AV62LegNomApe',fld:'vLEGNOMAPE',pic:''}]");
      setEventMetadata("VALID_MIGRLEGID",",oparms:[{av:'AV65LegNumeroPorId',fld:'vLEGNUMEROPORID',pic:'ZZZZZZZ9'},{av:'AV62LegNomApe',fld:'vLEGNOMAPE',pic:''}]}");
      setEventMetadata("VALID_MIGRLEGCUIL","{handler:'valid_Migrlegcuil',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A597MigrLegCUIL',fld:'MIGRLEGCUIL',pic:''},{av:'AV66LegNumeroPorCUIL',fld:'vLEGNUMEROPORCUIL',pic:'ZZZZZZZ9'},{av:'AV63LegIdNomApe',fld:'vLEGIDNOMAPE',pic:''}]");
      setEventMetadata("VALID_MIGRLEGCUIL",",oparms:[{av:'AV66LegNumeroPorCUIL',fld:'vLEGNUMEROPORCUIL',pic:'ZZZZZZZ9'},{av:'AV63LegIdNomApe',fld:'vLEGIDNOMAPE',pic:''}]}");
      setEventMetadata("VALID_MIGRLEGAPELLIDO","{handler:'valid_Migrlegapellido',iparms:[]");
      setEventMetadata("VALID_MIGRLEGAPELLIDO",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGNOMBRE","{handler:'valid_Migrlegnombre',iparms:[]");
      setEventMetadata("VALID_MIGRLEGNOMBRE",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGCLASE","{handler:'valid_Migrlegclase',iparms:[]");
      setEventMetadata("VALID_MIGRLEGCLASE",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGFECNAC","{handler:'valid_Migrlegfecnac',iparms:[]");
      setEventMetadata("VALID_MIGRLEGFECNAC",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGFECINGRESO","{handler:'valid_Migrlegfecingreso',iparms:[]");
      setEventMetadata("VALID_MIGRLEGFECINGRESO",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGSEXO","{handler:'valid_Migrlegsexo',iparms:[]");
      setEventMetadata("VALID_MIGRLEGSEXO",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGESTADOCIVIL","{handler:'valid_Migrlegestadocivil',iparms:[]");
      setEventMetadata("VALID_MIGRLEGESTADOCIVIL",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGCATEGORIA","{handler:'valid_Migrlegcategoria',iparms:[{av:'cmbMigrLegCategoria'},{av:'A604MigrLegCategoria',fld:'MIGRLEGCATEGORIA',pic:''},{av:'AV64AuxMigrLegCategoria',fld:'vAUXMIGRLEGCATEGORIA',pic:''}]");
      setEventMetadata("VALID_MIGRLEGCATEGORIA",",oparms:[{av:'AV64AuxMigrLegCategoria',fld:'vAUXMIGRLEGCATEGORIA',pic:''}]}");
      setEventMetadata("VALID_MIGRLEGAREA","{handler:'valid_Migrlegarea',iparms:[]");
      setEventMetadata("VALID_MIGRLEGAREA",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGBASICO","{handler:'valid_Migrlegbasico',iparms:[]");
      setEventMetadata("VALID_MIGRLEGBASICO",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGOBRASOCIAL","{handler:'valid_Migrlegobrasocial',iparms:[]");
      setEventMetadata("VALID_MIGRLEGOBRASOCIAL",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGOSAFIP","{handler:'valid_Migrlegosafip',iparms:[]");
      setEventMetadata("VALID_MIGRLEGOSAFIP",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGMODALIDAD","{handler:'valid_Migrlegmodalidad',iparms:[]");
      setEventMetadata("VALID_MIGRLEGMODALIDAD",",oparms:[]}");
      setEventMetadata("VALID_CLICOD","{handler:'valid_Clicod',iparms:[]");
      setEventMetadata("VALID_CLICOD",",oparms:[]}");
      setEventMetadata("VALID_EMPCOD","{handler:'valid_Empcod',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'}]");
      setEventMetadata("VALID_EMPCOD",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGNUMERO","{handler:'valid_Migrlegnumero',iparms:[]");
      setEventMetadata("VALID_MIGRLEGNUMERO",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGZONA","{handler:'valid_Migrlegzona',iparms:[]");
      setEventMetadata("VALID_MIGRLEGZONA",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGFORMAPAGO","{handler:'valid_Migrlegformapago',iparms:[]");
      setEventMetadata("VALID_MIGRLEGFORMAPAGO",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGACTIVIDAD","{handler:'valid_Migrlegactividad',iparms:[]");
      setEventMetadata("VALID_MIGRLEGACTIVIDAD",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGSITUACIONREVISTA","{handler:'valid_Migrlegsituacionrevista',iparms:[]");
      setEventMetadata("VALID_MIGRLEGSITUACIONREVISTA",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGCONDICION","{handler:'valid_Migrlegcondicion',iparms:[]");
      setEventMetadata("VALID_MIGRLEGCONDICION",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGSINIESTRADO","{handler:'valid_Migrlegsiniestrado',iparms:[]");
      setEventMetadata("VALID_MIGRLEGSINIESTRADO",",oparms:[]}");
      setEventMetadata("VALID_MIGRLEGFAMSEC","{handler:'valid_Migrlegfamsec',iparms:[]");
      setEventMetadata("VALID_MIGRLEGFAMSEC",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Migrlegfamdiscap',iparms:[]");
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
      pr_default.close(20);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z592MigrLegApellido = "" ;
      Z593MigrLegNombre = "" ;
      Z594MigrLegFecNac = GXutil.nullDate() ;
      Z595MigrLegSexo = "" ;
      Z596MigrLegEstadoCivil = "" ;
      Z597MigrLegCUIL = "" ;
      Z598MigrLegDiscapacidad = "" ;
      Z599MigrLegDomici = "" ;
      Z600MigrLegEmail = "" ;
      Z601MigrLegCodPos = "" ;
      Z602MigrLegTelefono = "" ;
      Z603MigrLegFecIngreso = GXutil.nullDate() ;
      Z604MigrLegCategoria = "" ;
      Z605MigrLegArea = "" ;
      Z606MigrLegLugarDePago = "" ;
      Z2415MigrLegModTra = "" ;
      Z2427MigrLegTipoTarifa = "" ;
      Z607MigrLegClase = "" ;
      Z608MigrLegBasico = DecimalUtil.ZERO ;
      Z609MigrLegFormaPago = "" ;
      Z610MigrLegBanco = "" ;
      Z611MigrLegBanSuc = "" ;
      Z612MigrLegBanTipCuen = "" ;
      Z613MigrLegSindicato = "" ;
      Z614MigrLegObraSocial = "" ;
      Z634MigrLegOSAfip = "" ;
      Z615MigrLegPlanMedico = "" ;
      Z616MigrLegActividad = "" ;
      Z617MigrLegModalidad = "" ;
      Z618MigrLegFecUltMod = GXutil.nullDate() ;
      Z619MigrLegCuentaBanc = "" ;
      Z620MigrLegZona = "" ;
      Z621MigrLegCBU = "" ;
      Z622MigrLegSCVO = "" ;
      Z623MigrLegSituacionRevista = "" ;
      Z624MigrLegCondicion = "" ;
      Z625MigrLegSiniestrado = "" ;
      Z626MigrLegId = "" ;
      Z627MigrLegConvenio = "" ;
      Z631MigrTieneConyuge = "" ;
      Z1398MigrTraDiurno = "" ;
      Z1399MigrTraNoct = "" ;
      Z1400MigrTraIns = "" ;
      Z2190MigrPeriodo = GXutil.nullDate() ;
      Z2205MigrLegFecEgreso = GXutil.nullDate() ;
      Z2216MigrPuesto = "" ;
      Z2221MigrLegMarcaCCT = "" ;
      Z2239MigrLegActLabClas = "" ;
      Z2240MigrLegPueAfip = "" ;
      Z2275MigrLegHorSem = DecimalUtil.ZERO ;
      O634MigrLegOSAfip = "" ;
      N634MigrLegOSAfip = "" ;
      Z2079MigrLegFamParen = "" ;
      Z2080MigrLegFamNroDoc = "" ;
      Z2081MigrLegFamDedGan = DecimalUtil.ZERO ;
      Z2082MigrLegFamAdh = "" ;
      Z2086MigrLegFamDiscap = "" ;
      Z2088MigrLegFamNomApe = "" ;
      Z2089MigrLegFamFecNac = GXutil.nullDate() ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A626MigrLegId = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      A613MigrLegSindicato = "" ;
      A627MigrLegConvenio = "" ;
      A604MigrLegCategoria = "" ;
      A605MigrLegArea = "" ;
      A614MigrLegObraSocial = "" ;
      A617MigrLegModalidad = "" ;
      sStyleString = "" ;
      ucDvpanel_tableattributes = new com.genexus.webpanels.GXUserControl();
      TempTags = "" ;
      A597MigrLegCUIL = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A592MigrLegApellido = "" ;
      A593MigrLegNombre = "" ;
      A2415MigrLegModTra = "" ;
      A2427MigrLegTipoTarifa = "" ;
      A607MigrLegClase = "" ;
      A594MigrLegFecNac = GXutil.nullDate() ;
      A603MigrLegFecIngreso = GXutil.nullDate() ;
      A595MigrLegSexo = "" ;
      A599MigrLegDomici = "" ;
      A601MigrLegCodPos = "" ;
      A602MigrLegTelefono = "" ;
      A600MigrLegEmail = "" ;
      A596MigrLegEstadoCivil = "" ;
      lblTextblockmigrlegsindicato_Jsonclick = "" ;
      lblMigrlegsindicato_righttext_Jsonclick = "" ;
      lblTextblockmigrlegconvenio_Jsonclick = "" ;
      lblMigrlegconvenio_righttext_Jsonclick = "" ;
      lblTextblockmigrlegcategoria_Jsonclick = "" ;
      lblMigrlegcategoria_righttext_Jsonclick = "" ;
      lblTextblockmigrlegarea_Jsonclick = "" ;
      lblMigrlegarea_righttext_Jsonclick = "" ;
      A608MigrLegBasico = DecimalUtil.ZERO ;
      lblTextblockmigrlegobrasocial_Jsonclick = "" ;
      lblMigrlegobrasocial_righttext_Jsonclick = "" ;
      A634MigrLegOSAfip = "" ;
      A621MigrLegCBU = "" ;
      lblTextblockmigrlegmodalidad_Jsonclick = "" ;
      lblMigrlegmodalidad_righttext_Jsonclick = "" ;
      A628MigrLegObs = "" ;
      Gridlevel1Container = new com.genexus.webpanels.GXWebGrid(context);
      B634MigrLegOSAfip = "" ;
      sMode262 = "" ;
      bttBtntrn_enter_Jsonclick = "" ;
      bttBtntrn_cancel_Jsonclick = "" ;
      A620MigrLegZona = "" ;
      A598MigrLegDiscapacidad = "" ;
      A606MigrLegLugarDePago = "" ;
      A610MigrLegBanco = "" ;
      A611MigrLegBanSuc = "" ;
      A612MigrLegBanTipCuen = "" ;
      A619MigrLegCuentaBanc = "" ;
      A609MigrLegFormaPago = "" ;
      A616MigrLegActividad = "" ;
      A623MigrLegSituacionRevista = "" ;
      A624MigrLegCondicion = "" ;
      A625MigrLegSiniestrado = "" ;
      A622MigrLegSCVO = "" ;
      A615MigrLegPlanMedico = "" ;
      A631MigrTieneConyuge = "" ;
      A2221MigrLegMarcaCCT = "" ;
      A618MigrLegFecUltMod = GXutil.nullDate() ;
      A1398MigrTraDiurno = "" ;
      A1399MigrTraNoct = "" ;
      A1400MigrTraIns = "" ;
      A2190MigrPeriodo = GXutil.nullDate() ;
      A2205MigrLegFecEgreso = GXutil.nullDate() ;
      A2216MigrPuesto = "" ;
      A2239MigrLegActLabClas = "" ;
      A2240MigrLegPueAfip = "" ;
      A2275MigrLegHorSem = DecimalUtil.ZERO ;
      AV64AuxMigrLegCategoria = "" ;
      AV62LegNomApe = "" ;
      AV63LegIdNomApe = "" ;
      A629MigrLegErrores = "" ;
      A633MigrLegWarnings = "" ;
      A2189MigrSueldos = "" ;
      A2206MigrOtrosDatos = "" ;
      AV69Pgmname = "" ;
      Dvpanel_tableattributes_Objectcall = "" ;
      Dvpanel_tableattributes_Class = "" ;
      Dvpanel_tableattributes_Height = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode75 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      A2079MigrLegFamParen = "" ;
      A2080MigrLegFamNroDoc = "" ;
      A2088MigrLegFamNomApe = "" ;
      A2089MigrLegFamFecNac = GXutil.nullDate() ;
      A2081MigrLegFamDedGan = DecimalUtil.ZERO ;
      A2082MigrLegFamAdh = "" ;
      A2086MigrLegFamDiscap = "" ;
      AV56WWPContext = new web.wwpbaseobjects.SdtWWPContext(remoteHandle, context);
      GXv_SdtWWPContext1 = new web.wwpbaseobjects.SdtWWPContext[1] ;
      GXv_boolean3 = new boolean[1] ;
      AV54TrnContext = new web.wwpbaseobjects.SdtWWPTransactionContext(remoteHandle, context);
      AV55WebSession = httpContext.getWebSession();
      AV67errores = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_svchar4 = new GXSimpleCollection[1] ;
      AV68warnings = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_svchar5 = new GXSimpleCollection[1] ;
      Z628MigrLegObs = "" ;
      Z629MigrLegErrores = "" ;
      Z633MigrLegWarnings = "" ;
      Z2189MigrSueldos = "" ;
      Z2206MigrOtrosDatos = "" ;
      T00017_A87MigrLegNumero = new int[1] ;
      T00017_A592MigrLegApellido = new String[] {""} ;
      T00017_A593MigrLegNombre = new String[] {""} ;
      T00017_A594MigrLegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      T00017_A595MigrLegSexo = new String[] {""} ;
      T00017_A596MigrLegEstadoCivil = new String[] {""} ;
      T00017_A597MigrLegCUIL = new String[] {""} ;
      T00017_A598MigrLegDiscapacidad = new String[] {""} ;
      T00017_A599MigrLegDomici = new String[] {""} ;
      T00017_A600MigrLegEmail = new String[] {""} ;
      T00017_A601MigrLegCodPos = new String[] {""} ;
      T00017_A602MigrLegTelefono = new String[] {""} ;
      T00017_A603MigrLegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      T00017_A604MigrLegCategoria = new String[] {""} ;
      T00017_A605MigrLegArea = new String[] {""} ;
      T00017_A606MigrLegLugarDePago = new String[] {""} ;
      T00017_A2415MigrLegModTra = new String[] {""} ;
      T00017_A2427MigrLegTipoTarifa = new String[] {""} ;
      T00017_A607MigrLegClase = new String[] {""} ;
      T00017_A608MigrLegBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00017_A609MigrLegFormaPago = new String[] {""} ;
      T00017_A691MigrLegClaseDef = new boolean[] {false} ;
      T00017_A610MigrLegBanco = new String[] {""} ;
      T00017_A611MigrLegBanSuc = new String[] {""} ;
      T00017_A612MigrLegBanTipCuen = new String[] {""} ;
      T00017_A613MigrLegSindicato = new String[] {""} ;
      T00017_A614MigrLegObraSocial = new String[] {""} ;
      T00017_A634MigrLegOSAfip = new String[] {""} ;
      T00017_A615MigrLegPlanMedico = new String[] {""} ;
      T00017_A616MigrLegActividad = new String[] {""} ;
      T00017_A617MigrLegModalidad = new String[] {""} ;
      T00017_A618MigrLegFecUltMod = new java.util.Date[] {GXutil.nullDate()} ;
      T00017_A619MigrLegCuentaBanc = new String[] {""} ;
      T00017_A620MigrLegZona = new String[] {""} ;
      T00017_A621MigrLegCBU = new String[] {""} ;
      T00017_A622MigrLegSCVO = new String[] {""} ;
      T00017_A623MigrLegSituacionRevista = new String[] {""} ;
      T00017_A624MigrLegCondicion = new String[] {""} ;
      T00017_A625MigrLegSiniestrado = new String[] {""} ;
      T00017_A626MigrLegId = new String[] {""} ;
      T00017_A627MigrLegConvenio = new String[] {""} ;
      T00017_A628MigrLegObs = new String[] {""} ;
      T00017_A629MigrLegErrores = new String[] {""} ;
      T00017_A633MigrLegWarnings = new String[] {""} ;
      T00017_A631MigrTieneConyuge = new String[] {""} ;
      T00017_A632MigrCantidadHijos = new short[1] ;
      T00017_A635MigrEncontroOsoSigla = new boolean[] {false} ;
      T00017_A1398MigrTraDiurno = new String[] {""} ;
      T00017_A1399MigrTraNoct = new String[] {""} ;
      T00017_A1400MigrTraIns = new String[] {""} ;
      T00017_A1820MigrEncontroOsoAfip = new boolean[] {false} ;
      T00017_A2189MigrSueldos = new String[] {""} ;
      T00017_A2190MigrPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T00017_A695MigrLegModalidadDef = new boolean[] {false} ;
      T00017_A696MigrLegZonaDef = new boolean[] {false} ;
      T00017_A698MigrLegSituacionDef = new boolean[] {false} ;
      T00017_A690MigrLegEstadoCivilDef = new boolean[] {false} ;
      T00017_A692MigrLegFormaPagoDef = new boolean[] {false} ;
      T00017_A693MigrLegTipoCuentaDef = new boolean[] {false} ;
      T00017_A694MigrLegActividadDef = new boolean[] {false} ;
      T00017_A699MigrLegCondicionDef = new boolean[] {false} ;
      T00017_A700MigrLegSiniestradoDef = new boolean[] {false} ;
      T00017_A2197MigrValCadaSave = new boolean[] {false} ;
      T00017_A2205MigrLegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      T00017_A2206MigrOtrosDatos = new String[] {""} ;
      T00017_A2216MigrPuesto = new String[] {""} ;
      T00017_A2221MigrLegMarcaCCT = new String[] {""} ;
      T00017_n2221MigrLegMarcaCCT = new boolean[] {false} ;
      T00017_A2222MigrArchSec = new short[1] ;
      T00017_n2222MigrArchSec = new boolean[] {false} ;
      T00017_A2239MigrLegActLabClas = new String[] {""} ;
      T00017_A2240MigrLegPueAfip = new String[] {""} ;
      T00017_A2275MigrLegHorSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00017_A3CliCod = new int[1] ;
      T00017_A1EmpCod = new short[1] ;
      T00016_A3CliCod = new int[1] ;
      T00018_A3CliCod = new int[1] ;
      T00019_A3CliCod = new int[1] ;
      T00019_A1EmpCod = new short[1] ;
      T00019_A87MigrLegNumero = new int[1] ;
      T00015_A87MigrLegNumero = new int[1] ;
      T00015_A592MigrLegApellido = new String[] {""} ;
      T00015_A593MigrLegNombre = new String[] {""} ;
      T00015_A594MigrLegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      T00015_A595MigrLegSexo = new String[] {""} ;
      T00015_A596MigrLegEstadoCivil = new String[] {""} ;
      T00015_A597MigrLegCUIL = new String[] {""} ;
      T00015_A598MigrLegDiscapacidad = new String[] {""} ;
      T00015_A599MigrLegDomici = new String[] {""} ;
      T00015_A600MigrLegEmail = new String[] {""} ;
      T00015_A601MigrLegCodPos = new String[] {""} ;
      T00015_A602MigrLegTelefono = new String[] {""} ;
      T00015_A603MigrLegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      T00015_A604MigrLegCategoria = new String[] {""} ;
      T00015_A605MigrLegArea = new String[] {""} ;
      T00015_A606MigrLegLugarDePago = new String[] {""} ;
      T00015_A2415MigrLegModTra = new String[] {""} ;
      T00015_A2427MigrLegTipoTarifa = new String[] {""} ;
      T00015_A607MigrLegClase = new String[] {""} ;
      T00015_A608MigrLegBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00015_A609MigrLegFormaPago = new String[] {""} ;
      T00015_A691MigrLegClaseDef = new boolean[] {false} ;
      T00015_A610MigrLegBanco = new String[] {""} ;
      T00015_A611MigrLegBanSuc = new String[] {""} ;
      T00015_A612MigrLegBanTipCuen = new String[] {""} ;
      T00015_A613MigrLegSindicato = new String[] {""} ;
      T00015_A614MigrLegObraSocial = new String[] {""} ;
      T00015_A634MigrLegOSAfip = new String[] {""} ;
      T00015_A615MigrLegPlanMedico = new String[] {""} ;
      T00015_A616MigrLegActividad = new String[] {""} ;
      T00015_A617MigrLegModalidad = new String[] {""} ;
      T00015_A618MigrLegFecUltMod = new java.util.Date[] {GXutil.nullDate()} ;
      T00015_A619MigrLegCuentaBanc = new String[] {""} ;
      T00015_A620MigrLegZona = new String[] {""} ;
      T00015_A621MigrLegCBU = new String[] {""} ;
      T00015_A622MigrLegSCVO = new String[] {""} ;
      T00015_A623MigrLegSituacionRevista = new String[] {""} ;
      T00015_A624MigrLegCondicion = new String[] {""} ;
      T00015_A625MigrLegSiniestrado = new String[] {""} ;
      T00015_A626MigrLegId = new String[] {""} ;
      T00015_A627MigrLegConvenio = new String[] {""} ;
      T00015_A628MigrLegObs = new String[] {""} ;
      T00015_A629MigrLegErrores = new String[] {""} ;
      T00015_A633MigrLegWarnings = new String[] {""} ;
      T00015_A631MigrTieneConyuge = new String[] {""} ;
      T00015_A632MigrCantidadHijos = new short[1] ;
      T00015_A635MigrEncontroOsoSigla = new boolean[] {false} ;
      T00015_A1398MigrTraDiurno = new String[] {""} ;
      T00015_A1399MigrTraNoct = new String[] {""} ;
      T00015_A1400MigrTraIns = new String[] {""} ;
      T00015_A1820MigrEncontroOsoAfip = new boolean[] {false} ;
      T00015_A2189MigrSueldos = new String[] {""} ;
      T00015_A2190MigrPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T00015_A695MigrLegModalidadDef = new boolean[] {false} ;
      T00015_A696MigrLegZonaDef = new boolean[] {false} ;
      T00015_A698MigrLegSituacionDef = new boolean[] {false} ;
      T00015_A690MigrLegEstadoCivilDef = new boolean[] {false} ;
      T00015_A692MigrLegFormaPagoDef = new boolean[] {false} ;
      T00015_A693MigrLegTipoCuentaDef = new boolean[] {false} ;
      T00015_A694MigrLegActividadDef = new boolean[] {false} ;
      T00015_A699MigrLegCondicionDef = new boolean[] {false} ;
      T00015_A700MigrLegSiniestradoDef = new boolean[] {false} ;
      T00015_A2197MigrValCadaSave = new boolean[] {false} ;
      T00015_A2205MigrLegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      T00015_A2206MigrOtrosDatos = new String[] {""} ;
      T00015_A2216MigrPuesto = new String[] {""} ;
      T00015_A2221MigrLegMarcaCCT = new String[] {""} ;
      T00015_n2221MigrLegMarcaCCT = new boolean[] {false} ;
      T00015_A2222MigrArchSec = new short[1] ;
      T00015_n2222MigrArchSec = new boolean[] {false} ;
      T00015_A2239MigrLegActLabClas = new String[] {""} ;
      T00015_A2240MigrLegPueAfip = new String[] {""} ;
      T00015_A2275MigrLegHorSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00015_A3CliCod = new int[1] ;
      T00015_A1EmpCod = new short[1] ;
      T000110_A3CliCod = new int[1] ;
      T000110_A1EmpCod = new short[1] ;
      T000110_A87MigrLegNumero = new int[1] ;
      T000111_A3CliCod = new int[1] ;
      T000111_A1EmpCod = new short[1] ;
      T000111_A87MigrLegNumero = new int[1] ;
      T00014_A87MigrLegNumero = new int[1] ;
      T00014_A592MigrLegApellido = new String[] {""} ;
      T00014_A593MigrLegNombre = new String[] {""} ;
      T00014_A594MigrLegFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      T00014_A595MigrLegSexo = new String[] {""} ;
      T00014_A596MigrLegEstadoCivil = new String[] {""} ;
      T00014_A597MigrLegCUIL = new String[] {""} ;
      T00014_A598MigrLegDiscapacidad = new String[] {""} ;
      T00014_A599MigrLegDomici = new String[] {""} ;
      T00014_A600MigrLegEmail = new String[] {""} ;
      T00014_A601MigrLegCodPos = new String[] {""} ;
      T00014_A602MigrLegTelefono = new String[] {""} ;
      T00014_A603MigrLegFecIngreso = new java.util.Date[] {GXutil.nullDate()} ;
      T00014_A604MigrLegCategoria = new String[] {""} ;
      T00014_A605MigrLegArea = new String[] {""} ;
      T00014_A606MigrLegLugarDePago = new String[] {""} ;
      T00014_A2415MigrLegModTra = new String[] {""} ;
      T00014_A2427MigrLegTipoTarifa = new String[] {""} ;
      T00014_A607MigrLegClase = new String[] {""} ;
      T00014_A608MigrLegBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00014_A609MigrLegFormaPago = new String[] {""} ;
      T00014_A691MigrLegClaseDef = new boolean[] {false} ;
      T00014_A610MigrLegBanco = new String[] {""} ;
      T00014_A611MigrLegBanSuc = new String[] {""} ;
      T00014_A612MigrLegBanTipCuen = new String[] {""} ;
      T00014_A613MigrLegSindicato = new String[] {""} ;
      T00014_A614MigrLegObraSocial = new String[] {""} ;
      T00014_A634MigrLegOSAfip = new String[] {""} ;
      T00014_A615MigrLegPlanMedico = new String[] {""} ;
      T00014_A616MigrLegActividad = new String[] {""} ;
      T00014_A617MigrLegModalidad = new String[] {""} ;
      T00014_A618MigrLegFecUltMod = new java.util.Date[] {GXutil.nullDate()} ;
      T00014_A619MigrLegCuentaBanc = new String[] {""} ;
      T00014_A620MigrLegZona = new String[] {""} ;
      T00014_A621MigrLegCBU = new String[] {""} ;
      T00014_A622MigrLegSCVO = new String[] {""} ;
      T00014_A623MigrLegSituacionRevista = new String[] {""} ;
      T00014_A624MigrLegCondicion = new String[] {""} ;
      T00014_A625MigrLegSiniestrado = new String[] {""} ;
      T00014_A626MigrLegId = new String[] {""} ;
      T00014_A627MigrLegConvenio = new String[] {""} ;
      T00014_A628MigrLegObs = new String[] {""} ;
      T00014_A629MigrLegErrores = new String[] {""} ;
      T00014_A633MigrLegWarnings = new String[] {""} ;
      T00014_A631MigrTieneConyuge = new String[] {""} ;
      T00014_A632MigrCantidadHijos = new short[1] ;
      T00014_A635MigrEncontroOsoSigla = new boolean[] {false} ;
      T00014_A1398MigrTraDiurno = new String[] {""} ;
      T00014_A1399MigrTraNoct = new String[] {""} ;
      T00014_A1400MigrTraIns = new String[] {""} ;
      T00014_A1820MigrEncontroOsoAfip = new boolean[] {false} ;
      T00014_A2189MigrSueldos = new String[] {""} ;
      T00014_A2190MigrPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      T00014_A695MigrLegModalidadDef = new boolean[] {false} ;
      T00014_A696MigrLegZonaDef = new boolean[] {false} ;
      T00014_A698MigrLegSituacionDef = new boolean[] {false} ;
      T00014_A690MigrLegEstadoCivilDef = new boolean[] {false} ;
      T00014_A692MigrLegFormaPagoDef = new boolean[] {false} ;
      T00014_A693MigrLegTipoCuentaDef = new boolean[] {false} ;
      T00014_A694MigrLegActividadDef = new boolean[] {false} ;
      T00014_A699MigrLegCondicionDef = new boolean[] {false} ;
      T00014_A700MigrLegSiniestradoDef = new boolean[] {false} ;
      T00014_A2197MigrValCadaSave = new boolean[] {false} ;
      T00014_A2205MigrLegFecEgreso = new java.util.Date[] {GXutil.nullDate()} ;
      T00014_A2206MigrOtrosDatos = new String[] {""} ;
      T00014_A2216MigrPuesto = new String[] {""} ;
      T00014_A2221MigrLegMarcaCCT = new String[] {""} ;
      T00014_n2221MigrLegMarcaCCT = new boolean[] {false} ;
      T00014_A2222MigrArchSec = new short[1] ;
      T00014_n2222MigrArchSec = new boolean[] {false} ;
      T00014_A2239MigrLegActLabClas = new String[] {""} ;
      T00014_A2240MigrLegPueAfip = new String[] {""} ;
      T00014_A2275MigrLegHorSem = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00014_A3CliCod = new int[1] ;
      T00014_A1EmpCod = new short[1] ;
      T000115_A3CliCod = new int[1] ;
      T000115_A1EmpCod = new short[1] ;
      T000115_A87MigrLegNumero = new int[1] ;
      GXt_dtime11 = GXutil.resetTime( GXutil.nullDate() );
      GXt_dtime12 = GXutil.resetTime( GXutil.nullDate() );
      T000116_A1EmpCod = new short[1] ;
      T000116_A87MigrLegNumero = new int[1] ;
      T000116_A2078MigrLegFamSec = new short[1] ;
      T000116_A2079MigrLegFamParen = new String[] {""} ;
      T000116_A2080MigrLegFamNroDoc = new String[] {""} ;
      T000116_A2081MigrLegFamDedGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T000116_A2082MigrLegFamAdh = new String[] {""} ;
      T000116_A2086MigrLegFamDiscap = new String[] {""} ;
      T000116_A2088MigrLegFamNomApe = new String[] {""} ;
      T000116_A2089MigrLegFamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      T000116_A3CliCod = new int[1] ;
      T000117_A3CliCod = new int[1] ;
      T000117_A1EmpCod = new short[1] ;
      T000117_A87MigrLegNumero = new int[1] ;
      T000117_A2078MigrLegFamSec = new short[1] ;
      T00013_A1EmpCod = new short[1] ;
      T00013_A87MigrLegNumero = new int[1] ;
      T00013_A2078MigrLegFamSec = new short[1] ;
      T00013_A2079MigrLegFamParen = new String[] {""} ;
      T00013_A2080MigrLegFamNroDoc = new String[] {""} ;
      T00013_A2081MigrLegFamDedGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00013_A2082MigrLegFamAdh = new String[] {""} ;
      T00013_A2086MigrLegFamDiscap = new String[] {""} ;
      T00013_A2088MigrLegFamNomApe = new String[] {""} ;
      T00013_A2089MigrLegFamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      T00013_A3CliCod = new int[1] ;
      T00012_A1EmpCod = new short[1] ;
      T00012_A87MigrLegNumero = new int[1] ;
      T00012_A2078MigrLegFamSec = new short[1] ;
      T00012_A2079MigrLegFamParen = new String[] {""} ;
      T00012_A2080MigrLegFamNroDoc = new String[] {""} ;
      T00012_A2081MigrLegFamDedGan = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      T00012_A2082MigrLegFamAdh = new String[] {""} ;
      T00012_A2086MigrLegFamDiscap = new String[] {""} ;
      T00012_A2088MigrLegFamNomApe = new String[] {""} ;
      T00012_A2089MigrLegFamFecNac = new java.util.Date[] {GXutil.nullDate()} ;
      T00012_A3CliCod = new int[1] ;
      T000121_A3CliCod = new int[1] ;
      T000121_A1EmpCod = new short[1] ;
      T000121_A87MigrLegNumero = new int[1] ;
      T000121_A2078MigrLegFamSec = new short[1] ;
      Gridlevel1Row = new com.genexus.webpanels.GXWebRow();
      subGridlevel1_Linesclass = "" ;
      ROClassString = "" ;
      GXCCtl = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridlevel1Column = new com.genexus.webpanels.GXWebColumn();
      GXv_int9 = new short[1] ;
      T000122_A3CliCod = new int[1] ;
      ZV62LegNomApe = "" ;
      GXv_int7 = new int[1] ;
      GXv_char10 = new String[1] ;
      ZV63LegIdNomApe = "" ;
      ZV64AuxMigrLegCategoria = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.importacion_legajo__default(),
         new Object[] {
             new Object[] {
            T00012_A1EmpCod, T00012_A87MigrLegNumero, T00012_A2078MigrLegFamSec, T00012_A2079MigrLegFamParen, T00012_A2080MigrLegFamNroDoc, T00012_A2081MigrLegFamDedGan, T00012_A2082MigrLegFamAdh, T00012_A2086MigrLegFamDiscap, T00012_A2088MigrLegFamNomApe, T00012_A2089MigrLegFamFecNac,
            T00012_A3CliCod
            }
            , new Object[] {
            T00013_A1EmpCod, T00013_A87MigrLegNumero, T00013_A2078MigrLegFamSec, T00013_A2079MigrLegFamParen, T00013_A2080MigrLegFamNroDoc, T00013_A2081MigrLegFamDedGan, T00013_A2082MigrLegFamAdh, T00013_A2086MigrLegFamDiscap, T00013_A2088MigrLegFamNomApe, T00013_A2089MigrLegFamFecNac,
            T00013_A3CliCod
            }
            , new Object[] {
            T00014_A87MigrLegNumero, T00014_A592MigrLegApellido, T00014_A593MigrLegNombre, T00014_A594MigrLegFecNac, T00014_A595MigrLegSexo, T00014_A596MigrLegEstadoCivil, T00014_A597MigrLegCUIL, T00014_A598MigrLegDiscapacidad, T00014_A599MigrLegDomici, T00014_A600MigrLegEmail,
            T00014_A601MigrLegCodPos, T00014_A602MigrLegTelefono, T00014_A603MigrLegFecIngreso, T00014_A604MigrLegCategoria, T00014_A605MigrLegArea, T00014_A606MigrLegLugarDePago, T00014_A2415MigrLegModTra, T00014_A2427MigrLegTipoTarifa, T00014_A607MigrLegClase, T00014_A608MigrLegBasico,
            T00014_A609MigrLegFormaPago, T00014_A691MigrLegClaseDef, T00014_A610MigrLegBanco, T00014_A611MigrLegBanSuc, T00014_A612MigrLegBanTipCuen, T00014_A613MigrLegSindicato, T00014_A614MigrLegObraSocial, T00014_A634MigrLegOSAfip, T00014_A615MigrLegPlanMedico, T00014_A616MigrLegActividad,
            T00014_A617MigrLegModalidad, T00014_A618MigrLegFecUltMod, T00014_A619MigrLegCuentaBanc, T00014_A620MigrLegZona, T00014_A621MigrLegCBU, T00014_A622MigrLegSCVO, T00014_A623MigrLegSituacionRevista, T00014_A624MigrLegCondicion, T00014_A625MigrLegSiniestrado, T00014_A626MigrLegId,
            T00014_A627MigrLegConvenio, T00014_A628MigrLegObs, T00014_A629MigrLegErrores, T00014_A633MigrLegWarnings, T00014_A631MigrTieneConyuge, T00014_A632MigrCantidadHijos, T00014_A635MigrEncontroOsoSigla, T00014_A1398MigrTraDiurno, T00014_A1399MigrTraNoct, T00014_A1400MigrTraIns,
            T00014_A1820MigrEncontroOsoAfip, T00014_A2189MigrSueldos, T00014_A2190MigrPeriodo, T00014_A695MigrLegModalidadDef, T00014_A696MigrLegZonaDef, T00014_A698MigrLegSituacionDef, T00014_A690MigrLegEstadoCivilDef, T00014_A692MigrLegFormaPagoDef, T00014_A693MigrLegTipoCuentaDef, T00014_A694MigrLegActividadDef,
            T00014_A699MigrLegCondicionDef, T00014_A700MigrLegSiniestradoDef, T00014_A2197MigrValCadaSave, T00014_A2205MigrLegFecEgreso, T00014_A2206MigrOtrosDatos, T00014_A2216MigrPuesto, T00014_A2221MigrLegMarcaCCT, T00014_n2221MigrLegMarcaCCT, T00014_A2222MigrArchSec, T00014_n2222MigrArchSec,
            T00014_A2239MigrLegActLabClas, T00014_A2240MigrLegPueAfip, T00014_A2275MigrLegHorSem, T00014_A3CliCod, T00014_A1EmpCod
            }
            , new Object[] {
            T00015_A87MigrLegNumero, T00015_A592MigrLegApellido, T00015_A593MigrLegNombre, T00015_A594MigrLegFecNac, T00015_A595MigrLegSexo, T00015_A596MigrLegEstadoCivil, T00015_A597MigrLegCUIL, T00015_A598MigrLegDiscapacidad, T00015_A599MigrLegDomici, T00015_A600MigrLegEmail,
            T00015_A601MigrLegCodPos, T00015_A602MigrLegTelefono, T00015_A603MigrLegFecIngreso, T00015_A604MigrLegCategoria, T00015_A605MigrLegArea, T00015_A606MigrLegLugarDePago, T00015_A2415MigrLegModTra, T00015_A2427MigrLegTipoTarifa, T00015_A607MigrLegClase, T00015_A608MigrLegBasico,
            T00015_A609MigrLegFormaPago, T00015_A691MigrLegClaseDef, T00015_A610MigrLegBanco, T00015_A611MigrLegBanSuc, T00015_A612MigrLegBanTipCuen, T00015_A613MigrLegSindicato, T00015_A614MigrLegObraSocial, T00015_A634MigrLegOSAfip, T00015_A615MigrLegPlanMedico, T00015_A616MigrLegActividad,
            T00015_A617MigrLegModalidad, T00015_A618MigrLegFecUltMod, T00015_A619MigrLegCuentaBanc, T00015_A620MigrLegZona, T00015_A621MigrLegCBU, T00015_A622MigrLegSCVO, T00015_A623MigrLegSituacionRevista, T00015_A624MigrLegCondicion, T00015_A625MigrLegSiniestrado, T00015_A626MigrLegId,
            T00015_A627MigrLegConvenio, T00015_A628MigrLegObs, T00015_A629MigrLegErrores, T00015_A633MigrLegWarnings, T00015_A631MigrTieneConyuge, T00015_A632MigrCantidadHijos, T00015_A635MigrEncontroOsoSigla, T00015_A1398MigrTraDiurno, T00015_A1399MigrTraNoct, T00015_A1400MigrTraIns,
            T00015_A1820MigrEncontroOsoAfip, T00015_A2189MigrSueldos, T00015_A2190MigrPeriodo, T00015_A695MigrLegModalidadDef, T00015_A696MigrLegZonaDef, T00015_A698MigrLegSituacionDef, T00015_A690MigrLegEstadoCivilDef, T00015_A692MigrLegFormaPagoDef, T00015_A693MigrLegTipoCuentaDef, T00015_A694MigrLegActividadDef,
            T00015_A699MigrLegCondicionDef, T00015_A700MigrLegSiniestradoDef, T00015_A2197MigrValCadaSave, T00015_A2205MigrLegFecEgreso, T00015_A2206MigrOtrosDatos, T00015_A2216MigrPuesto, T00015_A2221MigrLegMarcaCCT, T00015_n2221MigrLegMarcaCCT, T00015_A2222MigrArchSec, T00015_n2222MigrArchSec,
            T00015_A2239MigrLegActLabClas, T00015_A2240MigrLegPueAfip, T00015_A2275MigrLegHorSem, T00015_A3CliCod, T00015_A1EmpCod
            }
            , new Object[] {
            T00016_A3CliCod
            }
            , new Object[] {
            T00017_A87MigrLegNumero, T00017_A592MigrLegApellido, T00017_A593MigrLegNombre, T00017_A594MigrLegFecNac, T00017_A595MigrLegSexo, T00017_A596MigrLegEstadoCivil, T00017_A597MigrLegCUIL, T00017_A598MigrLegDiscapacidad, T00017_A599MigrLegDomici, T00017_A600MigrLegEmail,
            T00017_A601MigrLegCodPos, T00017_A602MigrLegTelefono, T00017_A603MigrLegFecIngreso, T00017_A604MigrLegCategoria, T00017_A605MigrLegArea, T00017_A606MigrLegLugarDePago, T00017_A2415MigrLegModTra, T00017_A2427MigrLegTipoTarifa, T00017_A607MigrLegClase, T00017_A608MigrLegBasico,
            T00017_A609MigrLegFormaPago, T00017_A691MigrLegClaseDef, T00017_A610MigrLegBanco, T00017_A611MigrLegBanSuc, T00017_A612MigrLegBanTipCuen, T00017_A613MigrLegSindicato, T00017_A614MigrLegObraSocial, T00017_A634MigrLegOSAfip, T00017_A615MigrLegPlanMedico, T00017_A616MigrLegActividad,
            T00017_A617MigrLegModalidad, T00017_A618MigrLegFecUltMod, T00017_A619MigrLegCuentaBanc, T00017_A620MigrLegZona, T00017_A621MigrLegCBU, T00017_A622MigrLegSCVO, T00017_A623MigrLegSituacionRevista, T00017_A624MigrLegCondicion, T00017_A625MigrLegSiniestrado, T00017_A626MigrLegId,
            T00017_A627MigrLegConvenio, T00017_A628MigrLegObs, T00017_A629MigrLegErrores, T00017_A633MigrLegWarnings, T00017_A631MigrTieneConyuge, T00017_A632MigrCantidadHijos, T00017_A635MigrEncontroOsoSigla, T00017_A1398MigrTraDiurno, T00017_A1399MigrTraNoct, T00017_A1400MigrTraIns,
            T00017_A1820MigrEncontroOsoAfip, T00017_A2189MigrSueldos, T00017_A2190MigrPeriodo, T00017_A695MigrLegModalidadDef, T00017_A696MigrLegZonaDef, T00017_A698MigrLegSituacionDef, T00017_A690MigrLegEstadoCivilDef, T00017_A692MigrLegFormaPagoDef, T00017_A693MigrLegTipoCuentaDef, T00017_A694MigrLegActividadDef,
            T00017_A699MigrLegCondicionDef, T00017_A700MigrLegSiniestradoDef, T00017_A2197MigrValCadaSave, T00017_A2205MigrLegFecEgreso, T00017_A2206MigrOtrosDatos, T00017_A2216MigrPuesto, T00017_A2221MigrLegMarcaCCT, T00017_n2221MigrLegMarcaCCT, T00017_A2222MigrArchSec, T00017_n2222MigrArchSec,
            T00017_A2239MigrLegActLabClas, T00017_A2240MigrLegPueAfip, T00017_A2275MigrLegHorSem, T00017_A3CliCod, T00017_A1EmpCod
            }
            , new Object[] {
            T00018_A3CliCod
            }
            , new Object[] {
            T00019_A3CliCod, T00019_A1EmpCod, T00019_A87MigrLegNumero
            }
            , new Object[] {
            T000110_A3CliCod, T000110_A1EmpCod, T000110_A87MigrLegNumero
            }
            , new Object[] {
            T000111_A3CliCod, T000111_A1EmpCod, T000111_A87MigrLegNumero
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000115_A3CliCod, T000115_A1EmpCod, T000115_A87MigrLegNumero
            }
            , new Object[] {
            T000116_A1EmpCod, T000116_A87MigrLegNumero, T000116_A2078MigrLegFamSec, T000116_A2079MigrLegFamParen, T000116_A2080MigrLegFamNroDoc, T000116_A2081MigrLegFamDedGan, T000116_A2082MigrLegFamAdh, T000116_A2086MigrLegFamDiscap, T000116_A2088MigrLegFamNomApe, T000116_A2089MigrLegFamFecNac,
            T000116_A3CliCod
            }
            , new Object[] {
            T000117_A3CliCod, T000117_A1EmpCod, T000117_A87MigrLegNumero, T000117_A2078MigrLegFamSec
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000121_A3CliCod, T000121_A1EmpCod, T000121_A87MigrLegNumero, T000121_A2078MigrLegFamSec
            }
            , new Object[] {
            T000122_A3CliCod
            }
         }
      );
      AV69Pgmname = "importacion_legajo" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte subGridlevel1_Backcolorstyle ;
   private byte subGridlevel1_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridlevel1_Allowselection ;
   private byte subGridlevel1_Allowhovering ;
   private byte subGridlevel1_Allowcollapsing ;
   private byte subGridlevel1_Collapsed ;
   private short wcpOAV18EmpCod ;
   private short Z1EmpCod ;
   private short Z632MigrCantidadHijos ;
   private short Z2222MigrArchSec ;
   private short Z2078MigrLegFamSec ;
   private short nRcdDeleted_262 ;
   private short nRcdExists_262 ;
   private short nIsMod_262 ;
   private short A1EmpCod ;
   private short AV18EmpCod ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount262 ;
   private short RcdFound262 ;
   private short nBlankRcdUsr262 ;
   private short A632MigrCantidadHijos ;
   private short A2222MigrArchSec ;
   private short RcdFound75 ;
   private short A2078MigrLegFamSec ;
   private short nIsDirty_75 ;
   private short nIsDirty_262 ;
   private short GXt_int8 ;
   private short GXv_int9[] ;
   private int wcpOAV7CliCod ;
   private int wcpOAV40MigrLegNumero ;
   private int Z3CliCod ;
   private int Z87MigrLegNumero ;
   private int nRC_GXsfl_203 ;
   private int nGXsfl_203_idx=1 ;
   private int A3CliCod ;
   private int AV7CliCod ;
   private int AV40MigrLegNumero ;
   private int trnEnded ;
   private int edtMigrLegId_Enabled ;
   private int edtMigrLegCUIL_Enabled ;
   private int edtMigrLegApellido_Enabled ;
   private int edtMigrLegNombre_Enabled ;
   private int edtMigrLegModTra_Enabled ;
   private int edtMigrLegTipoTarifa_Enabled ;
   private int edtMigrLegClase_Enabled ;
   private int edtMigrLegFecNac_Enabled ;
   private int edtMigrLegFecIngreso_Enabled ;
   private int edtMigrLegSexo_Enabled ;
   private int edtMigrLegDomici_Enabled ;
   private int edtMigrLegCodPos_Enabled ;
   private int edtMigrLegTelefono_Enabled ;
   private int edtMigrLegEmail_Enabled ;
   private int edtMigrLegEstadoCivil_Enabled ;
   private int edtMigrLegBasico_Enabled ;
   private int edtMigrLegOSAfip_Enabled ;
   private int edtMigrLegCBU_Enabled ;
   private int edtMigrLegObs_Enabled ;
   private int edtMigrLegFamSec_Enabled ;
   private int edtMigrLegFamParen_Enabled ;
   private int edtMigrLegFamNroDoc_Enabled ;
   private int edtMigrLegFamNomApe_Enabled ;
   private int edtMigrLegFamFecNac_Enabled ;
   private int edtMigrLegFamDedGan_Enabled ;
   private int edtMigrLegFamAdh_Enabled ;
   private int edtMigrLegFamDiscap_Enabled ;
   private int fRowAdded ;
   private int bttBtntrn_enter_Visible ;
   private int bttBtntrn_enter_Enabled ;
   private int bttBtntrn_cancel_Visible ;
   private int edtCliCod_Visible ;
   private int edtCliCod_Enabled ;
   private int edtEmpCod_Visible ;
   private int edtEmpCod_Enabled ;
   private int A87MigrLegNumero ;
   private int edtMigrLegNumero_Visible ;
   private int edtMigrLegNumero_Enabled ;
   private int edtMigrLegZona_Visible ;
   private int edtMigrLegZona_Enabled ;
   private int edtMigrLegDiscapacidad_Visible ;
   private int edtMigrLegDiscapacidad_Enabled ;
   private int edtMigrLegLugarDePago_Visible ;
   private int edtMigrLegLugarDePago_Enabled ;
   private int edtMigrLegBanco_Visible ;
   private int edtMigrLegBanco_Enabled ;
   private int edtMigrLegBanSuc_Visible ;
   private int edtMigrLegBanSuc_Enabled ;
   private int edtMigrLegBanTipCuen_Visible ;
   private int edtMigrLegBanTipCuen_Enabled ;
   private int edtMigrLegCuentaBanc_Visible ;
   private int edtMigrLegCuentaBanc_Enabled ;
   private int edtMigrLegFormaPago_Visible ;
   private int edtMigrLegFormaPago_Enabled ;
   private int edtMigrLegActividad_Visible ;
   private int edtMigrLegActividad_Enabled ;
   private int edtMigrLegSituacionRevista_Visible ;
   private int edtMigrLegSituacionRevista_Enabled ;
   private int edtMigrLegCondicion_Visible ;
   private int edtMigrLegCondicion_Enabled ;
   private int edtMigrLegSiniestrado_Visible ;
   private int edtMigrLegSiniestrado_Enabled ;
   private int edtMigrLegSCVO_Visible ;
   private int edtMigrLegSCVO_Enabled ;
   private int edtMigrLegPlanMedico_Visible ;
   private int edtMigrLegPlanMedico_Enabled ;
   private int edtMigrTieneConyuge_Visible ;
   private int edtMigrTieneConyuge_Enabled ;
   private int edtMigrCantidadHijos_Enabled ;
   private int edtMigrCantidadHijos_Visible ;
   private int AV65LegNumeroPorId ;
   private int AV66LegNumeroPorCUIL ;
   private int Dvpanel_tableattributes_Gxcontroltype ;
   private int GX_JID ;
   private int subGridlevel1_Backcolor ;
   private int subGridlevel1_Allbackcolor ;
   private int defedtMigrLegFamSec_Enabled ;
   private int idxLst ;
   private int subGridlevel1_Selectedindex ;
   private int subGridlevel1_Selectioncolor ;
   private int subGridlevel1_Hoveringcolor ;
   private int GXt_int6 ;
   private int ZV65LegNumeroPorId ;
   private int GXv_int7[] ;
   private int ZV66LegNumeroPorCUIL ;
   private long GRIDLEVEL1_nFirstRecordOnPage ;
   private java.math.BigDecimal Z608MigrLegBasico ;
   private java.math.BigDecimal Z2275MigrLegHorSem ;
   private java.math.BigDecimal Z2081MigrLegFamDedGan ;
   private java.math.BigDecimal A608MigrLegBasico ;
   private java.math.BigDecimal A2275MigrLegHorSem ;
   private java.math.BigDecimal A2081MigrLegFamDedGan ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String Z595MigrLegSexo ;
   private String Z597MigrLegCUIL ;
   private String Z598MigrLegDiscapacidad ;
   private String Z634MigrLegOSAfip ;
   private String Z622MigrLegSCVO ;
   private String Z626MigrLegId ;
   private String Z631MigrTieneConyuge ;
   private String Z1398MigrTraDiurno ;
   private String Z1399MigrTraNoct ;
   private String Z1400MigrTraIns ;
   private String Z2221MigrLegMarcaCCT ;
   private String O634MigrLegOSAfip ;
   private String N634MigrLegOSAfip ;
   private String Z2082MigrLegFamAdh ;
   private String Z2086MigrLegFamDiscap ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A626MigrLegId ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtMigrLegId_Internalname ;
   private String sGXsfl_203_idx="0001" ;
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
   private String edtMigrLegId_Jsonclick ;
   private String edtMigrLegCUIL_Internalname ;
   private String A597MigrLegCUIL ;
   private String edtMigrLegCUIL_Jsonclick ;
   private String edtMigrLegApellido_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String edtMigrLegNombre_Internalname ;
   private String edtMigrLegModTra_Internalname ;
   private String edtMigrLegTipoTarifa_Internalname ;
   private String edtMigrLegClase_Internalname ;
   private String edtMigrLegFecNac_Internalname ;
   private String edtMigrLegFecNac_Jsonclick ;
   private String edtMigrLegFecIngreso_Internalname ;
   private String edtMigrLegFecIngreso_Jsonclick ;
   private String edtMigrLegSexo_Internalname ;
   private String A595MigrLegSexo ;
   private String edtMigrLegSexo_Jsonclick ;
   private String edtMigrLegDomici_Internalname ;
   private String edtMigrLegCodPos_Internalname ;
   private String edtMigrLegTelefono_Internalname ;
   private String edtMigrLegEmail_Internalname ;
   private String edtMigrLegEmail_Jsonclick ;
   private String edtMigrLegEstadoCivil_Internalname ;
   private String divTablesplittedmigrlegsindicato_Internalname ;
   private String lblTextblockmigrlegsindicato_Internalname ;
   private String lblTextblockmigrlegsindicato_Jsonclick ;
   private String tblTablemergedmigrlegsindicato_Internalname ;
   private String lblMigrlegsindicato_righttext_Internalname ;
   private String lblMigrlegsindicato_righttext_Jsonclick ;
   private String divTablesplittedmigrlegconvenio_Internalname ;
   private String lblTextblockmigrlegconvenio_Internalname ;
   private String lblTextblockmigrlegconvenio_Jsonclick ;
   private String tblTablemergedmigrlegconvenio_Internalname ;
   private String lblMigrlegconvenio_righttext_Internalname ;
   private String lblMigrlegconvenio_righttext_Jsonclick ;
   private String divTablesplittedmigrlegcategoria_Internalname ;
   private String lblTextblockmigrlegcategoria_Internalname ;
   private String lblTextblockmigrlegcategoria_Jsonclick ;
   private String tblTablemergedmigrlegcategoria_Internalname ;
   private String lblMigrlegcategoria_righttext_Internalname ;
   private String lblMigrlegcategoria_righttext_Jsonclick ;
   private String divTablesplittedmigrlegarea_Internalname ;
   private String lblTextblockmigrlegarea_Internalname ;
   private String lblTextblockmigrlegarea_Jsonclick ;
   private String tblTablemergedmigrlegarea_Internalname ;
   private String lblMigrlegarea_righttext_Internalname ;
   private String lblMigrlegarea_righttext_Jsonclick ;
   private String edtMigrLegBasico_Internalname ;
   private String edtMigrLegBasico_Jsonclick ;
   private String divTablesplittedmigrlegobrasocial_Internalname ;
   private String lblTextblockmigrlegobrasocial_Internalname ;
   private String lblTextblockmigrlegobrasocial_Jsonclick ;
   private String tblTablemergedmigrlegobrasocial_Internalname ;
   private String lblMigrlegobrasocial_righttext_Internalname ;
   private String lblMigrlegobrasocial_righttext_Jsonclick ;
   private String edtMigrLegOSAfip_Internalname ;
   private String A634MigrLegOSAfip ;
   private String edtMigrLegOSAfip_Jsonclick ;
   private String edtMigrLegCBU_Internalname ;
   private String edtMigrLegCBU_Jsonclick ;
   private String divTablesplittedmigrlegmodalidad_Internalname ;
   private String lblTextblockmigrlegmodalidad_Internalname ;
   private String lblTextblockmigrlegmodalidad_Jsonclick ;
   private String tblTablemergedmigrlegmodalidad_Internalname ;
   private String lblMigrlegmodalidad_righttext_Internalname ;
   private String lblMigrlegmodalidad_righttext_Jsonclick ;
   private String edtMigrLegObs_Internalname ;
   private String grpUnnamedgroup2_Internalname ;
   private String tblUnnamedtable1_Internalname ;
   private String B634MigrLegOSAfip ;
   private String sMode262 ;
   private String edtMigrLegFamSec_Internalname ;
   private String edtMigrLegFamParen_Internalname ;
   private String edtMigrLegFamNroDoc_Internalname ;
   private String edtMigrLegFamNomApe_Internalname ;
   private String edtMigrLegFamFecNac_Internalname ;
   private String edtMigrLegFamDedGan_Internalname ;
   private String edtMigrLegFamAdh_Internalname ;
   private String edtMigrLegFamDiscap_Internalname ;
   private String subGridlevel1_Internalname ;
   private String bttBtntrn_enter_Internalname ;
   private String bttBtntrn_enter_Jsonclick ;
   private String bttBtntrn_cancel_Internalname ;
   private String bttBtntrn_cancel_Jsonclick ;
   private String divHtml_bottomauxiliarcontrols_Internalname ;
   private String edtCliCod_Internalname ;
   private String edtCliCod_Jsonclick ;
   private String edtEmpCod_Internalname ;
   private String edtEmpCod_Jsonclick ;
   private String edtMigrLegNumero_Internalname ;
   private String edtMigrLegNumero_Jsonclick ;
   private String edtMigrLegZona_Internalname ;
   private String edtMigrLegDiscapacidad_Internalname ;
   private String A598MigrLegDiscapacidad ;
   private String edtMigrLegDiscapacidad_Jsonclick ;
   private String edtMigrLegLugarDePago_Internalname ;
   private String edtMigrLegLugarDePago_Jsonclick ;
   private String edtMigrLegBanco_Internalname ;
   private String edtMigrLegBanSuc_Internalname ;
   private String edtMigrLegBanTipCuen_Internalname ;
   private String edtMigrLegBanTipCuen_Jsonclick ;
   private String edtMigrLegCuentaBanc_Internalname ;
   private String edtMigrLegCuentaBanc_Jsonclick ;
   private String edtMigrLegFormaPago_Internalname ;
   private String edtMigrLegActividad_Internalname ;
   private String edtMigrLegActividad_Jsonclick ;
   private String edtMigrLegSituacionRevista_Internalname ;
   private String edtMigrLegSituacionRevista_Jsonclick ;
   private String edtMigrLegCondicion_Internalname ;
   private String edtMigrLegCondicion_Jsonclick ;
   private String edtMigrLegSiniestrado_Internalname ;
   private String edtMigrLegSCVO_Internalname ;
   private String A622MigrLegSCVO ;
   private String edtMigrLegSCVO_Jsonclick ;
   private String edtMigrLegPlanMedico_Internalname ;
   private String edtMigrTieneConyuge_Internalname ;
   private String A631MigrTieneConyuge ;
   private String edtMigrTieneConyuge_Jsonclick ;
   private String edtMigrCantidadHijos_Internalname ;
   private String edtMigrCantidadHijos_Jsonclick ;
   private String A2221MigrLegMarcaCCT ;
   private String A1398MigrTraDiurno ;
   private String A1399MigrTraNoct ;
   private String A1400MigrTraIns ;
   private String AV69Pgmname ;
   private String Dvpanel_tableattributes_Objectcall ;
   private String Dvpanel_tableattributes_Class ;
   private String Dvpanel_tableattributes_Height ;
   private String hsh ;
   private String sMode75 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String A2082MigrLegFamAdh ;
   private String A2086MigrLegFamDiscap ;
   private String sGXsfl_203_fel_idx="0001" ;
   private String subGridlevel1_Class ;
   private String subGridlevel1_Linesclass ;
   private String ROClassString ;
   private String edtMigrLegFamSec_Jsonclick ;
   private String edtMigrLegFamParen_Jsonclick ;
   private String edtMigrLegFamNroDoc_Jsonclick ;
   private String edtMigrLegFamNomApe_Jsonclick ;
   private String edtMigrLegFamFecNac_Jsonclick ;
   private String edtMigrLegFamDedGan_Jsonclick ;
   private String edtMigrLegFamAdh_Jsonclick ;
   private String edtMigrLegFamDiscap_Jsonclick ;
   private String GXCCtl ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridlevel1_Header ;
   private String GXv_char10[] ;
   private java.util.Date GXt_dtime11 ;
   private java.util.Date GXt_dtime12 ;
   private java.util.Date Z594MigrLegFecNac ;
   private java.util.Date Z603MigrLegFecIngreso ;
   private java.util.Date Z618MigrLegFecUltMod ;
   private java.util.Date Z2190MigrPeriodo ;
   private java.util.Date Z2205MigrLegFecEgreso ;
   private java.util.Date Z2089MigrLegFamFecNac ;
   private java.util.Date A594MigrLegFecNac ;
   private java.util.Date A603MigrLegFecIngreso ;
   private java.util.Date A618MigrLegFecUltMod ;
   private java.util.Date A2190MigrPeriodo ;
   private java.util.Date A2205MigrLegFecEgreso ;
   private java.util.Date A2089MigrLegFamFecNac ;
   private boolean Z691MigrLegClaseDef ;
   private boolean Z635MigrEncontroOsoSigla ;
   private boolean Z1820MigrEncontroOsoAfip ;
   private boolean Z695MigrLegModalidadDef ;
   private boolean Z696MigrLegZonaDef ;
   private boolean Z698MigrLegSituacionDef ;
   private boolean Z690MigrLegEstadoCivilDef ;
   private boolean Z692MigrLegFormaPagoDef ;
   private boolean Z693MigrLegTipoCuentaDef ;
   private boolean Z694MigrLegActividadDef ;
   private boolean Z699MigrLegCondicionDef ;
   private boolean Z700MigrLegSiniestradoDef ;
   private boolean Z2197MigrValCadaSave ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean Dvpanel_tableattributes_Autowidth ;
   private boolean Dvpanel_tableattributes_Autoheight ;
   private boolean Dvpanel_tableattributes_Collapsible ;
   private boolean Dvpanel_tableattributes_Collapsed ;
   private boolean Dvpanel_tableattributes_Showcollapseicon ;
   private boolean Dvpanel_tableattributes_Autoscroll ;
   private boolean bGXsfl_203_Refreshing=false ;
   private boolean n2221MigrLegMarcaCCT ;
   private boolean n2222MigrArchSec ;
   private boolean A691MigrLegClaseDef ;
   private boolean A635MigrEncontroOsoSigla ;
   private boolean A1820MigrEncontroOsoAfip ;
   private boolean A695MigrLegModalidadDef ;
   private boolean A696MigrLegZonaDef ;
   private boolean A698MigrLegSituacionDef ;
   private boolean A690MigrLegEstadoCivilDef ;
   private boolean A692MigrLegFormaPagoDef ;
   private boolean A693MigrLegTipoCuentaDef ;
   private boolean A694MigrLegActividadDef ;
   private boolean A699MigrLegCondicionDef ;
   private boolean A700MigrLegSiniestradoDef ;
   private boolean A2197MigrValCadaSave ;
   private boolean Dvpanel_tableattributes_Enabled ;
   private boolean Dvpanel_tableattributes_Showheader ;
   private boolean Dvpanel_tableattributes_Visible ;
   private boolean returnInSub ;
   private boolean AV22IsAuthorized ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean3[] ;
   private boolean Gx_longc ;
   private String A628MigrLegObs ;
   private String A629MigrLegErrores ;
   private String A633MigrLegWarnings ;
   private String A2189MigrSueldos ;
   private String A2206MigrOtrosDatos ;
   private String Z628MigrLegObs ;
   private String Z629MigrLegErrores ;
   private String Z633MigrLegWarnings ;
   private String Z2189MigrSueldos ;
   private String Z2206MigrOtrosDatos ;
   private String Z592MigrLegApellido ;
   private String Z593MigrLegNombre ;
   private String Z596MigrLegEstadoCivil ;
   private String Z599MigrLegDomici ;
   private String Z600MigrLegEmail ;
   private String Z601MigrLegCodPos ;
   private String Z602MigrLegTelefono ;
   private String Z604MigrLegCategoria ;
   private String Z605MigrLegArea ;
   private String Z606MigrLegLugarDePago ;
   private String Z2415MigrLegModTra ;
   private String Z2427MigrLegTipoTarifa ;
   private String Z607MigrLegClase ;
   private String Z609MigrLegFormaPago ;
   private String Z610MigrLegBanco ;
   private String Z611MigrLegBanSuc ;
   private String Z612MigrLegBanTipCuen ;
   private String Z613MigrLegSindicato ;
   private String Z614MigrLegObraSocial ;
   private String Z615MigrLegPlanMedico ;
   private String Z616MigrLegActividad ;
   private String Z617MigrLegModalidad ;
   private String Z619MigrLegCuentaBanc ;
   private String Z620MigrLegZona ;
   private String Z621MigrLegCBU ;
   private String Z623MigrLegSituacionRevista ;
   private String Z624MigrLegCondicion ;
   private String Z625MigrLegSiniestrado ;
   private String Z627MigrLegConvenio ;
   private String Z2216MigrPuesto ;
   private String Z2239MigrLegActLabClas ;
   private String Z2240MigrLegPueAfip ;
   private String Z2079MigrLegFamParen ;
   private String Z2080MigrLegFamNroDoc ;
   private String Z2088MigrLegFamNomApe ;
   private String A613MigrLegSindicato ;
   private String A627MigrLegConvenio ;
   private String A604MigrLegCategoria ;
   private String A605MigrLegArea ;
   private String A614MigrLegObraSocial ;
   private String A617MigrLegModalidad ;
   private String A592MigrLegApellido ;
   private String A593MigrLegNombre ;
   private String A2415MigrLegModTra ;
   private String A2427MigrLegTipoTarifa ;
   private String A607MigrLegClase ;
   private String A599MigrLegDomici ;
   private String A601MigrLegCodPos ;
   private String A602MigrLegTelefono ;
   private String A600MigrLegEmail ;
   private String A596MigrLegEstadoCivil ;
   private String A621MigrLegCBU ;
   private String A620MigrLegZona ;
   private String A606MigrLegLugarDePago ;
   private String A610MigrLegBanco ;
   private String A611MigrLegBanSuc ;
   private String A612MigrLegBanTipCuen ;
   private String A619MigrLegCuentaBanc ;
   private String A609MigrLegFormaPago ;
   private String A616MigrLegActividad ;
   private String A623MigrLegSituacionRevista ;
   private String A624MigrLegCondicion ;
   private String A625MigrLegSiniestrado ;
   private String A615MigrLegPlanMedico ;
   private String A2216MigrPuesto ;
   private String A2239MigrLegActLabClas ;
   private String A2240MigrLegPueAfip ;
   private String AV64AuxMigrLegCategoria ;
   private String AV62LegNomApe ;
   private String AV63LegIdNomApe ;
   private String A2079MigrLegFamParen ;
   private String A2080MigrLegFamNroDoc ;
   private String A2088MigrLegFamNomApe ;
   private String ZV62LegNomApe ;
   private String ZV63LegIdNomApe ;
   private String ZV64AuxMigrLegCategoria ;
   private com.genexus.webpanels.GXWebGrid Gridlevel1Container ;
   private com.genexus.webpanels.GXWebRow Gridlevel1Row ;
   private com.genexus.webpanels.GXWebColumn Gridlevel1Column ;
   private com.genexus.webpanels.WebSession AV55WebSession ;
   private com.genexus.webpanels.GXUserControl ucDvpanel_tableattributes ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private HTMLChoice cmbMigrLegSindicato ;
   private HTMLChoice cmbMigrLegConvenio ;
   private HTMLChoice cmbMigrLegCategoria ;
   private HTMLChoice cmbMigrLegArea ;
   private HTMLChoice cmbMigrLegObraSocial ;
   private HTMLChoice cmbMigrLegModalidad ;
   private IDataStoreProvider pr_default ;
   private int[] T00017_A87MigrLegNumero ;
   private String[] T00017_A592MigrLegApellido ;
   private String[] T00017_A593MigrLegNombre ;
   private java.util.Date[] T00017_A594MigrLegFecNac ;
   private String[] T00017_A595MigrLegSexo ;
   private String[] T00017_A596MigrLegEstadoCivil ;
   private String[] T00017_A597MigrLegCUIL ;
   private String[] T00017_A598MigrLegDiscapacidad ;
   private String[] T00017_A599MigrLegDomici ;
   private String[] T00017_A600MigrLegEmail ;
   private String[] T00017_A601MigrLegCodPos ;
   private String[] T00017_A602MigrLegTelefono ;
   private java.util.Date[] T00017_A603MigrLegFecIngreso ;
   private String[] T00017_A604MigrLegCategoria ;
   private String[] T00017_A605MigrLegArea ;
   private String[] T00017_A606MigrLegLugarDePago ;
   private String[] T00017_A2415MigrLegModTra ;
   private String[] T00017_A2427MigrLegTipoTarifa ;
   private String[] T00017_A607MigrLegClase ;
   private java.math.BigDecimal[] T00017_A608MigrLegBasico ;
   private String[] T00017_A609MigrLegFormaPago ;
   private boolean[] T00017_A691MigrLegClaseDef ;
   private String[] T00017_A610MigrLegBanco ;
   private String[] T00017_A611MigrLegBanSuc ;
   private String[] T00017_A612MigrLegBanTipCuen ;
   private String[] T00017_A613MigrLegSindicato ;
   private String[] T00017_A614MigrLegObraSocial ;
   private String[] T00017_A634MigrLegOSAfip ;
   private String[] T00017_A615MigrLegPlanMedico ;
   private String[] T00017_A616MigrLegActividad ;
   private String[] T00017_A617MigrLegModalidad ;
   private java.util.Date[] T00017_A618MigrLegFecUltMod ;
   private String[] T00017_A619MigrLegCuentaBanc ;
   private String[] T00017_A620MigrLegZona ;
   private String[] T00017_A621MigrLegCBU ;
   private String[] T00017_A622MigrLegSCVO ;
   private String[] T00017_A623MigrLegSituacionRevista ;
   private String[] T00017_A624MigrLegCondicion ;
   private String[] T00017_A625MigrLegSiniestrado ;
   private String[] T00017_A626MigrLegId ;
   private String[] T00017_A627MigrLegConvenio ;
   private String[] T00017_A628MigrLegObs ;
   private String[] T00017_A629MigrLegErrores ;
   private String[] T00017_A633MigrLegWarnings ;
   private String[] T00017_A631MigrTieneConyuge ;
   private short[] T00017_A632MigrCantidadHijos ;
   private boolean[] T00017_A635MigrEncontroOsoSigla ;
   private String[] T00017_A1398MigrTraDiurno ;
   private String[] T00017_A1399MigrTraNoct ;
   private String[] T00017_A1400MigrTraIns ;
   private boolean[] T00017_A1820MigrEncontroOsoAfip ;
   private String[] T00017_A2189MigrSueldos ;
   private java.util.Date[] T00017_A2190MigrPeriodo ;
   private boolean[] T00017_A695MigrLegModalidadDef ;
   private boolean[] T00017_A696MigrLegZonaDef ;
   private boolean[] T00017_A698MigrLegSituacionDef ;
   private boolean[] T00017_A690MigrLegEstadoCivilDef ;
   private boolean[] T00017_A692MigrLegFormaPagoDef ;
   private boolean[] T00017_A693MigrLegTipoCuentaDef ;
   private boolean[] T00017_A694MigrLegActividadDef ;
   private boolean[] T00017_A699MigrLegCondicionDef ;
   private boolean[] T00017_A700MigrLegSiniestradoDef ;
   private boolean[] T00017_A2197MigrValCadaSave ;
   private java.util.Date[] T00017_A2205MigrLegFecEgreso ;
   private String[] T00017_A2206MigrOtrosDatos ;
   private String[] T00017_A2216MigrPuesto ;
   private String[] T00017_A2221MigrLegMarcaCCT ;
   private boolean[] T00017_n2221MigrLegMarcaCCT ;
   private short[] T00017_A2222MigrArchSec ;
   private boolean[] T00017_n2222MigrArchSec ;
   private String[] T00017_A2239MigrLegActLabClas ;
   private String[] T00017_A2240MigrLegPueAfip ;
   private java.math.BigDecimal[] T00017_A2275MigrLegHorSem ;
   private int[] T00017_A3CliCod ;
   private short[] T00017_A1EmpCod ;
   private int[] T00016_A3CliCod ;
   private int[] T00018_A3CliCod ;
   private int[] T00019_A3CliCod ;
   private short[] T00019_A1EmpCod ;
   private int[] T00019_A87MigrLegNumero ;
   private int[] T00015_A87MigrLegNumero ;
   private String[] T00015_A592MigrLegApellido ;
   private String[] T00015_A593MigrLegNombre ;
   private java.util.Date[] T00015_A594MigrLegFecNac ;
   private String[] T00015_A595MigrLegSexo ;
   private String[] T00015_A596MigrLegEstadoCivil ;
   private String[] T00015_A597MigrLegCUIL ;
   private String[] T00015_A598MigrLegDiscapacidad ;
   private String[] T00015_A599MigrLegDomici ;
   private String[] T00015_A600MigrLegEmail ;
   private String[] T00015_A601MigrLegCodPos ;
   private String[] T00015_A602MigrLegTelefono ;
   private java.util.Date[] T00015_A603MigrLegFecIngreso ;
   private String[] T00015_A604MigrLegCategoria ;
   private String[] T00015_A605MigrLegArea ;
   private String[] T00015_A606MigrLegLugarDePago ;
   private String[] T00015_A2415MigrLegModTra ;
   private String[] T00015_A2427MigrLegTipoTarifa ;
   private String[] T00015_A607MigrLegClase ;
   private java.math.BigDecimal[] T00015_A608MigrLegBasico ;
   private String[] T00015_A609MigrLegFormaPago ;
   private boolean[] T00015_A691MigrLegClaseDef ;
   private String[] T00015_A610MigrLegBanco ;
   private String[] T00015_A611MigrLegBanSuc ;
   private String[] T00015_A612MigrLegBanTipCuen ;
   private String[] T00015_A613MigrLegSindicato ;
   private String[] T00015_A614MigrLegObraSocial ;
   private String[] T00015_A634MigrLegOSAfip ;
   private String[] T00015_A615MigrLegPlanMedico ;
   private String[] T00015_A616MigrLegActividad ;
   private String[] T00015_A617MigrLegModalidad ;
   private java.util.Date[] T00015_A618MigrLegFecUltMod ;
   private String[] T00015_A619MigrLegCuentaBanc ;
   private String[] T00015_A620MigrLegZona ;
   private String[] T00015_A621MigrLegCBU ;
   private String[] T00015_A622MigrLegSCVO ;
   private String[] T00015_A623MigrLegSituacionRevista ;
   private String[] T00015_A624MigrLegCondicion ;
   private String[] T00015_A625MigrLegSiniestrado ;
   private String[] T00015_A626MigrLegId ;
   private String[] T00015_A627MigrLegConvenio ;
   private String[] T00015_A628MigrLegObs ;
   private String[] T00015_A629MigrLegErrores ;
   private String[] T00015_A633MigrLegWarnings ;
   private String[] T00015_A631MigrTieneConyuge ;
   private short[] T00015_A632MigrCantidadHijos ;
   private boolean[] T00015_A635MigrEncontroOsoSigla ;
   private String[] T00015_A1398MigrTraDiurno ;
   private String[] T00015_A1399MigrTraNoct ;
   private String[] T00015_A1400MigrTraIns ;
   private boolean[] T00015_A1820MigrEncontroOsoAfip ;
   private String[] T00015_A2189MigrSueldos ;
   private java.util.Date[] T00015_A2190MigrPeriodo ;
   private boolean[] T00015_A695MigrLegModalidadDef ;
   private boolean[] T00015_A696MigrLegZonaDef ;
   private boolean[] T00015_A698MigrLegSituacionDef ;
   private boolean[] T00015_A690MigrLegEstadoCivilDef ;
   private boolean[] T00015_A692MigrLegFormaPagoDef ;
   private boolean[] T00015_A693MigrLegTipoCuentaDef ;
   private boolean[] T00015_A694MigrLegActividadDef ;
   private boolean[] T00015_A699MigrLegCondicionDef ;
   private boolean[] T00015_A700MigrLegSiniestradoDef ;
   private boolean[] T00015_A2197MigrValCadaSave ;
   private java.util.Date[] T00015_A2205MigrLegFecEgreso ;
   private String[] T00015_A2206MigrOtrosDatos ;
   private String[] T00015_A2216MigrPuesto ;
   private String[] T00015_A2221MigrLegMarcaCCT ;
   private boolean[] T00015_n2221MigrLegMarcaCCT ;
   private short[] T00015_A2222MigrArchSec ;
   private boolean[] T00015_n2222MigrArchSec ;
   private String[] T00015_A2239MigrLegActLabClas ;
   private String[] T00015_A2240MigrLegPueAfip ;
   private java.math.BigDecimal[] T00015_A2275MigrLegHorSem ;
   private int[] T00015_A3CliCod ;
   private short[] T00015_A1EmpCod ;
   private int[] T000110_A3CliCod ;
   private short[] T000110_A1EmpCod ;
   private int[] T000110_A87MigrLegNumero ;
   private int[] T000111_A3CliCod ;
   private short[] T000111_A1EmpCod ;
   private int[] T000111_A87MigrLegNumero ;
   private int[] T00014_A87MigrLegNumero ;
   private String[] T00014_A592MigrLegApellido ;
   private String[] T00014_A593MigrLegNombre ;
   private java.util.Date[] T00014_A594MigrLegFecNac ;
   private String[] T00014_A595MigrLegSexo ;
   private String[] T00014_A596MigrLegEstadoCivil ;
   private String[] T00014_A597MigrLegCUIL ;
   private String[] T00014_A598MigrLegDiscapacidad ;
   private String[] T00014_A599MigrLegDomici ;
   private String[] T00014_A600MigrLegEmail ;
   private String[] T00014_A601MigrLegCodPos ;
   private String[] T00014_A602MigrLegTelefono ;
   private java.util.Date[] T00014_A603MigrLegFecIngreso ;
   private String[] T00014_A604MigrLegCategoria ;
   private String[] T00014_A605MigrLegArea ;
   private String[] T00014_A606MigrLegLugarDePago ;
   private String[] T00014_A2415MigrLegModTra ;
   private String[] T00014_A2427MigrLegTipoTarifa ;
   private String[] T00014_A607MigrLegClase ;
   private java.math.BigDecimal[] T00014_A608MigrLegBasico ;
   private String[] T00014_A609MigrLegFormaPago ;
   private boolean[] T00014_A691MigrLegClaseDef ;
   private String[] T00014_A610MigrLegBanco ;
   private String[] T00014_A611MigrLegBanSuc ;
   private String[] T00014_A612MigrLegBanTipCuen ;
   private String[] T00014_A613MigrLegSindicato ;
   private String[] T00014_A614MigrLegObraSocial ;
   private String[] T00014_A634MigrLegOSAfip ;
   private String[] T00014_A615MigrLegPlanMedico ;
   private String[] T00014_A616MigrLegActividad ;
   private String[] T00014_A617MigrLegModalidad ;
   private java.util.Date[] T00014_A618MigrLegFecUltMod ;
   private String[] T00014_A619MigrLegCuentaBanc ;
   private String[] T00014_A620MigrLegZona ;
   private String[] T00014_A621MigrLegCBU ;
   private String[] T00014_A622MigrLegSCVO ;
   private String[] T00014_A623MigrLegSituacionRevista ;
   private String[] T00014_A624MigrLegCondicion ;
   private String[] T00014_A625MigrLegSiniestrado ;
   private String[] T00014_A626MigrLegId ;
   private String[] T00014_A627MigrLegConvenio ;
   private String[] T00014_A628MigrLegObs ;
   private String[] T00014_A629MigrLegErrores ;
   private String[] T00014_A633MigrLegWarnings ;
   private String[] T00014_A631MigrTieneConyuge ;
   private short[] T00014_A632MigrCantidadHijos ;
   private boolean[] T00014_A635MigrEncontroOsoSigla ;
   private String[] T00014_A1398MigrTraDiurno ;
   private String[] T00014_A1399MigrTraNoct ;
   private String[] T00014_A1400MigrTraIns ;
   private boolean[] T00014_A1820MigrEncontroOsoAfip ;
   private String[] T00014_A2189MigrSueldos ;
   private java.util.Date[] T00014_A2190MigrPeriodo ;
   private boolean[] T00014_A695MigrLegModalidadDef ;
   private boolean[] T00014_A696MigrLegZonaDef ;
   private boolean[] T00014_A698MigrLegSituacionDef ;
   private boolean[] T00014_A690MigrLegEstadoCivilDef ;
   private boolean[] T00014_A692MigrLegFormaPagoDef ;
   private boolean[] T00014_A693MigrLegTipoCuentaDef ;
   private boolean[] T00014_A694MigrLegActividadDef ;
   private boolean[] T00014_A699MigrLegCondicionDef ;
   private boolean[] T00014_A700MigrLegSiniestradoDef ;
   private boolean[] T00014_A2197MigrValCadaSave ;
   private java.util.Date[] T00014_A2205MigrLegFecEgreso ;
   private String[] T00014_A2206MigrOtrosDatos ;
   private String[] T00014_A2216MigrPuesto ;
   private String[] T00014_A2221MigrLegMarcaCCT ;
   private boolean[] T00014_n2221MigrLegMarcaCCT ;
   private short[] T00014_A2222MigrArchSec ;
   private boolean[] T00014_n2222MigrArchSec ;
   private String[] T00014_A2239MigrLegActLabClas ;
   private String[] T00014_A2240MigrLegPueAfip ;
   private java.math.BigDecimal[] T00014_A2275MigrLegHorSem ;
   private int[] T00014_A3CliCod ;
   private short[] T00014_A1EmpCod ;
   private int[] T000115_A3CliCod ;
   private short[] T000115_A1EmpCod ;
   private int[] T000115_A87MigrLegNumero ;
   private short[] T000116_A1EmpCod ;
   private int[] T000116_A87MigrLegNumero ;
   private short[] T000116_A2078MigrLegFamSec ;
   private String[] T000116_A2079MigrLegFamParen ;
   private String[] T000116_A2080MigrLegFamNroDoc ;
   private java.math.BigDecimal[] T000116_A2081MigrLegFamDedGan ;
   private String[] T000116_A2082MigrLegFamAdh ;
   private String[] T000116_A2086MigrLegFamDiscap ;
   private String[] T000116_A2088MigrLegFamNomApe ;
   private java.util.Date[] T000116_A2089MigrLegFamFecNac ;
   private int[] T000116_A3CliCod ;
   private int[] T000117_A3CliCod ;
   private short[] T000117_A1EmpCod ;
   private int[] T000117_A87MigrLegNumero ;
   private short[] T000117_A2078MigrLegFamSec ;
   private short[] T00013_A1EmpCod ;
   private int[] T00013_A87MigrLegNumero ;
   private short[] T00013_A2078MigrLegFamSec ;
   private String[] T00013_A2079MigrLegFamParen ;
   private String[] T00013_A2080MigrLegFamNroDoc ;
   private java.math.BigDecimal[] T00013_A2081MigrLegFamDedGan ;
   private String[] T00013_A2082MigrLegFamAdh ;
   private String[] T00013_A2086MigrLegFamDiscap ;
   private String[] T00013_A2088MigrLegFamNomApe ;
   private java.util.Date[] T00013_A2089MigrLegFamFecNac ;
   private int[] T00013_A3CliCod ;
   private short[] T00012_A1EmpCod ;
   private int[] T00012_A87MigrLegNumero ;
   private short[] T00012_A2078MigrLegFamSec ;
   private String[] T00012_A2079MigrLegFamParen ;
   private String[] T00012_A2080MigrLegFamNroDoc ;
   private java.math.BigDecimal[] T00012_A2081MigrLegFamDedGan ;
   private String[] T00012_A2082MigrLegFamAdh ;
   private String[] T00012_A2086MigrLegFamDiscap ;
   private String[] T00012_A2088MigrLegFamNomApe ;
   private java.util.Date[] T00012_A2089MigrLegFamFecNac ;
   private int[] T00012_A3CliCod ;
   private int[] T000121_A3CliCod ;
   private short[] T000121_A1EmpCod ;
   private int[] T000121_A87MigrLegNumero ;
   private short[] T000121_A2078MigrLegFamSec ;
   private int[] T000122_A3CliCod ;
   private com.genexus.webpanels.GXWebForm Form ;
   private GXSimpleCollection<String> AV67errores ;
   private GXSimpleCollection<String> GXv_objcol_svchar4[] ;
   private GXSimpleCollection<String> AV68warnings ;
   private GXSimpleCollection<String> GXv_objcol_svchar5[] ;
   private web.wwpbaseobjects.SdtWWPTransactionContext AV54TrnContext ;
   private web.wwpbaseobjects.SdtWWPContext AV56WWPContext ;
   private web.wwpbaseobjects.SdtWWPContext GXv_SdtWWPContext1[] ;
}

final  class importacion_legajo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00012", "SELECT EmpCod, MigrLegNumero, MigrLegFamSec, MigrLegFamParen, MigrLegFamNroDoc, MigrLegFamDedGan, MigrLegFamAdh, MigrLegFamDiscap, MigrLegFamNomApe, MigrLegFamFecNac, CliCod FROM importacion_legajoFamilia WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ?  FOR UPDATE OF importacion_legajoFamilia NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00013", "SELECT EmpCod, MigrLegNumero, MigrLegFamSec, MigrLegFamParen, MigrLegFamNroDoc, MigrLegFamDedGan, MigrLegFamAdh, MigrLegFamDiscap, MigrLegFamNomApe, MigrLegFamFecNac, CliCod FROM importacion_legajoFamilia WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00014", "SELECT MigrLegNumero, MigrLegApellido, MigrLegNombre, MigrLegFecNac, MigrLegSexo, MigrLegEstadoCivil, MigrLegCUIL, MigrLegDiscapacidad, MigrLegDomici, MigrLegEmail, MigrLegCodPos, MigrLegTelefono, MigrLegFecIngreso, MigrLegCategoria, MigrLegArea, MigrLegLugarDePago, MigrLegModTra, MigrLegTipoTarifa, MigrLegClase, MigrLegBasico, MigrLegFormaPago, MigrLegClaseDef, MigrLegBanco, MigrLegBanSuc, MigrLegBanTipCuen, MigrLegSindicato, MigrLegObraSocial, MigrLegOSAfip, MigrLegPlanMedico, MigrLegActividad, MigrLegModalidad, MigrLegFecUltMod, MigrLegCuentaBanc, MigrLegZona, MigrLegCBU, MigrLegSCVO, MigrLegSituacionRevista, MigrLegCondicion, MigrLegSiniestrado, MigrLegId, MigrLegConvenio, MigrLegObs, MigrLegErrores, MigrLegWarnings, MigrTieneConyuge, MigrCantidadHijos, MigrEncontroOsoSigla, MigrTraDiurno, MigrTraNoct, MigrTraIns, MigrEncontroOsoAfip, MigrSueldos, MigrPeriodo, MigrLegModalidadDef, MigrLegZonaDef, MigrLegSituacionDef, MigrLegEstadoCivilDef, MigrLegFormaPagoDef, MigrLegTipoCuentaDef, MigrLegActividadDef, MigrLegCondicionDef, MigrLegSiniestradoDef, MigrValCadaSave, MigrLegFecEgreso, MigrOtrosDatos, MigrPuesto, MigrLegMarcaCCT, MigrArchSec, MigrLegActLabClas, MigrLegPueAfip, MigrLegHorSem, CliCod, EmpCod FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ?  FOR UPDATE OF importacion_legajo NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00015", "SELECT MigrLegNumero, MigrLegApellido, MigrLegNombre, MigrLegFecNac, MigrLegSexo, MigrLegEstadoCivil, MigrLegCUIL, MigrLegDiscapacidad, MigrLegDomici, MigrLegEmail, MigrLegCodPos, MigrLegTelefono, MigrLegFecIngreso, MigrLegCategoria, MigrLegArea, MigrLegLugarDePago, MigrLegModTra, MigrLegTipoTarifa, MigrLegClase, MigrLegBasico, MigrLegFormaPago, MigrLegClaseDef, MigrLegBanco, MigrLegBanSuc, MigrLegBanTipCuen, MigrLegSindicato, MigrLegObraSocial, MigrLegOSAfip, MigrLegPlanMedico, MigrLegActividad, MigrLegModalidad, MigrLegFecUltMod, MigrLegCuentaBanc, MigrLegZona, MigrLegCBU, MigrLegSCVO, MigrLegSituacionRevista, MigrLegCondicion, MigrLegSiniestrado, MigrLegId, MigrLegConvenio, MigrLegObs, MigrLegErrores, MigrLegWarnings, MigrTieneConyuge, MigrCantidadHijos, MigrEncontroOsoSigla, MigrTraDiurno, MigrTraNoct, MigrTraIns, MigrEncontroOsoAfip, MigrSueldos, MigrPeriodo, MigrLegModalidadDef, MigrLegZonaDef, MigrLegSituacionDef, MigrLegEstadoCivilDef, MigrLegFormaPagoDef, MigrLegTipoCuentaDef, MigrLegActividadDef, MigrLegCondicionDef, MigrLegSiniestradoDef, MigrValCadaSave, MigrLegFecEgreso, MigrOtrosDatos, MigrPuesto, MigrLegMarcaCCT, MigrArchSec, MigrLegActLabClas, MigrLegPueAfip, MigrLegHorSem, CliCod, EmpCod FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00016", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00017", "SELECT TM1.MigrLegNumero, TM1.MigrLegApellido, TM1.MigrLegNombre, TM1.MigrLegFecNac, TM1.MigrLegSexo, TM1.MigrLegEstadoCivil, TM1.MigrLegCUIL, TM1.MigrLegDiscapacidad, TM1.MigrLegDomici, TM1.MigrLegEmail, TM1.MigrLegCodPos, TM1.MigrLegTelefono, TM1.MigrLegFecIngreso, TM1.MigrLegCategoria, TM1.MigrLegArea, TM1.MigrLegLugarDePago, TM1.MigrLegModTra, TM1.MigrLegTipoTarifa, TM1.MigrLegClase, TM1.MigrLegBasico, TM1.MigrLegFormaPago, TM1.MigrLegClaseDef, TM1.MigrLegBanco, TM1.MigrLegBanSuc, TM1.MigrLegBanTipCuen, TM1.MigrLegSindicato, TM1.MigrLegObraSocial, TM1.MigrLegOSAfip, TM1.MigrLegPlanMedico, TM1.MigrLegActividad, TM1.MigrLegModalidad, TM1.MigrLegFecUltMod, TM1.MigrLegCuentaBanc, TM1.MigrLegZona, TM1.MigrLegCBU, TM1.MigrLegSCVO, TM1.MigrLegSituacionRevista, TM1.MigrLegCondicion, TM1.MigrLegSiniestrado, TM1.MigrLegId, TM1.MigrLegConvenio, TM1.MigrLegObs, TM1.MigrLegErrores, TM1.MigrLegWarnings, TM1.MigrTieneConyuge, TM1.MigrCantidadHijos, TM1.MigrEncontroOsoSigla, TM1.MigrTraDiurno, TM1.MigrTraNoct, TM1.MigrTraIns, TM1.MigrEncontroOsoAfip, TM1.MigrSueldos, TM1.MigrPeriodo, TM1.MigrLegModalidadDef, TM1.MigrLegZonaDef, TM1.MigrLegSituacionDef, TM1.MigrLegEstadoCivilDef, TM1.MigrLegFormaPagoDef, TM1.MigrLegTipoCuentaDef, TM1.MigrLegActividadDef, TM1.MigrLegCondicionDef, TM1.MigrLegSiniestradoDef, TM1.MigrValCadaSave, TM1.MigrLegFecEgreso, TM1.MigrOtrosDatos, TM1.MigrPuesto, TM1.MigrLegMarcaCCT, TM1.MigrArchSec, TM1.MigrLegActLabClas, TM1.MigrLegPueAfip, TM1.MigrLegHorSem, TM1.CliCod, TM1.EmpCod FROM importacion_legajo TM1 WHERE TM1.CliCod = ? and TM1.EmpCod = ? and TM1.MigrLegNumero = ? ORDER BY TM1.CliCod, TM1.EmpCod, TM1.MigrLegNumero ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00018", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00019", "SELECT CliCod, EmpCod, MigrLegNumero FROM importacion_legajo WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000110", "SELECT CliCod, EmpCod, MigrLegNumero FROM importacion_legajo WHERE ( CliCod > ? or CliCod = ? and EmpCod > ? or EmpCod = ? and CliCod = ? and MigrLegNumero > ?) ORDER BY CliCod, EmpCod, MigrLegNumero  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000111", "SELECT CliCod, EmpCod, MigrLegNumero FROM importacion_legajo WHERE ( CliCod < ? or CliCod = ? and EmpCod < ? or EmpCod = ? and CliCod = ? and MigrLegNumero < ?) ORDER BY CliCod DESC, EmpCod DESC, MigrLegNumero DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000112", "SAVEPOINT gxupdate;INSERT INTO importacion_legajo(MigrLegNumero, MigrLegApellido, MigrLegNombre, MigrLegFecNac, MigrLegSexo, MigrLegEstadoCivil, MigrLegCUIL, MigrLegDiscapacidad, MigrLegDomici, MigrLegEmail, MigrLegCodPos, MigrLegTelefono, MigrLegFecIngreso, MigrLegCategoria, MigrLegArea, MigrLegLugarDePago, MigrLegModTra, MigrLegTipoTarifa, MigrLegClase, MigrLegBasico, MigrLegFormaPago, MigrLegClaseDef, MigrLegBanco, MigrLegBanSuc, MigrLegBanTipCuen, MigrLegSindicato, MigrLegObraSocial, MigrLegOSAfip, MigrLegPlanMedico, MigrLegActividad, MigrLegModalidad, MigrLegFecUltMod, MigrLegCuentaBanc, MigrLegZona, MigrLegCBU, MigrLegSCVO, MigrLegSituacionRevista, MigrLegCondicion, MigrLegSiniestrado, MigrLegId, MigrLegConvenio, MigrLegObs, MigrLegErrores, MigrLegWarnings, MigrTieneConyuge, MigrCantidadHijos, MigrEncontroOsoSigla, MigrTraDiurno, MigrTraNoct, MigrTraIns, MigrEncontroOsoAfip, MigrSueldos, MigrPeriodo, MigrLegModalidadDef, MigrLegZonaDef, MigrLegSituacionDef, MigrLegEstadoCivilDef, MigrLegFormaPagoDef, MigrLegTipoCuentaDef, MigrLegActividadDef, MigrLegCondicionDef, MigrLegSiniestradoDef, MigrValCadaSave, MigrLegFecEgreso, MigrOtrosDatos, MigrPuesto, MigrLegMarcaCCT, MigrArchSec, MigrLegActLabClas, MigrLegPueAfip, MigrLegHorSem, CliCod, EmpCod, MigrLegAreaDef, MigrLegSCVODef) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, FALSE, FALSE);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000113", "SAVEPOINT gxupdate;UPDATE importacion_legajo SET MigrLegApellido=?, MigrLegNombre=?, MigrLegFecNac=?, MigrLegSexo=?, MigrLegEstadoCivil=?, MigrLegCUIL=?, MigrLegDiscapacidad=?, MigrLegDomici=?, MigrLegEmail=?, MigrLegCodPos=?, MigrLegTelefono=?, MigrLegFecIngreso=?, MigrLegCategoria=?, MigrLegArea=?, MigrLegLugarDePago=?, MigrLegModTra=?, MigrLegTipoTarifa=?, MigrLegClase=?, MigrLegBasico=?, MigrLegFormaPago=?, MigrLegClaseDef=?, MigrLegBanco=?, MigrLegBanSuc=?, MigrLegBanTipCuen=?, MigrLegSindicato=?, MigrLegObraSocial=?, MigrLegOSAfip=?, MigrLegPlanMedico=?, MigrLegActividad=?, MigrLegModalidad=?, MigrLegFecUltMod=?, MigrLegCuentaBanc=?, MigrLegZona=?, MigrLegCBU=?, MigrLegSCVO=?, MigrLegSituacionRevista=?, MigrLegCondicion=?, MigrLegSiniestrado=?, MigrLegId=?, MigrLegConvenio=?, MigrLegObs=?, MigrLegErrores=?, MigrLegWarnings=?, MigrTieneConyuge=?, MigrCantidadHijos=?, MigrEncontroOsoSigla=?, MigrTraDiurno=?, MigrTraNoct=?, MigrTraIns=?, MigrEncontroOsoAfip=?, MigrSueldos=?, MigrPeriodo=?, MigrLegModalidadDef=?, MigrLegZonaDef=?, MigrLegSituacionDef=?, MigrLegEstadoCivilDef=?, MigrLegFormaPagoDef=?, MigrLegTipoCuentaDef=?, MigrLegActividadDef=?, MigrLegCondicionDef=?, MigrLegSiniestradoDef=?, MigrValCadaSave=?, MigrLegFecEgreso=?, MigrOtrosDatos=?, MigrPuesto=?, MigrLegMarcaCCT=?, MigrArchSec=?, MigrLegActLabClas=?, MigrLegPueAfip=?, MigrLegHorSem=?  WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000114", "SAVEPOINT gxupdate;DELETE FROM importacion_legajo  WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000115", "SELECT CliCod, EmpCod, MigrLegNumero FROM importacion_legajo ORDER BY CliCod, EmpCod, MigrLegNumero ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000116", "SELECT EmpCod, MigrLegNumero, MigrLegFamSec, MigrLegFamParen, MigrLegFamNroDoc, MigrLegFamDedGan, MigrLegFamAdh, MigrLegFamDiscap, MigrLegFamNomApe, MigrLegFamFecNac, CliCod FROM importacion_legajoFamilia WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? and MigrLegFamSec = ? ORDER BY CliCod, EmpCod, MigrLegNumero, MigrLegFamSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000117", "SELECT CliCod, EmpCod, MigrLegNumero, MigrLegFamSec FROM importacion_legajoFamilia WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000118", "SAVEPOINT gxupdate;INSERT INTO importacion_legajoFamilia(EmpCod, MigrLegNumero, MigrLegFamSec, MigrLegFamParen, MigrLegFamNroDoc, MigrLegFamDedGan, MigrLegFamAdh, MigrLegFamDiscap, MigrLegFamNomApe, MigrLegFamFecNac, CliCod, MigrLegFamErrores, MigrLegFamWarnings) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, '', '');RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000119", "SAVEPOINT gxupdate;UPDATE importacion_legajoFamilia SET MigrLegFamParen=?, MigrLegFamNroDoc=?, MigrLegFamDedGan=?, MigrLegFamAdh=?, MigrLegFamDiscap=?, MigrLegFamNomApe=?, MigrLegFamFecNac=?  WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000120", "SAVEPOINT gxupdate;DELETE FROM importacion_legajoFamilia  WHERE CliCod = ? AND EmpCod = ? AND MigrLegNumero = ? AND MigrLegFamSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000121", "SELECT CliCod, EmpCod, MigrLegNumero, MigrLegFamSec FROM importacion_legajoFamilia WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero, MigrLegFamSec ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000122", "SELECT CliCod FROM Empresa WHERE CliCod = ? AND EmpCod = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 13);
               ((String[]) buf[7])[0] = rslt.getString(8, 2);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(20,2);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((boolean[]) buf[21])[0] = rslt.getBoolean(22);
               ((String[]) buf[22])[0] = rslt.getVarchar(23);
               ((String[]) buf[23])[0] = rslt.getVarchar(24);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getVarchar(26);
               ((String[]) buf[26])[0] = rslt.getVarchar(27);
               ((String[]) buf[27])[0] = rslt.getString(28, 20);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((String[]) buf[30])[0] = rslt.getVarchar(31);
               ((java.util.Date[]) buf[31])[0] = rslt.getGXDate(32);
               ((String[]) buf[32])[0] = rslt.getVarchar(33);
               ((String[]) buf[33])[0] = rslt.getVarchar(34);
               ((String[]) buf[34])[0] = rslt.getVarchar(35);
               ((String[]) buf[35])[0] = rslt.getString(36, 2);
               ((String[]) buf[36])[0] = rslt.getVarchar(37);
               ((String[]) buf[37])[0] = rslt.getVarchar(38);
               ((String[]) buf[38])[0] = rslt.getVarchar(39);
               ((String[]) buf[39])[0] = rslt.getString(40, 20);
               ((String[]) buf[40])[0] = rslt.getVarchar(41);
               ((String[]) buf[41])[0] = rslt.getLongVarchar(42);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(43);
               ((String[]) buf[43])[0] = rslt.getLongVarchar(44);
               ((String[]) buf[44])[0] = rslt.getString(45, 20);
               ((short[]) buf[45])[0] = rslt.getShort(46);
               ((boolean[]) buf[46])[0] = rslt.getBoolean(47);
               ((String[]) buf[47])[0] = rslt.getString(48, 2);
               ((String[]) buf[48])[0] = rslt.getString(49, 2);
               ((String[]) buf[49])[0] = rslt.getString(50, 2);
               ((boolean[]) buf[50])[0] = rslt.getBoolean(51);
               ((String[]) buf[51])[0] = rslt.getLongVarchar(52);
               ((java.util.Date[]) buf[52])[0] = rslt.getGXDate(53);
               ((boolean[]) buf[53])[0] = rslt.getBoolean(54);
               ((boolean[]) buf[54])[0] = rslt.getBoolean(55);
               ((boolean[]) buf[55])[0] = rslt.getBoolean(56);
               ((boolean[]) buf[56])[0] = rslt.getBoolean(57);
               ((boolean[]) buf[57])[0] = rslt.getBoolean(58);
               ((boolean[]) buf[58])[0] = rslt.getBoolean(59);
               ((boolean[]) buf[59])[0] = rslt.getBoolean(60);
               ((boolean[]) buf[60])[0] = rslt.getBoolean(61);
               ((boolean[]) buf[61])[0] = rslt.getBoolean(62);
               ((boolean[]) buf[62])[0] = rslt.getBoolean(63);
               ((java.util.Date[]) buf[63])[0] = rslt.getGXDate(64);
               ((String[]) buf[64])[0] = rslt.getLongVarchar(65);
               ((String[]) buf[65])[0] = rslt.getVarchar(66);
               ((String[]) buf[66])[0] = rslt.getString(67, 1);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               ((short[]) buf[68])[0] = rslt.getShort(68);
               ((boolean[]) buf[69])[0] = rslt.wasNull();
               ((String[]) buf[70])[0] = rslt.getVarchar(69);
               ((String[]) buf[71])[0] = rslt.getVarchar(70);
               ((java.math.BigDecimal[]) buf[72])[0] = rslt.getBigDecimal(71,1);
               ((int[]) buf[73])[0] = rslt.getInt(72);
               ((short[]) buf[74])[0] = rslt.getShort(73);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 13);
               ((String[]) buf[7])[0] = rslt.getString(8, 2);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(20,2);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((boolean[]) buf[21])[0] = rslt.getBoolean(22);
               ((String[]) buf[22])[0] = rslt.getVarchar(23);
               ((String[]) buf[23])[0] = rslt.getVarchar(24);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getVarchar(26);
               ((String[]) buf[26])[0] = rslt.getVarchar(27);
               ((String[]) buf[27])[0] = rslt.getString(28, 20);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((String[]) buf[30])[0] = rslt.getVarchar(31);
               ((java.util.Date[]) buf[31])[0] = rslt.getGXDate(32);
               ((String[]) buf[32])[0] = rslt.getVarchar(33);
               ((String[]) buf[33])[0] = rslt.getVarchar(34);
               ((String[]) buf[34])[0] = rslt.getVarchar(35);
               ((String[]) buf[35])[0] = rslt.getString(36, 2);
               ((String[]) buf[36])[0] = rslt.getVarchar(37);
               ((String[]) buf[37])[0] = rslt.getVarchar(38);
               ((String[]) buf[38])[0] = rslt.getVarchar(39);
               ((String[]) buf[39])[0] = rslt.getString(40, 20);
               ((String[]) buf[40])[0] = rslt.getVarchar(41);
               ((String[]) buf[41])[0] = rslt.getLongVarchar(42);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(43);
               ((String[]) buf[43])[0] = rslt.getLongVarchar(44);
               ((String[]) buf[44])[0] = rslt.getString(45, 20);
               ((short[]) buf[45])[0] = rslt.getShort(46);
               ((boolean[]) buf[46])[0] = rslt.getBoolean(47);
               ((String[]) buf[47])[0] = rslt.getString(48, 2);
               ((String[]) buf[48])[0] = rslt.getString(49, 2);
               ((String[]) buf[49])[0] = rslt.getString(50, 2);
               ((boolean[]) buf[50])[0] = rslt.getBoolean(51);
               ((String[]) buf[51])[0] = rslt.getLongVarchar(52);
               ((java.util.Date[]) buf[52])[0] = rslt.getGXDate(53);
               ((boolean[]) buf[53])[0] = rslt.getBoolean(54);
               ((boolean[]) buf[54])[0] = rslt.getBoolean(55);
               ((boolean[]) buf[55])[0] = rslt.getBoolean(56);
               ((boolean[]) buf[56])[0] = rslt.getBoolean(57);
               ((boolean[]) buf[57])[0] = rslt.getBoolean(58);
               ((boolean[]) buf[58])[0] = rslt.getBoolean(59);
               ((boolean[]) buf[59])[0] = rslt.getBoolean(60);
               ((boolean[]) buf[60])[0] = rslt.getBoolean(61);
               ((boolean[]) buf[61])[0] = rslt.getBoolean(62);
               ((boolean[]) buf[62])[0] = rslt.getBoolean(63);
               ((java.util.Date[]) buf[63])[0] = rslt.getGXDate(64);
               ((String[]) buf[64])[0] = rslt.getLongVarchar(65);
               ((String[]) buf[65])[0] = rslt.getVarchar(66);
               ((String[]) buf[66])[0] = rslt.getString(67, 1);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               ((short[]) buf[68])[0] = rslt.getShort(68);
               ((boolean[]) buf[69])[0] = rslt.wasNull();
               ((String[]) buf[70])[0] = rslt.getVarchar(69);
               ((String[]) buf[71])[0] = rslt.getVarchar(70);
               ((java.math.BigDecimal[]) buf[72])[0] = rslt.getBigDecimal(71,1);
               ((int[]) buf[73])[0] = rslt.getInt(72);
               ((short[]) buf[74])[0] = rslt.getShort(73);
               return;
            case 4 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 5 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((java.util.Date[]) buf[3])[0] = rslt.getGXDate(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 13);
               ((String[]) buf[7])[0] = rslt.getString(8, 2);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((String[]) buf[10])[0] = rslt.getVarchar(11);
               ((String[]) buf[11])[0] = rslt.getVarchar(12);
               ((java.util.Date[]) buf[12])[0] = rslt.getGXDate(13);
               ((String[]) buf[13])[0] = rslt.getVarchar(14);
               ((String[]) buf[14])[0] = rslt.getVarchar(15);
               ((String[]) buf[15])[0] = rslt.getVarchar(16);
               ((String[]) buf[16])[0] = rslt.getVarchar(17);
               ((String[]) buf[17])[0] = rslt.getVarchar(18);
               ((String[]) buf[18])[0] = rslt.getVarchar(19);
               ((java.math.BigDecimal[]) buf[19])[0] = rslt.getBigDecimal(20,2);
               ((String[]) buf[20])[0] = rslt.getVarchar(21);
               ((boolean[]) buf[21])[0] = rslt.getBoolean(22);
               ((String[]) buf[22])[0] = rslt.getVarchar(23);
               ((String[]) buf[23])[0] = rslt.getVarchar(24);
               ((String[]) buf[24])[0] = rslt.getVarchar(25);
               ((String[]) buf[25])[0] = rslt.getVarchar(26);
               ((String[]) buf[26])[0] = rslt.getVarchar(27);
               ((String[]) buf[27])[0] = rslt.getString(28, 20);
               ((String[]) buf[28])[0] = rslt.getVarchar(29);
               ((String[]) buf[29])[0] = rslt.getVarchar(30);
               ((String[]) buf[30])[0] = rslt.getVarchar(31);
               ((java.util.Date[]) buf[31])[0] = rslt.getGXDate(32);
               ((String[]) buf[32])[0] = rslt.getVarchar(33);
               ((String[]) buf[33])[0] = rslt.getVarchar(34);
               ((String[]) buf[34])[0] = rslt.getVarchar(35);
               ((String[]) buf[35])[0] = rslt.getString(36, 2);
               ((String[]) buf[36])[0] = rslt.getVarchar(37);
               ((String[]) buf[37])[0] = rslt.getVarchar(38);
               ((String[]) buf[38])[0] = rslt.getVarchar(39);
               ((String[]) buf[39])[0] = rslt.getString(40, 20);
               ((String[]) buf[40])[0] = rslt.getVarchar(41);
               ((String[]) buf[41])[0] = rslt.getLongVarchar(42);
               ((String[]) buf[42])[0] = rslt.getLongVarchar(43);
               ((String[]) buf[43])[0] = rslt.getLongVarchar(44);
               ((String[]) buf[44])[0] = rslt.getString(45, 20);
               ((short[]) buf[45])[0] = rslt.getShort(46);
               ((boolean[]) buf[46])[0] = rslt.getBoolean(47);
               ((String[]) buf[47])[0] = rslt.getString(48, 2);
               ((String[]) buf[48])[0] = rslt.getString(49, 2);
               ((String[]) buf[49])[0] = rslt.getString(50, 2);
               ((boolean[]) buf[50])[0] = rslt.getBoolean(51);
               ((String[]) buf[51])[0] = rslt.getLongVarchar(52);
               ((java.util.Date[]) buf[52])[0] = rslt.getGXDate(53);
               ((boolean[]) buf[53])[0] = rslt.getBoolean(54);
               ((boolean[]) buf[54])[0] = rslt.getBoolean(55);
               ((boolean[]) buf[55])[0] = rslt.getBoolean(56);
               ((boolean[]) buf[56])[0] = rslt.getBoolean(57);
               ((boolean[]) buf[57])[0] = rslt.getBoolean(58);
               ((boolean[]) buf[58])[0] = rslt.getBoolean(59);
               ((boolean[]) buf[59])[0] = rslt.getBoolean(60);
               ((boolean[]) buf[60])[0] = rslt.getBoolean(61);
               ((boolean[]) buf[61])[0] = rslt.getBoolean(62);
               ((boolean[]) buf[62])[0] = rslt.getBoolean(63);
               ((java.util.Date[]) buf[63])[0] = rslt.getGXDate(64);
               ((String[]) buf[64])[0] = rslt.getLongVarchar(65);
               ((String[]) buf[65])[0] = rslt.getVarchar(66);
               ((String[]) buf[66])[0] = rslt.getString(67, 1);
               ((boolean[]) buf[67])[0] = rslt.wasNull();
               ((short[]) buf[68])[0] = rslt.getShort(68);
               ((boolean[]) buf[69])[0] = rslt.wasNull();
               ((String[]) buf[70])[0] = rslt.getVarchar(69);
               ((String[]) buf[71])[0] = rslt.getVarchar(70);
               ((java.math.BigDecimal[]) buf[72])[0] = rslt.getBigDecimal(71,1);
               ((int[]) buf[73])[0] = rslt.getInt(72);
               ((short[]) buf[74])[0] = rslt.getShort(73);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 7 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 13 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(6,4);
               ((String[]) buf[6])[0] = rslt.getString(7, 20);
               ((String[]) buf[7])[0] = rslt.getString(8, 20);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.util.Date[]) buf[9])[0] = rslt.getGXDate(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               return;
            case 15 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 19 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               return;
            case 20 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 9 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setInt(5, ((Number) parms[4]).intValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setVarchar(3, (String)parms[2], 400, false);
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setVarchar(6, (String)parms[5], 400, false);
               stmt.setString(7, (String)parms[6], 13);
               stmt.setString(8, (String)parms[7], 2);
               stmt.setVarchar(9, (String)parms[8], 4000, false);
               stmt.setVarchar(10, (String)parms[9], 100, false);
               stmt.setVarchar(11, (String)parms[10], 400, false);
               stmt.setVarchar(12, (String)parms[11], 400, false);
               stmt.setDate(13, (java.util.Date)parms[12]);
               stmt.setVarchar(14, (String)parms[13], 400, false);
               stmt.setVarchar(15, (String)parms[14], 400, false);
               stmt.setVarchar(16, (String)parms[15], 20, false);
               stmt.setVarchar(17, (String)parms[16], 400, false);
               stmt.setVarchar(18, (String)parms[17], 400, false);
               stmt.setVarchar(19, (String)parms[18], 400, false);
               stmt.setBigDecimal(20, (java.math.BigDecimal)parms[19], 2);
               stmt.setVarchar(21, (String)parms[20], 400, false);
               stmt.setBoolean(22, ((Boolean) parms[21]).booleanValue());
               stmt.setVarchar(23, (String)parms[22], 400, false);
               stmt.setVarchar(24, (String)parms[23], 400, false);
               stmt.setVarchar(25, (String)parms[24], 20, false);
               stmt.setVarchar(26, (String)parms[25], 400, false);
               stmt.setVarchar(27, (String)parms[26], 400, false);
               stmt.setString(28, (String)parms[27], 20);
               stmt.setVarchar(29, (String)parms[28], 400, false);
               stmt.setVarchar(30, (String)parms[29], 150, false);
               stmt.setVarchar(31, (String)parms[30], 400, false);
               stmt.setDate(32, (java.util.Date)parms[31]);
               stmt.setVarchar(33, (String)parms[32], 20, false);
               stmt.setVarchar(34, (String)parms[33], 400, false);
               stmt.setVarchar(35, (String)parms[34], 22, false);
               stmt.setString(36, (String)parms[35], 2);
               stmt.setVarchar(37, (String)parms[36], 40, false);
               stmt.setVarchar(38, (String)parms[37], 40, false);
               stmt.setVarchar(39, (String)parms[38], 400, false);
               stmt.setString(40, (String)parms[39], 20);
               stmt.setVarchar(41, (String)parms[40], 400, false);
               stmt.setNLongVarchar(42, (String)parms[41], false);
               stmt.setNLongVarchar(43, (String)parms[42], false);
               stmt.setNLongVarchar(44, (String)parms[43], false);
               stmt.setString(45, (String)parms[44], 20);
               stmt.setShort(46, ((Number) parms[45]).shortValue());
               stmt.setBoolean(47, ((Boolean) parms[46]).booleanValue());
               stmt.setString(48, (String)parms[47], 2);
               stmt.setString(49, (String)parms[48], 2);
               stmt.setString(50, (String)parms[49], 2);
               stmt.setBoolean(51, ((Boolean) parms[50]).booleanValue());
               stmt.setNLongVarchar(52, (String)parms[51], false);
               stmt.setDate(53, (java.util.Date)parms[52]);
               stmt.setBoolean(54, ((Boolean) parms[53]).booleanValue());
               stmt.setBoolean(55, ((Boolean) parms[54]).booleanValue());
               stmt.setBoolean(56, ((Boolean) parms[55]).booleanValue());
               stmt.setBoolean(57, ((Boolean) parms[56]).booleanValue());
               stmt.setBoolean(58, ((Boolean) parms[57]).booleanValue());
               stmt.setBoolean(59, ((Boolean) parms[58]).booleanValue());
               stmt.setBoolean(60, ((Boolean) parms[59]).booleanValue());
               stmt.setBoolean(61, ((Boolean) parms[60]).booleanValue());
               stmt.setBoolean(62, ((Boolean) parms[61]).booleanValue());
               stmt.setBoolean(63, ((Boolean) parms[62]).booleanValue());
               stmt.setDate(64, (java.util.Date)parms[63]);
               stmt.setNLongVarchar(65, (String)parms[64], false);
               stmt.setVarchar(66, (String)parms[65], 400, false);
               if ( ((Boolean) parms[66]).booleanValue() )
               {
                  stmt.setNull( 67 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(67, (String)parms[67], 1);
               }
               if ( ((Boolean) parms[68]).booleanValue() )
               {
                  stmt.setNull( 68 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(68, ((Number) parms[69]).shortValue());
               }
               stmt.setVarchar(69, (String)parms[70], 60, false);
               stmt.setVarchar(70, (String)parms[71], 255, false);
               stmt.setBigDecimal(71, (java.math.BigDecimal)parms[72], 1);
               stmt.setInt(72, ((Number) parms[73]).intValue());
               stmt.setShort(73, ((Number) parms[74]).shortValue());
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setDate(3, (java.util.Date)parms[2]);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setString(6, (String)parms[5], 13);
               stmt.setString(7, (String)parms[6], 2);
               stmt.setVarchar(8, (String)parms[7], 4000, false);
               stmt.setVarchar(9, (String)parms[8], 100, false);
               stmt.setVarchar(10, (String)parms[9], 400, false);
               stmt.setVarchar(11, (String)parms[10], 400, false);
               stmt.setDate(12, (java.util.Date)parms[11]);
               stmt.setVarchar(13, (String)parms[12], 400, false);
               stmt.setVarchar(14, (String)parms[13], 400, false);
               stmt.setVarchar(15, (String)parms[14], 20, false);
               stmt.setVarchar(16, (String)parms[15], 400, false);
               stmt.setVarchar(17, (String)parms[16], 400, false);
               stmt.setVarchar(18, (String)parms[17], 400, false);
               stmt.setBigDecimal(19, (java.math.BigDecimal)parms[18], 2);
               stmt.setVarchar(20, (String)parms[19], 400, false);
               stmt.setBoolean(21, ((Boolean) parms[20]).booleanValue());
               stmt.setVarchar(22, (String)parms[21], 400, false);
               stmt.setVarchar(23, (String)parms[22], 400, false);
               stmt.setVarchar(24, (String)parms[23], 20, false);
               stmt.setVarchar(25, (String)parms[24], 400, false);
               stmt.setVarchar(26, (String)parms[25], 400, false);
               stmt.setString(27, (String)parms[26], 20);
               stmt.setVarchar(28, (String)parms[27], 400, false);
               stmt.setVarchar(29, (String)parms[28], 150, false);
               stmt.setVarchar(30, (String)parms[29], 400, false);
               stmt.setDate(31, (java.util.Date)parms[30]);
               stmt.setVarchar(32, (String)parms[31], 20, false);
               stmt.setVarchar(33, (String)parms[32], 400, false);
               stmt.setVarchar(34, (String)parms[33], 22, false);
               stmt.setString(35, (String)parms[34], 2);
               stmt.setVarchar(36, (String)parms[35], 40, false);
               stmt.setVarchar(37, (String)parms[36], 40, false);
               stmt.setVarchar(38, (String)parms[37], 400, false);
               stmt.setString(39, (String)parms[38], 20);
               stmt.setVarchar(40, (String)parms[39], 400, false);
               stmt.setNLongVarchar(41, (String)parms[40], false);
               stmt.setNLongVarchar(42, (String)parms[41], false);
               stmt.setNLongVarchar(43, (String)parms[42], false);
               stmt.setString(44, (String)parms[43], 20);
               stmt.setShort(45, ((Number) parms[44]).shortValue());
               stmt.setBoolean(46, ((Boolean) parms[45]).booleanValue());
               stmt.setString(47, (String)parms[46], 2);
               stmt.setString(48, (String)parms[47], 2);
               stmt.setString(49, (String)parms[48], 2);
               stmt.setBoolean(50, ((Boolean) parms[49]).booleanValue());
               stmt.setNLongVarchar(51, (String)parms[50], false);
               stmt.setDate(52, (java.util.Date)parms[51]);
               stmt.setBoolean(53, ((Boolean) parms[52]).booleanValue());
               stmt.setBoolean(54, ((Boolean) parms[53]).booleanValue());
               stmt.setBoolean(55, ((Boolean) parms[54]).booleanValue());
               stmt.setBoolean(56, ((Boolean) parms[55]).booleanValue());
               stmt.setBoolean(57, ((Boolean) parms[56]).booleanValue());
               stmt.setBoolean(58, ((Boolean) parms[57]).booleanValue());
               stmt.setBoolean(59, ((Boolean) parms[58]).booleanValue());
               stmt.setBoolean(60, ((Boolean) parms[59]).booleanValue());
               stmt.setBoolean(61, ((Boolean) parms[60]).booleanValue());
               stmt.setBoolean(62, ((Boolean) parms[61]).booleanValue());
               stmt.setDate(63, (java.util.Date)parms[62]);
               stmt.setNLongVarchar(64, (String)parms[63], false);
               stmt.setVarchar(65, (String)parms[64], 400, false);
               if ( ((Boolean) parms[65]).booleanValue() )
               {
                  stmt.setNull( 66 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(66, (String)parms[66], 1);
               }
               if ( ((Boolean) parms[67]).booleanValue() )
               {
                  stmt.setNull( 67 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(67, ((Number) parms[68]).shortValue());
               }
               stmt.setVarchar(68, (String)parms[69], 60, false);
               stmt.setVarchar(69, (String)parms[70], 255, false);
               stmt.setBigDecimal(70, (java.math.BigDecimal)parms[71], 1);
               stmt.setInt(71, ((Number) parms[72]).intValue());
               stmt.setShort(72, ((Number) parms[73]).shortValue());
               stmt.setInt(73, ((Number) parms[74]).intValue());
               return;
            case 12 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 14 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 15 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setVarchar(4, (String)parms[3], 40, false);
               stmt.setVarchar(5, (String)parms[4], 40, false);
               stmt.setBigDecimal(6, (java.math.BigDecimal)parms[5], 4);
               stmt.setString(7, (String)parms[6], 20);
               stmt.setString(8, (String)parms[7], 20);
               stmt.setVarchar(9, (String)parms[8], 40, false);
               stmt.setDate(10, (java.util.Date)parms[9]);
               stmt.setInt(11, ((Number) parms[10]).intValue());
               return;
            case 17 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setVarchar(2, (String)parms[1], 40, false);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[2], 4);
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 20);
               stmt.setVarchar(6, (String)parms[5], 40, false);
               stmt.setDate(7, (java.util.Date)parms[6]);
               stmt.setInt(8, ((Number) parms[7]).intValue());
               stmt.setShort(9, ((Number) parms[8]).shortValue());
               stmt.setInt(10, ((Number) parms[9]).intValue());
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               return;
            case 18 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               return;
            case 19 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 20 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

