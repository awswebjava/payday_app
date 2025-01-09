package web ;
import web.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtPaisTipoTrabajo_old extends GxUserType
{
   public SdtPaisTipoTrabajo_old( )
   {
      this(  new ModelContext(SdtPaisTipoTrabajo_old.class));
   }

   public SdtPaisTipoTrabajo_old( ModelContext context )
   {
      super( context, "SdtPaisTipoTrabajo_old");
   }

   public SdtPaisTipoTrabajo_old( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle, context, "SdtPaisTipoTrabajo_old");
   }

   public SdtPaisTipoTrabajo_old( StructSdtPaisTipoTrabajo_old struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoHsDia") )
            {
               gxTv_SdtPaisTipoTrabajo_old_Paitipohsdia = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoHsSem") )
            {
               gxTv_SdtPaisTipoTrabajo_old_Paitipohssem = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoTarifaXLim") )
            {
               gxTv_SdtPaisTipoTrabajo_old_Paitipotarifaxlim = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoTarifaRec") )
            {
               gxTv_SdtPaisTipoTrabajo_old_Paitipotarifarec = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoHsMaxDia") )
            {
               gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxdia = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoHsMaxSem") )
            {
               gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxsem = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoHsMaxMes") )
            {
               gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxmes = DecimalUtil.stringToDec( oReader.getValue()) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "PaiTipoHsMaxAnu") )
            {
               gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxanu = DecimalUtil.stringToDec( oReader.getValue()) ;
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
         sName = "PaisTipoTrabajo_old" ;
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
      oWriter.writeElement("PaiTipoHsDia", GXutil.trim( GXutil.strNoRound( gxTv_SdtPaisTipoTrabajo_old_Paitipohsdia, 3, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTipoHsSem", GXutil.trim( GXutil.strNoRound( gxTv_SdtPaisTipoTrabajo_old_Paitipohssem, 4, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTipoTarifaXLim", GXutil.trim( GXutil.strNoRound( gxTv_SdtPaisTipoTrabajo_old_Paitipotarifaxlim, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTipoTarifaRec", GXutil.trim( GXutil.strNoRound( gxTv_SdtPaisTipoTrabajo_old_Paitipotarifarec, 6, 4)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTipoHsMaxDia", GXutil.trim( GXutil.strNoRound( gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxdia, 3, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTipoHsMaxSem", GXutil.trim( GXutil.strNoRound( gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxsem, 4, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTipoHsMaxMes", GXutil.trim( GXutil.strNoRound( gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxmes, 5, 1)));
      if ( GXutil.strcmp(sNameSpace, "PayDay") != 0 )
      {
         oWriter.writeAttribute("xmlns", "PayDay");
      }
      oWriter.writeElement("PaiTipoHsMaxAnu", GXutil.trim( GXutil.strNoRound( gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxanu, 5, 1)));
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
      AddObjectProperty("PaiTipoHsDia", gxTv_SdtPaisTipoTrabajo_old_Paitipohsdia, false, false);
      AddObjectProperty("PaiTipoHsSem", gxTv_SdtPaisTipoTrabajo_old_Paitipohssem, false, false);
      AddObjectProperty("PaiTipoTarifaXLim", gxTv_SdtPaisTipoTrabajo_old_Paitipotarifaxlim, false, false);
      AddObjectProperty("PaiTipoTarifaRec", gxTv_SdtPaisTipoTrabajo_old_Paitipotarifarec, false, false);
      AddObjectProperty("PaiTipoHsMaxDia", gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxdia, false, false);
      AddObjectProperty("PaiTipoHsMaxSem", gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxsem, false, false);
      AddObjectProperty("PaiTipoHsMaxMes", gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxmes, false, false);
      AddObjectProperty("PaiTipoHsMaxAnu", gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxanu, false, false);
   }

   public java.math.BigDecimal getgxTv_SdtPaisTipoTrabajo_old_Paitipohsdia( )
   {
      return gxTv_SdtPaisTipoTrabajo_old_Paitipohsdia ;
   }

   public void setgxTv_SdtPaisTipoTrabajo_old_Paitipohsdia( java.math.BigDecimal value )
   {
      gxTv_SdtPaisTipoTrabajo_old_N = (byte)(0) ;
      gxTv_SdtPaisTipoTrabajo_old_Paitipohsdia = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPaisTipoTrabajo_old_Paitipohssem( )
   {
      return gxTv_SdtPaisTipoTrabajo_old_Paitipohssem ;
   }

   public void setgxTv_SdtPaisTipoTrabajo_old_Paitipohssem( java.math.BigDecimal value )
   {
      gxTv_SdtPaisTipoTrabajo_old_N = (byte)(0) ;
      gxTv_SdtPaisTipoTrabajo_old_Paitipohssem = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPaisTipoTrabajo_old_Paitipotarifaxlim( )
   {
      return gxTv_SdtPaisTipoTrabajo_old_Paitipotarifaxlim ;
   }

   public void setgxTv_SdtPaisTipoTrabajo_old_Paitipotarifaxlim( java.math.BigDecimal value )
   {
      gxTv_SdtPaisTipoTrabajo_old_N = (byte)(0) ;
      gxTv_SdtPaisTipoTrabajo_old_Paitipotarifaxlim = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPaisTipoTrabajo_old_Paitipotarifarec( )
   {
      return gxTv_SdtPaisTipoTrabajo_old_Paitipotarifarec ;
   }

   public void setgxTv_SdtPaisTipoTrabajo_old_Paitipotarifarec( java.math.BigDecimal value )
   {
      gxTv_SdtPaisTipoTrabajo_old_N = (byte)(0) ;
      gxTv_SdtPaisTipoTrabajo_old_Paitipotarifarec = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxdia( )
   {
      return gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxdia ;
   }

   public void setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxdia( java.math.BigDecimal value )
   {
      gxTv_SdtPaisTipoTrabajo_old_N = (byte)(0) ;
      gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxdia = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxsem( )
   {
      return gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxsem ;
   }

   public void setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxsem( java.math.BigDecimal value )
   {
      gxTv_SdtPaisTipoTrabajo_old_N = (byte)(0) ;
      gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxsem = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxmes( )
   {
      return gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxmes ;
   }

   public void setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxmes( java.math.BigDecimal value )
   {
      gxTv_SdtPaisTipoTrabajo_old_N = (byte)(0) ;
      gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxmes = value ;
   }

   public java.math.BigDecimal getgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxanu( )
   {
      return gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxanu ;
   }

   public void setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxanu( java.math.BigDecimal value )
   {
      gxTv_SdtPaisTipoTrabajo_old_N = (byte)(0) ;
      gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxanu = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtPaisTipoTrabajo_old_Paitipohsdia = DecimalUtil.ZERO ;
      gxTv_SdtPaisTipoTrabajo_old_N = (byte)(1) ;
      gxTv_SdtPaisTipoTrabajo_old_Paitipohssem = DecimalUtil.ZERO ;
      gxTv_SdtPaisTipoTrabajo_old_Paitipotarifaxlim = DecimalUtil.ZERO ;
      gxTv_SdtPaisTipoTrabajo_old_Paitipotarifarec = DecimalUtil.ZERO ;
      gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxdia = DecimalUtil.ZERO ;
      gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxsem = DecimalUtil.ZERO ;
      gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxmes = DecimalUtil.ZERO ;
      gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxanu = DecimalUtil.ZERO ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtPaisTipoTrabajo_old_N ;
   }

   public web.SdtPaisTipoTrabajo_old Clone( )
   {
      return (web.SdtPaisTipoTrabajo_old)(clone()) ;
   }

   public void setStruct( web.StructSdtPaisTipoTrabajo_old struct )
   {
      setgxTv_SdtPaisTipoTrabajo_old_Paitipohsdia(struct.getPaitipohsdia());
      setgxTv_SdtPaisTipoTrabajo_old_Paitipohssem(struct.getPaitipohssem());
      setgxTv_SdtPaisTipoTrabajo_old_Paitipotarifaxlim(struct.getPaitipotarifaxlim());
      setgxTv_SdtPaisTipoTrabajo_old_Paitipotarifarec(struct.getPaitipotarifarec());
      setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxdia(struct.getPaitipohsmaxdia());
      setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxsem(struct.getPaitipohsmaxsem());
      setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxmes(struct.getPaitipohsmaxmes());
      setgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxanu(struct.getPaitipohsmaxanu());
   }

   @SuppressWarnings("unchecked")
   public web.StructSdtPaisTipoTrabajo_old getStruct( )
   {
      web.StructSdtPaisTipoTrabajo_old struct = new web.StructSdtPaisTipoTrabajo_old ();
      struct.setPaitipohsdia(getgxTv_SdtPaisTipoTrabajo_old_Paitipohsdia());
      struct.setPaitipohssem(getgxTv_SdtPaisTipoTrabajo_old_Paitipohssem());
      struct.setPaitipotarifaxlim(getgxTv_SdtPaisTipoTrabajo_old_Paitipotarifaxlim());
      struct.setPaitipotarifarec(getgxTv_SdtPaisTipoTrabajo_old_Paitipotarifarec());
      struct.setPaitipohsmaxdia(getgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxdia());
      struct.setPaitipohsmaxsem(getgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxsem());
      struct.setPaitipohsmaxmes(getgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxmes());
      struct.setPaitipohsmaxanu(getgxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxanu());
      return struct ;
   }

   protected byte gxTv_SdtPaisTipoTrabajo_old_N ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected java.math.BigDecimal gxTv_SdtPaisTipoTrabajo_old_Paitipohsdia ;
   protected java.math.BigDecimal gxTv_SdtPaisTipoTrabajo_old_Paitipohssem ;
   protected java.math.BigDecimal gxTv_SdtPaisTipoTrabajo_old_Paitipotarifaxlim ;
   protected java.math.BigDecimal gxTv_SdtPaisTipoTrabajo_old_Paitipotarifarec ;
   protected java.math.BigDecimal gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxdia ;
   protected java.math.BigDecimal gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxsem ;
   protected java.math.BigDecimal gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxmes ;
   protected java.math.BigDecimal gxTv_SdtPaisTipoTrabajo_old_Paitipohsmaxanu ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
}

