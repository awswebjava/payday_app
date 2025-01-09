package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class iniesquematarifariodefault extends GXProcedure
{
   public iniesquematarifariodefault( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( iniesquematarifariodefault.class ), "" );
   }

   public iniesquematarifariodefault( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             short aP1 )
   {
      iniesquematarifariodefault.this.AV8CliCod = aP0;
      iniesquematarifariodefault.this.AV11PaiCod = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = AV10CliConvenio ;
      new web.newesquematarifario(remoteHandle, context).execute( AV8CliCod, AV11PaiCod, httpContext.getMessage( "Esquema default", ""), GXv_char1) ;
      iniesquematarifariodefault.this.AV10CliConvenio = GXv_char1[0] ;
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10CliConvenio = "" ;
      GXv_char1 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11PaiCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private String AV10CliConvenio ;
   private String GXv_char1[] ;
}

