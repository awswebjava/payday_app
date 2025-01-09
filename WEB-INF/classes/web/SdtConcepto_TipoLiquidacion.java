package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtConcepto_TipoLiquidacion extends GxSilentTrnSdt
{
   public SdtConcepto_TipoLiquidacion( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtConcepto_TipoLiquidacion.class));
   }

   public SdtConcepto_TipoLiquidacion( int remoteHandle ,
                                       ModelContext context )
   {
      super( remoteHandle, context, "SdtConcepto_TipoLiquidacion");
      initialize( remoteHandle) ;
   }

   public SdtConcepto_TipoLiquidacion( int remoteHandle ,
                                       StructSdtConcepto_TipoLiquidacion struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtConcepto_TipoLiquidacion( )
   {
      super( new ModelContext(SdtConcepto_TipoLiquidacion.class), "SdtConcepto_TipoLiquidacion");
      initialize( ) ;
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"TLiqCod", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "TipoLiquidacion");
      metadata.set("BT", "ConceptoTipoLiquidacion");
      metadata.set("PK", "[ \"TLiqCod\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\",\"ConCodigo\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"TLiqCod\" ],\"FKMap\":[  ] } ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqCod") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Tliqcod = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TliqDesc") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLiqSinCausa") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLiqSinPre") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLTipEgr") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contltipegr = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLOrdejec") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contlordejec = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLConOrd") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contlconord = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLVigencia") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLCondicion") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLConHab") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contlconhab = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLTipoCon") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contltipocon = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CONTLSegPla") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TLiqCod_Z") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Tliqcod_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TliqDesc_Z") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLiqSinCausa_Z") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLiqSinPre_Z") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLTipEgr_Z") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contltipegr_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLOrdejec_Z") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contlordejec_Z = (long)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLConOrd_Z") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contlconord_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLVigencia_Z") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLCondicion_Z") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLConHab_Z") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contlconhab_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLTipoCon_Z") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CONTLSegPla_Z") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_Z = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLiqSinCausa_N") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLiqSinPre_N") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLVigencia_N") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLCondicion_N") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConTLTipoCon_N") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N = (byte)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CONTLSegPla_N") )
            {
               gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Concepto.TipoLiquidacion" ;
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
      oWriter.writeElement("TLiqCod", gxTv_SdtConcepto_TipoLiquidacion_Tliqcod);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("TliqDesc", gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConTLiqSinCausa", GXutil.booltostr( gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConTLiqSinPre", GXutil.booltostr( gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConTLTipEgr", gxTv_SdtConcepto_TipoLiquidacion_Contltipegr);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConTLOrdejec", GXutil.trim( GXutil.str( gxTv_SdtConcepto_TipoLiquidacion_Contlordejec, 12, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConTLConOrd", GXutil.trim( GXutil.str( gxTv_SdtConcepto_TipoLiquidacion_Contlconord, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConTLVigencia", GXutil.trim( GXutil.str( gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConTLCondicion", gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConTLConHab", GXutil.trim( GXutil.str( gxTv_SdtConcepto_TipoLiquidacion_Contlconhab, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConTLTipoCon", gxTv_SdtConcepto_TipoLiquidacion_Contltipocon);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("CONTLSegPla", GXutil.trim( GXutil.str( gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla, 1, 0)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtConcepto_TipoLiquidacion_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtConcepto_TipoLiquidacion_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtConcepto_TipoLiquidacion_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TLiqCod_Z", gxTv_SdtConcepto_TipoLiquidacion_Tliqcod_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("TliqDesc_Z", gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConTLiqSinCausa_Z", GXutil.booltostr( gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConTLiqSinPre_Z", GXutil.booltostr( gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConTLTipEgr_Z", gxTv_SdtConcepto_TipoLiquidacion_Contltipegr_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConTLOrdejec_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_TipoLiquidacion_Contlordejec_Z, 12, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConTLConOrd_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_TipoLiquidacion_Contlconord_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConTLVigencia_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConTLCondicion_Z", gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConTLConHab_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_TipoLiquidacion_Contlconhab_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConTLTipoCon_Z", gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CONTLSegPla_Z", GXutil.trim( GXutil.str( gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_Z, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConTLiqSinCausa_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConTLiqSinPre_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConTLVigencia_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConTLCondicion_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("ConTLTipoCon_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("CONTLSegPla_N", GXutil.trim( GXutil.str( gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N, 1, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
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
      AddObjectProperty("TLiqCod", gxTv_SdtConcepto_TipoLiquidacion_Tliqcod, false, includeNonInitialized);
      AddObjectProperty("TliqDesc", gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc, false, includeNonInitialized);
      AddObjectProperty("ConTLiqSinCausa", gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa, false, includeNonInitialized);
      AddObjectProperty("ConTLiqSinCausa_N", gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N, false, includeNonInitialized);
      AddObjectProperty("ConTLiqSinPre", gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre, false, includeNonInitialized);
      AddObjectProperty("ConTLiqSinPre_N", gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N, false, includeNonInitialized);
      AddObjectProperty("ConTLTipEgr", gxTv_SdtConcepto_TipoLiquidacion_Contltipegr, false, includeNonInitialized);
      AddObjectProperty("ConTLOrdejec", gxTv_SdtConcepto_TipoLiquidacion_Contlordejec, false, includeNonInitialized);
      AddObjectProperty("ConTLConOrd", gxTv_SdtConcepto_TipoLiquidacion_Contlconord, false, includeNonInitialized);
      AddObjectProperty("ConTLVigencia", gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia, false, includeNonInitialized);
      AddObjectProperty("ConTLVigencia_N", gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N, false, includeNonInitialized);
      AddObjectProperty("ConTLCondicion", gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion, false, includeNonInitialized);
      AddObjectProperty("ConTLCondicion_N", gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N, false, includeNonInitialized);
      AddObjectProperty("ConTLConHab", gxTv_SdtConcepto_TipoLiquidacion_Contlconhab, false, includeNonInitialized);
      AddObjectProperty("ConTLTipoCon", gxTv_SdtConcepto_TipoLiquidacion_Contltipocon, false, includeNonInitialized);
      AddObjectProperty("ConTLTipoCon_N", gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N, false, includeNonInitialized);
      AddObjectProperty("CONTLSegPla", gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla, false, includeNonInitialized);
      AddObjectProperty("CONTLSegPla_N", gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtConcepto_TipoLiquidacion_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtConcepto_TipoLiquidacion_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtConcepto_TipoLiquidacion_Initialized, false, includeNonInitialized);
         AddObjectProperty("TLiqCod_Z", gxTv_SdtConcepto_TipoLiquidacion_Tliqcod_Z, false, includeNonInitialized);
         AddObjectProperty("TliqDesc_Z", gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc_Z, false, includeNonInitialized);
         AddObjectProperty("ConTLiqSinCausa_Z", gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_Z, false, includeNonInitialized);
         AddObjectProperty("ConTLiqSinPre_Z", gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_Z, false, includeNonInitialized);
         AddObjectProperty("ConTLTipEgr_Z", gxTv_SdtConcepto_TipoLiquidacion_Contltipegr_Z, false, includeNonInitialized);
         AddObjectProperty("ConTLOrdejec_Z", gxTv_SdtConcepto_TipoLiquidacion_Contlordejec_Z, false, includeNonInitialized);
         AddObjectProperty("ConTLConOrd_Z", gxTv_SdtConcepto_TipoLiquidacion_Contlconord_Z, false, includeNonInitialized);
         AddObjectProperty("ConTLVigencia_Z", gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_Z, false, includeNonInitialized);
         AddObjectProperty("ConTLCondicion_Z", gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_Z, false, includeNonInitialized);
         AddObjectProperty("ConTLConHab_Z", gxTv_SdtConcepto_TipoLiquidacion_Contlconhab_Z, false, includeNonInitialized);
         AddObjectProperty("ConTLTipoCon_Z", gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_Z, false, includeNonInitialized);
         AddObjectProperty("CONTLSegPla_Z", gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_Z, false, includeNonInitialized);
         AddObjectProperty("ConTLiqSinCausa_N", gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N, false, includeNonInitialized);
         AddObjectProperty("ConTLiqSinPre_N", gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N, false, includeNonInitialized);
         AddObjectProperty("ConTLVigencia_N", gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N, false, includeNonInitialized);
         AddObjectProperty("ConTLCondicion_N", gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N, false, includeNonInitialized);
         AddObjectProperty("ConTLTipoCon_N", gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N, false, includeNonInitialized);
         AddObjectProperty("CONTLSegPla_N", gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtConcepto_TipoLiquidacion sdt )
   {
      if ( sdt.IsDirty("TLiqCod") )
      {
         gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
         gxTv_SdtConcepto_TipoLiquidacion_Tliqcod = sdt.getgxTv_SdtConcepto_TipoLiquidacion_Tliqcod() ;
      }
      if ( sdt.IsDirty("TliqDesc") )
      {
         gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
         gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc = sdt.getgxTv_SdtConcepto_TipoLiquidacion_Tliqdesc() ;
      }
      if ( sdt.IsDirty("ConTLiqSinCausa") )
      {
         gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N = sdt.getgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N() ;
         gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
         gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa = sdt.getgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa() ;
      }
      if ( sdt.IsDirty("ConTLiqSinPre") )
      {
         gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N = sdt.getgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N() ;
         gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
         gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre = sdt.getgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre() ;
      }
      if ( sdt.IsDirty("ConTLTipEgr") )
      {
         gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
         gxTv_SdtConcepto_TipoLiquidacion_Contltipegr = sdt.getgxTv_SdtConcepto_TipoLiquidacion_Contltipegr() ;
      }
      if ( sdt.IsDirty("ConTLOrdejec") )
      {
         gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
         gxTv_SdtConcepto_TipoLiquidacion_Contlordejec = sdt.getgxTv_SdtConcepto_TipoLiquidacion_Contlordejec() ;
      }
      if ( sdt.IsDirty("ConTLConOrd") )
      {
         gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
         gxTv_SdtConcepto_TipoLiquidacion_Contlconord = sdt.getgxTv_SdtConcepto_TipoLiquidacion_Contlconord() ;
      }
      if ( sdt.IsDirty("ConTLVigencia") )
      {
         gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N = sdt.getgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N() ;
         gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
         gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia = sdt.getgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia() ;
      }
      if ( sdt.IsDirty("ConTLCondicion") )
      {
         gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N = sdt.getgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N() ;
         gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
         gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion = sdt.getgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion() ;
      }
      if ( sdt.IsDirty("ConTLConHab") )
      {
         gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
         gxTv_SdtConcepto_TipoLiquidacion_Contlconhab = sdt.getgxTv_SdtConcepto_TipoLiquidacion_Contlconhab() ;
      }
      if ( sdt.IsDirty("ConTLTipoCon") )
      {
         gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N = sdt.getgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N() ;
         gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
         gxTv_SdtConcepto_TipoLiquidacion_Contltipocon = sdt.getgxTv_SdtConcepto_TipoLiquidacion_Contltipocon() ;
      }
      if ( sdt.IsDirty("CONTLSegPla") )
      {
         gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N = sdt.getgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N() ;
         gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
         gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla = sdt.getgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla() ;
      }
   }

   public String getgxTv_SdtConcepto_TipoLiquidacion_Tliqcod( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Tliqcod ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Tliqcod( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Tliqcod");
      gxTv_SdtConcepto_TipoLiquidacion_Tliqcod = value ;
   }

   public String getgxTv_SdtConcepto_TipoLiquidacion_Tliqdesc( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Tliqdesc( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Tliqdesc");
      gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc = value ;
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa( boolean value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contliqsincausa");
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N = (byte)(1) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa = false ;
      SetDirty("Contliqsincausa");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_IsNull( )
   {
      return (gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N==1) ;
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre( boolean value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contliqsinpre");
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N = (byte)(1) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre = false ;
      SetDirty("Contliqsinpre");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_IsNull( )
   {
      return (gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N==1) ;
   }

   public String getgxTv_SdtConcepto_TipoLiquidacion_Contltipegr( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contltipegr ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contltipegr( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contltipegr");
      gxTv_SdtConcepto_TipoLiquidacion_Contltipegr = value ;
   }

   public long getgxTv_SdtConcepto_TipoLiquidacion_Contlordejec( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlordejec ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlordejec( long value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contlordejec");
      gxTv_SdtConcepto_TipoLiquidacion_Contlordejec = value ;
   }

   public short getgxTv_SdtConcepto_TipoLiquidacion_Contlconord( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlconord ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlconord( short value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contlconord");
      gxTv_SdtConcepto_TipoLiquidacion_Contlconord = value ;
   }

   public byte getgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contlvigencia");
      gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N = (byte)(1) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia = (byte)(0) ;
      SetDirty("Contlvigencia");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_IsNull( )
   {
      return (gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N==1) ;
   }

   public String getgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contlcondicion");
      gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N = (byte)(1) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion = "" ;
      SetDirty("Contlcondicion");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_IsNull( )
   {
      return (gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N==1) ;
   }

   public byte getgxTv_SdtConcepto_TipoLiquidacion_Contlconhab( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlconhab ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlconhab( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contlconhab");
      gxTv_SdtConcepto_TipoLiquidacion_Contlconhab = value ;
   }

   public String getgxTv_SdtConcepto_TipoLiquidacion_Contltipocon( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contltipocon ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contltipocon( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contltipocon");
      gxTv_SdtConcepto_TipoLiquidacion_Contltipocon = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N = (byte)(1) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contltipocon = "" ;
      SetDirty("Contltipocon");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_IsNull( )
   {
      return (gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N==1) ;
   }

   public byte getgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contlsegpla");
      gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N = (byte)(1) ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla = (byte)(0) ;
      SetDirty("Contlsegpla");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_IsNull( )
   {
      return (gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N==1) ;
   }

   public String getgxTv_SdtConcepto_TipoLiquidacion_Mode( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Mode ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Mode( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtConcepto_TipoLiquidacion_Mode = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Mode_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConcepto_TipoLiquidacion_Modified( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Modified ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Modified( short value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtConcepto_TipoLiquidacion_Modified = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Modified_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConcepto_TipoLiquidacion_Initialized( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Initialized ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Initialized( short value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtConcepto_TipoLiquidacion_Initialized = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Initialized_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_TipoLiquidacion_Tliqcod_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Tliqcod_Z ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Tliqcod_Z( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Tliqcod_Z");
      gxTv_SdtConcepto_TipoLiquidacion_Tliqcod_Z = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Tliqcod_Z_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Tliqcod_Z = "" ;
      SetDirty("Tliqcod_Z");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Tliqcod_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_TipoLiquidacion_Tliqdesc_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc_Z ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Tliqdesc_Z( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Tliqdesc_Z");
      gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc_Z = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Tliqdesc_Z_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc_Z = "" ;
      SetDirty("Tliqdesc_Z");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Tliqdesc_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_Z ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_Z( boolean value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contliqsincausa_Z");
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_Z = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_Z_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_Z = false ;
      SetDirty("Contliqsincausa_Z");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_Z ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_Z( boolean value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contliqsinpre_Z");
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_Z = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_Z_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_Z = false ;
      SetDirty("Contliqsinpre_Z");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_TipoLiquidacion_Contltipegr_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contltipegr_Z ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contltipegr_Z( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contltipegr_Z");
      gxTv_SdtConcepto_TipoLiquidacion_Contltipegr_Z = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contltipegr_Z_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contltipegr_Z = "" ;
      SetDirty("Contltipegr_Z");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contltipegr_Z_IsNull( )
   {
      return false ;
   }

   public long getgxTv_SdtConcepto_TipoLiquidacion_Contlordejec_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlordejec_Z ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlordejec_Z( long value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contlordejec_Z");
      gxTv_SdtConcepto_TipoLiquidacion_Contlordejec_Z = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlordejec_Z_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contlordejec_Z = 0 ;
      SetDirty("Contlordejec_Z");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contlordejec_Z_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtConcepto_TipoLiquidacion_Contlconord_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlconord_Z ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlconord_Z( short value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contlconord_Z");
      gxTv_SdtConcepto_TipoLiquidacion_Contlconord_Z = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlconord_Z_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contlconord_Z = (short)(0) ;
      SetDirty("Contlconord_Z");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contlconord_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_Z ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_Z( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contlvigencia_Z");
      gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_Z = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_Z_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_Z = (byte)(0) ;
      SetDirty("Contlvigencia_Z");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_Z ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_Z( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contlcondicion_Z");
      gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_Z = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_Z_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_Z = "" ;
      SetDirty("Contlcondicion_Z");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_TipoLiquidacion_Contlconhab_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlconhab_Z ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlconhab_Z( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contlconhab_Z");
      gxTv_SdtConcepto_TipoLiquidacion_Contlconhab_Z = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlconhab_Z_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contlconhab_Z = (byte)(0) ;
      SetDirty("Contlconhab_Z");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contlconhab_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_Z ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_Z( String value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contltipocon_Z");
      gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_Z = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_Z_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_Z = "" ;
      SetDirty("Contltipocon_Z");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_Z( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_Z ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_Z( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contlsegpla_Z");
      gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_Z = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_Z_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_Z = (byte)(0) ;
      SetDirty("Contlsegpla_Z");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contliqsincausa_N");
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N = (byte)(0) ;
      SetDirty("Contliqsincausa_N");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contliqsinpre_N");
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N = (byte)(0) ;
      SetDirty("Contliqsinpre_N");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contlvigencia_N");
      gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N = (byte)(0) ;
      SetDirty("Contlvigencia_N");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contlcondicion_N");
      gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N = (byte)(0) ;
      SetDirty("Contlcondicion_N");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contltipocon_N");
      gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N = (byte)(0) ;
      SetDirty("Contltipocon_N");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N( byte value )
   {
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(0) ;
      gxTv_SdtConcepto_TipoLiquidacion_Modified = (short)(1) ;
      SetDirty("Contlsegpla_N");
      gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N = value ;
   }

   public void setgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N_SetNull( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N = (byte)(0) ;
      SetDirty("Contlsegpla_N");
   }

   public boolean getgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtConcepto_TipoLiquidacion_Tliqcod = "" ;
      gxTv_SdtConcepto_TipoLiquidacion_N = (byte)(1) ;
      gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc = "" ;
      gxTv_SdtConcepto_TipoLiquidacion_Contltipegr = "" ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion = "" ;
      gxTv_SdtConcepto_TipoLiquidacion_Contltipocon = "" ;
      gxTv_SdtConcepto_TipoLiquidacion_Mode = "" ;
      gxTv_SdtConcepto_TipoLiquidacion_Tliqcod_Z = "" ;
      gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc_Z = "" ;
      gxTv_SdtConcepto_TipoLiquidacion_Contltipegr_Z = "" ;
      gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_Z = "" ;
      gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtConcepto_TipoLiquidacion_N ;
   }

   public web.SdtConcepto_TipoLiquidacion Clone( )
   {
      return (web.SdtConcepto_TipoLiquidacion)(clone()) ;
   }

   public void setStruct( web.StructSdtConcepto_TipoLiquidacion struct )
   {
      setgxTv_SdtConcepto_TipoLiquidacion_Tliqcod(struct.getTliqcod());
      setgxTv_SdtConcepto_TipoLiquidacion_Tliqdesc(struct.getTliqdesc());
      setgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa(struct.getContliqsincausa());
      setgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre(struct.getContliqsinpre());
      setgxTv_SdtConcepto_TipoLiquidacion_Contltipegr(struct.getContltipegr());
      setgxTv_SdtConcepto_TipoLiquidacion_Contlordejec(struct.getContlordejec());
      setgxTv_SdtConcepto_TipoLiquidacion_Contlconord(struct.getContlconord());
      setgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia(struct.getContlvigencia());
      setgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion(struct.getContlcondicion());
      setgxTv_SdtConcepto_TipoLiquidacion_Contlconhab(struct.getContlconhab());
      setgxTv_SdtConcepto_TipoLiquidacion_Contltipocon(struct.getContltipocon());
      setgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla(struct.getContlsegpla());
      setgxTv_SdtConcepto_TipoLiquidacion_Mode(struct.getMode());
      setgxTv_SdtConcepto_TipoLiquidacion_Modified(struct.getModified());
      setgxTv_SdtConcepto_TipoLiquidacion_Initialized(struct.getInitialized());
      setgxTv_SdtConcepto_TipoLiquidacion_Tliqcod_Z(struct.getTliqcod_Z());
      setgxTv_SdtConcepto_TipoLiquidacion_Tliqdesc_Z(struct.getTliqdesc_Z());
      setgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_Z(struct.getContliqsincausa_Z());
      setgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_Z(struct.getContliqsinpre_Z());
      setgxTv_SdtConcepto_TipoLiquidacion_Contltipegr_Z(struct.getContltipegr_Z());
      setgxTv_SdtConcepto_TipoLiquidacion_Contlordejec_Z(struct.getContlordejec_Z());
      setgxTv_SdtConcepto_TipoLiquidacion_Contlconord_Z(struct.getContlconord_Z());
      setgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_Z(struct.getContlvigencia_Z());
      setgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_Z(struct.getContlcondicion_Z());
      setgxTv_SdtConcepto_TipoLiquidacion_Contlconhab_Z(struct.getContlconhab_Z());
      setgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_Z(struct.getContltipocon_Z());
      setgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_Z(struct.getContlsegpla_Z());
      setgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N(struct.getContliqsincausa_N());
      setgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N(struct.getContliqsinpre_N());
      setgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N(struct.getContlvigencia_N());
      setgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N(struct.getContlcondicion_N());
      setgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N(struct.getContltipocon_N());
      setgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N(struct.getContlsegpla_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtConcepto_TipoLiquidacion getStruct( )
   {
      web.StructSdtConcepto_TipoLiquidacion struct = new web.StructSdtConcepto_TipoLiquidacion ();
      struct.setTliqcod(getgxTv_SdtConcepto_TipoLiquidacion_Tliqcod());
      struct.setTliqdesc(getgxTv_SdtConcepto_TipoLiquidacion_Tliqdesc());
      struct.setContliqsincausa(getgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa());
      struct.setContliqsinpre(getgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre());
      struct.setContltipegr(getgxTv_SdtConcepto_TipoLiquidacion_Contltipegr());
      struct.setContlordejec(getgxTv_SdtConcepto_TipoLiquidacion_Contlordejec());
      struct.setContlconord(getgxTv_SdtConcepto_TipoLiquidacion_Contlconord());
      struct.setContlvigencia(getgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia());
      struct.setContlcondicion(getgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion());
      struct.setContlconhab(getgxTv_SdtConcepto_TipoLiquidacion_Contlconhab());
      struct.setContltipocon(getgxTv_SdtConcepto_TipoLiquidacion_Contltipocon());
      struct.setContlsegpla(getgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla());
      struct.setMode(getgxTv_SdtConcepto_TipoLiquidacion_Mode());
      struct.setModified(getgxTv_SdtConcepto_TipoLiquidacion_Modified());
      struct.setInitialized(getgxTv_SdtConcepto_TipoLiquidacion_Initialized());
      struct.setTliqcod_Z(getgxTv_SdtConcepto_TipoLiquidacion_Tliqcod_Z());
      struct.setTliqdesc_Z(getgxTv_SdtConcepto_TipoLiquidacion_Tliqdesc_Z());
      struct.setContliqsincausa_Z(getgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_Z());
      struct.setContliqsinpre_Z(getgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_Z());
      struct.setContltipegr_Z(getgxTv_SdtConcepto_TipoLiquidacion_Contltipegr_Z());
      struct.setContlordejec_Z(getgxTv_SdtConcepto_TipoLiquidacion_Contlordejec_Z());
      struct.setContlconord_Z(getgxTv_SdtConcepto_TipoLiquidacion_Contlconord_Z());
      struct.setContlvigencia_Z(getgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_Z());
      struct.setContlcondicion_Z(getgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_Z());
      struct.setContlconhab_Z(getgxTv_SdtConcepto_TipoLiquidacion_Contlconhab_Z());
      struct.setContltipocon_Z(getgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_Z());
      struct.setContlsegpla_Z(getgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_Z());
      struct.setContliqsincausa_N(getgxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N());
      struct.setContliqsinpre_N(getgxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N());
      struct.setContlvigencia_N(getgxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N());
      struct.setContlcondicion_N(getgxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N());
      struct.setContltipocon_N(getgxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N());
      struct.setContlsegpla_N(getgxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N());
      return struct ;
   }

   private byte gxTv_SdtConcepto_TipoLiquidacion_N ;
   private byte gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia ;
   private byte gxTv_SdtConcepto_TipoLiquidacion_Contlconhab ;
   private byte gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla ;
   private byte gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_Z ;
   private byte gxTv_SdtConcepto_TipoLiquidacion_Contlconhab_Z ;
   private byte gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_Z ;
   private byte gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_N ;
   private byte gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_N ;
   private byte gxTv_SdtConcepto_TipoLiquidacion_Contlvigencia_N ;
   private byte gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_N ;
   private byte gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_N ;
   private byte gxTv_SdtConcepto_TipoLiquidacion_Contlsegpla_N ;
   private short gxTv_SdtConcepto_TipoLiquidacion_Contlconord ;
   private short gxTv_SdtConcepto_TipoLiquidacion_Modified ;
   private short gxTv_SdtConcepto_TipoLiquidacion_Initialized ;
   private short gxTv_SdtConcepto_TipoLiquidacion_Contlconord_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private long gxTv_SdtConcepto_TipoLiquidacion_Contlordejec ;
   private long gxTv_SdtConcepto_TipoLiquidacion_Contlordejec_Z ;
   private String gxTv_SdtConcepto_TipoLiquidacion_Tliqcod ;
   private String gxTv_SdtConcepto_TipoLiquidacion_Contltipegr ;
   private String gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion ;
   private String gxTv_SdtConcepto_TipoLiquidacion_Contltipocon ;
   private String gxTv_SdtConcepto_TipoLiquidacion_Mode ;
   private String gxTv_SdtConcepto_TipoLiquidacion_Tliqcod_Z ;
   private String gxTv_SdtConcepto_TipoLiquidacion_Contltipegr_Z ;
   private String gxTv_SdtConcepto_TipoLiquidacion_Contlcondicion_Z ;
   private String gxTv_SdtConcepto_TipoLiquidacion_Contltipocon_Z ;
   private String sTagName ;
   private boolean gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa ;
   private boolean gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre ;
   private boolean gxTv_SdtConcepto_TipoLiquidacion_Contliqsincausa_Z ;
   private boolean gxTv_SdtConcepto_TipoLiquidacion_Contliqsinpre_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc ;
   private String gxTv_SdtConcepto_TipoLiquidacion_Tliqdesc_Z ;
}

