package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class esnohabitualseguncoleccion extends GXProcedure
{
   public esnohabitualseguncoleccion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( esnohabitualseguncoleccion.class ), "" );
   }

   public esnohabitualseguncoleccion( int remoteHandle ,
                                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        GXSimpleCollection<String> aP2 ,
                        String aP3 ,
                        String aP4 ,
                        boolean aP5 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             GXSimpleCollection<String> aP2 ,
                             String aP3 ,
                             String aP4 ,
                             boolean aP5 )
   {
      esnohabitualseguncoleccion.this.AV16CliCod = aP0;
      esnohabitualseguncoleccion.this.AV11ConCodigo = aP1;
      esnohabitualseguncoleccion.this.AV9noHabitualConCodigo = aP2;
      esnohabitualseguncoleccion.this.AV12SubTipoConCod1 = aP3;
      esnohabitualseguncoleccion.this.AV14SubTipoConCod2 = aP4;
      esnohabitualseguncoleccion.this.AV10esNoHabitual = aP5;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8i = (short)(1) ;
      while ( AV8i <= AV9noHabitualConCodigo.size() )
      {
         if ( ! (GXutil.strcmp("", AV11ConCodigo)==0) )
         {
            Cond_result = true ;
         }
         else
         {
            Cond_result = false ;
         }
         if ( Cond_result )
         {
            if ( GXutil.strcmp(AV11ConCodigo, (String)AV9noHabitualConCodigo.elementAt(-1+AV8i)) == 0 )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               AV10esNoHabitual = true ;
               if (true) break;
            }
         }
         else
         {
            GXv_char1[0] = AV13nohab_SubTipoConCod1 ;
            GXv_char2[0] = AV15nohab_SubTipoConCod2 ;
            new web.conceptogetsubtipos(remoteHandle, context).execute( AV16CliCod, (String)AV9noHabitualConCodigo.elementAt(-1+AV8i), GXv_char1, GXv_char2) ;
            esnohabitualseguncoleccion.this.AV13nohab_SubTipoConCod1 = GXv_char1[0] ;
            esnohabitualseguncoleccion.this.AV15nohab_SubTipoConCod2 = GXv_char2[0] ;
            if ( ( GXutil.strcmp(AV12SubTipoConCod1, AV13nohab_SubTipoConCod1) == 0 ) && ( GXutil.strcmp(AV14SubTipoConCod2, AV15nohab_SubTipoConCod2) == 0 ) )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               AV10esNoHabitual = true ;
               if (true) break;
            }
         }
         AV8i = (short)(AV8i+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13nohab_SubTipoConCod1 = "" ;
      GXv_char1 = new String[1] ;
      AV15nohab_SubTipoConCod2 = "" ;
      GXv_char2 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8i ;
   private short Gx_err ;
   private int AV16CliCod ;
   private String AV11ConCodigo ;
   private String AV12SubTipoConCod1 ;
   private String AV14SubTipoConCod2 ;
   private String AV13nohab_SubTipoConCod1 ;
   private String GXv_char1[] ;
   private String AV15nohab_SubTipoConCod2 ;
   private String GXv_char2[] ;
   private boolean AV10esNoHabitual ;
   private boolean Cond_result ;
   private GXSimpleCollection<String> AV9noHabitualConCodigo ;
}

