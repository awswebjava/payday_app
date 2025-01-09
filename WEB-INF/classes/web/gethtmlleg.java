package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gethtmlleg extends GXProcedure
{
   public gethtmlleg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gethtmlleg.class ), "" );
   }

   public gethtmlleg( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 )
   {
      gethtmlleg.this.aP3 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String[] aP3 )
   {
      gethtmlleg.this.AV9CliCod = aP0;
      gethtmlleg.this.AV10EmpCod = aP1;
      gethtmlleg.this.AV11LegNumero = aP2;
      gethtmlleg.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV12LegFotoNom ;
      GXv_char2[0] = AV15LegNombre ;
      GXv_char3[0] = AV16LegApellido ;
      GXv_char4[0] = AV17LegNomApe ;
      new web.getlegfotonomyape(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LegNumero, GXv_char1, GXv_char2, GXv_char3, GXv_char4) ;
      gethtmlleg.this.AV12LegFotoNom = GXv_char1[0] ;
      gethtmlleg.this.AV15LegNombre = GXv_char2[0] ;
      gethtmlleg.this.AV16LegApellido = GXv_char3[0] ;
      gethtmlleg.this.AV17LegNomApe = GXv_char4[0] ;
      GXv_char4[0] = AV13urlFoto ;
      new web.devuelveurlfoto(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LegNumero, httpContext.getMessage( "legajo", ""), GXutil.trim( AV12LegFotoNom), GXv_char4) ;
      gethtmlleg.this.AV13urlFoto = GXv_char4[0] ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV9CliCod, AV21Pgmname, httpContext.getMessage( "urlfoto ", "")+GXutil.trim( AV13urlFoto)+httpContext.getMessage( " leg ", "")+GXutil.trim( GXutil.str( AV11LegNumero, 8, 0))) ;
      GXt_char5 = AV18palabra ;
      GXv_char4[0] = GXt_char5 ;
      new web.getclasificacionlegtxt(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV11LegNumero, GXv_char4) ;
      gethtmlleg.this.GXt_char5 = GXv_char4[0] ;
      AV18palabra = GXt_char5 ;
      AV8html = httpContext.getMessage( "<div id=\"PERSONCOLUMN1_TABLEPERSONCOLUMNCONTAINER\" class=\"Flex\" data-gx-flex=\"\">", "") ;
      AV8html += httpContext.getMessage( "<div style=\"align-self:center;\">", "") ;
      if ( (GXutil.strcmp("", AV13urlFoto)==0) )
      {
         AV8html += httpContext.getMessage( "<span class=\"BadgeName\" ", "") ;
         GXt_char5 = AV14inicialesPalabra ;
         GXv_char4[0] = GXt_char5 ;
         new web.getinicialesleg(remoteHandle, context).execute( AV15LegNombre, AV16LegApellido, GXv_char4) ;
         gethtmlleg.this.GXt_char5 = GXv_char4[0] ;
         AV14inicialesPalabra = GXt_char5 ;
         AV8html += ">" + GXutil.trim( AV14inicialesPalabra) + httpContext.getMessage( "</span>", "") ;
      }
      else
      {
         AV8html += httpContext.getMessage( "<img src=\"", "") + GXutil.trim( AV13urlFoto) + "\"" ;
         AV8html += httpContext.getMessage( " alt=\"\" class=\"avatarLegajo  gx-disabled\">", "") ;
      }
      AV8html += httpContext.getMessage( "</div>", "") ;
      AV8html += httpContext.getMessage( "<div style=\"flex-grow:1;\">", "") ;
      AV8html += httpContext.getMessage( "<div ", "") ;
      AV8html += httpContext.getMessage( "class=\"Flex\" style=\"flex-direction:column;\" data-gx-flex=\"\">", "") ;
      AV8html += httpContext.getMessage( "<div style=\"flex-grow:1;\">", "") ;
      AV8html += httpContext.getMessage( "<span class=\"TextPerson\" id=\"PERSONCOLUMN1_TEXTPERSON\">", "") ;
      AV8html += GXutil.trim( AV17LegNomApe) ;
      AV8html += httpContext.getMessage( "</span>", "") ;
      AV8html += httpContext.getMessage( "</div>", "") ;
      AV8html += httpContext.getMessage( "<div style=\"flex-grow:1;\">", "") ;
      AV8html += httpContext.getMessage( "<span class=\"TextRol\" ", "") ;
      AV8html += ">" + GXutil.trim( AV18palabra) ;
      AV8html += httpContext.getMessage( "</span>", "") ;
      AV8html += httpContext.getMessage( "</div>", "") ;
      AV8html += httpContext.getMessage( "</div>", "") ;
      AV8html += httpContext.getMessage( "</div>", "") ;
      AV8html += httpContext.getMessage( "</div>", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = gethtmlleg.this.AV8html;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8html = "" ;
      AV12LegFotoNom = "" ;
      GXv_char1 = new String[1] ;
      AV15LegNombre = "" ;
      GXv_char2 = new String[1] ;
      AV16LegApellido = "" ;
      GXv_char3 = new String[1] ;
      AV17LegNomApe = "" ;
      AV13urlFoto = "" ;
      AV21Pgmname = "" ;
      AV18palabra = "" ;
      AV14inicialesPalabra = "" ;
      GXt_char5 = "" ;
      GXv_char4 = new String[1] ;
      AV21Pgmname = "getHtmlLeg" ;
      /* GeneXus formulas. */
      AV21Pgmname = "getHtmlLeg" ;
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV11LegNumero ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private String GXv_char3[] ;
   private String AV21Pgmname ;
   private String AV18palabra ;
   private String AV14inicialesPalabra ;
   private String GXt_char5 ;
   private String GXv_char4[] ;
   private String AV8html ;
   private String AV12LegFotoNom ;
   private String AV15LegNombre ;
   private String AV16LegApellido ;
   private String AV17LegNomApe ;
   private String AV13urlFoto ;
   private String[] aP3 ;
}

