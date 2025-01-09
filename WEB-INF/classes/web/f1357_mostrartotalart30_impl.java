package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class f1357_mostrartotalart30_impl extends GXDataArea
{
   public f1357_mostrartotalart30_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public f1357_mostrartotalart30_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( f1357_mostrartotalart30_impl.class ));
   }

   public f1357_mostrartotalart30_impl( int remoteHandle ,
                                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
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
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
         {
            httpContext.setAjaxEventMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "CliCod") ;
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
            A3CliCod = (int)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               A1EmpCod = (short)(GXutil.lval( httpContext.GetPar( "EmpCod"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
               A784F1357CTipoPre = (byte)(GXutil.lval( httpContext.GetPar( "F1357CTipoPre"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
               A777F1357CPer = httpContext.GetPar( "F1357CPer") ;
               httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
               A778F1357CSec = (byte)(GXutil.lval( httpContext.GetPar( "F1357CSec"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
               A6LegNumero = (int)(GXutil.lval( httpContext.GetPar( "LegNumero"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
               A862F1357LDPTipReg = httpContext.GetPar( "F1357LDPTipReg") ;
               httpContext.ajax_rsp_assign_attri("", false, "A862F1357LDPTipReg", A862F1357LDPTipReg);
            }
         }
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "web.wwpbaseobjects.workwithplusmasterpageprompt");
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

   public byte executeStartEvent( )
   {
      pa9U2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start9U2( ) ;
      }
      return gxajaxcallmode ;
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
      if ( nGXWrapped != 1 )
      {
         MasterPageObj.master_styles();
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
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = ((nGXWrapped==0) ? " data-HasEnter=\"false\" data-Skiponenter=\"false\"" : "") ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("web.f1357_mostrartotalart30", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A784F1357CTipoPre,1,0)),GXutil.URLEncode(GXutil.rtrim(A777F1357CPer)),GXutil.URLEncode(GXutil.ltrimstr(A778F1357CSec,2,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0)),GXutil.URLEncode(GXutil.rtrim(A862F1357LDPTipReg))}, new String[] {"CliCod","EmpCod","F1357CTipoPre","F1357CPer","F1357CSec","LegNumero","F1357LDPTipReg"}) +"\">") ;
         web.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
         web.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
         httpContext.writeText( "<input type=\"submit\" title=\"submit\" style=\"display:block;height:0;border:0;padding:0\" disabled>") ;
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      }
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
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
      web.GxWebStd.gx_hidden_field( httpContext, "CLICOD", GXutil.ltrim( localUtil.ntoc( A3CliCod, (byte)(6), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "EMPCOD", GXutil.ltrim( localUtil.ntoc( A1EmpCod, (byte)(4), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "F1357CTIPOPRE", GXutil.ltrim( localUtil.ntoc( A784F1357CTipoPre, (byte)(1), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "F1357CPER", GXutil.rtrim( A777F1357CPer));
      web.GxWebStd.gx_hidden_field( httpContext, "F1357CSEC", GXutil.ltrim( localUtil.ntoc( A778F1357CSec, (byte)(2), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "LEGNUMERO", GXutil.ltrim( localUtil.ntoc( A6LegNumero, (byte)(8), (byte)(0), httpContext.getLanguageProperty( "decimal_point"), "")));
      web.GxWebStd.gx_hidden_field( httpContext, "F1357LDPTIPREG", GXutil.rtrim( A862F1357LDPTipReg));
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
      if ( nGXWrapped != 1 )
      {
         httpContext.writeTextNL( "</form>") ;
      }
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

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         web.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we9U2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt9U2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return false ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("web.f1357_mostrartotalart30", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A3CliCod,6,0)),GXutil.URLEncode(GXutil.ltrimstr(A1EmpCod,4,0)),GXutil.URLEncode(GXutil.ltrimstr(A784F1357CTipoPre,1,0)),GXutil.URLEncode(GXutil.rtrim(A777F1357CPer)),GXutil.URLEncode(GXutil.ltrimstr(A778F1357CSec,2,0)),GXutil.URLEncode(GXutil.ltrimstr(A6LegNumero,8,0)),GXutil.URLEncode(GXutil.rtrim(A862F1357LDPTipReg))}, new String[] {"CliCod","EmpCod","F1357CTipoPre","F1357CPer","F1357CSec","LegNumero","F1357LDPTipReg"})  ;
   }

   public String getPgmname( )
   {
      return "F1357_MostrarTotalArt30" ;
   }

   public String getPgmdesc( )
   {
      return httpContext.getMessage( "Composición de total deducciones art. 30", "") ;
   }

   public void wb9U0( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( nGXWrapped == 1 )
         {
            renderHtmlHeaders( ) ;
            renderHtmlOpenForm( ) ;
         }
         web.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", "", "false");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"bootstrapv3\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divLayoutmaintable_Internalname, 1, 0, "px", 0, "px", divLayoutmaintable_Class, "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTablemain_Internalname, 1, 0, "px", 0, "px", "TableMainPopover", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, divTableattributes_Internalname, 1, 0, "px", 0, "px", "", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPGNI_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtF1357LDPGNI_Internalname, httpContext.getMessage( "GANANCIA NO IMPONIBLE", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPGNI_Internalname, GXutil.ltrim( localUtil.ntoc( A827F1357LDPGNI, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPGNI_Enabled!=0) ? localUtil.format( A827F1357LDPGNI, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A827F1357LDPGNI, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPGNI_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPGNI_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357_MostrarTotalArt30.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPEspecial_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtF1357LDPEspecial_Internalname, httpContext.getMessage( "DEDUCCION ESPECIAL", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPEspecial_Internalname, GXutil.ltrim( localUtil.ntoc( A828F1357LDPEspecial, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPEspecial_Enabled!=0) ? localUtil.format( A828F1357LDPEspecial, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A828F1357LDPEspecial, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPEspecial_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPEspecial_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357_MostrarTotalArt30.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPEspecifica_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtF1357LDPEspecifica_Internalname, httpContext.getMessage( "DEDUCCIÓN ESPECÍFICA", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPEspecifica_Internalname, GXutil.ltrim( localUtil.ntoc( A829F1357LDPEspecifica, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPEspecifica_Enabled!=0) ? localUtil.format( A829F1357LDPEspecifica, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A829F1357LDPEspecifica, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPEspecifica_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPEspecifica_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357_MostrarTotalArt30.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPEspIncremen1_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtF1357LDPEspIncremen1_Internalname, httpContext.getMessage( "Deducción Especial Incrementada Primera parte del penúltimo párrafo del inciso c) del artículo 30 de la ley del gravamen", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPEspIncremen1_Internalname, GXutil.ltrim( localUtil.ntoc( A841F1357LDPEspIncremen1, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPEspIncremen1_Enabled!=0) ? localUtil.format( A841F1357LDPEspIncremen1, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A841F1357LDPEspIncremen1, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPEspIncremen1_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPEspIncremen1_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357_MostrarTotalArt30.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPEspIncremen2_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtF1357LDPEspIncremen2_Internalname, httpContext.getMessage( "Deducción Especial Incrementada Segunda parte del penúltimo párrafo del inciso c) del artículo 30 de la ley del gravamen", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPEspIncremen2_Internalname, GXutil.ltrim( localUtil.ntoc( A842F1357LDPEspIncremen2, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPEspIncremen2_Enabled!=0) ? localUtil.format( A842F1357LDPEspIncremen2, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A842F1357LDPEspIncremen2, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPEspIncremen2_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPEspIncremen2_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357_MostrarTotalArt30.htm");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6 DataContentCell DscTop", "left", "top", "", "", "div");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtF1357LDPTotalFami_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         web.GxWebStd.gx_label_element( httpContext, edtF1357LDPTotalFami_Internalname, httpContext.getMessage( "TOTAL DE CARGAS DE FAMILIA", ""), " AttributeLabel", 1, true, "");
         /* Div Control */
         web.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         web.GxWebStd.gx_single_line_edit( httpContext, edtF1357LDPTotalFami_Internalname, GXutil.ltrim( localUtil.ntoc( A833F1357LDPTotalFami, (byte)(20), (byte)(2), httpContext.getLanguageProperty( "decimal_point"), "")), GXutil.ltrim( ((edtF1357LDPTotalFami_Enabled!=0) ? localUtil.format( A833F1357LDPTotalFami, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99") : localUtil.format( A833F1357LDPTotalFami, "Z,ZZZ,ZZZ,ZZZ,ZZ9.99"))), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtF1357LDPTotalFami_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtF1357LDPTotalFami_Enabled, 0, "text", "", 20, "chr", 1, "row", 20, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Importes16_2", "right", false, "", "HLP_F1357_MostrarTotalArt30.htm");
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
         web.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start9U2( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 17_0_11-163677", (short)(0)) ;
         }
         Form.getMeta().addItem("description", httpContext.getMessage( "Composición de total deducciones art. 30", ""), (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup9U0( ) ;
   }

   public void ws9U2( )
   {
      start9U2( ) ;
      evt9U2( ) ;
   }

   public void evt9U2( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
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
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e119U2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e129U2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              Rfr0gs = false ;
                              if ( ! Rfr0gs )
                              {
                              }
                              dynload_actions( ) ;
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we9U2( )
   {
      if ( ! web.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! web.GxWebStd.gx_redirect( httpContext) )
         {
            if ( nGXWrapped == 1 )
            {
               renderHtmlCloseForm( ) ;
            }
         }
      }
   }

   public void pa9U2( )
   {
      if ( nDonePA == 0 )
      {
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
         if ( ! httpContext.isAjaxRequest( ) )
         {
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
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
      rf9U2( ) ;
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

   public void rf9U2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H009U2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A862F1357LDPTipReg});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A833F1357LDPTotalFami = H009U2_A833F1357LDPTotalFami[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A833F1357LDPTotalFami", GXutil.ltrimstr( A833F1357LDPTotalFami, 16, 2));
            A842F1357LDPEspIncremen2 = H009U2_A842F1357LDPEspIncremen2[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A842F1357LDPEspIncremen2", GXutil.ltrimstr( A842F1357LDPEspIncremen2, 16, 2));
            A841F1357LDPEspIncremen1 = H009U2_A841F1357LDPEspIncremen1[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A841F1357LDPEspIncremen1", GXutil.ltrimstr( A841F1357LDPEspIncremen1, 16, 2));
            A829F1357LDPEspecifica = H009U2_A829F1357LDPEspecifica[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A829F1357LDPEspecifica", GXutil.ltrimstr( A829F1357LDPEspecifica, 16, 2));
            A828F1357LDPEspecial = H009U2_A828F1357LDPEspecial[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A828F1357LDPEspecial", GXutil.ltrimstr( A828F1357LDPEspecial, 16, 2));
            A827F1357LDPGNI = H009U2_A827F1357LDPGNI[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A827F1357LDPGNI", GXutil.ltrimstr( A827F1357LDPGNI, 16, 2));
            /* Execute user event: Load */
            e129U2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb9U0( ) ;
      }
   }

   public void send_integrity_lvl_hashes9U2( )
   {
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup9U0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e119U2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         /* Read variables values. */
         A827F1357LDPGNI = localUtil.ctond( httpContext.cgiGet( edtF1357LDPGNI_Internalname)) ;
         httpContext.ajax_rsp_assign_attri("", false, "A827F1357LDPGNI", GXutil.ltrimstr( A827F1357LDPGNI, 16, 2));
         A828F1357LDPEspecial = localUtil.ctond( httpContext.cgiGet( edtF1357LDPEspecial_Internalname)) ;
         httpContext.ajax_rsp_assign_attri("", false, "A828F1357LDPEspecial", GXutil.ltrimstr( A828F1357LDPEspecial, 16, 2));
         A829F1357LDPEspecifica = localUtil.ctond( httpContext.cgiGet( edtF1357LDPEspecifica_Internalname)) ;
         httpContext.ajax_rsp_assign_attri("", false, "A829F1357LDPEspecifica", GXutil.ltrimstr( A829F1357LDPEspecifica, 16, 2));
         A841F1357LDPEspIncremen1 = localUtil.ctond( httpContext.cgiGet( edtF1357LDPEspIncremen1_Internalname)) ;
         httpContext.ajax_rsp_assign_attri("", false, "A841F1357LDPEspIncremen1", GXutil.ltrimstr( A841F1357LDPEspIncremen1, 16, 2));
         A842F1357LDPEspIncremen2 = localUtil.ctond( httpContext.cgiGet( edtF1357LDPEspIncremen2_Internalname)) ;
         httpContext.ajax_rsp_assign_attri("", false, "A842F1357LDPEspIncremen2", GXutil.ltrimstr( A842F1357LDPEspIncremen2, 16, 2));
         A833F1357LDPTotalFami = localUtil.ctond( httpContext.cgiGet( edtF1357LDPTotalFami_Internalname)) ;
         httpContext.ajax_rsp_assign_attri("", false, "A833F1357LDPTotalFami", GXutil.ltrimstr( A833F1357LDPTotalFami, 16, 2));
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e119U2 ();
      if (returnInSub) return;
   }

   public void e119U2( )
   {
      /* Start Routine */
      returnInSub = false ;
      divLayoutmaintable_Class = divLayoutmaintable_Class+" "+"EditForm" ;
      httpContext.ajax_rsp_assign_prop("", false, divLayoutmaintable_Internalname, "Class", divLayoutmaintable_Class, true);
   }

   protected void nextLoad( )
   {
   }

   protected void e129U2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A3CliCod = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CliCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CliCod), 6, 0));
      A1EmpCod = ((Number) GXutil.testNumericType( getParm(obj,1), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "A1EmpCod", GXutil.ltrimstr( DecimalUtil.doubleToDec(A1EmpCod), 4, 0));
      A784F1357CTipoPre = ((Number) GXutil.testNumericType( getParm(obj,2), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "A784F1357CTipoPre", GXutil.str( A784F1357CTipoPre, 1, 0));
      A777F1357CPer = (String)getParm(obj,3) ;
      httpContext.ajax_rsp_assign_attri("", false, "A777F1357CPer", A777F1357CPer);
      A778F1357CSec = ((Number) GXutil.testNumericType( getParm(obj,4), TypeConstants.BYTE)).byteValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "A778F1357CSec", GXutil.ltrimstr( DecimalUtil.doubleToDec(A778F1357CSec), 2, 0));
      A6LegNumero = ((Number) GXutil.testNumericType( getParm(obj,5), TypeConstants.INT)).intValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "A6LegNumero", GXutil.ltrimstr( DecimalUtil.doubleToDec(A6LegNumero), 8, 0));
      A862F1357LDPTipReg = (String)getParm(obj,6) ;
      httpContext.ajax_rsp_assign_attri("", false, "A862F1357LDPTipReg", A862F1357LDPTipReg);
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
      pa9U2( ) ;
      ws9U2( ) ;
      we9U2( ) ;
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
      httpContext.setWrapped(false);
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

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202412202054758", true, true);
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
         httpContext.AddJavascriptSource("messages."+httpContext.getLanguageProperty( "code")+".js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
         httpContext.AddJavascriptSource("gxdec.js", "?"+httpContext.getBuildNumber( 214800), false, true);
         httpContext.AddJavascriptSource("f1357_mostrartotalart30.js", "?202412202054759", false, true);
      }
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtF1357LDPGNI_Internalname = "F1357LDPGNI" ;
      edtF1357LDPEspecial_Internalname = "F1357LDPESPECIAL" ;
      edtF1357LDPEspecifica_Internalname = "F1357LDPESPECIFICA" ;
      edtF1357LDPEspIncremen1_Internalname = "F1357LDPESPINCREMEN1" ;
      edtF1357LDPEspIncremen2_Internalname = "F1357LDPESPINCREMEN2" ;
      edtF1357LDPTotalFami_Internalname = "F1357LDPTOTALFAMI" ;
      divTableattributes_Internalname = "TABLEATTRIBUTES" ;
      divTablemain_Internalname = "TABLEMAIN" ;
      divLayoutmaintable_Internalname = "LAYOUTMAINTABLE" ;
      Form.setInternalname( "FORM" );
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
      edtF1357LDPTotalFami_Jsonclick = "" ;
      edtF1357LDPTotalFami_Enabled = 0 ;
      edtF1357LDPEspIncremen2_Jsonclick = "" ;
      edtF1357LDPEspIncremen2_Enabled = 0 ;
      edtF1357LDPEspIncremen1_Jsonclick = "" ;
      edtF1357LDPEspIncremen1_Enabled = 0 ;
      edtF1357LDPEspecifica_Jsonclick = "" ;
      edtF1357LDPEspecifica_Enabled = 0 ;
      edtF1357LDPEspecial_Jsonclick = "" ;
      edtF1357LDPEspecial_Enabled = 0 ;
      edtF1357LDPGNI_Jsonclick = "" ;
      edtF1357LDPGNI_Enabled = 0 ;
      divLayoutmaintable_Class = "Table TableTransactionTemplate" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( httpContext.getMessage( "Composición de total deducciones art. 30", "") );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A3CliCod',fld:'CLICOD',pic:'ZZZZZ9'},{av:'A1EmpCod',fld:'EMPCOD',pic:'ZZZ9'},{av:'A784F1357CTipoPre',fld:'F1357CTIPOPRE',pic:'9'},{av:'A777F1357CPer',fld:'F1357CPER',pic:''},{av:'A778F1357CSec',fld:'F1357CSEC',pic:'Z9'},{av:'A6LegNumero',fld:'LEGNUMERO',pic:'ZZZZZZZ9'},{av:'A862F1357LDPTipReg',fld:'F1357LDPTIPREG',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
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
      wcpOA777F1357CPer = "" ;
      wcpOA862F1357LDPTipReg = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      A777F1357CPer = "" ;
      A862F1357LDPTipReg = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      A827F1357LDPGNI = DecimalUtil.ZERO ;
      A828F1357LDPEspecial = DecimalUtil.ZERO ;
      A829F1357LDPEspecifica = DecimalUtil.ZERO ;
      A841F1357LDPEspIncremen1 = DecimalUtil.ZERO ;
      A842F1357LDPEspIncremen2 = DecimalUtil.ZERO ;
      A833F1357LDPTotalFami = DecimalUtil.ZERO ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      scmdbuf = "" ;
      H009U2_A3CliCod = new int[1] ;
      H009U2_A1EmpCod = new short[1] ;
      H009U2_A784F1357CTipoPre = new byte[1] ;
      H009U2_A777F1357CPer = new String[] {""} ;
      H009U2_A778F1357CSec = new byte[1] ;
      H009U2_A6LegNumero = new int[1] ;
      H009U2_A862F1357LDPTipReg = new String[] {""} ;
      H009U2_A833F1357LDPTotalFami = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009U2_A842F1357LDPEspIncremen2 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009U2_A841F1357LDPEspIncremen1 = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009U2_A829F1357LDPEspecifica = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009U2_A828F1357LDPEspecial = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      H009U2_A827F1357LDPGNI = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new web.f1357_mostrartotalart30__default(),
         new Object[] {
             new Object[] {
            H009U2_A3CliCod, H009U2_A1EmpCod, H009U2_A784F1357CTipoPre, H009U2_A777F1357CPer, H009U2_A778F1357CSec, H009U2_A6LegNumero, H009U2_A862F1357LDPTipReg, H009U2_A833F1357LDPTotalFami, H009U2_A842F1357LDPEspIncremen2, H009U2_A841F1357LDPEspIncremen1,
            H009U2_A829F1357LDPEspecifica, H009U2_A828F1357LDPEspecial, H009U2_A827F1357LDPGNI
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte wcpOA784F1357CTipoPre ;
   private byte wcpOA778F1357CSec ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte A784F1357CTipoPre ;
   private byte A778F1357CSec ;
   private byte gxajaxcallmode ;
   private byte nGXWrapped ;
   private byte nDonePA ;
   private short wcpOA1EmpCod ;
   private short A1EmpCod ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int wcpOA3CliCod ;
   private int wcpOA6LegNumero ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int edtF1357LDPGNI_Enabled ;
   private int edtF1357LDPEspecial_Enabled ;
   private int edtF1357LDPEspecifica_Enabled ;
   private int edtF1357LDPEspIncremen1_Enabled ;
   private int edtF1357LDPEspIncremen2_Enabled ;
   private int edtF1357LDPTotalFami_Enabled ;
   private int idxLst ;
   private java.math.BigDecimal A827F1357LDPGNI ;
   private java.math.BigDecimal A828F1357LDPEspecial ;
   private java.math.BigDecimal A829F1357LDPEspecifica ;
   private java.math.BigDecimal A841F1357LDPEspIncremen1 ;
   private java.math.BigDecimal A842F1357LDPEspIncremen2 ;
   private java.math.BigDecimal A833F1357LDPTotalFami ;
   private String wcpOA777F1357CPer ;
   private String wcpOA862F1357LDPTipReg ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String A777F1357CPer ;
   private String A862F1357LDPTipReg ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divLayoutmaintable_Internalname ;
   private String divLayoutmaintable_Class ;
   private String divTablemain_Internalname ;
   private String divTableattributes_Internalname ;
   private String edtF1357LDPGNI_Internalname ;
   private String edtF1357LDPGNI_Jsonclick ;
   private String edtF1357LDPEspecial_Internalname ;
   private String edtF1357LDPEspecial_Jsonclick ;
   private String edtF1357LDPEspecifica_Internalname ;
   private String edtF1357LDPEspecifica_Jsonclick ;
   private String edtF1357LDPEspIncremen1_Internalname ;
   private String edtF1357LDPEspIncremen1_Jsonclick ;
   private String edtF1357LDPEspIncremen2_Internalname ;
   private String edtF1357LDPEspIncremen2_Jsonclick ;
   private String edtF1357LDPTotalFami_Internalname ;
   private String edtF1357LDPTotalFami_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String scmdbuf ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private IDataStoreProvider pr_default ;
   private int[] H009U2_A3CliCod ;
   private short[] H009U2_A1EmpCod ;
   private byte[] H009U2_A784F1357CTipoPre ;
   private String[] H009U2_A777F1357CPer ;
   private byte[] H009U2_A778F1357CSec ;
   private int[] H009U2_A6LegNumero ;
   private String[] H009U2_A862F1357LDPTipReg ;
   private java.math.BigDecimal[] H009U2_A833F1357LDPTotalFami ;
   private java.math.BigDecimal[] H009U2_A842F1357LDPEspIncremen2 ;
   private java.math.BigDecimal[] H009U2_A841F1357LDPEspIncremen1 ;
   private java.math.BigDecimal[] H009U2_A829F1357LDPEspecifica ;
   private java.math.BigDecimal[] H009U2_A828F1357LDPEspecial ;
   private java.math.BigDecimal[] H009U2_A827F1357LDPGNI ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class f1357_mostrartotalart30__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H009U2", "SELECT CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDPTipReg, F1357LDPTotalFami, F1357LDPEspIncremen2, F1357LDPEspIncremen1, F1357LDPEspecifica, F1357LDPEspecial, F1357LDPGNI FROM F1357LDedPer WHERE CliCod = ? and EmpCod = ? and F1357CTipoPre = ? and F1357CPer = ( ?) and F1357CSec = ? and LegNumero = ? and F1357LDPTipReg = ( ?) ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDPTipReg ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 6);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((String[]) buf[6])[0] = rslt.getString(7, 2);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(11,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(12,2);
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(13,2);
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
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 2);
               return;
      }
   }

}

