package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class replacecomienzo extends GXProcedure
{
   public replacecomienzo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( replacecomienzo.class ), "" );
   }

   public replacecomienzo( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      replacecomienzo.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      replacecomienzo.this.AV8valor = aP0[0];
      this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8valor = GXutil.strReplace( AV8valor, "[", "") ;
      AV8valor = GXutil.strReplace( AV8valor, "{", "") ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = replacecomienzo.this.AV8valor;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8valor ;
   private String[] aP0 ;
}

