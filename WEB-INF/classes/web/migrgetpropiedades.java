package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class migrgetpropiedades extends GXProcedure
{
   public migrgetpropiedades( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( migrgetpropiedades.class ), "" );
   }

   public migrgetpropiedades( int remoteHandle ,
                              ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              String aP3 ,
                              String aP4 ,
                              String aP5 ,
                              boolean[] aP6 ,
                              String[] aP7 ,
                              boolean[] aP8 ,
                              boolean[] aP9 )
   {
      migrgetpropiedades.this.aP10 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        String aP3 ,
                        String aP4 ,
                        String aP5 ,
                        boolean[] aP6 ,
                        String[] aP7 ,
                        boolean[] aP8 ,
                        boolean[] aP9 ,
                        boolean[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             String aP3 ,
                             String aP4 ,
                             String aP5 ,
                             boolean[] aP6 ,
                             String[] aP7 ,
                             boolean[] aP8 ,
                             boolean[] aP9 ,
                             boolean[] aP10 )
   {
      migrgetpropiedades.this.AV8CliCod = aP0;
      migrgetpropiedades.this.AV9EmpCod = aP1;
      migrgetpropiedades.this.AV10MigrLegNumero = aP2;
      migrgetpropiedades.this.AV19campo = aP3;
      migrgetpropiedades.this.AV27dependenciaCodigo = aP4;
      migrgetpropiedades.this.AV20valor = aP5;
      migrgetpropiedades.this.aP6 = aP6;
      migrgetpropiedades.this.aP7 = aP7;
      migrgetpropiedades.this.aP8 = aP8;
      migrgetpropiedades.this.aP9 = aP9;
      migrgetpropiedades.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV31ParmValue ;
      GXt_char2 = AV31ParmValue ;
      GXv_char3[0] = GXt_char2 ;
      new web.algoritmoequivimportleg_codigo(remoteHandle, context).execute( GXv_char3) ;
      migrgetpropiedades.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
      migrgetpropiedades.this.GXt_char1 = GXv_char4[0] ;
      AV31ParmValue = GXt_char1 ;
      AV30AlgortimoEquivalenciasImpLeg = AV31ParmValue ;
      if ( ! (GXutil.strcmp("", AV20valor)==0) )
      {
         if ( ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Adherente", "")) == 0 ) || ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Discapacitado", "")) == 0 ) )
         {
            GXv_boolean5[0] = false ;
            GXv_objcol_svchar6[0] = AV14errores ;
            GXv_char4[0] = "" ;
            GXv_boolean7[0] = AV17existe ;
            new web.traducirsinoaboolean(remoteHandle, context).execute( AV8CliCod, AV20valor, AV19campo, GXv_boolean5, GXv_objcol_svchar6, GXv_char4, GXv_boolean7) ;
            AV14errores = GXv_objcol_svchar6[0] ;
            migrgetpropiedades.this.AV17existe = GXv_boolean7[0] ;
            AV23valor_devuelve = AV20valor ;
         }
         else
         {
            if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Género", "")) == 0 )
            {
               GXv_int8[0] = (byte)(0) ;
               GXv_objcol_svchar6[0] = AV14errores ;
               GXv_char4[0] = "" ;
               GXv_boolean7[0] = AV17existe ;
               new web.traducirsexo(remoteHandle, context).execute( AV8CliCod, AV20valor, GXv_int8, GXv_objcol_svchar6, GXv_char4, GXv_boolean7) ;
               AV14errores = GXv_objcol_svchar6[0] ;
               migrgetpropiedades.this.AV17existe = GXv_boolean7[0] ;
            }
            else
            {
               if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Estado Civil", "")) == 0 )
               {
                  GXv_int9[0] = (short)(0) ;
                  GXv_objcol_svchar6[0] = AV14errores ;
                  GXv_char4[0] = "" ;
                  GXv_boolean7[0] = AV17existe ;
                  new web.traducirestadocivil(remoteHandle, context).execute( AV8CliCod, AV20valor, GXv_int9, GXv_objcol_svchar6, GXv_char4, GXv_boolean7) ;
                  AV14errores = GXv_objcol_svchar6[0] ;
                  migrgetpropiedades.this.AV17existe = GXv_boolean7[0] ;
               }
               else
               {
                  GXv_char4[0] = "" ;
                  GXv_objcol_svchar6[0] = AV14errores ;
                  GXv_objcol_svchar10[0] = AV18warnings ;
                  GXv_char3[0] = AV21likeValor ;
                  GXv_boolean7[0] = AV13hayLike ;
                  GXv_boolean5[0] = AV17existe ;
                  GXv_boolean11[0] = AV24esCodigo ;
                  GXv_char12[0] = "" ;
                  new web.traducirmigracioncaracter(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10MigrLegNumero, AV19campo, AV20valor, false, AV27dependenciaCodigo, AV30AlgortimoEquivalenciasImpLeg, "", "", GXv_char4, GXv_objcol_svchar6, GXv_objcol_svchar10, GXv_char3, GXv_boolean7, GXv_boolean5, GXv_boolean11, GXv_char12) ;
                  AV14errores = GXv_objcol_svchar6[0] ;
                  AV18warnings = GXv_objcol_svchar10[0] ;
                  migrgetpropiedades.this.AV21likeValor = GXv_char3[0] ;
                  migrgetpropiedades.this.AV13hayLike = GXv_boolean7[0] ;
                  migrgetpropiedades.this.AV17existe = GXv_boolean5[0] ;
                  migrgetpropiedades.this.AV24esCodigo = GXv_boolean11[0] ;
               }
            }
            GXt_char2 = AV26default ;
            GXv_char12[0] = GXt_char2 ;
            new web.defaultmigr(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV19campo, GXv_char12) ;
            migrgetpropiedades.this.GXt_char2 = GXv_char12[0] ;
            AV26default = GXt_char2 ;
            if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV20valor)), GXutil.upper( GXutil.trim( AV26default))) == 0 )
            {
               /* Using cursor P002Y2 */
               pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV10MigrLegNumero)});
               while ( (pr_default.getStatus(0) != 101) )
               {
                  A87MigrLegNumero = P002Y2_A87MigrLegNumero[0] ;
                  A1EmpCod = P002Y2_A1EmpCod[0] ;
                  A3CliCod = P002Y2_A3CliCod[0] ;
                  A689MigrLegAreaDef = P002Y2_A689MigrLegAreaDef[0] ;
                  A694MigrLegActividadDef = P002Y2_A694MigrLegActividadDef[0] ;
                  A691MigrLegClaseDef = P002Y2_A691MigrLegClaseDef[0] ;
                  A699MigrLegCondicionDef = P002Y2_A699MigrLegCondicionDef[0] ;
                  A690MigrLegEstadoCivilDef = P002Y2_A690MigrLegEstadoCivilDef[0] ;
                  A692MigrLegFormaPagoDef = P002Y2_A692MigrLegFormaPagoDef[0] ;
                  A695MigrLegModalidadDef = P002Y2_A695MigrLegModalidadDef[0] ;
                  A700MigrLegSiniestradoDef = P002Y2_A700MigrLegSiniestradoDef[0] ;
                  A698MigrLegSituacionDef = P002Y2_A698MigrLegSituacionDef[0] ;
                  A696MigrLegZonaDef = P002Y2_A696MigrLegZonaDef[0] ;
                  if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Area", "")) == 0 )
                  {
                     AV25defaultEs = A689MigrLegAreaDef ;
                  }
                  else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Actividad", "")) == 0 )
                  {
                     AV25defaultEs = A694MigrLegActividadDef ;
                  }
                  else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Frecuencia de pago", "")) == 0 )
                  {
                     AV25defaultEs = A691MigrLegClaseDef ;
                  }
                  else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Condicion", "")) == 0 )
                  {
                     AV25defaultEs = A699MigrLegCondicionDef ;
                  }
                  else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Estado civil", "")) == 0 )
                  {
                     AV25defaultEs = A690MigrLegEstadoCivilDef ;
                  }
                  else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Forma de Pago", "")) == 0 )
                  {
                     AV25defaultEs = A692MigrLegFormaPagoDef ;
                  }
                  else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Modalidad", "")) == 0 )
                  {
                     AV25defaultEs = A695MigrLegModalidadDef ;
                  }
                  else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Siniestrado", "")) == 0 )
                  {
                     AV25defaultEs = A700MigrLegSiniestradoDef ;
                  }
                  else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Situacion", "")) == 0 )
                  {
                     AV25defaultEs = A698MigrLegSituacionDef ;
                  }
                  else if ( GXutil.strcmp(AV19campo, httpContext.getMessage( "Zona", "")) == 0 )
                  {
                     AV25defaultEs = A696MigrLegZonaDef ;
                  }
                  /* Exiting from a For First loop. */
                  if (true) break;
               }
               pr_default.close(0);
            }
            AV23valor_devuelve = AV20valor ;
            AV29parmAuxDescrip = AV23valor_devuelve ;
            GXv_char12[0] = AV23valor_devuelve ;
            new web.reemplazosningunos(remoteHandle, context).execute( AV8CliCod, AV29parmAuxDescrip, GXv_char12) ;
            migrgetpropiedades.this.AV23valor_devuelve = GXv_char12[0] ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = migrgetpropiedades.this.AV13hayLike;
      this.aP7[0] = migrgetpropiedades.this.AV23valor_devuelve;
      this.aP8[0] = migrgetpropiedades.this.AV17existe;
      this.aP9[0] = migrgetpropiedades.this.AV24esCodigo;
      this.aP10[0] = migrgetpropiedades.this.AV25defaultEs;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV23valor_devuelve = "" ;
      AV31ParmValue = "" ;
      GXt_char1 = "" ;
      AV30AlgortimoEquivalenciasImpLeg = "" ;
      AV14errores = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_int8 = new byte[1] ;
      GXv_int9 = new short[1] ;
      GXv_char4 = new String[1] ;
      GXv_objcol_svchar6 = new GXSimpleCollection[1] ;
      AV18warnings = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_svchar10 = new GXSimpleCollection[1] ;
      AV21likeValor = "" ;
      GXv_char3 = new String[1] ;
      GXv_boolean7 = new boolean[1] ;
      GXv_boolean5 = new boolean[1] ;
      GXv_boolean11 = new boolean[1] ;
      AV26default = "" ;
      GXt_char2 = "" ;
      scmdbuf = "" ;
      P002Y2_A87MigrLegNumero = new int[1] ;
      P002Y2_A1EmpCod = new short[1] ;
      P002Y2_A3CliCod = new int[1] ;
      P002Y2_A689MigrLegAreaDef = new boolean[] {false} ;
      P002Y2_A694MigrLegActividadDef = new boolean[] {false} ;
      P002Y2_A691MigrLegClaseDef = new boolean[] {false} ;
      P002Y2_A699MigrLegCondicionDef = new boolean[] {false} ;
      P002Y2_A690MigrLegEstadoCivilDef = new boolean[] {false} ;
      P002Y2_A692MigrLegFormaPagoDef = new boolean[] {false} ;
      P002Y2_A695MigrLegModalidadDef = new boolean[] {false} ;
      P002Y2_A700MigrLegSiniestradoDef = new boolean[] {false} ;
      P002Y2_A698MigrLegSituacionDef = new boolean[] {false} ;
      P002Y2_A696MigrLegZonaDef = new boolean[] {false} ;
      AV29parmAuxDescrip = "" ;
      GXv_char12 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.migrgetpropiedades__default(),
         new Object[] {
             new Object[] {
            P002Y2_A87MigrLegNumero, P002Y2_A1EmpCod, P002Y2_A3CliCod, P002Y2_A689MigrLegAreaDef, P002Y2_A694MigrLegActividadDef, P002Y2_A691MigrLegClaseDef, P002Y2_A699MigrLegCondicionDef, P002Y2_A690MigrLegEstadoCivilDef, P002Y2_A692MigrLegFormaPagoDef, P002Y2_A695MigrLegModalidadDef,
            P002Y2_A700MigrLegSiniestradoDef, P002Y2_A698MigrLegSituacionDef, P002Y2_A696MigrLegZonaDef
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte GXv_int8[] ;
   private short AV9EmpCod ;
   private short GXv_int9[] ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10MigrLegNumero ;
   private int A87MigrLegNumero ;
   private int A3CliCod ;
   private String AV19campo ;
   private String AV27dependenciaCodigo ;
   private String GXt_char1 ;
   private String AV30AlgortimoEquivalenciasImpLeg ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private String GXt_char2 ;
   private String scmdbuf ;
   private String GXv_char12[] ;
   private boolean AV13hayLike ;
   private boolean AV17existe ;
   private boolean AV24esCodigo ;
   private boolean AV25defaultEs ;
   private boolean GXv_boolean7[] ;
   private boolean GXv_boolean5[] ;
   private boolean GXv_boolean11[] ;
   private boolean A689MigrLegAreaDef ;
   private boolean A694MigrLegActividadDef ;
   private boolean A691MigrLegClaseDef ;
   private boolean A699MigrLegCondicionDef ;
   private boolean A690MigrLegEstadoCivilDef ;
   private boolean A692MigrLegFormaPagoDef ;
   private boolean A695MigrLegModalidadDef ;
   private boolean A700MigrLegSiniestradoDef ;
   private boolean A698MigrLegSituacionDef ;
   private boolean A696MigrLegZonaDef ;
   private String AV31ParmValue ;
   private String AV20valor ;
   private String AV23valor_devuelve ;
   private String AV21likeValor ;
   private String AV26default ;
   private String AV29parmAuxDescrip ;
   private boolean[] aP10 ;
   private boolean[] aP6 ;
   private String[] aP7 ;
   private boolean[] aP8 ;
   private boolean[] aP9 ;
   private IDataStoreProvider pr_default ;
   private int[] P002Y2_A87MigrLegNumero ;
   private short[] P002Y2_A1EmpCod ;
   private int[] P002Y2_A3CliCod ;
   private boolean[] P002Y2_A689MigrLegAreaDef ;
   private boolean[] P002Y2_A694MigrLegActividadDef ;
   private boolean[] P002Y2_A691MigrLegClaseDef ;
   private boolean[] P002Y2_A699MigrLegCondicionDef ;
   private boolean[] P002Y2_A690MigrLegEstadoCivilDef ;
   private boolean[] P002Y2_A692MigrLegFormaPagoDef ;
   private boolean[] P002Y2_A695MigrLegModalidadDef ;
   private boolean[] P002Y2_A700MigrLegSiniestradoDef ;
   private boolean[] P002Y2_A698MigrLegSituacionDef ;
   private boolean[] P002Y2_A696MigrLegZonaDef ;
   private GXSimpleCollection<String> AV14errores ;
   private GXSimpleCollection<String> GXv_objcol_svchar6[] ;
   private GXSimpleCollection<String> AV18warnings ;
   private GXSimpleCollection<String> GXv_objcol_svchar10[] ;
}

final  class migrgetpropiedades__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P002Y2", "SELECT MigrLegNumero, EmpCod, CliCod, MigrLegAreaDef, MigrLegActividadDef, MigrLegClaseDef, MigrLegCondicionDef, MigrLegEstadoCivilDef, MigrLegFormaPagoDef, MigrLegModalidadDef, MigrLegSiniestradoDef, MigrLegSituacionDef, MigrLegZonaDef FROM importacion_legajo WHERE CliCod = ? and EmpCod = ? and MigrLegNumero = ? ORDER BY CliCod, EmpCod, MigrLegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((boolean[]) buf[3])[0] = rslt.getBoolean(4);
               ((boolean[]) buf[4])[0] = rslt.getBoolean(5);
               ((boolean[]) buf[5])[0] = rslt.getBoolean(6);
               ((boolean[]) buf[6])[0] = rslt.getBoolean(7);
               ((boolean[]) buf[7])[0] = rslt.getBoolean(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((boolean[]) buf[9])[0] = rslt.getBoolean(10);
               ((boolean[]) buf[10])[0] = rslt.getBoolean(11);
               ((boolean[]) buf[11])[0] = rslt.getBoolean(12);
               ((boolean[]) buf[12])[0] = rslt.getBoolean(13);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

