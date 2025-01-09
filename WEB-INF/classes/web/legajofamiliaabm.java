package web ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.legajofamiliaabm", "/web.legajofamiliaabm"})
public final  class legajofamiliaabm extends GXWebObjectStub
{
   public legajofamiliaabm( )
   {
   }

   public legajofamiliaabm( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( legajofamiliaabm.class ));
   }

   public legajofamiliaabm( int remoteHandle ,
                            ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new legajofamiliaabm_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new legajofamiliaabm_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Legajo Familia ABM";
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

