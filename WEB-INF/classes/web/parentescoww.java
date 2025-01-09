package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.parentescoww", "/web.parentescoww"})
public final  class parentescoww extends GXWebObjectStub
{
   public parentescoww( )
   {
   }

   public parentescoww( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( parentescoww.class ));
   }

   public parentescoww( int remoteHandle ,
                        ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new parentescoww_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new parentescoww_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return " Parentesco";
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

}

