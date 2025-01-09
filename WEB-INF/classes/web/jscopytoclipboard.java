package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class jscopytoclipboard extends GXProcedure
{
   public jscopytoclipboard( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( jscopytoclipboard.class ), "" );
   }

   public jscopytoclipboard( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      jscopytoclipboard.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             String[] aP1 )
   {
      jscopytoclipboard.this.AV9variable = aP0;
      jscopytoclipboard.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8js = httpContext.getMessage( "<script>", "") ;
      AV8js += httpContext.getMessage( "console.log(\"", "") + AV9variable + "\");" ;
      AV8js += httpContext.getMessage( "var copyText = document.getElementById(\"", "") + GXutil.trim( AV9variable) + "\");" ;
      AV8js += httpContext.getMessage( "copyText.select();", "") ;
      AV8js += httpContext.getMessage( "copyText.setSelectionRange(0, 99999);", "") ;
      AV8js += httpContext.getMessage( "navigator.clipboard.writeText(copyText.value);", "") ;
      AV8js += httpContext.getMessage( "</script>", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = jscopytoclipboard.this.AV8js;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8js = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9variable ;
   private String AV8js ;
   private String[] aP1 ;
}

