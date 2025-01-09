package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class validar_concepto_base_2 extends GXProcedure
{
   public validar_concepto_base_2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( validar_concepto_base_2.class ), "" );
   }

   public validar_concepto_base_2( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( byte aP0 ,
                              String aP1 ,
                              boolean aP2 )
   {
      validar_concepto_base_2.this.aP3 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( byte aP0 ,
                        String aP1 ,
                        boolean aP2 ,
                        boolean[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( byte aP0 ,
                             String aP1 ,
                             boolean aP2 ,
                             boolean[] aP3 )
   {
      validar_concepto_base_2.this.AV8ConBaseLic = aP0;
      validar_concepto_base_2.this.AV23tipo_tarifa = aP1;
      validar_concepto_base_2.this.AV10habitualEs = aP2;
      validar_concepto_base_2.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12agregar = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, "1") ;
      if ( AV8ConBaseLic == 1 )
      {
         AV12agregar = true ;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, "2") ;
         if ( AV8ConBaseLic == 4 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, "3") ;
            AV12agregar = AV10habitualEs ;
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, "4") ;
            if ( ( AV8ConBaseLic == 2 ) && ( GXutil.strcmp(AV23tipo_tarifa, "H") == 0 ) )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV26Pgmname, "5") ;
               AV12agregar = true ;
            }
            else
            {
               if ( ( AV8ConBaseLic == 3 ) && ( GXutil.strcmp(AV23tipo_tarifa, "P") == 0 ) )
               {
                  AV12agregar = true ;
               }
               else
               {
                  if ( ( AV8ConBaseLic == 5 ) && ( GXutil.strcmp(AV23tipo_tarifa, "H") == 0 ) )
                  {
                     AV12agregar = AV10habitualEs ;
                  }
                  else
                  {
                     if ( ( AV8ConBaseLic == 6 ) && ( GXutil.strcmp(AV23tipo_tarifa, "P") == 0 ) )
                     {
                        AV12agregar = AV10habitualEs ;
                     }
                  }
               }
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = validar_concepto_base_2.this.AV12agregar;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV26Pgmname = "" ;
      AV26Pgmname = "validar_concepto_base_2" ;
      /* GeneXus formulas. */
      AV26Pgmname = "validar_concepto_base_2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV8ConBaseLic ;
   private short Gx_err ;
   private String AV23tipo_tarifa ;
   private String AV26Pgmname ;
   private boolean AV10habitualEs ;
   private boolean AV12agregar ;
   private boolean[] aP3 ;
}

