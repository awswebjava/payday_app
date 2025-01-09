package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtPais_tipo_trabajo extends GxSilentTrnSdt
{
   public SdtPais_tipo_trabajo( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtPais_tipo_trabajo.class));
   }

   public SdtPais_tipo_trabajo( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle, context, "SdtPais_tipo_trabajo");
      initialize( remoteHandle) ;
   }

   public SdtPais_tipo_trabajo( int remoteHandle ,
                                StructSdtPais_tipo_trabajo struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtPais_tipo_trabajo( )
   {
      super( new ModelContext(SdtPais_tipo_trabajo.class), "SdtPais_tipo_trabajo");
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
      return (Object[][])(new Object[][]{new Object[]{"PaiTipoTraId", String.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "tipo_trabajo");
      metadata.set("BT", "PaisTipoTrabajo");
      metadata.set("PK", "[ \"PaiTipoTraId\" ]");
      metadata.set("PKAssigned", "[ \"PaiTipoTraId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"PaiCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"TipoTraId\" ],\"FKMap\":[ \"PaiTipoTraId-TipoTraId\" ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoTraId") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipotraid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoTraNom") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipotranom = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoTraHor") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipotrahor = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoTraIns") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipotrains = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoHsDia") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipohsdia = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoHsSem") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipohssem = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoTarifaXLim") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoTarifaRec") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipotarifarec = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoHsMaxDia") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoHsMaxSem") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoHsMaxMes") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoHsMaxAnu") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtPais_tipo_trabajo_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtPais_tipo_trabajo_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtPais_tipo_trabajo_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoTraId_Z") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipotraid_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoTraNom_Z") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipotranom_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoTraHor_Z") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipotrahor_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoTraIns_Z") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipotrains_Z = (boolean)((((GXutil.strcmp(oReader.getValue(), "true")==0)||(GXutil.strcmp(oReader.getValue(), "1")==0) ? 1 : 0)==0)?false:true) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoHsDia_Z") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipohsdia_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoHsSem_Z") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipohssem_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoTarifaXLim_Z") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoTarifaRec_Z") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipotarifarec_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoHsMaxDia_Z") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoHsMaxSem_Z") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoHsMaxMes_Z") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoHsMaxAnu_Z") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoTraHor_N") )
            {
               gxTv_SdtPais_tipo_trabajo_Paitipotrahor_N = (byte)(getnumericvalue(oReader.getValue())) ;
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
         sName = "Pais.tipo_trabajo" ;
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
      oWriter.writeElement("PaiTipoTraId", gxTv_SdtPais_tipo_trabajo_Paitipotraid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTipoTraNom", gxTv_SdtPais_tipo_trabajo_Paitipotranom);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTipoTraHor", gxTv_SdtPais_tipo_trabajo_Paitipotrahor);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTipoTraIns", GXutil.booltostr( gxTv_SdtPais_tipo_trabajo_Paitipotrains));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTipoHsDia", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_tipo_trabajo_Paitipohsdia, 3, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTipoHsSem", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_tipo_trabajo_Paitipohssem, 4, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTipoTarifaXLim", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTipoTarifaRec", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_tipo_trabajo_Paitipotarifarec, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTipoHsMaxDia", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia, 3, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTipoHsMaxSem", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem, 4, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTipoHsMaxMes", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes, 5, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTipoHsMaxAnu", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu, 5, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtPais_tipo_trabajo_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtPais_tipo_trabajo_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtPais_tipo_trabajo_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiTipoTraId_Z", gxTv_SdtPais_tipo_trabajo_Paitipotraid_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiTipoTraNom_Z", gxTv_SdtPais_tipo_trabajo_Paitipotranom_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiTipoTraHor_Z", gxTv_SdtPais_tipo_trabajo_Paitipotrahor_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiTipoTraIns_Z", GXutil.booltostr( gxTv_SdtPais_tipo_trabajo_Paitipotrains_Z));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiTipoHsDia_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_tipo_trabajo_Paitipohsdia_Z, 3, 1)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiTipoHsSem_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_tipo_trabajo_Paitipohssem_Z, 4, 1)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiTipoTarifaXLim_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim_Z, 6, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiTipoTarifaRec_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_tipo_trabajo_Paitipotarifarec_Z, 6, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiTipoHsMaxDia_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia_Z, 3, 1)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiTipoHsMaxSem_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem_Z, 4, 1)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiTipoHsMaxMes_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes_Z, 5, 1)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiTipoHsMaxAnu_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu_Z, 5, 1)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiTipoTraHor_N", GXutil.trim( GXutil.str( gxTv_SdtPais_tipo_trabajo_Paitipotrahor_N, 1, 0)));
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
      AddObjectProperty("PaiTipoTraId", gxTv_SdtPais_tipo_trabajo_Paitipotraid, false, includeNonInitialized);
      AddObjectProperty("PaiTipoTraNom", gxTv_SdtPais_tipo_trabajo_Paitipotranom, false, includeNonInitialized);
      AddObjectProperty("PaiTipoTraHor", gxTv_SdtPais_tipo_trabajo_Paitipotrahor, false, includeNonInitialized);
      AddObjectProperty("PaiTipoTraHor_N", gxTv_SdtPais_tipo_trabajo_Paitipotrahor_N, false, includeNonInitialized);
      AddObjectProperty("PaiTipoTraIns", gxTv_SdtPais_tipo_trabajo_Paitipotrains, false, includeNonInitialized);
      AddObjectProperty("PaiTipoHsDia", gxTv_SdtPais_tipo_trabajo_Paitipohsdia, false, includeNonInitialized);
      AddObjectProperty("PaiTipoHsSem", gxTv_SdtPais_tipo_trabajo_Paitipohssem, false, includeNonInitialized);
      AddObjectProperty("PaiTipoTarifaXLim", gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim, false, includeNonInitialized);
      AddObjectProperty("PaiTipoTarifaRec", gxTv_SdtPais_tipo_trabajo_Paitipotarifarec, false, includeNonInitialized);
      AddObjectProperty("PaiTipoHsMaxDia", gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia, false, includeNonInitialized);
      AddObjectProperty("PaiTipoHsMaxSem", gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem, false, includeNonInitialized);
      AddObjectProperty("PaiTipoHsMaxMes", gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes, false, includeNonInitialized);
      AddObjectProperty("PaiTipoHsMaxAnu", gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtPais_tipo_trabajo_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtPais_tipo_trabajo_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtPais_tipo_trabajo_Initialized, false, includeNonInitialized);
         AddObjectProperty("PaiTipoTraId_Z", gxTv_SdtPais_tipo_trabajo_Paitipotraid_Z, false, includeNonInitialized);
         AddObjectProperty("PaiTipoTraNom_Z", gxTv_SdtPais_tipo_trabajo_Paitipotranom_Z, false, includeNonInitialized);
         AddObjectProperty("PaiTipoTraHor_Z", gxTv_SdtPais_tipo_trabajo_Paitipotrahor_Z, false, includeNonInitialized);
         AddObjectProperty("PaiTipoTraIns_Z", gxTv_SdtPais_tipo_trabajo_Paitipotrains_Z, false, includeNonInitialized);
         AddObjectProperty("PaiTipoHsDia_Z", gxTv_SdtPais_tipo_trabajo_Paitipohsdia_Z, false, includeNonInitialized);
         AddObjectProperty("PaiTipoHsSem_Z", gxTv_SdtPais_tipo_trabajo_Paitipohssem_Z, false, includeNonInitialized);
         AddObjectProperty("PaiTipoTarifaXLim_Z", gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim_Z, false, includeNonInitialized);
         AddObjectProperty("PaiTipoTarifaRec_Z", gxTv_SdtPais_tipo_trabajo_Paitipotarifarec_Z, false, includeNonInitialized);
         AddObjectProperty("PaiTipoHsMaxDia_Z", gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia_Z, false, includeNonInitialized);
         AddObjectProperty("PaiTipoHsMaxSem_Z", gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem_Z, false, includeNonInitialized);
         AddObjectProperty("PaiTipoHsMaxMes_Z", gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes_Z, false, includeNonInitialized);
         AddObjectProperty("PaiTipoHsMaxAnu_Z", gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu_Z, false, includeNonInitialized);
         AddObjectProperty("PaiTipoTraHor_N", gxTv_SdtPais_tipo_trabajo_Paitipotrahor_N, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtPais_tipo_trabajo sdt )
   {
      if ( sdt.IsDirty("PaiTipoTraId") )
      {
         gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
         gxTv_SdtPais_tipo_trabajo_Paitipotraid = sdt.getgxTv_SdtPais_tipo_trabajo_Paitipotraid() ;
      }
      if ( sdt.IsDirty("PaiTipoTraNom") )
      {
         gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
         gxTv_SdtPais_tipo_trabajo_Paitipotranom = sdt.getgxTv_SdtPais_tipo_trabajo_Paitipotranom() ;
      }
      if ( sdt.IsDirty("PaiTipoTraHor") )
      {
         gxTv_SdtPais_tipo_trabajo_Paitipotrahor_N = sdt.getgxTv_SdtPais_tipo_trabajo_Paitipotrahor_N() ;
         gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
         gxTv_SdtPais_tipo_trabajo_Paitipotrahor = sdt.getgxTv_SdtPais_tipo_trabajo_Paitipotrahor() ;
      }
      if ( sdt.IsDirty("PaiTipoTraIns") )
      {
         gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
         gxTv_SdtPais_tipo_trabajo_Paitipotrains = sdt.getgxTv_SdtPais_tipo_trabajo_Paitipotrains() ;
      }
      if ( sdt.IsDirty("PaiTipoHsDia") )
      {
         gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
         gxTv_SdtPais_tipo_trabajo_Paitipohsdia = sdt.getgxTv_SdtPais_tipo_trabajo_Paitipohsdia() ;
      }
      if ( sdt.IsDirty("PaiTipoHsSem") )
      {
         gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
         gxTv_SdtPais_tipo_trabajo_Paitipohssem = sdt.getgxTv_SdtPais_tipo_trabajo_Paitipohssem() ;
      }
      if ( sdt.IsDirty("PaiTipoTarifaXLim") )
      {
         gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
         gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim = sdt.getgxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim() ;
      }
      if ( sdt.IsDirty("PaiTipoTarifaRec") )
      {
         gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
         gxTv_SdtPais_tipo_trabajo_Paitipotarifarec = sdt.getgxTv_SdtPais_tipo_trabajo_Paitipotarifarec() ;
      }
      if ( sdt.IsDirty("PaiTipoHsMaxDia") )
      {
         gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
         gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia = sdt.getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia() ;
      }
      if ( sdt.IsDirty("PaiTipoHsMaxSem") )
      {
         gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
         gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem = sdt.getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem() ;
      }
      if ( sdt.IsDirty("PaiTipoHsMaxMes") )
      {
         gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
         gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes = sdt.getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes() ;
      }
      if ( sdt.IsDirty("PaiTipoHsMaxAnu") )
      {
         gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
         gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu = sdt.getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu() ;
      }
   }

   public String getgxTv_SdtPais_tipo_trabajo_Paitipotraid( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotraid ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotraid( String value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipotraid");
      gxTv_SdtPais_tipo_trabajo_Paitipotraid = value ;
   }

   public String getgxTv_SdtPais_tipo_trabajo_Paitipotranom( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotranom ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotranom( String value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipotranom");
      gxTv_SdtPais_tipo_trabajo_Paitipotranom = value ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotranom_SetNull( )
   {
      gxTv_SdtPais_tipo_trabajo_Paitipotranom = "" ;
      SetDirty("Paitipotranom");
   }

   public boolean getgxTv_SdtPais_tipo_trabajo_Paitipotranom_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_tipo_trabajo_Paitipotrahor( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotrahor ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotrahor( String value )
   {
      gxTv_SdtPais_tipo_trabajo_Paitipotrahor_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipotrahor");
      gxTv_SdtPais_tipo_trabajo_Paitipotrahor = value ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotrahor_SetNull( )
   {
      gxTv_SdtPais_tipo_trabajo_Paitipotrahor_N = (byte)(1) ;
      gxTv_SdtPais_tipo_trabajo_Paitipotrahor = "" ;
      SetDirty("Paitipotrahor");
   }

   public boolean getgxTv_SdtPais_tipo_trabajo_Paitipotrahor_IsNull( )
   {
      return (gxTv_SdtPais_tipo_trabajo_Paitipotrahor_N==1) ;
   }

   public boolean getgxTv_SdtPais_tipo_trabajo_Paitipotrains( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotrains ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotrains( boolean value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipotrains");
      gxTv_SdtPais_tipo_trabajo_Paitipotrains = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_tipo_trabajo_Paitipohsdia( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohsdia ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipohsdia( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipohsdia");
      gxTv_SdtPais_tipo_trabajo_Paitipohsdia = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_tipo_trabajo_Paitipohssem( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohssem ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipohssem( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipohssem");
      gxTv_SdtPais_tipo_trabajo_Paitipohssem = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipotarifaxlim");
      gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_tipo_trabajo_Paitipotarifarec( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotarifarec ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotarifarec( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipotarifarec");
      gxTv_SdtPais_tipo_trabajo_Paitipotarifarec = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipohsmaxdia");
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipohsmaxsem");
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipohsmaxmes");
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipohsmaxanu");
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu = value ;
   }

   public String getgxTv_SdtPais_tipo_trabajo_Mode( )
   {
      return gxTv_SdtPais_tipo_trabajo_Mode ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Mode( String value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtPais_tipo_trabajo_Mode = value ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Mode_SetNull( )
   {
      gxTv_SdtPais_tipo_trabajo_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtPais_tipo_trabajo_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_tipo_trabajo_Modified( )
   {
      return gxTv_SdtPais_tipo_trabajo_Modified ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Modified( short value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtPais_tipo_trabajo_Modified = value ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Modified_SetNull( )
   {
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtPais_tipo_trabajo_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtPais_tipo_trabajo_Initialized( )
   {
      return gxTv_SdtPais_tipo_trabajo_Initialized ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Initialized( short value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtPais_tipo_trabajo_Initialized = value ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Initialized_SetNull( )
   {
      gxTv_SdtPais_tipo_trabajo_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtPais_tipo_trabajo_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_tipo_trabajo_Paitipotraid_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotraid_Z ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotraid_Z( String value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipotraid_Z");
      gxTv_SdtPais_tipo_trabajo_Paitipotraid_Z = value ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotraid_Z_SetNull( )
   {
      gxTv_SdtPais_tipo_trabajo_Paitipotraid_Z = "" ;
      SetDirty("Paitipotraid_Z");
   }

   public boolean getgxTv_SdtPais_tipo_trabajo_Paitipotraid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_tipo_trabajo_Paitipotranom_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotranom_Z ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotranom_Z( String value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipotranom_Z");
      gxTv_SdtPais_tipo_trabajo_Paitipotranom_Z = value ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotranom_Z_SetNull( )
   {
      gxTv_SdtPais_tipo_trabajo_Paitipotranom_Z = "" ;
      SetDirty("Paitipotranom_Z");
   }

   public boolean getgxTv_SdtPais_tipo_trabajo_Paitipotranom_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtPais_tipo_trabajo_Paitipotrahor_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotrahor_Z ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotrahor_Z( String value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipotrahor_Z");
      gxTv_SdtPais_tipo_trabajo_Paitipotrahor_Z = value ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotrahor_Z_SetNull( )
   {
      gxTv_SdtPais_tipo_trabajo_Paitipotrahor_Z = "" ;
      SetDirty("Paitipotrahor_Z");
   }

   public boolean getgxTv_SdtPais_tipo_trabajo_Paitipotrahor_Z_IsNull( )
   {
      return false ;
   }

   public boolean getgxTv_SdtPais_tipo_trabajo_Paitipotrains_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotrains_Z ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotrains_Z( boolean value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipotrains_Z");
      gxTv_SdtPais_tipo_trabajo_Paitipotrains_Z = value ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotrains_Z_SetNull( )
   {
      gxTv_SdtPais_tipo_trabajo_Paitipotrains_Z = false ;
      SetDirty("Paitipotrains_Z");
   }

   public boolean getgxTv_SdtPais_tipo_trabajo_Paitipotrains_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_tipo_trabajo_Paitipohsdia_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohsdia_Z ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipohsdia_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipohsdia_Z");
      gxTv_SdtPais_tipo_trabajo_Paitipohsdia_Z = value ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipohsdia_Z_SetNull( )
   {
      gxTv_SdtPais_tipo_trabajo_Paitipohsdia_Z = DecimalUtil.ZERO ;
      SetDirty("Paitipohsdia_Z");
   }

   public boolean getgxTv_SdtPais_tipo_trabajo_Paitipohsdia_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_tipo_trabajo_Paitipohssem_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohssem_Z ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipohssem_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipohssem_Z");
      gxTv_SdtPais_tipo_trabajo_Paitipohssem_Z = value ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipohssem_Z_SetNull( )
   {
      gxTv_SdtPais_tipo_trabajo_Paitipohssem_Z = DecimalUtil.ZERO ;
      SetDirty("Paitipohssem_Z");
   }

   public boolean getgxTv_SdtPais_tipo_trabajo_Paitipohssem_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim_Z ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipotarifaxlim_Z");
      gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim_Z = value ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim_Z_SetNull( )
   {
      gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim_Z = DecimalUtil.ZERO ;
      SetDirty("Paitipotarifaxlim_Z");
   }

   public boolean getgxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_tipo_trabajo_Paitipotarifarec_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotarifarec_Z ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotarifarec_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipotarifarec_Z");
      gxTv_SdtPais_tipo_trabajo_Paitipotarifarec_Z = value ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotarifarec_Z_SetNull( )
   {
      gxTv_SdtPais_tipo_trabajo_Paitipotarifarec_Z = DecimalUtil.ZERO ;
      SetDirty("Paitipotarifarec_Z");
   }

   public boolean getgxTv_SdtPais_tipo_trabajo_Paitipotarifarec_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia_Z ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipohsmaxdia_Z");
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia_Z = value ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia_Z_SetNull( )
   {
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia_Z = DecimalUtil.ZERO ;
      SetDirty("Paitipohsmaxdia_Z");
   }

   public boolean getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem_Z ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipohsmaxsem_Z");
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem_Z = value ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem_Z_SetNull( )
   {
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem_Z = DecimalUtil.ZERO ;
      SetDirty("Paitipohsmaxsem_Z");
   }

   public boolean getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes_Z ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipohsmaxmes_Z");
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes_Z = value ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes_Z_SetNull( )
   {
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes_Z = DecimalUtil.ZERO ;
      SetDirty("Paitipohsmaxmes_Z");
   }

   public boolean getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu_Z( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu_Z ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu_Z( java.math.BigDecimal value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipohsmaxanu_Z");
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu_Z = value ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu_Z_SetNull( )
   {
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu_Z = DecimalUtil.ZERO ;
      SetDirty("Paitipohsmaxanu_Z");
   }

   public boolean getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu_Z_IsNull( )
   {
      return false ;
   }

   public byte getgxTv_SdtPais_tipo_trabajo_Paitipotrahor_N( )
   {
      return gxTv_SdtPais_tipo_trabajo_Paitipotrahor_N ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotrahor_N( byte value )
   {
      gxTv_SdtPais_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtPais_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipotrahor_N");
      gxTv_SdtPais_tipo_trabajo_Paitipotrahor_N = value ;
   }

   public void setgxTv_SdtPais_tipo_trabajo_Paitipotrahor_N_SetNull( )
   {
      gxTv_SdtPais_tipo_trabajo_Paitipotrahor_N = (byte)(0) ;
      SetDirty("Paitipotrahor_N");
   }

   public boolean getgxTv_SdtPais_tipo_trabajo_Paitipotrahor_N_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtPais_tipo_trabajo_Paitipotraid = "" ;
      gxTv_SdtPais_tipo_trabajo_N = (byte)(1) ;
      gxTv_SdtPais_tipo_trabajo_Paitipotranom = "" ;
      gxTv_SdtPais_tipo_trabajo_Paitipotrahor = "" ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsdia = DecimalUtil.ZERO ;
      gxTv_SdtPais_tipo_trabajo_Paitipohssem = DecimalUtil.ZERO ;
      gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim = DecimalUtil.ZERO ;
      gxTv_SdtPais_tipo_trabajo_Paitipotarifarec = DecimalUtil.ZERO ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia = DecimalUtil.ZERO ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem = DecimalUtil.ZERO ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes = DecimalUtil.ZERO ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu = DecimalUtil.ZERO ;
      gxTv_SdtPais_tipo_trabajo_Mode = "" ;
      gxTv_SdtPais_tipo_trabajo_Paitipotraid_Z = "" ;
      gxTv_SdtPais_tipo_trabajo_Paitipotranom_Z = "" ;
      gxTv_SdtPais_tipo_trabajo_Paitipotrahor_Z = "" ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsdia_Z = DecimalUtil.ZERO ;
      gxTv_SdtPais_tipo_trabajo_Paitipohssem_Z = DecimalUtil.ZERO ;
      gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim_Z = DecimalUtil.ZERO ;
      gxTv_SdtPais_tipo_trabajo_Paitipotarifarec_Z = DecimalUtil.ZERO ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia_Z = DecimalUtil.ZERO ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem_Z = DecimalUtil.ZERO ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes_Z = DecimalUtil.ZERO ;
      gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu_Z = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtPais_tipo_trabajo_N ;
   }

   public web.SdtPais_tipo_trabajo Clone( )
   {
      return (web.SdtPais_tipo_trabajo)(clone()) ;
   }

   public void setStruct( web.StructSdtPais_tipo_trabajo struct )
   {
      setgxTv_SdtPais_tipo_trabajo_Paitipotraid(struct.getPaitipotraid());
      setgxTv_SdtPais_tipo_trabajo_Paitipotranom(struct.getPaitipotranom());
      setgxTv_SdtPais_tipo_trabajo_Paitipotrahor(struct.getPaitipotrahor());
      setgxTv_SdtPais_tipo_trabajo_Paitipotrains(struct.getPaitipotrains());
      setgxTv_SdtPais_tipo_trabajo_Paitipohsdia(struct.getPaitipohsdia());
      setgxTv_SdtPais_tipo_trabajo_Paitipohssem(struct.getPaitipohssem());
      setgxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim(struct.getPaitipotarifaxlim());
      setgxTv_SdtPais_tipo_trabajo_Paitipotarifarec(struct.getPaitipotarifarec());
      setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia(struct.getPaitipohsmaxdia());
      setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem(struct.getPaitipohsmaxsem());
      setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes(struct.getPaitipohsmaxmes());
      setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu(struct.getPaitipohsmaxanu());
      setgxTv_SdtPais_tipo_trabajo_Mode(struct.getMode());
      setgxTv_SdtPais_tipo_trabajo_Modified(struct.getModified());
      setgxTv_SdtPais_tipo_trabajo_Initialized(struct.getInitialized());
      setgxTv_SdtPais_tipo_trabajo_Paitipotraid_Z(struct.getPaitipotraid_Z());
      setgxTv_SdtPais_tipo_trabajo_Paitipotranom_Z(struct.getPaitipotranom_Z());
      setgxTv_SdtPais_tipo_trabajo_Paitipotrahor_Z(struct.getPaitipotrahor_Z());
      setgxTv_SdtPais_tipo_trabajo_Paitipotrains_Z(struct.getPaitipotrains_Z());
      setgxTv_SdtPais_tipo_trabajo_Paitipohsdia_Z(struct.getPaitipohsdia_Z());
      setgxTv_SdtPais_tipo_trabajo_Paitipohssem_Z(struct.getPaitipohssem_Z());
      setgxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim_Z(struct.getPaitipotarifaxlim_Z());
      setgxTv_SdtPais_tipo_trabajo_Paitipotarifarec_Z(struct.getPaitipotarifarec_Z());
      setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia_Z(struct.getPaitipohsmaxdia_Z());
      setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem_Z(struct.getPaitipohsmaxsem_Z());
      setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes_Z(struct.getPaitipohsmaxmes_Z());
      setgxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu_Z(struct.getPaitipohsmaxanu_Z());
      setgxTv_SdtPais_tipo_trabajo_Paitipotrahor_N(struct.getPaitipotrahor_N());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtPais_tipo_trabajo getStruct( )
   {
      web.StructSdtPais_tipo_trabajo struct = new web.StructSdtPais_tipo_trabajo ();
      struct.setPaitipotraid(getgxTv_SdtPais_tipo_trabajo_Paitipotraid());
      struct.setPaitipotranom(getgxTv_SdtPais_tipo_trabajo_Paitipotranom());
      struct.setPaitipotrahor(getgxTv_SdtPais_tipo_trabajo_Paitipotrahor());
      struct.setPaitipotrains(getgxTv_SdtPais_tipo_trabajo_Paitipotrains());
      struct.setPaitipohsdia(getgxTv_SdtPais_tipo_trabajo_Paitipohsdia());
      struct.setPaitipohssem(getgxTv_SdtPais_tipo_trabajo_Paitipohssem());
      struct.setPaitipotarifaxlim(getgxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim());
      struct.setPaitipotarifarec(getgxTv_SdtPais_tipo_trabajo_Paitipotarifarec());
      struct.setPaitipohsmaxdia(getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia());
      struct.setPaitipohsmaxsem(getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem());
      struct.setPaitipohsmaxmes(getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes());
      struct.setPaitipohsmaxanu(getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu());
      struct.setMode(getgxTv_SdtPais_tipo_trabajo_Mode());
      struct.setModified(getgxTv_SdtPais_tipo_trabajo_Modified());
      struct.setInitialized(getgxTv_SdtPais_tipo_trabajo_Initialized());
      struct.setPaitipotraid_Z(getgxTv_SdtPais_tipo_trabajo_Paitipotraid_Z());
      struct.setPaitipotranom_Z(getgxTv_SdtPais_tipo_trabajo_Paitipotranom_Z());
      struct.setPaitipotrahor_Z(getgxTv_SdtPais_tipo_trabajo_Paitipotrahor_Z());
      struct.setPaitipotrains_Z(getgxTv_SdtPais_tipo_trabajo_Paitipotrains_Z());
      struct.setPaitipohsdia_Z(getgxTv_SdtPais_tipo_trabajo_Paitipohsdia_Z());
      struct.setPaitipohssem_Z(getgxTv_SdtPais_tipo_trabajo_Paitipohssem_Z());
      struct.setPaitipotarifaxlim_Z(getgxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim_Z());
      struct.setPaitipotarifarec_Z(getgxTv_SdtPais_tipo_trabajo_Paitipotarifarec_Z());
      struct.setPaitipohsmaxdia_Z(getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia_Z());
      struct.setPaitipohsmaxsem_Z(getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem_Z());
      struct.setPaitipohsmaxmes_Z(getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes_Z());
      struct.setPaitipohsmaxanu_Z(getgxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu_Z());
      struct.setPaitipotrahor_N(getgxTv_SdtPais_tipo_trabajo_Paitipotrahor_N());
      return struct ;
   }

   private byte gxTv_SdtPais_tipo_trabajo_N ;
   private byte gxTv_SdtPais_tipo_trabajo_Paitipotrahor_N ;
   private short gxTv_SdtPais_tipo_trabajo_Modified ;
   private short gxTv_SdtPais_tipo_trabajo_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohsdia ;
   private java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohssem ;
   private java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim ;
   private java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipotarifarec ;
   private java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia ;
   private java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem ;
   private java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes ;
   private java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu ;
   private java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohsdia_Z ;
   private java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohssem_Z ;
   private java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipotarifaxlim_Z ;
   private java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipotarifarec_Z ;
   private java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohsmaxdia_Z ;
   private java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohsmaxsem_Z ;
   private java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohsmaxmes_Z ;
   private java.math.BigDecimal gxTv_SdtPais_tipo_trabajo_Paitipohsmaxanu_Z ;
   private String gxTv_SdtPais_tipo_trabajo_Paitipotraid ;
   private String gxTv_SdtPais_tipo_trabajo_Paitipotrahor ;
   private String gxTv_SdtPais_tipo_trabajo_Mode ;
   private String gxTv_SdtPais_tipo_trabajo_Paitipotraid_Z ;
   private String gxTv_SdtPais_tipo_trabajo_Paitipotrahor_Z ;
   private String sTagName ;
   private boolean gxTv_SdtPais_tipo_trabajo_Paitipotrains ;
   private boolean gxTv_SdtPais_tipo_trabajo_Paitipotrains_Z ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtPais_tipo_trabajo_Paitipotranom ;
   private String gxTv_SdtPais_tipo_trabajo_Paitipotranom_Z ;
}

