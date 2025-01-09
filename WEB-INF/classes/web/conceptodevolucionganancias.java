package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conceptodevolucionganancias extends GXProcedure
{
   public conceptodevolucionganancias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conceptodevolucionganancias.class ), "" );
   }

   public conceptodevolucionganancias( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 )
   {
      conceptodevolucionganancias.this.aP1 = new String[] {""};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        String[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             String[] aP1 )
   {
      conceptodevolucionganancias.this.AV8CliCod = aP0;
      conceptodevolucionganancias.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9ConCodigo = httpContext.getMessage( "DES016", "") ;
      new web.codigosfijosrevisar(remoteHandle, context).execute( ) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = conceptodevolucionganancias.this.AV9ConCodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9ConCodigo = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV8CliCod ;
   private String AV9ConCodigo ;
   private String[] aP1 ;
}

