package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getpaisdeconvenio extends GXProcedure
{
   public getpaisdeconvenio( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getpaisdeconvenio.class ), "" );
   }

   public getpaisdeconvenio( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( String aP0 ,
                            short aP1 )
   {
      getpaisdeconvenio.this.aP2 = new short[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        short aP1 ,
                        short[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             short aP1 ,
                             short[] aP2 )
   {
      getpaisdeconvenio.this.AV8ConveCodigo = aP0;
      getpaisdeconvenio.this.AV11LegPaiCod = aP1;
      getpaisdeconvenio.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10PaiCod = AV11LegPaiCod ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getpaisdeconvenio.this.AV10PaiCod;
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

   private short AV11LegPaiCod ;
   private short AV10PaiCod ;
   private short Gx_err ;
   private String AV8ConveCodigo ;
   private short[] aP2 ;
}

