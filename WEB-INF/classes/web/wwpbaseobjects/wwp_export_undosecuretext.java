package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class wwp_export_undosecuretext extends GXProcedure
{
   public wwp_export_undosecuretext( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( wwp_export_undosecuretext.class ), "" );
   }

   public wwp_export_undosecuretext( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      wwp_export_undosecuretext.this.aP1 = new String[] {""};
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
      wwp_export_undosecuretext.this.AV9Text = aP0;
      wwp_export_undosecuretext.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8UndoSecureText = GXutil.trim( AV9Text) ;
      if ( ( GXutil.len( AV8UndoSecureText) > 0 ) && ( GXutil.startsWith( AV8UndoSecureText, "'=") || GXutil.startsWith( AV8UndoSecureText, "'+") || GXutil.startsWith( AV8UndoSecureText, "'-") || GXutil.startsWith( AV8UndoSecureText, "'@") ) )
      {
         AV8UndoSecureText = GXutil.substring( AV8UndoSecureText, 2, -1) ;
      }
      if ( ( GXutil.strSearch( GXutil.upper( AV8UndoSecureText), httpContext.getMessage( "NINGUNO", ""), 1) != 0 ) || ( GXutil.strcmp(GXutil.upper( AV8UndoSecureText), httpContext.getMessage( "NADA", "")) == 0 ) || ( GXutil.strcmp(GXutil.upper( AV8UndoSecureText), "-") == 0 ) )
      {
         AV8UndoSecureText = "" ;
      }
      new web.ojoquepisawwplus(remoteHandle, context).execute( ) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = wwp_export_undosecuretext.this.AV8UndoSecureText;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8UndoSecureText = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9Text ;
   private String AV8UndoSecureText ;
   private String[] aP1 ;
}

