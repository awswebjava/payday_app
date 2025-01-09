package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getnextreplicanro extends GXProcedure
{
   public getnextreplicanro( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getnextreplicanro.class ), "" );
   }

   public getnextreplicanro( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( GXSimpleCollection<Short> aP0 ,
                            short[] aP1 )
   {
      getnextreplicanro.this.aP2 = new short[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( GXSimpleCollection<Short> aP0 ,
                        short[] aP1 ,
                        short[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( GXSimpleCollection<Short> aP0 ,
                             short[] aP1 ,
                             short[] aP2 )
   {
      getnextreplicanro.this.AV8replicas = aP0;
      getnextreplicanro.this.AV9i = aP1[0];
      this.aP1 = aP1;
      getnextreplicanro.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( AV9i < AV8replicas.size() )
      {
         AV9i = (short)(AV9i+1) ;
      }
      else
      {
         AV9i = (short)(0) ;
      }
      if ( AV9i == 0 )
      {
         AV10replicaNro = (short)(0) ;
      }
      else
      {
         AV10replicaNro = ((Number) AV8replicas.elementAt(-1+AV9i)).shortValue() ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getnextreplicanro.this.AV9i;
      this.aP2[0] = getnextreplicanro.this.AV10replicaNro;
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

   private short AV9i ;
   private short AV10replicaNro ;
   private short Gx_err ;
   private GXSimpleCollection<Short> AV8replicas ;
   private short[] aP2 ;
   private short[] aP1 ;
}

