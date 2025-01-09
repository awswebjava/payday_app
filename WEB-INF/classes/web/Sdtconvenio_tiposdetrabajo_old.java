package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class Sdtconvenio_tiposdetrabajo_old extends GxUserType
{
   public Sdtconvenio_tiposdetrabajo_old( )
   {
      this(  new ModelContext(Sdtconvenio_tiposdetrabajo_old.class));
   }

   public Sdtconvenio_tiposdetrabajo_old( ModelContext context )
   {
      super( context, "Sdtconvenio_tiposdetrabajo_old");
   }

   public Sdtconvenio_tiposdetrabajo_old( int remoteHandle ,
                                          ModelContext context )
   {
      super( remoteHandle, context, "Sdtconvenio_tiposdetrabajo_old");
   }

   public Sdtconvenio_tiposdetrabajo_old( StructSdtconvenio_tiposdetrabajo_old struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveHsDia") )
            {
               gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsdia = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveHsSem") )
            {
               gxTv_Sdtconvenio_tiposdetrabajo_old_Convehssem = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveTarifaXLim") )
            {
               gxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifaxlim = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveTarifaRec") )
            {
               gxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifarec = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveHsMaxDia") )
            {
               gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxdia = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveHsMaxSem") )
            {
               gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxsem = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveHsMaxMes") )
            {
               gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxmes = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "ConveHsMaxAnu") )
            {
               gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxanu = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "convenio_tiposdetrabajo_old" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "PayDay" ;
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
      oWriter.writeElement("ConveHsDia", GXutil.trim( GXutil.strNoRound( gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsdia, 3, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveHsSem", GXutil.trim( GXutil.strNoRound( gxTv_Sdtconvenio_tiposdetrabajo_old_Convehssem, 4, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveTarifaXLim", GXutil.trim( GXutil.strNoRound( gxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifaxlim, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveTarifaRec", GXutil.trim( GXutil.strNoRound( gxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifarec, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveHsMaxDia", GXutil.trim( GXutil.strNoRound( gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxdia, 3, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveHsMaxSem", GXutil.trim( GXutil.strNoRound( gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxsem, 4, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveHsMaxMes", GXutil.trim( GXutil.strNoRound( gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxmes, 5, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("ConveHsMaxAnu", GXutil.trim( GXutil.strNoRound( gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxanu, 5, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeEndElement();
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
      AddObjectProperty("ConveHsDia", gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsdia, false, false);
      AddObjectProperty("ConveHsSem", gxTv_Sdtconvenio_tiposdetrabajo_old_Convehssem, false, false);
      AddObjectProperty("ConveTarifaXLim", gxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifaxlim, false, false);
      AddObjectProperty("ConveTarifaRec", gxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifarec, false, false);
      AddObjectProperty("ConveHsMaxDia", gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxdia, false, false);
      AddObjectProperty("ConveHsMaxSem", gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxsem, false, false);
      AddObjectProperty("ConveHsMaxMes", gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxmes, false, false);
      AddObjectProperty("ConveHsMaxAnu", gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxanu, false, false);
   }

   public java.math.BigDecimal getgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsdia( )
   {
      return gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsdia ;
   }

   public void setgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsdia( java.math.BigDecimal value )
   {
      gxTv_Sdtconvenio_tiposdetrabajo_old_N = (byte)(0) ;
      gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsdia = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtconvenio_tiposdetrabajo_old_Convehssem( )
   {
      return gxTv_Sdtconvenio_tiposdetrabajo_old_Convehssem ;
   }

   public void setgxTv_Sdtconvenio_tiposdetrabajo_old_Convehssem( java.math.BigDecimal value )
   {
      gxTv_Sdtconvenio_tiposdetrabajo_old_N = (byte)(0) ;
      gxTv_Sdtconvenio_tiposdetrabajo_old_Convehssem = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifaxlim( )
   {
      return gxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifaxlim ;
   }

   public void setgxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifaxlim( java.math.BigDecimal value )
   {
      gxTv_Sdtconvenio_tiposdetrabajo_old_N = (byte)(0) ;
      gxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifaxlim = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifarec( )
   {
      return gxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifarec ;
   }

   public void setgxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifarec( java.math.BigDecimal value )
   {
      gxTv_Sdtconvenio_tiposdetrabajo_old_N = (byte)(0) ;
      gxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifarec = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxdia( )
   {
      return gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxdia ;
   }

   public void setgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxdia( java.math.BigDecimal value )
   {
      gxTv_Sdtconvenio_tiposdetrabajo_old_N = (byte)(0) ;
      gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxdia = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxsem( )
   {
      return gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxsem ;
   }

   public void setgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxsem( java.math.BigDecimal value )
   {
      gxTv_Sdtconvenio_tiposdetrabajo_old_N = (byte)(0) ;
      gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxsem = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxmes( )
   {
      return gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxmes ;
   }

   public void setgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxmes( java.math.BigDecimal value )
   {
      gxTv_Sdtconvenio_tiposdetrabajo_old_N = (byte)(0) ;
      gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxmes = value ;
   }

   public java.math.BigDecimal getgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxanu( )
   {
      return gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxanu ;
   }

   public void setgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxanu( java.math.BigDecimal value )
   {
      gxTv_Sdtconvenio_tiposdetrabajo_old_N = (byte)(0) ;
      gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxanu = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsdia = DecimalUtil.ZERO ;
      gxTv_Sdtconvenio_tiposdetrabajo_old_N = (byte)(1) ;
      gxTv_Sdtconvenio_tiposdetrabajo_old_Convehssem = DecimalUtil.ZERO ;
      gxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifaxlim = DecimalUtil.ZERO ;
      gxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifarec = DecimalUtil.ZERO ;
      gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxdia = DecimalUtil.ZERO ;
      gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxsem = DecimalUtil.ZERO ;
      gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxmes = DecimalUtil.ZERO ;
      gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxanu = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_Sdtconvenio_tiposdetrabajo_old_N ;
   }

   public web.Sdtconvenio_tiposdetrabajo_old Clone( )
   {
      return (web.Sdtconvenio_tiposdetrabajo_old)(clone()) ;
   }

   public void setStruct( web.StructSdtconvenio_tiposdetrabajo_old struct )
   {
      setgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsdia(struct.getConvehsdia());
      setgxTv_Sdtconvenio_tiposdetrabajo_old_Convehssem(struct.getConvehssem());
      setgxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifaxlim(struct.getConvetarifaxlim());
      setgxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifarec(struct.getConvetarifarec());
      setgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxdia(struct.getConvehsmaxdia());
      setgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxsem(struct.getConvehsmaxsem());
      setgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxmes(struct.getConvehsmaxmes());
      setgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxanu(struct.getConvehsmaxanu());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtconvenio_tiposdetrabajo_old getStruct( )
   {
      web.StructSdtconvenio_tiposdetrabajo_old struct = new web.StructSdtconvenio_tiposdetrabajo_old ();
      struct.setConvehsdia(getgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsdia());
      struct.setConvehssem(getgxTv_Sdtconvenio_tiposdetrabajo_old_Convehssem());
      struct.setConvetarifaxlim(getgxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifaxlim());
      struct.setConvetarifarec(getgxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifarec());
      struct.setConvehsmaxdia(getgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxdia());
      struct.setConvehsmaxsem(getgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxsem());
      struct.setConvehsmaxmes(getgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxmes());
      struct.setConvehsmaxanu(getgxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxanu());
      return struct ;
   }

   protected byte gxTv_Sdtconvenio_tiposdetrabajo_old_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsdia ;
   protected java.math.BigDecimal gxTv_Sdtconvenio_tiposdetrabajo_old_Convehssem ;
   protected java.math.BigDecimal gxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifaxlim ;
   protected java.math.BigDecimal gxTv_Sdtconvenio_tiposdetrabajo_old_Convetarifarec ;
   protected java.math.BigDecimal gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxdia ;
   protected java.math.BigDecimal gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxsem ;
   protected java.math.BigDecimal gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxmes ;
   protected java.math.BigDecimal gxTv_Sdtconvenio_tiposdetrabajo_old_Convehsmaxanu ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

