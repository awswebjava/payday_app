package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtEmpresa_tipo_trabajo extends GxSilentTrnSdt
{
   public SdtEmpresa_tipo_trabajo( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtEmpresa_tipo_trabajo.class));
   }

   public SdtEmpresa_tipo_trabajo( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle, context, "SdtEmpresa_tipo_trabajo");
      initialize( remoteHandle) ;
   }

   public SdtEmpresa_tipo_trabajo( int remoteHandle ,
                                   StructSdtEmpresa_tipo_trabajo struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtEmpresa_tipo_trabajo( )
   {
      super( new ModelContext(SdtEmpresa_tipo_trabajo.class), "SdtEmpresa_tipo_trabajo");
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
      metadata.set("BT", "Empresatipo_trabajo");
      metadata.set("PK", "[ \"PaiTipoTraId\" ]");
      metadata.set("PKAssigned", "[ \"PaiTipoTraId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CliCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"CliCod\",\"EmpCod\" ],\"FKMap\":[  ] },{ \"FK\":[ \"TipoTraId\" ],\"FKMap\":[ \"PaiTipoTraId-TipoTraId\" ] } ]");
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
               gxTv_SdtEmpresa_tipo_trabajo_Paitipotraid = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpHsDia") )
            {
               gxTv_SdtEmpresa_tipo_trabajo_Emphsdia = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpHsSem") )
            {
               gxTv_SdtEmpresa_tipo_trabajo_Emphssem = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpTarifaXLim") )
            {
               gxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpTarifaRec") )
            {
               gxTv_SdtEmpresa_tipo_trabajo_Emptarifarec = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpHsMaxDia") )
            {
               gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpHsMaxSem") )
            {
               gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpHsMaxMes") )
            {
               gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpHsMaxAnu") )
            {
               gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtEmpresa_tipo_trabajo_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtEmpresa_tipo_trabajo_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtEmpresa_tipo_trabajo_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoTraId_Z") )
            {
               gxTv_SdtEmpresa_tipo_trabajo_Paitipotraid_Z = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpHsDia_Z") )
            {
               gxTv_SdtEmpresa_tipo_trabajo_Emphsdia_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpHsSem_Z") )
            {
               gxTv_SdtEmpresa_tipo_trabajo_Emphssem_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpTarifaXLim_Z") )
            {
               gxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpTarifaRec_Z") )
            {
               gxTv_SdtEmpresa_tipo_trabajo_Emptarifarec_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpHsMaxDia_Z") )
            {
               gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpHsMaxSem_Z") )
            {
               gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpHsMaxMes_Z") )
            {
               gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "EmpHsMaxAnu_Z") )
            {
               gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu_Z = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "Empresa.tipo_trabajo" ;
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
      oWriter.writeElement("PaiTipoTraId", gxTv_SdtEmpresa_tipo_trabajo_Paitipotraid);
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpHsDia", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_tipo_trabajo_Emphsdia, 3, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpHsSem", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_tipo_trabajo_Emphssem, 4, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpTarifaXLim", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpTarifaRec", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_tipo_trabajo_Emptarifarec, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpHsMaxDia", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia, 3, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpHsMaxSem", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem, 4, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpHsMaxMes", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes, 5, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("EmpHsMaxAnu", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu, 5, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtEmpresa_tipo_trabajo_Mode);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_tipo_trabajo_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtEmpresa_tipo_trabajo_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("PaiTipoTraId_Z", gxTv_SdtEmpresa_tipo_trabajo_Paitipotraid_Z);
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpHsDia_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_tipo_trabajo_Emphsdia_Z, 3, 1)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpHsSem_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_tipo_trabajo_Emphssem_Z, 4, 1)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpTarifaXLim_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim_Z, 6, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpTarifaRec_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_tipo_trabajo_Emptarifarec_Z, 6, 4)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpHsMaxDia_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia_Z, 3, 1)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpHsMaxSem_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem_Z, 4, 1)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpHsMaxMes_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes_Z, 5, 1)));
         if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
         {
            oWriter.writeAttribute("xmlns", "PayDay");
         }
         oWriter.writeElement("EmpHsMaxAnu_Z", GXutil.trim( GXutil.strNoRound( gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu_Z, 5, 1)));
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
      AddObjectProperty("PaiTipoTraId", gxTv_SdtEmpresa_tipo_trabajo_Paitipotraid, false, includeNonInitialized);
      AddObjectProperty("EmpHsDia", gxTv_SdtEmpresa_tipo_trabajo_Emphsdia, false, includeNonInitialized);
      AddObjectProperty("EmpHsSem", gxTv_SdtEmpresa_tipo_trabajo_Emphssem, false, includeNonInitialized);
      AddObjectProperty("EmpTarifaXLim", gxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim, false, includeNonInitialized);
      AddObjectProperty("EmpTarifaRec", gxTv_SdtEmpresa_tipo_trabajo_Emptarifarec, false, includeNonInitialized);
      AddObjectProperty("EmpHsMaxDia", gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia, false, includeNonInitialized);
      AddObjectProperty("EmpHsMaxSem", gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem, false, includeNonInitialized);
      AddObjectProperty("EmpHsMaxMes", gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes, false, includeNonInitialized);
      AddObjectProperty("EmpHsMaxAnu", gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtEmpresa_tipo_trabajo_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtEmpresa_tipo_trabajo_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtEmpresa_tipo_trabajo_Initialized, false, includeNonInitialized);
         AddObjectProperty("PaiTipoTraId_Z", gxTv_SdtEmpresa_tipo_trabajo_Paitipotraid_Z, false, includeNonInitialized);
         AddObjectProperty("EmpHsDia_Z", gxTv_SdtEmpresa_tipo_trabajo_Emphsdia_Z, false, includeNonInitialized);
         AddObjectProperty("EmpHsSem_Z", gxTv_SdtEmpresa_tipo_trabajo_Emphssem_Z, false, includeNonInitialized);
         AddObjectProperty("EmpTarifaXLim_Z", gxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim_Z, false, includeNonInitialized);
         AddObjectProperty("EmpTarifaRec_Z", gxTv_SdtEmpresa_tipo_trabajo_Emptarifarec_Z, false, includeNonInitialized);
         AddObjectProperty("EmpHsMaxDia_Z", gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia_Z, false, includeNonInitialized);
         AddObjectProperty("EmpHsMaxSem_Z", gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem_Z, false, includeNonInitialized);
         AddObjectProperty("EmpHsMaxMes_Z", gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes_Z, false, includeNonInitialized);
         AddObjectProperty("EmpHsMaxAnu_Z", gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( web.SdtEmpresa_tipo_trabajo sdt )
   {
      if ( sdt.IsDirty("PaiTipoTraId") )
      {
         gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
         gxTv_SdtEmpresa_tipo_trabajo_Paitipotraid = sdt.getgxTv_SdtEmpresa_tipo_trabajo_Paitipotraid() ;
      }
      if ( sdt.IsDirty("EmpHsDia") )
      {
         gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
         gxTv_SdtEmpresa_tipo_trabajo_Emphsdia = sdt.getgxTv_SdtEmpresa_tipo_trabajo_Emphsdia() ;
      }
      if ( sdt.IsDirty("EmpHsSem") )
      {
         gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
         gxTv_SdtEmpresa_tipo_trabajo_Emphssem = sdt.getgxTv_SdtEmpresa_tipo_trabajo_Emphssem() ;
      }
      if ( sdt.IsDirty("EmpTarifaXLim") )
      {
         gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
         gxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim = sdt.getgxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim() ;
      }
      if ( sdt.IsDirty("EmpTarifaRec") )
      {
         gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
         gxTv_SdtEmpresa_tipo_trabajo_Emptarifarec = sdt.getgxTv_SdtEmpresa_tipo_trabajo_Emptarifarec() ;
      }
      if ( sdt.IsDirty("EmpHsMaxDia") )
      {
         gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
         gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia = sdt.getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia() ;
      }
      if ( sdt.IsDirty("EmpHsMaxSem") )
      {
         gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
         gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem = sdt.getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem() ;
      }
      if ( sdt.IsDirty("EmpHsMaxMes") )
      {
         gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
         gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes = sdt.getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes() ;
      }
      if ( sdt.IsDirty("EmpHsMaxAnu") )
      {
         gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
         gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu = sdt.getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu() ;
      }
   }

   public String getgxTv_SdtEmpresa_tipo_trabajo_Paitipotraid( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_Paitipotraid ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Paitipotraid( String value )
   {
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtEmpresa_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipotraid");
      gxTv_SdtEmpresa_tipo_trabajo_Paitipotraid = value ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_tipo_trabajo_Emphsdia( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_Emphsdia ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emphsdia( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtEmpresa_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Emphsdia");
      gxTv_SdtEmpresa_tipo_trabajo_Emphsdia = value ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_tipo_trabajo_Emphssem( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_Emphssem ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emphssem( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtEmpresa_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Emphssem");
      gxTv_SdtEmpresa_tipo_trabajo_Emphssem = value ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtEmpresa_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Emptarifaxlim");
      gxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim = value ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_tipo_trabajo_Emptarifarec( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_Emptarifarec ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emptarifarec( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtEmpresa_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Emptarifarec");
      gxTv_SdtEmpresa_tipo_trabajo_Emptarifarec = value ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtEmpresa_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Emphsmaxdia");
      gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia = value ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtEmpresa_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Emphsmaxsem");
      gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem = value ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtEmpresa_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Emphsmaxmes");
      gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes = value ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtEmpresa_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Emphsmaxanu");
      gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu = value ;
   }

   public String getgxTv_SdtEmpresa_tipo_trabajo_Mode( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_Mode ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Mode( String value )
   {
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtEmpresa_tipo_trabajo_Mode = value ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Mode_SetNull( )
   {
      gxTv_SdtEmpresa_tipo_trabajo_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtEmpresa_tipo_trabajo_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_tipo_trabajo_Modified( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_Modified ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Modified( short value )
   {
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtEmpresa_tipo_trabajo_Modified = value ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Modified_SetNull( )
   {
      gxTv_SdtEmpresa_tipo_trabajo_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtEmpresa_tipo_trabajo_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtEmpresa_tipo_trabajo_Initialized( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_Initialized ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Initialized( short value )
   {
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtEmpresa_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtEmpresa_tipo_trabajo_Initialized = value ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Initialized_SetNull( )
   {
      gxTv_SdtEmpresa_tipo_trabajo_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtEmpresa_tipo_trabajo_Initialized_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtEmpresa_tipo_trabajo_Paitipotraid_Z( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_Paitipotraid_Z ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Paitipotraid_Z( String value )
   {
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtEmpresa_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Paitipotraid_Z");
      gxTv_SdtEmpresa_tipo_trabajo_Paitipotraid_Z = value ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Paitipotraid_Z_SetNull( )
   {
      gxTv_SdtEmpresa_tipo_trabajo_Paitipotraid_Z = "" ;
      SetDirty("Paitipotraid_Z");
   }

   public boolean getgxTv_SdtEmpresa_tipo_trabajo_Paitipotraid_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_tipo_trabajo_Emphsdia_Z( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_Emphsdia_Z ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emphsdia_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtEmpresa_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Emphsdia_Z");
      gxTv_SdtEmpresa_tipo_trabajo_Emphsdia_Z = value ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emphsdia_Z_SetNull( )
   {
      gxTv_SdtEmpresa_tipo_trabajo_Emphsdia_Z = DecimalUtil.ZERO ;
      SetDirty("Emphsdia_Z");
   }

   public boolean getgxTv_SdtEmpresa_tipo_trabajo_Emphsdia_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_tipo_trabajo_Emphssem_Z( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_Emphssem_Z ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emphssem_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtEmpresa_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Emphssem_Z");
      gxTv_SdtEmpresa_tipo_trabajo_Emphssem_Z = value ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emphssem_Z_SetNull( )
   {
      gxTv_SdtEmpresa_tipo_trabajo_Emphssem_Z = DecimalUtil.ZERO ;
      SetDirty("Emphssem_Z");
   }

   public boolean getgxTv_SdtEmpresa_tipo_trabajo_Emphssem_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim_Z( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim_Z ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtEmpresa_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Emptarifaxlim_Z");
      gxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim_Z = value ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim_Z_SetNull( )
   {
      gxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim_Z = DecimalUtil.ZERO ;
      SetDirty("Emptarifaxlim_Z");
   }

   public boolean getgxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_tipo_trabajo_Emptarifarec_Z( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_Emptarifarec_Z ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emptarifarec_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtEmpresa_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Emptarifarec_Z");
      gxTv_SdtEmpresa_tipo_trabajo_Emptarifarec_Z = value ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emptarifarec_Z_SetNull( )
   {
      gxTv_SdtEmpresa_tipo_trabajo_Emptarifarec_Z = DecimalUtil.ZERO ;
      SetDirty("Emptarifarec_Z");
   }

   public boolean getgxTv_SdtEmpresa_tipo_trabajo_Emptarifarec_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia_Z( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia_Z ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtEmpresa_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Emphsmaxdia_Z");
      gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia_Z = value ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia_Z_SetNull( )
   {
      gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia_Z = DecimalUtil.ZERO ;
      SetDirty("Emphsmaxdia_Z");
   }

   public boolean getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem_Z( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem_Z ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtEmpresa_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Emphsmaxsem_Z");
      gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem_Z = value ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem_Z_SetNull( )
   {
      gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem_Z = DecimalUtil.ZERO ;
      SetDirty("Emphsmaxsem_Z");
   }

   public boolean getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes_Z( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes_Z ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtEmpresa_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Emphsmaxmes_Z");
      gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes_Z = value ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes_Z_SetNull( )
   {
      gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes_Z = DecimalUtil.ZERO ;
      SetDirty("Emphsmaxmes_Z");
   }

   public boolean getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes_Z_IsNull( )
   {
      return false ;
   }

   public java.math.BigDecimal getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu_Z( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu_Z ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu_Z( java.math.BigDecimal value )
   {
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(0) ;
      gxTv_SdtEmpresa_tipo_trabajo_Modified = (short)(1) ;
      SetDirty("Emphsmaxanu_Z");
      gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu_Z = value ;
   }

   public void setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu_Z_SetNull( )
   {
      gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu_Z = DecimalUtil.ZERO ;
      SetDirty("Emphsmaxanu_Z");
   }

   public boolean getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtEmpresa_tipo_trabajo_Paitipotraid = "" ;
      gxTv_SdtEmpresa_tipo_trabajo_N = (byte)(1) ;
      gxTv_SdtEmpresa_tipo_trabajo_Emphsdia = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_tipo_trabajo_Emphssem = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_tipo_trabajo_Emptarifarec = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_tipo_trabajo_Mode = "" ;
      gxTv_SdtEmpresa_tipo_trabajo_Paitipotraid_Z = "" ;
      gxTv_SdtEmpresa_tipo_trabajo_Emphsdia_Z = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_tipo_trabajo_Emphssem_Z = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim_Z = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_tipo_trabajo_Emptarifarec_Z = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia_Z = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem_Z = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes_Z = DecimalUtil.ZERO ;
      gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu_Z = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtEmpresa_tipo_trabajo_N ;
   }

   public web.SdtEmpresa_tipo_trabajo Clone( )
   {
      return (web.SdtEmpresa_tipo_trabajo)(clone()) ;
   }

   public void setStruct( web.StructSdtEmpresa_tipo_trabajo struct )
   {
      setgxTv_SdtEmpresa_tipo_trabajo_Paitipotraid(struct.getPaitipotraid());
      setgxTv_SdtEmpresa_tipo_trabajo_Emphsdia(struct.getEmphsdia());
      setgxTv_SdtEmpresa_tipo_trabajo_Emphssem(struct.getEmphssem());
      setgxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim(struct.getEmptarifaxlim());
      setgxTv_SdtEmpresa_tipo_trabajo_Emptarifarec(struct.getEmptarifarec());
      setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia(struct.getEmphsmaxdia());
      setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem(struct.getEmphsmaxsem());
      setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes(struct.getEmphsmaxmes());
      setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu(struct.getEmphsmaxanu());
      setgxTv_SdtEmpresa_tipo_trabajo_Mode(struct.getMode());
      setgxTv_SdtEmpresa_tipo_trabajo_Modified(struct.getModified());
      setgxTv_SdtEmpresa_tipo_trabajo_Initialized(struct.getInitialized());
      setgxTv_SdtEmpresa_tipo_trabajo_Paitipotraid_Z(struct.getPaitipotraid_Z());
      setgxTv_SdtEmpresa_tipo_trabajo_Emphsdia_Z(struct.getEmphsdia_Z());
      setgxTv_SdtEmpresa_tipo_trabajo_Emphssem_Z(struct.getEmphssem_Z());
      setgxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim_Z(struct.getEmptarifaxlim_Z());
      setgxTv_SdtEmpresa_tipo_trabajo_Emptarifarec_Z(struct.getEmptarifarec_Z());
      setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia_Z(struct.getEmphsmaxdia_Z());
      setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem_Z(struct.getEmphsmaxsem_Z());
      setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes_Z(struct.getEmphsmaxmes_Z());
      setgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu_Z(struct.getEmphsmaxanu_Z());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtEmpresa_tipo_trabajo getStruct( )
   {
      web.StructSdtEmpresa_tipo_trabajo struct = new web.StructSdtEmpresa_tipo_trabajo ();
      struct.setPaitipotraid(getgxTv_SdtEmpresa_tipo_trabajo_Paitipotraid());
      struct.setEmphsdia(getgxTv_SdtEmpresa_tipo_trabajo_Emphsdia());
      struct.setEmphssem(getgxTv_SdtEmpresa_tipo_trabajo_Emphssem());
      struct.setEmptarifaxlim(getgxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim());
      struct.setEmptarifarec(getgxTv_SdtEmpresa_tipo_trabajo_Emptarifarec());
      struct.setEmphsmaxdia(getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia());
      struct.setEmphsmaxsem(getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem());
      struct.setEmphsmaxmes(getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes());
      struct.setEmphsmaxanu(getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu());
      struct.setMode(getgxTv_SdtEmpresa_tipo_trabajo_Mode());
      struct.setModified(getgxTv_SdtEmpresa_tipo_trabajo_Modified());
      struct.setInitialized(getgxTv_SdtEmpresa_tipo_trabajo_Initialized());
      struct.setPaitipotraid_Z(getgxTv_SdtEmpresa_tipo_trabajo_Paitipotraid_Z());
      struct.setEmphsdia_Z(getgxTv_SdtEmpresa_tipo_trabajo_Emphsdia_Z());
      struct.setEmphssem_Z(getgxTv_SdtEmpresa_tipo_trabajo_Emphssem_Z());
      struct.setEmptarifaxlim_Z(getgxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim_Z());
      struct.setEmptarifarec_Z(getgxTv_SdtEmpresa_tipo_trabajo_Emptarifarec_Z());
      struct.setEmphsmaxdia_Z(getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia_Z());
      struct.setEmphsmaxsem_Z(getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem_Z());
      struct.setEmphsmaxmes_Z(getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes_Z());
      struct.setEmphsmaxanu_Z(getgxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu_Z());
      return struct ;
   }

   private byte gxTv_SdtEmpresa_tipo_trabajo_N ;
   private short gxTv_SdtEmpresa_tipo_trabajo_Modified ;
   private short gxTv_SdtEmpresa_tipo_trabajo_Initialized ;
   private short readOk ;
   private short nOutParmCount ;
   private java.math.BigDecimal gxTv_SdtEmpresa_tipo_trabajo_Emphsdia ;
   private java.math.BigDecimal gxTv_SdtEmpresa_tipo_trabajo_Emphssem ;
   private java.math.BigDecimal gxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim ;
   private java.math.BigDecimal gxTv_SdtEmpresa_tipo_trabajo_Emptarifarec ;
   private java.math.BigDecimal gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia ;
   private java.math.BigDecimal gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem ;
   private java.math.BigDecimal gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes ;
   private java.math.BigDecimal gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu ;
   private java.math.BigDecimal gxTv_SdtEmpresa_tipo_trabajo_Emphsdia_Z ;
   private java.math.BigDecimal gxTv_SdtEmpresa_tipo_trabajo_Emphssem_Z ;
   private java.math.BigDecimal gxTv_SdtEmpresa_tipo_trabajo_Emptarifaxlim_Z ;
   private java.math.BigDecimal gxTv_SdtEmpresa_tipo_trabajo_Emptarifarec_Z ;
   private java.math.BigDecimal gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxdia_Z ;
   private java.math.BigDecimal gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxsem_Z ;
   private java.math.BigDecimal gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxmes_Z ;
   private java.math.BigDecimal gxTv_SdtEmpresa_tipo_trabajo_Emphsmaxanu_Z ;
   private String gxTv_SdtEmpresa_tipo_trabajo_Paitipotraid ;
   private String gxTv_SdtEmpresa_tipo_trabajo_Mode ;
   private String gxTv_SdtEmpresa_tipo_trabajo_Paitipotraid_Z ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
}

