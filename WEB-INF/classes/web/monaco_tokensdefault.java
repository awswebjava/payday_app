package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class monaco_tokensdefault extends GXProcedure
{
   public monaco_tokensdefault( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( monaco_tokensdefault.class ), "" );
   }

   public monaco_tokensdefault( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      monaco_tokensdefault.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      monaco_tokensdefault.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8json = "[" + GXutil.newLine( ) ;
      AV8json += "  {" + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "      \"nombre\":\"numero\",", "") + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "      \"regex\":\"/[0-9.]/\",", "") + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "      \"css\":\"foreground: ", "") ;
      GXt_char1 = AV8json ;
      GXv_char2[0] = GXt_char1 ;
      new web.monacocolortokennumeros_codigoparam(remoteHandle, context).execute( GXv_char2) ;
      monaco_tokensdefault.this.GXt_char1 = GXv_char2[0] ;
      AV8json += "'" + GXutil.trim( GXt_char1) + "'" ;
      AV8json += " \"" + GXutil.newLine( ) ;
      AV8json += "   }," + GXutil.newLine( ) ;
      AV8json += "   {" + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "      \"nombre\":\"calculo\",", "") + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "      \"regex\":\"/\\(^\\\\{.*?\\\\}\\)/\",", "") + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "      \"css\":\"foreground: ", "") ;
      GXt_char1 = AV8json ;
      GXv_char2[0] = GXt_char1 ;
      new web.monacocolortokencalculos_codigoparam(remoteHandle, context).execute( GXv_char2) ;
      monaco_tokensdefault.this.GXt_char1 = GXv_char2[0] ;
      AV8json += "'" + GXutil.trim( GXt_char1) + "'" ;
      AV8json += " \"" + GXutil.newLine( ) ;
      AV8json += "   }," + GXutil.newLine( ) ;
      AV8json += "   {" + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "      \"nombre\":\"concepto\",", "") + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "      \"regex\":\"/\\(^\\\\[c\\\\s.*?\\\\]\\)/\",", "") + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "      \"css\":\"foreground: ", "") ;
      GXt_char1 = AV8json ;
      GXv_char2[0] = GXt_char1 ;
      new web.monacocolortokenconceptos_codigoparam(remoteHandle, context).execute( GXv_char2) ;
      monaco_tokensdefault.this.GXt_char1 = GXv_char2[0] ;
      AV8json += "'" + GXutil.trim( GXt_char1) + "'" ;
      AV8json += " \"" + GXutil.newLine( ) ;
      AV8json += "   }," + GXutil.newLine( ) ;
      AV8json += "{" ;
      AV8json += httpContext.getMessage( "\"nombre\":\"variables1\",", "") ;
      AV8json += httpContext.getMessage( "\"regex\":\"/\\\\[((?!c\\\\s).)+\\\\]/\",", "") ;
      AV8json += httpContext.getMessage( "      \"css\":\"foreground: ", "") ;
      GXt_char1 = AV8json ;
      GXv_char2[0] = GXt_char1 ;
      new web.monacocolortokenvariables_codigoparam(remoteHandle, context).execute( GXv_char2) ;
      monaco_tokensdefault.this.GXt_char1 = GXv_char2[0] ;
      AV8json += "'" + GXutil.trim( GXt_char1) + "'" ;
      AV8json += " \"" + GXutil.newLine( ) ;
      AV8json += "   }" + GXutil.newLine( ) ;
      AV8json += "]" ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = monaco_tokensdefault.this.AV8json;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8json = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV8json ;
   private String[] aP0 ;
}

