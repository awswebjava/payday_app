package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class jsmonacobracketsdefault extends GXProcedure
{
   public jsmonacobracketsdefault( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( jsmonacobracketsdefault.class ), "" );
   }

   public jsmonacobracketsdefault( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      jsmonacobracketsdefault.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      jsmonacobracketsdefault.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8json = "{" + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "   \"surroundingPairs\":[", "") + GXutil.newLine( ) ;
      AV8json += "      {" + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "         \"open\":\"{\",", "") + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "         \"close\":\"}\"", "") + GXutil.newLine( ) ;
      AV8json += "      }," + GXutil.newLine( ) ;
      AV8json += "      {" + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "         \"open\":\"[\",", "") + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "         \"close\":\"]\"", "") + GXutil.newLine( ) ;
      AV8json += "      }," + GXutil.newLine( ) ;
      AV8json += "      {" + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "         \"open\":\"(\",", "") + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "         \"close\":\")\"", "") + GXutil.newLine( ) ;
      AV8json += "      }" + GXutil.newLine( ) ;
      AV8json += "   ]," + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "   \"autoClosingPairs\":[", "") + GXutil.newLine( ) ;
      AV8json += "      {" + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "         \"open\":\"{\",", "") + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "         \"close\":\"}\"", "") + GXutil.newLine( ) ;
      AV8json += "      }," + GXutil.newLine( ) ;
      AV8json += "      {" + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "         \"open\":\"(\",", "") + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "         \"close\":\")\"", "") + GXutil.newLine( ) ;
      AV8json += "      }" + GXutil.newLine( ) ;
      AV8json += "   ]," + GXutil.newLine( ) ;
      AV8json += httpContext.getMessage( "   \"brackets\":[", "") + GXutil.newLine( ) ;
      AV8json += "      [" + GXutil.newLine( ) ;
      AV8json += "         \"{\"," + GXutil.newLine( ) ;
      AV8json += "         \"}\"" + GXutil.newLine( ) ;
      AV8json += "      ]," + GXutil.newLine( ) ;
      AV8json += "      [" + GXutil.newLine( ) ;
      AV8json += "         \"[\"," + GXutil.newLine( ) ;
      AV8json += "         \"]\"" + GXutil.newLine( ) ;
      AV8json += "      ]," + GXutil.newLine( ) ;
      AV8json += "      [" + GXutil.newLine( ) ;
      AV8json += "         \"(\"," + GXutil.newLine( ) ;
      AV8json += "         \")\"" + GXutil.newLine( ) ;
      AV8json += "      ]" + GXutil.newLine( ) ;
      AV8json += "   ]" + GXutil.newLine( ) ;
      AV8json += "}" ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = jsmonacobracketsdefault.this.AV8json;
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
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8json ;
   private String[] aP0 ;
}

