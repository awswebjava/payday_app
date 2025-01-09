package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtsdt_concepto_sdt_conceptoItem extends GxUserType
{
   public Sdtsdt_concepto_sdt_conceptoItem( )
   {
      this(  new ModelContext(Sdtsdt_concepto_sdt_conceptoItem.class));
   }

   public Sdtsdt_concepto_sdt_conceptoItem( ModelContext context )
   {
      super( context, "Sdtsdt_concepto_sdt_conceptoItem");
   }

   public Sdtsdt_concepto_sdt_conceptoItem( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle, context, "Sdtsdt_concepto_sdt_conceptoItem");
   }

   public Sdtsdt_concepto_sdt_conceptoItem( StructSdtsdt_concepto_sdt_conceptoItem struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCodigo") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRangoCant") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrangocant = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConEdiEnRec") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conedienrec = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConUsado") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conusado = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "MotivosEgreso") )
            {
               if ( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso == null )
               {
                  gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso = new GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem>(web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem.class, "sdt_concepto.sdt_conceptoItem.MotEgrItem", "PayDay", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso.readxmlcollection(oReader, "MotivosEgreso", "MotEgrItem") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "MotivosEgreso") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRetGanPropor") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conretganpropor = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAplicGan") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conaplicgan = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRecalcular") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrecalcular = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConDescrip") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConHabilitado") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conhabilitado = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTipo") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConOrden") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conorden = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCanti") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concanti = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConValUni") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convaluni = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConImporte") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conimporte = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConVigencia") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convigencia = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFormula") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConValorGen") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convalorgen = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFormulaAmigable") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaamigable = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTipoLiqGanancias") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoliqganancias = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConObservacion") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobservacion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFormulaObs2") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaobs2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConVariable") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convariable = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConForEditable") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conforeditable = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConSegunPla") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consegunpla = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoLiquidacion") )
            {
               if ( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion == null )
               {
                  gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion = new GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem>(web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem.class, "sdt_concepto.sdt_conceptoItem.TipoLiquidacionItem", "PayDay", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion.readxmlcollection(oReader, "TipoLiquidacion", "TipoLiquidacionItem") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "TipoLiquidacion") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TipoConCod") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SubTipoConCod1") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "SubTipoConCod2") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2 = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFormulaExpl") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaexpl = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTipoOrden") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoorden = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConOrdEjec") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conordejec = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConObliga") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobliga = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConObligaSiSac") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobligasisac = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCondicion") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondicion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCondCodigo") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondcodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConPrereq") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conprereq = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Convenios") )
            {
               if ( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios == null )
               {
                  gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios = new GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem>(web.Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem.class, "sdt_concepto.sdt_conceptoItem.ConveniosItem", "PayDay", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios.readxmlcollection(oReader, "Convenios", "ConveniosItem") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "Convenios") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConMostrarPos") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conmostrarpos = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAdelDescu") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conadeldescu = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AplIIGG") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Apliigg = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConNumero") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Connumero = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConSIPAApo") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipaapo = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConSIPACont") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipacont = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConINSSJyPApo") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypapo = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConINSSJyPCont") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypcont = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConObraSocApo") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasocapo = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConObraSocCont") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasoccont = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFonSolRedApo") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredapo = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFonSolRedCont") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredcont = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRenateaApo") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateaapo = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRenateaCont") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateacont = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConAsigFamCont") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conasigfamcont = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConFonNacEmpCont") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonnacempcont = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConLeyRieTrabCont") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conleyrietrabcont = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRegDifApo") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregdifapo = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRegEspApo") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregespapo = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConSacDeven") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consacdeven = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseFer") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasefer = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseFerProm") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseferprom = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseHorExt") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorext = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseHorExtProm") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorextprom = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseLic") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselic = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseLicProm") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselicprom = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseOSDif") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseosdif = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseAus") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseaus = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseAusProm") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseausprom = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConCodAfip") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodafip = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConceptoPais") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptopais = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConceptoConveCodigo") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptoconvecodigo = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBasePres") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasepres = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConBaseAnt") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseant = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConErrorSiCero") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conerrorsicero = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CliCod") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConPueNov") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conpuenov = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConRelSec") )
            {
               gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrelsec = (int)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "sdt_concepto.sdt_conceptoItem" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("ConCodigo", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConRangoCant", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrangocant);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConEdiEnRec", GXutil.booltostr( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conedienrec));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConUsado", GXutil.booltostr( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conusado));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso.writexmlcollection(oWriter, "MotivosEgreso", sNameSpace1, "MotEgrItem", sNameSpace1);
      }
      oWriter.writeElement("ConRetGanPropor", GXutil.booltostr( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conretganpropor));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAplicGan", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conaplicgan, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConRecalcular", GXutil.booltostr( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrecalcular));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConDescrip", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConHabilitado", GXutil.booltostr( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conhabilitado));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConTipo", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConOrden", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conorden, 8, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConCanti", GXutil.booltostr( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concanti));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConValUni", GXutil.booltostr( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convaluni));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConImporte", GXutil.booltostr( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conimporte));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConVigencia", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convigencia, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConFormula", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConValorGen", GXutil.trim( GXutil.strNoRound( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convalorgen, 14, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConFormulaAmigable", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaamigable, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConTipoLiqGanancias", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoliqganancias);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConObservacion", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobservacion);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConFormulaObs2", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaobs2);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConVariable", GXutil.booltostr( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convariable));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConForEditable", GXutil.booltostr( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conforeditable));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConSegunPla", GXutil.booltostr( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consegunpla));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion.writexmlcollection(oWriter, "TipoLiquidacion", sNameSpace1, "TipoLiquidacionItem", sNameSpace1);
      }
      oWriter.writeElement("TipoConCod", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SubTipoConCod1", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("SubTipoConCod2", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConFormulaExpl", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaexpl);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConTipoOrden", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoorden, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConOrdEjec", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conordejec, 12, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConObliga", GXutil.booltostr( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobliga));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConObligaSiSac", GXutil.booltostr( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobligasisac));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConCondicion", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondicion);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConCondCodigo", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondcodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConPrereq", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conprereq);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "PayDay") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "PayDay" ;
         }
         else
         {
            sNameSpace1 = "PayDay" ;
         }
         gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios.writexmlcollection(oWriter, "Convenios", sNameSpace1, "ConveniosItem", sNameSpace1);
      }
      oWriter.writeElement("ConMostrarPos", GXutil.booltostr( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conmostrarpos));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAdelDescu", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conadeldescu, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("AplIIGG", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Apliigg, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConNumero", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Connumero, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConSIPAApo", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipaapo, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConSIPACont", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipacont, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConINSSJyPApo", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypapo, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConINSSJyPCont", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypcont, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConObraSocApo", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasocapo, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConObraSocCont", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasoccont, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConFonSolRedApo", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredapo, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConFonSolRedCont", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredcont, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConRenateaApo", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateaapo, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConRenateaCont", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateacont, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConAsigFamCont", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conasigfamcont, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConFonNacEmpCont", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonnacempcont, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConLeyRieTrabCont", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conleyrietrabcont, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConRegDifApo", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregdifapo, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConRegEspApo", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregespapo, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConSacDeven", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consacdeven, 2, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseFer", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasefer, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseFerProm", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseferprom, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseHorExt", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorext, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseHorExtProm", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorextprom, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseLic", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselic, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseLicProm", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselicprom, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseOSDif", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseosdif, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseAus", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseaus, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseAusProm", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseausprom, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConCodAfip", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodafip);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConceptoPais", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptopais, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConceptoConveCodigo", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptoconvecodigo);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBasePres", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasepres, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConBaseAnt", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseant, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConErrorSiCero", GXutil.booltostr( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conerrorsicero));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CliCod", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConPueNov", GXutil.booltostr( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conpuenov));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConRelSec", GXutil.trim( GXutil.str( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrelsec, 6, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("ConCodigo", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo, false, false);
      AddObjectProperty("ConRangoCant", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrangocant, false, false);
      AddObjectProperty("ConEdiEnRec", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conedienrec, false, false);
      AddObjectProperty("ConUsado", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conusado, false, false);
      if ( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso != null )
      {
         AddObjectProperty("MotivosEgreso", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso, false, false);
      }
      AddObjectProperty("ConRetGanPropor", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conretganpropor, false, false);
      AddObjectProperty("ConAplicGan", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conaplicgan, false, false);
      AddObjectProperty("ConRecalcular", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrecalcular, false, false);
      AddObjectProperty("ConDescrip", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip, false, false);
      AddObjectProperty("ConHabilitado", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conhabilitado, false, false);
      AddObjectProperty("ConTipo", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo, false, false);
      AddObjectProperty("ConOrden", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conorden, false, false);
      AddObjectProperty("ConCanti", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concanti, false, false);
      AddObjectProperty("ConValUni", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convaluni, false, false);
      AddObjectProperty("ConImporte", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conimporte, false, false);
      AddObjectProperty("ConVigencia", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convigencia, false, false);
      AddObjectProperty("ConFormula", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula, false, false);
      AddObjectProperty("ConValorGen", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convalorgen, false, false);
      AddObjectProperty("ConFormulaAmigable", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaamigable, false, false);
      AddObjectProperty("ConTipoLiqGanancias", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoliqganancias, false, false);
      AddObjectProperty("ConObservacion", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobservacion, false, false);
      AddObjectProperty("ConFormulaObs2", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaobs2, false, false);
      AddObjectProperty("ConVariable", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convariable, false, false);
      AddObjectProperty("ConForEditable", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conforeditable, false, false);
      AddObjectProperty("ConSegunPla", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consegunpla, false, false);
      if ( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion != null )
      {
         AddObjectProperty("TipoLiquidacion", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion, false, false);
      }
      AddObjectProperty("TipoConCod", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod, false, false);
      AddObjectProperty("SubTipoConCod1", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1, false, false);
      AddObjectProperty("SubTipoConCod2", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2, false, false);
      AddObjectProperty("ConFormulaExpl", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaexpl, false, false);
      AddObjectProperty("ConTipoOrden", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoorden, false, false);
      AddObjectProperty("ConOrdEjec", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conordejec, false, false);
      AddObjectProperty("ConObliga", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobliga, false, false);
      AddObjectProperty("ConObligaSiSac", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobligasisac, false, false);
      AddObjectProperty("ConCondicion", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondicion, false, false);
      AddObjectProperty("ConCondCodigo", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondcodigo, false, false);
      AddObjectProperty("ConPrereq", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conprereq, false, false);
      if ( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios != null )
      {
         AddObjectProperty("Convenios", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios, false, false);
      }
      AddObjectProperty("ConMostrarPos", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conmostrarpos, false, false);
      AddObjectProperty("ConAdelDescu", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conadeldescu, false, false);
      AddObjectProperty("AplIIGG", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Apliigg, false, false);
      AddObjectProperty("ConNumero", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Connumero, false, false);
      AddObjectProperty("ConSIPAApo", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipaapo, false, false);
      AddObjectProperty("ConSIPACont", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipacont, false, false);
      AddObjectProperty("ConINSSJyPApo", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypapo, false, false);
      AddObjectProperty("ConINSSJyPCont", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypcont, false, false);
      AddObjectProperty("ConObraSocApo", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasocapo, false, false);
      AddObjectProperty("ConObraSocCont", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasoccont, false, false);
      AddObjectProperty("ConFonSolRedApo", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredapo, false, false);
      AddObjectProperty("ConFonSolRedCont", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredcont, false, false);
      AddObjectProperty("ConRenateaApo", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateaapo, false, false);
      AddObjectProperty("ConRenateaCont", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateacont, false, false);
      AddObjectProperty("ConAsigFamCont", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conasigfamcont, false, false);
      AddObjectProperty("ConFonNacEmpCont", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonnacempcont, false, false);
      AddObjectProperty("ConLeyRieTrabCont", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conleyrietrabcont, false, false);
      AddObjectProperty("ConRegDifApo", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregdifapo, false, false);
      AddObjectProperty("ConRegEspApo", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregespapo, false, false);
      AddObjectProperty("ConSacDeven", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consacdeven, false, false);
      AddObjectProperty("ConBaseFer", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasefer, false, false);
      AddObjectProperty("ConBaseFerProm", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseferprom, false, false);
      AddObjectProperty("ConBaseHorExt", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorext, false, false);
      AddObjectProperty("ConBaseHorExtProm", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorextprom, false, false);
      AddObjectProperty("ConBaseLic", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselic, false, false);
      AddObjectProperty("ConBaseLicProm", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselicprom, false, false);
      AddObjectProperty("ConBaseOSDif", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseosdif, false, false);
      AddObjectProperty("ConBaseAus", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseaus, false, false);
      AddObjectProperty("ConBaseAusProm", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseausprom, false, false);
      AddObjectProperty("ConCodAfip", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodafip, false, false);
      AddObjectProperty("ConceptoPais", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptopais, false, false);
      AddObjectProperty("ConceptoConveCodigo", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptoconvecodigo, false, false);
      AddObjectProperty("ConBasePres", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasepres, false, false);
      AddObjectProperty("ConBaseAnt", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseant, false, false);
      AddObjectProperty("ConErrorSiCero", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conerrorsicero, false, false);
      AddObjectProperty("CliCod", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod, false, false);
      AddObjectProperty("ConPueNov", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conpuenov, false, false);
      AddObjectProperty("ConRelSec", gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrelsec, false, false);
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo = value ;
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrangocant( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrangocant ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrangocant( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrangocant = value ;
   }

   public boolean getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conedienrec( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conedienrec ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conedienrec( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conedienrec = value ;
   }

   public boolean getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conusado( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conusado ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conusado( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conusado = value ;
   }

   public GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem> getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso( )
   {
      if ( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso == null )
      {
         gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso = new GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem>(web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem.class, "sdt_concepto.sdt_conceptoItem.MotEgrItem", "PayDay", remoteHandle);
      }
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso( GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem> value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso = value ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso_SetNull( )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso_N = (byte)(1) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso = null ;
   }

   public boolean getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso_IsNull( )
   {
      if ( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso_N( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso_N ;
   }

   public boolean getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conretganpropor( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conretganpropor ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conretganpropor( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conretganpropor = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conaplicgan( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conaplicgan ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conaplicgan( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conaplicgan = value ;
   }

   public boolean getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrecalcular( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrecalcular ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrecalcular( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrecalcular = value ;
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip = value ;
   }

   public boolean getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conhabilitado( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conhabilitado ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conhabilitado( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conhabilitado = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo = value ;
   }

   public int getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conorden( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conorden ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conorden( int value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conorden = value ;
   }

   public boolean getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concanti( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concanti ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concanti( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concanti = value ;
   }

   public boolean getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convaluni( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convaluni ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convaluni( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convaluni = value ;
   }

   public boolean getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conimporte( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conimporte ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conimporte( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conimporte = value ;
   }

   public short getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convigencia( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convigencia ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convigencia( short value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convigencia = value ;
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convalorgen( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convalorgen ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convalorgen( java.math.BigDecimal value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convalorgen = value ;
   }

   public short getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaamigable( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaamigable ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaamigable( short value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaamigable = value ;
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoliqganancias( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoliqganancias ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoliqganancias( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoliqganancias = value ;
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobservacion( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobservacion ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobservacion( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobservacion = value ;
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaobs2( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaobs2 ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaobs2( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaobs2 = value ;
   }

   public boolean getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convariable( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convariable ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convariable( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convariable = value ;
   }

   public boolean getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conforeditable( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conforeditable ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conforeditable( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conforeditable = value ;
   }

   public boolean getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consegunpla( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consegunpla ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consegunpla( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consegunpla = value ;
   }

   public GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem> getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion( )
   {
      if ( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion == null )
      {
         gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion = new GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem>(web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem.class, "sdt_concepto.sdt_conceptoItem.TipoLiquidacionItem", "PayDay", remoteHandle);
      }
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion( GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem> value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion = value ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion_SetNull( )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion_N = (byte)(1) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion = null ;
   }

   public boolean getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion_IsNull( )
   {
      if ( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion_N( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion_N ;
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod = value ;
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1 ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1 = value ;
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2 ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2 = value ;
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaexpl( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaexpl ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaexpl( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaexpl = value ;
   }

   public short getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoorden( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoorden ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoorden( short value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoorden = value ;
   }

   public long getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conordejec( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conordejec ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conordejec( long value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conordejec = value ;
   }

   public boolean getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobliga( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobliga ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobliga( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobliga = value ;
   }

   public boolean getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobligasisac( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobligasisac ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobligasisac( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobligasisac = value ;
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondicion( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondicion ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondicion( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondicion = value ;
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondcodigo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondcodigo ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondcodigo( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondcodigo = value ;
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conprereq( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conprereq ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conprereq( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conprereq = value ;
   }

   public GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem> getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios( )
   {
      if ( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios == null )
      {
         gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios = new GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem>(web.Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem.class, "sdt_concepto.sdt_conceptoItem.ConveniosItem", "PayDay", remoteHandle);
      }
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios( GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem> value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios = value ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios_SetNull( )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios_N = (byte)(1) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios = null ;
   }

   public boolean getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios_IsNull( )
   {
      if ( gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios_N( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios_N ;
   }

   public boolean getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conmostrarpos( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conmostrarpos ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conmostrarpos( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conmostrarpos = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conadeldescu( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conadeldescu ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conadeldescu( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conadeldescu = value ;
   }

   public short getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Apliigg( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Apliigg ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Apliigg( short value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Apliigg = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Connumero( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Connumero ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Connumero( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Connumero = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipaapo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipaapo ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipaapo( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipaapo = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipacont( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipacont ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipacont( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipacont = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypapo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypapo ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypapo( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypapo = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypcont( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypcont ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypcont( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypcont = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasocapo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasocapo ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasocapo( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasocapo = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasoccont( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasoccont ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasoccont( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasoccont = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredapo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredapo ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredapo( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredapo = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredcont( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredcont ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredcont( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredcont = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateaapo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateaapo ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateaapo( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateaapo = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateacont( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateacont ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateacont( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateacont = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conasigfamcont( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conasigfamcont ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conasigfamcont( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conasigfamcont = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonnacempcont( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonnacempcont ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonnacempcont( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonnacempcont = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conleyrietrabcont( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conleyrietrabcont ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conleyrietrabcont( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conleyrietrabcont = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregdifapo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregdifapo ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregdifapo( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregdifapo = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregespapo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregespapo ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregespapo( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregespapo = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consacdeven( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consacdeven ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consacdeven( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consacdeven = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasefer( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasefer ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasefer( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasefer = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseferprom( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseferprom ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseferprom( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseferprom = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorext( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorext ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorext( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorext = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorextprom( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorextprom ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorextprom( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorextprom = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselic( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselic ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselic( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselic = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselicprom( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselicprom ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselicprom( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselicprom = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseosdif( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseosdif ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseosdif( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseosdif = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseaus( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseaus ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseaus( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseaus = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseausprom( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseausprom ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseausprom( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseausprom = value ;
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodafip( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodafip ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodafip( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodafip = value ;
   }

   public short getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptopais( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptopais ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptopais( short value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptopais = value ;
   }

   public String getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptoconvecodigo( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptoconvecodigo ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptoconvecodigo( String value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptoconvecodigo = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasepres( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasepres ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasepres( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasepres = value ;
   }

   public byte getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseant( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseant ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseant( byte value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseant = value ;
   }

   public boolean getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conerrorsicero( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conerrorsicero ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conerrorsicero( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conerrorsicero = value ;
   }

   public int getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod( int value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod = value ;
   }

   public boolean getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conpuenov( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conpuenov ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conpuenov( boolean value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conpuenov = value ;
   }

   public int getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrelsec( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrelsec ;
   }

   public void setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrelsec( int value )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(0) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrelsec = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_N = (byte)(1) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrangocant = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso_N = (byte)(1) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convalorgen = DecimalUtil.ZERO ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoliqganancias = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobservacion = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaobs2 = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion_N = (byte)(1) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1 = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2 = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaexpl = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondicion = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondcodigo = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conprereq = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios_N = (byte)(1) ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodafip = "" ;
      gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptoconvecodigo = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtsdt_concepto_sdt_conceptoItem_N ;
   }

   public web.Sdtsdt_concepto_sdt_conceptoItem Clone( )
   {
      return (web.Sdtsdt_concepto_sdt_conceptoItem)(clone()) ;
   }

   public void setStruct( web.StructSdtsdt_concepto_sdt_conceptoItem struct )
   {
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo(struct.getConcodigo());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrangocant(struct.getConrangocant());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conedienrec(struct.getConedienrec());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conusado(struct.getConusado());
      GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem> gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso_aux = new GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem>(web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem.class, "sdt_concepto.sdt_conceptoItem.MotEgrItem", "PayDay", remoteHandle);
      Vector<web.StructSdtsdt_concepto_sdt_conceptoItem_MotEgrItem> gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso_aux1 = struct.getMotivosegreso();
      if (gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso_aux1.size(); i++)
         {
            gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso_aux.add(new web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem(gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso(gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso_aux);
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conretganpropor(struct.getConretganpropor());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conaplicgan(struct.getConaplicgan());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrecalcular(struct.getConrecalcular());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip(struct.getCondescrip());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conhabilitado(struct.getConhabilitado());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo(struct.getContipo());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conorden(struct.getConorden());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concanti(struct.getConcanti());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convaluni(struct.getConvaluni());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conimporte(struct.getConimporte());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convigencia(struct.getConvigencia());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula(struct.getConformula());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convalorgen(struct.getConvalorgen());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaamigable(struct.getConformulaamigable());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoliqganancias(struct.getContipoliqganancias());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobservacion(struct.getConobservacion());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaobs2(struct.getConformulaobs2());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convariable(struct.getConvariable());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conforeditable(struct.getConforeditable());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consegunpla(struct.getConsegunpla());
      GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem> gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion_aux = new GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem>(web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem.class, "sdt_concepto.sdt_conceptoItem.TipoLiquidacionItem", "PayDay", remoteHandle);
      Vector<web.StructSdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem> gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion_aux1 = struct.getTipoliquidacion();
      if (gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion_aux1.size(); i++)
         {
            gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion_aux.add(new web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem(gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion(gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion_aux);
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod(struct.getTipoconcod());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1(struct.getSubtipoconcod1());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2(struct.getSubtipoconcod2());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaexpl(struct.getConformulaexpl());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoorden(struct.getContipoorden());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conordejec(struct.getConordejec());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobliga(struct.getConobliga());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobligasisac(struct.getConobligasisac());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondicion(struct.getConcondicion());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondcodigo(struct.getConcondcodigo());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conprereq(struct.getConprereq());
      GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem> gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios_aux = new GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem>(web.Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem.class, "sdt_concepto.sdt_conceptoItem.ConveniosItem", "PayDay", remoteHandle);
      Vector<web.StructSdtsdt_concepto_sdt_conceptoItem_ConveniosItem> gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios_aux1 = struct.getConvenios();
      if (gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios_aux1 != null)
      {
         for (int i = 0; i < gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios_aux1.size(); i++)
         {
            gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios_aux.add(new web.Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem(gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios_aux1.elementAt(i)));
         }
      }
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios(gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios_aux);
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conmostrarpos(struct.getConmostrarpos());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conadeldescu(struct.getConadeldescu());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Apliigg(struct.getApliigg());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Connumero(struct.getConnumero());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipaapo(struct.getConsipaapo());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipacont(struct.getConsipacont());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypapo(struct.getConinssjypapo());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypcont(struct.getConinssjypcont());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasocapo(struct.getConobrasocapo());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasoccont(struct.getConobrasoccont());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredapo(struct.getConfonsolredapo());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredcont(struct.getConfonsolredcont());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateaapo(struct.getConrenateaapo());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateacont(struct.getConrenateacont());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conasigfamcont(struct.getConasigfamcont());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonnacempcont(struct.getConfonnacempcont());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conleyrietrabcont(struct.getConleyrietrabcont());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregdifapo(struct.getConregdifapo());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregespapo(struct.getConregespapo());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consacdeven(struct.getConsacdeven());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasefer(struct.getConbasefer());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseferprom(struct.getConbaseferprom());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorext(struct.getConbasehorext());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorextprom(struct.getConbasehorextprom());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselic(struct.getConbaselic());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselicprom(struct.getConbaselicprom());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseosdif(struct.getConbaseosdif());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseaus(struct.getConbaseaus());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseausprom(struct.getConbaseausprom());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodafip(struct.getConcodafip());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptopais(struct.getConceptopais());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptoconvecodigo(struct.getConceptoconvecodigo());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasepres(struct.getConbasepres());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseant(struct.getConbaseant());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conerrorsicero(struct.getConerrorsicero());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod(struct.getClicod());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conpuenov(struct.getConpuenov());
      setgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrelsec(struct.getConrelsec());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtsdt_concepto_sdt_conceptoItem getStruct( )
   {
      web.StructSdtsdt_concepto_sdt_conceptoItem struct = new web.StructSdtsdt_concepto_sdt_conceptoItem ();
      struct.setConcodigo(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo());
      struct.setConrangocant(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrangocant());
      struct.setConedienrec(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conedienrec());
      struct.setConusado(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conusado());
      struct.setMotivosegreso(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso().getStruct());
      struct.setConretganpropor(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conretganpropor());
      struct.setConaplicgan(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conaplicgan());
      struct.setConrecalcular(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrecalcular());
      struct.setCondescrip(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip());
      struct.setConhabilitado(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conhabilitado());
      struct.setContipo(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo());
      struct.setConorden(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conorden());
      struct.setConcanti(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concanti());
      struct.setConvaluni(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convaluni());
      struct.setConimporte(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conimporte());
      struct.setConvigencia(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convigencia());
      struct.setConformula(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula());
      struct.setConvalorgen(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convalorgen());
      struct.setConformulaamigable(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaamigable());
      struct.setContipoliqganancias(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoliqganancias());
      struct.setConobservacion(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobservacion());
      struct.setConformulaobs2(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaobs2());
      struct.setConvariable(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convariable());
      struct.setConforeditable(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conforeditable());
      struct.setConsegunpla(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consegunpla());
      struct.setTipoliquidacion(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion().getStruct());
      struct.setTipoconcod(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod());
      struct.setSubtipoconcod1(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1());
      struct.setSubtipoconcod2(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2());
      struct.setConformulaexpl(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaexpl());
      struct.setContipoorden(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoorden());
      struct.setConordejec(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conordejec());
      struct.setConobliga(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobliga());
      struct.setConobligasisac(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobligasisac());
      struct.setConcondicion(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondicion());
      struct.setConcondcodigo(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondcodigo());
      struct.setConprereq(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conprereq());
      struct.setConvenios(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios().getStruct());
      struct.setConmostrarpos(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conmostrarpos());
      struct.setConadeldescu(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conadeldescu());
      struct.setApliigg(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Apliigg());
      struct.setConnumero(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Connumero());
      struct.setConsipaapo(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipaapo());
      struct.setConsipacont(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipacont());
      struct.setConinssjypapo(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypapo());
      struct.setConinssjypcont(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypcont());
      struct.setConobrasocapo(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasocapo());
      struct.setConobrasoccont(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasoccont());
      struct.setConfonsolredapo(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredapo());
      struct.setConfonsolredcont(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredcont());
      struct.setConrenateaapo(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateaapo());
      struct.setConrenateacont(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateacont());
      struct.setConasigfamcont(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conasigfamcont());
      struct.setConfonnacempcont(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonnacempcont());
      struct.setConleyrietrabcont(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conleyrietrabcont());
      struct.setConregdifapo(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregdifapo());
      struct.setConregespapo(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregespapo());
      struct.setConsacdeven(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Consacdeven());
      struct.setConbasefer(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasefer());
      struct.setConbaseferprom(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseferprom());
      struct.setConbasehorext(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorext());
      struct.setConbasehorextprom(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorextprom());
      struct.setConbaselic(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselic());
      struct.setConbaselicprom(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselicprom());
      struct.setConbaseosdif(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseosdif());
      struct.setConbaseaus(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseaus());
      struct.setConbaseausprom(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseausprom());
      struct.setConcodafip(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodafip());
      struct.setConceptopais(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptopais());
      struct.setConceptoconvecodigo(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptoconvecodigo());
      struct.setConbasepres(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasepres());
      struct.setConbaseant(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseant());
      struct.setConerrorsicero(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conerrorsicero());
      struct.setClicod(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod());
      struct.setConpuenov(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conpuenov());
      struct.setConrelsec(getgxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrelsec());
      return struct ;
   }

   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_N ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso_N ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conaplicgan ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipo ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion_N ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios_N ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conadeldescu ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Connumero ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipaapo ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consipacont ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypapo ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Coninssjypcont ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasocapo ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobrasoccont ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredapo ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonsolredcont ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateaapo ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrenateacont ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conasigfamcont ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Confonnacempcont ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conleyrietrabcont ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregdifapo ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conregespapo ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consacdeven ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasefer ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseferprom ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorext ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasehorextprom ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselic ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaselicprom ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseosdif ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseaus ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseausprom ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbasepres ;
   protected byte gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conbaseant ;
   protected short gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convigencia ;
   protected short gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaamigable ;
   protected short gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoorden ;
   protected short gxTv_Sdtsdt_concepto_sdt_conceptoItem_Apliigg ;
   protected short gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptopais ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected int gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conorden ;
   protected int gxTv_Sdtsdt_concepto_sdt_conceptoItem_Clicod ;
   protected int gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrelsec ;
   protected long gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conordejec ;
   protected java.math.BigDecimal gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convalorgen ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodigo ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Contipoliqganancias ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoconcod ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod1 ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Subtipoconcod2 ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondicion ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concondcodigo ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conprereq ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concodafip ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conceptoconvecodigo ;
   protected String sTagName ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conedienrec ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conusado ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conretganpropor ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrecalcular ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conhabilitado ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Concanti ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convaluni ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conimporte ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convariable ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conforeditable ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Consegunpla ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobliga ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobligasisac ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conmostrarpos ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conerrorsicero ;
   protected boolean gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conpuenov ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformula ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conobservacion ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaobs2 ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conformulaexpl ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Conrangocant ;
   protected String gxTv_Sdtsdt_concepto_sdt_conceptoItem_Condescrip ;
   protected GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem> gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso_aux ;
   protected GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem> gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion_aux ;
   protected GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem> gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios_aux ;
   protected GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_MotEgrItem> gxTv_Sdtsdt_concepto_sdt_conceptoItem_Motivosegreso=null ;
   protected GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_TipoLiquidacionItem> gxTv_Sdtsdt_concepto_sdt_conceptoItem_Tipoliquidacion=null ;
   protected GXBaseCollection<web.Sdtsdt_concepto_sdt_conceptoItem_ConveniosItem> gxTv_Sdtsdt_concepto_sdt_conceptoItem_Convenios=null ;
}

