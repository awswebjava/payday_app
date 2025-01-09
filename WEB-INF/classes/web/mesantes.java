package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class mesantes extends GXProcedure
{
   public mesantes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( mesantes.class ), "" );
   }

   public mesantes( int remoteHandle ,
                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( byte aP0 )
   {
      mesantes.this.aP1 = new byte[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( byte aP0 ,
                        byte[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( byte aP0 ,
                             byte[] aP1 )
   {
      mesantes.this.AV8mes = aP0;
      mesantes.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( AV8mes == 1 )
      {
         AV9mesAntes = (byte)(12) ;
      }
      else if ( AV8mes == 2 )
      {
         AV9mesAntes = (byte)(1) ;
      }
      else if ( AV8mes == 3 )
      {
         AV9mesAntes = (byte)(2) ;
      }
      else if ( AV8mes == 4 )
      {
         AV9mesAntes = (byte)(3) ;
      }
      else if ( AV8mes == 5 )
      {
         AV9mesAntes = (byte)(4) ;
      }
      else if ( AV8mes == 6 )
      {
         AV9mesAntes = (byte)(5) ;
      }
      else if ( AV8mes == 7 )
      {
         AV9mesAntes = (byte)(6) ;
      }
      else if ( AV8mes == 8 )
      {
         AV9mesAntes = (byte)(7) ;
      }
      else if ( AV8mes == 9 )
      {
         AV9mesAntes = (byte)(8) ;
      }
      else if ( AV8mes == 10 )
      {
         AV9mesAntes = (byte)(9) ;
      }
      else if ( AV8mes == 11 )
      {
         AV9mesAntes = (byte)(10) ;
      }
      else if ( AV8mes == 12 )
      {
         AV9mesAntes = (byte)(11) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = mesantes.this.AV9mesAntes;
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

   private byte AV8mes ;
   private byte AV9mesAntes ;
   private short Gx_err ;
   private byte[] aP1 ;
}

