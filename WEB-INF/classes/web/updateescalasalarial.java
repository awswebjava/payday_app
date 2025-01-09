package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class updateescalasalarial extends GXProcedure
{
   public updateescalasalarial( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( updateescalasalarial.class ), "" );
   }

   public updateescalasalarial( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( long aP0 ,
                        int aP1 ,
                        int aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( long aP0 ,
                             int aP1 ,
                             int aP2 )
   {
      updateescalasalarial.this.AV16ClientePadre = aP0;
      updateescalasalarial.this.AV14CliCod = aP1;
      updateescalasalarial.this.AV19CliRelSec = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV23padreReleaseDateTime ;
      new web.getreleasedatetime(remoteHandle, context).execute( (int)(AV16ClientePadre), AV19CliRelSec, GXv_dtime1) ;
      updateescalasalarial.this.AV23padreReleaseDateTime = GXv_dtime1[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "1 &ClientePadre ", "")+GXutil.trim( GXutil.str( AV16ClientePadre, 12, 0))+httpContext.getMessage( " &CliRelSec ", "")+GXutil.trim( GXutil.str( AV19CliRelSec, 6, 0))) ;
      AV31GXLvl4 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Integer.valueOf(AV19CliRelSec) ,
                                           Integer.valueOf(A1891CatSalRelSec) ,
                                           Long.valueOf(AV16ClientePadre) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.LONG, TypeConstants.INT
                                           }
      });
      /* Using cursor P01RE2 */
      pr_default.execute(0, new Object[] {Long.valueOf(AV16ClientePadre), Integer.valueOf(AV19CliRelSec)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1891CatSalRelSec = P01RE2_A1891CatSalRelSec[0] ;
         n1891CatSalRelSec = P01RE2_n1891CatSalRelSec[0] ;
         A3CliCod = P01RE2_A3CliCod[0] ;
         A1564CliPaiConve = P01RE2_A1564CliPaiConve[0] ;
         A1565CliConvenio = P01RE2_A1565CliConvenio[0] ;
         A8CatCodigo = P01RE2_A8CatCodigo[0] ;
         A907CatVigencia = P01RE2_A907CatVigencia[0] ;
         A1892EscBasico = P01RE2_A1892EscBasico[0] ;
         A1893EscAdicional = P01RE2_A1893EscAdicional[0] ;
         AV31GXLvl4 = (byte)(1) ;
         GXv_boolean2[0] = AV27clienteConvenioTiene ;
         new web.clientetieneconvenio(remoteHandle, context).execute( AV14CliCod, A1564CliPaiConve, A1565CliConvenio, GXv_boolean2) ;
         updateescalasalarial.this.AV27clienteConvenioTiene = GXv_boolean2[0] ;
         if ( AV27clienteConvenioTiene )
         {
            AV22itemEscalaSal = (web.Sdtsdt_escalaSalarial_sdt_escalaSalarialItem)new web.Sdtsdt_escalaSalarial_sdt_escalaSalarialItem(remoteHandle, context);
            AV22itemEscalaSal.setgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Cliconvenio( A1565CliConvenio );
            AV22itemEscalaSal.setgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Clipaiconve( A1564CliPaiConve );
            AV22itemEscalaSal.setgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catcodigo( A8CatCodigo );
            AV22itemEscalaSal.setgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia( A907CatVigencia );
            AV22itemEscalaSal.setgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escbasico( A1892EscBasico );
            AV22itemEscalaSal.setgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escadicional( A1893EscAdicional );
            AV24sdt_escalaSalarial.add(AV22itemEscalaSal, 0);
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV31GXLvl4 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "noene 1", "")) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV14CliCod, 6, 0))) ;
      if ( AV24sdt_escalaSalarial.size() > 0 )
      {
         AV32GXLvl32 = (byte)(0) ;
         /* Using cursor P01RE3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV14CliCod)});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A3CliCod = P01RE3_A3CliCod[0] ;
            AV32GXLvl32 = (byte)(1) ;
            AV20hijoCliCod = A3CliCod ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, "2") ;
            AV33GXV1 = 1 ;
            while ( AV33GXV1 <= AV24sdt_escalaSalarial.size() )
            {
               AV22itemEscalaSal = (web.Sdtsdt_escalaSalarial_sdt_escalaSalarialItem)((web.Sdtsdt_escalaSalarial_sdt_escalaSalarialItem)AV24sdt_escalaSalarial.elementAt(-1+AV33GXV1));
               AV11CatCodigo = AV22itemEscalaSal.getgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catcodigo() ;
               AV13CatVigencia = AV22itemEscalaSal.getgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Catvigencia() ;
               AV15CliConvenio = AV22itemEscalaSal.getgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Cliconvenio() ;
               AV18CliPaiConve = AV22itemEscalaSal.getgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Clipaiconve() ;
               AV25EscBasico = AV22itemEscalaSal.getgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escbasico() ;
               AV26EscAdicional = AV22itemEscalaSal.getgxTv_Sdtsdt_escalaSalarial_sdt_escalaSalarialItem_Escadicional() ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, "3") ;
               /* Execute user subroutine: 'HIJO' */
               S111 ();
               if ( returnInSub )
               {
                  pr_default.close(1);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV33GXV1 = (int)(AV33GXV1+1) ;
            }
            if ( ! (0==AV19CliRelSec) )
            {
               new web.setlegrecalcularliq(remoteHandle, context).execute( A3CliCod, (short)(0), 0, true) ;
            }
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(1);
         if ( AV32GXLvl32 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, httpContext.getMessage( "none 2", "")) ;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'HIJO' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, "4") ;
      AV34GXLvl64 = (byte)(0) ;
      /* Using cursor P01RE4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV20hijoCliCod), Short.valueOf(AV18CliPaiConve), AV15CliConvenio, AV11CatCodigo, AV13CatVigencia});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A907CatVigencia = P01RE4_A907CatVigencia[0] ;
         A8CatCodigo = P01RE4_A8CatCodigo[0] ;
         A1565CliConvenio = P01RE4_A1565CliConvenio[0] ;
         A1564CliPaiConve = P01RE4_A1564CliPaiConve[0] ;
         A3CliCod = P01RE4_A3CliCod[0] ;
         A1891CatSalRelSec = P01RE4_A1891CatSalRelSec[0] ;
         n1891CatSalRelSec = P01RE4_n1891CatSalRelSec[0] ;
         A1892EscBasico = P01RE4_A1892EscBasico[0] ;
         A1893EscAdicional = P01RE4_A1893EscAdicional[0] ;
         AV34GXLvl64 = (byte)(1) ;
         GXv_dtime1[0] = AV21hijoReleaseDateTime ;
         new web.getreleasedatetime(remoteHandle, context).execute( A3CliCod, A1891CatSalRelSec, GXv_dtime1) ;
         updateescalasalarial.this.AV21hijoReleaseDateTime = GXv_dtime1[0] ;
         if ( AV23padreReleaseDateTime.after( AV21hijoReleaseDateTime ) )
         {
            A1891CatSalRelSec = AV19CliRelSec ;
            n1891CatSalRelSec = false ;
            A1892EscBasico = AV25EscBasico ;
            A1893EscAdicional = AV26EscAdicional ;
         }
         /* Using cursor P01RE5 */
         pr_default.execute(3, new Object[] {Boolean.valueOf(n1891CatSalRelSec), Integer.valueOf(A1891CatSalRelSec), A1892EscBasico, A1893EscAdicional, Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A907CatVigencia});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoriavalores1");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(2);
      if ( AV34GXLvl64 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV30Pgmname, "5") ;
         new web.newescalasalarial(remoteHandle, context).execute( AV20hijoCliCod, AV18CliPaiConve, AV15CliConvenio, AV11CatCodigo, AV13CatVigencia, AV25EscBasico, AV26EscAdicional, AV19CliRelSec) ;
      }
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "updateescalasalarial");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV23padreReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      AV30Pgmname = "" ;
      scmdbuf = "" ;
      P01RE2_A1891CatSalRelSec = new int[1] ;
      P01RE2_n1891CatSalRelSec = new boolean[] {false} ;
      P01RE2_A3CliCod = new int[1] ;
      P01RE2_A1564CliPaiConve = new short[1] ;
      P01RE2_A1565CliConvenio = new String[] {""} ;
      P01RE2_A8CatCodigo = new String[] {""} ;
      P01RE2_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      P01RE2_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RE2_A1893EscAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      A907CatVigencia = GXutil.nullDate() ;
      A1892EscBasico = DecimalUtil.ZERO ;
      A1893EscAdicional = DecimalUtil.ZERO ;
      GXv_boolean2 = new boolean[1] ;
      AV22itemEscalaSal = new web.Sdtsdt_escalaSalarial_sdt_escalaSalarialItem(remoteHandle, context);
      AV24sdt_escalaSalarial = new GXBaseCollection<web.Sdtsdt_escalaSalarial_sdt_escalaSalarialItem>(web.Sdtsdt_escalaSalarial_sdt_escalaSalarialItem.class, "sdt_escalaSalarialItem", "PayDay", remoteHandle);
      P01RE3_A3CliCod = new int[1] ;
      AV11CatCodigo = "" ;
      AV13CatVigencia = GXutil.nullDate() ;
      AV15CliConvenio = "" ;
      AV25EscBasico = DecimalUtil.ZERO ;
      AV26EscAdicional = DecimalUtil.ZERO ;
      P01RE4_A907CatVigencia = new java.util.Date[] {GXutil.nullDate()} ;
      P01RE4_A8CatCodigo = new String[] {""} ;
      P01RE4_A1565CliConvenio = new String[] {""} ;
      P01RE4_A1564CliPaiConve = new short[1] ;
      P01RE4_A3CliCod = new int[1] ;
      P01RE4_A1891CatSalRelSec = new int[1] ;
      P01RE4_n1891CatSalRelSec = new boolean[] {false} ;
      P01RE4_A1892EscBasico = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01RE4_A1893EscAdicional = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      AV21hijoReleaseDateTime = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.updateescalasalarial__default(),
         new Object[] {
             new Object[] {
            P01RE2_A1891CatSalRelSec, P01RE2_n1891CatSalRelSec, P01RE2_A3CliCod, P01RE2_A1564CliPaiConve, P01RE2_A1565CliConvenio, P01RE2_A8CatCodigo, P01RE2_A907CatVigencia, P01RE2_A1892EscBasico, P01RE2_A1893EscAdicional
            }
            , new Object[] {
            P01RE3_A3CliCod
            }
            , new Object[] {
            P01RE4_A907CatVigencia, P01RE4_A8CatCodigo, P01RE4_A1565CliConvenio, P01RE4_A1564CliPaiConve, P01RE4_A3CliCod, P01RE4_A1891CatSalRelSec, P01RE4_n1891CatSalRelSec, P01RE4_A1892EscBasico, P01RE4_A1893EscAdicional
            }
            , new Object[] {
            }
         }
      );
      AV30Pgmname = "updateEscalaSalarial" ;
      /* GeneXus formulas. */
      AV30Pgmname = "updateEscalaSalarial" ;
      Gx_err = (short)(0) ;
   }

   private byte AV31GXLvl4 ;
   private byte AV32GXLvl32 ;
   private byte AV34GXLvl64 ;
   private short A1564CliPaiConve ;
   private short AV18CliPaiConve ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int AV19CliRelSec ;
   private int A1891CatSalRelSec ;
   private int A3CliCod ;
   private int AV20hijoCliCod ;
   private int AV33GXV1 ;
   private long AV16ClientePadre ;
   private java.math.BigDecimal A1892EscBasico ;
   private java.math.BigDecimal A1893EscAdicional ;
   private java.math.BigDecimal AV25EscBasico ;
   private java.math.BigDecimal AV26EscAdicional ;
   private String AV30Pgmname ;
   private String scmdbuf ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private String AV11CatCodigo ;
   private String AV15CliConvenio ;
   private java.util.Date AV23padreReleaseDateTime ;
   private java.util.Date AV21hijoReleaseDateTime ;
   private java.util.Date GXv_dtime1[] ;
   private java.util.Date A907CatVigencia ;
   private java.util.Date AV13CatVigencia ;
   private boolean n1891CatSalRelSec ;
   private boolean AV27clienteConvenioTiene ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private IDataStoreProvider pr_default ;
   private int[] P01RE2_A1891CatSalRelSec ;
   private boolean[] P01RE2_n1891CatSalRelSec ;
   private int[] P01RE2_A3CliCod ;
   private short[] P01RE2_A1564CliPaiConve ;
   private String[] P01RE2_A1565CliConvenio ;
   private String[] P01RE2_A8CatCodigo ;
   private java.util.Date[] P01RE2_A907CatVigencia ;
   private java.math.BigDecimal[] P01RE2_A1892EscBasico ;
   private java.math.BigDecimal[] P01RE2_A1893EscAdicional ;
   private int[] P01RE3_A3CliCod ;
   private java.util.Date[] P01RE4_A907CatVigencia ;
   private String[] P01RE4_A8CatCodigo ;
   private String[] P01RE4_A1565CliConvenio ;
   private short[] P01RE4_A1564CliPaiConve ;
   private int[] P01RE4_A3CliCod ;
   private int[] P01RE4_A1891CatSalRelSec ;
   private boolean[] P01RE4_n1891CatSalRelSec ;
   private java.math.BigDecimal[] P01RE4_A1892EscBasico ;
   private java.math.BigDecimal[] P01RE4_A1893EscAdicional ;
   private GXBaseCollection<web.Sdtsdt_escalaSalarial_sdt_escalaSalarialItem> AV24sdt_escalaSalarial ;
   private web.Sdtsdt_escalaSalarial_sdt_escalaSalarialItem AV22itemEscalaSal ;
}

final  class updateescalasalarial__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01RE2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          int AV19CliRelSec ,
                                          int A1891CatSalRelSec ,
                                          long AV16ClientePadre ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[2];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT CatSalRelSec, CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia, EscBasico, EscAdicional FROM Categoriavalores1" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (0==AV19CliRelSec) )
      {
         addWhere(sWhereString, "(CatSalRelSec = ?)");
      }
      else
      {
         GXv_int3[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod" ;
      GXv_Object4[0] = scmdbuf ;
      GXv_Object4[1] = GXv_int3 ;
      return GXv_Object4 ;
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
                  return conditional_P01RE2(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , ((Number) dynConstraints[1]).intValue() , ((Number) dynConstraints[2]).longValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01RE2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01RE3", "SELECT CliCod FROM Cliente WHERE CliCod = ? ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P01RE4", "SELECT CatVigencia, CatCodigo, CliConvenio, CliPaiConve, CliCod, CatSalRelSec, EscBasico, EscAdicional FROM Categoriavalores1 WHERE CliCod = ? and CliPaiConve = ? and CliConvenio = ( ?) and CatCodigo = ( ?) and CatVigencia = ? ORDER BY CliCod, CliPaiConve, CliConvenio, CatCodigo, CatVigencia  FOR UPDATE OF Categoriavalores1",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P01RE5", "SAVEPOINT gxupdate;UPDATE Categoriavalores1 SET CatSalRelSec=?, EscBasico=?, EscAdicional=?  WHERE CliCod = ? AND CliPaiConve = ? AND CliConvenio = ? AND CatCodigo = ? AND CatVigencia = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((String[]) buf[5])[0] = rslt.getString(5, 40);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(6);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               return;
            case 2 :
               ((java.util.Date[]) buf[0])[0] = rslt.getGXDate(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 40);
               ((String[]) buf[2])[0] = rslt.getString(3, 20);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
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
                  stmt.setLong(sIdx, ((Number) parms[2]).longValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setDate(5, (java.util.Date)parms[4]);
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(1, ((Number) parms[1]).intValue());
               }
               stmt.setBigDecimal(2, (java.math.BigDecimal)parms[2], 2);
               stmt.setBigDecimal(3, (java.math.BigDecimal)parms[3], 2);
               stmt.setInt(4, ((Number) parms[4]).intValue());
               stmt.setShort(5, ((Number) parms[5]).shortValue());
               stmt.setString(6, (String)parms[6], 20);
               stmt.setString(7, (String)parms[7], 40);
               stmt.setDate(8, (java.util.Date)parms[8]);
               return;
      }
   }

}

