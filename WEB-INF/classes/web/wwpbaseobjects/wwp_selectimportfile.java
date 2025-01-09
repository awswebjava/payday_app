package web.wwpbaseobjects ;
import web.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

@javax.servlet.annotation.WebServlet(urlPatterns = {"/servlet/web.wwpbaseobjects.wwp_selectimportfile", "/web.wwpbaseobjects.wwp_selectimportfile"})
public final  class wwp_selectimportfile extends GXWebObjectStub
{
   public wwp_selectimportfile( )
   {
   }

   public wwp_selectimportfile( int remoteHandle )
   {
      super(remoteHandle, new ModelContext( wwp_selectimportfile.class ));
   }

   public wwp_selectimportfile( int remoteHandle ,
                                ModelContext context )
   {
      super(remoteHandle, context);
   }

   protected void doExecute( com.genexus.internet.HttpContext context ) throws Exception
   {
      new wwp_selectimportfile_impl(context).doExecute();
   }

   protected void init( com.genexus.internet.HttpContext context )
   {
      new wwp_selectimportfile_impl(context).cleanup();
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

