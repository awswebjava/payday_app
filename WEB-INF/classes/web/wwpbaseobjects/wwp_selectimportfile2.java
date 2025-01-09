package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.wwp_selectimportfile2", "/web.wwpbaseobjects.wwp_selectimportfile2"})
public final  class wwp_selectimportfile2 extends GXWebObjectStub
{
   public wwp_selectimportfile2( )
   {
   }

   public wwp_selectimportfile2( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_selectimportfile2.class ));
   }

   public wwp_selectimportfile2( int remoteHandle ,
                                 ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_selectimportfile2_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_selectimportfile2_impl(context).cleanup();
   }

   public String getServletInfo( )
   {
      return "Importar archivo";
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

