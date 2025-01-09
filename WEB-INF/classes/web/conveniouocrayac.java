package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class conveniouocrayac extends GXProcedure
{
   public conveniouocrayac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( conveniouocrayac.class ), "" );
   }

   public conveniouocrayac( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( )
   {
      conveniouocrayac.this.aP0 = new String[] {""};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( String[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( String[] aP0 )
   {
      conveniouocrayac.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8Convecodigo = "545/08" ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = conveniouocrayac.this.AV8Convecodigo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Convecodigo = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private String AV8Convecodigo ;
   private String[] aP0 ;
}

