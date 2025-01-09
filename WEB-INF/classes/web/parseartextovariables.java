package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class parseartextovariables extends GXProcedure
{
   public parseartextovariables( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( parseartextovariables.class ), "" );
   }

   public parseartextovariables( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 )
   {
      parseartextovariables.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( String aP0 ,
                        String aP1 ,
                        String[] aP2 ,
                        String[] aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( String aP0 ,
                             String aP1 ,
                             String[] aP2 ,
                             String[] aP3 ,
                             String[] aP4 )
   {
      parseartextovariables.this.AV8OpeCliId = aP0;
      parseartextovariables.this.AV10scrape_OpeCliValor = aP1;
      parseartextovariables.this.aP2 = aP2;
      parseartextovariables.this.aP3 = aP3;
      parseartextovariables.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ( GXutil.strcmp(AV8OpeCliId, "[smvm]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[fijo_ART]") == 0 ) )
      {
         AV9split = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV10scrape_OpeCliValor,"\\(")) ;
         if ( AV9split.size() == 0 )
         {
            AV16error = httpContext.getMessage( "No se encontró el patrón esperado \"(\"", "") ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         else
         {
            if ( AV9split.size() < 2 )
            {
               AV16error = httpContext.getMessage( "No se encontró el patrón esperado ( ", "") + GXutil.trim( GXutil.str( AV9split.size(), 9, 0)) + " < 2" ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            else
            {
               AV10scrape_OpeCliValor = (String)AV9split.elementAt(-1+2) ;
               AV9split = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV10scrape_OpeCliValor,"\\)")) ;
               if ( AV9split.size() < 1 )
               {
                  AV16error = httpContext.getMessage( "No se encontró el patrón esperado ( ", "") + GXutil.trim( GXutil.str( AV9split.size(), 9, 0)) + " < 1" ;
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               else
               {
                  AV10scrape_OpeCliValor = (String)AV9split.elementAt(-1+1) ;
               }
            }
         }
         AV17valorCrudo = AV10scrape_OpeCliValor ;
         /* Execute user subroutine: 'REEMPLAZAR COSAS' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXv_char1[0] = AV11OpeCliValor ;
         new web.convertirformatoimporte(remoteHandle, context).execute( AV15aux_OpeCliValor, httpContext.getMessage( "Miles_Punto", ""), GXv_char1) ;
         parseartextovariables.this.AV11OpeCliValor = GXv_char1[0] ;
      }
      else if ( ( GXutil.strcmp(AV8OpeCliId, "[base_imp_min]") == 0 ) || ( GXutil.strcmp(AV8OpeCliId, "[base_imp_max]") == 0 ) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV20Pgmname, httpContext.getMessage( "&scrape_OpeCliValor ", "")+AV10scrape_OpeCliValor) ;
         AV9split = new GXSimpleCollection<String>(String.class, "internal", "", GxRegex.Split(AV10scrape_OpeCliValor,"\\(")) ;
         if ( AV9split.size() == 0 )
         {
            AV16error = httpContext.getMessage( "No se encontró el patrón esperado \"(\"", "") ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         else
         {
            if ( AV9split.size() < 3 )
            {
               AV16error = httpContext.getMessage( "No se encontró el patrón esperado ( ", "") + GXutil.trim( GXutil.str( AV9split.size(), 9, 0)) + " < 3" ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            else
            {
               if ( GXutil.strcmp(AV8OpeCliId, "[base_imp_min]") == 0 )
               {
                  AV10scrape_OpeCliValor = (String)AV9split.elementAt(-1+2) ;
               }
               else
               {
                  AV10scrape_OpeCliValor = (String)AV9split.elementAt(-1+3) ;
               }
               AV10scrape_OpeCliValor = GXutil.strReplace( AV10scrape_OpeCliValor, "$", "") ;
               AV13pos = (short)(0) ;
               while ( true )
               {
                  gxexitloop = false ;
                  if ( gxexitloop )
                  {
                     break;
                  }
                  AV13pos = (short)(AV13pos+1) ;
                  AV12char = GXutil.substring( AV10scrape_OpeCliValor, AV13pos, 1) ;
                  if ( GXutil.strcmp(AV12char, ")") != 0 )
                  {
                     AV11OpeCliValor += AV12char ;
                  }
                  else
                  {
                     if (true) break;
                  }
                  if ( AV13pos >= GXutil.len( AV10scrape_OpeCliValor) )
                  {
                     if (true) break;
                  }
               }
               AV17valorCrudo = AV11OpeCliValor ;
               AV15aux_OpeCliValor = AV11OpeCliValor ;
               GXv_char1[0] = AV11OpeCliValor ;
               new web.convertirformatoimporte(remoteHandle, context).execute( AV15aux_OpeCliValor, httpContext.getMessage( "Miles_Punto", ""), GXv_char1) ;
               parseartextovariables.this.AV11OpeCliValor = GXv_char1[0] ;
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'REEMPLAZAR COSAS' Routine */
      returnInSub = false ;
      AV15aux_OpeCliValor = GXutil.strReplace( AV10scrape_OpeCliValor, "$", "") ;
      AV15aux_OpeCliValor = GXutil.strReplace( AV15aux_OpeCliValor, " ", "") ;
      AV15aux_OpeCliValor = GXutil.strReplace( AV15aux_OpeCliValor, "(", "") ;
      AV15aux_OpeCliValor = GXutil.strReplace( AV15aux_OpeCliValor, ")", "") ;
      AV15aux_OpeCliValor = GXutil.strReplace( AV15aux_OpeCliValor, ")", "") ;
      AV15aux_OpeCliValor = GXutil.strReplace( AV15aux_OpeCliValor, "-", "") ;
   }

   protected void cleanup( )
   {
      this.aP2[0] = parseartextovariables.this.AV11OpeCliValor;
      this.aP3[0] = parseartextovariables.this.AV17valorCrudo;
      this.aP4[0] = parseartextovariables.this.AV16error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11OpeCliValor = "" ;
      AV17valorCrudo = "" ;
      AV16error = "" ;
      AV9split = new GXSimpleCollection<String>(String.class, "internal", "");
      AV15aux_OpeCliValor = "" ;
      AV20Pgmname = "" ;
      AV12char = "" ;
      GXv_char1 = new String[1] ;
      AV20Pgmname = "parsearTextoVariables" ;
      /* GeneXus formulas. */
      AV20Pgmname = "parsearTextoVariables" ;
      Gx_err = (short)(0) ;
   }

   private short AV13pos ;
   private short Gx_err ;
   private String AV8OpeCliId ;
   private String AV17valorCrudo ;
   private String AV20Pgmname ;
   private String AV12char ;
   private String GXv_char1[] ;
   private boolean returnInSub ;
   private boolean gxexitloop ;
   private String AV10scrape_OpeCliValor ;
   private String AV11OpeCliValor ;
   private String AV15aux_OpeCliValor ;
   private String AV16error ;
   private String[] aP4 ;
   private String[] aP2 ;
   private String[] aP3 ;
   private GXSimpleCollection<String> AV9split ;
}

