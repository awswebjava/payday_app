package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class countfiltroslegajos extends GXProcedure
{
   public countfiltroslegajos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( countfiltroslegajos.class ), "" );
   }

   public countfiltroslegajos( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( web.wwpbaseobjects.SdtWWPGridState aP0 ,
                             short[] aP1 )
   {
      countfiltroslegajos.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( web.wwpbaseobjects.SdtWWPGridState aP0 ,
                        short[] aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( web.wwpbaseobjects.SdtWWPGridState aP0 ,
                             short[] aP1 ,
                             String[] aP2 )
   {
      countfiltroslegajos.this.AV8GridState = aP0;
      countfiltroslegajos.this.aP1 = aP1;
      countfiltroslegajos.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV12filtrosTexto = "" ;
      new web.msgdebug_prod2(remoteHandle, context).execute( 4, AV15Pgmname, httpContext.getMessage( "&GridState count ", "")+GXutil.trim( GXutil.str( AV8GridState.getgxTv_SdtWWPGridState_Filtervalues().size(), 9, 0))) ;
      AV16GXV1 = 1 ;
      while ( AV16GXV1 <= AV8GridState.getgxTv_SdtWWPGridState_Filtervalues().size() )
      {
         AV9GridStateFilterValue = (web.wwpbaseobjects.SdtWWPGridState_FilterValue)((web.wwpbaseobjects.SdtWWPGridState_FilterValue)AV8GridState.getgxTv_SdtWWPGridState_Filtervalues().elementAt(-1+AV16GXV1));
         new web.msgdebug_prod2(remoteHandle, context).execute( 4, AV15Pgmname, httpContext.getMessage( "&GridStateFilterValue.Name \"", "")+AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name()+"\"") ;
         if ( GXutil.strcmp(AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "FILTERFULLTEXT") != 0 )
         {
            if ( GXutil.strcmp(AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "CONVENIOFILTRO") == 0 )
            {
               AV10ConvenioFiltro = AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value() ;
               if ( GXutil.strcmp(AV10ConvenioFiltro, "Todos") != 0 )
               {
                  AV11i = (short)(AV11i+1) ;
                  /* Execute user subroutine: 'COMA' */
                  S111 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
                  AV12filtrosTexto += httpContext.getMessage( "Convenio", "") ;
               }
            }
            else
            {
               if ( GXutil.strcmp(AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGCONVECODIGO") != 0 )
               {
                  AV11i = (short)(AV11i+1) ;
                  /* Execute user subroutine: 'COMA' */
                  S111 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
                  new web.msgdebug_prod2(remoteHandle, context).execute( 4, AV15Pgmname, httpContext.getMessage( "... &GridStateFilterValue.Name \"", "")+AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name()+"\"") ;
                  if ( GXutil.strcmp(AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGINCOMPLETO") == 0 )
                  {
                     AV12filtrosTexto += httpContext.getMessage( "Solo legajos con datos incompletos", "") ;
                  }
                  else if ( GXutil.strcmp(AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGSEXO") == 0 )
                  {
                     AV12filtrosTexto += httpContext.getMessage( "Género", "") ;
                  }
                  else if ( GXutil.strcmp(AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGCLASE") == 0 )
                  {
                     AV12filtrosTexto += httpContext.getMessage( "Frecuencia de pago", "") ;
                  }
                  else if ( GXutil.strcmp(AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGMODTRA") == 0 )
                  {
                     AV12filtrosTexto += httpContext.getMessage( "Relación laboral", "") ;
                  }
                  else if ( GXutil.strcmp(AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGTIPOTARIFA") == 0 )
                  {
                     AV12filtrosTexto += httpContext.getMessage( "Tipo de tarifa", "") ;
                  }
                  else if ( GXutil.strcmp(AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGSINCOD") == 0 )
                  {
                     AV12filtrosTexto += httpContext.getMessage( "Sindicato", "") ;
                  }
                  else if ( GXutil.strcmp(AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGCATCODIGO") == 0 )
                  {
                     AV12filtrosTexto += httpContext.getMessage( "Categoría", "") ;
                  }
                  else if ( GXutil.strcmp(AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGFECINGRESO") == 0 )
                  {
                     AV12filtrosTexto += httpContext.getMessage( "Fecha de ingreso", "") ;
                  }
                  else if ( GXutil.strcmp(AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGFECEGRESO") == 0 )
                  {
                     AV12filtrosTexto += httpContext.getMessage( "Fecha de egreso", "") ;
                  }
                  else if ( GXutil.strcmp(AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGSECCODIGO") == 0 )
                  {
                     AV12filtrosTexto += httpContext.getMessage( "Área", "") ;
                  }
                  else if ( GXutil.strcmp(AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGPUESCODIGO") == 0 )
                  {
                     AV12filtrosTexto += httpContext.getMessage( "Puesto", "") ;
                  }
                  else if ( GXutil.strcmp(AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGACTCODIGO") == 0 )
                  {
                     AV12filtrosTexto += httpContext.getMessage( "Actividad", "") ;
                  }
                  else if ( GXutil.strcmp(AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "MPRCOD") == 0 )
                  {
                     AV12filtrosTexto += httpContext.getMessage( "Modalidad", "") ;
                  }
                  else if ( GXutil.strcmp(AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "ZONCOD") == 0 )
                  {
                     AV12filtrosTexto += httpContext.getMessage( "Zona", "") ;
                  }
                  else if ( GXutil.strcmp(AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGSUCCODIGO") == 0 )
                  {
                     AV12filtrosTexto += httpContext.getMessage( "Sucursal", "") ;
                  }
                  else if ( GXutil.strcmp(AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGESTADO") == 0 )
                  {
                     AV12filtrosTexto += httpContext.getMessage( "Estado", "") ;
                     new web.msgdebug_prod2(remoteHandle, context).execute( 4, AV15Pgmname, httpContext.getMessage( "agrega estado ", "")+GXutil.trim( AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value())) ;
                     if ( GXutil.strcmp(GXutil.trim( AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Value()), "1") == 0 )
                     {
                        AV12filtrosTexto += httpContext.getMessage( " (activos)", "") ;
                     }
                     else
                     {
                        AV12filtrosTexto += httpContext.getMessage( " (baja/inactivos)", "") ;
                     }
                  }
                  else if ( GXutil.strcmp(AV9GridStateFilterValue.getgxTv_SdtWWPGridState_FilterValue_Name(), "LEGINCOMPLETO") == 0 )
                  {
                     AV12filtrosTexto += httpContext.getMessage( "Solo legajos incompletos", "") ;
                  }
               }
            }
         }
         AV16GXV1 = (int)(AV16GXV1+1) ;
      }
      if ( ! (GXutil.strcmp("", AV12filtrosTexto)==0) )
      {
         AV12filtrosTexto = httpContext.getMessage( "Filtros aplicados: ", "") + GXutil.trim( AV12filtrosTexto) ;
      }
      else
      {
         AV12filtrosTexto = httpContext.getMessage( "Aplicar filtros", "") ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'COMA' Routine */
      returnInSub = false ;
      if ( AV11i > 1 )
      {
         AV12filtrosTexto += ", " ;
      }
   }

   protected void cleanup( )
   {
      this.aP1[0] = countfiltroslegajos.this.AV11i;
      this.aP2[0] = countfiltroslegajos.this.AV12filtrosTexto;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12filtrosTexto = "" ;
      AV15Pgmname = "" ;
      AV9GridStateFilterValue = new web.wwpbaseobjects.SdtWWPGridState_FilterValue(remoteHandle, context);
      AV10ConvenioFiltro = "" ;
      AV15Pgmname = "countFiltrosLegajos" ;
      /* GeneXus formulas. */
      AV15Pgmname = "countFiltrosLegajos" ;
      Gx_err = (short)(0) ;
   }

   private short AV11i ;
   private short Gx_err ;
   private int AV16GXV1 ;
   private String AV15Pgmname ;
   private String AV10ConvenioFiltro ;
   private boolean returnInSub ;
   private String AV12filtrosTexto ;
   private String[] aP2 ;
   private short[] aP1 ;
   private web.wwpbaseobjects.SdtWWPGridState AV8GridState ;
   private web.wwpbaseobjects.SdtWWPGridState_FilterValue AV9GridStateFilterValue ;
}

