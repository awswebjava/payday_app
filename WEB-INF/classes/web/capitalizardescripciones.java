package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class capitalizardescripciones extends GXProcedure
{
   public capitalizardescripciones( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( capitalizardescripciones.class ), "" );
   }

   public capitalizardescripciones( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int aP0 )
   {
      capitalizardescripciones.this.AV8CliCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, "1") ;
      AV24GXLvl2 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV8CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P022B2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P022B2_A3CliCod[0] ;
         A41ConDescrip = P022B2_A41ConDescrip[0] ;
         A26ConCodigo = P022B2_A26ConCodigo[0] ;
         AV24GXLvl2 = (byte)(1) ;
         GXv_char1[0] = AV10ConDescrip ;
         new web.capitalizartexto(remoteHandle, context).execute( A41ConDescrip, GXv_char1) ;
         capitalizardescripciones.this.AV10ConDescrip = GXv_char1[0] ;
         if ( GXutil.strSearch( AV10ConDescrip, httpContext.getMessage( " dei", ""), 1) != 0 )
         {
            AV10ConDescrip = GXutil.strReplace( AV10ConDescrip, httpContext.getMessage( " dei", ""), httpContext.getMessage( " DEI", "")) ;
         }
         A41ConDescrip = GXutil.trim( AV10ConDescrip) ;
         /* Using cursor P022B3 */
         pr_default.execute(1, new Object[] {A41ConDescrip, Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV24GXLvl2 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "none", "")) ;
      }
      AV25GXLvl13 = (byte)(0) ;
      /* Using cursor P022B4 */
      pr_default.execute(2);
      while ( (pr_default.getStatus(2) != 101) )
      {
         A160ConveDescri = P022B4_A160ConveDescri[0] ;
         A46PaiCod = P022B4_A46PaiCod[0] ;
         A9ConveCodigo = P022B4_A9ConveCodigo[0] ;
         AV25GXLvl13 = (byte)(1) ;
         GXv_char1[0] = AV12ConveDescri ;
         new web.capitalizartexto(remoteHandle, context).execute( A160ConveDescri, GXv_char1) ;
         capitalizardescripciones.this.AV12ConveDescri = GXv_char1[0] ;
         A160ConveDescri = GXutil.trim( AV12ConveDescri) ;
         /* Using cursor P022B5 */
         pr_default.execute(3, new Object[] {A160ConveDescri, Short.valueOf(A46PaiCod), A9ConveCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Convenio");
         pr_default.readNext(2);
      }
      pr_default.close(2);
      if ( AV25GXLvl13 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "none2", "")) ;
      }
      AV26GXLvl21 = (byte)(0) ;
      /* Using cursor P022B6 */
      pr_default.execute(4);
      while ( (pr_default.getStatus(4) != 101) )
      {
         A123CatDescrip = P022B6_A123CatDescrip[0] ;
         A3CliCod = P022B6_A3CliCod[0] ;
         A1564CliPaiConve = P022B6_A1564CliPaiConve[0] ;
         A1565CliConvenio = P022B6_A1565CliConvenio[0] ;
         A8CatCodigo = P022B6_A8CatCodigo[0] ;
         AV26GXLvl21 = (byte)(1) ;
         GXv_char1[0] = AV19CatDescrip ;
         new web.capitalizartextocategoria(remoteHandle, context).execute( A123CatDescrip, GXv_char1) ;
         capitalizardescripciones.this.AV19CatDescrip = GXv_char1[0] ;
         A123CatDescrip = GXutil.trim( AV19CatDescrip) ;
         /* Using cursor P022B7 */
         pr_default.execute(5, new Object[] {A123CatDescrip, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoria1");
         pr_default.readNext(4);
      }
      pr_default.close(4);
      if ( AV26GXLvl21 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "nonecat", "")) ;
      }
      AV27GXLvl38 = (byte)(0) ;
      pr_default.dynParam(6, new Object[]{ new Object[]{
                                           Integer.valueOf(AV8CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P022B8 */
      pr_default.execute(6, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(6) != 101) )
      {
         A3CliCod = P022B8_A3CliCod[0] ;
         A307OsoDescrip = P022B8_A307OsoDescrip[0] ;
         A5OsoCod = P022B8_A5OsoCod[0] ;
         AV27GXLvl38 = (byte)(1) ;
         GXv_char1[0] = AV14OsoDescrip ;
         new web.capitalizartexto(remoteHandle, context).execute( A307OsoDescrip, GXv_char1) ;
         capitalizardescripciones.this.AV14OsoDescrip = GXv_char1[0] ;
         A307OsoDescrip = GXutil.trim( AV14OsoDescrip) ;
         /* Using cursor P022B9 */
         pr_default.execute(7, new Object[] {A307OsoDescrip, Integer.valueOf(A3CliCod), A5OsoCod});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ObraSocial");
         pr_default.readNext(6);
      }
      pr_default.close(6);
      if ( AV27GXLvl38 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "none4", "")) ;
      }
      AV28GXLvl47 = (byte)(0) ;
      pr_default.dynParam(8, new Object[]{ new Object[]{
                                           Integer.valueOf(AV8CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P022B10 */
      pr_default.execute(8, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(8) != 101) )
      {
         A3CliCod = P022B10_A3CliCod[0] ;
         A329SecDescrip = P022B10_A329SecDescrip[0] ;
         A13SecCodigo = P022B10_A13SecCodigo[0] ;
         AV28GXLvl47 = (byte)(1) ;
         GXv_char1[0] = AV15SecDescrip ;
         new web.capitalizartexto(remoteHandle, context).execute( A329SecDescrip, GXv_char1) ;
         capitalizardescripciones.this.AV15SecDescrip = GXv_char1[0] ;
         A329SecDescrip = GXutil.trim( AV15SecDescrip) ;
         /* Using cursor P022B11 */
         pr_default.execute(9, new Object[] {A329SecDescrip, Integer.valueOf(A3CliCod), A13SecCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Seccion");
         pr_default.readNext(8);
      }
      pr_default.close(8);
      if ( AV28GXLvl47 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "none4", "")) ;
      }
      AV29GXLvl55 = (byte)(0) ;
      pr_default.dynParam(10, new Object[]{ new Object[]{
                                           Integer.valueOf(AV8CliCod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P022B12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(10) != 101) )
      {
         A3CliCod = P022B12_A3CliCod[0] ;
         A300MegDescrip = P022B12_A300MegDescrip[0] ;
         A11MegCodigo = P022B12_A11MegCodigo[0] ;
         AV29GXLvl55 = (byte)(1) ;
         GXv_char1[0] = AV16MegDescrip ;
         new web.capitalizartexto(remoteHandle, context).execute( A300MegDescrip, GXv_char1) ;
         capitalizardescripciones.this.AV16MegDescrip = GXv_char1[0] ;
         A300MegDescrip = GXutil.trim( AV16MegDescrip) ;
         /* Using cursor P022B13 */
         pr_default.execute(11, new Object[] {A300MegDescrip, Integer.valueOf(A3CliCod), A11MegCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("MotivoEgreso");
         pr_default.readNext(10);
      }
      pr_default.close(10);
      if ( AV29GXLvl55 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "none4", "")) ;
      }
      AV30GXLvl63 = (byte)(0) ;
      /* Using cursor P022B14 */
      pr_default.execute(12);
      while ( (pr_default.getStatus(12) != 101) )
      {
         A1152ARTNom = P022B14_A1152ARTNom[0] ;
         A1151ARTSec = P022B14_A1151ARTSec[0] ;
         AV30GXLvl63 = (byte)(1) ;
         GXv_char1[0] = AV17ARTNom ;
         new web.capitalizartexto(remoteHandle, context).execute( A1152ARTNom, GXv_char1) ;
         capitalizardescripciones.this.AV17ARTNom = GXv_char1[0] ;
         A1152ARTNom = GXutil.trim( AV17ARTNom) ;
         /* Using cursor P022B15 */
         pr_default.execute(13, new Object[] {A1152ARTNom, Short.valueOf(A1151ARTSec)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("ART");
         pr_default.readNext(12);
      }
      pr_default.close(12);
      if ( AV30GXLvl63 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "none4", "")) ;
      }
      AV31GXLvl71 = (byte)(0) ;
      /* Using cursor P022B16 */
      pr_default.execute(14);
      while ( (pr_default.getStatus(14) != 101) )
      {
         A144CondiDescri = P022B16_A144CondiDescri[0] ;
         A17CondiCodigo = P022B16_A17CondiCodigo[0] ;
         AV31GXLvl71 = (byte)(1) ;
         GXv_char1[0] = AV20CondiDescri ;
         new web.capitalizartexto(remoteHandle, context).execute( A144CondiDescri, GXv_char1) ;
         capitalizardescripciones.this.AV20CondiDescri = GXv_char1[0] ;
         A144CondiDescri = GXutil.trim( AV20CondiDescri) ;
         /* Using cursor P022B17 */
         pr_default.execute(15, new Object[] {A144CondiDescri, Short.valueOf(A17CondiCodigo)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("CondicionAFIP");
         pr_default.readNext(14);
      }
      pr_default.close(14);
      if ( AV31GXLvl71 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV23Pgmname, httpContext.getMessage( "none5", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "capitalizardescripciones");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV23Pgmname = "" ;
      scmdbuf = "" ;
      P022B2_A3CliCod = new int[1] ;
      P022B2_A41ConDescrip = new String[] {""} ;
      P022B2_A26ConCodigo = new String[] {""} ;
      A41ConDescrip = "" ;
      A26ConCodigo = "" ;
      AV10ConDescrip = "" ;
      P022B4_A160ConveDescri = new String[] {""} ;
      P022B4_A46PaiCod = new short[1] ;
      P022B4_A9ConveCodigo = new String[] {""} ;
      A160ConveDescri = "" ;
      A9ConveCodigo = "" ;
      AV12ConveDescri = "" ;
      P022B6_A123CatDescrip = new String[] {""} ;
      P022B6_A3CliCod = new int[1] ;
      P022B6_A1564CliPaiConve = new short[1] ;
      P022B6_A1565CliConvenio = new String[] {""} ;
      P022B6_A8CatCodigo = new String[] {""} ;
      A123CatDescrip = "" ;
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      AV19CatDescrip = "" ;
      P022B8_A3CliCod = new int[1] ;
      P022B8_A307OsoDescrip = new String[] {""} ;
      P022B8_A5OsoCod = new String[] {""} ;
      A307OsoDescrip = "" ;
      A5OsoCod = "" ;
      AV14OsoDescrip = "" ;
      P022B10_A3CliCod = new int[1] ;
      P022B10_A329SecDescrip = new String[] {""} ;
      P022B10_A13SecCodigo = new String[] {""} ;
      A329SecDescrip = "" ;
      A13SecCodigo = "" ;
      AV15SecDescrip = "" ;
      P022B12_A3CliCod = new int[1] ;
      P022B12_A300MegDescrip = new String[] {""} ;
      P022B12_A11MegCodigo = new String[] {""} ;
      A300MegDescrip = "" ;
      A11MegCodigo = "" ;
      AV16MegDescrip = "" ;
      P022B14_A1152ARTNom = new String[] {""} ;
      P022B14_A1151ARTSec = new short[1] ;
      A1152ARTNom = "" ;
      AV17ARTNom = "" ;
      P022B16_A144CondiDescri = new String[] {""} ;
      P022B16_A17CondiCodigo = new short[1] ;
      A144CondiDescri = "" ;
      AV20CondiDescri = "" ;
      GXv_char1 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.capitalizardescripciones__default(),
         new Object[] {
             new Object[] {
            P022B2_A3CliCod, P022B2_A41ConDescrip, P022B2_A26ConCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            P022B4_A160ConveDescri, P022B4_A46PaiCod, P022B4_A9ConveCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            P022B6_A123CatDescrip, P022B6_A3CliCod, P022B6_A1564CliPaiConve, P022B6_A1565CliConvenio, P022B6_A8CatCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            P022B8_A3CliCod, P022B8_A307OsoDescrip, P022B8_A5OsoCod
            }
            , new Object[] {
            }
            , new Object[] {
            P022B10_A3CliCod, P022B10_A329SecDescrip, P022B10_A13SecCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            P022B12_A3CliCod, P022B12_A300MegDescrip, P022B12_A11MegCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            P022B14_A1152ARTNom, P022B14_A1151ARTSec
            }
            , new Object[] {
            }
            , new Object[] {
            P022B16_A144CondiDescri, P022B16_A17CondiCodigo
            }
            , new Object[] {
            }
         }
      );
      AV23Pgmname = "CapitalizarDescripciones" ;
      /* GeneXus formulas. */
      AV23Pgmname = "CapitalizarDescripciones" ;
      Gx_err = (short)(0) ;
   }

   private byte AV24GXLvl2 ;
   private byte AV25GXLvl13 ;
   private byte AV26GXLvl21 ;
   private byte AV27GXLvl38 ;
   private byte AV28GXLvl47 ;
   private byte AV29GXLvl55 ;
   private byte AV30GXLvl63 ;
   private byte AV31GXLvl71 ;
   private short A46PaiCod ;
   private short A1564CliPaiConve ;
   private short A1151ARTSec ;
   private short A17CondiCodigo ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String AV23Pgmname ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A9ConveCodigo ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private String A5OsoCod ;
   private String A13SecCodigo ;
   private String A11MegCodigo ;
   private String GXv_char1[] ;
   private String A41ConDescrip ;
   private String AV10ConDescrip ;
   private String A160ConveDescri ;
   private String AV12ConveDescri ;
   private String A123CatDescrip ;
   private String AV19CatDescrip ;
   private String A307OsoDescrip ;
   private String AV14OsoDescrip ;
   private String A329SecDescrip ;
   private String AV15SecDescrip ;
   private String A300MegDescrip ;
   private String AV16MegDescrip ;
   private String A1152ARTNom ;
   private String AV17ARTNom ;
   private String A144CondiDescri ;
   private String AV20CondiDescri ;
   private IDataStoreProvider pr_default ;
   private int[] P022B2_A3CliCod ;
   private String[] P022B2_A41ConDescrip ;
   private String[] P022B2_A26ConCodigo ;
   private String[] P022B4_A160ConveDescri ;
   private short[] P022B4_A46PaiCod ;
   private String[] P022B4_A9ConveCodigo ;
   private String[] P022B6_A123CatDescrip ;
   private int[] P022B6_A3CliCod ;
   private short[] P022B6_A1564CliPaiConve ;
   private String[] P022B6_A1565CliConvenio ;
   private String[] P022B6_A8CatCodigo ;
   private int[] P022B8_A3CliCod ;
   private String[] P022B8_A307OsoDescrip ;
   private String[] P022B8_A5OsoCod ;
   private int[] P022B10_A3CliCod ;
   private String[] P022B10_A329SecDescrip ;
   private String[] P022B10_A13SecCodigo ;
   private int[] P022B12_A3CliCod ;
   private String[] P022B12_A300MegDescrip ;
   private String[] P022B12_A11MegCodigo ;
   private String[] P022B14_A1152ARTNom ;
   private short[] P022B14_A1151ARTSec ;
   private String[] P022B16_A144CondiDescri ;
   private short[] P022B16_A17CondiCodigo ;
}

final  class capitalizardescripciones__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P022B2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV8CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int2 = new byte[1];
      Object[] GXv_Object3 = new Object[2];
      scmdbuf = "SELECT CliCod, ConDescrip, ConCodigo FROM Concepto" ;
      if ( ! (0==AV8CliCod) )
      {
         addWhere(sWhereString, "(CliCod = ?)");
      }
      else
      {
         GXv_int2[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, ConCodigo" ;
      scmdbuf += " FOR UPDATE OF Concepto" ;
      GXv_Object3[0] = scmdbuf ;
      GXv_Object3[1] = GXv_int2 ;
      return GXv_Object3 ;
   }

   protected Object[] conditional_P022B8( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV8CliCod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[1];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT CliCod, OsoDescrip, OsoCod FROM ObraSocial" ;
      if ( ! (0==AV8CliCod) )
      {
         addWhere(sWhereString, "(CliCod = ?)");
      }
      else
      {
         GXv_int4[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, OsoCod" ;
      scmdbuf += " FOR UPDATE OF ObraSocial" ;
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
   }

   protected Object[] conditional_P022B10( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           int AV8CliCod ,
                                           int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int6 = new byte[1];
      Object[] GXv_Object7 = new Object[2];
      scmdbuf = "SELECT CliCod, SecDescrip, SecCodigo FROM Seccion" ;
      if ( ! (0==AV8CliCod) )
      {
         addWhere(sWhereString, "(CliCod = ?)");
      }
      else
      {
         GXv_int6[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, SecCodigo" ;
      scmdbuf += " FOR UPDATE OF Seccion" ;
      GXv_Object7[0] = scmdbuf ;
      GXv_Object7[1] = GXv_int6 ;
      return GXv_Object7 ;
   }

   protected Object[] conditional_P022B12( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           int AV8CliCod ,
                                           int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int8 = new byte[1];
      Object[] GXv_Object9 = new Object[2];
      scmdbuf = "SELECT CliCod, MegDescrip, MegCodigo FROM MotivoEgreso" ;
      if ( ! (0==AV8CliCod) )
      {
         addWhere(sWhereString, "(CliCod = ?)");
      }
      else
      {
         GXv_int8[0] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, MegCodigo" ;
      scmdbuf += " FOR UPDATE OF MotivoEgreso" ;
      GXv_Object9[0] = scmdbuf ;
      GXv_Object9[1] = GXv_int8 ;
      return GXv_Object9 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_P022B2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() );
            case 6 :
                  return conditional_P022B8(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() );
            case 8 :
                  return conditional_P022B10(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() );
            case 10 :
                  return conditional_P022B12(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P022B2", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P022B3", "SAVEPOINT gxupdate;UPDATE Concepto SET ConDescrip=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P022B4", "SELECT ConveDescri, PaiCod, ConveCodigo FROM Convenio ORDER BY PaiCod, ConveCodigo  FOR UPDATE OF Convenio",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P022B5", "SAVEPOINT gxupdate;UPDATE Convenio SET ConveDescri=?  WHERE PaiCod = ? AND ConveCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P022B6", "SELECT CatDescrip, CliCod, CliPaiConve, CliConvenio, CatCodigo FROM Categoria1 ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo  FOR UPDATE OF Categoria1",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P022B7", "SAVEPOINT gxupdate;UPDATE Categoria1 SET CatDescrip=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P022B8", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P022B9", "SAVEPOINT gxupdate;UPDATE ObraSocial SET OsoDescrip=?  WHERE CliCod = ? AND OsoCod = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P022B10", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P022B11", "SAVEPOINT gxupdate;UPDATE Seccion SET SecDescrip=?  WHERE CliCod = ? AND SecCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P022B12", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P022B13", "SAVEPOINT gxupdate;UPDATE MotivoEgreso SET MegDescrip=?  WHERE CliCod = ? AND MegCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P022B14", "SELECT ARTNom, ARTSec FROM ART ORDER BY ARTSec  FOR UPDATE OF ART",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P022B15", "SAVEPOINT gxupdate;UPDATE ART SET ARTNom=?  WHERE ARTSec = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P022B16", "SELECT CondiDescri, CondiCodigo FROM CondicionAFIP ORDER BY CondiCodigo  FOR UPDATE OF CondicionAFIP",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P022B17", "SAVEPOINT gxupdate;UPDATE CondicionAFIP SET CondiDescri=?  WHERE CondiCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 20);
               ((String[]) buf[4])[0] = rslt.getString(5, 40);
               return;
            case 6 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 8 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               return;
            case 12 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 14 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[1]).intValue());
               }
               return;
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
            case 3 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 5 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 20);
               stmt.setString(5, (String)parms[4], 40);
               return;
            case 6 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[1]).intValue());
               }
               return;
            case 7 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 8 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[1]).intValue());
               }
               return;
            case 9 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 10 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[1]).intValue());
               }
               return;
            case 11 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 20);
               return;
            case 13 :
               stmt.setVarchar(1, (String)parms[0], 400, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 15 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

