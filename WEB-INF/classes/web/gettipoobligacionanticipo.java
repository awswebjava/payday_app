package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gettipoobligacionanticipo extends GXProcedure
{
   public gettipoobligacionanticipo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gettipoobligacionanticipo.class ), "" );
   }

   public gettipoobligacionanticipo( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 )
   {
      gettipoobligacionanticipo.this.aP1 = new short[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        short[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             short[] aP1 )
   {
      gettipoobligacionanticipo.this.AV9CliCod = aP0;
      gettipoobligacionanticipo.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8TipoOblSec = (short)(2) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = gettipoobligacionanticipo.this.AV8TipoOblSec;
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

   private short AV8TipoOblSec ;
   private short Gx_err ;
   private int AV9CliCod ;
   private short[] aP1 ;
}

