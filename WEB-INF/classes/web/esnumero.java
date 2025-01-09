package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class esnumero extends GXProcedure
{
   public esnumero( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( esnumero.class ), "" );
   }

   public esnumero( int remoteHandle ,
                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( String aP0 )
   {
      esnumero.this.aP1 = new boolean[] {false};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        boolean[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             boolean[] aP1 )
   {
      esnumero.this.AV8palabra = aP0;
      esnumero.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV9d = (short)(1) ;
      AV10esNumero = true ;
      if ( GXutil.len( AV8palabra) > 0 )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         while ( AV9d <= GXutil.len( AV8palabra) )
         {
            if ( ( GXutil.strcmp(GXutil.substring( AV8palabra, AV9d, 1), "0") != 0 ) && ( GXutil.strcmp(GXutil.substring( AV8palabra, AV9d, 1), "1") != 0 ) && ( GXutil.strcmp(GXutil.substring( AV8palabra, AV9d, 1), "2") != 0 ) && ( GXutil.strcmp(GXutil.substring( AV8palabra, AV9d, 1), "3") != 0 ) && ( GXutil.strcmp(GXutil.substring( AV8palabra, AV9d, 1), "4") != 0 ) && ( GXutil.strcmp(GXutil.substring( AV8palabra, AV9d, 1), "5") != 0 ) && ( GXutil.strcmp(GXutil.substring( AV8palabra, AV9d, 1), "6") != 0 ) && ( GXutil.strcmp(GXutil.substring( AV8palabra, AV9d, 1), "7") != 0 ) && ( GXutil.strcmp(GXutil.substring( AV8palabra, AV9d, 1), "8") != 0 ) && ( GXutil.strcmp(GXutil.substring( AV8palabra, AV9d, 1), "9") != 0 ) )
            {
               AV10esNumero = false ;
               if (true) break;
            }
            AV9d = (short)(AV9d+1) ;
         }
      }
      else
      {
         AV10esNumero = false ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = esnumero.this.AV10esNumero;
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

   private short AV9d ;
   private short Gx_err ;
   private String AV8palabra ;
   private boolean AV10esNumero ;
   private boolean Cond_result ;
   private boolean[] aP1 ;
}

