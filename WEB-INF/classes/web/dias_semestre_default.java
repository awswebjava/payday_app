package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class dias_semestre_default extends GXProcedure
{
   public dias_semestre_default( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( dias_semestre_default.class ), "" );
   }

   public dias_semestre_default( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 )
   {
      dias_semestre_default.this.aP1 = new short[] {0};
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
      dias_semestre_default.this.AV9CliCod = aP0;
      dias_semestre_default.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8dias = (short)(180) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = dias_semestre_default.this.AV8dias;
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

   private short AV8dias ;
   private short Gx_err ;
   private int AV9CliCod ;
   private short[] aP1 ;
}

