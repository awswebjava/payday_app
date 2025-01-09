package web.wwpbaseobjects ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettextvariablenoidentificada extends GXProcedure
{
   public gettextvariablenoidentificada( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettextvariablenoidentificada.class ), "" );
   }

   public gettextvariablenoidentificada( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 )
   {
      gettextvariablenoidentificada.this.aP1 = new String[] {""};
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
      gettextvariablenoidentificada.this.AV9palabra = aP0;
      gettextvariablenoidentificada.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8texto = httpContext.getMessage( "Variable no identificada ", "") ;
      if ( ! (GXutil.strcmp("", AV9palabra)==0) )
      {
         AV8texto += "\"" + GXutil.trim( AV9palabra) + "\"" ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = gettextvariablenoidentificada.this.AV8texto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8texto = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV9palabra ;
   private String AV8texto ;
   private String[] aP1 ;
}

